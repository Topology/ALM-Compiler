// Generated from ALM.g4 by ANTLR 4.5.3

package edu.ttu.krlab.alm.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMTranslator;
import edu.ttu.krlab.alm.TranslatorSettings;
import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;
import edu.ttu.krlab.alm.datastruct.VariableManager;
import edu.ttu.krlab.alm.datastruct.aspf.*;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.datastruct.sig.*;
import edu.ttu.krlab.alm.parser.ALMParser.AttributesContext;
import edu.ttu.krlab.alm.parser.ALMParser.Fun_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Function_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.Instance_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.LiteralContext;
import edu.ttu.krlab.alm.parser.ALMParser.Object_constantContext;
import edu.ttu.krlab.alm.parser.ALMParser.Occurs_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Occurs_literalContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_attribute_declContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_attribute_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Sort_nameContext;

/**
 * This class provides an empty implementation of {@link ALMListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */

/**
 * 
 * @author Edward Wertz
 *
 *         Organized to target computing Pre-model in SPARC first, then
 *         targeting Final SPARC Program.
 * 
 *         Prior to Constructing Pre-Model SPARC Program: 1) Parse Sort
 *         Hierarchy A) Sort Hierarchy into Symbol Table B) ASP{f} rules for
 *         Hierarchy Created and in intermediate ASP{f} Rule Table 2) Parse
 *         Function Declarations A) Functions into Symbol Table 3) Parse Axioms
 *         A) Parse Axioms into ASP{f} Rule Table for each type of Axiom 4)
 *         Parse Constant Definitions in Structure A) Constant Definitions
 *         modify declared constants in the Symbol Table 5) Parse Sort Instances
 *         A) Sort Instances are added to the symbol table. B) Rules for sort
 *         instances added to ASP{f} table of appropriate type. 6) Parse
 *         Function definitions A) Definitions added to ASP{f} rule table of
 *         appropriate type.
 *
 *         Construct Pre-model SPARC Program 1) Initialize Sort Section from
 *         SORT Hierarchy in symbol table 2) Define predicates from function in
 *         symbol table. 3) Translate static rules from ASP{f} that contribute
 *         to pre-model.
 * 
 *         Compute Answer Set
 * 
 *         Construct Final SPARC Program 1) Populate Sort Section from answerset
 *         2) Copy predicate declarations 3) Copy rules 4) Translate remaining
 *         non-static rules from ASP{f} 5) Add facts from Answer Set.
 *
 */

public class ALMBaseListener implements ALMListener {

	private SymbolTable st;
	private ErrorReport er;
	private ASPfProgram aspf;
	private TranslatorSettings s;

	// Function Type
	boolean staticType = false;
	boolean fluentType = false;
	boolean basicType = false;
	boolean definedType = false;
	boolean totalType = false;

	public ALMBaseListener(TranslatorSettings settings, SymbolTable st, ErrorReport er, ASPfProgram aspf) {
		this.s = settings;
		this.st = st;
		this.er = er;
		this.aspf = aspf;

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

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterModule(ALMParser.ModuleContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitModule(ALMParser.ModuleContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
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
		List<TerminalNode> IDs = ctx.ID();
		List<Sort_nameContext> sort_names = ctx.sort_name();
		AttributesContext attributes_section = ctx.attributes();
		List<One_attribute_declContext> attributes = null;
		if (attributes_section != null)
			attributes = attributes_section.one_attribute_decl();

		// convert sort_names into sort_entries for parents,
		// throw semantic error
		// if they do not exist yet
		// if they are predefined.
		List<SortEntry> parent_sorts = new ArrayList<SortEntry>();
		for (Sort_nameContext sort_name : sort_names)
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

		// Create New Sort Entries for IDS, throw semantic error if they exist
		// already.
		List<SortEntry> child_sorts = new ArrayList<SortEntry>();
		for (TerminalNode ID : IDs)
			try {
				child_sorts.add(st.createSortEntry(ID.getText(), new Location(ID)));
			} catch (DuplicateSortException e2) {
				// child sort entry already exists inside symbol table.
				er.newSemanticError(SemanticError.SRT005).add(ID);
			}

		// link parent and child together in symbol table.
		for (SortEntry parent : parent_sorts)
			for (SortEntry child : child_sorts) {
				parent.addChildSort(child);
				child.addParentSort(parent);
			}

		// Create Attribute Functions
		// one_attribute_decl: ID ':' (sort_name (',' sort_name )* RIGHT_ARROW)?
		// sort_name;
		if (attributes != null) {
			for (One_attribute_declContext attribute : attributes) {

				// attribute name
				String attr_name = attribute.ID().getText();

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
							NormalFunctionEntry attr = st.createFunctionEntry(attr_name, full_sig, new Location(attribute));
							attr.setAttribute();
							attr.setStatic();
							child.addAttribute(attr);
							

							//per attribute function, need to add axiom defining dom_f
							ALMTerm domf = new ALMTerm(ALM.DOM_PREFIX+attr.getQualifiedFunctionName(), ALMTerm.FUN, attribute );
							ALMTerm fun = new ALMTerm(attr.getQualifiedFunctionName(), ALMTerm.FUN, attribute);
							
							int num_args = attr.getSignature().size()-1;
							for(int i = 0; i < num_args; i++){
								ALMTerm argi = new ALMTerm("X"+i, ALMTerm.VAR);
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
							r.addComment("Definition for dom_f being positive when attribute function ["+attr.getFunctionName()+"] of sort ["+child.getSortName()+"] has a known definition.");
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

		// convert sort_names into sort entries and ensure they are source sorts
		// in the hierarchy
		List<SortEntry> sort_entries = new ArrayList<SortEntry>();
		for (Sort_nameContext sort_name : sort_names)
			try {
				SortEntry sort = st.getSortEntry(sort_name.getText());
				Set<SortEntry> children = sort.getChildSorts();
				if (children.size() == 0)
					sort_entries.add(sort);
				else {
					// sort was not source sort.
					SemanticError se = er.newSemanticError(SemanticError.CND001);
					se.add(ctx); // location of const declaration.
					se.add(sort_name);
					se.add(children.iterator().next().getLocation());
				}
			} catch (SortNotFoundException e1) {
				// sort was not declared in the hierarchy
				er.newSemanticError(SemanticError.CND003).add(sort_name);
			}

		// create object constants if their arguments are source sorts.
		for (Object_constantContext obj_con : object_constants) {
			ALMTerm obj_const = ALM.ParseALMTerm(obj_con);

			boolean schema_passed = true;
			// check to make sure all parameters are source sorts in hierarchy.
			List<ALMTerm> args = obj_const.getArgs();
			if (args != null)
				for (ALMTerm arg : args) {
					try {
						SortEntry sort = st.getSortEntry(arg.toString());
						Set<SortEntry> children = sort.getChildSorts();
						if (children.size() != 0) {
							SortEntry childsort = children.iterator().next();
							er.newSemanticError(SemanticError.CND002).add(arg.getLocation())
									.add(childsort.getLocation());
							schema_passed = false;
						}
					} catch (SortNotFoundException e) {
						er.newSemanticError(SemanticError.CND004).add(arg.getLocation());
						schema_passed = false;
					}

				}
			if (schema_passed)
				try {
					st.createConstantEntry(obj_const.getName(), sort_entries, new Location(ctx));
				} catch (DuplicateConstantException e) {
					ConstantEntry prev_const = e.getConstantEntry();
					er.newSemanticError(SemanticError.CND005).add(obj_const.getLocation())
							.add(prev_const.getLocation());

				} catch (NotSourceSortException e) {
					ALMTranslator.PROGRAM_FAILURE("Creating Object Constant Entry",
							"Unhandled Semantic Error, sort entry did not exist or was not a source sort.");
					// already handled previously, no new error needs to be
					// thrown. This line should never execute.
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
			totalType = true;

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
			}
		}

		// defined functions must be boolean, otherwise semantic error.
		if (definedType == true) {
			if (signature.get(signature.size() - 1) != st.getBooleansSortEntry())
				// was not boolean sort
				er.newSemanticError(SemanticError.FND001).add(ctx);
		}

		
		//create then entry in the symbol table for the function.  
		try {
			FunctionEntry f = st.createFunctionEntry(funName, signature, new Location(ctx));
			if (fluentType)
				f.setFluent();
			if (staticType)
				f.setStatic();
			if (basicType)
				f.setBasic();
			if (definedType)
				f.setDefined();
			if (totalType)
				f.setTotal();
			

			//Rules for when dom_f is defined.   All usert defined functions need some form of this rule.   
			
			ALMTerm domf = new ALMTerm(ALM.DOM_PREFIX+f.getFunctionName(), ALMTerm.FUN, fun_name );
			ALMTerm fun = new ALMTerm(f.getFunctionName(), ALMTerm.FUN, fun_name);
			

			int num_args = f.getSignature().size()-1;
			for(int i = 0; i < num_args; i++){
				ALMTerm argi = new ALMTerm("X"+i, ALMTerm.VAR);
				domf.addArg(argi);
				fun.addArg(argi);
				i++;
			}
			
			
			ALMTerm funRelation = new ALMTerm(ALM.SYMBOL_EQ, ALMTerm.TERM_RELATION);
			funRelation.addArg(fun);
			funRelation.addArg(new ALMTerm("Y", ALMTerm.VAR));
			
			List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();
			body.add(funRelation);
			
			if(fluentType){
				if(basicType){
					ASPfRule r = aspf.newRule(ALM.AXIOMS_STATE_CONSTRAINTS_FLUENT, domf, body);
					r.addComment("State Constraint for dom_f being positive when basic fluent function ["+f.getFunctionName()+"] has a known definition.");		
				} 
				if (definedType){
					ASPfRule r = aspf.newRule(ALM.AXIOMS_DEFINITIONS_FLUENT, domf, body);
					r.addComment("Definition for dom_f being positive when defined fluent function ["+f.getFunctionName()+"] has a known definition.");
				}
			} 
			if(staticType){
				ASPfRule r = aspf.newRule(ALM.AXIOMS_DEFINITIONS_STATIC, domf, body);
				r.addComment("Definition for dom_f being positive when static function ["+f.getFunctionName()+"] has a known definition.");
			}
			
			
			
			//TODO there are other axioms to add from the paper. 

			
			
			
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
	public void enterDefinitions(ALMParser.DefinitionsContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitDefinitions(ALMParser.DefinitionsContext ctx) {

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
		for (LiteralContext lit : ctx.literal())
			literals.add(ALM.ParseLiteral(lit));

		// occurs_atom and instance_atom must share the same variable or term.
		String occurs_text = occurs_atom.getArg(0).toString();
		String instance_text = instance_atom.getArg(0).toString();
		if (occurs_text.compareTo(instance_text) != 0) {
			er.newSemanticError(SemanticError.AXM010).add(occurs_atom).add(instance_atom);
			error_occurred = true;
		}
		
		//function cannot be special function and must be previously declared.
		FunctionEntry f;
		try {
			if(pos_fun_def.getType() == ALMTerm.TERM_RELATION)
				f = st.getFunctionEntry(pos_fun_def.getArg(0));
			else
				f = st.getFunctionEntry(pos_fun_def);
			if(f.isSpecial()){
				er.newSemanticError(SemanticError.AXM003).add(pos_fun_def);
				error_occurred = true;
			}
		} catch (FunctionNotFound e) {
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
		for(ALMTerm lit : literals)
			if(LiteralHasSemanticErrors(lit))
				error_occurred = true;

		// Need To Type Check Literals
		VariableManager typeChecker = new VariableManager(st);
		occurs_atom.typeCheck(typeChecker, st, er);
		instance_atom.typeCheck(typeChecker, st, er);
		for (ALMTerm lit : literals)
			lit.typeCheck(typeChecker, st, er);

		if (!typeChecker.typeCheckPasses(er))
			error_occurred = true;

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
		for (Occurs_literalContext olc : occurs_literals)
			occurs_lits.add(ALM.ParseOccursLiteral(olc));

		// convert literals to ALMTerms
		List<ALMTerm> lits = new ArrayList<ALMTerm>();
		for (LiteralContext lit : literals)
			lits.add(ALM.ParseLiteral(lit));

		// SEMANTIC ERROR CHECKING
		
		//Argument of occurs must match instance_atom
		ALMTerm occ_arg = occ_atom.getArg(0);
		ALMTerm inst_arg = inst_atom.getArg(0);
		if(occ_arg.toString().compareTo(inst_arg.toString()) != 0){
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

		
		//check remaining literals for semantic errors. 
		for(ALMTerm lit: lits)
			if(LiteralHasSemanticErrors(lit))
				error_occurred = true;
		
		
		//TYPE CHECKING
		VariableManager vtc = new VariableManager(st);
		for(ALMTerm lit : lits)
			lit.typeCheck(vtc, st, er);
		for(ALMTerm occurs : occurs_lits)
			occurs.typeCheck(vtc, st, er);
		
		if(!vtc.typeCheckPasses(er))
			error_occurred = true;
		
		
		if(!error_occurred){
			// ADD RULE TO ASPfProgram
			// The ASPfRule has no head, all literals in the body.
			List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();
			body.add(occ_atom);
			body.add(inst_atom);
			for (ALMTerm occ_lit : occurs_lits)
				body.add(occ_lit);
			for (ALMTerm lit : lits)
				body.add(lit);
	
			ASPfRule r = aspf.newRule(ALM.AXIOMS_EXECUTABILITY_CONDITIONS, null, body);
			r.addComment(
					"Executability Condition for when [" + occ_atom.getArg(0).getName() + "] is impossible to execute.");
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
		
		//get components
		Fun_defContext fun_def = ctx.fun_def();
		List<LiteralContext> literals = ctx.literal();

		// Parse fun_def to ALMTerm
		ALMTerm head = null;
		if (fun_def != null) // if absent, then state constraint models a logic
								// constraint (false at head)
			head = ALM.ParseFunDef(fun_def);

		// Parse literals to ALMTerms if literals exist
		List<ALMTerm> lits = null;
		if (literals != null) {
			lits = new ArrayList<ALMTerm>();
			for (LiteralContext lit : literals)
				lits.add(ALM.ParseLiteral(lit));
		}

		// SEMANTIC ERROR CHECKING
	
		if(head != null){
			//CHECK FORM OF HEAD LITERAL, either Term Relation or Function. 
			ALMTerm headFunction = head;
			if(head.getType() == ALMTerm.TERM_RELATION){
				headFunction = head.getArg(0);
			}
			
			try {
				FunctionEntry head_function = st.getFunctionEntry(headFunction);
				//head function must be basic
				if(!head_function.isBasic()){
					er.newSemanticError(SemanticError.AXM004).add(headFunction);
					error_occurred = true;
				}
	
				List<SortEntry> sig = head_function.getSignature();
				//entity on right hand side must be variable or object constant of range sort of function. 
				ALMTerm oterm = head.getArg(1);
				if(!oterm.isVariable()){
					if(oterm.isObjectConstant()){
						//TODO:  This is a mess,  how do you address object constantschemas?  
						//st.getConstantEntry(oterm);
						//TODO: There should be a semantic error here if there is no object constant declaration for the range sort. 
					} else {
						er.newSemanticError(SemanticError.AXM009).add(headFunction).add(oterm).add(sig.get(sig.size()-1));
					}
				}
			} catch (FunctionNotFound e) {
				er.newSemanticError(SemanticError.FND003).add(headFunction);
				error_occurred = true;
			}
		}
		//Variable Type Checking
		VariableManager vm = new VariableManager(st);
		for(ALMTerm lit: lits)
			lit.typeCheck(vm, st, er);
		if(head != null)
			head.typeCheck(vm, st, er);
		
		if(!vm.typeCheckPasses(er))
			error_occurred = true;
		
		if(!error_occurred){
		
			// Construct ASPf Rule
			List<ASPfLiteral> body = null;
			if (literals != null) {
				body = new ArrayList<ASPfLiteral>();
				for (ALMTerm lit : lits)
					body.add(lit);
			}
	
			ASPfRule r = aspf.newRule(ALM.AXIOMS_STATE_CONSTRAINTS, head, body);
			if (head != null)
				if (head.getType() == ALMTerm.FUN)
					r.addComment("State Constraint for function [" + head.getName() + "].");
				else
					r.addComment("State Constraint for function [" + head.getArg(0).getName() + "].");
			else
				r.addComment("State Constraint: This condition is impossible in all states.");
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
		List<LiteralContext> literals = ctx.literal();
		List<ALMTerm> lits = new ArrayList<ALMTerm>();
		if (literals != null)
			for (LiteralContext lit : literals)
				lits.add(ALM.ParseLiteral(lit));

		//SEMANTIC ERROR CHECKING
		
		boolean isStatic = false;
		//function must be defined
		try {
			FunctionEntry f= st.getFunctionEntry(head);
			if(!f.isDefined()){
				er.newSemanticError(SemanticError.AXM008).add(head);
				error_occurred = true;
			}
			if(f.isStatic())
				isStatic = true;
		} catch (FunctionNotFound e) {
			er.newSemanticError(SemanticError.FND003).add(head);
			error_occurred = true;
		}
		
		//if Function is static, all literals in body must be static. 
		if(isStatic)
			for(ALMTerm lit:lits)
				if(lit.hasFluentFunction(st)){
					er.newSemanticError(SemanticError.AXM006).add(lit).add(head);
					error_occurred = true;
				}
					
		
		//VARIABLE TYPE CHECKING
		VariableManager vm = new VariableManager(st);
		for(ALMTerm lit: lits)
			lit.typeCheck(vm, st, er);
		head.typeCheck(vm, st, er);
		
		if(!vm.typeCheckPasses(er))
			error_occurred = true;
			
		if(!error_occurred){
			List<ASPfLiteral> body = new ArrayList<ASPfLiteral>();
			for(ALMTerm lit: lits)
				body.add(lit);
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
	 * GRAMMAR: one_instance_def: object_constant (',' object_constant)* 'in'
	 * sort_name (',' sort_name)* ('where' literal (',' literal)* )?
	 * attribute_defs;//<one_instance_def> attribute_defs: (one_attribute_def)*;
	 * one_attribute_def: function_term EQ term;
	 * 
	 * 
	 */
	// one_instance_def: object_constant (',' object_constant)* 'in' sort_name
	// (',' sort_name)* ('where' literal (',' literal)* )? attribute_defs;
	@Override
	public void exitOne_instance_def(ALMParser.One_instance_defContext ctx) {

		// pull out theses lists:
		// Instance Descriptions (Object Constants)
		// Sorts
		// Literals
		// Attribute Definitions
		List<ALMParser.Object_constantContext> instances = ctx.object_constant();
		List<ALMParser.Sort_nameContext> sorts = ctx.sort_name();
		List<ALMParser.LiteralContext> literals = ctx.literal();
		List<ALMParser.One_attribute_defContext> attr_defs = null;
		if (ctx.attribute_defs() != null)
			attr_defs = ctx.attribute_defs().one_attribute_def();

		// Turn list of sort_names into a list of SortEntries in the symbol
		// table.
		List<SortEntry> sort_entries = new ArrayList<SortEntry>();
		for (ALMParser.Sort_nameContext sort : sorts) {
			String sort_text = sort.getText();
			if (st.isPredefinedSort(sort_text))
				er.newSemanticError("SID001").add(new Location(sort));
			else {
				SortEntry se;
				try {
					se = st.getSortEntry(sort.getText());
					if (se.getChildSorts().size() > 0)
						er.newSemanticError("SID002").add(new Location(sort));
					else
						sort_entries.add(se);
				} catch (SortNotFoundException e) {
					er.newSemanticError("SID002").add(new Location(sort));
				}
			}
		}

		// Convert object_constants into a list of ALMTerms and check they
		// qualify as sort instances.
		// A sort instance is either a ground function term, or it is a schema.
		// If it is a schema, the sort information about the variables will need
		// to be added
		// after parsing the rules. This will be handled later in the function.
		// object_constant: ID ( '(' term (',' term)* ')')?;
		List<ALMTerm> sort_instances = new ArrayList<ALMTerm>();
		for (ALMParser.Object_constantContext inst : instances) {
			ALMTerm aterm = ALM.ParseALMTerm(inst);
			if (aterm == null)
				ALMTranslator.PROGRAM_FAILURE("Structure Instance", "Failed To Parse ALMTerm:" + inst.getText());
			if (aterm.isSchema())
				sort_instances.add(aterm);
			else
				er.newSemanticError("SID003").add(new Location(inst));
		}

		// Convert literals into ALMTerms
		// Collect Type Information
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

		// Collect Variables and Type Check Variables.
		// This will also register the type-checker with the literals and terms
		// so they can
		// provide the sort information when quarried for it.
		VariableManager vtc = new VariableManager(st);
		for (ALMTerm si : sort_instances)
			si.recordVariableOccurrences(vtc, st, er); // DO NOT TYPE CHECK THIS SINCE IT IS NOT A FUNCTION IN SYMBOL TABLE.
		for (ASPfLiteral lit : lits)
			lit.typeCheck(vtc, st, er);
		for (ALMTerm adef : attribute_defs) {
			ALMTerm attr = adef.getArg(0);
			String attr_name = attr.getName();
			List<ALMTerm> attr_params = attr.getArgs();
			int param_count = 0;
			if (attr_params != null)
				param_count = attr_params.size();
			ALMTerm rangeVar = adef.getArg(1);
			if (rangeVar.getType() != ALMTerm.VAR)
				er.newSemanticError("SID004");
			for (SortEntry s : sort_entries)
				for (FunctionEntry attr_fun : s.getAttributes())
					if (attr_fun.getFunctionName().compareTo(attr_name) == 0) {
						// matching attribute function found.
						List<SortEntry> sig = attr_fun.getSignature();
						if (param_count + 2 != sig.size()) {
							er.newSemanticError("SID005").add(attr.getLocation()).add(attr_fun.getLocation());
							continue;
						}
						for (int i = 0; i < param_count; i++) {
							ALMTerm param = attr_params.get(i);
							SortEntry param_sort = sig.get(i + 1);
							if (param.getType() != ALMTerm.VAR) {
								er.newSemanticError("SID004");
								continue;
							}
							vtc.addTypedVar(param.getName(), param_sort, param.getLocation());
						}
						vtc.addTypedVar(rangeVar.getName(), sig.get(sig.size() - 1), rangeVar.getLocation());
					}
		}

		// If Type Check passes, add sort instance declaration.
		if (vtc.typeCheckPasses(er)) {
			// Register Instances With SortEntries in SymbolTable
			for (SortEntry se : sort_entries)
				for (ALMTerm si : sort_instances)
					se.addSortInstance(si);
		}

		// body
		List<ASPfLiteral> body = null;
		if (lits != null) {
			body = new ArrayList<ASPfLiteral>();
			for (ALMTerm lit : lits)
				body.add(lit);
		}

		// Create ASPfRules for Sort Instances and Attribute Definitions
		// one_instance_def: object_constant (',' object_constant)* 'in'
		// sort_name (',' sort_name)* ('where' literal (',' literal)* )?
		// attribute_defs;
		for (ALMTerm obj_const : sort_instances)
			for (SortEntry sort_entry : sort_entries) {

				// head
				ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_IS_A, ALMTerm.FUN);
				head.addArg(obj_const);
				head.addArg(new ALMTerm(sort_entry.getSortName(), ALMTerm.ID,
						sort_entry.getLocation().getParserRuleContext()));

				ASPfRule r = aspf.newRule(ALM.STRUCTURE_SORT_INSTANCES, head, body);
				r.addComment("Sort Instance [" + obj_const + "] for sort [" + sort_entry + "].");

				// Create ASPfRules for Attribute Definitions.
				// TODO: Need forloop over attribute definitions.
				for (ALMTerm attr_def : attribute_defs) {
					// The attribute definition is missint the instance of the
					// sort
					// Need to construct a term relation over the function with
					// the instance injected in the first position.
					ALMTerm attr_fun = attr_def.getArg(0);
					ALMTerm attr_term = attr_def.getArg(1);
					ALMTerm new_fun = new ALMTerm(attr_fun.getName(), ALMTerm.FUN, attr_def.getLocation());
					new_fun.addArg(obj_const);
					if (attr_fun.getArgs() != null)
						for (ALMTerm arg : attr_fun.getArgs())
							new_fun.addArg(arg);
					// Construct a new variable for the function to equal.
					String new_var_base = attr_fun.getName().substring(0, 1).toUpperCase() + "_";
					ALMTerm new_var = new ALMTerm(vtc.newVariable(new_var_base), ALMTerm.VAR, attr_def.getLocation());
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

					ASPfRule ar = aspf.newRule(ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS, ad_head, ad_body);
					ar.addComment("Definition of attribute [" + attr_def.getArg(0).getName() + "] for instance ["
							+ obj_const.toString() + "] of sort [" + sort_entry.getSortName() + "].");
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

		ASPfLiteral head = ALM.ParseFunDef(ctx.fun_def());
		ArrayList<ASPfLiteral> body = null;
		List<LiteralContext> literals = ctx.literal();
		if (literals != null && literals.size() > 0) {
			body = new ArrayList<ASPfLiteral>();
			for (LiteralContext lit : literals)
				body.add(ALM.ParseLiteral(lit));
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

	private boolean LiteralHasSemanticErrors(ALMTerm lit) {
		boolean error_occurred = false;
		String type = lit.getType();
		String name = lit.getName();
		switch (type) {
		case ALMTerm.TERM_RELATION:
			// TODO: Massive Amount Of Work Here...
			break;
		case ALMTerm.FUN:
			// TODO: Massive Amount Of Work Here...
			switch (name) {

			case ALM.SPECIAL_FUNCTION_INSTANCE:
				break;
			case ALM.SPECIAL_FUNCTION_IS_A:
				break;
			case ALM.SPECIAL_FUNCTION_HAS_CHILD:
				break;
			case ALM.SPECIAL_FUNCTION_HAS_PARENT:
				break;
			case ALM.SPECIAL_FUNCTION_LINK:
				break;
			case ALM.SPECIAL_FUNCTION_SINK:
				break;
			case ALM.SPECIAL_FUNCTION_SOURCE:
				break;
			case ALM.SPECIAL_FUNCTION_SUBSORT:
				break;
			default:
				// TODO: Need To Handle General Boolean Function With
				// Arguments.
			}
			break;
		default:
			// Nothing Else Should Occur As Literal
			ALMTranslator.PROGRAM_FAILURE("Semantic Check Of Literals",
					"ALMTerm [" + lit.toString() + "] is not a literal");
		}
		return error_occurred;
	}
	
	

}