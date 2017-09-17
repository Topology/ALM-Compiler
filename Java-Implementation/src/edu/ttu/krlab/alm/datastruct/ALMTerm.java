package edu.ttu.krlab.alm.datastruct;

import static edu.ttu.krlab.alm.datastruct.type.Type.ANY_TYPE;
import static edu.ttu.krlab.alm.datastruct.type.Type.EMPTY_TYPE;

/**
 * This class is a massive kludge.  It's basically an in-memory hybrid object model 
 * to represents all objects in ALM and logic program.  Anything of the form: 
 * -? STRING_1 
 * -? STRING_1 ( STRING_2, ..., STRING_N) 
 * and recursively.  
 * The type attribute indicates which it is.
 * The "writeTo" function renders the ALMTerm in the appropriate flattened string form bysed on type
 * The sign can be set and is relevant if the type supports the sign 
 * This implements both the literal interfaces for ASPf and SPARC. 
 * This class is the nexus for changing stylistic rendering on output. 
 * This class is the target of using ALM.Parse* which handles many literal and terms as ParserRuleContexts
 * When constructing an ALMTerm you use this pattern: 
 * ALMTerm foo = new ALMTerm(<STRING_1>, ALMTERM.<TYPE>, <PARSER_RULE_CONTEXT>)
 * foo.addArg(<ALMTerm>);
 * foo.setSign(<BOOLEAN>); 
 * 
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfLiteral;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.datastruct.sig.ConstantEntry;
import edu.ttu.krlab.alm.datastruct.sig.FunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.SortEntry;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCLiteral;
import edu.ttu.krlab.alm.datastruct.type.SortType;
import edu.ttu.krlab.alm.datastruct.type.Type;
import edu.ttu.krlab.alm.datastruct.type.TypeChecker;

public class ALMTerm implements ASPfLiteral, SPARCLiteral {

    public static final String SIGN_NEG = "-";
    public static final String SIGN_POS = "";
    public static final String SIGN_NOT = "not ";
    public static final String SIGN_NOT_NEG = "not -";
    public static final String ID = "ID";
    public static final String VAR = "VAR";
    public static final String INT = "INTEGER";
    public static final String FUN = "FUN";
    public static final String BOOL = "BOOLEAN";
    public static final String MATH_NEG = "-";
    public static final String MATH_ADD = "ADD";
    public static final String MATH_SUB = "SUBTRACT";
    public static final String MATH_MULT = "MULTIPLY";
    public static final String MATH_DIV = "DIVIDE";
    public static final String MATH_MOD = "MODULO";
    public static final String MATH_EXP = "EXPONENT";
    public static final String TERM_RELATION = "RELATION";
    public static final String SORT = "SORT";
    public static final String ATTR_DEF = "ATTRIBUTE_DEFINITION";

    private static ALMTerm NEXT_TIME_STEP = null;
    private static ALMTerm CURRENT_TIME_STEP = null;
    private static ALMTerm BOOLEAN_TRUE = null;
    private static ALMTerm BOOLEAN_FALSE = null;

    private String name;
    private String type;
    private String sort;
    private String sign;
    private List<ALMTerm> args;
    private ParserRuleContext prc;
    private TypeChecker typechecker;
    private SortType sortType = null;

    private void defaultInit() {
        this.args = null;
        this.sign = ALMTerm.SIGN_POS; // positive by default
        typechecker = null;

        switch (type) {
        case INT:
            sort = ALM.SORT_INTEGERS;
            break;
        case BOOL:
            sort = ALM.SORT_BOOLEANS;
            break;
        case VAR:
            sort = ALM.SORT_UNKNOWN;
            break;
        default:
            sort = null;

        }
    }

    public ALMTerm(String name, String type) {
        this.name = name;
        this.type = type;
        this.prc = null;
        defaultInit();

    }

    public ALMTerm(String name, String type, ParserRuleContext prc) {
        this.name = name;
        this.type = type;
        this.prc = prc;
        defaultInit();

    }

    public ALMTerm(String name, String type, Location loc) {
        this.name = name;
        this.type = type;
        this.prc = loc.getParserRuleContext();
        defaultInit();
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getType() {
        return type;
    }

    public List<ALMTerm> getArgs() {
        // return empty list if null.
        if (args == null) {
            args = new ArrayList<ALMTerm>();
        }
        return args;
    }

    public ALMTerm addArg(ALMTerm arg) {
        if (args == null)
            args = new ArrayList<ALMTerm>();
        args.add(arg);
        return this;
    }

    public ALMTerm addArg(int index, ALMTerm arg) {
        args.set(index, arg);
        return this;
    }

    public void setSort(String var, String sort) {
        if (this.type == VAR && this.name.compareTo(var) == 0)
            this.sort = sort;
        for (ALMTerm arg : args)
            arg.setSort(var, sort);

    }

    public String getSort() {
        return sort;
    }

    public boolean isSchema() {
        // schemas have string constants and variables, no mathematical expressions.
        switch (this.type) {
        case ID:
            if (this.args == null || args.size() == 0)
                return true;
            return false;
        case FUN:
            if (this.args == null || args.size() == 0)
                return true;
            for (ALMTerm arg : args)
                if (!arg.recIsSchema())
                    return false;
            return true;
        default:
            return false;
        }
    }

    private boolean recIsSchema() {
        // schemas have string constants and variables, no mathematical expressions.
        switch (this.type) {
        case ID:
        case VAR:
        case INT:
        case BOOL:
            if (this.args == null || args.size() == 0)
                return true;
            return false;
        case FUN:
            if (this.args == null || args.size() == 0)
                return true;
            for (ALMTerm arg : args)
                if (!arg.recIsSchema())
                    return false;
            return true;
        default:
            return false;
        }
    }

    @Override
    public void typeCheck(TypeChecker tc, SymbolTable st, ErrorReport er) {
        typechecker = tc;
        // no expectation of resulting type at top level.
        this.typeCheck(tc, st, er, ANY_TYPE);
    }

    private static SortType INTEGERS_TYPE = null;
    private static SortType BOOLEANS_TYPE = null;

    /**
     * Determines the type of the ALMTerm and performs recursive typecheck on sub-ALMTerms. The given TypeChecker is
     * populated with mappings from the toString of the ALMTerm to the type determined for it. Any failure to determine
     * an adequate type produces a semantic error. The expected type from enclosing ALMTerms is passed forward in the
     * recursive type-check algorithm.
     * 
     * returns null when the ALMTerm does not have a type determined for it.
     * 
     * @param tc
     *            The TypeChecker storing type information between this and other related ALMTerms.
     * @param st
     *            The Symbol Table for looking up functions and constants and other sort information.
     * @param er
     *            The semantic error reporter.
     * @param expected
     *            The expected type from the enclosing ALMTerm to this ALMTerm. null indicates any valid type.
     * @return The narrowest type determined for this ALMTerm. EMPTY_TYPE is returned when the type of the ALMTerm
     *         cannot be determined or a type mismatch occurs with what is expected.
     */
    private SortType typeCheck(TypeChecker tc, SymbolTable st, ErrorReport er, SortType expected) {
        if (typechecker == null)
            typechecker = tc;
        if (INTEGERS_TYPE == null)
            INTEGERS_TYPE = Type.getSortType(st.getIntegersSortEntry());
        if (BOOLEANS_TYPE == null)
            BOOLEANS_TYPE = Type.getSortType(st.getBooleansSortEntry());

        switch (this.type) {
        case ALMTerm.ID:
            // There are no sub-terms.
            // ALMTerm.ID is only used in the case of constants, or instances.  Constants get priority. 
            // Lookup the constant entry.
            Set<ConstantEntry> constSet = st.getMatchingConstantEntries(this);
            // If a constant entry cannot be found, the constant is untyped. This is a
            // semantic error and return EMPTY_TYPE.
            if (constSet != null && constSet.size() > 0) {
                // constant entry exists, determine if its type can be a subtype of the expected sort.
                if (constSet.size() > 1) {
                    Iterator<ConstantEntry> constants = constSet.iterator();
                    er.newSemanticError(SemanticError.CND007).add(this).add(constants.next()).add(constants.next());
                    return EMPTY_TYPE;
                }
                ConstantEntry cnst = constSet.iterator().next();
                SortType cnstType = tc.getNarrowestSortType(cnst);

                if (!cnstType.isSubtypeOf(expected)) {
                    // type mismatch occurred.
                    er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(cnstType);
                    return EMPTY_TYPE;
                }
                // else we have a compatible match.
                // Record the expected type for the constant with the type checker.
                // return the matching sort provided by the constant.
                tc.recordConstantExpectedType(cnst, this, expected);
                return tc.getNarrowestSortType(cnst);
            }

            //Not a constant, check to see if it is an instance of the expected sort. 
        case ALMTerm.VAR:
            // There are no sub-terms.
            // Variables take on any type.
            // If there is no expected type, an instance of an un-typed variable is
            // recorded.
            // return the narrowest sort determined for the variable.
            if (expected != null)
                tc.recordVariableExpectedType(this, expected);
            else
                tc.recordUntypedVariable(this);
            return tc.getNarrowestSortType(this.name);
        case ALMTerm.INT:
            // If expected type is not null and not integers, create a semantic error and
            // return EMPTY_TYPE.
            if (expected != null && INTEGERS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(INTEGERS_TYPE);
            return INTEGERS_TYPE;
        case ALMTerm.BOOL:
            if (expected != null && BOOLEANS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(BOOLEANS_TYPE);
            return BOOLEANS_TYPE;
        case ALMTerm.MATH_NEG:
            if (expected != null && INTEGERS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(INTEGERS_TYPE);
            args.get(0).typeCheck(tc, st, er, INTEGERS_TYPE);
            return INTEGERS_TYPE;
        case ALMTerm.MATH_ADD:
            if (expected != null && INTEGERS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(INTEGERS_TYPE);
            args.get(0).typeCheck(tc, st, er, INTEGERS_TYPE);
            args.get(1).typeCheck(tc, st, er, INTEGERS_TYPE);
            return INTEGERS_TYPE;
        case ALMTerm.MATH_SUB:
            if (expected != null && INTEGERS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(INTEGERS_TYPE);
            args.get(0).typeCheck(tc, st, er, INTEGERS_TYPE);
            args.get(1).typeCheck(tc, st, er, INTEGERS_TYPE);
            return INTEGERS_TYPE;
        case ALMTerm.MATH_MULT:
            if (expected != null && INTEGERS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(INTEGERS_TYPE);
            args.get(0).typeCheck(tc, st, er, INTEGERS_TYPE);
            args.get(1).typeCheck(tc, st, er, INTEGERS_TYPE);
            return INTEGERS_TYPE;
        case ALMTerm.MATH_DIV:
            if (expected != null && INTEGERS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(INTEGERS_TYPE);
            args.get(0).typeCheck(tc, st, er, INTEGERS_TYPE);
            args.get(1).typeCheck(tc, st, er, INTEGERS_TYPE);
            return INTEGERS_TYPE;
        case ALMTerm.MATH_MOD:
            if (expected != null && INTEGERS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(INTEGERS_TYPE);
            args.get(0).typeCheck(tc, st, er, INTEGERS_TYPE);
            args.get(1).typeCheck(tc, st, er, INTEGERS_TYPE);
            return INTEGERS_TYPE;
        case ALMTerm.MATH_EXP:
            if (expected != null && INTEGERS_TYPE.isSubtypeOf(expected))
                er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(INTEGERS_TYPE);
            args.get(0).typeCheck(tc, st, er, INTEGERS_TYPE);
            args.get(1).typeCheck(tc, st, er, INTEGERS_TYPE);
            return INTEGERS_TYPE;
        case ALMTerm.SORT:
            // This ALMTerm should never have typeCheck called for it.
            ALMCompiler.IMPLEMENTATION_FAILURE("Type Checking", "typeCheck was called on ALMTerm.SORT");
        case ALMTerm.TERM_RELATION:
            switch (this.name) {
            case ALM.SYMBOL_EQ:
            case ALM.SYMBOL_NEQ: {
                SortType leftType = args.get(0).typeCheck(tc, st, er, ANY_TYPE);
                SortType rightType = args.get(1).typeCheck(tc, st, er, ANY_TYPE);
                if (leftType != null && rightType != null) {
                    // we need to make sure that the intersection of the types is non-empty and
                    // re-type check the broader type with the narrower type.
                    if (leftType.isSubtypeOf(rightType)) {
                        rightType = args.get(1).typeCheck(tc, st, er, leftType);
                    } else if (rightType.isSubtypeOf(leftType)) {
                        leftType = args.get(0).typeCheck(tc, st, er, rightType);
                    } else {
                        // Neither side is the subtype of the other, type mismatch results.
                        er.newSemanticError(SemanticError.TYP003).add(this).add(leftType).add(rightType);
                    }
                    return Type.intersect(rightType, leftType);
                }
                // else If a type could not be determined for either the left or the right, then
                // the respective type checking has already recorded the appropriate error.
            }
            case ALM.SYMBOL_LESS:
            case ALM.SYMBOL_LEQ:
            case ALM.SYMBOL_GEQ:
            case ALM.SYMBOL_GREATER:
                args.get(0).typeCheck(tc, st, er, INTEGERS_TYPE);
                args.get(1).typeCheck(tc, st, er, INTEGERS_TYPE);
            }
            if (!BOOLEANS_TYPE.isSubtypeOf(expected)) {
                er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(BOOLEANS_TYPE);
            }
            return BOOLEANS_TYPE;
        case ALMTerm.ATTR_DEF:
            //left hand side is missing its sort argument (the first argument)
            //must manually type check here and cannot use recursion since 
            //there is no matching function.
            ALMTerm fTerm = args.get(0);
            int domSize = fTerm.getArgs().size() + 1;
            FunctionEntry f = st.getFunctionEntry(fTerm, domSize, st, er);
            List<SortEntry> sig = f.getSignature();

            for (int i = 1; i < domSize; i++)
                fTerm.getArg(i - 1).typeCheck(tc, st, er, Type.getSortType(sig.get(i)));
            SortType left = Type.getSortType(sig.get(domSize));
            SortType right = args.get(1).typeCheck(tc, st, er, left);
            break;
        case ALMTerm.FUN:
            String fun_name = this.getName();
            switch (fun_name) {
            // No Type Checking Required For Special functions which do not take terms.
            // Non TYP*** semantic errors are checked outside of this function.
            case ALM.SPECIAL_FUNCTION_HAS_CHILD:
            case ALM.SPECIAL_FUNCTION_HAS_PARENT:
            case ALM.SPECIAL_FUNCTION_SINK:
            case ALM.SPECIAL_FUNCTION_SOURCE:
            case ALM.SPECIAL_FUNCTION_LINK:
            case ALM.SPECIAL_FUNCTION_SUBSORT:
                if (BOOLEANS_TYPE != expected)
                    er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(BOOLEANS_TYPE);
                return BOOLEANS_TYPE;
            case ALM.SPECIAL_FUNCTION_IS_A:
            case ALM.SPECIAL_FUNCTION_INSTANCE:
                // The right hand arguments is a sort
                SortType rightArgType;
                try {
                    rightArgType = Type.getSortType(st.getSortEntry(args.get(1).getName()));
                } catch (Exception e) {
                    rightArgType = null;
                }
                if (rightArgType != null) {
                    // Use SortType of right hand argument to type check left hand argument.
                    args.get(0).typeCheck(tc, st, er, rightArgType);
                } else {
                    // Right hand argument did not resolve to a coherent sort, typecheck against any
                    // type.
                    args.get(0).typeCheck(tc, st, er, ANY_TYPE);
                }
                if (!BOOLEANS_TYPE.isSubtypeOf(expected))
                    er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(BOOLEANS_TYPE);
                return BOOLEANS_TYPE;
            case ALM.SPECIAL_FUNCTION_OCCURS:
                // Only actions can occur. Type check against actions.
                args.get(0).typeCheck(tc, st, er, Type.getSortType(st.getActionsSortEntry()));
                if (!BOOLEANS_TYPE.isSubtypeOf(expected))
                    er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(BOOLEANS_TYPE);
                return BOOLEANS_TYPE;
            default:
                // This could be a function or a parameterized constant.
                // The names of functions and constants at the top level must be distinct.
                // functions are determined by their signatures.
                Set<FunctionEntry> functions = st.getFunctionEntries(this.name, getArgs().size());
                Set<ConstantEntry> constants = st.getConstantEntries(this.name, getArgs().size());
                if (functions != null && functions.size() > 0) {
                    // Currently there should be only one function in the set.
                    // Future versions may support function overloading based on signature.
                    // When that happens, this is where we would engage a best-fit type matching.
                    // May require multi-pass type checking to collect definite type determinations
                    // and then come
                    // back to functions to choose between options based on determined types.
                    if (functions.size() > 1) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Type Checking",
                                "This version of type checking does not support function overloading.");
                    }
                    f = functions.iterator().next();
                    sig = f.getSignature();
                    // type-check each argument against its expected sort.
                    for (int i = 0; i < args.size(); i++) {
                        // any mismatch in expected type of arguments has errors recorded in these
                        // function calls.
                        args.get(i).typeCheck(tc, st, er, Type.getSortType(sig.get(i)));
                    }
                    SortType rangeType = Type.getSortType(sig.get(sig.size() - 1));
                    if (!rangeType.isSubtypeOf(expected)) {
                        er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(rangeType);
                    }
                    return rangeType;
                } else if (constants != null && constants.size() > 0) {
                    // Currently there should be only one constant in the set.
                    // Future versions may support constant overloading based on signature.
                    // When that happens, this is where we would engage a best-fit type matching.
                    // May require multi-pass type checking to collect definite type determinations
                    // and then come
                    // back to functions to choose between options based on determined types.
                    if (constants.size() > 1) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Type Checking",
                                "This version of type checking does not support constant overloading.");
                    }
                    ConstantEntry c = constants.iterator().next();
                    List<SortEntry> cargs = c.getArguments();
                    // type-check each argument against its expected sort.
                    for (int i = 0; i < args.size(); i++) {
                        // any mismatch in expected type of arguments has errors recorded in these
                        // function calls.
                        args.get(i).typeCheck(tc, st, er, Type.getSortType(cargs.get(i)));
                    }
                    SortType rangeType = Type.getSortType(c.getSourceSorts());
                    if (!rangeType.isSubtypeOf(expected)) {
                        er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(rangeType);
                    }
                    return rangeType;
                } else {
                    er.newSemanticError(SemanticError.FND003).add(this);
                    return EMPTY_TYPE;
                }
            }
        default:
            ALMCompiler.IMPLEMENTATION_FAILURE("Type Checking ALMTerm",
                    "All Cases Should Be Explicit, but case [" + type + "] was not handled.");
        }
        // This line of code is unreachable.
        return EMPTY_TYPE;
    }

    public TypeChecker getTypeChecker() {
        if (typechecker == null && args != null) {
            Iterator<ALMTerm> argIt = args.iterator();
            while (typechecker == null && argIt.hasNext())
                typechecker = argIt.next().getTypeChecker();
        }
        return typechecker;
    }

    public void registerVariablesWith(TypeChecker tc) {
        typechecker = tc;
        if (args != null && args.size() > 0)
            for (ALMTerm arg : args)
                arg.registerVariablesWith(tc);
        if (type == ALMTerm.VAR)
            tc.recordUntypedVariable(this);
    }

    public boolean isVariable() {
        return type == ALMTerm.VAR;
    }

    public boolean isObjectConstant() {
        switch (type) {
        case ALMTerm.ID:
            return true;
        case ALMTerm.FUN:
            if (args == null || args.size() == 0)
                return false;
            for (ALMTerm arg : args)
                if (!arg.isObjectConstant())
                    return false;
            return true;
        }
        return false;
    }

    public SortEntry isInstance(SortEntry sort) {
        boolean compatible = false;
        SortEntry returnSort = null;
        // check compability to the instances of expected sort
        List<ALMTerm> instances = sort.getInstances();
        for (ALMTerm inst : instances) {
            if (inst.getName().equals(this.getName())) {
                compatible = true;
                returnSort = sort;
                break;
            }
        }
        if (compatible == false) {
            // we can have multi-level of child sort so it needs to have a recursive
            // function, write a function that called instance function
            // if it is not compatible with expected sort's instances check the child sort's
            // instances
            Set<SortEntry> childSorts = sort.getChildSorts();
            for (SortEntry child : childSorts) {
                returnSort = isInstance(child);
                if (returnSort != null)
                    break;
            }
        }

        if (returnSort != null)
            return returnSort;
        else
            return null;
    }

    @Override
    public void writeTo(BufferedWriter out) throws IOException {
        switch (this.type) {

        case ALMTerm.MATH_NEG:
            out.write("-");
            args.get(0).writeTo(out);
            break;
        case ALMTerm.MATH_ADD:
            args.get(0).writeTo(out);
            out.write("+");
            args.get(1).writeTo(out);
            break;
        case ALMTerm.MATH_DIV:
            args.get(0).writeTo(out);
            out.write("/");
            args.get(1).writeTo(out);
            break;
        case ALMTerm.MATH_EXP:
            args.get(0).writeTo(out);
            out.write("^");
            args.get(1).writeTo(out);
            break;
        case ALMTerm.MATH_MOD:
            args.get(0).writeTo(out);
            out.write(" mod ");
            args.get(1).writeTo(out);
            break;
        case ALMTerm.MATH_MULT:
            args.get(0).writeTo(out);
            out.write("*");
            args.get(1).writeTo(out);
            break;
        case ALMTerm.TERM_RELATION:
            args.get(0).writeTo(out);
            out.write(this.name);
            args.get(1).writeTo(out);
            break;
        case ALMTerm.BOOL:
        case ALMTerm.ID:
        case ALMTerm.INT:
        case ALMTerm.VAR:
        case ALMTerm.SORT:
            out.write(this.name);
            break;
        case ALMTerm.FUN:
            out.write(this.sign);
            out.write(this.name);
            if (this.args != null && this.args.size() > 0) {
                boolean first = true;
                out.write("(");
                for (ALMTerm arg : args) {
                    if (first)
                        first = false;
                    else
                        out.write(", ");
                    arg.writeTo(out);
                }
                out.write(")");
            }
            break;
        default:
            ALMCompiler.IMPLEMENTATION_FAILURE("Writing Out ALMTerm", "Unhandled type [" + this.type + "]");

        }
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        BufferedWriter out = new BufferedWriter(sw);
        try {
            this.writeTo(out);
            out.flush();
            out.close();
            return sw.toString();
        } catch (IOException e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("To String", "Failed to write out term due to IO error");
        }
        return null;
    }

    public void setSign(String sign) {
        this.sign = sign;

    }

    public void setType(String type) {
        this.type = type;
    }

    public String toSortInstance() {
        switch (this.type) {
        case ALMTerm.VAR:
            if (typechecker == null)
                return ALM.SORT_UNKNOWN;
            SortType sortType = typechecker.getNarrowestSortType(this.name);
            if (sortType.isSingleton()) {
                return "#" + sortType.getSingleton().getSortName();
            } else {
                ALMCompiler.IMPLEMENTATION_FAILURE("toSortInstance",
                        "Union Sort not handled here.  Whole section needs to be re-written. ");
            }

        case ALMTerm.FUN:
            StringBuffer out = new StringBuffer();
            out.append(this.name);
            if (this.args != null && this.args.size() > 0) {
                boolean first = true;
                out.append("(");
                for (ALMTerm arg : args) {
                    if (first)
                        first = false;
                    else
                        out.append(", ");
                    out.append(arg.toSortInstance());
                }
                out.append(")");
            }
            return out.toString();

        case ALMTerm.ID:
        case ALMTerm.BOOL:
        case ALMTerm.INT:
            return this.name;
        default:
            ALMCompiler.IMPLEMENTATION_FAILURE("SortInstance As String", "Unhandled type [" + this.type + "]");
            return null;
        }
    }

    public ALMTerm getArg(int i) {
        if (args != null && args.size() > i)
            return args.get(i);
        return null;
    }

    public ParserRuleContext getLocation() {
        return prc;
    }

    public static ALMTerm NEXT_TIME_STEP() {
        if (ALMTerm.NEXT_TIME_STEP == null)
            ALMTerm.NEXT_TIME_STEP = new ALMTerm("I+1", ALMTerm.VAR);
        return ALMTerm.NEXT_TIME_STEP;
    }

    public static ALMTerm CURRENT_TIME_STEP() {
        if (ALMTerm.CURRENT_TIME_STEP == null)
            ALMTerm.CURRENT_TIME_STEP = new ALMTerm("I", ALMTerm.VAR);
        return ALMTerm.CURRENT_TIME_STEP;
    }

    public static ALMTerm BOOLEAN_TRUE() {
        if (ALMTerm.BOOLEAN_TRUE == null)
            ALMTerm.BOOLEAN_TRUE = new ALMTerm("true", ALMTerm.BOOL);
        return ALMTerm.BOOLEAN_TRUE;
    }

    public static ALMTerm BOOLEAN_FALSE() {
        if (ALMTerm.BOOLEAN_FALSE == null)
            ALMTerm.BOOLEAN_FALSE = new ALMTerm("false", ALMTerm.BOOL);
        return ALMTerm.BOOLEAN_FALSE;
    }

    public boolean isGround() {
        switch (this.type) {
        case ALMTerm.VAR:
            return false;
        case ALMTerm.INT:
        case ALMTerm.BOOL:
        case ALMTerm.ID:
            return true;
        default:
            if (args != null && args.size() > 0)
                for (ALMTerm arg : args)
                    if (!arg.isGround())
                        return false;
            return true;

        }
    }

    @Override
    public boolean hasFluentFunction(SymbolTable st) {
        switch (this.type) {
        case FUN:
            Set<FunctionEntry> functions = st.getFunctionEntries(this.name, args.size());
            if (functions.size() > 0) {
                // There should be at most one in this version of the compiler.
                if (functions.size() > 1) {
                    ALMCompiler.IMPLEMENTATION_FAILURE("Checking For Fluents", "Overloaded function found.");
                }
                FunctionEntry f = functions.iterator().next();
                if (f.isFluent())
                    return true;
                for (ALMTerm arg : args)
                    if (arg.hasFluentFunction(st))
                        return true;
            }
            return false;
        default:
            if (this.args == null || this.args.size() == 0)
                return false;
            for (ALMTerm arg : args)
                if (arg.hasFluentFunction(st))
                    return true;
            return false;
        }
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    public ALMTerm toALMTerm() {
        return this;
    }

    /**
     * recursively register variables with the given set from this ALMTerm and its sub-ALMTerms.
     * 
     * @param variables
     *            The set to accumulate variable names with.
     */
    public void registerVariables(Set<String> variables) {
        if (isVariable()) {
            variables.add(this.name);
            return;
        }

        if (args != null)
            for (ALMTerm arg : args) {
                arg.registerVariables(variables);
            }
    }

    /**
     * Recursively traverses the ALMTerm looking substructure that matches the pattern to replace with the given
     * replacement ALMTerm. Variable names are allowed to differ, but variable occurrences are required to match
     * structurally.
     * 
     * @param pattern
     *            The structure that must match.
     * @param replacement
     */
    public void replaceTerm(ALMTerm pattern, ALMTerm replacement) {
        if (this.matches(pattern)) {
            this.name = replacement.getName();
            this.type = replacement.getType();
            this.sign = replacement.getSign();
            getArgs().clear();
            this.args.addAll(replacement.getArgs());
            this.prc = replacement.getLocation();
        } else if (args != null && args.size() > 0) {
            for (ALMTerm arg : args)
                arg.replaceTerm(pattern, replacement);
        }
    }

    /**
     * Recursively Compares this ALMTerm to the given pattern allowing for variable name differences. This does not
     * allow for loose matches where variables can be matched to non-variable ALMTerms.
     * 
     * @param pattern
     *            The pattern to match against.
     * @return True if there is a structural match, otherwise false is returned.
     */
    public boolean matches(ALMTerm pattern) {
        if (this.type != pattern.type)
            return false;
        //type matches
        switch (this.type) {
        case ALMTerm.VAR:
            return true; //the variable name does not matter when matching.
        }
        if (!this.name.equals(pattern.name))
            return false;
        //name matches
        if (this.sign != pattern.sign)
            return false;
        //sign matches
        int numArgs = args == null ? 0 : args.size();
        if (numArgs != pattern.getArgs().size())
            return false;
        //size of arguments match
        for (int i = 0; i < numArgs; i++) {
            if (!args.get(i).matches(pattern.getArg(i)))
                return false;
        }
        //all arguments match
        return true;
    }

}
