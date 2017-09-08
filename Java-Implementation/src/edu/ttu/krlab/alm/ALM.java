package edu.ttu.krlab.alm;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.parser.ALMParser;
import edu.ttu.krlab.alm.parser.ALMParser.Arithmetic_termContext;
import edu.ttu.krlab.alm.parser.ALMParser.AtomContext;
import edu.ttu.krlab.alm.parser.ALMParser.ExpressionContext;
import edu.ttu.krlab.alm.parser.ALMParser.FactorContext;
import edu.ttu.krlab.alm.parser.ALMParser.Fun_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Function_termContext;
import edu.ttu.krlab.alm.parser.ALMParser.Instance_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.IntegerContext;
import edu.ttu.krlab.alm.parser.ALMParser.Integer_rangeContext;
import edu.ttu.krlab.alm.parser.ALMParser.LiteralContext;
import edu.ttu.krlab.alm.parser.ALMParser.Neg_fun_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Object_constantContext;
import edu.ttu.krlab.alm.parser.ALMParser.Occurs_atomContext;
import edu.ttu.krlab.alm.parser.ALMParser.Occurs_literalContext;
import edu.ttu.krlab.alm.parser.ALMParser.One_attribute_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Pos_fun_defContext;
import edu.ttu.krlab.alm.parser.ALMParser.Predefined_sortsContext;
import edu.ttu.krlab.alm.parser.ALMParser.Sort_nameContext;
import edu.ttu.krlab.alm.parser.ALMParser.TermContext;
import edu.ttu.krlab.alm.parser.ALMParser.Var_or_objContext;

public abstract class ALM {

	public static final String SYMBOL_EQ = "=";
	public static final String SYMBOL_NEQ = "!=";
	public static final String SYMBOL_LESS = "<";
	public static final String SYMBOL_LEQ = "<=";
	public static final String SYMBOL_GREATER = ">";
	public static final String SYMBOL_GEQ = ">=";
	public static final String SYMBOL_EXP = "^";
	public static final String SYMBOL_DIV = "/";
	public static final String SYMBOL_PLUS = "+";
	public static final String SYMBOL_SUB = "-";
	public static final String SYMBOL_MULT = "*";
	public static final String SYMBOL_MOD = "mod";
	public static final String SYMBOL_OPEN_PAREN = "(";
	public static final String SYMBOL_CLOSE_PAREN = ")";

	public static final String SORT_UNKNOWN = null;
	public static final String SORT_INTEGERS = "integers";

	public static final String SORT_TIMESTEP = "timeStep";

	public static final String SORT_BOOLEANS = "booleans";
	public static final String SORT_UNIVERSE = "universe";
	public static final String SORT_ACTIONS = "actions";
	public static final String SORT_INTEGER_RANGE = "integer range";
	public static final String SPECIAL_SORT_NODES = "sort_hierarchy_nodes_";
	public static final String SPECIAL_FUNCTION_IS_A = "is_a";
	public static final String SPECIAL_FUNCTION_INSTANCE = "instance";
	public static final String SPECIAL_FUNCTION_LINK = "link";
	public static final String SPECIAL_FUNCTION_SUBSORT = "subsort";
	public static final String SPECIAL_FUNCTION_HAS_CHILD = "has_child";
	public static final String SPECIAL_FUNCTION_HAS_PARENT = "has_parent";
	public static final String SPECIAL_FUNCTION_SINK = "sink";
	public static final String SPECIAL_FUNCTION_SOURCE = "source";
	public static final String SPECIAL_FUNCTION_OCCURS = "occurs";
	public static final String RULES_STATIC_FUNCTIONS = "Auxiliary Rules For Static Functions";
	public static final String RULES_FLUENT_FUNCTIONS = "Auxiliary Rules For Fluent Functions";
	public static final String AXIOMS_DYNAMIC_CAUSAL_LAWS = "Axioms - Dynamic Causal Laws";
	public static final String AXIOMS_EXECUTABILITY_CONDITIONS = "Axioms - Executability Conditions";
	public static final String AXIOMS_STATE_CONSTRAINTS = "Axioms - State Constraints";
	public static final String AXIOMS_STATE_CONSTRAINTS_STATIC = "Axioms - State Constraints With Only Static Functions";
	public static final String AXIOMS_STATE_CONSTRAINTS_FLUENT = "Axioms - State Constraints Containing Fluent Functions";
	public static final String AXIOMS_DEFINITIONS = "Axioms - Function Definitions";
	public static final String AXIOMS_DEFINITIONS_STATIC = "Axioms - Satic Function Definitions";
	public static final String AXIOMS_DEFINITIONS_FLUENT = "Axioms - Fluent Function Definitions";
	public static final String THEORY_CONSTANT_DECLARATIONS = "Theory - Constant Declarations";
	public static final String STRUCTURE_CONSTANT_DEFINITIONS = "Structure - Attribute Definitions";
	public static final String STRUCTURE_SORT_INSTANCES = "Structure - Sort Instances";
	public static final String STRUCTURE_ATTRIBUTE_DEFINITIONS = "Structure - Attribute Definitions";
	public static final String STRUCTURE_STATIC_FUNCTION_DEFINITIONS = "Structure - Static Function Definitions";
	public static final String OPTIMIZATION_ADD_FACTS_FROM_PRE_MODEL_ANSWERSET = "Optimization - All Facts Computed By Premodel Program.";
	public static final String DOM_PREFIX = "dom_";
	public static final String HISTORY_OBSERVED = "observed";
	public static final String HISTORY_HAPPENED = "happened";
	public static final String HISTORY = "History";

	// literal: atom | '-' atom | term relation term ;
	public static ALMTerm ParseLiteral(LiteralContext litcon) {
		AtomContext acon = litcon.atom();
		if (acon != null) {
			ALMTerm atomterm = ALM.ParseAtom(acon);
			if (litcon.getChild(0) instanceof TerminalNode)
				atomterm.setSign(ALMTerm.SIGN_NEG);
			else
				atomterm.setSign(ALMTerm.SIGN_POS);
			return atomterm;
		} else if (litcon.term() != null) {
			ALMTerm left = ALM.ParseTerm(litcon.term(0));
			ALMTerm right = ALM.ParseTerm(litcon.term(1));
			return new ALMTerm(litcon.relation().getText(), ALMTerm.TERM_RELATION, litcon).addArg(left).addArg(right);
		}
		return null;
	}

	// occurs_atom: OCCURS '(' var_or_obj ')';
	public static ALMTerm ParseOccursAtom(Occurs_atomContext occurs_atom) {

		ALMTerm occurs = new ALMTerm(occurs_atom.OCCURS().getText(), ALMTerm.FUN, occurs_atom);
		occurs.addArg(ALM.ParseVarObj(occurs_atom.var_or_obj()));
		return occurs;
	}

	// atom: instance_atom | is_a_atom | link_atom | subsort_atom | has_child_atom |
	// has_parent_atom | sink_atom | source_atom | function_term
	private static ALMTerm ParseAtom(AtomContext acon) {
		if (acon.instance_atom() != null) {
			return ALM.ParseInstanceAtom(acon.instance_atom());
		} else if (acon.is_a_atom() != null) {
			return ALM.ParseAtomSortSort(acon.is_a_atom());
		} else if (acon.link_atom() != null) {
			return ALM.ParseAtomSortSort(acon.link_atom());
		} else if (acon.subsort_atom() != null) {
			return ALM.ParseAtomSortSort(acon.subsort_atom());
		} else if (acon.has_child_atom() != null) {
			return ALM.ParseAtomSort(acon.has_child_atom());
		} else if (acon.has_parent_atom() != null) {
			return ALM.ParseAtomSort(acon.has_parent_atom());
		} else if (acon.sink_atom() != null) {
			return ALM.ParseAtomSort(acon.sink_atom());
		} else if (acon.source_atom() != null) {
			return ALM.ParseAtomSort(acon.source_atom());
		} else if (acon.function_term() != null) {
			ALMTerm functionTerm = ALM.ParseFunction(acon.function_term());
			functionTerm.setType(ALMTerm.FUN);
			return functionTerm;
		}
		return null;
	}

	// instance_atom: INSTANCE '(' var_or_obj ',' sort_name ')';

	public static ALMTerm ParseInstanceAtom(Instance_atomContext ia) {
		ALMTerm left = ALM.ParseVarObj((ALMParser.Var_or_objContext) ia.getChild(2));
		ALMTerm right = ALM.ParseSortName((ALMParser.Sort_nameContext) ia.getChild(4));
		return new ALMTerm(ia.getChild(0).getText(), ALMTerm.FUN, ia).addArg(left).addArg(right);
	}

	// link_atom: LINK '(' sort_name ',' sort_name ')';
	// is_a_atom: IS_A '(' sort_name ',' sort_name ')';
	// subsort_atom: SUBSORT '(' sort_name ',' sort_name ')';
	private static ALMTerm ParseAtomSortSort(ParserRuleContext con) {
		ALMTerm left = ALM.ParseSortName((ALMParser.Sort_nameContext) con.getChild(2));
		ALMTerm right = ALM.ParseSortName((ALMParser.Sort_nameContext) con.getChild(4));
		return new ALMTerm(con.getChild(0).getText(), ALMTerm.FUN, con).addArg(left).addArg(right);

	}

	// has_child_atom: HAS_CHILD '(' sort_name ')';
	// has_parent_atom: HAS_PARENT '(' sort_name ')';
	// sink_atom: SINK '(' sort_name ')';
	// source_atom: SOURCE '(' sort_name ')';
	private static ALMTerm ParseAtomSort(ParserRuleContext con) {
		ALMTerm left = ALM.ParseSortName((ALMParser.Sort_nameContext) con.getChild(2));
		return new ALMTerm(con.getChild(0).getText(), ALMTerm.FUN, con).addArg(left);

	}

	// sort_name: predefined_sorts | UNIVERSE | ACTIONS | ID;
	private static ALMTerm ParseSortName(Sort_nameContext sn) {
		if (sn.predefined_sorts() != null)
			return ALM.ParsePredefinedSort(sn.predefined_sorts());
		else if (sn.UNIVERSE() != null)
			return new ALMTerm(sn.UNIVERSE().getText(), ALMTerm.SORT, sn);
		else if (sn.ACTIONS() != null)
			return new ALMTerm(sn.ACTIONS().getText(), ALMTerm.SORT, sn);
		else if (sn.ID() != null)
			return new ALMTerm(sn.ID().getText(), ALMTerm.ID, sn);
		return null;
	}

	// predefined_sorts: BOOLEAN | INTEGERS | integer_range;
	private static ALMTerm ParsePredefinedSort(Predefined_sortsContext ps) {
		if (ps.BOOLEAN() != null)
			return new ALMTerm(ps.BOOLEAN().getText(), ALMTerm.SORT, ps);
		else if (ps.INTEGERS() != null)
			return new ALMTerm(ps.INTEGERS().getText(), ALMTerm.SORT, ps);
		else if (ps.integer_range() != null)
			return ALM.ParseIntRange(ps.integer_range());
		return null;
	}

	// integer_range: '[' integer '..' integer ']';
	private static ALMTerm ParseIntRange(Integer_rangeContext ir) {
		ALMTerm left = ALM.ParseInteger(ir.integer(0));
		ALMTerm right = ALM.ParseInteger(ir.integer(1));
		return new ALMTerm(ir.getText(), ALMTerm.SORT, ir).addArg(left).addArg(right);
	}

	// integer : ZERO | POSINT | NEGINT;
	private static ALMTerm ParseInteger(IntegerContext i) {
		return new ALMTerm(i.getText(), ALMTerm.INT, i);
	}

	// var_or_obj: (object_constant | VAR);
	private static ALMTerm ParseVarObj(Var_or_objContext vo) {
		if (vo.object_constant() != null)
			return ALM.ParseObject(vo.object_constant());
		else if (vo.VAR() != null)
			return new ALMTerm(vo.VAR().getText(), ALMTerm.VAR, vo);
		return null;
	}

	public static ALMTerm ParseALMTerm(ParserRuleContext con) {
		if (con instanceof ALMParser.Object_constantContext)
			return ALM.ParseObject((ALMParser.Object_constantContext) con);
		if (con instanceof ALMParser.Function_termContext)
			return ALM.ParseFunction((ALMParser.Function_termContext) con);

		return null;
	}

	// function_term: object_constant;
	private static ALMTerm ParseFunction(Function_termContext con) {
		ALMTerm function = ALM.ParseObject(con.object_constant());
		function.setType(ALMTerm.FUN);
		return function;
	}

	// object_constant: ID ( '(' term (',' term)* ')')?; //Pattern for any object
	// instance of any sort.
	private static ALMTerm ParseObject(Object_constantContext con) {
		TerminalNode id = con.ID();
		List<TermContext> terms = con.term();
		if (terms == null || terms.size() == 0) {
			return new ALMTerm(id.getText(), ALMTerm.ID, con);
		} else {
			ALMTerm fterm = new ALMTerm(id.getText(), ALMTerm.FUN, con);
			for (TermContext tcon : terms)
				fterm.addArg(ALM.ParseTerm(tcon));
			return fterm;
		}
	}

	// term: BOOL | VAR | ID | integer | function_term | expression;
	public static ALMTerm ParseTerm(TermContext tcon) {

		if (tcon.BOOL() != null) {
			return new ALMTerm(tcon.BOOL().getText(), ALMTerm.BOOL, tcon);
		}

		if (tcon.VAR() != null) {
			return new ALMTerm(tcon.VAR().getText(), ALMTerm.VAR, tcon);
		}
		if (tcon.ID() != null) {
			return new ALMTerm(tcon.ID().getText(), ALMTerm.ID, tcon);
		}
		if (tcon.integer() != null) {
			return new ALMTerm(tcon.integer().getText(), ALMTerm.INT, tcon);
		}
		if (tcon.function_term() != null) {
			return ALM.ParseFunction(tcon.function_term());
		}
		if (tcon.expression() != null) {
			return ALM.ParseExpression(tcon.expression());
		}
		return null;
	}

	// expression: expression '+' arithmetic_term | expression '-' arithmetic_term |
	// arithmetic_term;
	private static ALMTerm ParseExpression(ExpressionContext expression) {
		if (expression.expression() == null) {
			return ALM.ParseArithmetic(expression.arithmetic_term());
		}
		ALMTerm left = ALM.ParseExpression(expression.expression());
		ALMTerm right = ALM.ParseArithmetic(expression.arithmetic_term());

		ALMTerm expr;
		TerminalNode op = (TerminalNode) expression.getChild(1);
		if (SYMBOL_PLUS.compareTo(op.getText()) == 0)
			expr = new ALMTerm(op.getText(), ALMTerm.MATH_ADD, expression);
		else if (SYMBOL_SUB.compareTo(op.getText()) == 0)
			expr = new ALMTerm(op.getText(), ALMTerm.MATH_SUB, expression);
		else
			return null;
		expr.addArg(left);
		expr.addArg(right);

		return expr;
	}

	// arithmetic_term: arithmetic_term '*' factor | arithmetic_term '/' factor |
	// arithmetic_term 'mod' factor | factor '^' factor | factor;
	private static ALMTerm ParseArithmetic(Arithmetic_termContext aterm) {
		if (aterm.arithmetic_term() == null) {
			// could be factor^factor or factor.
			List<FactorContext> factors = aterm.factor();
			if (factors.size() == 1)
				return ALM.ParseFactor(factors.get(0));
			else {
				ALMTerm exponent = new ALMTerm(ALM.SYMBOL_EXP, ALMTerm.MATH_EXP, aterm);
				exponent.addArg(ALM.ParseFactor(factors.get(0)));
				exponent.addArg(ALM.ParseFactor(factors.get(1)));
				return exponent;
			}
		} else {
			// arithmetic term is present.
			ALMTerm arith;
			TerminalNode op = (TerminalNode) aterm.getChild(1);
			if (SYMBOL_MULT.compareTo(op.getText()) == 0)
				arith = new ALMTerm(op.getText(), ALMTerm.MATH_MULT, aterm);
			else if (SYMBOL_DIV.compareTo(op.getText()) == 0)
				arith = new ALMTerm(op.getText(), ALMTerm.MATH_DIV, aterm);
			else if (SYMBOL_MOD.compareTo(op.getText()) == 0)
				arith = new ALMTerm(op.getText(), ALMTerm.MATH_MOD, aterm);
			else
				return null;
			arith.addArg(ALM.ParseArithmetic(aterm.arithmetic_term()));
			arith.addArg(ALM.ParseFactor(aterm.factor(0)));
			return arith;
		}
	}

	// factor: VAR | '-' VAR | integer | function_term | '-' function_term | '('
	// expression ')' | '-' '(' expression ')';
	private static ALMTerm ParseFactor(FactorContext factor) {
		if (factor.integer() != null)
			return new ALMTerm(factor.getText(), ALMTerm.INT, factor);
		if (factor.function_term() != null)
			return ALM.ParseFunction(factor.function_term());
		TerminalNode first = (TerminalNode) factor.getChild(0);
		if (SYMBOL_SUB.compareTo(first.getText()) == 0) {
			ALMTerm neg = new ALMTerm("-", ALMTerm.MATH_NEG, factor);
			if (factor.VAR() != null)
				neg.addArg(new ALMTerm(factor.getText(), ALMTerm.VAR, factor));
			else if (factor.function_term() != null)
				neg.addArg(ALM.ParseFunction(factor.function_term()));
			else if (factor.expression() != null)
				neg.addArg(ALM.ParseExpression(factor.expression()));
			return neg;
		} else if (SYMBOL_OPEN_PAREN.compareTo(first.getText()) == 0) {
			return ALM.ParseExpression(factor.expression());
		} else {
			return new ALMTerm(first.getText(), ALMTerm.VAR, factor);
		}
	}

	// fun_def : (pos_fun_def | neg_fun_def);
	public static ALMTerm ParseFunDef(Fun_defContext fun_def) {
		if (fun_def.pos_fun_def() != null)
			return ALM.ParsePosFunDef(fun_def.pos_fun_def());
		else if (fun_def.neg_fun_def() != null)
			return ALM.ParseNegFunDef(fun_def.neg_fun_def());
		return null;
	}

	// neg_fun_def: function_term NEQ term
	private static ALMTerm ParseNegFunDef(Neg_fun_defContext nfd) {
		ALMTerm left = ALM.ParseFunction(nfd.function_term());
		ALMTerm right = ALM.ParseTerm(nfd.term());
		return new ALMTerm(SYMBOL_NEQ, ALMTerm.TERM_RELATION, nfd).addArg(left).addArg(right);
	}

	// pos_fun_def: function_term EQ term | function_term | '-' function_term;
	public static ALMTerm ParsePosFunDef(Pos_fun_defContext pfd) {
		if (pfd.term() != null) {
			ALMTerm left = ALM.ParseFunction(pfd.function_term());
			ALMTerm right = ALM.ParseTerm(pfd.term());
			return new ALMTerm(SYMBOL_EQ, ALMTerm.TERM_RELATION, pfd).addArg(left).addArg(right);
		} else {
			ALMTerm function = ALM.ParseFunction(pfd.function_term());
			if (pfd.function_term() != pfd.getChild(0))
				function.setSign(ALMTerm.SIGN_NEG); // the first child was not the function term
			return function;
		}
	}

	// one_attribute_def: function_term EQ term
	public static ALMTerm ParseAttrDef(One_attribute_defContext attr_def) {
		return new ALMTerm(SYMBOL_EQ, ALMTerm.ATTR_DEF, attr_def).addArg(ALM.ParseFunction(attr_def.function_term()))
				.addArg(ALM.ParseTerm(attr_def.term()));
	}

	public static ALMTerm ParseIntegerRangeFromString(String sort_text) {
		// TODO: NOT YET DONE, comment out to find out where it is used.
		return null;
	}

	// occurs_literal: occurs_atom | '-' occurs_atom;
	public static ALMTerm ParseOccursLiteral(Occurs_literalContext olc) {
		ParseTree first = olc.getChild(0);
		Occurs_atomContext oc_atom = olc.occurs_atom();
		ALMTerm parsed_oc_atom = ALM.ParseOccursAtom(oc_atom);
		if (first != oc_atom)
			parsed_oc_atom.setSign(ALMTerm.SIGN_NEG);
		return parsed_oc_atom;
	}

}
