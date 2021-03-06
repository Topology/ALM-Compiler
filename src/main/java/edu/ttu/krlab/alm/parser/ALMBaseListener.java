// Generated from ALM.g4 by ANTLR 4.5.3
package edu.ttu.krlab.alm.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.ALMCompilerSettings;
import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfLiteral;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfProgram;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfRule;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.datastruct.sig.ConstantEntry;
import edu.ttu.krlab.alm.datastruct.sig.DOMFunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.exception.DuplicateConstantException;
import edu.ttu.krlab.alm.datastruct.sig.exception.DuplicateFunctionException;
import edu.ttu.krlab.alm.datastruct.sig.exception.DuplicateSortException;
import edu.ttu.krlab.alm.datastruct.sig.FunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.NormalFunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.SortEntry;
import edu.ttu.krlab.alm.datastruct.sig.SortInstanceEntry;
import edu.ttu.krlab.alm.datastruct.sig.exception.SortNotFoundException;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.sig.exception.NameCollisionException;
import edu.ttu.krlab.alm.datastruct.type.SortType;
import edu.ttu.krlab.alm.datastruct.type.Type;
import edu.ttu.krlab.alm.datastruct.type.TypeChecker;
import edu.ttu.krlab.alm.parser.ALMParser.Action_conditionsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Added_constraintsContext;
import edu.ttu.krlab.alm.parser.ALMParser.AttributesContext;
import edu.ttu.krlab.alm.parser.ALMParser.BoolContext;
import edu.ttu.krlab.alm.parser.ALMParser.Current_stateContext;
import edu.ttu.krlab.alm.parser.ALMParser.Diagnostic_problemContext;
import edu.ttu.krlab.alm.parser.ALMParser.Fun_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Function_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Goal_stateContext;
import edu.ttu.krlab.alm.parser.ALMParser.HappenedContext;
import edu.ttu.krlab.alm.parser.ALMParser.HistoryContext;
import edu.ttu.krlab.alm.parser.ALMParser.IdContext;
import edu.ttu.krlab.alm.parser.ALMParser.Instance_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.LiteralContext;
import edu.ttu.krlab.alm.parser.ALMParser.Max_stepsContext;
import edu.ttu.krlab.alm.parser.ALMParser.ModuleContext;
import edu.ttu.krlab.alm.parser.ALMParser.Module_dependenciesContext;
import edu.ttu.krlab.alm.parser.ALMParser.Nat_numContext;
import edu.ttu.krlab.alm.parser.ALMParser.Normal_conditionsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Object_constantContext;
import edu.ttu.krlab.alm.parser.ALMParser.ObservedContext;
import edu.ttu.krlab.alm.parser.ALMParser.Occurs_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Occurs_literalContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_action_conditionContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_added_constraintContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_attribute_declContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_attribute_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_dependencyContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_normal_conditionContext;
import edu.ttu.krlab.alm.parser.ALMParser.Planning_problemContext;
import edu.ttu.krlab.alm.parser.ALMParser.Solver_modeContext;
import edu.ttu.krlab.alm.parser.ALMParser.Sort_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Temporal_projectionContext;
import edu.ttu.krlab.alm.parser.ALMParser.TermContext;

/**
 * This class provides an empty implementation of {@link ALMListener}, which can be extended to create a listener which
 * only needs to handle a subset of the available methods.
 */
/**
 *
 *
 * Organized to target computing Pre-model in SPARC first, then targeting Final SPARC Program.
 *
 * Prior to Constructing Pre-Model SPARC Program: 1) Parse Sort Hierarchy A) Sort Hierarchy into Symbol Table B) ASP{f}
 * rules for Hierarchy Created and in intermediate ASP{f} Rule Table 2) Parse Function Declarations A) Functions into
 * Symbol Table 3) Parse Axioms A) Parse Axioms into ASP{f} Rule Table for each type of Axiom 4) Parse Constant
 * Definitions in Structure A) Constant Definitions modify declared constants in the Symbol Table 5) Parse Sort
 * Instances A) Sort Instances are added to the symbol table. B) Rules for sort instances added to ASP{f} table of
 * appropriate type. 6) Parse Function definitions A) Definitions added to ASP{f} rule table of appropriate type.
 *
 * Construct Pre-model SPARC Program 1) Initialize Sort Section from SORT Hierarchy in symbol table 2) Define predicates
 * from function in symbol table. 3) Translate static rules from ASP{f} that contribute to pre-model.
 *
 * Compute Answer Set
 *
 * Construct Final SPARC Program 1) Populate Sort Section from answerset 2) Copy predicate declarations 3) Copy rules 4)
 * Translate remaining non-static rules from ASP{f} 5) Add facts from Answer Set.
 *
 * @author Edward Wertz
 */
public class ALMBaseListener implements ALMListener {

    private SymbolTable st;
    private ErrorReport er;
    private ASPfProgram aspf;
    private ALMCompilerSettings s;

    // Function Type
    boolean staticType = false;
    boolean fluentType = false;
    boolean basicType = false;
    boolean definedType = false;
    boolean totalType = false;

    public ALMBaseListener(ALMCompilerSettings settings, SymbolTable st, ASPfProgram aspf, ErrorReport er) {
        this.s = settings;
        this.st = st;
        this.aspf = aspf;
        this.er = er;

        aspf.createSection(ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS);
        aspf.createSection(ALM.AXIOMS_EXECUTABILITY_CONDITIONS);
        aspf.createSection(ALM.AXIOMS_STATE_CONSTRAINTS);
        aspf.createSection(ALM.AXIOMS_DEFINITIONS);
        aspf.createSection(ALM.STRUCTURE_CONSTANT_DEFINITIONS);
        aspf.createSection(ALM.STRUCTURE_SORT_INSTANCES);
        aspf.createSection(ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS);
        aspf.createSection(ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterAlm_name(ALMParser.Alm_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitAlm_name(ALMParser.Alm_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterInteger(ALMParser.IntegerContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitInteger(ALMParser.IntegerContext ctx) {
        st.addIntegerOccurrence(ctx.getText(), new Location(ctx));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterRelation(ALMParser.RelationContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitRelation(ALMParser.RelationContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterObject_constant(ALMParser.Object_constantContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitObject_constant(ALMParser.Object_constantContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterFunction_term(ALMParser.Function_termContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitFunction_term(ALMParser.Function_termContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterTerm(ALMParser.TermContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitTerm(ALMParser.TermContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterVar_or_obj(ALMParser.Var_or_objContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitVar_or_obj(ALMParser.Var_or_objContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterExpression(ALMParser.ExpressionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitExpression(ALMParser.ExpressionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterArithmetic_term(ALMParser.Arithmetic_termContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitArithmetic_term(ALMParser.Arithmetic_termContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterFactor(ALMParser.FactorContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitFactor(ALMParser.FactorContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOccurs_atom(ALMParser.Occurs_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitOccurs_atom(ALMParser.Occurs_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterInstance_atom(ALMParser.Instance_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitInstance_atom(ALMParser.Instance_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterIs_a_atom(ALMParser.Is_a_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitIs_a_atom(ALMParser.Is_a_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterLink_atom(ALMParser.Link_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitLink_atom(ALMParser.Link_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterSubsort_atom(ALMParser.Subsort_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitSubsort_atom(ALMParser.Subsort_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterHas_child_atom(ALMParser.Has_child_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitHas_child_atom(ALMParser.Has_child_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterHas_parent_atom(ALMParser.Has_parent_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitHas_parent_atom(ALMParser.Has_parent_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterSink_atom(ALMParser.Sink_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitSink_atom(ALMParser.Sink_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterSource_atom(ALMParser.Source_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitSource_atom(ALMParser.Source_atomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterAtom(ALMParser.AtomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitAtom(ALMParser.AtomContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterLiteral(ALMParser.LiteralContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitLiteral(ALMParser.LiteralContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOccurs_literal(ALMParser.Occurs_literalContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitOccurs_literal(ALMParser.Occurs_literalContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterLibrary_name(ALMParser.Library_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitLibrary_name(ALMParser.Library_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterSys_desc_name(ALMParser.Sys_desc_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitSys_desc_name(ALMParser.Sys_desc_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterSystem_description(ALMParser.System_descriptionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitSystem_description(ALMParser.System_descriptionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterTheory_name(ALMParser.Theory_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitTheory_name(ALMParser.Theory_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterTheory(ALMParser.TheoryContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitTheory(ALMParser.TheoryContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterModule(ModuleContext ctx) {
        ALMTerm.setSymbolTable(st);
    }

    @Override
    public void exitModule(ModuleContext ctx) {
    }

    @Override
    public void enterModule_name(ALMParser.Module_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitModule_name(ALMParser.Module_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterSequence_of_modules(ALMParser.Sequence_of_modulesContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitSequence_of_modules(ALMParser.Sequence_of_modulesContext ctx) {
    }

    @Override
    public void enterModule_body(ALMParser.Module_bodyContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitModule_body(ALMParser.Module_bodyContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterInteger_range(ALMParser.Integer_rangeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitInteger_range(ALMParser.Integer_rangeContext ctx) {
        List<ALMParser.IntegerContext> integers = ctx.integer();
        Integer low = Integer.parseInt(integers.get(0).getText());
        Integer high = Integer.parseInt(integers.get(1).getText());
        //insert semantic error check for low > high, if needed. 
        st.getIntegerRangeSort(low, high, new Location(ctx));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterPredefined_sorts(ALMParser.Predefined_sortsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitPredefined_sorts(ALMParser.Predefined_sortsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterSort_name(ALMParser.Sort_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitSort_name(ALMParser.Sort_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterSort_declarations(ALMParser.Sort_declarationsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitSort_declarations(ALMParser.Sort_declarationsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_sort_decl(ALMParser.One_sort_declContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    // one_sort_decl: ID (',' ID)* '::' sort_name (',' sort_name)* attributes;
    @Override
    public void exitOne_sort_decl(ALMParser.One_sort_declContext ctx) {

        // collect lists of parts
        List<ALMParser.New_sort_nameContext> newSorts = ctx.new_sort_name();
        List<Sort_nameContext> sort_names = ctx.sort_name();
        AttributesContext attributes_section = ctx.attributes();
        List<One_attribute_declContext> attributes = null;
        if (attributes_section != null) {
            attributes = attributes_section.one_attribute_decl();
        }

        // convert sort_names into sort_entries for parents,
        // throw semantic error
        // if they do not exist yet
        // if they are predefined.
        List<SortEntry> parent_sorts = new ArrayList<SortEntry>();
        for (Sort_nameContext sort_name : sort_names) {
            try {
                String sortName = sort_name.getText();
                switch (sortName) {
                    case ALM.SORT_BOOLEANS:
                    case ALM.SORT_INTEGERS:
                        er.newSemanticError(SemanticError.SRT001).add(sort_name);
                        break;
                    default:
                        parent_sorts.add(st.getSortEntry(sort_name.getText()));
                }
            } catch (SortNotFoundException e2) {
                // parent sort entry is not inside the symbol table.
                er.newSemanticError(SemanticError.SRT002).add(sort_name);
            }
        }

        // Create New Sort Entries for IDS
        List<SortEntry> child_sorts = new ArrayList<SortEntry>();
        for (ALMParser.New_sort_nameContext newSort : newSorts) {
            if (newSort.id() != null) {
                //check if child sort already exists. 
                SortEntry child = null;
                try {
                    child = st.getSortEntry(newSort.id().getText());
                } catch (SortNotFoundException ex) {
                    try {
                        child = st.createSortEntry(newSort.id().getText(), new Location(newSort));
                    } catch (DuplicateSortException ex1) {
                        //never happens 
                    }
                }
                child_sorts.add(child);
            } else {
                Integer low = Integer.parseInt(newSort.integer_range().integer(0).getText());
                Integer high = Integer.parseInt(newSort.integer_range().integer(1).getText());
                child_sorts.add(st.getIntegerRangeSort(low, high, new Location(newSort)));
            }
        }

        // link parent and child together in symbol table.
        for (SortEntry parent : parent_sorts) {
            for (SortEntry child : child_sorts) {
                child.addParentSort(parent);
                // // if parent sorts have attribute the child should has them as well
                // Set<NormalFunctionEntry> parentAttributes = parent.getAttributes();
                // if(parentAttributes.size() != 0){
                // for(NormalFunctionEntry pAttr : parentAttributes){
                // child.addAttribute(pAttr);
                // }
                // }
            }
        }

        // Create Attribute Functions
        // one_attribute_decl: ID ':' (sort_name (',' sort_name )* RIGHT_ARROW)?
        // sort_name;
        if (attributes != null) {
            for (One_attribute_declContext attribute : attributes) {

                // attribute name
                String attr_name = attribute.id().getText();

                // Construct Partial Signature
                boolean sig_success = true;
                List<SortEntry> partial_sig = new ArrayList<SortEntry>();
                for (Sort_nameContext sig_sort : attribute.sort_name()) {
                    try {
                        partial_sig.add(st.getSortEntry(sig_sort.getText()));
                    } catch (SortNotFoundException e) {
                        // Sort Entry does not exist for sort name in the
                        // signature.
                        er.newSemanticError(SemanticError.ATF002).add(attribute).add(sig_sort);
                        sig_success = false;
                    }
                }

                // if partial signature successful, create attribute function
                // for every ID in list.
                if (sig_success) {
                    for (SortEntry child : child_sorts) {

                        // construct full signature for function
                        List<SortEntry> full_sig = new ArrayList<SortEntry>();
                        full_sig.add(child);
                        full_sig.addAll(partial_sig);

                        // attempt to create the function entry and if
                        // successful add it to the child.
                        try {
                            //Check for other attribute declarations with the same name and number of arguments. 
                            Set<FunctionEntry> matching = st.getFunctionEntries(attr_name, full_sig.size() - 1);
                            if (matching != null && matching.size() > 0) {
                                er.newSemanticError(SemanticError.ATF004).add(attribute)
                                        .add(matching.iterator().next().getLocation());
                            } else {
                                NormalFunctionEntry attr;
                                try {
                                    attr = st.createFunctionEntry(attr_name, full_sig,
                                            new Location(attribute));
                                } catch (NameCollisionException ex) {
                                    er.newSemanticError(SemanticError.NAM001).add(attribute).add(ex.getLocation());
                                    //this is a fatal error.  
                                    return;
                                }

                                attr.setAttribute();
                                attr.setStatic();
                                child.addAttribute(attr);

                                // per attribute function, need to add axiom defining dom_f
                                ALMTerm domf = new ALMTerm(ALM.DOM_PREFIX + attr.getQualifiedFunctionName(),
                                        ALMTerm.FUN, attribute);
                                ALMTerm fun = new ALMTerm(attr.getQualifiedFunctionName(), ALMTerm.FUN, attribute);

                                int num_args = attr.getSignature().size() - 1;
                                for (int i = 0; i < num_args; i++) {
                                    ALMTerm argi = new ALMTerm("X" + i, ALMTerm.VAR);
                                    domf.addArg(argi);
                                    fun.addArg(argi);
                                    i++;
                                }

                                ALMTerm funRelation = new ALMTerm(ALM.SYMBOL_EQ, ALMTerm.TERM_RELATION);
                                funRelation.addArg(fun);
                                funRelation.addArg(new ALMTerm("Y", ALMTerm.VAR));

                                List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();
                                body.add(funRelation);

                                ASPfRule r = aspf.newRule(ALM.AXIOMS_DEFINITIONS_STATIC, domf, body);
                                r.addComment("Definition for dom_f being positive when attribute function ["
                                        + attr.getFunctionName() + "] of sort [" + child.getSortName()
                                        + "] has a known definition.");
                            }
                        } catch (DuplicateFunctionException e) {
                            FunctionEntry original = e.getFunctionEntry();
                            er.newSemanticError(SemanticError.ATF003).add(attribute).add(original.getLocation());
                        }

                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterAttributes(ALMParser.AttributesContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitAttributes(ALMParser.AttributesContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_attribute_decl(ALMParser.One_attribute_declContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitOne_attribute_decl(ALMParser.One_attribute_declContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterConstant_declarations(ALMParser.Constant_declarationsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitConstant_declarations(ALMParser.Constant_declarationsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_constant_decl(ALMParser.One_constant_declContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    // object_constant (',' object_constant)* ':' sort_name (',' sort_name)*;
    @Override
    public void exitOne_constant_decl(ALMParser.One_constant_declContext ctx) {

        // collect ANTLR4 entities into appropriate lists.
        List<Object_constantContext> object_constants = ctx.object_constant();
        List<Sort_nameContext> sort_names = ctx.sort_name();
        List<ALMParser.One_attribute_defContext> attr_defs = null;
        if (ctx.attribute_defs() != null) {
            attr_defs = ctx.attribute_defs().one_attribute_def();
            if (sort_names.size() > 1 && !attr_defs.isEmpty()) {
                er.newSemanticError(SemanticError.SID006).add(object_constants).add(sort_names).add(attr_defs);
            }
        }

        // Convert Attribute Definitions into ALMTerms for term relations.
        List<ALMTerm> attribute_defs = new ArrayList<ALMTerm>();
        if (attr_defs != null) {
            for (One_attribute_defContext attr_def : attr_defs) {
                attribute_defs.add(ALM.ParseAttrDef(attr_def));
            }
        }

        // convert sort_names into sort entries and ensure they are source sorts
        // in the hierarchy
        List<SortEntry> sort_entries = new ArrayList<SortEntry>();
        for (Sort_nameContext sort_name : sort_names) {
            try {
                SortEntry sort = st.getSortEntry(sort_name.getText());
                Set<SortEntry> children = sort.getChildSorts();
//                if (children.size() == 0) {
                sort_entries.add(sort);
//                } else {
//                    // sort was not source sort.
//                    SemanticError se = er.newSemanticError(SemanticError.CND001);
//                    se.add(ctx); // location of const declaration.
//                    se.add(sort_name);
//                    se.add(children.iterator().next().getLocation());
//                }
            } catch (SortNotFoundException e1) {
                // sort was not declared in the hierarchy
                er.newSemanticError(SemanticError.CND003).add(sort_name);
            }
        }

        // TypeCheck ALMTerms and verify that attribute definitions are actual attributes for the sort. 
        TypeChecker tc = new TypeChecker(st, er);

        for (ALMTerm adef : attribute_defs) {
            //for each attribute definition
            //type check the attribute function. 
            adef.typeCheck(tc, st, er);
            ALMTerm range = adef.getArg(1);
            ALMTerm attr = adef.getArg(0);
            String attr_name = attr.getName();
            List<ALMTerm> attr_params = attr.getArgs();
            int param_count = 0;
            if (attr_params != null) {
                param_count = attr_params.size();
            }
            //verify attribute function belongs to the sorts the instance is compatible with.
            for (SortEntry s : sort_entries) {
                //for each sort the instance is declared to belong to.
                for (FunctionEntry attr_fun : s.getAttributes()) {
                    //for each attribute function of the sort. 
                    if (attr_fun.getFunctionName().compareTo(attr_name) == 0) {
                        // matching attribute function found.
                        List<SortEntry> sig = attr_fun.getSignature();
                        if (param_count + 2 != sig.size()) {
                            //this error may not be accurate if its possible for a sort to have two attributes
                            //of the same name but different arguments.  
                            er.newSemanticError("SID005").add(attr.getLocation()).add(attr_fun.getLocation());
                            continue;
                        }
                    }
                }
            }

        }

        // body
        List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();

        // create object constants if their arguments are source sorts.
        for (Object_constantContext obj_con : object_constants) {
            ALMTerm obj_const = ALM.ParseALMTerm(obj_con);

            boolean schema_passed = true;
            // check to make sure all parameters are source sorts in hierarchy.
            List<ALMTerm> args = obj_const.getArgs();
            List<SortEntry> arguments = new ArrayList<SortEntry>();
            if (args != null) {
                for (ALMTerm arg : args) {
                    try {
                        SortEntry sort = st.getSortEntry(arg.toString());
                        Set<SortEntry> children = sort.getChildSorts();
                        arguments.add(sort);
//                        if (children.size() != 0) {
//                            SortEntry childsort = children.iterator().next();
//                            er.newSemanticError(SemanticError.CND002).add(arg.getLocation())
//                                    .add(childsort.getLocation());
//                            schema_passed = false;
//                        }
                    } catch (SortNotFoundException e) {
                        er.newSemanticError(SemanticError.CND004).add(arg.getLocation());
                        schema_passed = false;
                    }

                }
            }

            ConstantEntry constEntry = null;
            if (schema_passed) {
                try {

                    constEntry = st.createConstantEntry(obj_const.getName(), arguments, sort_entries,
                            new Location(ctx));
                } catch (DuplicateConstantException e) {
                    constEntry = e.getConstantEntry();
                    Set<SortEntry> duplicated = e.getPreviouslyDeclaredSorts();
                    er.newSemanticError(SemanticError.CND005).add(obj_const.getLocation())
                            .add(duplicated.iterator().next());

                } catch (NameCollisionException ex) {
                    er.newSemanticError(SemanticError.NAM002).add(obj_const).add(ex.getLocation());
                    //this is a fatal error. 
                    return;
                }
            } else {
                return; //nothing else to do here due to error. 
            }

            // Add the is_a(object_constant, source_sort) rule to ASPf
            // is_a(c(S1 .. Sn), source_sort) :- instance(S1, sort1) .. instance(Sn,sortn).
            for (int i = 0; i < sort_entries.size(); i++) {
                ALMTerm constTerm;
                int argSize = arguments.size();
                if (argSize > 0) {
                    constTerm = new ALMTerm(obj_const.getName(), ALMTerm.FUN);
                } else {
                    constTerm = new ALMTerm(obj_const.getName(), ALMTerm.ID);
                }

                ALMTerm head = null;
                head = new ALMTerm(ALM.SPECIAL_FUNCTION_IS_A, ALMTerm.FUN);
                head.addArg(constTerm);
                head.addArg(new ALMTerm(sort_entries.get(i).getSortName(), ALMTerm.ID,
                        sort_entries.get(i).getLocation().getParserRuleContext()));
                body = new ArrayList<>();

                // If the constant is parameterized by sorts, then it must have instance(X,Y)
                // for each sort.
                if (argSize > 0) {
                    String SVar = "S";
                    List<SortEntry> sortArgs = constEntry.getArguments();
                    for (int j = 0; j < argSize; j++) {
                        ALMTerm Sj = new ALMTerm(SVar + j, ALMTerm.VAR);
                        constTerm.addArg(Sj);

                        ALMTerm sortj = new ALMTerm(sortArgs.get(i).getSortName(), ALMTerm.ID);

                        ALMTerm instanceTerm = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
                        instanceTerm.addArg(Sj);
                        instanceTerm.addArg(sortj);

                        body.add(instanceTerm);
                    }
                }

                //TODO: This needs to be changed to its own constant declaration section.  
                ASPfRule r = aspf.newRule(ALM.THEORY_CONSTANT_DECLARATIONS, head, body);
                r.addComment("Constant [" + obj_const + "] declared for sort [" + sort_entries.get(i) + "].");

                // Create ASPfRules for Attribute Definitions.
                // Need forloop over attribute definitions.
                for (ALMTerm attr_def : attribute_defs) {
                    body = new ArrayList<>();
                    // The instance(X, sort) declarations need to be added to the body for the domain and range of
                    // every attribute definition.  Multiple rules are created using the same body and will receive
                    // the instance declarations for variables as they are added to the common body.
                    ALMTerm attr_fun = attr_def.getArg(0);
                    ALMTerm attr_term = attr_def.getArg(1);
                    List<ALMTerm> funArgs = attr_fun.getArgs();
                    int dom_size = funArgs.size() + 1; //missing sort argument to function. 

                    //determine matching function. If no matching function can be found, skip.   
                    Set<FunctionEntry> funs = st.getFunctionEntries(attr_fun.getName(), dom_size);
                    if (funs.size() < 1) {
                        continue;
                    } else if (funs.size() > 1) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Parsing Atrribute Definitions",
                                "Function overloading is not supported in this version of ALM.");
                    }

                    //instance(X, sort) for attribute arguments. 
                    FunctionEntry fun = funs.iterator().next();
                    List<SortEntry> sig = fun.getSignature();
                    for (int j = 1; j < dom_size; j++) {
                        ALMTerm instanceOf = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
                        instanceOf.addArg(funArgs.get(j - 1));
                        instanceOf.addArg(new ALMTerm(sig.get(j).getSortName(), ALMTerm.ID));
                        body.add(instanceOf);
                    }

//                    //DISABLED UNTIL HERBRAND TERM ADDED AS FIRST CLASS CONSTRUCT TO SYMBOL TABLE. 
//                    //instance(X, sort) for attribtue range
//                    ALMTerm rangeInstanceOf = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
//                    rangeInstanceOf.addArg(attr_term);
//                    rangeInstanceOf.addArg(new ALMTerm(sig.get(dom_size).getSortName(), ALMTerm.ID));
//                    body.add(rangeInstanceOf);
                    //need to create attribute definition rule.
                    ALMTerm new_fun = new ALMTerm(attr_fun.getName(), ALMTerm.FUN, attr_def.getLocation());
                    new_fun.addArg(obj_const);
                    if (attr_fun.getArgs() != null) {
                        for (ALMTerm arg : attr_fun.getArgs()) {
                            new_fun.addArg(arg);
                        }
                    }
                    // Construct a new variable for the function to equal.
                    String new_var_base = attr_fun.getName().substring(0, 1).toUpperCase() + "_";
                    ALMTerm new_var = new ALMTerm(tc.newVariable(new_var_base, Type.ANY_TYPE), ALMTerm.VAR, attr_def.getLocation());
                    ALMTerm ad_head = new ALMTerm(ALM.SYMBOL_EQ, ALMTerm.TERM_RELATION, attr_def.getLocation());
                    ad_head.addArg(new_fun);
                    ad_head.addArg(new_var);

                    // add new term relation to body for variable.
                    List<ASPfLiteral> ad_body = new ArrayList<ASPfLiteral>();
                    ad_body.addAll(body);
                    ALMTerm term_relation = new ALMTerm(ALM.SYMBOL_EQ, ALMTerm.TERM_RELATION, attr_def.getLocation());
                    term_relation.addArg(new_var);
                    term_relation.addArg(attr_term);
                    ad_body.add(term_relation);

                    ASPfRule ar = aspf.newRule(ALM.THEORY_CONSTANT_DECLARATIONS, ad_head, ad_body);
                    ar.addComment("Definition of attribute [" + attr_def.getArg(0).getName() + "] for instance ["
                            + obj_const.toString() + "] of sort [" + sort_entries.get(i).getSortName() + "].");

                }
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterFunction_name(ALMParser.Function_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitFunction_name(ALMParser.Function_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterFunction_declarations(ALMParser.Function_declarationsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitFunction_declarations(ALMParser.Function_declarationsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterStatic_declarations(ALMParser.Static_declarationsContext ctx) {
        staticType = true;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitStatic_declarations(ALMParser.Static_declarationsContext ctx) {
        staticType = false;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterFluent_declarations(ALMParser.Fluent_declarationsContext ctx) {
        fluentType = true;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitFluent_declarations(ALMParser.Fluent_declarationsContext ctx) {
        fluentType = false;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterBasic_function_declarations(ALMParser.Basic_function_declarationsContext ctx) {
        basicType = true;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitBasic_function_declarations(ALMParser.Basic_function_declarationsContext ctx) {
        basicType = false;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterDefined_function_declarations(ALMParser.Defined_function_declarationsContext ctx) {
        definedType = true;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitDefined_function_declarations(ALMParser.Defined_function_declarationsContext ctx) {
        definedType = false;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_function_decl(ALMParser.One_function_declContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    // one_function_decl: ('total')? function_name ':' sort_name (('*' sort_name
    // )* RIGHT_ARROW
    // sort_name)?;//<one_function_decl><total_partial><one_f_decl>
    // <remainder_args>
    @Override
    public void exitOne_function_decl(ALMParser.One_function_declContext ctx) {

        totalType = false; // assume not total until we find the total keyword

        ParseTree firstchild = ctx.getChild(0);
        Function_nameContext fun_name = ctx.function_name();

        if (firstchild != fun_name) // The keyword total is present;
        {
            totalType = true;
        }

        String funName = fun_name.getText();

        List<Sort_nameContext> sort_names = ctx.sort_name();

        // convert to a list of sort-entries
        List<SortEntry> signature = new ArrayList<SortEntry>();
        for (Sort_nameContext sctx : sort_names) {
            String sort_name_text = sctx.getText();
            try {
                SortEntry sort = st.getSortEntry(sort_name_text);
                signature.add(sort);
            } catch (SortNotFoundException e) {
                // All sorts must be declared in hierarchy
                er.newSemanticError(SemanticError.FND002).add(sctx);
                return; //cannot proceed due to signature failure. 
            }
        }

        // defined functions must be boolean, otherwise semantic error.
        if (definedType == true) {
            if (signature.get(signature.size() - 1) != st.getBooleansSortEntry()) // was not boolean sort
            {
                er.newSemanticError(SemanticError.FND001).add(ctx);
            }
        }

        // create then entry in the symbol table for the function.
        try {
            FunctionEntry f;
            try {
                f = st.createFunctionEntry(funName, signature, new Location(ctx));
            } catch (NameCollisionException ex) {
                er.newSemanticError(SemanticError.NAM004).add(fun_name).add(ex.getLocation());
                //this is a fatal error. 
                return;
            }
            if (fluentType) {
                f.setFluent();
            }
            if (staticType) {
                f.setStatic();
            }
            if (basicType) {
                f.setBasic();
            }
            if (definedType) {
                f.setDefined();
            }
            if (totalType) {
                f.setTotal();
            }

            // Rules for when dom_f is defined. All usert defined functions need some form
            // of this rule.
            ALMTerm domf = new ALMTerm(ALM.DOM_PREFIX + f.getFunctionName(), ALMTerm.FUN, fun_name);
            ALMTerm fun = new ALMTerm(f.getFunctionName(), ALMTerm.FUN, fun_name);

            int num_args = f.getSignature().size() - 1;
            for (int i = 0; i < num_args; i++) {
                ALMTerm argi = new ALMTerm("X" + i, ALMTerm.VAR);
                domf.addArg(argi);
                fun.addArg(argi);
                i++;
            }

            ALMTerm funRelation = new ALMTerm(ALM.SYMBOL_EQ, ALMTerm.TERM_RELATION);
            funRelation.addArg(fun);
            funRelation.addArg(new ALMTerm("Y", ALMTerm.VAR));

            List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();
            body.add(funRelation);

            if (fluentType) {
                if (basicType) {
                    ASPfRule r = aspf.newRule(ALM.AXIOMS_STATE_CONSTRAINTS_FLUENT, domf, body);
                    r.addComment("State Constraint for dom_f being positive when basic fluent function ["
                            + f.getFunctionName() + "] has a known definition.");
                }
                if (definedType) {
                    ASPfRule r = aspf.newRule(ALM.AXIOMS_DEFINITIONS_FLUENT, domf, body);
                    r.addComment("Definition for dom_f being positive when defined fluent function ["
                            + f.getFunctionName() + "] has a known definition.");
                }
            }
            if (staticType) {
                ASPfRule r = aspf.newRule(ALM.AXIOMS_DEFINITIONS_STATIC, domf, body);
                r.addComment("Definition for dom_f being positive when static function [" + f.getFunctionName()
                        + "] has a known definition.");
            }

            // TODO there are other axioms to add from the paper.
        } catch (DuplicateFunctionException e) {
            FunctionEntry prev_decl = e.getFunctionEntry();
            // All function signatures must be unique throughout the system
            // description.
            er.newSemanticError(SemanticError.FND008).add(ctx).add(prev_decl.getLocation());
        }

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterPos_fun_def(ALMParser.Pos_fun_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitPos_fun_def(ALMParser.Pos_fun_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterNeg_fun_def(ALMParser.Neg_fun_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitNeg_fun_def(ALMParser.Neg_fun_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterFun_def(ALMParser.Fun_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitFun_def(ALMParser.Fun_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterAxioms(ALMParser.AxiomsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitAxioms(ALMParser.AxiomsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterDynamic_causal_laws(ALMParser.Dynamic_causal_lawsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitDynamic_causal_laws(ALMParser.Dynamic_causal_lawsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterExecutability_conditions(ALMParser.Executability_conditionsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitExecutability_conditions(ALMParser.Executability_conditionsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterState_constraints(ALMParser.State_constraintsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitState_constraints(ALMParser.State_constraintsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterFunction_definitions(ALMParser.Function_definitionsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitFunction_definitions(ALMParser.Function_definitionsContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_dynamic_causal_law(ALMParser.One_dynamic_causal_lawContext ctx) {
    }

    private FunctionEntry getFunctionEntry(ALMTerm funTerm, int domSize, SymbolTable st, ErrorReport er) {
        Set<FunctionEntry> matching = st.getFunctionEntries(funTerm.getName(), domSize);
        if (matching.size() < 1) {
            er.newSemanticError(SemanticError.FND003).add(funTerm);
            return null;
        } else if (matching.size() > 1) {
            Iterator<FunctionEntry> funs = matching.iterator();
            er.newSemanticError(SemanticError.FND009).add(funTerm).add(funs.next()).add(funs.next());
            return null;
        }
        FunctionEntry match = matching.iterator().next();
        return match;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    // one_dynamic_causal_law: occurs_atom 'causes' pos_fun_def 'if'
    // instance_atom (',' literal)* '.'; //<dynamic_causal_law><body>
    @Override
    public void exitOne_dynamic_causal_law(ALMParser.One_dynamic_causal_lawContext ctx) {
        boolean error_occurred = false;

        // extract ANTLR4 pieces into ALMTerms
        ALMTerm occurs_atom = ALM.ParseOccursAtom(ctx.occurs_atom());
        ALMTerm pos_fun_def = ALM.ParsePosFunDef(ctx.pos_fun_def());
        ALMTerm instance_atom = ALM.ParseInstanceAtom(ctx.instance_atom());
        List<ALMTerm> literals = new ArrayList<ALMTerm>();
        for (LiteralContext lit : ctx.literal()) {
            literals.add(ALM.ParseLiteral(lit));
        }

        if (instance_atom == null) {
            er.newSemanticError(SemanticError.AXM012).add(ctx);
            return; // this is a fatal error. 
        }

        // occurs_atom and instance_atom must share the same variable or term.
        String occurs_text = occurs_atom.getArg(0).toString();
        String instance_text = instance_atom.getArg(0).toString();
        if (occurs_text.compareTo(instance_text) != 0) {
            er.newSemanticError(SemanticError.AXM010).add(occurs_atom).add(instance_atom);
            error_occurred = true;
        }

        // function cannot be special function and must be previously declared.
        FunctionEntry f;
        if (pos_fun_def.getType() == ALMTerm.TERM_RELATION) {
            ALMTerm funTerm = pos_fun_def.getArg(0);
            f = getFunctionEntry(funTerm, funTerm.getArgs().size(), st, er);
        } else {
            f = getFunctionEntry(pos_fun_def, pos_fun_def.getArgs().size(), st, er);
        }
        if (f != null) {
            if (f.isSpecial()) {
                er.newSemanticError(SemanticError.AXM003).add(pos_fun_def);
                error_occurred = true;
            }
        } else {
            er.newSemanticError(SemanticError.FND003).add(pos_fun_def);
            error_occurred = true;
        }

        // get sort entry for actions
        SortEntry actions_sort = st.getActionsSortEntry();

        // instance_atom's sort_name must be a subsort of actions;
        SortEntry inst_sort = null;
        try {
            inst_sort = st.getSortEntry(instance_atom.getArg(1).getName());
            if (!inst_sort.subsortof(actions_sort)) {
                SemanticError se = er.newSemanticError(SemanticError.AXM011);
                se.add(inst_sort.getLocation());
                se.add(occurs_atom.getLocation());
                se.add(instance_atom.getLocation());
                error_occurred = true;
            }
        } catch (SortNotFoundException e1) {
            er.newSemanticError(SemanticError.SPF001).add(instance_atom.getLocation());
            error_occurred = true;
        }

        // Verify remaining literals are semantically sound
        for (ALMTerm lit : literals) {
            if (literalHasSemanticErrors(lit)) {
                error_occurred = true;
            }
        }

        if (error_occurred) {
            return;
            //structural semantic errors supercede type checking semantic errors.
            //type checking expects well formed literals.  
        }

        // Need To Type Check Literals
        TypeChecker typeChecker = new TypeChecker(st, er);
        occurs_atom.typeCheck(typeChecker, st, er);
        instance_atom.typeCheck(typeChecker, st, er);
        for (ALMTerm lit : literals) {
            lit.typeCheck(typeChecker, st, er);
        }

        if (!typeChecker.typeCheckPasses(er)) {
            error_occurred = true;
        }

        if (!typeChecker.isActionsSubsort(occurs_atom.getArg(0))) {
            er.newSemanticError(SemanticError.SPF012).add(occurs_atom).add(instance_atom);
            error_occurred = true;
        }

        // create ASPfRule (time component will be added in translation to
        // SPARC)
        if (!error_occurred) {
            ASPfLiteral head = pos_fun_def;
            List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();
            body.addAll(literals);
            body.add(occurs_atom);
            body.add(instance_atom);
            aspf.newRule(ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS, head, body);
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_executability_condition(ALMParser.One_executability_conditionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    // one_executability_condition: 'impossible' occurs_atom 'if' instance_atom
    // ( ',' ( occurs_literal| literal))* '.';
    @Override
    public void exitOne_executability_condition(ALMParser.One_executability_conditionContext ctx) {
        boolean error_occurred = false;
        Occurs_atomContext occurs_atom = ctx.occurs_atom();
        Instance_atomContext instance_atom = ctx.instance_atom();
        List<LiteralContext> literals = ctx.literal();
        List<Occurs_literalContext> occurs_literals = ctx.occurs_literal();

        // convert occurs atom to ALMTerm
        ALMTerm occ_atom = ALM.ParseOccursAtom(occurs_atom);

        // convert instance atom to ALMTerm
        ALMTerm inst_atom = ALM.ParseInstanceAtom(instance_atom);

        // convert occurs literals to ALMTerms
        List<ALMTerm> occurs_lits = new ArrayList<ALMTerm>();
        for (Occurs_literalContext olc : occurs_literals) {
            occurs_lits.add(ALM.ParseOccursLiteral(olc));
        }

        // convert literals to ALMTerms
        List<ALMTerm> lits = new ArrayList<ALMTerm>();
        for (LiteralContext lit : literals) {
            lits.add(ALM.ParseLiteral(lit));
        }

        // SEMANTIC ERROR CHECKING
        // Argument of occurs must match instance_atom
        ALMTerm occ_arg = occ_atom.getArg(0);
        ALMTerm inst_arg = inst_atom.getArg(0);
        if (occ_arg.toString().compareTo(inst_arg.toString()) != 0) {
            er.newSemanticError(SemanticError.AXM010).add(occ_atom).add(inst_atom);
            error_occurred = true;
        }

        // get sort entry for actions
        SortEntry actions_sort = st.getActionsSortEntry();

        // instance_atom's sort_name must be a subsort of actions;
        SortEntry inst_sort = null;
        try {
            inst_sort = st.getSortEntry(inst_atom.getArg(1).getName());
            if (!inst_sort.subsortof(actions_sort)) {
                SemanticError se = er.newSemanticError(SemanticError.AXM011);
                se.add(inst_sort.getLocation());
                se.add(occurs_atom);
                se.add(instance_atom);
                error_occurred = true;
            }
        } catch (SortNotFoundException e1) {
            er.newSemanticError(SemanticError.SPF001).add(instance_atom);
            error_occurred = true;
        }

        // check remaining literals for semantic errors.
        for (ALMTerm lit : lits) {
            if (literalHasSemanticErrors(lit)) {
                error_occurred = true;
            }
        }

        if (error_occurred) {
            return;
            //structural semantic errors supercede type checking semantic errors.
            //type checking expects well formed literals.  
        }

        // TYPE CHECKING
        TypeChecker vtc = new TypeChecker(st, er);
        for (ALMTerm lit : lits) {
            lit.typeCheck(vtc, st, er);
        }
        for (ALMTerm occurs : occurs_lits) {
            occurs.typeCheck(vtc, st, er);
        }

        if (!vtc.typeCheckPasses(er)) {
            error_occurred = true;
        }

        if (!error_occurred) {
            // ADD RULE TO ASPfProgram
            // The ASPfRule has no head, all literals in the body.
            List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();
            body.add(occ_atom);
            body.add(inst_atom);
            for (ALMTerm occ_lit : occurs_lits) {
                body.add(occ_lit);
            }
            for (ALMTerm lit : lits) {
                body.add(lit);
            }

            ASPfRule r = aspf.newRule(ALM.AXIOMS_EXECUTABILITY_CONDITIONS, null, body);
            r.addComment("Executability Condition for when [" + occ_atom.getArg(0).getName()
                    + "] is impossible to execute.");
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_state_constraint(ALMParser.One_state_constraintContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    // one_state_constraint: fun_def '.' | ('false' | fun_def) 'if' literal (','
    // literal)* '.';
    @Override
    public void exitOne_state_constraint(ALMParser.One_state_constraintContext ctx) {
        boolean error_occurred = false;

        // get components
        Fun_defContext fun_def = ctx.fun_def();
        List<LiteralContext> literals = ctx.literal();

        // Parse fun_def to ALMTerm
        ALMTerm head = null;
        if (fun_def != null) // if absent, then state constraint models a logic
        // constraint (false at head)
        {
            head = ALM.ParseFunDef(fun_def);
        }

        // Parse literals to ALMTerms if literals exist
        List<ALMTerm> lits = null;
        if (literals != null) {
            lits = new ArrayList<ALMTerm>();
            for (LiteralContext lit : literals) {
                lits.add(ALM.ParseLiteral(lit));
            }
        }

        boolean moveRHStoBody = false;
        SortEntry rhsSort = null;

        // SEMANTIC ERROR CHECKING
        if (head != null) {
            // CHECK FORM OF HEAD LITERAL, either Term Relation or Function.
            ALMTerm headFunction = head;
            if (head.getType() == ALMTerm.TERM_RELATION) {
                headFunction = head.getArg(0);
            }

            FunctionEntry head_function = getFunctionEntry(headFunction, headFunction.getArgs().size(), st, er);
            // head function must be basic
            if (head_function != null) {
                if (!head_function.isAttribute()) {
                    if (!head_function.isBasic()) {
                        er.newSemanticError(SemanticError.AXM004).add(headFunction);
                        error_occurred = true;
                    }
                }

                List<SortEntry> sig = head_function.getSignature();
                // entity on right hand side must be variable or object constant of range sort
                // of function.
                ALMTerm oterm = head.getArg(1);
                if (oterm != null) {
                    if (!oterm.isVariable()) {
                        rhsSort = sig.get(sig.size() - 1);
                        boolean match = false;
                        for (ConstantEntry ce : rhsSort.getConstants()) {
                            match = ce.matches(oterm);
                        }
                        if (!match) {
                            moveRHStoBody = true;
//                            er.newSemanticError(SemanticError.AXM009).add(headFunction).add(oterm)
//                                    .add(sig.get(sig.size() - 1));
                        }
                    }
                }
            } else {
                er.newSemanticError(SemanticError.FND003).add(headFunction);
                error_occurred = true;
            }
        }

        //GENERAL SEMANTIC ERROR CHECKING
        for (ALMTerm lit : lits) {
            error_occurred = literalHasSemanticErrors(lit) || error_occurred;
        }

        if (error_occurred) {
            return;
            //structural semantic errors supercede type checking semantic errors.
            //type checking expects well formed literals.  
        }

        // Variable Type Checking
        TypeChecker vm = new TypeChecker(st, er);
        for (ALMTerm lit : lits) {
            lit.typeCheck(vm, st, er);
        }
        if (head != null) {
            head.typeCheck(vm, st, er);
        }

        if (!vm.typeCheckPasses(er)) {
            error_occurred = true;
        }

        if (!error_occurred) {

            // Construct ASPf Rule
            List<ASPfLiteral> body = null;
            if (literals != null) {
                body = new ArrayList<ASPfLiteral>();
                for (ALMTerm lit : lits) {
                    body.add(lit);
                }
            }

            if (moveRHStoBody) {
                ALMTerm rhs = head.getArg(1);
                String var = vm.newVariable("V", Type.getSortType(rhsSort));
                ALMTerm varTerm = new ALMTerm(var, ALMTerm.VAR, head.getLocation());
                head.getArgs().set(1, varTerm);
                ALMTerm termEq = new ALMTerm(ALM.SYMBOL_EQ, ALMTerm.TERM_RELATION, varTerm, rhs);
                body.add(termEq);
            }

            ASPfRule r = aspf.newRule(ALM.AXIOMS_STATE_CONSTRAINTS, head, body);
            if (head != null) {
                if (head.getType() == ALMTerm.FUN) {
                    r.addComment("State Constraint for function [" + head.getName() + "].");
                } else {
                    r.addComment("State Constraint for function [" + head.getArg(0).getName() + "].");
                }
            } else {
                r.addComment("State Constraint: This condition is impossible in all states.");
            }
        }

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_definition(ALMParser.One_definitionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    // one_definition: function_term '.' | function_term 'if' literal (','
    // literal)* '.';
    @Override
    public void exitOne_definition(ALMParser.One_definitionContext ctx) {
        boolean error_occurred = false;
        ALMTerm head = ALM.ParseALMTerm(ctx.function_term());
        if(head == null){
            return;
        }
        List<LiteralContext> literals = ctx.literal();
        List<ALMTerm> lits = new ArrayList<ALMTerm>();
        if (literals != null) {
            for (LiteralContext lit : literals) {
                ALMTerm parsedLit = ALM.ParseLiteral(lit);
                if(parsedLit == null){
                    return; //syntax error 
                }
                lits.add(parsedLit);
            }
        }

        // SPECIFIC SEMANTIC ERROR CHECKING
        boolean isStatic = false;
        // function must be defined
        FunctionEntry f1 = null;
        if (head.getType() == ALMTerm.TERM_RELATION) {
            ALMTerm headTerm = head.getArg(0);
            f1 = getFunctionEntry(headTerm, headTerm.getArgs().size(), st, er);
        } else {
            f1 = getFunctionEntry(head, head.getArgs().size(), st, er);
        }
        if (f1 != null) {
            if (!f1.isDefined()) {
                er.newSemanticError(SemanticError.AXM008).add(head);
                error_occurred = true;
            }
            if (f1.isStatic()) {
                isStatic = true;
            }
        } else {
            er.newSemanticError(SemanticError.FND003).add(head);
            error_occurred = true;
        }

        // if Function is static, all literals in body must be static.
        if (isStatic) {
            for (ALMTerm lit : lits) {
                if (lit.hasFluentFunction(st)) {
                    er.newSemanticError(SemanticError.AXM006).add(lit).add(head);
                    error_occurred = true;
                }
            }
        }

        //GENERAL SEMANTIC ERROR CHECKING
        for (ALMTerm lit : lits) {
            error_occurred = literalHasSemanticErrors(lit) || error_occurred;
        }

        if (error_occurred) {
            return;
            //structural semantic errors supercede type checking semantic errors.
            //type checking expects well formed literals.  
        }

        // VARIABLE TYPE CHECKING
        TypeChecker vm = new TypeChecker(st, er);
        for (ALMTerm lit : lits) {
            lit.typeCheck(vm, st, er);
        }
        head.typeCheck(vm, st, er);

        if (!vm.typeCheckPasses(er)) {
            error_occurred = true;
        }

        if (!error_occurred) {
            List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();
            for (ALMTerm lit : lits) {
                body.add(lit);
            }
            // CREATE RULE
            ASPfRule r = aspf.newRule(ALM.AXIOMS_DEFINITIONS, head, body);
            r.addComment("Definition for function [" + head.getName() + "].");
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterStructure_name(ALMParser.Structure_nameContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitStructure_name(ALMParser.Structure_nameContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterStructure(ALMParser.StructureContext ctx) {
        ALMTerm.setSymbolTable(st);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitStructure(ALMParser.StructureContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterConstant_defs(ALMParser.Constant_defsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitConstant_defs(ALMParser.Constant_defsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_constant_def(ALMParser.One_constant_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitOne_constant_def(ALMParser.One_constant_defContext ctx) {

        boolean error_occurred = false;
        Object_constantContext leftObjConstant = ctx.object_constant();
        TermContext rightTerm = ctx.term();

        ALMTerm obj_const = ALM.ParseALMTerm(leftObjConstant);
        ALMTerm objConstVal = ALM.ParseTerm(rightTerm);

        // object constant substitutions must be ground.  
        // The entity on the right must replace the occurrence of the ground term wherever applicable. 
        // The entity on the right must be added as a sort instance wherever the entity on the left occurs as one. 
        // The entity on the left must no longer exist as an instance to any of its source sorts.  
        // rules which match the abstract pattern of the constant on the left must now handle the instance on the right. 
        // All of this work needs to happen later, in the translation process.  There are still rules which may be 
        // processed in the structure which the substitution may apply to.  
        // What we need to do here is store the definition in the symbol table for later recall.  
        // type checking the ground constant instance must wait until the complete structure is parsed.
        if (!obj_const.isGround()) {
            error_occurred = true;
            er.newSemanticError(SemanticError.CDF003).add(obj_const);
        } else if (obj_const.getType() != ALMTerm.ID || obj_const.getArgs().size() > 0) {
            //Constant Definition in this version of ALM only supports simple constants. 
            er.newSemanticError(SemanticError.CDF006).add(obj_const);
        }

        if (!objConstVal.isGround()) {
            error_occurred = true;
            er.newSemanticError(SemanticError.CDF004).add(objConstVal);
        }

        if (!error_occurred) {
            ConstantEntry ce = st.getMatchingConstantEntry(obj_const);
            if (ce == null) {
                error_occurred = true;
                er.newSemanticError(SemanticError.CDF001).add(obj_const);
            } else {
                ALMTerm existing = st.getConstantDefinition(obj_const);
                if (existing == null) {
                    ConstantEntry check = st.getMatchingConstantEntry(objConstVal);
                    if (check != null) {
                        ALMTerm failCheck = st.getConstantDefinition(objConstVal);
                        if (failCheck != null) {
                            error_occurred = true;
                            er.newSemanticError(SemanticError.CDF002).add(obj_const).add(objConstVal).add(failCheck);
                        }
                    }
                    if (!error_occurred) {
                        st.defineConstant(obj_const, objConstVal);
                    }
                } else {
                    error_occurred = true;
                    er.newSemanticError(SemanticError.CDF005).add(obj_const).add(existing);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterInstance_defs(ALMParser.Instance_defsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitInstance_defs(ALMParser.Instance_defsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_instance_def(ALMParser.One_instance_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * GRAMMAR: one_instance_def: object_constant (',' object_constant)* 'in' sort_name (',' sort_name)* ('where'
     * literal (',' literal)* )? attribute_defs;//<one_instance_def> attribute_defs: (one_attribute_def)*;
     * one_attribute_def: function_term EQ term;
     *
     *
     */
    // one_instance_def: object_constant (',' object_constant)* 'in' 
    // sort_name (',' sort_name)* ('where' literal (',' literal)* )? attribute_defs;
    @Override
    public void exitOne_instance_def(ALMParser.One_instance_defContext ctx) {

        // pull out theses lists:
        // Instance Descriptions (Object Constants)
        // Sorts
        // Literals
        // Attribute Definitions
        List<ALMParser.Var_or_objContext> instances = ctx.var_or_obj();
        List<ALMParser.Sort_nameContext> sorts = ctx.sort_name();
        List<ALMParser.LiteralContext> literals = ctx.literal();
        List<ALMParser.One_attribute_defContext> attr_defs = null;
        if (ctx.attribute_defs() != null) {
            attr_defs = ctx.attribute_defs().one_attribute_def();
            if (sorts.size() > 1 && !attr_defs.isEmpty()) {
                er.newSemanticError(SemanticError.SID006).add(instances).add(sorts).add(attr_defs);
            }
        }

        // Turn list of sort_names into a list of SortEntries from the symbol table.
        List<SortEntry> sort_entries = new ArrayList<SortEntry>();
        for (ALMParser.Sort_nameContext sort : sorts) {
            String sort_text = sort.getText();
            if (st.isPredefinedSort(sort_text)) {
                er.newSemanticError(SemanticError.SID001).add(new Location(sort));
            } else {
                SortEntry se;
                try {
                    se = st.getSortEntry(sort.getText());
                    sort_entries.add(se);
                } catch (SortNotFoundException e) {
                    er.newSemanticError("SID002").add(new Location(sort));
                }
            }
        }

        boolean error_occurred = false;
        // Convert object_constants into a list of ALMTerms and check they
        // qualify as sort instances.
        // A sort instance is either a ground function term, or it is a schema, or a variable.
        // If it is a schema, the sort information about the variables will need
        // to be added
        // after parsing the rules. This will be handled later in the function.
        // object_constant: ID ( '(' term (',' term)* ')')?;
        List<ALMTerm> sort_instances = new ArrayList<ALMTerm>();
        for (ALMParser.Var_or_objContext inst : instances) {
            ALMTerm aterm = ALM.ParseALMTerm(inst);
            if (aterm == null) {
                er.newSemanticError(SemanticError.SID007).add(inst);
                continue;
            }
            Set<FunctionEntry> colliding = st.getFunctionEntries(aterm.getName());
            if (colliding.size() > 0) {
                er.newSemanticError(SemanticError.NAM003).add(aterm).add(colliding.iterator().next().getLocation());
                error_occurred = true;
            }
            if (aterm.isSchema()) {
                sort_instances.add(aterm);
            } else {
                er.newSemanticError("SID003").add(new Location(inst));
            }
        }

        // Convert literals into ALMTerms
        List<ALMTerm> lits = null;
        if (literals != null) {
            lits = new ArrayList<ALMTerm>();
            for (ALMParser.LiteralContext literal : literals) {
                lits.add(ALM.ParseLiteral(literal));
            }
        }

        // Convert Attribute Definitions into ALMTerms for term relations.
        List<ALMTerm> attribute_defs = new ArrayList<ALMTerm>();
        if (attr_defs != null) {
            for (One_attribute_defContext attr_def : attr_defs) {
                attribute_defs.add(ALM.ParseAttrDef(attr_def));
            }
        }

        //GENERAL SEMANTIC ERROR CHECKING
        for (ALMTerm lit : lits) {
            error_occurred = literalHasSemanticErrors(lit) || error_occurred;
        }

        if (error_occurred) {
            return;
            //structural semantic errors supercede type checking semantic errors.
            //type checking expects well formed literals.  
        }

        // TypeCheck ALMTerms and verify that attribute definitions are actual attributes for the sort. 
        TypeChecker tc = new TypeChecker(st, er);
        for (ALMTerm si : sort_instances) {
            si.registerVariablesWith(tc);
        }
        for (ASPfLiteral lit : lits) {
            lit.typeCheck(tc, st, er);
        }
        for (ALMTerm adef : attribute_defs) {
            //for each attribute definition
            //type check the attribute function. 
            if (adef.getArg(1).isVariable()) {
                //TODO  THIS IS A TEMPORARY "FIX", DELETE CONTAINING IF ONCE HERBRAND TERMS ARE ADDED. 
                adef.typeCheck(tc, st, er);
            }
            ALMTerm range = adef.getArg(1);
            ALMTerm attr = adef.getArg(0);
            String attr_name = attr.getName();
            List<ALMTerm> attr_params = attr.getArgs();
            int param_count = 0;
            if (attr_params != null) {
                param_count = attr_params.size();
            }
            //verify attribute function belongs to the sorts the instance is compatible with.
            for (SortEntry s : sort_entries) {
                //for each sort the instance is declared to belong to.
                for (FunctionEntry attr_fun : s.getAttributes()) {
                    //for each attribute function of the sort. 
                    if (attr_fun.getFunctionName().compareTo(attr_name) == 0) {
                        // matching attribute function found.
                        List<SortEntry> sig = attr_fun.getSignature();
                        if (param_count + 2 != sig.size()) {
                            //this error may not be accurate if its possible for a sort to have two attributes
                            //of the same name but different arguments.  
                            er.newSemanticError("SID005").add(attr.getLocation()).add(attr_fun.getLocation());
                            continue;
                        }
                    }
                }
            }

        }

        // If Type Check passes, add sort instance declaration or make subsort.
        if (tc.typeCheckPasses(er)) {
            // Register Instances With SortEntries in st
            for (SortEntry se : sort_entries) {
                for (ALMTerm si : sort_instances) {
                    if (si.isVariable()) {
                        //The type of the variable needs to be added as a subsort. 
                        //TODO VERIFY THIS IS THE RIGHT THING TO DO.  
                        SortType type = tc.getNarrowestSortType(si);
                        if (type.isSingleton()) {
                            se.addChildSort(type.getSingleton());
                        } else {
                            for (SortEntry child : type.getSortEntries()) {
                                se.addChildSort(child);
                            }
                        }
                        //TODO VERIFY THIS IS THE RIGHT THING TO DO.  
                    } else {
                        try {
                            st.createSortInstanceEntry(se, si);
                        } catch (NameCollisionException ex) {
                            er.newSemanticError(SemanticError.NAM003).add(si).add(ex.getLocation());
                            error_occurred = true;
                        }
                    }
                }
            }
        }

        if (error_occurred) {
            return;
        }

        // body
        List<ASPfLiteral> body = null;
        if (lits != null) {
            body = new ArrayList<ASPfLiteral>();
            for (ALMTerm lit : lits) {
                body.add(lit);
            }
        }

        // Create ASPfRules for Sort Instances and Attribute Definitions
        // one_instance_def: object_constant (',' object_constant)* 'in'
        // sort_name (',' sort_name)* ('where' literal (',' literal)* )?
        // attribute_defs;
        for (ALMTerm obj_const : sort_instances) {
            for (SortEntry sort_entry : sort_entries) {

                // head
                ALMTerm is_a_head = null;
                // If the sort is a source sort add is_a otherwise add instance
                Set<SortEntry> childSorts = sort_entry.getChildSorts();
//                if (childSorts.size() != 0) {
//                    //declaring instances for non-source sorts (leaves) is not supported in this version of ALM. 
//                    er.newSemanticError(SemanticError.SID002).add(obj_const).add(sort_entry);
//                }

                is_a_head = new ALMTerm(ALM.SPECIAL_FUNCTION_IS_A, ALMTerm.FUN);

                is_a_head.addArg(obj_const);
                is_a_head.addArg(new ALMTerm(sort_entry.getSortName(), ALMTerm.ID,
                        sort_entry.getLocation().getParserRuleContext()));

                ASPfRule r = aspf.newRule(ALM.STRUCTURE_SORT_INSTANCES, is_a_head, body);
                r.addComment("Sort Instance [" + obj_const + "] for sort [" + sort_entry + "].");

                // Create ASPfRules for Attribute Definitions.
                // Need forloop over attribute definitions.
                for (ALMTerm attr_def : attribute_defs) {
                    // The instance(X, sort) declarations need to be added to the body for the domain and range of
                    // every attribute definition.  Multiple rules are created using the same body and will receive
                    // the instance declarations for variables as they are added to the common body.
                    ALMTerm attr_fun = attr_def.getArg(0);
                    ALMTerm attr_term = attr_def.getArg(1);
                    List<ALMTerm> funArgs = attr_fun.getArgs();
                    int dom_size = funArgs.size() + 1; //missing sort argument to function. 

                    //determine matching function. If no matching function can be found, skip.   
                    Set<FunctionEntry> funs = st.getFunctionEntries(attr_fun.getName(), dom_size);
                    if (funs.size() < 1) {
                        continue;
                    } else if (funs.size() > 1) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Parsing Atrribute Definitions",
                                "Function overloading is not supported in this version of ALM.");
                    }

                    //instance(X, sort) for attribute arguments. 
                    FunctionEntry fun = funs.iterator().next();
                    List<SortEntry> sig = fun.getSignature();
                    for (int i = 1; i < dom_size; i++) {
                        ALMTerm instanceOf = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
                        instanceOf.addArg(funArgs.get(i - 1));
                        instanceOf.addArg(new ALMTerm(sig.get(i).getSortName(), ALMTerm.ID));
                        body.add(instanceOf);
                    }

//                    //DISABLED UNTIL HERBRAND TERM ADDED AS FIRST CLASS CONSTRUCT TO SYMBOL TABLE. 
//                    //instance(X, sort) for attribtue range
//                    ALMTerm rangeInstanceOf = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
//                    rangeInstanceOf.addArg(attr_term);
//                    rangeInstanceOf.addArg(new ALMTerm(sig.get(dom_size).getSortName(), ALMTerm.ID));
//                    body.add(rangeInstanceOf);
                    //need to create attribute definition rule.
                    //This is the new function to use. 
                    ALMTerm new_fun = new ALMTerm(attr_fun.getName(), ALMTerm.FUN, attr_def.getLocation());
                    new_fun.addArg(obj_const);
                    if (attr_fun.getArgs() != null) {
                        for (ALMTerm arg : attr_fun.getArgs()) {
                            new_fun.addArg(arg);
                        }
                    }

                    ALMTerm ad_head = null;
                    List<ASPfLiteral> ad_body = new ArrayList<ASPfLiteral>();
                    //check if range is boolean or non-booleans. 
                    if (fun.isBoolean()) {
                        boolean sign = false;
                        if (attr_term.getName().equals(ALM.BOOLEAN_TRUE)) {
                            sign = true;
                        } else if (!attr_term.getName().equals(ALM.BOOLEAN_FALSE)) {
                            ALMCompiler.IMPLEMENTATION_FAILURE("Attribute Definition in Sort Definition", "This should be caught by earlier semantic error.");
                        }

                        ad_head = new_fun;
                        if (!sign) {
                            ad_head.setSign(ALMTerm.SIGN_NEG);
                        }
                    } else {
                        // Construct a new variable for the function to equal.
                        String new_var_base = attr_fun.getName().substring(0, 1).toUpperCase() + "_";
                        ALMTerm new_var = new ALMTerm(tc.newVariable(new_var_base, Type.ANY_TYPE), ALMTerm.VAR, attr_def.getLocation());
                        ad_head = new ALMTerm(ALM.SYMBOL_EQ, ALMTerm.TERM_RELATION, attr_def.getLocation());
                        ad_head.addArg(new_fun);
                        ad_head.addArg(new_var);

                        ALMTerm term_relation = new ALMTerm(ALM.SYMBOL_EQ, ALMTerm.TERM_RELATION, attr_def.getLocation());
                        term_relation.addArg(new_var);
                        term_relation.addArg(attr_term);
                        ad_body.add(term_relation);
                    }

                    // add new term relation to body for variable.
                    ad_body.addAll(body);

                    ASPfRule ar = aspf.newRule(ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS, ad_head, ad_body);
                    ar.addComment("Definition of attribute [" + attr_def.getArg(0).getName() + "] for instance ["
                            + obj_const.toString() + "] of sort [" + sort_entry.getSortName() + "].");

                }
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterAttribute_defs(ALMParser.Attribute_defsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitAttribute_defs(ALMParser.Attribute_defsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_attribute_def(ALMParser.One_attribute_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitOne_attribute_def(ALMParser.One_attribute_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterStatics_defs(ALMParser.Statics_defsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitStatics_defs(ALMParser.Statics_defsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterOne_static_def(ALMParser.One_static_defContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    // one_static_def: fun_def ('if' literal (',' literal)*)? '.';
    @Override
    public void exitOne_static_def(ALMParser.One_static_defContext ctx) {

        // get head literal
        ALMTerm head = ALM.ParseFunDef(ctx.fun_def());
        List<ASPfLiteral> body = new ArrayList<>();
        List<ALMTerm> lits = null;
        List<LiteralContext> literals = ctx.literal();

        // TypeCheck ALMTerms and verify that attribute definitions are actual attributes for the sort. 
        TypeChecker tc = new TypeChecker(st, er);

        if (literals != null && literals.size() > 0) {
            lits = new ArrayList<>();
            for (LiteralContext lit : literals) {
                lits.add(ALM.ParseLiteral(lit));
            }

            boolean error_occurred = false;
            //GENERAL SEMANTIC ERROR CHECKING
            for (ALMTerm lit : lits) {
                error_occurred = literalHasSemanticErrors(lit) || error_occurred;
            }

            if (error_occurred) {
                return;
                //structural semantic errors supercede type checking semantic errors.
                //type checking expects well formed literals.  
            }

            for (ASPfLiteral lit : lits) {
                lit.typeCheck(tc, st, er);
                body.add(lit);
            }
        } else // type checking
        {
            head.typeCheck(tc, st, er);
        }

        if (!tc.typeCheckPasses(er)) {
            return;
        }

        aspf.newRule(ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS, head, body);

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {
        // THIS IS NOT WHERE TO CAPTURE SYNTAX ERRORS

        // USE ANTLRErrorListener given to the parser before parsing.
        // ER.newSyntaxError(node);
    }

    private boolean literalHasSemanticErrors(ALMTerm lit) {
        boolean error_occurred = false;
        String type = lit.getType();
        String name = lit.getName();
        List<ALMTerm> args = lit.getArgs();
        ALMTerm arg0;
        ALMTerm arg1;
        switch (type) {
            case ALMTerm.TERM_RELATION:
                arg0 = args.get(0);
                error_occurred = termHasSemanticErrors(arg0) || error_occurred;
                arg1 = args.get(1);
                error_occurred = termHasSemanticErrors(arg1) || error_occurred;
                break;
            case ALMTerm.FUN:
                // TODO: Massive Amount Of Work Here...
                switch (name) {
                    case ALM.SPECIAL_FUNCTION_INSTANCE:
                        if (args.size() == 2) {
                            arg0 = args.get(0);
                            error_occurred = termHasSemanticErrors(arg0) || error_occurred;
                            arg1 = args.get(1);
                            try {
                                SortEntry se = st.getSortEntry(arg1.getName());
                            } catch (SortNotFoundException ex) {
                                error_occurred = true;
                                er.newSemanticError(SemanticError.SPF001).add(lit);
                            }
                        } else {
                            er.newSemanticError(SemanticError.SPF013).add(lit);
                            error_occurred = true;
                        }
                        break;
                    case ALM.SPECIAL_FUNCTION_IS_A:
                        arg0 = args.get(0);
                        arg1 = args.get(1);
                        error_occurred = termHasSemanticErrors(arg0) || error_occurred;
                        try {
                            SortEntry se = st.getSortEntry(arg1.getName());
                        } catch (SortNotFoundException ex) {
                            error_occurred = true;
                            er.newSemanticError(SemanticError.SPF005).add(lit);
                        }
                        break;
                    case ALM.SPECIAL_FUNCTION_HAS_CHILD:
                        arg0 = args.get(0);
                        try {
                            SortEntry se = st.getSortEntry(arg0.getName());
                        } catch (SortNotFoundException ex) {
                            error_occurred = true;
                            er.newSemanticError(SemanticError.SPF007).add(lit);
                        }
                        break;
                    case ALM.SPECIAL_FUNCTION_HAS_PARENT:
                        arg0 = args.get(0);
                        try {
                            SortEntry se = st.getSortEntry(arg0.getName());
                        } catch (SortNotFoundException ex) {
                            error_occurred = true;
                            er.newSemanticError(SemanticError.SPF008).add(lit);
                        }
                        break;
                    case ALM.SPECIAL_FUNCTION_LINK:
                        arg0 = args.get(0);
                        arg1 = args.get(1);
                        try {
                            SortEntry se0 = st.getSortEntry(arg1.getName());
                            SortEntry se1 = st.getSortEntry(arg1.getName());
                        } catch (SortNotFoundException ex) {
                            error_occurred = true;
                            er.newSemanticError(SemanticError.SPF003).add(lit);
                        }
                        break;
                    case ALM.SPECIAL_FUNCTION_SINK:
                        arg0 = args.get(0);
                        try {
                            SortEntry se = st.getSortEntry(arg0.getName());
                        } catch (SortNotFoundException ex) {
                            error_occurred = true;
                            er.newSemanticError(SemanticError.SPF009).add(lit);
                        }
                        break;
                    case ALM.SPECIAL_FUNCTION_SOURCE:
                        arg0 = args.get(0);
                        try {
                            SortEntry se = st.getSortEntry(arg0.getName());
                        } catch (SortNotFoundException ex) {
                            error_occurred = true;
                            er.newSemanticError(SemanticError.SPF010).add(lit);
                        }
                        break;
                    case ALM.SPECIAL_FUNCTION_SUBSORT:
                        arg0 = args.get(0);
                        arg1 = args.get(1);
                        try {
                            SortEntry se0 = st.getSortEntry(arg1.getName());
                            SortEntry se1 = st.getSortEntry(arg1.getName());
                        } catch (SortNotFoundException ex) {
                            error_occurred = true;
                            er.newSemanticError(SemanticError.SPF006).add(lit);
                        }
                        break;
                    default:
                        //Check that the function is in the symbol table and is a boolean function. 
                        FunctionEntry fun = st.getFunctionEntry(name, args.size());
                        if (fun != null) {
                            if (fun instanceof DOMFunctionEntry || fun.getRangeSort() == st.getBooleansSortEntry()) {
                                //check the term arguments for semantic errors. 
                                for (ALMTerm arg : args) {
                                    if (termHasSemanticErrors(arg)) {
                                        error_occurred = true;
                                    }
                                }
                            } else {
                                er.newSemanticError(SemanticError.FND010).add(lit);
                                error_occurred = true;
                            }
                        } else {
                            er.newSemanticError(SemanticError.FND003).add(lit);
                            error_occurred = true;
                        }
                }
                break;
            default:
                for (ALMTerm arg : args) {
                    error_occurred = termHasSemanticErrors(arg) || error_occurred;
                }

                // Nothing Else Should Occur As Literal
                ALMCompiler.IMPLEMENTATION_FAILURE("Semantic Check Of Literals",
                        "ALMTerm [" + lit.toString() + "] is not a literal");
        }
        return error_occurred;
    }

    public boolean termHasSemanticErrors(ALMTerm term) {
        boolean error_occurred = false;
        String type = term.getType();
        String name = term.getName();
        List<ALMTerm> args = term.getArgs();
        int numArgs = args.size();
        Set<ConstantEntry> matchingConstants = null;
        Set<FunctionEntry> functions = null;
        SortInstanceEntry sie = null;
        boolean inSymbolTable = false;
        for (ALMTerm arg : args) {
            error_occurred = termHasSemanticErrors(arg) || error_occurred;
        }
        switch (type) {
            case ALMTerm.ID:
                //these are either constants or no-argument functions.  Just verify exists in symbol table. 
                matchingConstants = st.getConstantEntries(name, 0);
                if (matchingConstants.size() > 0) {
                    inSymbolTable = true;
                }
                if (!inSymbolTable) {
                    sie = st.getSortInstanceEntry(term.getName(), 0);
                    if (sie != null) {
                        inSymbolTable = true;
                    }
                }
                if (!inSymbolTable) {
                    functions = st.getFunctionEntries(name, 0);
                    for (FunctionEntry f : functions) {
                        if (f.getSignature().size() == 1) {
                            inSymbolTable = true;
                        }
                    }
                }
                if (!inSymbolTable) {
                    er.newSemanticError(SemanticError.CND008).add(term);
                    error_occurred = true;
                }
                break;
            case ALMTerm.INT:
                break;
            case ALMTerm.FUN:
                //these are either constants or no-argument functions.  Just verify exists in symbol table. 
                matchingConstants = st.getConstantEntries(name, numArgs);
                if (matchingConstants.size() > 0) {
                    inSymbolTable = true;
                }
                if (!inSymbolTable) {
                    sie = st.getSortInstanceEntry(term.getName(), numArgs);
                    if (sie != null) {
                        inSymbolTable = true;
                    }
                }
                if (!inSymbolTable) {
                    functions = st.getFunctionEntries(name, numArgs);
                    if (!functions.isEmpty()) {
                        inSymbolTable = true;
                    }
                }
                if (!inSymbolTable) {
                    er.newSemanticError(SemanticError.CND008).add(term);
                    error_occurred = true;
                } else {
                    for (ALMTerm arg : args) {
                        if (termHasSemanticErrors(arg)) {
                            error_occurred = true;
                        }
                    }
                }
                break;
            case ALMTerm.VAR:
                break;
        }
        return error_occurred;
    }

    @Override
    public void enterSolver_mode(Solver_modeContext ctx) {
        st.setModeActive(ALM.SOLVER_MODE, true);
    }

    @Override
    public void exitSolver_mode(Solver_modeContext ctx) {
    }

    @Override
    public void enterTemporal_projection(Temporal_projectionContext ctx) {
        st.setModeActive(ALM.SOLVER_MODE_TP, true);
    }

    @Override
    public void exitTemporal_projection(Temporal_projectionContext ctx) {
    }

    @Override
    public void enterMax_steps(Max_stepsContext ctx) {
    }

    @Override
    public void exitMax_steps(Max_stepsContext ctx) {
        TerminalNode max = ctx.POSINT();
        if (max != null) {
            st.setMaxSteps(Integer.parseInt(max.getText()));
        }

    }

    @Override
    public void enterHistory(HistoryContext ctx) {
        st.setModeActive(ALM.HISTORY, true);
    }

    @Override
    public void exitHistory(HistoryContext ctx) {
        aspf.createSection(ALM.HISTORY);
    }

    @Override
    public void enterObserved(ObservedContext ctx) {
    }

    @Override
    public void exitObserved(ObservedContext ctx) {
        if (er.hasErrors()) {
            return; //cannot process history until BAT is sound.
        }
        ALMTerm f = ALM.ParseALMTerm(ctx.function_term());
        ALMTerm t = ALM.ParseTerm(ctx.term());
        int i = Integer.parseInt(ctx.nat_num().getText());

        st.addHistoryTimeStep(i);

        ALMTerm observed = new ALMTerm(ALM.HISTORY_OBSERVED, ALMTerm.FUN);
        observed.addArg(f);
        observed.addArg(t);
        observed.addArg(new ALMTerm(Integer.toString(i), ALMTerm.INT));

        FunctionEntry f_ent = getFunctionEntry(f, f.getArgs().size(), st, er);
        if (f_ent != null) {
            if (f_ent.isFluent()) {
                if (st.isTimeStep(i)) {
                    aspf.newRule(ALM.HISTORY, observed, null);
                } else {
                    // TODO record semantic error
                    ALMCompiler.IMPLEMENTATION_FAILURE("Parsing History",
                            "observed time step is out of bounds, semantic error not implemented yet.");
                }
            } else {
                // TODO record semantic error
                ALMCompiler.IMPLEMENTATION_FAILURE("Parsing History",
                        "observed function not fluent, semantic error not implemented yet.");
            }
        } else {
            // TODO record semantic error.
            ALMCompiler.IMPLEMENTATION_FAILURE("Parsing History",
                    "function not recognized, semantic error not implemented yet.");

        }
    }

    @Override
    public void enterHappened(HappenedContext ctx) {
    }

    @Override
    public void exitHappened(HappenedContext ctx) {
        if (er.hasErrors()) {
            return; //cannot process history until BAT is sound.
        }
        ALMTerm a = ALM.ParseALMTerm(ctx.object_constant());
        int i = Integer.parseInt(ctx.nat_num().getText());

        st.addHistoryTimeStep(i);

        ALMTerm happened = new ALMTerm(ALM.HISTORY_HAPPENED, ALMTerm.FUN);
        happened.addArg(a);
        happened.addArg(new ALMTerm(Integer.toString(i), ALMTerm.INT));

        if (true) { //st.isAction(a) -- need to check but this hasn't been implemented yet. 
            if (st.isTimeStep(i)) {
                aspf.newRule(ALM.HISTORY, happened, null);
            } else {
                // TODO record semantic error.
                ALMCompiler.IMPLEMENTATION_FAILURE("Parsing History",
                        "timeStep is out of bounds, semantic error not implemented yet.");
            }
        } else {
            // TODO record semantic error.
            ALMCompiler.IMPLEMENTATION_FAILURE("Parsing History",
                    "action not recognized, semantic error not implemented yet.");
        }

    }

    @Override
    public void enterNat_num(Nat_numContext ctx) {
    }

    @Override
    public void exitNat_num(Nat_numContext ctx) {
    }

    @Override
    public void enterModule_dependencies(Module_dependenciesContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitModule_dependencies(Module_dependenciesContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_dependency(One_dependencyContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_dependency(One_dependencyContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterId(IdContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitId(IdContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterBool(BoolContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitBool(BoolContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_action_condition(One_action_conditionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_action_condition(One_action_conditionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_added_constraint(One_added_constraintContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_added_constraint(One_added_constraintContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterAdded_constraints(Added_constraintsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitAdded_constraints(Added_constraintsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterPlanning_problem(Planning_problemContext ctx) {
        st.setModeActive(ALM.SOLVER_MODE_PP, true);

    }

    @Override
    public void exitPlanning_problem(Planning_problemContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterGoal_state(Goal_stateContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitGoal_state(Goal_stateContext ctx) {
        List<ALMParser.LiteralContext> literals = ctx.literal();
        if (literals.size() == 0) {
            //no conditions, return from function. 
            return;
        }

        SortEntry booleans = st.getBooleansSortEntry();
        List<SortEntry> sig = new ArrayList<>();
        sig.add(booleans);

        //create goal function. 
        FunctionEntry goal;
        try {
            //create defined fluent function which is true when goal state reached.
            goal = st.createFunctionEntry(ALM.SPECIAL_FUNCTION_PLANNING_PROBLEM_GOAL, sig, new Location(ctx.GOAL()));
            goal.setDefined();
            goal.setFluent();
        } catch (DuplicateFunctionException | NameCollisionException ex) {
            ALMCompiler.IMPLEMENTATION_FAILURE("planning problem", "Assumed unique function name for goal state is already declared.");
            return;
        }

        //create success function. 
        FunctionEntry success;
        try {
            //create defined static function which is true if goal state is ever true.
            success = st.createFunctionEntry(ALM.SPECIAL_FUNCTION_PLANNING_PROBLEM_SUCCESS, sig, new Location(ctx.GOAL()));
            success.setDefined();
            success.setStatic();
        } catch (DuplicateFunctionException | NameCollisionException ex) {
            ALMCompiler.IMPLEMENTATION_FAILURE("planning problem", "Assumed unique function name for success state is already declared.");
            return;
        }

        //create something happened function. 
        FunctionEntry something_happened;
        try {
            //defined fluent to indicate action occurred. 
            something_happened = st.createFunctionEntry(ALM.SPECIAL_FUNCTION_PLANNING_PROBLEM_SOMETHING_HAPPENED, sig, new Location(ctx.GOAL()));
            something_happened.setDefined();
            something_happened.setFluent();
        } catch (DuplicateFunctionException | NameCollisionException ex) {
            ALMCompiler.IMPLEMENTATION_FAILURE("planning problem", "Assumed unique function name for something_happened is already declared.");
            return;
        }

        // Convert literals into ALMTerms
        List<ALMTerm> lits = new ArrayList<>();
        for (ALMParser.LiteralContext literal : literals) {
            lits.add(ALM.ParseLiteral(literal));
        }

        boolean error_occurred = false;

        //Type Check Literals
        TypeChecker tc = new TypeChecker(st, er);
        for (ALMTerm lit : lits) {
            if (literalHasSemanticErrors(lit)) {
                error_occurred = true;
            }
            lit.typeCheck(tc, st, er);
        }

        //Verify Type Check Passes.
        if (!tc.typeCheckPasses(er) || error_occurred) {
            //cannot proceed if errors.
            return;
        }

        // body
        List<ASPfLiteral> goal_body = new ArrayList<>();
        for (ALMTerm lit : lits) {
            goal_body.add(lit);
        }

        /**
         * START: goal(TS) :- { literals }
         */
        //goal_head
        ASPfLiteral goal_head = new ALMTerm(goal.getFunctionName(), ALMTerm.FUN, goal.getLocation());

        //rule indicating goal condition is reached in current state. 
        ASPfRule goal_ar = aspf.newRule(ALM.SOLVER_MODE_PP, goal_head, goal_body);
        goal_ar.addComment("Goal conditions for planning problem: goal = {literals}");
        /**
         * END: goal(TS) :- { literals }
         */

        //The additional rules are created in the translation to the final SPARC program. 
    }

    @Override
    public void enterNormal_conditions(Normal_conditionsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitNormal_conditions(Normal_conditionsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterAction_conditions(Action_conditionsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitAction_conditions(Action_conditionsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterCurrent_state(Current_stateContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitCurrent_state(Current_stateContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_normal_condition(One_normal_conditionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_normal_condition(One_normal_conditionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterDiagnostic_problem(Diagnostic_problemContext ctx) {
        st.setModeActive(ALM.SOLVER_MODE_DP, true);

    }

    @Override
    public void exitDiagnostic_problem(Diagnostic_problemContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterAlm_file(ALMParser.Alm_fileContext ctx) {
    }

    @Override
    public void exitAlm_file(ALMParser.Alm_fileContext ctx) {
    }

    @Override
    public void enterCurrent_time(ALMParser.Current_timeContext ctx) {
    }

    @Override
    public void exitCurrent_time(ALMParser.Current_timeContext ctx) {
        st.setCurrentTime(Integer.parseInt(ctx.nat_num().getText()));
    }

    @Override
    public void enterNew_sort_name(ALMParser.New_sort_nameContext ctx) {
    }

    @Override
    public void exitNew_sort_name(ALMParser.New_sort_nameContext ctx) {
    }

}
