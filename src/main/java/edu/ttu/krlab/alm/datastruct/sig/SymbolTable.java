package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;

public class SymbolTable {

    /*
     * STATIC VARIABLES
     */
    //This symbol table is the one that holds the function and sort definitions for an empty system description.
    private static boolean bootstrap = false;
    private static SymbolTable baseST = null;

    private static SortEntry universe = null;
    private static SortEntry actions = null;
    private static SortEntry nodes = null;
    private static SortEntry booleans = null;
    private static SortEntry integers = null;
    private static SortEntry timestep = null;
    private static int maxStep = -1;

    final private static Set<SortEntry> predefined = new HashSet<>();
    final private static Set<String> modes = new HashSet<>();
    final private static Map<String, Set<ConstantEntry>> staticCEMap = new HashMap<>();
    final private static Map<String, SortEntry> singletons = new HashMap<>();
    final private static Map<ALMTerm, ConstantEntry> CDMap = new HashMap<>();

    /*
     * STATIC FUNCTIONS
     */
    /**
     * Creates the time step instances i where 0 <= i < {@code upper_boud}
     *
     * @param upper_bound The number of time steps.
     */
    public void setMaxSteps(int upper_bound) {
        timestep.instances.clear();
        for (int i = 0; i < upper_bound; i++) {
            timestep.instances.add(new ALMTerm(Integer.toString(i), ALMTerm.INT));
        }
        maxStep = upper_bound - 1;
    }
    
    public int getMaxSteps(){
        return maxStep;
    }

    public boolean isTimeStep(int i) {
        return i <= maxStep && i >= 0;
    }

    public boolean isModeActive(String mode) {
        return modes.contains(mode);
    }

    public void setModeActive(String mode, boolean setting) {
        if (setting) {
            modes.add(mode);
        } else {
            modes.remove(mode);
        }
    }

    public SortEntry getUniverseSortEntry() {

        return universe;
    }

    public SortEntry getTimestepSortEntry() {

        return timestep;
    }

    public  SortEntry getActionsSortEntry() {
        return actions;
    }

    public  SortEntry getNodesSpecialSortEntry() {
        return nodes;
    }

    public  SortEntry getBooleansSortEntry() {
        return booleans;
    }

    public SortEntry getIntegersSortEntry() {
        return integers;
    }

    /*
     * NON-STATIC VARIABLES
     */
    final private String STName;
    final private Set<SymbolTable> dependencies = new HashSet<>();
    final private Map<String, SortEntry> SEMap = new HashMap<>();
    /**
     * Constant entries are first retrievable by name and then by their argument
     * signature.
     */
    final private HashMap<String, Set<ConstantEntry>> CEMap = new HashMap<>();
    /**
     * FunctionEntrys may have the same name but the combination of name and
     * signature must be unique. Looking up by name should return a set of
     * compatible functions To look up by signature as well, first lookup by
     * name then look for the function in the set with the matching signature.
     */
    final private Map<String, Set<NormalFunctionEntry>> FEMap = new HashMap<>();
    final private Map<NormalFunctionEntry, DOMFunctionEntry> DMap = new HashMap<>();

    /**
     * creates a new symbol table with an initial direct dependency on the base
     * symbol table.
     */
    public SymbolTable(String STName) {
        this.STName = STName;
        if (bootstrap) {
            try {
                initialize();
            } catch (DuplicateFunctionException | DuplicateSortException e) {
                e.printStackTrace();
                ALMCompiler.IMPLEMENTATION_FAILURE("Initializing Symbol Table",
                        "Initialize Function Threw An Exception");
                // this should never happen.
            }
        } else if (baseST == null) {
            bootstrap = true;
            baseST = new SymbolTable("base symbol table");
            bootstrap = false;
        } else {
            dependencies.add(baseST);
        }
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

    public boolean isPredefinedSort(String sort_text) {

        if (sort_text.compareTo(ALM.SORT_BOOLEANS) == 0) {
            return true;
        }

        if (sort_text.compareTo(ALM.SORT_INTEGERS) == 0) {
            return true;
        }

        ALMTerm IntegerRange = ALM.ParseIntegerRangeFromString(sort_text);
        if (IntegerRange != null) {
            return true;
        }

        return false;
    }

    /**
     * Returns the sort entries in this symbol table and in all dependencies.
     *
     * @return all SortEntries reachable from this Symbol Table.
     */
    public Set<SortEntry> getSortEntries() {
        Set<SortEntry> result = new HashSet<>();
        for (SymbolTable dependency : dependencies) {
            result.addAll(dependency.getSortEntries());
        }
        result.addAll(this.SEMap.values());
        return result;
    }

    /**
     * Creates a new SortEntry of the given sortname in this symbol table if the
     * name of the sort does not exist in this symbol table or any dependent
     * symbol tables.
     *
     * @param sortname The name of the sort to create a SortEntry for.
     * @param loc The parsed text location for the sort.
     * @return the new SortEntry
     * @throws DuplicateSortException if a SortEntry for the given sortname
     * exists already.
     */
    public SortEntry createSortEntry(String sortname, Location loc) throws DuplicateSortException {
        // Sort Entries must be uniquely named.
        SortEntry existing;
        try {
            existing = getSortEntry(sortname);
            throw new DuplicateSortException(existing);
        } catch (SortNotFoundException e) {
            // Add new Sort Entry at this level.  
            SortEntry srt = new SortEntry(sortname, loc);
            SEMap.put(sortname, srt);
            nodes.addSortInstance(new ALMTerm(srt.getSortName(), ALMTerm.ID));
            return srt;
        }
    }

    /**
     * Retrieves any existing SortEntry for the given sortname that exists in
     * this symbol table or in any of its dependencies.
     *
     * @param sortname The name of the sort
     * @return The SortEntry for the given sort name.
     * @throws SortNotFoundException if no matching SortEntry could be found.
     */
    public SortEntry getSortEntry(String sortname) throws SortNotFoundException {
        SortEntry sortEntry = getSortEntryHelp(sortname);
        if (sortEntry != null) {
            return sortEntry;
        }
        //no sort entry could be found in this symbol table or in any of the dependencies. 
        throw new SortNotFoundException(sortname);
    }

    private SortEntry getSortEntryHelp(String sortname) {
        SortEntry se = SEMap.get(sortname);
        if (se != null) {
            return se;
        }
        for (SymbolTable dependency : dependencies) {
            se = dependency.getSortEntryHelp(sortname);
            if (se != null) {
                return se;
            }
        }
        return null;
    }

    /**
     * Retrieves an existing singleton sort entry if it exists or creates a new
     * one to hold the constant entry as its only instance. The singleton sort
     * entry is marked as a singleton and registered with the constant for later
     * retrieval.
     *
     * @param ce The {@link ConstantEntry ConstantEntry} for which its singleton
     * sort is to be retrieved.
     *
     * @return The {@link SortEntry SortEntry} that is the singleton sort of the
     * constant entry.
     */
    private SortEntry getSingletonSortForConstantEntry(ConstantEntry ce) {
        //The naming convention of the singleton sort should not be easily produced by a user of the ALM system. 
        //Pattern:  singleton_constName_SortArg1Name_SortArt2Neam_...___  <- three trailing underscores. 
        //This pattern will be used to easily identify and remove singleton sorts from the premodel sparc program. 
        String singletonName = "singleton_" + ce.getConstName();
        for (SortEntry sort : ce.getSourceSorts()) {
            singletonName += "_" + sort.getSortName();
        }
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

    public NormalFunctionEntry createFunctionEntry(String funname, List<SortEntry> signature, Location loc)
            throws DuplicateFunctionException {
        // Check conditions for whether or not its safe to declare the functions
        // Specifically the function to be created does not have the same function name
        // and signature.
        FunctionEntry existing = getFunctionEntry(funname, signature);
        if (existing != null) {
            throw new DuplicateFunctionException(existing);
        }

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

    public Set<FunctionEntry> getFluentFunctions() {
        Set<FunctionEntry> fluentFunctions = new HashSet<>();
        for (Set<NormalFunctionEntry> sameNameFunctions : FEMap.values()) {
            for (FunctionEntry f : sameNameFunctions) {
                if (f.isFluent()) {
                    fluentFunctions.add(f);
                }
            }
        }
        return fluentFunctions;
    }

    /**
     * Returns all functions with the matching function name from this symbol
     * table and its dependecies.
     *
     * @param funname The name of the function to match;
     * @return The set of all function entries with the same name.
     */
    private Set<NormalFunctionEntry> getFunctionEntriesHelp(String funname) {
        Set<NormalFunctionEntry> matching = new HashSet<>();
        for (SymbolTable dependency : dependencies) {
            matching.addAll(dependency.getFunctionEntriesHelp(funname));
        }
        Set<NormalFunctionEntry> matches = FEMap.get(funname);
        if (matches != null) {
            matching.addAll(FEMap.get(funname));
        }
        return matching;
    }

    public Set<FunctionEntry> getFunctionEntries(String fname) {
        String baseName = fname;
        if (fname.startsWith(ALM.DOM_PREFIX)) {
            baseName = fname.substring(ALM.DOM_PREFIX.length());
        }
        Set<NormalFunctionEntry> funs = getFunctionEntriesHelp(fname);
        if (fname == baseName) {
            return new HashSet<>(funs);
        } else {
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
        Set<NormalFunctionEntry> nFuns = getFunctionEntriesHelp(baseName);
        Set<FunctionEntry> funs = new HashSet<>();
        if (nFuns == null || nFuns.size() == 0) {
            return funs;
        }
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

    /**
     * Returns all visible normal functions from this symbol table and all
     * dependencies.
     *
     * @return Set of NormalFunctionEntries reachable from this SymbolTable.
     */
    public Set<NormalFunctionEntry> getFunctions() {
        Set<NormalFunctionEntry> result = new HashSet<>();
        for (SymbolTable dependency : dependencies) {
            result.addAll(dependency.getFunctions());
        }
        for (String fname : FEMap.keySet()) {
            result.addAll(getFunctionEntriesHelp(fname));
        }
        return result;
    }

    /**
     * Returns the function matching the same name and the same argument
     * signature
     *
     * @param funname The name of the function
     * @param signature The signature of the function.
     * @return the FunctionEntry matching the name and signature.
     */
    private FunctionEntry getFunctionEntry(String funname, List<SortEntry> signature) {
        Set<NormalFunctionEntry> FSet = getFunctionEntriesHelp(funname);
        if (FSet == null || FSet.size() == 0) {
            return null;
        }
        for (FunctionEntry fe : FSet) {
            if (fe.sigMatch(signature)) {
                return fe;
            }
        }
        return null;
    }

    public FunctionEntry getFunctionEntry(String funname, int domSize) {
        Set<FunctionEntry> matching = getFunctionEntries(funname, domSize);
        if (matching.size() < 1) {
            return null;
        } else if (matching.size() > 1) {
            return null;
        }
        return matching.iterator().next();

    }

    public Set<DOMFunctionEntry> getDOMFunctions() {
        Set<DOMFunctionEntry> result = new HashSet<>();
        for (SymbolTable dependency : dependencies) {
            result.addAll(dependency.getDOMFunctions());
        }
        result.addAll(DMap.values());
        return result;
    }

    public DOMFunctionEntry getDOMFunction(FunctionEntry f) {
        DOMFunctionEntry df = DMap.get(f);
        if (df != null) {
            return df;
        }
        for (SymbolTable dependency : dependencies) {
            df = dependency.getDOMFunction(f);
            if (df != null) {
                return df;
            }
        }
        return null;
    }

    public void writeTo(BufferedWriter out) throws IOException {
        if (out == null) {
            return;
        }
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

    /**
     * Returns the constant entry with the matching constant name and argument
     * signature. This function examines this symbol table and all dependencies
     * for matching instances.
     *
     * @param constname The name of the constant
     * @param arguments The list of arguments. may be null or empty list to
     * indicate the constants has no arguments.
     * @return The matching ConstantEntry if it exists, otherwise null.
     */
    public ConstantEntry getConstantEntry(String constname, List<SortEntry> arguments) {

        Set<ConstantEntry> matching = CEMap.get(constname);
        if (matching == null) {
            return null;
        }
        for (ConstantEntry constEntry : matching) {
            if (constEntry.getArguments().equals(arguments)) {
                return constEntry;
            }
        }
        //iterate through dependencies until a match is found.
        for (SymbolTable dependency : dependencies) {
            ConstantEntry ce = dependency.getConstantEntry(constname, arguments);
            if (ce != null) {
                return ce;
            }
        }
        //no match found
        return null;
    }

    /**
     * Creates a new constant entry for the given {@code constname(arguments)}
     * and registers the constant as belonging to the sort entries in the list
     * of sourceSorts.
     *
     * @param constname the String name of the constant
     * @param arguments the sorts that specify the schema for instantiating the
     * constant.
     * @param parent_sorts The sort entries that will have the constant as a
     * member of their sort.
     * @param loc The syntactic element relating to the declaration of the
     * constants.
     * @return the ConstantEntry created in the symbol table.
     * @throws DuplicateConstantException if the exact constant has already been
     * declared for one of the parent_sorts.
     */
    public ConstantEntry createConstantEntry(String constname, List<SortEntry> arguments, List<SortEntry> parent_sorts,
            Location loc) throws DuplicateConstantException {

        ConstantEntry constEntry = null;
        // first retrieve any existing matching ConstantEntry.
        Set<ConstantEntry> constSet = CEMap.get(constname);
        if (constSet == null || constSet.size() == 0) {
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
        //we do not want to duplicate any existing compatible ConstantEntry created by other symbol tables. 
        if (constEntry == null) {
            //check global constent entry table
            Set<ConstantEntry> otherSTEntries = staticCEMap.get(constname);
            if (otherSTEntries != null) {
                for (ConstantEntry c : otherSTEntries) {
                    if (c.getArguments().equals(arguments)) {
                        constEntry = c;
                        break;
                    }
                }
            }
            if (constEntry == null) {
                constEntry = new ConstantEntry(constname, arguments, parent_sorts, loc);
                Set<ConstantEntry> globalSet = staticCEMap.get(constname);
                if (globalSet == null) {
                    globalSet = new HashSet<>();
                    staticCEMap.put(constname, globalSet);
                }
                globalSet.add(constEntry);
            }
            constSet.add(constEntry);
        }
        // By this point we have a matching constant entry from the set of constant
        // entries with the same name.

        //get or create the singleton sort created specifically to house the constant
        SortEntry singleton = getSingletonSortForConstantEntry(constEntry);

        //add the singleton sort as sub-sorts to the source-sorts of the constant entry.  
        //collect any duplicate declarations for an exception. 
        Set<SortEntry> duplicates = new HashSet<>();
        for (SortEntry sort : parent_sorts) {
            if (sort.childSorts.contains(singleton)) {
                duplicates.add(sort);
            } else {
                sort.childSorts.add(singleton);
                singleton.parentSorts.add(sort);
            }
        }

        if (duplicates.size() > 0) {
            throw new DuplicateConstantException(constEntry, duplicates);
        }
        return constEntry;
    }

    /**
     * Finds a matching constant entry of the same name. returns null if no such
     * constant entry can be found.
     *
     * @param constTerm The ALMTerm whose matching constant entry we are
     * seeking.
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
        Set<ConstantEntry> constSet = getConstantEntries(constName);

        if (constSet != null && constSet.size() > 0) {
            if (argSize > 0) {
                Set<ConstantEntry> matching = new HashSet<>();
                for (ConstantEntry ce : constSet) {
                    if (ce.getArguments().size() == argSize) {
                        matching.add(ce);
                    }
                }
                return matching;
            } else {
                return constSet;
            }
        }
        return null;
    }

    public Set<ConstantEntry> getConstantEntries(String name) {
        Set<ConstantEntry> result = new HashSet<>();
        for (SymbolTable dependency : dependencies) {
            result.addAll(dependency.getConstantEntries(name));
        }
        Set<ConstantEntry> constants = CEMap.get(name);
        if (constants != null) {
            result.addAll(constants);
        }
        return result;
    }

    public Set<ConstantEntry> getConstantEntries(String name, int argSize) {
        Set<ConstantEntry> constants = getConstantEntries(name);
        if (constants == null) {
            return Collections.emptySet();
        }
        Set<ConstantEntry> matches = new HashSet<>();
        for (ConstantEntry c : constants) {
            if (c.getArguments().size() == argSize) {
                matches.add(c);
            }
        }
        return matches;
    }

    public ConstantEntry getMatchingConstantEntry(ALMTerm obj_const) {
        if (!obj_const.isGround()) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Find ConstantEntry",
                    "Retrieval of ConstantEntry for non-ground constants is not supported in this version of ALM.");
        }
        Set<ConstantEntry> matching = getConstantEntries(obj_const.getName(), obj_const.getArgs().size());
        if (matching.size() > 1) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Find ConstantEntry",
                    "ConstantEntry overloading is not supported in this version of ALM.");
        }
        if (matching.size() == 0) {
            return null;
        }
        return matching.iterator().next();
    }

    /**
     * Caller must ensure that obj_const actually resolves to a constant entry.
     *
     * @param obj_const
     * @param objConstVal
     */
    public void defineConstant(ALMTerm obj_const, ALMTerm objConstVal) {
        ConstantEntry ce = getMatchingConstantEntry(obj_const);
        ce.setConstantDefinition(obj_const, objConstVal);
        CDMap.put(obj_const, ce);
    }

    public ALMTerm getConstantDefinition(ALMTerm obj_const) {
        if (!obj_const.isGround()) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Get Constant Definition",
                    "Retrieval of Constant Definition for non-ground constants is not supported in this version of ALM.");
        }
        ConstantEntry ce = CDMap.get(obj_const);
        if (ce == null) {
            return null;
        }
        return ce.getConstantDefinition(obj_const);
    }

    public Map<ALMTerm, ConstantEntry> getDefinedConstants() {
        return CDMap;
    }

    public void addDependency(SymbolTable dST) {
        dependencies.add(dST);
    }

    public void flatten() {
        for (SymbolTable dependency : dependencies) {
            dependency.flatten();
            this.SEMap.putAll(dependency.SEMap);
            this.CEMap.putAll(dependency.CEMap);
            this.FEMap.putAll(dependency.FEMap);
            this.DMap.putAll(dependency.DMap);
        }
        dependencies.clear();
    }

    @Override
    public String toString() {
        return STName;
    }

    public void addIntegerOccurrence(int parseInt) {
        // TODO Auto-generated method stub

    }

}
