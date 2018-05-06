package edu.ttu.krlab.alm.parser;
// Generated from ALM.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ALMParser}.
 */
public interface ALMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ALMParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(ALMParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(ALMParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(ALMParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(ALMParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#nat_num}.
	 * @param ctx the parse tree
	 */
	void enterNat_num(ALMParser.Nat_numContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#nat_num}.
	 * @param ctx the parse tree
	 */
	void exitNat_num(ALMParser.Nat_numContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(ALMParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(ALMParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(ALMParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(ALMParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#alm_name}.
	 * @param ctx the parse tree
	 */
	void enterAlm_name(ALMParser.Alm_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#alm_name}.
	 * @param ctx the parse tree
	 */
	void exitAlm_name(ALMParser.Alm_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#object_constant}.
	 * @param ctx the parse tree
	 */
	void enterObject_constant(ALMParser.Object_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#object_constant}.
	 * @param ctx the parse tree
	 */
	void exitObject_constant(ALMParser.Object_constantContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#function_term}.
	 * @param ctx the parse tree
	 */
	void enterFunction_term(ALMParser.Function_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#function_term}.
	 * @param ctx the parse tree
	 */
	void exitFunction_term(ALMParser.Function_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ALMParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ALMParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#var_or_obj}.
	 * @param ctx the parse tree
	 */
	void enterVar_or_obj(ALMParser.Var_or_objContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#var_or_obj}.
	 * @param ctx the parse tree
	 */
	void exitVar_or_obj(ALMParser.Var_or_objContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ALMParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ALMParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#arithmetic_term}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_term(ALMParser.Arithmetic_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#arithmetic_term}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_term(ALMParser.Arithmetic_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ALMParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ALMParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#occurs_atom}.
	 * @param ctx the parse tree
	 */
	void enterOccurs_atom(ALMParser.Occurs_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#occurs_atom}.
	 * @param ctx the parse tree
	 */
	void exitOccurs_atom(ALMParser.Occurs_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#instance_atom}.
	 * @param ctx the parse tree
	 */
	void enterInstance_atom(ALMParser.Instance_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#instance_atom}.
	 * @param ctx the parse tree
	 */
	void exitInstance_atom(ALMParser.Instance_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#is_a_atom}.
	 * @param ctx the parse tree
	 */
	void enterIs_a_atom(ALMParser.Is_a_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#is_a_atom}.
	 * @param ctx the parse tree
	 */
	void exitIs_a_atom(ALMParser.Is_a_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#link_atom}.
	 * @param ctx the parse tree
	 */
	void enterLink_atom(ALMParser.Link_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#link_atom}.
	 * @param ctx the parse tree
	 */
	void exitLink_atom(ALMParser.Link_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#subsort_atom}.
	 * @param ctx the parse tree
	 */
	void enterSubsort_atom(ALMParser.Subsort_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#subsort_atom}.
	 * @param ctx the parse tree
	 */
	void exitSubsort_atom(ALMParser.Subsort_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#has_child_atom}.
	 * @param ctx the parse tree
	 */
	void enterHas_child_atom(ALMParser.Has_child_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#has_child_atom}.
	 * @param ctx the parse tree
	 */
	void exitHas_child_atom(ALMParser.Has_child_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#has_parent_atom}.
	 * @param ctx the parse tree
	 */
	void enterHas_parent_atom(ALMParser.Has_parent_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#has_parent_atom}.
	 * @param ctx the parse tree
	 */
	void exitHas_parent_atom(ALMParser.Has_parent_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#sink_atom}.
	 * @param ctx the parse tree
	 */
	void enterSink_atom(ALMParser.Sink_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#sink_atom}.
	 * @param ctx the parse tree
	 */
	void exitSink_atom(ALMParser.Sink_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#source_atom}.
	 * @param ctx the parse tree
	 */
	void enterSource_atom(ALMParser.Source_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#source_atom}.
	 * @param ctx the parse tree
	 */
	void exitSource_atom(ALMParser.Source_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ALMParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ALMParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ALMParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ALMParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#occurs_literal}.
	 * @param ctx the parse tree
	 */
	void enterOccurs_literal(ALMParser.Occurs_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#occurs_literal}.
	 * @param ctx the parse tree
	 */
	void exitOccurs_literal(ALMParser.Occurs_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#library_name}.
	 * @param ctx the parse tree
	 */
	void enterLibrary_name(ALMParser.Library_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#library_name}.
	 * @param ctx the parse tree
	 */
	void exitLibrary_name(ALMParser.Library_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#sys_desc_name}.
	 * @param ctx the parse tree
	 */
	void enterSys_desc_name(ALMParser.Sys_desc_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#sys_desc_name}.
	 * @param ctx the parse tree
	 */
	void exitSys_desc_name(ALMParser.Sys_desc_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#system_description}.
	 * @param ctx the parse tree
	 */
	void enterSystem_description(ALMParser.System_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#system_description}.
	 * @param ctx the parse tree
	 */
	void exitSystem_description(ALMParser.System_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#theory_name}.
	 * @param ctx the parse tree
	 */
	void enterTheory_name(ALMParser.Theory_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#theory_name}.
	 * @param ctx the parse tree
	 */
	void exitTheory_name(ALMParser.Theory_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#theory}.
	 * @param ctx the parse tree
	 */
	void enterTheory(ALMParser.TheoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#theory}.
	 * @param ctx the parse tree
	 */
	void exitTheory(ALMParser.TheoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#module_name}.
	 * @param ctx the parse tree
	 */
	void enterModule_name(ALMParser.Module_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#module_name}.
	 * @param ctx the parse tree
	 */
	void exitModule_name(ALMParser.Module_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#sequence_of_modules}.
	 * @param ctx the parse tree
	 */
	void enterSequence_of_modules(ALMParser.Sequence_of_modulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#sequence_of_modules}.
	 * @param ctx the parse tree
	 */
	void exitSequence_of_modules(ALMParser.Sequence_of_modulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(ALMParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(ALMParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#module_body}.
	 * @param ctx the parse tree
	 */
	void enterModule_body(ALMParser.Module_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#module_body}.
	 * @param ctx the parse tree
	 */
	void exitModule_body(ALMParser.Module_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#module_dependencies}.
	 * @param ctx the parse tree
	 */
	void enterModule_dependencies(ALMParser.Module_dependenciesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#module_dependencies}.
	 * @param ctx the parse tree
	 */
	void exitModule_dependencies(ALMParser.Module_dependenciesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_dependency}.
	 * @param ctx the parse tree
	 */
	void enterOne_dependency(ALMParser.One_dependencyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_dependency}.
	 * @param ctx the parse tree
	 */
	void exitOne_dependency(ALMParser.One_dependencyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#integer_range}.
	 * @param ctx the parse tree
	 */
	void enterInteger_range(ALMParser.Integer_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#integer_range}.
	 * @param ctx the parse tree
	 */
	void exitInteger_range(ALMParser.Integer_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#predefined_sorts}.
	 * @param ctx the parse tree
	 */
	void enterPredefined_sorts(ALMParser.Predefined_sortsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#predefined_sorts}.
	 * @param ctx the parse tree
	 */
	void exitPredefined_sorts(ALMParser.Predefined_sortsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#sort_name}.
	 * @param ctx the parse tree
	 */
	void enterSort_name(ALMParser.Sort_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#sort_name}.
	 * @param ctx the parse tree
	 */
	void exitSort_name(ALMParser.Sort_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#sort_declarations}.
	 * @param ctx the parse tree
	 */
	void enterSort_declarations(ALMParser.Sort_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#sort_declarations}.
	 * @param ctx the parse tree
	 */
	void exitSort_declarations(ALMParser.Sort_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_sort_decl}.
	 * @param ctx the parse tree
	 */
	void enterOne_sort_decl(ALMParser.One_sort_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_sort_decl}.
	 * @param ctx the parse tree
	 */
	void exitOne_sort_decl(ALMParser.One_sort_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(ALMParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(ALMParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_attribute_decl}.
	 * @param ctx the parse tree
	 */
	void enterOne_attribute_decl(ALMParser.One_attribute_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_attribute_decl}.
	 * @param ctx the parse tree
	 */
	void exitOne_attribute_decl(ALMParser.One_attribute_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#constant_declarations}.
	 * @param ctx the parse tree
	 */
	void enterConstant_declarations(ALMParser.Constant_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#constant_declarations}.
	 * @param ctx the parse tree
	 */
	void exitConstant_declarations(ALMParser.Constant_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_constant_decl}.
	 * @param ctx the parse tree
	 */
	void enterOne_constant_decl(ALMParser.One_constant_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_constant_decl}.
	 * @param ctx the parse tree
	 */
	void exitOne_constant_decl(ALMParser.One_constant_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(ALMParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(ALMParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#function_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declarations(ALMParser.Function_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#function_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declarations(ALMParser.Function_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#static_declarations}.
	 * @param ctx the parse tree
	 */
	void enterStatic_declarations(ALMParser.Static_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#static_declarations}.
	 * @param ctx the parse tree
	 */
	void exitStatic_declarations(ALMParser.Static_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#fluent_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFluent_declarations(ALMParser.Fluent_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#fluent_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFluent_declarations(ALMParser.Fluent_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#basic_function_declarations}.
	 * @param ctx the parse tree
	 */
	void enterBasic_function_declarations(ALMParser.Basic_function_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#basic_function_declarations}.
	 * @param ctx the parse tree
	 */
	void exitBasic_function_declarations(ALMParser.Basic_function_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#defined_function_declarations}.
	 * @param ctx the parse tree
	 */
	void enterDefined_function_declarations(ALMParser.Defined_function_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#defined_function_declarations}.
	 * @param ctx the parse tree
	 */
	void exitDefined_function_declarations(ALMParser.Defined_function_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_function_decl}.
	 * @param ctx the parse tree
	 */
	void enterOne_function_decl(ALMParser.One_function_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_function_decl}.
	 * @param ctx the parse tree
	 */
	void exitOne_function_decl(ALMParser.One_function_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#pos_fun_def}.
	 * @param ctx the parse tree
	 */
	void enterPos_fun_def(ALMParser.Pos_fun_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#pos_fun_def}.
	 * @param ctx the parse tree
	 */
	void exitPos_fun_def(ALMParser.Pos_fun_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#neg_fun_def}.
	 * @param ctx the parse tree
	 */
	void enterNeg_fun_def(ALMParser.Neg_fun_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#neg_fun_def}.
	 * @param ctx the parse tree
	 */
	void exitNeg_fun_def(ALMParser.Neg_fun_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#fun_def}.
	 * @param ctx the parse tree
	 */
	void enterFun_def(ALMParser.Fun_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#fun_def}.
	 * @param ctx the parse tree
	 */
	void exitFun_def(ALMParser.Fun_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#axioms}.
	 * @param ctx the parse tree
	 */
	void enterAxioms(ALMParser.AxiomsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#axioms}.
	 * @param ctx the parse tree
	 */
	void exitAxioms(ALMParser.AxiomsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#dynamic_causal_laws}.
	 * @param ctx the parse tree
	 */
	void enterDynamic_causal_laws(ALMParser.Dynamic_causal_lawsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#dynamic_causal_laws}.
	 * @param ctx the parse tree
	 */
	void exitDynamic_causal_laws(ALMParser.Dynamic_causal_lawsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#executability_conditions}.
	 * @param ctx the parse tree
	 */
	void enterExecutability_conditions(ALMParser.Executability_conditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#executability_conditions}.
	 * @param ctx the parse tree
	 */
	void exitExecutability_conditions(ALMParser.Executability_conditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#state_constraints}.
	 * @param ctx the parse tree
	 */
	void enterState_constraints(ALMParser.State_constraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#state_constraints}.
	 * @param ctx the parse tree
	 */
	void exitState_constraints(ALMParser.State_constraintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(ALMParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(ALMParser.DefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_dynamic_causal_law}.
	 * @param ctx the parse tree
	 */
	void enterOne_dynamic_causal_law(ALMParser.One_dynamic_causal_lawContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_dynamic_causal_law}.
	 * @param ctx the parse tree
	 */
	void exitOne_dynamic_causal_law(ALMParser.One_dynamic_causal_lawContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_executability_condition}.
	 * @param ctx the parse tree
	 */
	void enterOne_executability_condition(ALMParser.One_executability_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_executability_condition}.
	 * @param ctx the parse tree
	 */
	void exitOne_executability_condition(ALMParser.One_executability_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_state_constraint}.
	 * @param ctx the parse tree
	 */
	void enterOne_state_constraint(ALMParser.One_state_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_state_constraint}.
	 * @param ctx the parse tree
	 */
	void exitOne_state_constraint(ALMParser.One_state_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_definition}.
	 * @param ctx the parse tree
	 */
	void enterOne_definition(ALMParser.One_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_definition}.
	 * @param ctx the parse tree
	 */
	void exitOne_definition(ALMParser.One_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#structure_name}.
	 * @param ctx the parse tree
	 */
	void enterStructure_name(ALMParser.Structure_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#structure_name}.
	 * @param ctx the parse tree
	 */
	void exitStructure_name(ALMParser.Structure_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(ALMParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(ALMParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#constant_defs}.
	 * @param ctx the parse tree
	 */
	void enterConstant_defs(ALMParser.Constant_defsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#constant_defs}.
	 * @param ctx the parse tree
	 */
	void exitConstant_defs(ALMParser.Constant_defsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_constant_def}.
	 * @param ctx the parse tree
	 */
	void enterOne_constant_def(ALMParser.One_constant_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_constant_def}.
	 * @param ctx the parse tree
	 */
	void exitOne_constant_def(ALMParser.One_constant_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#instance_defs}.
	 * @param ctx the parse tree
	 */
	void enterInstance_defs(ALMParser.Instance_defsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#instance_defs}.
	 * @param ctx the parse tree
	 */
	void exitInstance_defs(ALMParser.Instance_defsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_instance_def}.
	 * @param ctx the parse tree
	 */
	void enterOne_instance_def(ALMParser.One_instance_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_instance_def}.
	 * @param ctx the parse tree
	 */
	void exitOne_instance_def(ALMParser.One_instance_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#attribute_defs}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_defs(ALMParser.Attribute_defsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#attribute_defs}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_defs(ALMParser.Attribute_defsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_attribute_def}.
	 * @param ctx the parse tree
	 */
	void enterOne_attribute_def(ALMParser.One_attribute_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_attribute_def}.
	 * @param ctx the parse tree
	 */
	void exitOne_attribute_def(ALMParser.One_attribute_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#statics_defs}.
	 * @param ctx the parse tree
	 */
	void enterStatics_defs(ALMParser.Statics_defsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#statics_defs}.
	 * @param ctx the parse tree
	 */
	void exitStatics_defs(ALMParser.Statics_defsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_static_def}.
	 * @param ctx the parse tree
	 */
	void enterOne_static_def(ALMParser.One_static_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_static_def}.
	 * @param ctx the parse tree
	 */
	void exitOne_static_def(ALMParser.One_static_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#solver_mode}.
	 * @param ctx the parse tree
	 */
	void enterSolver_mode(ALMParser.Solver_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#solver_mode}.
	 * @param ctx the parse tree
	 */
	void exitSolver_mode(ALMParser.Solver_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#max_steps}.
	 * @param ctx the parse tree
	 */
	void enterMax_steps(ALMParser.Max_stepsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#max_steps}.
	 * @param ctx the parse tree
	 */
	void exitMax_steps(ALMParser.Max_stepsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#history}.
	 * @param ctx the parse tree
	 */
	void enterHistory(ALMParser.HistoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#history}.
	 * @param ctx the parse tree
	 */
	void exitHistory(ALMParser.HistoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#observed}.
	 * @param ctx the parse tree
	 */
	void enterObserved(ALMParser.ObservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#observed}.
	 * @param ctx the parse tree
	 */
	void exitObserved(ALMParser.ObservedContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#happened}.
	 * @param ctx the parse tree
	 */
	void enterHappened(ALMParser.HappenedContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#happened}.
	 * @param ctx the parse tree
	 */
	void exitHappened(ALMParser.HappenedContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#added_constraints}.
	 * @param ctx the parse tree
	 */
	void enterAdded_constraints(ALMParser.Added_constraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#added_constraints}.
	 * @param ctx the parse tree
	 */
	void exitAdded_constraints(ALMParser.Added_constraintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_added_constraint}.
	 * @param ctx the parse tree
	 */
	void enterOne_added_constraint(ALMParser.One_added_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_added_constraint}.
	 * @param ctx the parse tree
	 */
	void exitOne_added_constraint(ALMParser.One_added_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#action_conditions}.
	 * @param ctx the parse tree
	 */
	void enterAction_conditions(ALMParser.Action_conditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#action_conditions}.
	 * @param ctx the parse tree
	 */
	void exitAction_conditions(ALMParser.Action_conditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_action_condition}.
	 * @param ctx the parse tree
	 */
	void enterOne_action_condition(ALMParser.One_action_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_action_condition}.
	 * @param ctx the parse tree
	 */
	void exitOne_action_condition(ALMParser.One_action_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#temporal_projection}.
	 * @param ctx the parse tree
	 */
	void enterTemporal_projection(ALMParser.Temporal_projectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#temporal_projection}.
	 * @param ctx the parse tree
	 */
	void exitTemporal_projection(ALMParser.Temporal_projectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#planning_problem}.
	 * @param ctx the parse tree
	 */
	void enterPlanning_problem(ALMParser.Planning_problemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#planning_problem}.
	 * @param ctx the parse tree
	 */
	void exitPlanning_problem(ALMParser.Planning_problemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#goal_state}.
	 * @param ctx the parse tree
	 */
	void enterGoal_state(ALMParser.Goal_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#goal_state}.
	 * @param ctx the parse tree
	 */
	void exitGoal_state(ALMParser.Goal_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#diagnostic_problem}.
	 * @param ctx the parse tree
	 */
	void enterDiagnostic_problem(ALMParser.Diagnostic_problemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#diagnostic_problem}.
	 * @param ctx the parse tree
	 */
	void exitDiagnostic_problem(ALMParser.Diagnostic_problemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#normal_conditions}.
	 * @param ctx the parse tree
	 */
	void enterNormal_conditions(ALMParser.Normal_conditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#normal_conditions}.
	 * @param ctx the parse tree
	 */
	void exitNormal_conditions(ALMParser.Normal_conditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#one_normal_condition}.
	 * @param ctx the parse tree
	 */
	void enterOne_normal_condition(ALMParser.One_normal_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#one_normal_condition}.
	 * @param ctx the parse tree
	 */
	void exitOne_normal_condition(ALMParser.One_normal_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALMParser#current_state}.
	 * @param ctx the parse tree
	 */
	void enterCurrent_state(ALMParser.Current_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALMParser#current_state}.
	 * @param ctx the parse tree
	 */
	void exitCurrent_state(ALMParser.Current_stateContext ctx);
}