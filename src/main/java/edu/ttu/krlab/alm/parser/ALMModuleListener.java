package edu.ttu.krlab.alm.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.ALMModuleManager;
import edu.ttu.krlab.alm.DuplicateModuleException;
import edu.ttu.krlab.alm.parser.ALMParser.Action_conditionsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Added_constraintsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Alm_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Arithmetic_termContext;
import edu.ttu.krlab.alm.parser.ALMParser.AtomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Attribute_defsContext;
import edu.ttu.krlab.alm.parser.ALMParser.AttributesContext;
import edu.ttu.krlab.alm.parser.ALMParser.AxiomsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Basic_function_declarationsContext;
import edu.ttu.krlab.alm.parser.ALMParser.BoolContext;
import edu.ttu.krlab.alm.parser.ALMParser.Constant_declarationsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Constant_defsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Current_stateContext;
import edu.ttu.krlab.alm.parser.ALMParser.Defined_function_declarationsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Diagnostic_problemContext;
import edu.ttu.krlab.alm.parser.ALMParser.Dynamic_causal_lawsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Executability_conditionsContext;
import edu.ttu.krlab.alm.parser.ALMParser.ExpressionContext;
import edu.ttu.krlab.alm.parser.ALMParser.FactorContext;
import edu.ttu.krlab.alm.parser.ALMParser.Fluent_declarationsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Fun_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Function_declarationsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Function_definitionsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Function_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Function_termContext;
import edu.ttu.krlab.alm.parser.ALMParser.Goal_stateContext;
import edu.ttu.krlab.alm.parser.ALMParser.HappenedContext;
import edu.ttu.krlab.alm.parser.ALMParser.Has_child_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Has_parent_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.HistoryContext;
import edu.ttu.krlab.alm.parser.ALMParser.IdContext;
import edu.ttu.krlab.alm.parser.ALMParser.Instance_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Instance_defsContext;
import edu.ttu.krlab.alm.parser.ALMParser.IntegerContext;
import edu.ttu.krlab.alm.parser.ALMParser.Integer_rangeContext;
import edu.ttu.krlab.alm.parser.ALMParser.Is_a_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Library_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Link_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.LiteralContext;
import edu.ttu.krlab.alm.parser.ALMParser.Max_stepsContext;
import edu.ttu.krlab.alm.parser.ALMParser.ModuleContext;
import edu.ttu.krlab.alm.parser.ALMParser.Module_bodyContext;
import edu.ttu.krlab.alm.parser.ALMParser.Module_dependenciesContext;
import edu.ttu.krlab.alm.parser.ALMParser.Module_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Nat_numContext;
import edu.ttu.krlab.alm.parser.ALMParser.Neg_fun_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Normal_conditionsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Object_constantContext;
import edu.ttu.krlab.alm.parser.ALMParser.ObservedContext;
import edu.ttu.krlab.alm.parser.ALMParser.Occurs_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Occurs_literalContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_action_conditionContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_added_constraintContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_attribute_declContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_attribute_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_constant_declContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_constant_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_definitionContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_dependencyContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_dynamic_causal_lawContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_executability_conditionContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_function_declContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_instance_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_normal_conditionContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_sort_declContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_state_constraintContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_static_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Planning_problemContext;
import edu.ttu.krlab.alm.parser.ALMParser.Pos_fun_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Predefined_sortsContext;
import edu.ttu.krlab.alm.parser.ALMParser.RelationContext;
import edu.ttu.krlab.alm.parser.ALMParser.Sequence_of_modulesContext;
import edu.ttu.krlab.alm.parser.ALMParser.Sink_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Solver_modeContext;
import edu.ttu.krlab.alm.parser.ALMParser.Sort_declarationsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Sort_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Source_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.State_constraintsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Static_declarationsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Statics_defsContext;
import edu.ttu.krlab.alm.parser.ALMParser.StructureContext;
import edu.ttu.krlab.alm.parser.ALMParser.Structure_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Subsort_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Sys_desc_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.System_descriptionContext;
import edu.ttu.krlab.alm.parser.ALMParser.Temporal_projectionContext;
import edu.ttu.krlab.alm.parser.ALMParser.TermContext;
import edu.ttu.krlab.alm.parser.ALMParser.TheoryContext;
import edu.ttu.krlab.alm.parser.ALMParser.Theory_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Var_or_objContext;

public class ALMModuleListener implements ALMListener {

    ALMModuleManager amm;
    String currentTheoryName = null;
    String currentModuleName = null;
    String moduleDependency = null;
    boolean insideModule = false;
    boolean firstModuleName = true;

    public ALMModuleListener(ALMModuleManager amm) {
        this.amm = amm;
    }

    @Override
    public void enterEveryRule(ParserRuleContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitEveryRule(ParserRuleContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitTerminal(TerminalNode arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterNat_num(Nat_numContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitNat_num(Nat_numContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterInteger(IntegerContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitInteger(IntegerContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterRelation(RelationContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitRelation(RelationContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterAlm_name(Alm_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitAlm_name(Alm_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterObject_constant(Object_constantContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitObject_constant(Object_constantContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterFunction_term(Function_termContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitFunction_term(Function_termContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterTerm(TermContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitTerm(TermContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterVar_or_obj(Var_or_objContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitVar_or_obj(Var_or_objContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterExpression(ExpressionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitExpression(ExpressionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterArithmetic_term(Arithmetic_termContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitArithmetic_term(Arithmetic_termContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterFactor(FactorContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitFactor(FactorContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOccurs_atom(Occurs_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOccurs_atom(Occurs_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterInstance_atom(Instance_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitInstance_atom(Instance_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterIs_a_atom(Is_a_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitIs_a_atom(Is_a_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterLink_atom(Link_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitLink_atom(Link_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterSubsort_atom(Subsort_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSubsort_atom(Subsort_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterHas_child_atom(Has_child_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitHas_child_atom(Has_child_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterHas_parent_atom(Has_parent_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitHas_parent_atom(Has_parent_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterSink_atom(Sink_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSink_atom(Sink_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterSource_atom(Source_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSource_atom(Source_atomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterAtom(AtomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitAtom(AtomContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterLiteral(LiteralContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitLiteral(LiteralContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOccurs_literal(Occurs_literalContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOccurs_literal(Occurs_literalContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterLibrary_name(Library_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitLibrary_name(Library_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterSys_desc_name(Sys_desc_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSys_desc_name(Sys_desc_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterSystem_description(System_descriptionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSystem_description(System_descriptionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterTheory_name(Theory_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitTheory_name(Theory_nameContext ctx) {
        //The theory name of the current system description is the only theory name that occures outside of a module. 
        if (!insideModule) {
            this.currentTheoryName = ctx.alm_name().getText();
        }
    }

    @Override
    public void enterTheory(TheoryContext ctx) {
        // TODO Auto-generated method stub
    }

    @Override
    public void exitTheory(TheoryContext ctx) {
        if (ctx.IMPORT() != null) {
            //complete theory is being imported.  
            Library_nameContext lctx = ctx.library_name();
            if (lctx != null) {
                String library_name = lctx.getText();
                Theory_nameContext tctx = ctx.theory_name();
                if (tctx != null) {
                    //we need to load the library theory and then parse it.
                    String theory_name = tctx.getText();
                    amm.recordImport(library_name, theory_name, ctx);
                } else {
                    ALMCompiler.IMPLEMENTATION_FAILURE("import theory", "missing theory name, no semantic error yet.");
                }
            } else {
                ALMCompiler.IMPLEMENTATION_FAILURE("import theory", "missing libarary name, no semantic error yet.");
            }

        }
    }

    @Override
    public void enterModule_name(Module_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitModule_name(Module_nameContext ctx) {
        //The first module name inside a module is the module's name.  
        //Others are part of dependency declarations 
        if (firstModuleName) {
            this.currentModuleName = ctx.alm_name().getText();
            firstModuleName = false;
        }
    }

    @Override
    public void enterSequence_of_modules(Sequence_of_modulesContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSequence_of_modules(Sequence_of_modulesContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterModule(ModuleContext ctx) {
        insideModule = true;
        firstModuleName = true;
    }

    @Override
    public void exitModule(ModuleContext ctx) {
        insideModule = false;
        firstModuleName = false;

        //If this is a module, its dependencies have been handled by other call back functions.
        Library_nameContext libCtx = ctx.library_name();
        String libraryName = libCtx == null ? null : libCtx.getText();
        Module_nameContext modCtx = ctx.module_name();
        String moduleName = modCtx == null ? null : modCtx.getText();

        if (libraryName != null) {
            //If this is an import statement, the ALM Module Manager handles the import.
            Theory_nameContext thCtx = ctx.theory_name();
            String theoryName = thCtx == null ? null : thCtx.getText();
            amm.recordImport(this.currentTheoryName, libraryName, theoryName, moduleName, ctx);
        } else {
            //This module context was defined here.  Add mapping for qualified name.
            try {
                amm.setModule(this.currentTheoryName, moduleName, ctx);
            } catch (DuplicateModuleException e) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Duplicate Parsed Module", "No semantic error recorded yet.");
            }
        }
    }

    @Override
    public void enterModule_body(Module_bodyContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitModule_body(Module_bodyContext ctx) {
        // TODO Auto-generated method stub

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

    }

    @Override
    public void exitOne_dependency(One_dependencyContext ctx) {

        Theory_nameContext theoryNameCTX = ctx.theory_name();
        String dependencyTheoryName = theoryNameCTX == null ? null : theoryNameCTX.alm_name().getText();
        String dependencyModuleName = ctx.module_name().getText();

        amm.recordModuleDependency(currentTheoryName, currentModuleName, dependencyTheoryName, dependencyModuleName, ctx.module_name());

    }

    @Override
    public void enterInteger_range(Integer_rangeContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitInteger_range(Integer_rangeContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterPredefined_sorts(Predefined_sortsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitPredefined_sorts(Predefined_sortsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterSort_name(Sort_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSort_name(Sort_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterSort_declarations(Sort_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSort_declarations(Sort_declarationsContext ctx) {
        // TODO Auto-generated method stub
    }

    @Override
    public void enterOne_sort_decl(One_sort_declContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_sort_decl(One_sort_declContext ctx) {
        // TODO Auto-generated method stub
    }

    @Override
    public void enterAttributes(AttributesContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitAttributes(AttributesContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_attribute_decl(One_attribute_declContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_attribute_decl(One_attribute_declContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterConstant_declarations(Constant_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitConstant_declarations(Constant_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_constant_decl(One_constant_declContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_constant_decl(One_constant_declContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterFunction_name(Function_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitFunction_name(Function_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterFunction_declarations(Function_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitFunction_declarations(Function_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterStatic_declarations(Static_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitStatic_declarations(Static_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterFluent_declarations(Fluent_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitFluent_declarations(Fluent_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterBasic_function_declarations(Basic_function_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitBasic_function_declarations(Basic_function_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterDefined_function_declarations(Defined_function_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitDefined_function_declarations(Defined_function_declarationsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_function_decl(One_function_declContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_function_decl(One_function_declContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterPos_fun_def(Pos_fun_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitPos_fun_def(Pos_fun_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterNeg_fun_def(Neg_fun_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitNeg_fun_def(Neg_fun_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterFun_def(Fun_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitFun_def(Fun_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterAxioms(AxiomsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitAxioms(AxiomsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterDynamic_causal_laws(Dynamic_causal_lawsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitDynamic_causal_laws(Dynamic_causal_lawsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterExecutability_conditions(Executability_conditionsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitExecutability_conditions(Executability_conditionsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterState_constraints(State_constraintsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitState_constraints(State_constraintsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterFunction_definitions(Function_definitionsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitFunction_definitions(Function_definitionsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_dynamic_causal_law(One_dynamic_causal_lawContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_dynamic_causal_law(One_dynamic_causal_lawContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_executability_condition(One_executability_conditionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_executability_condition(One_executability_conditionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_state_constraint(One_state_constraintContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_state_constraint(One_state_constraintContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_definition(One_definitionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_definition(One_definitionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterStructure_name(Structure_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitStructure_name(Structure_nameContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterStructure(StructureContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitStructure(StructureContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterConstant_defs(Constant_defsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitConstant_defs(Constant_defsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_constant_def(One_constant_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_constant_def(One_constant_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterInstance_defs(Instance_defsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitInstance_defs(Instance_defsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_instance_def(One_instance_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_instance_def(One_instance_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterAttribute_defs(Attribute_defsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitAttribute_defs(Attribute_defsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_attribute_def(One_attribute_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_attribute_def(One_attribute_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterStatics_defs(Statics_defsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitStatics_defs(Statics_defsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterOne_static_def(One_static_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitOne_static_def(One_static_defContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterSolver_mode(Solver_modeContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitSolver_mode(Solver_modeContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterTemporal_projection(Temporal_projectionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitTemporal_projection(Temporal_projectionContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterMax_steps(Max_stepsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitMax_steps(Max_stepsContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterHistory(HistoryContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitHistory(HistoryContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterObserved(ObservedContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitObserved(ObservedContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterHappened(HappenedContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitHappened(HappenedContext ctx) {
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
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

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
    }

    @Override
    public void enterNew_sort_name(ALMParser.New_sort_nameContext ctx) {
    }

    @Override
    public void exitNew_sort_name(ALMParser.New_sort_nameContext ctx) {
    }

}
