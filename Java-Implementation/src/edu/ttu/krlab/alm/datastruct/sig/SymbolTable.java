package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;

public class SymbolTable {

    SortEntry universe;
    SortEntry actions;
    SortEntry nodes;
    SortEntry booleans;
    SortEntry integers;

    SortEntry timestep;
    int maxStep = -1;

    private Set<String> modes;
    private HashSet<SortEntry> predefined;
    private HashMap<String, SortEntry> SEMap;
    private HashMap<String, SortEntry> singletons;

    /**
     * Constant entries are first retrievable by name and then by their argument signature.
     */
    private HashMap<String, Set<ConstantEntry>> CEMap;

    /**
     * FunctionEntrys may have the same name but the combination of name and signature must be unique. Looking up by
     * name should return a set of compatible functions To look up by signature as well, first lookup by name then look
     * for the function in the set with the matching signature.
     */
    private HashMap<String, Set<NormalFunctionEntry>> FEMap;
    private HashMap<NormalFunctionEntry, DOMFunctionEntry> DMap;

    public SymbolTable() {
        modes = new HashSet<>();
        SEMap = new HashMap<>();
        CEMap = new HashMap<>();
        FEMap = new HashMap<>();
        DMap = new HashMap<>();
        singletons = new HashMap<>();
        try {
            initialize();
        } catch (DuplicateFunctionException | DuplicateSortException e) {
            e.printStackTrace();
            ALMCompiler.IMPLEMENTATION_FAILURE("Initializing Symbol Table", "Initialize Function Threw An Exception");
            // this should never happen.
        }
    }

    public SortEntry createSortEntry(String sortname, Location loc) throws DuplicateSortException {
        // Sort Entries must be uniquely named.
        SortEntry existing;
        try {
            existing = getSortEntry(sortname);
            throw new DuplicateSortException(existing);
        } catch (SortNotFoundException e) {
            // Add new Sort Entry
            SortEntry srt = new SortEntry(sortname, loc);
            SEMap.put(sortname, srt);
            nodes.addSortInstance(new ALMTerm(srt.getSortName(), ALMTerm.ID));
            return srt;
        }
    }

    public SortEntry getSortEntry(String sortname) throws SortNotFoundException {
        SortEntry se = SEMap.get(sortname);
        if (se == null)
            throw new SortNotFoundException(sortname);
        return se;
    }

    /**
     * Creates a new constant entry for the given {@code constname(arguments)} and registers the constant as belonging
     * to the sort entries in the list of sourceSorts.
     * 
     * @param constname
     *            the String name of the constant
     * @param arguments
     *            the sorts that specify the schema for instantiating the constant.
     * @param parent_sorts
     *            The sort entries that will have the constant as a member of their sort.
     * @param loc
     *            The syntactic element relating to the declaration of the constants.
     * @return the ConstantEntry created in the symbol table.
     * @throws DuplicateConstantException
     *             if the exact constant has already been declared for one of the parent_sorts.
     */
    public ConstantEntry createConstantEntry(String constname, List<SortEntry> arguments, List<SortEntry> parent_sorts,
            Location loc) throws DuplicateConstantException {

        ConstantEntry constEntry = null;
        // first retrieve any existing matching ConstantEntry.
        Set<ConstantEntry> constSet = CEMap.get(constname);
        if (constSet == null) {
            constSet = new HashSet<>();
            CEMap.put(constname, constSet);
        } else {
            for (ConstantEntry c : constSet) {
                if (c.getArguments().equals(arguments)) {
                    constEntry = c;
                    break;
                }
            }
        }
        if (constEntry == null) {
            constEntry = new ConstantEntry(constname, arguments, parent_sorts, loc);
            constSet.add(constEntry);
        }
        // By this point we have a matching constant entry from the set of constant
        // entries with the same name.

        //get or create the singleton sort created specifically to house the constant
        SortEntry singleton = getSingletonSortForConstantEntry(constEntry);

        //add the singleton sort as sub-sorts to the source-sorts of the constant entry.  
        //collect any duplicate declarations for an exception. 

        Set<SortEntry> duplicates = null;
        for (SortEntry sort : parent_sorts) {
            if (sort.childSorts.contains(singleton)) {
                if (duplicates == null) {
                    duplicates = new HashSet<>();
                }
                duplicates.add(sort);
            } else {
                sort.childSorts.add(singleton);
                singleton.parentSorts.add(sort);
            }
        }

        if (duplicates != null) {
            throw new DuplicateConstantException(constEntry, duplicates);
        }
        return constEntry;
    }

    /**
     * Retrieves an existing singleton sort entry if it exists or creates a new one to hold the constant entry as its
     * only instance. The singleton sort entry is marked as a singleton and registered with the constant for later
     * retrieval.
     * 
     * @param ce
     *            The {@link ConstantEntry ConstantEntry} for which its singleton sort is to be retrieved.
     * 
     * @return The {@link SortEntry SortEntry} that is the singleton sort of the constant entry.
     */
    private SortEntry getSingletonSortForConstantEntry(ConstantEntry ce) {
        //The naming convention of the singleton sort should not be easily produced by a user of the ALM system. 
        //Pattern:  singleton_constName_SortArg1Name_SortArt2Neam_...___  <- three trailing underscores. 
        //This pattern will be used to easily identify and remove singleton sorts from the premodel sparc program. 
        String singletonName = "singleton_" + ce.getConstName();
        for (SortEntry sort : ce.getSourceSorts())
            singletonName += "_" + sort.getSortName();
        singletonName += "___";

        //lookup for an existing singleton matching this pattern. 
        SortEntry singleton = singletons.get(singletonName);
        if (singleton == null) {
            //creating the sort entry will add the singleton as a formal node in the hierarchy
            //this will need to be purged after the premodel is computed.  
            boolean success = false;
            while (!success) {
                try {
                    singleton = createSortEntry(singletonName, null);
                    success = true;
                } catch (DuplicateSortException e) {
                    singletonName += "_"; //extend the name until a unique name is found.  
                }
            }
            singleton.setSingletonConstant(ce);
            ce.setSingletonSort(singleton);
            singletons.put(singletonName, singleton);
        }
        return singleton;
    }

    /**
     * Returns the constant entry with the matching constant name and argument signature.
     * 
     * @param constname
     *            The name of the constant
     * @param arguments
     *            The list of arguments. may be null or empty list to indicate the constants has no arguments.
     * @return The matching ConstantEntry if it exists, otherwise null.
     */
    public ConstantEntry getConstantEntry(String constname, List<SortEntry> arguments) {

        Set<ConstantEntry> matching = CEMap.get(constname);
        if (matching == null)
            return null;
        for (ConstantEntry constEntry : matching) {
            if (constEntry.getArguments().equals(arguments)) {
                return constEntry;
            }
        }
        return null;
    }

    public NormalFunctionEntry createFunctionEntry(String funname, List<SortEntry> signature, Location loc)
            throws DuplicateFunctionException {
        // Check conditions for whether or not its safe to declare the functions
        // Specifically the function to be created does not have the same function name
        // and signature.
        FunctionEntry existing = getFunctionEntry(funname, signature);
        if (existing != null)
            throw new DuplicateFunctionException(existing);

        // safe to create new function entry, add it to the set in the map.
        Set<NormalFunctionEntry> set = FEMap.get(funname);
        if (set == null) {
            set = new HashSet<NormalFunctionEntry>();
            FEMap.put(funname, set);
        }
        NormalFunctionEntry newFun = new NormalFunctionEntry(funname, signature, loc);
        set.add(newFun);

        // Set DOMFunctionEntry for NormalFunction.
        DMap.put(newFun, new DOMFunctionEntry(newFun, booleans));
        return newFun;
    }

    private Set<NormalFunctionEntry> getFunctionEntry(String funname) {
        return FEMap.get(funname);
    }

    private FunctionEntry getFunctionEntry(String funname, List<SortEntry> signature) {
        Set<NormalFunctionEntry> FS = FEMap.get(funname);
        if (FS == null)
            return null;
        Iterator<NormalFunctionEntry> it = FS.iterator();
        while (it.hasNext()) {
            FunctionEntry fe = it.next();
            if (fe.sigMatch(signature))
                return fe;
        }
        return null;
    }

    private void initialize() throws DuplicateFunctionException, DuplicateSortException {

        // Before the Hierarchy can be initialized, we need a special sort entry for
        // nodes in the hierarchy.
        nodes = new SortEntry(ALM.SPECIAL_SORT_NODES, null);
        SEMap.put(ALM.SPECIAL_SORT_NODES, nodes);

        // Add Universe Sort
        universe = this.createSortEntry(ALM.SORT_UNIVERSE, null);

        // Add timestep Sort
        timestep = this.createSortEntry(ALM.SORT_TIMESTEP, null);

        // Add Actions Sort (child of universe)
        actions = this.createSortEntry(ALM.SORT_ACTIONS, null);
        actions.addParentSort(universe);

        // Add Predefined Sorts
        predefined = new HashSet<SortEntry>();
        // boolean
        booleans = this.createSortEntry(ALM.SORT_BOOLEANS, null);
        predefined.add(booleans);

        // integer
        integers = this.createSortEntry(ALM.SORT_INTEGERS, null);
        predefined.add(integers);

        // Add special functions

        // SIGNATURES
        // universe x nodes -> booleans
        List<SortEntry> universe_nodes_booleans_sig = new ArrayList<SortEntry>();
        universe_nodes_booleans_sig.add(universe);
        universe_nodes_booleans_sig.add(nodes);
        universe_nodes_booleans_sig.add(booleans);

        // nodes x nodes -> booleans
        List<SortEntry> nodes_nodes_booleans_sig = new ArrayList<SortEntry>();
        nodes_nodes_booleans_sig.add(nodes);
        nodes_nodes_booleans_sig.add(nodes);
        nodes_nodes_booleans_sig.add(booleans);

        // nodes -> booleans
        List<SortEntry> nodes_booleans_sig = new ArrayList<SortEntry>();
        nodes_booleans_sig.add(nodes);
        nodes_booleans_sig.add(booleans);

        // actions -> booleans
        List<SortEntry> actions_booleans_sig = new ArrayList<SortEntry>();
        actions_booleans_sig.add(actions);
        actions_booleans_sig.add(booleans);

        // SPECIAL FUNCTIONS

        // is_a
        FunctionEntry is_a = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_IS_A, universe_nodes_booleans_sig, null);
        is_a.setSpecial();
        is_a.setStatic();
        is_a.setTotal();
        is_a.setDefined();

        // instance
        FunctionEntry instance = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_INSTANCE, universe_nodes_booleans_sig,
                null);
        instance.setSpecial();
        instance.setStatic();
        instance.setTotal();
        instance.setDefined();

        // link
        FunctionEntry link = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_LINK, nodes_nodes_booleans_sig, null);
        link.setSpecial();
        link.setStatic();
        link.setTotal();
        link.setDefined();

        // subsort
        FunctionEntry subsort = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_SUBSORT, nodes_nodes_booleans_sig, null);
        subsort.setSpecial();
        subsort.setStatic();
        subsort.setTotal();
        subsort.setDefined();

        // has_child
        FunctionEntry has_child = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_HAS_CHILD, nodes_booleans_sig, null);
        has_child.setSpecial();
        has_child.setStatic();
        has_child.setTotal();
        has_child.setDefined();

        // has_parent
        FunctionEntry has_parent = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_HAS_PARENT, nodes_booleans_sig, null);
        has_parent.setSpecial();
        has_parent.setStatic();
        has_parent.setTotal();
        has_parent.setDefined();

        // sink
        FunctionEntry sink = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_SINK, nodes_booleans_sig, null);
        sink.setSpecial();
        sink.setStatic();
        sink.setTotal();
        sink.setDefined();

        // source
        FunctionEntry source = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_SOURCE, nodes_booleans_sig, null);
        source.setSpecial();
        source.setStatic();
        source.setTotal();
        source.setDefined();

        // occurs
        FunctionEntry occurs = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_OCCURS, actions_booleans_sig, null);
        occurs.setSpecial();
        occurs.setFluent();
        occurs.setTotal();
        occurs.setDefined();

    }

    public void writeTo(BufferedWriter out) throws IOException {
        if (out == null)
            return;
        out.write("------------------\n");
        out.write("-- SYMBOL TABLE --\n");
        out.write("------------------\n\n");

        out.write("-------------------\n");
        out.write("-- Sort Hierachy --\n");
        out.write("-------------------\n\n");

        Set<SortEntry> printed = new HashSet<SortEntry>();

        Iterator<String> itS = SEMap.keySet().iterator();
        while (itS.hasNext()) {
            SortEntry se = SEMap.get(itS.next());
            se.writeTo(out, printed);
        }
        out.write("\n");
        out.flush();

        out.write("---------------------------\n");
        out.write("-- Constant Declarations --\n");
        out.write("---------------------------\n\n");

        for (Set<ConstantEntry> constSet : CEMap.values()) {
            for (ConstantEntry ce : constSet) {
                ce.writeTo(out);
                out.write("\n");
            }
        }
        out.flush();

        out.write("---------------------------\n");
        out.write("-- Function Declarations --\n");
        out.write("---------------------------\n\n");

        Iterator<String> itFS = FEMap.keySet().iterator();
        while (itFS.hasNext()) {
            Set<NormalFunctionEntry> sfe = FEMap.get(itFS.next());
            Iterator<NormalFunctionEntry> itF = sfe.iterator();
            while (itF.hasNext()) {
                FunctionEntry fe = itF.next();
                fe.writeTo(out);
                out.write("\n");
            }
        }

        out.flush();
    }

    public boolean isPredefinedSort(String sort_text) {

        if (sort_text.compareTo(ALM.SORT_BOOLEANS) == 0)
            return true;

        if (sort_text.compareTo(ALM.SORT_INTEGERS) == 0)
            return true;

        ALMTerm IntegerRange = ALM.ParseIntegerRangeFromString(sort_text);
        if (IntegerRange != null)
            return true;

        return false;
    }

    public List<FunctionEntry> getFunctions() {
        List<FunctionEntry> functions = new ArrayList<FunctionEntry>();
        for (String fname : FEMap.keySet())
            for (NormalFunctionEntry fun : FEMap.get(fname))
                functions.add(fun);
        return functions;
    }

    public Collection<SortEntry> getSortEntries() {
        return this.SEMap.values();
    }

    public SortEntry getUniverseSortEntry() {

        return universe;
    }

    public SortEntry getTimestepSortEntry() {

        return timestep;
    }

    public SortEntry getActionsSortEntry() {
        return actions;
    }

    public SortEntry getNodesSpecialSortEntry() {
        return nodes;
    }

    public SortEntry getBooleansSortEntry() {
        return booleans;
    }

    public Set<FunctionEntry> getFunctionEntries(String fname) {
        String baseName = fname;
        if (fname.startsWith(ALM.DOM_PREFIX)) {
            baseName = fname.substring(ALM.DOM_PREFIX.length());
        }
        Set<NormalFunctionEntry> funs = FEMap.get(baseName);
        if (fname == baseName)
            return new HashSet<>(funs);
        else {
            Set<FunctionEntry> doms = new HashSet<>();
            for (NormalFunctionEntry f : funs) {
                doms.add(DMap.get(f));
            }
            return doms;
        }
    }

    public Set<FunctionEntry> getFunctionEntries(String fname, int numArgs) {
        String baseName = fname;
        if (fname.startsWith(ALM.DOM_PREFIX)) {
            baseName = fname.substring(ALM.DOM_PREFIX.length());
        }
        Set<NormalFunctionEntry> nFuns = FEMap.get(baseName);
        Set<FunctionEntry> funs = new HashSet<>();
        if (nFuns == null || nFuns.size() == 0)
            return funs;
        for (NormalFunctionEntry f : nFuns) {
            if (f.getSignature().size() - 1 == numArgs) {
                if (fname == baseName) {
                    funs.add(f);
                } else {
                    funs.add(DMap.get(f));
                }
            }
        }
        return funs;
    }

    public SortEntry getIntegersSortEntry() {
        return integers;
    }

    public Set<DOMFunctionEntry> getDOMFunctions() {
        return new HashSet<>(DMap.values());
    }

    public DOMFunctionEntry getDOMFunction(FunctionEntry f) {
        return DMap.get(f);
    }

    /**
     * Creates the time step instances i where 0 <= i < {@code upper_boud}
     * 
     * @param upper_bound
     *            The number of time steps.
     */
    public void setMaxSteps(int upper_bound) {
        this.timestep.instances.clear();
        for (int i = 0; i < upper_bound; i++) {
            timestep.instances.add(new ALMTerm(Integer.toString(i), ALMTerm.INT));
        }
        maxStep = upper_bound - 1;
    }

    public boolean isTimeStep(int i) {
        return i <= maxStep && i >= 0;
    }

    public boolean modeActive(String mode) {
        return this.modes.contains(mode);
    }

    public void setMode(String mode, boolean setting) {
        if (setting) {
            this.modes.add(mode);
        } else {
            this.modes.remove(mode);
        }
    }

    public boolean isAction(ALMTerm action) {
        return true;
    }

    private boolean isInstance(SortEntry sort, ALMTerm instance) {
        List<ALMTerm> instances = sort.instances;
        if (instances != null) {
            for (ALMTerm i : instances) {
                if (i.toString().compareTo(instance.toString()) == 0) {
                    return true;
                }
            }
        }
        for (SortEntry child : sort.getChildSorts()) {
            if (isInstance(child, instance)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a matching constant entry of the same name. returns null if no such constant entry can be found.
     * 
     * @param constTerm
     *            The ALMTerm whose matching constant entry we are seeking.
     * @return the matching constant entry if it exists, otherwise null.
     */
    public Set<ConstantEntry> getMatchingConstantEntries(ALMTerm constTerm) {
        int argSize = 0;
        switch (constTerm.getType()) {
        case ALMTerm.ID:
            break;
        case ALMTerm.FUN:
            argSize = constTerm.getArgs().size();
            break;
        default:
            return null;
        }
        String constName = constTerm.getName();
        Set<ConstantEntry> constSet = CEMap.get(constName);
        if (constSet != null) {
            if (argSize > 0) {
                Set<ConstantEntry> matching = new HashSet<>();
                for (ConstantEntry ce : constSet) {
                    if (ce.getArguments().size() == argSize)
                        matching.add(ce);
                }
                return matching;
            } else
                return constSet;
        }
        return null;
    }

    public Set<ConstantEntry> getConstantEntries(String name) {
        return CEMap.get(name);
    }

    public Set<ConstantEntry> getConstantEntries(String name, int argSize) {
        Set<ConstantEntry> constants = CEMap.get(name);
        if (constants == null)
            return null;
        Set<ConstantEntry> matches = new HashSet<>();
        for (ConstantEntry c : constants) {
            if (c.getArguments().size() == argSize)
                matches.add(c);
        }
        return matches;
    }

    public FunctionEntry getFunctionEntry(ALMTerm funTerm, int domSize, SymbolTable st, ErrorReport er) {
        Set<FunctionEntry> matching = st.getFunctionEntries(funTerm.getName(), domSize);
        if (matching.size() < 0) {
            er.newSemanticError(SemanticError.FND003).add(funTerm);
            return null;
        } else if (matching.size() > 1) {
            Iterator<FunctionEntry> funs = matching.iterator();
            er.newSemanticError(SemanticError.FND009).add(funTerm).add(funs.next()).add(funs.next());
            return null;
        }
        return matching.iterator().next();
    }

    public ConstantEntry getConstantEntry(ALMTerm constTerm, int argSize, SymbolTable st, ErrorReport er) {
        Set<ConstantEntry> matching = st.getConstantEntries(constTerm.getName(), argSize);
        if (matching.size() < 0) {
            er.newSemanticError(SemanticError.CND008).add(constTerm);
            return null;
        } else if (matching.size() > 1) {
            Iterator<ConstantEntry> funs = matching.iterator();
            er.newSemanticError(SemanticError.CND007).add(constTerm).add(funs.next()).add(funs.next());
            return null;
        }
        return matching.iterator().next();
    }

    public Set<SortEntry> getSingletonSorts() {
        return new HashSet<>(singletons.values());
    }

    public void purgeSingletonSorts() {
        //remove from nodes
        for (SortEntry singleton : singletons.values()) {
            for (SortEntry parent : singleton.getParentSorts()) {
                parent.getChildSorts().remove(singleton);
            }
            nodes.removeSortInstanceWithName(singleton.getSortName());
        }
        singletons.clear();
    }
}
