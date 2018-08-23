package edu.ttu.krlab.alm.datastruct.type;

import edu.ttu.krlab.alm.ALMCompiler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.datastruct.sig.ConstantEntry;
import edu.ttu.krlab.alm.datastruct.sig.FunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.SortEntry;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import java.util.Iterator;

public class TypeChecker {

    private final Map<ConstantEntry, SortType> constTypes = new HashMap<>();
    private final Map<ConstantEntry, Set<ALMTerm>> constOccurrences = new HashMap<>();
    private final Map<String, Set<ALMTerm>> varOccurrences = new HashMap<>();
    private final Map<String, SortType> varTypes = new HashMap<>();

    private SymbolTable st;
    private ErrorReport er;
    private boolean typeChecked = false;
    private boolean passed = false;

    public TypeChecker(SymbolTable st, ErrorReport er) {
        this.st = st;
        this.er = er;
    }

    public boolean typeCheckPasses(ErrorReport er) {
        if (typeChecked) {
            return passed;
        }
        passed = true; // until proven otherwise.
        for (Map.Entry<String, SortType> entry : varTypes.entrySet()) {
            String var = entry.getKey();
            SortType sType = entry.getValue();
            if (sType == Type.EMPTY_TYPE) {
                passed = false;
                er.newSemanticError(SemanticError.TYP002).add(varOccurrences.get(var).iterator().next());
            } else if (sType == Type.ANY_TYPE) {
                // ANY_TYPE should produce error since all variables must have definite type.
                passed = false;
                er.newSemanticError(SemanticError.TYP001).add(varOccurrences.get(var).iterator().next());
            }
        }
        for (Map.Entry<ConstantEntry, SortType> entry : constTypes.entrySet()) {
            ConstantEntry cnst = entry.getKey();
            SortType cType = entry.getValue();
            if (cType == Type.EMPTY_TYPE) {
                passed = false;
                er.newSemanticError(SemanticError.TYP004).add(constOccurrences.get(cnst).iterator().next());
            }
        }
        typeChecked = true;
        return passed;
    }

    public String newVariable(String baseVar, SortType type) {
        Set<String> variables = varTypes.keySet();
        if (!variables.contains(baseVar)) {
            varTypes.put(baseVar, type);
            return baseVar;
        }
        int count = 1;
        String newVar = baseVar + count;
        while (variables.contains(newVar)) {
            newVar = baseVar + (count++);
        }
        varTypes.put(newVar, type);
        return newVar;
    }

    public SortType recordConstantExpectedType(ConstantEntry cnst, ALMTerm constTerm, SortType expected) {
        typeChecked = false;
        Set<ALMTerm> occurrences = constOccurrences.get(cnst);
        if (occurrences == null) {
            occurrences = new HashSet<>();
            constOccurrences.put(cnst, occurrences);
        }
        occurrences.add(constTerm);
        SortType constType = constTypes.get(cnst);
        if (constType == null) {
            constType = Type.getSortType(cnst.getSourceSorts());
        } else {
            constType = Type.intersect(constType, expected);
        }
        constTypes.put(cnst, constType);
        return constType;
    }

    public SortType recordUntypedVariable(ALMTerm varTerm) {
        typeChecked = false;
        String var = varTerm.getName();
        Set<ALMTerm> occurrences = varOccurrences.get(var);
        if (occurrences == null) {
            occurrences = new HashSet<>();
            varOccurrences.put(var, occurrences);
        }
        occurrences.add(varTerm);
        SortType varType = varTypes.get(var);
        if (varType == null) {
            varType = Type.ANY_TYPE;
            varTypes.put(var, varType);
        }
        return varType;
    }

    public SortType recordVariableExpectedType(ALMTerm varTerm, SortType expected) {
        typeChecked = false;
        String var = varTerm.getName();
        Set<ALMTerm> occurrences = varOccurrences.get(var);
        if (occurrences == null) {
            occurrences = new HashSet<>();
            varOccurrences.put(var, occurrences);
        }
        occurrences.add(varTerm);
        SortType varType = varTypes.get(var);
        if (varType == null) {
            varType = expected;
        } else {
            varType = Type.intersect(varType, expected);
        }
        varTypes.put(var, varType);
        return varType;
    }

    public SortType getNarrowestSortType(String var) {
        SortType varType = varTypes.get(var);
        if (varType == null) {
            return Type.ANY_TYPE;
        }
        return varType;
    }

    public SortType getNarrowestSortType(ConstantEntry cnst) {
        SortType constType = constTypes.get(cnst);
        if (constType == null) {
            constType = Type.getSortType(cnst.getSourceSorts());
            constTypes.put(cnst, constType);
        }
        return constType;
    }

    public SortType getNarrowestSortType(ALMTerm term) {

        //This usage is assumed to be for a constant reference that needs to be looked up in the symbol table. 
        String name = term.getName();
        int argSize = term.getArgs().size();
        Set<ConstantEntry> constants = st.getConstantEntries(name, argSize);
        int numMatch = constants.size();
        if (numMatch == 1) {
            return getNarrowestSortType(constants.iterator().next());
        } else if (numMatch > 1) {
            Iterator<ConstantEntry> it = constants.iterator();
            ConstantEntry first = it.next();
            ConstantEntry second = it.next();
            er.newSemanticError(SemanticError.CND007).add(term).add(first).add(second);
            SortType intersect = Type.intersect(getNarrowestSortType(first), getNarrowestSortType(second));
            while (it.hasNext()) {
                intersect = Type.intersect(intersect, getNarrowestSortType(it.next()));
            }
            return intersect;
        } else {
            //there are no matching constants.   This could be a no-argument function?.  
            Set<FunctionEntry> functions = st.getFunctionEntries(name);
            int numFunctions = functions.size();
            if (numFunctions == 1) {
                FunctionEntry f = functions.iterator().next();
                SortEntry range = f.getRangeSort();
                return Type.getSortType(range);
            } else {
                ALMCompiler.IMPLEMENTATION_FAILURE("Get Narrowest Sort Of Term", "Unexpected case for tern :" + term.toString());
            }
            return Type.EMPTY_TYPE;
        }
    }

}
