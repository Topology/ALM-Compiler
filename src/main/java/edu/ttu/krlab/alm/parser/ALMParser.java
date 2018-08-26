package edu.ttu.krlab.alm.parser;
// Generated from ALM.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import static org.antlr.v4.runtime.Recognizer.EOF;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ALMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, COMMENT=15, WhiteSpace=16, 
		MOD=17, EQ=18, NEQ=19, ARITH_OP=20, COMP_REL=21, RIGHT_ARROW=22, OCCURS=23, 
		INSTANCE=24, IS_A=25, HAS_CHILD=26, HAS_PARENT=27, LINK=28, SOURCE=29, 
		SINK=30, SUBSORT=31, DOM=32, SORT=33, STATE=34, CONSTRAINTS=35, FUNCTION=36, 
		DECLARATIONS=37, DEFINITIONS=38, SYSTEM=39, DESCRIPTION=40, THEORY=41, 
		MODULE=42, IMPORT=43, FROM=44, DEPENDS=45, ON=46, ATTRIBUTES=47, OBJECT=48, 
		CONSTANT=49, STATICS=50, FLUENTS=51, BASIC=52, DEFINED=53, TOTAL=54, AXIOMS=55, 
		DYNAMIC=56, CAUSAL=57, LAWS=58, EXECUTABILITY=59, CONDITIONS=60, CAUSES=61, 
		IMPOSSIBLE=62, IF=63, FALSE=64, TRUE=65, STRUCTURE=66, IN=67, WHERE=68, 
		VALUE=69, OF=70, INSTANCES=71, TEMPORAL=72, PROJECTION=73, MAX=74, STEPS=75, 
		HISTORY=76, OBSERVED=77, HAPPENED=78, PLANNING=79, PROBLEM=80, DIAGNOSTIC=81, 
		GOAL=82, SITUATION=83, WHEN=84, NORMAL=85, ACTION=86, ADDITIONAL=87, RESTRICTIONS=88, 
		PERMISSIONS=89, POSSIBLE=90, AVOID=91, BOOLEANS=92, INTEGERS=93, UNIVERSE=94, 
		ACTIONS=95, CURRENT=96, TIME=97, ID=98, VAR=99, POSINT=100, NEGINT=101, 
		ZERO=102;
	public static final int
		RULE_bool = 0, RULE_nat_num = 1, RULE_integer = 2, RULE_relation = 3, 
		RULE_id = 4, RULE_alm_name = 5, RULE_object_constant = 6, RULE_function_term = 7, 
		RULE_term = 8, RULE_var_or_obj = 9, RULE_expression = 10, RULE_arithmetic_term = 11, 
		RULE_factor = 12, RULE_occurs_atom = 13, RULE_instance_atom = 14, RULE_is_a_atom = 15, 
		RULE_link_atom = 16, RULE_subsort_atom = 17, RULE_has_child_atom = 18, 
		RULE_has_parent_atom = 19, RULE_sink_atom = 20, RULE_source_atom = 21, 
		RULE_atom = 22, RULE_literal = 23, RULE_occurs_literal = 24, RULE_alm_file = 25, 
		RULE_library_name = 26, RULE_sys_desc_name = 27, RULE_system_description = 28, 
		RULE_theory_name = 29, RULE_theory = 30, RULE_module_name = 31, RULE_sequence_of_modules = 32, 
		RULE_module = 33, RULE_module_body = 34, RULE_module_dependencies = 35, 
		RULE_one_dependency = 36, RULE_integer_range = 37, RULE_predefined_sorts = 38, 
		RULE_sort_name = 39, RULE_new_sort_name = 40, RULE_sort_declarations = 41, 
		RULE_one_sort_decl = 42, RULE_attributes = 43, RULE_one_attribute_decl = 44, 
		RULE_constant_declarations = 45, RULE_one_constant_decl = 46, RULE_function_name = 47, 
		RULE_function_declarations = 48, RULE_static_declarations = 49, RULE_fluent_declarations = 50, 
		RULE_basic_function_declarations = 51, RULE_defined_function_declarations = 52, 
		RULE_one_function_decl = 53, RULE_pos_fun_def = 54, RULE_neg_fun_def = 55, 
		RULE_fun_def = 56, RULE_axioms = 57, RULE_dynamic_causal_laws = 58, RULE_executability_conditions = 59, 
		RULE_state_constraints = 60, RULE_function_definitions = 61, RULE_one_dynamic_causal_law = 62, 
		RULE_one_executability_condition = 63, RULE_one_state_constraint = 64, 
		RULE_one_definition = 65, RULE_structure_name = 66, RULE_structure = 67, 
		RULE_constant_defs = 68, RULE_one_constant_def = 69, RULE_instance_defs = 70, 
		RULE_one_instance_def = 71, RULE_attribute_defs = 72, RULE_one_attribute_def = 73, 
		RULE_statics_defs = 74, RULE_one_static_def = 75, RULE_solver_mode = 76, 
		RULE_max_steps = 77, RULE_current_time = 78, RULE_history = 79, RULE_observed = 80, 
		RULE_happened = 81, RULE_added_constraints = 82, RULE_one_added_constraint = 83, 
		RULE_action_conditions = 84, RULE_one_action_condition = 85, RULE_temporal_projection = 86, 
		RULE_planning_problem = 87, RULE_goal_state = 88, RULE_diagnostic_problem = 89, 
		RULE_normal_conditions = 90, RULE_one_normal_condition = 91, RULE_current_state = 92;
	public static final String[] ruleNames = {
		"bool", "nat_num", "integer", "relation", "id", "alm_name", "object_constant", 
		"function_term", "term", "var_or_obj", "expression", "arithmetic_term", 
		"factor", "occurs_atom", "instance_atom", "is_a_atom", "link_atom", "subsort_atom", 
		"has_child_atom", "has_parent_atom", "sink_atom", "source_atom", "atom", 
		"literal", "occurs_literal", "alm_file", "library_name", "sys_desc_name", 
		"system_description", "theory_name", "theory", "module_name", "sequence_of_modules", 
		"module", "module_body", "module_dependencies", "one_dependency", "integer_range", 
		"predefined_sorts", "sort_name", "new_sort_name", "sort_declarations", 
		"one_sort_decl", "attributes", "one_attribute_decl", "constant_declarations", 
		"one_constant_decl", "function_name", "function_declarations", "static_declarations", 
		"fluent_declarations", "basic_function_declarations", "defined_function_declarations", 
		"one_function_decl", "pos_fun_def", "neg_fun_def", "fun_def", "axioms", 
		"dynamic_causal_laws", "executability_conditions", "state_constraints", 
		"function_definitions", "one_dynamic_causal_law", "one_executability_condition", 
		"one_state_constraint", "one_definition", "structure_name", "structure", 
		"constant_defs", "one_constant_def", "instance_defs", "one_instance_def", 
		"attribute_defs", "one_attribute_def", "statics_defs", "one_static_def", 
		"solver_mode", "max_steps", "current_time", "history", "observed", "happened", 
		"added_constraints", "one_added_constraint", "action_conditions", "one_action_condition", 
		"temporal_projection", "planning_problem", "goal_state", "diagnostic_problem", 
		"normal_conditions", "one_normal_condition", "current_state"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'+'", "'-'", "'*'", "'/'", "'^'", "'.'", "'..'", 
		"'::'", "':'", "'{'", "'}'", null, null, "'mod'", "'='", "'!='", null, 
		null, "'->'", "'occurs'", "'instance'", "'is_a'", "'has_child'", "'has_parent'", 
		"'link'", "'source'", "'sink'", "'subsort'", "'DOM'", "'sort'", "'state'", 
		"'constraints'", "'function'", "'declarations'", "'definitions'", "'system'", 
		"'description'", "'theory'", "'module'", "'import'", "'from'", "'depends'", 
		"'on'", "'attributes'", "'object'", "'constant'", "'statics'", "'fluents'", 
		"'basic'", "'defined'", "'total'", "'axioms'", "'dynamic'", "'causal'", 
		"'laws'", "'executability'", "'conditions'", "'causes'", "'impossible'", 
		"'if'", "'false'", "'true'", "'structure'", "'in'", "'where'", "'value'", 
		"'of'", "'instances'", "'temporal'", "'projection'", "'max'", "'steps'", 
		"'history'", "'observed'", "'happened'", "'planning'", "'problem'", "'diagnostic'", 
		"'goal'", "'situation'", "'when'", "'normal'", "'action'", "'additional'", 
		"'restrictions'", "'permissions'", "'possible'", "'avoid'", "'booleans'", 
		"'integers'", "'universe'", "'actions'", "'current'", "'time'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "COMMENT", "WhiteSpace", "MOD", "EQ", "NEQ", "ARITH_OP", 
		"COMP_REL", "RIGHT_ARROW", "OCCURS", "INSTANCE", "IS_A", "HAS_CHILD", 
		"HAS_PARENT", "LINK", "SOURCE", "SINK", "SUBSORT", "DOM", "SORT", "STATE", 
		"CONSTRAINTS", "FUNCTION", "DECLARATIONS", "DEFINITIONS", "SYSTEM", "DESCRIPTION", 
		"THEORY", "MODULE", "IMPORT", "FROM", "DEPENDS", "ON", "ATTRIBUTES", "OBJECT", 
		"CONSTANT", "STATICS", "FLUENTS", "BASIC", "DEFINED", "TOTAL", "AXIOMS", 
		"DYNAMIC", "CAUSAL", "LAWS", "EXECUTABILITY", "CONDITIONS", "CAUSES", 
		"IMPOSSIBLE", "IF", "FALSE", "TRUE", "STRUCTURE", "IN", "WHERE", "VALUE", 
		"OF", "INSTANCES", "TEMPORAL", "PROJECTION", "MAX", "STEPS", "HISTORY", 
		"OBSERVED", "HAPPENED", "PLANNING", "PROBLEM", "DIAGNOSTIC", "GOAL", "SITUATION", 
		"WHEN", "NORMAL", "ACTION", "ADDITIONAL", "RESTRICTIONS", "PERMISSIONS", 
		"POSSIBLE", "AVOID", "BOOLEANS", "INTEGERS", "UNIVERSE", "ACTIONS", "CURRENT", 
		"TIME", "ID", "VAR", "POSINT", "NEGINT", "ZERO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ALM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ALMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ALMParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ALMParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nat_numContext extends ParserRuleContext {
		public TerminalNode ZERO() { return getToken(ALMParser.ZERO, 0); }
		public TerminalNode POSINT() { return getToken(ALMParser.POSINT, 0); }
		public Nat_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nat_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterNat_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitNat_num(this);
		}
	}

	public final Nat_numContext nat_num() throws RecognitionException {
		Nat_numContext _localctx = new Nat_numContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nat_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_la = _input.LA(1);
			if ( !(_la==POSINT || _la==ZERO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode ZERO() { return getToken(ALMParser.ZERO, 0); }
		public TerminalNode POSINT() { return getToken(ALMParser.POSINT, 0); }
		public TerminalNode NEGINT() { return getToken(ALMParser.NEGINT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_la = _input.LA(1);
			if ( !(((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (POSINT - 100)) | (1L << (NEGINT - 100)) | (1L << (ZERO - 100)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(ALMParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ALMParser.NEQ, 0); }
		public TerminalNode COMP_REL() { return getToken(ALMParser.COMP_REL, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitRelation(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << COMP_REL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode OCCURS() { return getToken(ALMParser.OCCURS, 0); }
		public TerminalNode INSTANCE() { return getToken(ALMParser.INSTANCE, 0); }
		public TerminalNode IS_A() { return getToken(ALMParser.IS_A, 0); }
		public TerminalNode HAS_CHILD() { return getToken(ALMParser.HAS_CHILD, 0); }
		public TerminalNode HAS_PARENT() { return getToken(ALMParser.HAS_PARENT, 0); }
		public TerminalNode LINK() { return getToken(ALMParser.LINK, 0); }
		public TerminalNode SOURCE() { return getToken(ALMParser.SOURCE, 0); }
		public TerminalNode SINK() { return getToken(ALMParser.SINK, 0); }
		public TerminalNode SUBSORT() { return getToken(ALMParser.SUBSORT, 0); }
		public TerminalNode DOM() { return getToken(ALMParser.DOM, 0); }
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
		public TerminalNode MOD() { return getToken(ALMParser.MOD, 0); }
		public TerminalNode SORT() { return getToken(ALMParser.SORT, 0); }
		public TerminalNode STATE() { return getToken(ALMParser.STATE, 0); }
		public TerminalNode CONSTRAINTS() { return getToken(ALMParser.CONSTRAINTS, 0); }
		public TerminalNode FUNCTION() { return getToken(ALMParser.FUNCTION, 0); }
		public TerminalNode DECLARATIONS() { return getToken(ALMParser.DECLARATIONS, 0); }
		public TerminalNode DEFINITIONS() { return getToken(ALMParser.DEFINITIONS, 0); }
		public TerminalNode SYSTEM() { return getToken(ALMParser.SYSTEM, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ALMParser.DESCRIPTION, 0); }
		public TerminalNode THEORY() { return getToken(ALMParser.THEORY, 0); }
		public TerminalNode MODULE() { return getToken(ALMParser.MODULE, 0); }
		public TerminalNode IMPORT() { return getToken(ALMParser.IMPORT, 0); }
		public TerminalNode FROM() { return getToken(ALMParser.FROM, 0); }
		public TerminalNode DEPENDS() { return getToken(ALMParser.DEPENDS, 0); }
		public TerminalNode ON() { return getToken(ALMParser.ON, 0); }
		public TerminalNode ATTRIBUTES() { return getToken(ALMParser.ATTRIBUTES, 0); }
		public TerminalNode OBJECT() { return getToken(ALMParser.OBJECT, 0); }
		public TerminalNode CONSTANT() { return getToken(ALMParser.CONSTANT, 0); }
		public TerminalNode STATICS() { return getToken(ALMParser.STATICS, 0); }
		public TerminalNode FLUENTS() { return getToken(ALMParser.FLUENTS, 0); }
		public TerminalNode BASIC() { return getToken(ALMParser.BASIC, 0); }
		public TerminalNode DEFINED() { return getToken(ALMParser.DEFINED, 0); }
		public TerminalNode TOTAL() { return getToken(ALMParser.TOTAL, 0); }
		public TerminalNode AXIOMS() { return getToken(ALMParser.AXIOMS, 0); }
		public TerminalNode DYNAMIC() { return getToken(ALMParser.DYNAMIC, 0); }
		public TerminalNode CAUSAL() { return getToken(ALMParser.CAUSAL, 0); }
		public TerminalNode LAWS() { return getToken(ALMParser.LAWS, 0); }
		public TerminalNode EXECUTABILITY() { return getToken(ALMParser.EXECUTABILITY, 0); }
		public TerminalNode CONDITIONS() { return getToken(ALMParser.CONDITIONS, 0); }
		public TerminalNode CAUSES() { return getToken(ALMParser.CAUSES, 0); }
		public TerminalNode IMPOSSIBLE() { return getToken(ALMParser.IMPOSSIBLE, 0); }
		public TerminalNode IF() { return getToken(ALMParser.IF, 0); }
		public TerminalNode FALSE() { return getToken(ALMParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(ALMParser.TRUE, 0); }
		public TerminalNode STRUCTURE() { return getToken(ALMParser.STRUCTURE, 0); }
		public TerminalNode IN() { return getToken(ALMParser.IN, 0); }
		public TerminalNode WHERE() { return getToken(ALMParser.WHERE, 0); }
		public TerminalNode VALUE() { return getToken(ALMParser.VALUE, 0); }
		public TerminalNode OF() { return getToken(ALMParser.OF, 0); }
		public TerminalNode INSTANCES() { return getToken(ALMParser.INSTANCES, 0); }
		public TerminalNode TEMPORAL() { return getToken(ALMParser.TEMPORAL, 0); }
		public TerminalNode PROJECTION() { return getToken(ALMParser.PROJECTION, 0); }
		public TerminalNode MAX() { return getToken(ALMParser.MAX, 0); }
		public TerminalNode STEPS() { return getToken(ALMParser.STEPS, 0); }
		public TerminalNode HISTORY() { return getToken(ALMParser.HISTORY, 0); }
		public TerminalNode OBSERVED() { return getToken(ALMParser.OBSERVED, 0); }
		public TerminalNode HAPPENED() { return getToken(ALMParser.HAPPENED, 0); }
		public TerminalNode PLANNING() { return getToken(ALMParser.PLANNING, 0); }
		public TerminalNode PROBLEM() { return getToken(ALMParser.PROBLEM, 0); }
		public TerminalNode DIAGNOSTIC() { return getToken(ALMParser.DIAGNOSTIC, 0); }
		public TerminalNode GOAL() { return getToken(ALMParser.GOAL, 0); }
		public TerminalNode SITUATION() { return getToken(ALMParser.SITUATION, 0); }
		public TerminalNode WHEN() { return getToken(ALMParser.WHEN, 0); }
		public TerminalNode NORMAL() { return getToken(ALMParser.NORMAL, 0); }
		public TerminalNode ACTION() { return getToken(ALMParser.ACTION, 0); }
		public TerminalNode ADDITIONAL() { return getToken(ALMParser.ADDITIONAL, 0); }
		public TerminalNode RESTRICTIONS() { return getToken(ALMParser.RESTRICTIONS, 0); }
		public TerminalNode PERMISSIONS() { return getToken(ALMParser.PERMISSIONS, 0); }
		public TerminalNode POSSIBLE() { return getToken(ALMParser.POSSIBLE, 0); }
		public TerminalNode AVOID() { return getToken(ALMParser.AVOID, 0); }
		public TerminalNode BOOLEANS() { return getToken(ALMParser.BOOLEANS, 0); }
		public TerminalNode INTEGERS() { return getToken(ALMParser.INTEGERS, 0); }
		public TerminalNode UNIVERSE() { return getToken(ALMParser.UNIVERSE, 0); }
		public TerminalNode ACTIONS() { return getToken(ALMParser.ACTIONS, 0); }
		public TerminalNode CURRENT() { return getToken(ALMParser.CURRENT, 0); }
		public TerminalNode TIME() { return getToken(ALMParser.TIME, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_id);
		try {
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OCCURS:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(OCCURS);
				}
				break;
			case INSTANCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(INSTANCE);
				}
				break;
			case IS_A:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(IS_A);
				}
				break;
			case HAS_CHILD:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(HAS_CHILD);
				}
				break;
			case HAS_PARENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(198);
				match(HAS_PARENT);
				}
				break;
			case LINK:
				enterOuterAlt(_localctx, 6);
				{
				setState(199);
				match(LINK);
				}
				break;
			case SOURCE:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				match(SOURCE);
				}
				break;
			case SINK:
				enterOuterAlt(_localctx, 8);
				{
				setState(201);
				match(SINK);
				}
				break;
			case SUBSORT:
				enterOuterAlt(_localctx, 9);
				{
				setState(202);
				match(SUBSORT);
				}
				break;
			case DOM:
				enterOuterAlt(_localctx, 10);
				{
				setState(203);
				match(DOM);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 11);
				{
				setState(204);
				match(ID);
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 12);
				{
				setState(205);
				match(MOD);
				}
				break;
			case SORT:
				enterOuterAlt(_localctx, 13);
				{
				setState(206);
				match(SORT);
				}
				break;
			case STATE:
				enterOuterAlt(_localctx, 14);
				{
				setState(207);
				match(STATE);
				}
				break;
			case CONSTRAINTS:
				enterOuterAlt(_localctx, 15);
				{
				setState(208);
				match(CONSTRAINTS);
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 16);
				{
				setState(209);
				match(FUNCTION);
				}
				break;
			case DECLARATIONS:
				enterOuterAlt(_localctx, 17);
				{
				setState(210);
				match(DECLARATIONS);
				}
				break;
			case DEFINITIONS:
				enterOuterAlt(_localctx, 18);
				{
				setState(211);
				match(DEFINITIONS);
				}
				break;
			case SYSTEM:
				enterOuterAlt(_localctx, 19);
				{
				setState(212);
				match(SYSTEM);
				}
				break;
			case DESCRIPTION:
				enterOuterAlt(_localctx, 20);
				{
				setState(213);
				match(DESCRIPTION);
				}
				break;
			case THEORY:
				enterOuterAlt(_localctx, 21);
				{
				setState(214);
				match(THEORY);
				}
				break;
			case MODULE:
				enterOuterAlt(_localctx, 22);
				{
				setState(215);
				match(MODULE);
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 23);
				{
				setState(216);
				match(IMPORT);
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 24);
				{
				setState(217);
				match(FROM);
				}
				break;
			case DEPENDS:
				enterOuterAlt(_localctx, 25);
				{
				setState(218);
				match(DEPENDS);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 26);
				{
				setState(219);
				match(ON);
				}
				break;
			case ATTRIBUTES:
				enterOuterAlt(_localctx, 27);
				{
				setState(220);
				match(ATTRIBUTES);
				}
				break;
			case OBJECT:
				enterOuterAlt(_localctx, 28);
				{
				setState(221);
				match(OBJECT);
				}
				break;
			case CONSTANT:
				enterOuterAlt(_localctx, 29);
				{
				setState(222);
				match(CONSTANT);
				}
				break;
			case STATICS:
				enterOuterAlt(_localctx, 30);
				{
				setState(223);
				match(STATICS);
				}
				break;
			case FLUENTS:
				enterOuterAlt(_localctx, 31);
				{
				setState(224);
				match(FLUENTS);
				}
				break;
			case BASIC:
				enterOuterAlt(_localctx, 32);
				{
				setState(225);
				match(BASIC);
				}
				break;
			case DEFINED:
				enterOuterAlt(_localctx, 33);
				{
				setState(226);
				match(DEFINED);
				}
				break;
			case TOTAL:
				enterOuterAlt(_localctx, 34);
				{
				setState(227);
				match(TOTAL);
				}
				break;
			case AXIOMS:
				enterOuterAlt(_localctx, 35);
				{
				setState(228);
				match(AXIOMS);
				}
				break;
			case DYNAMIC:
				enterOuterAlt(_localctx, 36);
				{
				setState(229);
				match(DYNAMIC);
				}
				break;
			case CAUSAL:
				enterOuterAlt(_localctx, 37);
				{
				setState(230);
				match(CAUSAL);
				}
				break;
			case LAWS:
				enterOuterAlt(_localctx, 38);
				{
				setState(231);
				match(LAWS);
				}
				break;
			case EXECUTABILITY:
				enterOuterAlt(_localctx, 39);
				{
				setState(232);
				match(EXECUTABILITY);
				}
				break;
			case CONDITIONS:
				enterOuterAlt(_localctx, 40);
				{
				setState(233);
				match(CONDITIONS);
				}
				break;
			case CAUSES:
				enterOuterAlt(_localctx, 41);
				{
				setState(234);
				match(CAUSES);
				}
				break;
			case IMPOSSIBLE:
				enterOuterAlt(_localctx, 42);
				{
				setState(235);
				match(IMPOSSIBLE);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 43);
				{
				setState(236);
				match(IF);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 44);
				{
				setState(237);
				match(FALSE);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 45);
				{
				setState(238);
				match(TRUE);
				}
				break;
			case STRUCTURE:
				enterOuterAlt(_localctx, 46);
				{
				setState(239);
				match(STRUCTURE);
				}
				break;
			case IN:
				enterOuterAlt(_localctx, 47);
				{
				setState(240);
				match(IN);
				}
				break;
			case WHERE:
				enterOuterAlt(_localctx, 48);
				{
				setState(241);
				match(WHERE);
				}
				break;
			case VALUE:
				enterOuterAlt(_localctx, 49);
				{
				setState(242);
				match(VALUE);
				}
				break;
			case OF:
				enterOuterAlt(_localctx, 50);
				{
				setState(243);
				match(OF);
				}
				break;
			case INSTANCES:
				enterOuterAlt(_localctx, 51);
				{
				setState(244);
				match(INSTANCES);
				}
				break;
			case TEMPORAL:
				enterOuterAlt(_localctx, 52);
				{
				setState(245);
				match(TEMPORAL);
				}
				break;
			case PROJECTION:
				enterOuterAlt(_localctx, 53);
				{
				setState(246);
				match(PROJECTION);
				}
				break;
			case MAX:
				enterOuterAlt(_localctx, 54);
				{
				setState(247);
				match(MAX);
				}
				break;
			case STEPS:
				enterOuterAlt(_localctx, 55);
				{
				setState(248);
				match(STEPS);
				}
				break;
			case HISTORY:
				enterOuterAlt(_localctx, 56);
				{
				setState(249);
				match(HISTORY);
				}
				break;
			case OBSERVED:
				enterOuterAlt(_localctx, 57);
				{
				setState(250);
				match(OBSERVED);
				}
				break;
			case HAPPENED:
				enterOuterAlt(_localctx, 58);
				{
				setState(251);
				match(HAPPENED);
				}
				break;
			case PLANNING:
				enterOuterAlt(_localctx, 59);
				{
				setState(252);
				match(PLANNING);
				}
				break;
			case PROBLEM:
				enterOuterAlt(_localctx, 60);
				{
				setState(253);
				match(PROBLEM);
				}
				break;
			case DIAGNOSTIC:
				enterOuterAlt(_localctx, 61);
				{
				setState(254);
				match(DIAGNOSTIC);
				}
				break;
			case GOAL:
				enterOuterAlt(_localctx, 62);
				{
				setState(255);
				match(GOAL);
				}
				break;
			case SITUATION:
				enterOuterAlt(_localctx, 63);
				{
				setState(256);
				match(SITUATION);
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 64);
				{
				setState(257);
				match(WHEN);
				}
				break;
			case NORMAL:
				enterOuterAlt(_localctx, 65);
				{
				setState(258);
				match(NORMAL);
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 66);
				{
				setState(259);
				match(ACTION);
				}
				break;
			case ADDITIONAL:
				enterOuterAlt(_localctx, 67);
				{
				setState(260);
				match(ADDITIONAL);
				}
				break;
			case RESTRICTIONS:
				enterOuterAlt(_localctx, 68);
				{
				setState(261);
				match(RESTRICTIONS);
				}
				break;
			case PERMISSIONS:
				enterOuterAlt(_localctx, 69);
				{
				setState(262);
				match(PERMISSIONS);
				}
				break;
			case POSSIBLE:
				enterOuterAlt(_localctx, 70);
				{
				setState(263);
				match(POSSIBLE);
				}
				break;
			case AVOID:
				enterOuterAlt(_localctx, 71);
				{
				setState(264);
				match(AVOID);
				}
				break;
			case BOOLEANS:
				enterOuterAlt(_localctx, 72);
				{
				setState(265);
				match(BOOLEANS);
				}
				break;
			case INTEGERS:
				enterOuterAlt(_localctx, 73);
				{
				setState(266);
				match(INTEGERS);
				}
				break;
			case UNIVERSE:
				enterOuterAlt(_localctx, 74);
				{
				setState(267);
				match(UNIVERSE);
				}
				break;
			case ACTIONS:
				enterOuterAlt(_localctx, 75);
				{
				setState(268);
				match(ACTIONS);
				}
				break;
			case CURRENT:
				enterOuterAlt(_localctx, 76);
				{
				setState(269);
				match(CURRENT);
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 77);
				{
				setState(270);
				match(TIME);
				}
				break;
			case POSINT:
			case NEGINT:
			case ZERO:
				enterOuterAlt(_localctx, 78);
				{
				setState(271);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alm_nameContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode VAR() { return getToken(ALMParser.VAR, 0); }
		public Alm_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alm_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterAlm_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitAlm_name(this);
		}
	}

	public final Alm_nameContext alm_name() throws RecognitionException {
		Alm_nameContext _localctx = new Alm_nameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_alm_name);
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MOD:
			case OCCURS:
			case INSTANCE:
			case IS_A:
			case HAS_CHILD:
			case HAS_PARENT:
			case LINK:
			case SOURCE:
			case SINK:
			case SUBSORT:
			case DOM:
			case SORT:
			case STATE:
			case CONSTRAINTS:
			case FUNCTION:
			case DECLARATIONS:
			case DEFINITIONS:
			case SYSTEM:
			case DESCRIPTION:
			case THEORY:
			case MODULE:
			case IMPORT:
			case FROM:
			case DEPENDS:
			case ON:
			case ATTRIBUTES:
			case OBJECT:
			case CONSTANT:
			case STATICS:
			case FLUENTS:
			case BASIC:
			case DEFINED:
			case TOTAL:
			case AXIOMS:
			case DYNAMIC:
			case CAUSAL:
			case LAWS:
			case EXECUTABILITY:
			case CONDITIONS:
			case CAUSES:
			case IMPOSSIBLE:
			case IF:
			case FALSE:
			case TRUE:
			case STRUCTURE:
			case IN:
			case WHERE:
			case VALUE:
			case OF:
			case INSTANCES:
			case TEMPORAL:
			case PROJECTION:
			case MAX:
			case STEPS:
			case HISTORY:
			case OBSERVED:
			case HAPPENED:
			case PLANNING:
			case PROBLEM:
			case DIAGNOSTIC:
			case GOAL:
			case SITUATION:
			case WHEN:
			case NORMAL:
			case ACTION:
			case ADDITIONAL:
			case RESTRICTIONS:
			case PERMISSIONS:
			case POSSIBLE:
			case AVOID:
			case BOOLEANS:
			case INTEGERS:
			case UNIVERSE:
			case ACTIONS:
			case CURRENT:
			case TIME:
			case ID:
			case POSINT:
			case NEGINT:
			case ZERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				id();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Object_constantContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Object_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterObject_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitObject_constant(this);
		}
	}

	public final Object_constantContext object_constant() throws RecognitionException {
		Object_constantContext _localctx = new Object_constantContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_object_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(278);
				id();
				setState(290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(279);
					match(T__0);
					setState(280);
					term();
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(281);
						match(T__1);
						setState(282);
						term();
						}
						}
						setState(287);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(288);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(292);
				integer();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_termContext extends ParserRuleContext {
		public Object_constantContext object_constant() {
			return getRuleContext(Object_constantContext.class,0);
		}
		public Function_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterFunction_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitFunction_term(this);
		}
	}

	public final Function_termContext function_term() throws RecognitionException {
		Function_termContext _localctx = new Function_termContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			object_constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode VAR() { return getToken(ALMParser.VAR, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				bool();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				id();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				integer();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(302);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_or_objContext extends ParserRuleContext {
		public Object_constantContext object_constant() {
			return getRuleContext(Object_constantContext.class,0);
		}
		public TerminalNode VAR() { return getToken(ALMParser.VAR, 0); }
		public Var_or_objContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_or_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterVar_or_obj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitVar_or_obj(this);
		}
	}

	public final Var_or_objContext var_or_obj() throws RecognitionException {
		Var_or_objContext _localctx = new Var_or_objContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var_or_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MOD:
			case OCCURS:
			case INSTANCE:
			case IS_A:
			case HAS_CHILD:
			case HAS_PARENT:
			case LINK:
			case SOURCE:
			case SINK:
			case SUBSORT:
			case DOM:
			case SORT:
			case STATE:
			case CONSTRAINTS:
			case FUNCTION:
			case DECLARATIONS:
			case DEFINITIONS:
			case SYSTEM:
			case DESCRIPTION:
			case THEORY:
			case MODULE:
			case IMPORT:
			case FROM:
			case DEPENDS:
			case ON:
			case ATTRIBUTES:
			case OBJECT:
			case CONSTANT:
			case STATICS:
			case FLUENTS:
			case BASIC:
			case DEFINED:
			case TOTAL:
			case AXIOMS:
			case DYNAMIC:
			case CAUSAL:
			case LAWS:
			case EXECUTABILITY:
			case CONDITIONS:
			case CAUSES:
			case IMPOSSIBLE:
			case IF:
			case FALSE:
			case TRUE:
			case STRUCTURE:
			case IN:
			case WHERE:
			case VALUE:
			case OF:
			case INSTANCES:
			case TEMPORAL:
			case PROJECTION:
			case MAX:
			case STEPS:
			case HISTORY:
			case OBSERVED:
			case HAPPENED:
			case PLANNING:
			case PROBLEM:
			case DIAGNOSTIC:
			case GOAL:
			case SITUATION:
			case WHEN:
			case NORMAL:
			case ACTION:
			case ADDITIONAL:
			case RESTRICTIONS:
			case PERMISSIONS:
			case POSSIBLE:
			case AVOID:
			case BOOLEANS:
			case INTEGERS:
			case UNIVERSE:
			case ACTIONS:
			case CURRENT:
			case TIME:
			case ID:
			case POSINT:
			case NEGINT:
			case ZERO:
				{
				setState(305);
				object_constant();
				}
				break;
			case VAR:
				{
				setState(306);
				match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Arithmetic_termContext arithmetic_term() {
			return getRuleContext(Arithmetic_termContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(310);
			arithmetic_term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(318);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(313);
						match(T__3);
						setState(314);
						arithmetic_term(0);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(316);
						match(T__4);
						setState(317);
						arithmetic_term(0);
						}
						break;
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Arithmetic_termContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public Arithmetic_termContext arithmetic_term() {
			return getRuleContext(Arithmetic_termContext.class,0);
		}
		public TerminalNode MOD() { return getToken(ALMParser.MOD, 0); }
		public Arithmetic_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterArithmetic_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitArithmetic_term(this);
		}
	}

	public final Arithmetic_termContext arithmetic_term() throws RecognitionException {
		return arithmetic_term(0);
	}

	private Arithmetic_termContext arithmetic_term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_termContext _localctx = new Arithmetic_termContext(_ctx, _parentState);
		Arithmetic_termContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_arithmetic_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(324);
				factor();
				setState(325);
				match(T__7);
				setState(326);
				factor();
				}
				break;
			case 2:
				{
				setState(328);
				factor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(342);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(340);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(331);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(332);
						match(T__5);
						setState(333);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(334);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(335);
						match(T__6);
						setState(336);
						factor();
						}
						break;
					case 3:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(337);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(338);
						match(MOD);
						setState(339);
						factor();
						}
						break;
					}
					} 
				}
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ALMParser.VAR, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_factor);
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				match(T__4);
				setState(347);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				integer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(349);
				function_term();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(350);
				match(T__4);
				setState(351);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(352);
				match(T__0);
				setState(353);
				expression(0);
				setState(354);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(356);
				match(T__4);
				setState(357);
				match(T__0);
				setState(358);
				expression(0);
				setState(359);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Occurs_atomContext extends ParserRuleContext {
		public TerminalNode OCCURS() { return getToken(ALMParser.OCCURS, 0); }
		public Var_or_objContext var_or_obj() {
			return getRuleContext(Var_or_objContext.class,0);
		}
		public Occurs_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_occurs_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOccurs_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOccurs_atom(this);
		}
	}

	public final Occurs_atomContext occurs_atom() throws RecognitionException {
		Occurs_atomContext _localctx = new Occurs_atomContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_occurs_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(OCCURS);
			setState(364);
			match(T__0);
			setState(365);
			var_or_obj();
			setState(366);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Instance_atomContext extends ParserRuleContext {
		public TerminalNode INSTANCE() { return getToken(ALMParser.INSTANCE, 0); }
		public Var_or_objContext var_or_obj() {
			return getRuleContext(Var_or_objContext.class,0);
		}
		public Sort_nameContext sort_name() {
			return getRuleContext(Sort_nameContext.class,0);
		}
		public Instance_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instance_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterInstance_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitInstance_atom(this);
		}
	}

	public final Instance_atomContext instance_atom() throws RecognitionException {
		Instance_atomContext _localctx = new Instance_atomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_instance_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(INSTANCE);
			setState(369);
			match(T__0);
			setState(370);
			var_or_obj();
			setState(371);
			match(T__1);
			setState(372);
			sort_name();
			setState(373);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_a_atomContext extends ParserRuleContext {
		public TerminalNode IS_A() { return getToken(ALMParser.IS_A, 0); }
		public Var_or_objContext var_or_obj() {
			return getRuleContext(Var_or_objContext.class,0);
		}
		public Sort_nameContext sort_name() {
			return getRuleContext(Sort_nameContext.class,0);
		}
		public Is_a_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_a_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterIs_a_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitIs_a_atom(this);
		}
	}

	public final Is_a_atomContext is_a_atom() throws RecognitionException {
		Is_a_atomContext _localctx = new Is_a_atomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_is_a_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(IS_A);
			setState(376);
			match(T__0);
			setState(377);
			var_or_obj();
			setState(378);
			match(T__1);
			setState(379);
			sort_name();
			setState(380);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Link_atomContext extends ParserRuleContext {
		public TerminalNode LINK() { return getToken(ALMParser.LINK, 0); }
		public List<Sort_nameContext> sort_name() {
			return getRuleContexts(Sort_nameContext.class);
		}
		public Sort_nameContext sort_name(int i) {
			return getRuleContext(Sort_nameContext.class,i);
		}
		public Link_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_link_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterLink_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitLink_atom(this);
		}
	}

	public final Link_atomContext link_atom() throws RecognitionException {
		Link_atomContext _localctx = new Link_atomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_link_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(LINK);
			setState(383);
			match(T__0);
			setState(384);
			sort_name();
			setState(385);
			match(T__1);
			setState(386);
			sort_name();
			setState(387);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Subsort_atomContext extends ParserRuleContext {
		public TerminalNode SUBSORT() { return getToken(ALMParser.SUBSORT, 0); }
		public List<Sort_nameContext> sort_name() {
			return getRuleContexts(Sort_nameContext.class);
		}
		public Sort_nameContext sort_name(int i) {
			return getRuleContext(Sort_nameContext.class,i);
		}
		public Subsort_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsort_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSubsort_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSubsort_atom(this);
		}
	}

	public final Subsort_atomContext subsort_atom() throws RecognitionException {
		Subsort_atomContext _localctx = new Subsort_atomContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subsort_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(SUBSORT);
			setState(390);
			match(T__0);
			setState(391);
			sort_name();
			setState(392);
			match(T__1);
			setState(393);
			sort_name();
			setState(394);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Has_child_atomContext extends ParserRuleContext {
		public TerminalNode HAS_CHILD() { return getToken(ALMParser.HAS_CHILD, 0); }
		public Sort_nameContext sort_name() {
			return getRuleContext(Sort_nameContext.class,0);
		}
		public Has_child_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_has_child_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterHas_child_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitHas_child_atom(this);
		}
	}

	public final Has_child_atomContext has_child_atom() throws RecognitionException {
		Has_child_atomContext _localctx = new Has_child_atomContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_has_child_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(HAS_CHILD);
			setState(397);
			match(T__0);
			setState(398);
			sort_name();
			setState(399);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Has_parent_atomContext extends ParserRuleContext {
		public TerminalNode HAS_PARENT() { return getToken(ALMParser.HAS_PARENT, 0); }
		public Sort_nameContext sort_name() {
			return getRuleContext(Sort_nameContext.class,0);
		}
		public Has_parent_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_has_parent_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterHas_parent_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitHas_parent_atom(this);
		}
	}

	public final Has_parent_atomContext has_parent_atom() throws RecognitionException {
		Has_parent_atomContext _localctx = new Has_parent_atomContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_has_parent_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(HAS_PARENT);
			setState(402);
			match(T__0);
			setState(403);
			sort_name();
			setState(404);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sink_atomContext extends ParserRuleContext {
		public TerminalNode SINK() { return getToken(ALMParser.SINK, 0); }
		public Sort_nameContext sort_name() {
			return getRuleContext(Sort_nameContext.class,0);
		}
		public Sink_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sink_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSink_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSink_atom(this);
		}
	}

	public final Sink_atomContext sink_atom() throws RecognitionException {
		Sink_atomContext _localctx = new Sink_atomContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sink_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(SINK);
			setState(407);
			match(T__0);
			setState(408);
			sort_name();
			setState(409);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Source_atomContext extends ParserRuleContext {
		public TerminalNode SOURCE() { return getToken(ALMParser.SOURCE, 0); }
		public Sort_nameContext sort_name() {
			return getRuleContext(Sort_nameContext.class,0);
		}
		public Source_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSource_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSource_atom(this);
		}
	}

	public final Source_atomContext source_atom() throws RecognitionException {
		Source_atomContext _localctx = new Source_atomContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_source_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(SOURCE);
			setState(412);
			match(T__0);
			setState(413);
			sort_name();
			setState(414);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public Instance_atomContext instance_atom() {
			return getRuleContext(Instance_atomContext.class,0);
		}
		public Is_a_atomContext is_a_atom() {
			return getRuleContext(Is_a_atomContext.class,0);
		}
		public Link_atomContext link_atom() {
			return getRuleContext(Link_atomContext.class,0);
		}
		public Subsort_atomContext subsort_atom() {
			return getRuleContext(Subsort_atomContext.class,0);
		}
		public Has_child_atomContext has_child_atom() {
			return getRuleContext(Has_child_atomContext.class,0);
		}
		public Has_parent_atomContext has_parent_atom() {
			return getRuleContext(Has_parent_atomContext.class,0);
		}
		public Sink_atomContext sink_atom() {
			return getRuleContext(Sink_atomContext.class,0);
		}
		public Source_atomContext source_atom() {
			return getRuleContext(Source_atomContext.class,0);
		}
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_atom);
		try {
			setState(425);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(416);
				instance_atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(417);
				is_a_atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(418);
				link_atom();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(419);
				subsort_atom();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(420);
				has_child_atom();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(421);
				has_parent_atom();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(422);
				sink_atom();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(423);
				source_atom();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(424);
				function_term();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_literal);
		try {
			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(427);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(428);
				match(T__4);
				setState(429);
				atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(430);
				term();
				setState(431);
				relation();
				setState(432);
				term();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Occurs_literalContext extends ParserRuleContext {
		public Occurs_atomContext occurs_atom() {
			return getRuleContext(Occurs_atomContext.class,0);
		}
		public Occurs_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_occurs_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOccurs_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOccurs_literal(this);
		}
	}

	public final Occurs_literalContext occurs_literal() throws RecognitionException {
		Occurs_literalContext _localctx = new Occurs_literalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_occurs_literal);
		try {
			setState(439);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OCCURS:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				occurs_atom();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				match(T__4);
				setState(438);
				occurs_atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alm_fileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ALMParser.EOF, 0); }
		public System_descriptionContext system_description() {
			return getRuleContext(System_descriptionContext.class,0);
		}
		public TheoryContext theory() {
			return getRuleContext(TheoryContext.class,0);
		}
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public Alm_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alm_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterAlm_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitAlm_file(this);
		}
	}

	public final Alm_fileContext alm_file() throws RecognitionException {
		Alm_fileContext _localctx = new Alm_fileContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_alm_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(441);
				system_description();
				}
				break;
			case 2:
				{
				setState(442);
				theory();
				}
				break;
			case 3:
				{
				setState(443);
				module();
				}
				break;
			}
			setState(446);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Library_nameContext extends ParserRuleContext {
		public Alm_nameContext alm_name() {
			return getRuleContext(Alm_nameContext.class,0);
		}
		public Library_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_library_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterLibrary_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitLibrary_name(this);
		}
	}

	public final Library_nameContext library_name() throws RecognitionException {
		Library_nameContext _localctx = new Library_nameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_library_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			alm_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sys_desc_nameContext extends ParserRuleContext {
		public Alm_nameContext alm_name() {
			return getRuleContext(Alm_nameContext.class,0);
		}
		public Sys_desc_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sys_desc_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSys_desc_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSys_desc_name(this);
		}
	}

	public final Sys_desc_nameContext sys_desc_name() throws RecognitionException {
		Sys_desc_nameContext _localctx = new Sys_desc_nameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_sys_desc_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			alm_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class System_descriptionContext extends ParserRuleContext {
		public TerminalNode SYSTEM() { return getToken(ALMParser.SYSTEM, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ALMParser.DESCRIPTION, 0); }
		public Sys_desc_nameContext sys_desc_name() {
			return getRuleContext(Sys_desc_nameContext.class,0);
		}
		public TheoryContext theory() {
			return getRuleContext(TheoryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ALMParser.EOF, 0); }
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public Solver_modeContext solver_mode() {
			return getRuleContext(Solver_modeContext.class,0);
		}
		public System_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSystem_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSystem_description(this);
		}
	}

	public final System_descriptionContext system_description() throws RecognitionException {
		System_descriptionContext _localctx = new System_descriptionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_system_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(SYSTEM);
			setState(453);
			match(DESCRIPTION);
			setState(454);
			sys_desc_name();
			setState(455);
			theory();
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRUCTURE) {
				{
				setState(456);
				structure();
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (TEMPORAL - 72)) | (1L << (PLANNING - 72)) | (1L << (DIAGNOSTIC - 72)))) != 0)) {
					{
					setState(457);
					solver_mode();
					}
				}

				}
			}

			setState(462);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Theory_nameContext extends ParserRuleContext {
		public Alm_nameContext alm_name() {
			return getRuleContext(Alm_nameContext.class,0);
		}
		public Theory_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theory_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterTheory_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitTheory_name(this);
		}
	}

	public final Theory_nameContext theory_name() throws RecognitionException {
		Theory_nameContext _localctx = new Theory_nameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_theory_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			alm_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TheoryContext extends ParserRuleContext {
		public TerminalNode THEORY() { return getToken(ALMParser.THEORY, 0); }
		public Theory_nameContext theory_name() {
			return getRuleContext(Theory_nameContext.class,0);
		}
		public Sequence_of_modulesContext sequence_of_modules() {
			return getRuleContext(Sequence_of_modulesContext.class,0);
		}
		public TerminalNode IMPORT() { return getToken(ALMParser.IMPORT, 0); }
		public TerminalNode FROM() { return getToken(ALMParser.FROM, 0); }
		public Library_nameContext library_name() {
			return getRuleContext(Library_nameContext.class,0);
		}
		public TheoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterTheory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitTheory(this);
		}
	}

	public final TheoryContext theory() throws RecognitionException {
		TheoryContext _localctx = new TheoryContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_theory);
		try {
			setState(475);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THEORY:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(466);
				match(THEORY);
				setState(467);
				theory_name();
				setState(468);
				sequence_of_modules();
				}
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(470);
				match(IMPORT);
				setState(471);
				theory_name();
				setState(472);
				match(FROM);
				setState(473);
				library_name();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_nameContext extends ParserRuleContext {
		public Alm_nameContext alm_name() {
			return getRuleContext(Alm_nameContext.class,0);
		}
		public Module_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterModule_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitModule_name(this);
		}
	}

	public final Module_nameContext module_name() throws RecognitionException {
		Module_nameContext _localctx = new Module_nameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			alm_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sequence_of_modulesContext extends ParserRuleContext {
		public List<ModuleContext> module() {
			return getRuleContexts(ModuleContext.class);
		}
		public ModuleContext module(int i) {
			return getRuleContext(ModuleContext.class,i);
		}
		public Sequence_of_modulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_of_modules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSequence_of_modules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSequence_of_modules(this);
		}
	}

	public final Sequence_of_modulesContext sequence_of_modules() throws RecognitionException {
		Sequence_of_modulesContext _localctx = new Sequence_of_modulesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_sequence_of_modules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(479);
				module();
				}
				}
				setState(482); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MODULE || _la==IMPORT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(ALMParser.MODULE, 0); }
		public Module_nameContext module_name() {
			return getRuleContext(Module_nameContext.class,0);
		}
		public Module_bodyContext module_body() {
			return getRuleContext(Module_bodyContext.class,0);
		}
		public TerminalNode IMPORT() { return getToken(ALMParser.IMPORT, 0); }
		public Theory_nameContext theory_name() {
			return getRuleContext(Theory_nameContext.class,0);
		}
		public TerminalNode FROM() { return getToken(ALMParser.FROM, 0); }
		public Library_nameContext library_name() {
			return getRuleContext(Library_nameContext.class,0);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitModule(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_module);
		int _la;
		try {
			setState(497);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(484);
				match(MODULE);
				setState(485);
				module_name();
				setState(486);
				module_body();
				}
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(488);
				match(IMPORT);
				setState(489);
				theory_name();
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(490);
					match(T__8);
					setState(491);
					module_name();
					}
				}

				setState(494);
				match(FROM);
				setState(495);
				library_name();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_bodyContext extends ParserRuleContext {
		public Module_dependenciesContext module_dependencies() {
			return getRuleContext(Module_dependenciesContext.class,0);
		}
		public Sort_declarationsContext sort_declarations() {
			return getRuleContext(Sort_declarationsContext.class,0);
		}
		public Constant_declarationsContext constant_declarations() {
			return getRuleContext(Constant_declarationsContext.class,0);
		}
		public Function_declarationsContext function_declarations() {
			return getRuleContext(Function_declarationsContext.class,0);
		}
		public AxiomsContext axioms() {
			return getRuleContext(AxiomsContext.class,0);
		}
		public Module_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterModule_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitModule_body(this);
		}
	}

	public final Module_bodyContext module_body() throws RecognitionException {
		Module_bodyContext _localctx = new Module_bodyContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_module_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEPENDS) {
				{
				setState(499);
				module_dependencies();
				}
			}

			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORT) {
				{
				setState(502);
				sort_declarations();
				}
			}

			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(505);
				constant_declarations();
				}
			}

			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNCTION) {
				{
				setState(508);
				function_declarations();
				}
			}

			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AXIOMS) {
				{
				setState(511);
				axioms();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_dependenciesContext extends ParserRuleContext {
		public TerminalNode DEPENDS() { return getToken(ALMParser.DEPENDS, 0); }
		public TerminalNode ON() { return getToken(ALMParser.ON, 0); }
		public List<One_dependencyContext> one_dependency() {
			return getRuleContexts(One_dependencyContext.class);
		}
		public One_dependencyContext one_dependency(int i) {
			return getRuleContext(One_dependencyContext.class,i);
		}
		public Module_dependenciesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_dependencies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterModule_dependencies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitModule_dependencies(this);
		}
	}

	public final Module_dependenciesContext module_dependencies() throws RecognitionException {
		Module_dependenciesContext _localctx = new Module_dependenciesContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_module_dependencies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			match(DEPENDS);
			setState(515);
			match(ON);
			setState(516);
			one_dependency();
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(517);
				match(T__1);
				setState(518);
				one_dependency();
				}
				}
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_dependencyContext extends ParserRuleContext {
		public Module_nameContext module_name() {
			return getRuleContext(Module_nameContext.class,0);
		}
		public Theory_nameContext theory_name() {
			return getRuleContext(Theory_nameContext.class,0);
		}
		public One_dependencyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_dependency; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_dependency(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_dependency(this);
		}
	}

	public final One_dependencyContext one_dependency() throws RecognitionException {
		One_dependencyContext _localctx = new One_dependencyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_one_dependency);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(524);
				theory_name();
				setState(525);
				match(T__8);
				}
				break;
			}
			setState(529);
			module_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Integer_rangeContext extends ParserRuleContext {
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public Integer_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterInteger_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitInteger_range(this);
		}
	}

	public final Integer_rangeContext integer_range() throws RecognitionException {
		Integer_rangeContext _localctx = new Integer_rangeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_integer_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			integer();
			setState(532);
			match(T__9);
			setState(533);
			integer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Predefined_sortsContext extends ParserRuleContext {
		public TerminalNode BOOLEANS() { return getToken(ALMParser.BOOLEANS, 0); }
		public TerminalNode INTEGERS() { return getToken(ALMParser.INTEGERS, 0); }
		public Integer_rangeContext integer_range() {
			return getRuleContext(Integer_rangeContext.class,0);
		}
		public Predefined_sortsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predefined_sorts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterPredefined_sorts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitPredefined_sorts(this);
		}
	}

	public final Predefined_sortsContext predefined_sorts() throws RecognitionException {
		Predefined_sortsContext _localctx = new Predefined_sortsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_predefined_sorts);
		try {
			setState(538);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEANS:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				match(BOOLEANS);
				}
				break;
			case INTEGERS:
				enterOuterAlt(_localctx, 2);
				{
				setState(536);
				match(INTEGERS);
				}
				break;
			case POSINT:
			case NEGINT:
			case ZERO:
				enterOuterAlt(_localctx, 3);
				{
				setState(537);
				integer_range();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sort_nameContext extends ParserRuleContext {
		public Predefined_sortsContext predefined_sorts() {
			return getRuleContext(Predefined_sortsContext.class,0);
		}
		public TerminalNode UNIVERSE() { return getToken(ALMParser.UNIVERSE, 0); }
		public TerminalNode ACTIONS() { return getToken(ALMParser.ACTIONS, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Sort_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSort_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSort_name(this);
		}
	}

	public final Sort_nameContext sort_name() throws RecognitionException {
		Sort_nameContext _localctx = new Sort_nameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_sort_name);
		try {
			setState(544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(540);
				predefined_sorts();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(541);
				match(UNIVERSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(542);
				match(ACTIONS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(543);
				id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class New_sort_nameContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Integer_rangeContext integer_range() {
			return getRuleContext(Integer_rangeContext.class,0);
		}
		public New_sort_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_sort_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterNew_sort_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitNew_sort_name(this);
		}
	}

	public final New_sort_nameContext new_sort_name() throws RecognitionException {
		New_sort_nameContext _localctx = new New_sort_nameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_new_sort_name);
		try {
			setState(548);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(547);
				integer_range();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sort_declarationsContext extends ParserRuleContext {
		public TerminalNode SORT() { return getToken(ALMParser.SORT, 0); }
		public TerminalNode DECLARATIONS() { return getToken(ALMParser.DECLARATIONS, 0); }
		public List<One_sort_declContext> one_sort_decl() {
			return getRuleContexts(One_sort_declContext.class);
		}
		public One_sort_declContext one_sort_decl(int i) {
			return getRuleContext(One_sort_declContext.class,i);
		}
		public Sort_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSort_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSort_declarations(this);
		}
	}

	public final Sort_declarationsContext sort_declarations() throws RecognitionException {
		Sort_declarationsContext _localctx = new Sort_declarationsContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_sort_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(SORT);
			setState(551);
			match(DECLARATIONS);
			setState(553); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(552);
					one_sort_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(555); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_sort_declContext extends ParserRuleContext {
		public List<New_sort_nameContext> new_sort_name() {
			return getRuleContexts(New_sort_nameContext.class);
		}
		public New_sort_nameContext new_sort_name(int i) {
			return getRuleContext(New_sort_nameContext.class,i);
		}
		public List<Sort_nameContext> sort_name() {
			return getRuleContexts(Sort_nameContext.class);
		}
		public Sort_nameContext sort_name(int i) {
			return getRuleContext(Sort_nameContext.class,i);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public One_sort_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_sort_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_sort_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_sort_decl(this);
		}
	}

	public final One_sort_declContext one_sort_decl() throws RecognitionException {
		One_sort_declContext _localctx = new One_sort_declContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_one_sort_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			new_sort_name();
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(558);
				match(T__1);
				setState(559);
				new_sort_name();
				}
				}
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(565);
			match(T__10);
			setState(566);
			sort_name();
			setState(571);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(567);
				match(T__1);
				setState(568);
				sort_name();
				}
				}
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(575);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(574);
				attributes();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributesContext extends ParserRuleContext {
		public TerminalNode ATTRIBUTES() { return getToken(ALMParser.ATTRIBUTES, 0); }
		public List<One_attribute_declContext> one_attribute_decl() {
			return getRuleContexts(One_attribute_declContext.class);
		}
		public One_attribute_declContext one_attribute_decl(int i) {
			return getRuleContext(One_attribute_declContext.class,i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitAttributes(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_attributes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(ATTRIBUTES);
			setState(579); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(578);
					one_attribute_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(581); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_attribute_declContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<Sort_nameContext> sort_name() {
			return getRuleContexts(Sort_nameContext.class);
		}
		public Sort_nameContext sort_name(int i) {
			return getRuleContext(Sort_nameContext.class,i);
		}
		public TerminalNode RIGHT_ARROW() { return getToken(ALMParser.RIGHT_ARROW, 0); }
		public One_attribute_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_attribute_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_attribute_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_attribute_decl(this);
		}
	}

	public final One_attribute_declContext one_attribute_decl() throws RecognitionException {
		One_attribute_declContext _localctx = new One_attribute_declContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_one_attribute_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			id();
			setState(584);
			match(T__11);
			setState(595);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(585);
				sort_name();
				setState(590);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(586);
					match(T__1);
					setState(587);
					sort_name();
					}
					}
					setState(592);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(593);
				match(RIGHT_ARROW);
				}
				break;
			}
			setState(597);
			sort_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant_declarationsContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(ALMParser.CONSTANT, 0); }
		public TerminalNode DECLARATIONS() { return getToken(ALMParser.DECLARATIONS, 0); }
		public List<One_constant_declContext> one_constant_decl() {
			return getRuleContexts(One_constant_declContext.class);
		}
		public One_constant_declContext one_constant_decl(int i) {
			return getRuleContext(One_constant_declContext.class,i);
		}
		public Constant_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterConstant_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitConstant_declarations(this);
		}
	}

	public final Constant_declarationsContext constant_declarations() throws RecognitionException {
		Constant_declarationsContext _localctx = new Constant_declarationsContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_constant_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(CONSTANT);
			setState(600);
			match(DECLARATIONS);
			setState(602); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(601);
					one_constant_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(604); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_constant_declContext extends ParserRuleContext {
		public List<Object_constantContext> object_constant() {
			return getRuleContexts(Object_constantContext.class);
		}
		public Object_constantContext object_constant(int i) {
			return getRuleContext(Object_constantContext.class,i);
		}
		public List<Sort_nameContext> sort_name() {
			return getRuleContexts(Sort_nameContext.class);
		}
		public Sort_nameContext sort_name(int i) {
			return getRuleContext(Sort_nameContext.class,i);
		}
		public Attribute_defsContext attribute_defs() {
			return getRuleContext(Attribute_defsContext.class,0);
		}
		public One_constant_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_constant_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_constant_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_constant_decl(this);
		}
	}

	public final One_constant_declContext one_constant_decl() throws RecognitionException {
		One_constant_declContext _localctx = new One_constant_declContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_one_constant_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			object_constant();
			setState(611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(607);
				match(T__1);
				setState(608);
				object_constant();
				}
				}
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(614);
			match(T__11);
			setState(615);
			sort_name();
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(616);
				match(T__1);
				setState(617);
				sort_name();
				}
				}
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(624);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(623);
				attribute_defs();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_declarationsContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(ALMParser.FUNCTION, 0); }
		public TerminalNode DECLARATIONS() { return getToken(ALMParser.DECLARATIONS, 0); }
		public Static_declarationsContext static_declarations() {
			return getRuleContext(Static_declarationsContext.class,0);
		}
		public Fluent_declarationsContext fluent_declarations() {
			return getRuleContext(Fluent_declarationsContext.class,0);
		}
		public Function_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterFunction_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitFunction_declarations(this);
		}
	}

	public final Function_declarationsContext function_declarations() throws RecognitionException {
		Function_declarationsContext _localctx = new Function_declarationsContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			match(FUNCTION);
			setState(629);
			match(DECLARATIONS);
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATICS) {
				{
				setState(630);
				static_declarations();
				}
			}

			setState(634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLUENTS) {
				{
				setState(633);
				fluent_declarations();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Static_declarationsContext extends ParserRuleContext {
		public TerminalNode STATICS() { return getToken(ALMParser.STATICS, 0); }
		public Basic_function_declarationsContext basic_function_declarations() {
			return getRuleContext(Basic_function_declarationsContext.class,0);
		}
		public Defined_function_declarationsContext defined_function_declarations() {
			return getRuleContext(Defined_function_declarationsContext.class,0);
		}
		public Static_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterStatic_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitStatic_declarations(this);
		}
	}

	public final Static_declarationsContext static_declarations() throws RecognitionException {
		Static_declarationsContext _localctx = new Static_declarationsContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_static_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			match(STATICS);
			setState(638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BASIC) {
				{
				setState(637);
				basic_function_declarations();
				}
			}

			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINED) {
				{
				setState(640);
				defined_function_declarations();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fluent_declarationsContext extends ParserRuleContext {
		public TerminalNode FLUENTS() { return getToken(ALMParser.FLUENTS, 0); }
		public Basic_function_declarationsContext basic_function_declarations() {
			return getRuleContext(Basic_function_declarationsContext.class,0);
		}
		public Defined_function_declarationsContext defined_function_declarations() {
			return getRuleContext(Defined_function_declarationsContext.class,0);
		}
		public Fluent_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fluent_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterFluent_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitFluent_declarations(this);
		}
	}

	public final Fluent_declarationsContext fluent_declarations() throws RecognitionException {
		Fluent_declarationsContext _localctx = new Fluent_declarationsContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_fluent_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			match(FLUENTS);
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BASIC) {
				{
				setState(644);
				basic_function_declarations();
				}
			}

			setState(648);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINED) {
				{
				setState(647);
				defined_function_declarations();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Basic_function_declarationsContext extends ParserRuleContext {
		public TerminalNode BASIC() { return getToken(ALMParser.BASIC, 0); }
		public List<One_function_declContext> one_function_decl() {
			return getRuleContexts(One_function_declContext.class);
		}
		public One_function_declContext one_function_decl(int i) {
			return getRuleContext(One_function_declContext.class,i);
		}
		public Basic_function_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_function_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterBasic_function_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitBasic_function_declarations(this);
		}
	}

	public final Basic_function_declarationsContext basic_function_declarations() throws RecognitionException {
		Basic_function_declarationsContext _localctx = new Basic_function_declarationsContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_basic_function_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			match(BASIC);
			setState(652); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(651);
					one_function_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(654); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Defined_function_declarationsContext extends ParserRuleContext {
		public TerminalNode DEFINED() { return getToken(ALMParser.DEFINED, 0); }
		public List<One_function_declContext> one_function_decl() {
			return getRuleContexts(One_function_declContext.class);
		}
		public One_function_declContext one_function_decl(int i) {
			return getRuleContext(One_function_declContext.class,i);
		}
		public Defined_function_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defined_function_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterDefined_function_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitDefined_function_declarations(this);
		}
	}

	public final Defined_function_declarationsContext defined_function_declarations() throws RecognitionException {
		Defined_function_declarationsContext _localctx = new Defined_function_declarationsContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_defined_function_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
			match(DEFINED);
			setState(658); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(657);
					one_function_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(660); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_function_declContext extends ParserRuleContext {
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public List<Sort_nameContext> sort_name() {
			return getRuleContexts(Sort_nameContext.class);
		}
		public Sort_nameContext sort_name(int i) {
			return getRuleContext(Sort_nameContext.class,i);
		}
		public TerminalNode TOTAL() { return getToken(ALMParser.TOTAL, 0); }
		public TerminalNode RIGHT_ARROW() { return getToken(ALMParser.RIGHT_ARROW, 0); }
		public One_function_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_function_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_function_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_function_decl(this);
		}
	}

	public final One_function_declContext one_function_decl() throws RecognitionException {
		One_function_declContext _localctx = new One_function_declContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_one_function_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(662);
				match(TOTAL);
				}
				break;
			}
			setState(665);
			function_name();
			setState(666);
			match(T__11);
			setState(667);
			sort_name();
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==RIGHT_ARROW) {
				{
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(668);
					match(T__5);
					setState(669);
					sort_name();
					}
					}
					setState(674);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(675);
				match(RIGHT_ARROW);
				setState(676);
				sort_name();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pos_fun_defContext extends ParserRuleContext {
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ALMParser.EQ, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Pos_fun_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos_fun_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterPos_fun_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitPos_fun_def(this);
		}
	}

	public final Pos_fun_defContext pos_fun_def() throws RecognitionException {
		Pos_fun_defContext _localctx = new Pos_fun_defContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_pos_fun_def);
		try {
			setState(686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				function_term();
				setState(680);
				match(EQ);
				setState(681);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(683);
				function_term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(684);
				match(T__4);
				setState(685);
				function_term();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Neg_fun_defContext extends ParserRuleContext {
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public TerminalNode NEQ() { return getToken(ALMParser.NEQ, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Neg_fun_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg_fun_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterNeg_fun_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitNeg_fun_def(this);
		}
	}

	public final Neg_fun_defContext neg_fun_def() throws RecognitionException {
		Neg_fun_defContext _localctx = new Neg_fun_defContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_neg_fun_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			function_term();
			setState(689);
			match(NEQ);
			setState(690);
			term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fun_defContext extends ParserRuleContext {
		public Pos_fun_defContext pos_fun_def() {
			return getRuleContext(Pos_fun_defContext.class,0);
		}
		public Neg_fun_defContext neg_fun_def() {
			return getRuleContext(Neg_fun_defContext.class,0);
		}
		public Fun_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterFun_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitFun_def(this);
		}
	}

	public final Fun_defContext fun_def() throws RecognitionException {
		Fun_defContext _localctx = new Fun_defContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_fun_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(692);
				pos_fun_def();
				}
				break;
			case 2:
				{
				setState(693);
				neg_fun_def();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AxiomsContext extends ParserRuleContext {
		public TerminalNode AXIOMS() { return getToken(ALMParser.AXIOMS, 0); }
		public List<Dynamic_causal_lawsContext> dynamic_causal_laws() {
			return getRuleContexts(Dynamic_causal_lawsContext.class);
		}
		public Dynamic_causal_lawsContext dynamic_causal_laws(int i) {
			return getRuleContext(Dynamic_causal_lawsContext.class,i);
		}
		public List<Executability_conditionsContext> executability_conditions() {
			return getRuleContexts(Executability_conditionsContext.class);
		}
		public Executability_conditionsContext executability_conditions(int i) {
			return getRuleContext(Executability_conditionsContext.class,i);
		}
		public List<State_constraintsContext> state_constraints() {
			return getRuleContexts(State_constraintsContext.class);
		}
		public State_constraintsContext state_constraints(int i) {
			return getRuleContext(State_constraintsContext.class,i);
		}
		public List<Function_definitionsContext> function_definitions() {
			return getRuleContexts(Function_definitionsContext.class);
		}
		public Function_definitionsContext function_definitions(int i) {
			return getRuleContext(Function_definitionsContext.class,i);
		}
		public AxiomsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_axioms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterAxioms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitAxioms(this);
		}
	}

	public final AxiomsContext axioms() throws RecognitionException {
		AxiomsContext _localctx = new AxiomsContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_axioms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			match(AXIOMS);
			setState(701); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(701);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DYNAMIC:
					{
					setState(697);
					dynamic_causal_laws();
					}
					break;
				case EXECUTABILITY:
					{
					setState(698);
					executability_conditions();
					}
					break;
				case STATE:
					{
					setState(699);
					state_constraints();
					}
					break;
				case FUNCTION:
					{
					setState(700);
					function_definitions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(703); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STATE) | (1L << FUNCTION) | (1L << DYNAMIC) | (1L << EXECUTABILITY))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dynamic_causal_lawsContext extends ParserRuleContext {
		public TerminalNode DYNAMIC() { return getToken(ALMParser.DYNAMIC, 0); }
		public TerminalNode CAUSAL() { return getToken(ALMParser.CAUSAL, 0); }
		public TerminalNode LAWS() { return getToken(ALMParser.LAWS, 0); }
		public List<One_dynamic_causal_lawContext> one_dynamic_causal_law() {
			return getRuleContexts(One_dynamic_causal_lawContext.class);
		}
		public One_dynamic_causal_lawContext one_dynamic_causal_law(int i) {
			return getRuleContext(One_dynamic_causal_lawContext.class,i);
		}
		public Dynamic_causal_lawsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dynamic_causal_laws; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterDynamic_causal_laws(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitDynamic_causal_laws(this);
		}
	}

	public final Dynamic_causal_lawsContext dynamic_causal_laws() throws RecognitionException {
		Dynamic_causal_lawsContext _localctx = new Dynamic_causal_lawsContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_dynamic_causal_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			match(DYNAMIC);
			setState(706);
			match(CAUSAL);
			setState(707);
			match(LAWS);
			setState(711);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OCCURS) {
				{
				{
				setState(708);
				one_dynamic_causal_law();
				}
				}
				setState(713);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Executability_conditionsContext extends ParserRuleContext {
		public TerminalNode EXECUTABILITY() { return getToken(ALMParser.EXECUTABILITY, 0); }
		public TerminalNode CONDITIONS() { return getToken(ALMParser.CONDITIONS, 0); }
		public List<One_executability_conditionContext> one_executability_condition() {
			return getRuleContexts(One_executability_conditionContext.class);
		}
		public One_executability_conditionContext one_executability_condition(int i) {
			return getRuleContext(One_executability_conditionContext.class,i);
		}
		public Executability_conditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_executability_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterExecutability_conditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitExecutability_conditions(this);
		}
	}

	public final Executability_conditionsContext executability_conditions() throws RecognitionException {
		Executability_conditionsContext _localctx = new Executability_conditionsContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_executability_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			match(EXECUTABILITY);
			setState(715);
			match(CONDITIONS);
			setState(719);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPOSSIBLE) {
				{
				{
				setState(716);
				one_executability_condition();
				}
				}
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_constraintsContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(ALMParser.STATE, 0); }
		public TerminalNode CONSTRAINTS() { return getToken(ALMParser.CONSTRAINTS, 0); }
		public List<One_state_constraintContext> one_state_constraint() {
			return getRuleContexts(One_state_constraintContext.class);
		}
		public One_state_constraintContext one_state_constraint(int i) {
			return getRuleContext(One_state_constraintContext.class,i);
		}
		public State_constraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_constraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterState_constraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitState_constraints(this);
		}
	}

	public final State_constraintsContext state_constraints() throws RecognitionException {
		State_constraintsContext _localctx = new State_constraintsContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_state_constraints);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
			match(STATE);
			setState(723);
			match(CONSTRAINTS);
			setState(727);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(724);
					one_state_constraint();
					}
					} 
				}
				setState(729);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionsContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(ALMParser.FUNCTION, 0); }
		public TerminalNode DEFINITIONS() { return getToken(ALMParser.DEFINITIONS, 0); }
		public List<One_definitionContext> one_definition() {
			return getRuleContexts(One_definitionContext.class);
		}
		public One_definitionContext one_definition(int i) {
			return getRuleContext(One_definitionContext.class,i);
		}
		public Function_definitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterFunction_definitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitFunction_definitions(this);
		}
	}

	public final Function_definitionsContext function_definitions() throws RecognitionException {
		Function_definitionsContext _localctx = new Function_definitionsContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_function_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			match(FUNCTION);
			setState(731);
			match(DEFINITIONS);
			setState(735);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(732);
					one_definition();
					}
					} 
				}
				setState(737);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_dynamic_causal_lawContext extends ParserRuleContext {
		public Occurs_atomContext occurs_atom() {
			return getRuleContext(Occurs_atomContext.class,0);
		}
		public TerminalNode CAUSES() { return getToken(ALMParser.CAUSES, 0); }
		public Pos_fun_defContext pos_fun_def() {
			return getRuleContext(Pos_fun_defContext.class,0);
		}
		public TerminalNode IF() { return getToken(ALMParser.IF, 0); }
		public Instance_atomContext instance_atom() {
			return getRuleContext(Instance_atomContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public One_dynamic_causal_lawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_dynamic_causal_law; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_dynamic_causal_law(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_dynamic_causal_law(this);
		}
	}

	public final One_dynamic_causal_lawContext one_dynamic_causal_law() throws RecognitionException {
		One_dynamic_causal_lawContext _localctx = new One_dynamic_causal_lawContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_one_dynamic_causal_law);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			occurs_atom();
			setState(739);
			match(CAUSES);
			setState(740);
			pos_fun_def();
			setState(741);
			match(IF);
			setState(742);
			instance_atom();
			setState(747);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(743);
				match(T__1);
				setState(744);
				literal();
				}
				}
				setState(749);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(750);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_executability_conditionContext extends ParserRuleContext {
		public TerminalNode IMPOSSIBLE() { return getToken(ALMParser.IMPOSSIBLE, 0); }
		public Occurs_atomContext occurs_atom() {
			return getRuleContext(Occurs_atomContext.class,0);
		}
		public TerminalNode IF() { return getToken(ALMParser.IF, 0); }
		public Instance_atomContext instance_atom() {
			return getRuleContext(Instance_atomContext.class,0);
		}
		public List<Occurs_literalContext> occurs_literal() {
			return getRuleContexts(Occurs_literalContext.class);
		}
		public Occurs_literalContext occurs_literal(int i) {
			return getRuleContext(Occurs_literalContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public One_executability_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_executability_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_executability_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_executability_condition(this);
		}
	}

	public final One_executability_conditionContext one_executability_condition() throws RecognitionException {
		One_executability_conditionContext _localctx = new One_executability_conditionContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_one_executability_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(752);
			match(IMPOSSIBLE);
			setState(753);
			occurs_atom();
			setState(754);
			match(IF);
			setState(755);
			instance_atom();
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(756);
				match(T__1);
				setState(759);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(757);
					occurs_literal();
					}
					break;
				case 2:
					{
					setState(758);
					literal();
					}
					break;
				}
				}
				}
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(766);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_state_constraintContext extends ParserRuleContext {
		public Fun_defContext fun_def() {
			return getRuleContext(Fun_defContext.class,0);
		}
		public TerminalNode IF() { return getToken(ALMParser.IF, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public TerminalNode FALSE() { return getToken(ALMParser.FALSE, 0); }
		public One_state_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_state_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_state_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_state_constraint(this);
		}
	}

	public final One_state_constraintContext one_state_constraint() throws RecognitionException {
		One_state_constraintContext _localctx = new One_state_constraintContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_one_state_constraint);
		int _la;
		try {
			setState(786);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(768);
				fun_def();
				setState(769);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(773);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(771);
					match(FALSE);
					}
					break;
				case 2:
					{
					setState(772);
					fun_def();
					}
					break;
				}
				setState(775);
				match(IF);
				setState(776);
				literal();
				setState(781);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(777);
					match(T__1);
					setState(778);
					literal();
					}
					}
					setState(783);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(784);
				match(T__8);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_definitionContext extends ParserRuleContext {
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public TerminalNode IF() { return getToken(ALMParser.IF, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public One_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_definition(this);
		}
	}

	public final One_definitionContext one_definition() throws RecognitionException {
		One_definitionContext _localctx = new One_definitionContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_one_definition);
		int _la;
		try {
			setState(803);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(788);
				function_term();
				setState(789);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(791);
				function_term();
				setState(792);
				match(IF);
				setState(793);
				literal();
				setState(798);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(794);
					match(T__1);
					setState(795);
					literal();
					}
					}
					setState(800);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(801);
				match(T__8);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Structure_nameContext extends ParserRuleContext {
		public Alm_nameContext alm_name() {
			return getRuleContext(Alm_nameContext.class,0);
		}
		public Structure_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterStructure_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitStructure_name(this);
		}
	}

	public final Structure_nameContext structure_name() throws RecognitionException {
		Structure_nameContext _localctx = new Structure_nameContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_structure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			alm_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructureContext extends ParserRuleContext {
		public TerminalNode STRUCTURE() { return getToken(ALMParser.STRUCTURE, 0); }
		public Structure_nameContext structure_name() {
			return getRuleContext(Structure_nameContext.class,0);
		}
		public List<Constant_defsContext> constant_defs() {
			return getRuleContexts(Constant_defsContext.class);
		}
		public Constant_defsContext constant_defs(int i) {
			return getRuleContext(Constant_defsContext.class,i);
		}
		public List<Instance_defsContext> instance_defs() {
			return getRuleContexts(Instance_defsContext.class);
		}
		public Instance_defsContext instance_defs(int i) {
			return getRuleContext(Instance_defsContext.class,i);
		}
		public List<Statics_defsContext> statics_defs() {
			return getRuleContexts(Statics_defsContext.class);
		}
		public Statics_defsContext statics_defs(int i) {
			return getRuleContext(Statics_defsContext.class,i);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitStructure(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			match(STRUCTURE);
			setState(808);
			structure_name();
			setState(814);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (CONSTANT - 49)) | (1L << (VALUE - 49)) | (1L << (INSTANCES - 49)))) != 0)) {
				{
				setState(812);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONSTANT:
					{
					setState(809);
					constant_defs();
					}
					break;
				case INSTANCES:
					{
					setState(810);
					instance_defs();
					}
					break;
				case VALUE:
					{
					setState(811);
					statics_defs();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(816);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant_defsContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(ALMParser.CONSTANT, 0); }
		public TerminalNode DEFINITIONS() { return getToken(ALMParser.DEFINITIONS, 0); }
		public List<One_constant_defContext> one_constant_def() {
			return getRuleContexts(One_constant_defContext.class);
		}
		public One_constant_defContext one_constant_def(int i) {
			return getRuleContext(One_constant_defContext.class,i);
		}
		public Constant_defsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_defs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterConstant_defs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitConstant_defs(this);
		}
	}

	public final Constant_defsContext constant_defs() throws RecognitionException {
		Constant_defsContext _localctx = new Constant_defsContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_constant_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
			match(CONSTANT);
			setState(818);
			match(DEFINITIONS);
			setState(820); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(819);
					one_constant_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(822); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_constant_defContext extends ParserRuleContext {
		public Object_constantContext object_constant() {
			return getRuleContext(Object_constantContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public One_constant_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_constant_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_constant_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_constant_def(this);
		}
	}

	public final One_constant_defContext one_constant_def() throws RecognitionException {
		One_constant_defContext _localctx = new One_constant_defContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_one_constant_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
			object_constant();
			setState(825);
			match(EQ);
			setState(826);
			term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Instance_defsContext extends ParserRuleContext {
		public TerminalNode INSTANCES() { return getToken(ALMParser.INSTANCES, 0); }
		public List<One_instance_defContext> one_instance_def() {
			return getRuleContexts(One_instance_defContext.class);
		}
		public One_instance_defContext one_instance_def(int i) {
			return getRuleContext(One_instance_defContext.class,i);
		}
		public Instance_defsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instance_defs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterInstance_defs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitInstance_defs(this);
		}
	}

	public final Instance_defsContext instance_defs() throws RecognitionException {
		Instance_defsContext _localctx = new Instance_defsContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_instance_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			match(INSTANCES);
			setState(830); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(829);
					one_instance_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(832); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_instance_defContext extends ParserRuleContext {
		public List<Object_constantContext> object_constant() {
			return getRuleContexts(Object_constantContext.class);
		}
		public Object_constantContext object_constant(int i) {
			return getRuleContext(Object_constantContext.class,i);
		}
		public TerminalNode IN() { return getToken(ALMParser.IN, 0); }
		public List<Sort_nameContext> sort_name() {
			return getRuleContexts(Sort_nameContext.class);
		}
		public Sort_nameContext sort_name(int i) {
			return getRuleContext(Sort_nameContext.class,i);
		}
		public Attribute_defsContext attribute_defs() {
			return getRuleContext(Attribute_defsContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(ALMParser.WHERE, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public One_instance_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_instance_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_instance_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_instance_def(this);
		}
	}

	public final One_instance_defContext one_instance_def() throws RecognitionException {
		One_instance_defContext _localctx = new One_instance_defContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_one_instance_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834);
			object_constant();
			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(835);
				match(T__1);
				setState(836);
				object_constant();
				}
				}
				setState(841);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(842);
			match(IN);
			setState(843);
			sort_name();
			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(844);
				match(T__1);
				setState(845);
				sort_name();
				}
				}
				setState(850);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(860);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(851);
				match(WHERE);
				setState(852);
				literal();
				setState(857);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(853);
					match(T__1);
					setState(854);
					literal();
					}
					}
					setState(859);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(862);
			attribute_defs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attribute_defsContext extends ParserRuleContext {
		public List<One_attribute_defContext> one_attribute_def() {
			return getRuleContexts(One_attribute_defContext.class);
		}
		public One_attribute_defContext one_attribute_def(int i) {
			return getRuleContext(One_attribute_defContext.class,i);
		}
		public Attribute_defsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_defs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterAttribute_defs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitAttribute_defs(this);
		}
	}

	public final Attribute_defsContext attribute_defs() throws RecognitionException {
		Attribute_defsContext _localctx = new Attribute_defsContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_attribute_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(864);
					one_attribute_def();
					}
					} 
				}
				setState(869);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_attribute_defContext extends ParserRuleContext {
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ALMParser.EQ, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public One_attribute_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_attribute_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_attribute_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_attribute_def(this);
		}
	}

	public final One_attribute_defContext one_attribute_def() throws RecognitionException {
		One_attribute_defContext _localctx = new One_attribute_defContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_one_attribute_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			function_term();
			setState(871);
			match(EQ);
			setState(872);
			term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Statics_defsContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(ALMParser.VALUE, 0); }
		public TerminalNode OF() { return getToken(ALMParser.OF, 0); }
		public TerminalNode STATICS() { return getToken(ALMParser.STATICS, 0); }
		public List<One_static_defContext> one_static_def() {
			return getRuleContexts(One_static_defContext.class);
		}
		public One_static_defContext one_static_def(int i) {
			return getRuleContext(One_static_defContext.class,i);
		}
		public Statics_defsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statics_defs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterStatics_defs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitStatics_defs(this);
		}
	}

	public final Statics_defsContext statics_defs() throws RecognitionException {
		Statics_defsContext _localctx = new Statics_defsContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_statics_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
			match(VALUE);
			setState(875);
			match(OF);
			setState(876);
			match(STATICS);
			setState(878); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(877);
					one_static_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(880); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_static_defContext extends ParserRuleContext {
		public Fun_defContext fun_def() {
			return getRuleContext(Fun_defContext.class,0);
		}
		public TerminalNode IF() { return getToken(ALMParser.IF, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public One_static_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_static_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_static_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_static_def(this);
		}
	}

	public final One_static_defContext one_static_def() throws RecognitionException {
		One_static_defContext _localctx = new One_static_defContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_one_static_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(882);
			fun_def();
			setState(892);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(883);
				match(IF);
				setState(884);
				literal();
				setState(889);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(885);
					match(T__1);
					setState(886);
					literal();
					}
					}
					setState(891);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(894);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Solver_modeContext extends ParserRuleContext {
		public Temporal_projectionContext temporal_projection() {
			return getRuleContext(Temporal_projectionContext.class,0);
		}
		public Planning_problemContext planning_problem() {
			return getRuleContext(Planning_problemContext.class,0);
		}
		public Diagnostic_problemContext diagnostic_problem() {
			return getRuleContext(Diagnostic_problemContext.class,0);
		}
		public Added_constraintsContext added_constraints() {
			return getRuleContext(Added_constraintsContext.class,0);
		}
		public Action_conditionsContext action_conditions() {
			return getRuleContext(Action_conditionsContext.class,0);
		}
		public Solver_modeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solver_mode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterSolver_mode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitSolver_mode(this);
		}
	}

	public final Solver_modeContext solver_mode() throws RecognitionException {
		Solver_modeContext _localctx = new Solver_modeContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_solver_mode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPORAL:
				{
				setState(896);
				temporal_projection();
				}
				break;
			case PLANNING:
				{
				setState(897);
				planning_problem();
				}
				break;
			case DIAGNOSTIC:
				{
				setState(898);
				diagnostic_problem();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(902);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADDITIONAL) {
				{
				setState(901);
				added_constraints();
				}
			}

			setState(905);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACTION) {
				{
				setState(904);
				action_conditions();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Max_stepsContext extends ParserRuleContext {
		public TerminalNode MAX() { return getToken(ALMParser.MAX, 0); }
		public TerminalNode STEPS() { return getToken(ALMParser.STEPS, 0); }
		public TerminalNode POSINT() { return getToken(ALMParser.POSINT, 0); }
		public Max_stepsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max_steps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterMax_steps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitMax_steps(this);
		}
	}

	public final Max_stepsContext max_steps() throws RecognitionException {
		Max_stepsContext _localctx = new Max_stepsContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_max_steps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(907);
			match(MAX);
			setState(908);
			match(STEPS);
			setState(909);
			match(POSINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Current_timeContext extends ParserRuleContext {
		public TerminalNode CURRENT() { return getToken(ALMParser.CURRENT, 0); }
		public TerminalNode TIME() { return getToken(ALMParser.TIME, 0); }
		public Nat_numContext nat_num() {
			return getRuleContext(Nat_numContext.class,0);
		}
		public Current_timeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_current_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterCurrent_time(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitCurrent_time(this);
		}
	}

	public final Current_timeContext current_time() throws RecognitionException {
		Current_timeContext _localctx = new Current_timeContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_current_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(911);
			match(CURRENT);
			setState(912);
			match(TIME);
			setState(913);
			nat_num();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HistoryContext extends ParserRuleContext {
		public TerminalNode HISTORY() { return getToken(ALMParser.HISTORY, 0); }
		public List<ObservedContext> observed() {
			return getRuleContexts(ObservedContext.class);
		}
		public ObservedContext observed(int i) {
			return getRuleContext(ObservedContext.class,i);
		}
		public List<HappenedContext> happened() {
			return getRuleContexts(HappenedContext.class);
		}
		public HappenedContext happened(int i) {
			return getRuleContext(HappenedContext.class,i);
		}
		public HistoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_history; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterHistory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitHistory(this);
		}
	}

	public final HistoryContext history() throws RecognitionException {
		HistoryContext _localctx = new HistoryContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_history);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			match(HISTORY);
			setState(918); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(918);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OBSERVED:
					{
					setState(916);
					observed();
					}
					break;
				case HAPPENED:
					{
					setState(917);
					happened();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(920); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OBSERVED || _la==HAPPENED );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObservedContext extends ParserRuleContext {
		public TerminalNode OBSERVED() { return getToken(ALMParser.OBSERVED, 0); }
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Nat_numContext nat_num() {
			return getRuleContext(Nat_numContext.class,0);
		}
		public ObservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_observed; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterObserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitObserved(this);
		}
	}

	public final ObservedContext observed() throws RecognitionException {
		ObservedContext _localctx = new ObservedContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_observed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
			match(OBSERVED);
			setState(923);
			match(T__0);
			setState(924);
			function_term();
			setState(925);
			match(T__1);
			setState(926);
			term();
			setState(927);
			match(T__1);
			setState(928);
			nat_num();
			setState(929);
			match(T__2);
			setState(930);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HappenedContext extends ParserRuleContext {
		public TerminalNode HAPPENED() { return getToken(ALMParser.HAPPENED, 0); }
		public Object_constantContext object_constant() {
			return getRuleContext(Object_constantContext.class,0);
		}
		public Nat_numContext nat_num() {
			return getRuleContext(Nat_numContext.class,0);
		}
		public HappenedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happened; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterHappened(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitHappened(this);
		}
	}

	public final HappenedContext happened() throws RecognitionException {
		HappenedContext _localctx = new HappenedContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_happened);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(932);
			match(HAPPENED);
			setState(933);
			match(T__0);
			setState(934);
			object_constant();
			setState(935);
			match(T__1);
			setState(936);
			nat_num();
			setState(937);
			match(T__2);
			setState(938);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Added_constraintsContext extends ParserRuleContext {
		public TerminalNode ADDITIONAL() { return getToken(ALMParser.ADDITIONAL, 0); }
		public TerminalNode CONSTRAINTS() { return getToken(ALMParser.CONSTRAINTS, 0); }
		public List<One_added_constraintContext> one_added_constraint() {
			return getRuleContexts(One_added_constraintContext.class);
		}
		public One_added_constraintContext one_added_constraint(int i) {
			return getRuleContext(One_added_constraintContext.class,i);
		}
		public Added_constraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_added_constraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterAdded_constraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitAdded_constraints(this);
		}
	}

	public final Added_constraintsContext added_constraints() throws RecognitionException {
		Added_constraintsContext _localctx = new Added_constraintsContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_added_constraints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(940);
			match(ADDITIONAL);
			setState(941);
			match(CONSTRAINTS);
			setState(943); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(942);
				one_added_constraint();
				}
				}
				setState(945); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPOSSIBLE || _la==AVOID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_added_constraintContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public TerminalNode IMPOSSIBLE() { return getToken(ALMParser.IMPOSSIBLE, 0); }
		public TerminalNode AVOID() { return getToken(ALMParser.AVOID, 0); }
		public One_added_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_added_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_added_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_added_constraint(this);
		}
	}

	public final One_added_constraintContext one_added_constraint() throws RecognitionException {
		One_added_constraintContext _localctx = new One_added_constraintContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_one_added_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
			_la = _input.LA(1);
			if ( !(_la==IMPOSSIBLE || _la==AVOID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(948);
			literal();
			setState(953);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(949);
				match(T__1);
				setState(950);
				literal();
				}
				}
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(956);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Action_conditionsContext extends ParserRuleContext {
		public TerminalNode ACTION() { return getToken(ALMParser.ACTION, 0); }
		public TerminalNode RESTRICTIONS() { return getToken(ALMParser.RESTRICTIONS, 0); }
		public TerminalNode PERMISSIONS() { return getToken(ALMParser.PERMISSIONS, 0); }
		public List<One_action_conditionContext> one_action_condition() {
			return getRuleContexts(One_action_conditionContext.class);
		}
		public One_action_conditionContext one_action_condition(int i) {
			return getRuleContext(One_action_conditionContext.class,i);
		}
		public Action_conditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterAction_conditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitAction_conditions(this);
		}
	}

	public final Action_conditionsContext action_conditions() throws RecognitionException {
		Action_conditionsContext _localctx = new Action_conditionsContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_action_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(958);
			match(ACTION);
			setState(959);
			_la = _input.LA(1);
			if ( !(_la==RESTRICTIONS || _la==PERMISSIONS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(961); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(960);
				one_action_condition();
				}
				}
				setState(963); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (IMPOSSIBLE - 62)) | (1L << (POSSIBLE - 62)) | (1L << (AVOID - 62)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_action_conditionContext extends ParserRuleContext {
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(ALMParser.WHEN, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public TerminalNode POSSIBLE() { return getToken(ALMParser.POSSIBLE, 0); }
		public TerminalNode IMPOSSIBLE() { return getToken(ALMParser.IMPOSSIBLE, 0); }
		public TerminalNode AVOID() { return getToken(ALMParser.AVOID, 0); }
		public One_action_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_action_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_action_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_action_condition(this);
		}
	}

	public final One_action_conditionContext one_action_condition() throws RecognitionException {
		One_action_conditionContext _localctx = new One_action_conditionContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_one_action_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(965);
			_la = _input.LA(1);
			if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (IMPOSSIBLE - 62)) | (1L << (POSSIBLE - 62)) | (1L << (AVOID - 62)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(966);
			function_term();
			setState(967);
			match(WHEN);
			setState(968);
			literal();
			setState(973);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(969);
				match(T__1);
				setState(970);
				literal();
				}
				}
				setState(975);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(976);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Temporal_projectionContext extends ParserRuleContext {
		public TerminalNode TEMPORAL() { return getToken(ALMParser.TEMPORAL, 0); }
		public TerminalNode PROJECTION() { return getToken(ALMParser.PROJECTION, 0); }
		public Max_stepsContext max_steps() {
			return getRuleContext(Max_stepsContext.class,0);
		}
		public HistoryContext history() {
			return getRuleContext(HistoryContext.class,0);
		}
		public Temporal_projectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporal_projection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterTemporal_projection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitTemporal_projection(this);
		}
	}

	public final Temporal_projectionContext temporal_projection() throws RecognitionException {
		Temporal_projectionContext _localctx = new Temporal_projectionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_temporal_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			match(TEMPORAL);
			setState(979);
			match(PROJECTION);
			setState(980);
			max_steps();
			setState(981);
			history();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Planning_problemContext extends ParserRuleContext {
		public TerminalNode PLANNING() { return getToken(ALMParser.PLANNING, 0); }
		public TerminalNode PROBLEM() { return getToken(ALMParser.PROBLEM, 0); }
		public Max_stepsContext max_steps() {
			return getRuleContext(Max_stepsContext.class,0);
		}
		public HistoryContext history() {
			return getRuleContext(HistoryContext.class,0);
		}
		public Goal_stateContext goal_state() {
			return getRuleContext(Goal_stateContext.class,0);
		}
		public Current_timeContext current_time() {
			return getRuleContext(Current_timeContext.class,0);
		}
		public Planning_problemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_planning_problem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterPlanning_problem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitPlanning_problem(this);
		}
	}

	public final Planning_problemContext planning_problem() throws RecognitionException {
		Planning_problemContext _localctx = new Planning_problemContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_planning_problem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			match(PLANNING);
			setState(984);
			match(PROBLEM);
			setState(985);
			max_steps();
			setState(987);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CURRENT) {
				{
				setState(986);
				current_time();
				}
			}

			setState(989);
			history();
			setState(990);
			goal_state();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Goal_stateContext extends ParserRuleContext {
		public TerminalNode GOAL() { return getToken(ALMParser.GOAL, 0); }
		public TerminalNode EQ() { return getToken(ALMParser.EQ, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public Goal_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterGoal_state(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitGoal_state(this);
		}
	}

	public final Goal_stateContext goal_state() throws RecognitionException {
		Goal_stateContext _localctx = new Goal_stateContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_goal_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(992);
			match(GOAL);
			setState(993);
			match(EQ);
			setState(994);
			match(T__12);
			setState(995);
			literal();
			setState(1000);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(996);
				match(T__1);
				setState(997);
				literal();
				}
				}
				setState(1002);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1003);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Diagnostic_problemContext extends ParserRuleContext {
		public TerminalNode DIAGNOSTIC() { return getToken(ALMParser.DIAGNOSTIC, 0); }
		public TerminalNode PROBLEM() { return getToken(ALMParser.PROBLEM, 0); }
		public Max_stepsContext max_steps() {
			return getRuleContext(Max_stepsContext.class,0);
		}
		public HistoryContext history() {
			return getRuleContext(HistoryContext.class,0);
		}
		public Current_stateContext current_state() {
			return getRuleContext(Current_stateContext.class,0);
		}
		public Current_timeContext current_time() {
			return getRuleContext(Current_timeContext.class,0);
		}
		public Normal_conditionsContext normal_conditions() {
			return getRuleContext(Normal_conditionsContext.class,0);
		}
		public Diagnostic_problemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diagnostic_problem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterDiagnostic_problem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitDiagnostic_problem(this);
		}
	}

	public final Diagnostic_problemContext diagnostic_problem() throws RecognitionException {
		Diagnostic_problemContext _localctx = new Diagnostic_problemContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_diagnostic_problem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1005);
			match(DIAGNOSTIC);
			setState(1006);
			match(PROBLEM);
			setState(1007);
			max_steps();
			setState(1009);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CURRENT) {
				{
				setState(1008);
				current_time();
				}
			}

			setState(1011);
			history();
			setState(1013);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NORMAL) {
				{
				setState(1012);
				normal_conditions();
				}
			}

			setState(1015);
			current_state();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Normal_conditionsContext extends ParserRuleContext {
		public TerminalNode NORMAL() { return getToken(ALMParser.NORMAL, 0); }
		public TerminalNode CONDITIONS() { return getToken(ALMParser.CONDITIONS, 0); }
		public List<One_normal_conditionContext> one_normal_condition() {
			return getRuleContexts(One_normal_conditionContext.class);
		}
		public One_normal_conditionContext one_normal_condition(int i) {
			return getRuleContext(One_normal_conditionContext.class,i);
		}
		public Normal_conditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterNormal_conditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitNormal_conditions(this);
		}
	}

	public final Normal_conditionsContext normal_conditions() throws RecognitionException {
		Normal_conditionsContext _localctx = new Normal_conditionsContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_normal_conditions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1017);
			match(NORMAL);
			setState(1018);
			match(CONDITIONS);
			setState(1020); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1019);
					one_normal_condition();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1022); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class One_normal_conditionContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public One_normal_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_normal_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterOne_normal_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitOne_normal_condition(this);
		}
	}

	public final One_normal_conditionContext one_normal_condition() throws RecognitionException {
		One_normal_conditionContext _localctx = new One_normal_conditionContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_one_normal_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1024);
			id();
			setState(1025);
			match(T__11);
			setState(1026);
			literal();
			setState(1036);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(1027);
				match(WHEN);
				setState(1028);
				literal();
				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(1029);
					match(T__1);
					setState(1030);
					literal();
					}
					}
					setState(1035);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1038);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Current_stateContext extends ParserRuleContext {
		public TerminalNode SITUATION() { return getToken(ALMParser.SITUATION, 0); }
		public TerminalNode EQ() { return getToken(ALMParser.EQ, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public Current_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_current_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterCurrent_state(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitCurrent_state(this);
		}
	}

	public final Current_stateContext current_state() throws RecognitionException {
		Current_stateContext _localctx = new Current_stateContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_current_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1040);
			match(SITUATION);
			setState(1041);
			match(EQ);
			setState(1042);
			match(T__12);
			setState(1043);
			literal();
			setState(1048);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1044);
				match(T__1);
				setState(1045);
				literal();
				}
				}
				setState(1050);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1051);
			match(T__13);
			setState(1052);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 11:
			return arithmetic_term_sempred((Arithmetic_termContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arithmetic_term_sempred(Arithmetic_termContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3h\u0421\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0113\n\6"+
		"\3\7\3\7\5\7\u0117\n\7\3\b\3\b\3\b\3\b\3\b\7\b\u011e\n\b\f\b\16\b\u0121"+
		"\13\b\3\b\3\b\5\b\u0125\n\b\3\b\5\b\u0128\n\b\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u0132\n\n\3\13\3\13\5\13\u0136\n\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\7\f\u0141\n\f\f\f\16\f\u0144\13\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u014c\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0157\n\r\f\r"+
		"\16\r\u015a\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u016c\n\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u01ac\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01b5\n\31\3"+
		"\32\3\32\3\32\5\32\u01ba\n\32\3\33\3\33\3\33\5\33\u01bf\n\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01cd\n\36\5\36"+
		"\u01cf\n\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01de\n"+
		" \3!\3!\3\"\6\"\u01e3\n\"\r\"\16\"\u01e4\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01ef"+
		"\n#\3#\3#\3#\5#\u01f4\n#\3$\5$\u01f7\n$\3$\5$\u01fa\n$\3$\5$\u01fd\n$"+
		"\3$\5$\u0200\n$\3$\5$\u0203\n$\3%\3%\3%\3%\3%\7%\u020a\n%\f%\16%\u020d"+
		"\13%\3&\3&\3&\5&\u0212\n&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\5(\u021d\n(\3"+
		")\3)\3)\3)\5)\u0223\n)\3*\3*\5*\u0227\n*\3+\3+\3+\6+\u022c\n+\r+\16+\u022d"+
		"\3,\3,\3,\7,\u0233\n,\f,\16,\u0236\13,\3,\3,\3,\3,\7,\u023c\n,\f,\16,"+
		"\u023f\13,\3,\5,\u0242\n,\3-\3-\6-\u0246\n-\r-\16-\u0247\3.\3.\3.\3.\3"+
		".\7.\u024f\n.\f.\16.\u0252\13.\3.\3.\5.\u0256\n.\3.\3.\3/\3/\3/\6/\u025d"+
		"\n/\r/\16/\u025e\3\60\3\60\3\60\7\60\u0264\n\60\f\60\16\60\u0267\13\60"+
		"\3\60\3\60\3\60\3\60\7\60\u026d\n\60\f\60\16\60\u0270\13\60\3\60\5\60"+
		"\u0273\n\60\3\61\3\61\3\62\3\62\3\62\5\62\u027a\n\62\3\62\5\62\u027d\n"+
		"\62\3\63\3\63\5\63\u0281\n\63\3\63\5\63\u0284\n\63\3\64\3\64\5\64\u0288"+
		"\n\64\3\64\5\64\u028b\n\64\3\65\3\65\6\65\u028f\n\65\r\65\16\65\u0290"+
		"\3\66\3\66\6\66\u0295\n\66\r\66\16\66\u0296\3\67\5\67\u029a\n\67\3\67"+
		"\3\67\3\67\3\67\3\67\7\67\u02a1\n\67\f\67\16\67\u02a4\13\67\3\67\3\67"+
		"\5\67\u02a8\n\67\38\38\38\38\38\38\38\58\u02b1\n8\39\39\39\39\3:\3:\5"+
		":\u02b9\n:\3;\3;\3;\3;\3;\6;\u02c0\n;\r;\16;\u02c1\3<\3<\3<\3<\7<\u02c8"+
		"\n<\f<\16<\u02cb\13<\3=\3=\3=\7=\u02d0\n=\f=\16=\u02d3\13=\3>\3>\3>\7"+
		">\u02d8\n>\f>\16>\u02db\13>\3?\3?\3?\7?\u02e0\n?\f?\16?\u02e3\13?\3@\3"+
		"@\3@\3@\3@\3@\3@\7@\u02ec\n@\f@\16@\u02ef\13@\3@\3@\3A\3A\3A\3A\3A\3A"+
		"\3A\5A\u02fa\nA\7A\u02fc\nA\fA\16A\u02ff\13A\3A\3A\3B\3B\3B\3B\3B\5B\u0308"+
		"\nB\3B\3B\3B\3B\7B\u030e\nB\fB\16B\u0311\13B\3B\3B\5B\u0315\nB\3C\3C\3"+
		"C\3C\3C\3C\3C\3C\7C\u031f\nC\fC\16C\u0322\13C\3C\3C\5C\u0326\nC\3D\3D"+
		"\3E\3E\3E\3E\3E\7E\u032f\nE\fE\16E\u0332\13E\3F\3F\3F\6F\u0337\nF\rF\16"+
		"F\u0338\3G\3G\3G\3G\3H\3H\6H\u0341\nH\rH\16H\u0342\3I\3I\3I\7I\u0348\n"+
		"I\fI\16I\u034b\13I\3I\3I\3I\3I\7I\u0351\nI\fI\16I\u0354\13I\3I\3I\3I\3"+
		"I\7I\u035a\nI\fI\16I\u035d\13I\5I\u035f\nI\3I\3I\3J\7J\u0364\nJ\fJ\16"+
		"J\u0367\13J\3K\3K\3K\3K\3L\3L\3L\3L\6L\u0371\nL\rL\16L\u0372\3M\3M\3M"+
		"\3M\3M\7M\u037a\nM\fM\16M\u037d\13M\5M\u037f\nM\3M\3M\3N\3N\3N\5N\u0386"+
		"\nN\3N\5N\u0389\nN\3N\5N\u038c\nN\3O\3O\3O\3O\3P\3P\3P\3P\3Q\3Q\3Q\6Q"+
		"\u0399\nQ\rQ\16Q\u039a\3R\3R\3R\3R\3R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3"+
		"S\3S\3S\3T\3T\3T\6T\u03b2\nT\rT\16T\u03b3\3U\3U\3U\3U\7U\u03ba\nU\fU\16"+
		"U\u03bd\13U\3U\3U\3V\3V\3V\6V\u03c4\nV\rV\16V\u03c5\3W\3W\3W\3W\3W\3W"+
		"\7W\u03ce\nW\fW\16W\u03d1\13W\3W\3W\3X\3X\3X\3X\3X\3Y\3Y\3Y\3Y\5Y\u03de"+
		"\nY\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\7Z\u03e9\nZ\fZ\16Z\u03ec\13Z\3Z\3Z\3[\3"+
		"[\3[\3[\5[\u03f4\n[\3[\3[\5[\u03f8\n[\3[\3[\3\\\3\\\3\\\6\\\u03ff\n\\"+
		"\r\\\16\\\u0400\3]\3]\3]\3]\3]\3]\3]\7]\u040a\n]\f]\16]\u040d\13]\5]\u040f"+
		"\n]\3]\3]\3^\3^\3^\3^\3^\3^\7^\u0419\n^\f^\16^\u041c\13^\3^\3^\3^\3^\2"+
		"\4\26\30_\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2"+
		"\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba"+
		"\2\t\3\2BC\4\2ffhh\3\2fh\4\2\24\25\27\27\4\2@@]]\3\2Z[\4\2@@\\]\2\u048e"+
		"\2\u00bc\3\2\2\2\4\u00be\3\2\2\2\6\u00c0\3\2\2\2\b\u00c2\3\2\2\2\n\u0112"+
		"\3\2\2\2\f\u0116\3\2\2\2\16\u0127\3\2\2\2\20\u0129\3\2\2\2\22\u0131\3"+
		"\2\2\2\24\u0135\3\2\2\2\26\u0137\3\2\2\2\30\u014b\3\2\2\2\32\u016b\3\2"+
		"\2\2\34\u016d\3\2\2\2\36\u0172\3\2\2\2 \u0179\3\2\2\2\"\u0180\3\2\2\2"+
		"$\u0187\3\2\2\2&\u018e\3\2\2\2(\u0193\3\2\2\2*\u0198\3\2\2\2,\u019d\3"+
		"\2\2\2.\u01ab\3\2\2\2\60\u01b4\3\2\2\2\62\u01b9\3\2\2\2\64\u01be\3\2\2"+
		"\2\66\u01c2\3\2\2\28\u01c4\3\2\2\2:\u01c6\3\2\2\2<\u01d2\3\2\2\2>\u01dd"+
		"\3\2\2\2@\u01df\3\2\2\2B\u01e2\3\2\2\2D\u01f3\3\2\2\2F\u01f6\3\2\2\2H"+
		"\u0204\3\2\2\2J\u0211\3\2\2\2L\u0215\3\2\2\2N\u021c\3\2\2\2P\u0222\3\2"+
		"\2\2R\u0226\3\2\2\2T\u0228\3\2\2\2V\u022f\3\2\2\2X\u0243\3\2\2\2Z\u0249"+
		"\3\2\2\2\\\u0259\3\2\2\2^\u0260\3\2\2\2`\u0274\3\2\2\2b\u0276\3\2\2\2"+
		"d\u027e\3\2\2\2f\u0285\3\2\2\2h\u028c\3\2\2\2j\u0292\3\2\2\2l\u0299\3"+
		"\2\2\2n\u02b0\3\2\2\2p\u02b2\3\2\2\2r\u02b8\3\2\2\2t\u02ba\3\2\2\2v\u02c3"+
		"\3\2\2\2x\u02cc\3\2\2\2z\u02d4\3\2\2\2|\u02dc\3\2\2\2~\u02e4\3\2\2\2\u0080"+
		"\u02f2\3\2\2\2\u0082\u0314\3\2\2\2\u0084\u0325\3\2\2\2\u0086\u0327\3\2"+
		"\2\2\u0088\u0329\3\2\2\2\u008a\u0333\3\2\2\2\u008c\u033a\3\2\2\2\u008e"+
		"\u033e\3\2\2\2\u0090\u0344\3\2\2\2\u0092\u0365\3\2\2\2\u0094\u0368\3\2"+
		"\2\2\u0096\u036c\3\2\2\2\u0098\u0374\3\2\2\2\u009a\u0385\3\2\2\2\u009c"+
		"\u038d\3\2\2\2\u009e\u0391\3\2\2\2\u00a0\u0395\3\2\2\2\u00a2\u039c\3\2"+
		"\2\2\u00a4\u03a6\3\2\2\2\u00a6\u03ae\3\2\2\2\u00a8\u03b5\3\2\2\2\u00aa"+
		"\u03c0\3\2\2\2\u00ac\u03c7\3\2\2\2\u00ae\u03d4\3\2\2\2\u00b0\u03d9\3\2"+
		"\2\2\u00b2\u03e2\3\2\2\2\u00b4\u03ef\3\2\2\2\u00b6\u03fb\3\2\2\2\u00b8"+
		"\u0402\3\2\2\2\u00ba\u0412\3\2\2\2\u00bc\u00bd\t\2\2\2\u00bd\3\3\2\2\2"+
		"\u00be\u00bf\t\3\2\2\u00bf\5\3\2\2\2\u00c0\u00c1\t\4\2\2\u00c1\7\3\2\2"+
		"\2\u00c2\u00c3\t\5\2\2\u00c3\t\3\2\2\2\u00c4\u0113\7\31\2\2\u00c5\u0113"+
		"\7\32\2\2\u00c6\u0113\7\33\2\2\u00c7\u0113\7\34\2\2\u00c8\u0113\7\35\2"+
		"\2\u00c9\u0113\7\36\2\2\u00ca\u0113\7\37\2\2\u00cb\u0113\7 \2\2\u00cc"+
		"\u0113\7!\2\2\u00cd\u0113\7\"\2\2\u00ce\u0113\7d\2\2\u00cf\u0113\7\23"+
		"\2\2\u00d0\u0113\7#\2\2\u00d1\u0113\7$\2\2\u00d2\u0113\7%\2\2\u00d3\u0113"+
		"\7&\2\2\u00d4\u0113\7\'\2\2\u00d5\u0113\7(\2\2\u00d6\u0113\7)\2\2\u00d7"+
		"\u0113\7*\2\2\u00d8\u0113\7+\2\2\u00d9\u0113\7,\2\2\u00da\u0113\7-\2\2"+
		"\u00db\u0113\7.\2\2\u00dc\u0113\7/\2\2\u00dd\u0113\7\60\2\2\u00de\u0113"+
		"\7\61\2\2\u00df\u0113\7\62\2\2\u00e0\u0113\7\63\2\2\u00e1\u0113\7\64\2"+
		"\2\u00e2\u0113\7\65\2\2\u00e3\u0113\7\66\2\2\u00e4\u0113\7\67\2\2\u00e5"+
		"\u0113\78\2\2\u00e6\u0113\79\2\2\u00e7\u0113\7:\2\2\u00e8\u0113\7;\2\2"+
		"\u00e9\u0113\7<\2\2\u00ea\u0113\7=\2\2\u00eb\u0113\7>\2\2\u00ec\u0113"+
		"\7?\2\2\u00ed\u0113\7@\2\2\u00ee\u0113\7A\2\2\u00ef\u0113\7B\2\2\u00f0"+
		"\u0113\7C\2\2\u00f1\u0113\7D\2\2\u00f2\u0113\7E\2\2\u00f3\u0113\7F\2\2"+
		"\u00f4\u0113\7G\2\2\u00f5\u0113\7H\2\2\u00f6\u0113\7I\2\2\u00f7\u0113"+
		"\7J\2\2\u00f8\u0113\7K\2\2\u00f9\u0113\7L\2\2\u00fa\u0113\7M\2\2\u00fb"+
		"\u0113\7N\2\2\u00fc\u0113\7O\2\2\u00fd\u0113\7P\2\2\u00fe\u0113\7Q\2\2"+
		"\u00ff\u0113\7R\2\2\u0100\u0113\7S\2\2\u0101\u0113\7T\2\2\u0102\u0113"+
		"\7U\2\2\u0103\u0113\7V\2\2\u0104\u0113\7W\2\2\u0105\u0113\7X\2\2\u0106"+
		"\u0113\7Y\2\2\u0107\u0113\7Z\2\2\u0108\u0113\7[\2\2\u0109\u0113\7\\\2"+
		"\2\u010a\u0113\7]\2\2\u010b\u0113\7^\2\2\u010c\u0113\7_\2\2\u010d\u0113"+
		"\7`\2\2\u010e\u0113\7a\2\2\u010f\u0113\7b\2\2\u0110\u0113\7c\2\2\u0111"+
		"\u0113\5\6\4\2\u0112\u00c4\3\2\2\2\u0112\u00c5\3\2\2\2\u0112\u00c6\3\2"+
		"\2\2\u0112\u00c7\3\2\2\2\u0112\u00c8\3\2\2\2\u0112\u00c9\3\2\2\2\u0112"+
		"\u00ca\3\2\2\2\u0112\u00cb\3\2\2\2\u0112\u00cc\3\2\2\2\u0112\u00cd\3\2"+
		"\2\2\u0112\u00ce\3\2\2\2\u0112\u00cf\3\2\2\2\u0112\u00d0\3\2\2\2\u0112"+
		"\u00d1\3\2\2\2\u0112\u00d2\3\2\2\2\u0112\u00d3\3\2\2\2\u0112\u00d4\3\2"+
		"\2\2\u0112\u00d5\3\2\2\2\u0112\u00d6\3\2\2\2\u0112\u00d7\3\2\2\2\u0112"+
		"\u00d8\3\2\2\2\u0112\u00d9\3\2\2\2\u0112\u00da\3\2\2\2\u0112\u00db\3\2"+
		"\2\2\u0112\u00dc\3\2\2\2\u0112\u00dd\3\2\2\2\u0112\u00de\3\2\2\2\u0112"+
		"\u00df\3\2\2\2\u0112\u00e0\3\2\2\2\u0112\u00e1\3\2\2\2\u0112\u00e2\3\2"+
		"\2\2\u0112\u00e3\3\2\2\2\u0112\u00e4\3\2\2\2\u0112\u00e5\3\2\2\2\u0112"+
		"\u00e6\3\2\2\2\u0112\u00e7\3\2\2\2\u0112\u00e8\3\2\2\2\u0112\u00e9\3\2"+
		"\2\2\u0112\u00ea\3\2\2\2\u0112\u00eb\3\2\2\2\u0112\u00ec\3\2\2\2\u0112"+
		"\u00ed\3\2\2\2\u0112\u00ee\3\2\2\2\u0112\u00ef\3\2\2\2\u0112\u00f0\3\2"+
		"\2\2\u0112\u00f1\3\2\2\2\u0112\u00f2\3\2\2\2\u0112\u00f3\3\2\2\2\u0112"+
		"\u00f4\3\2\2\2\u0112\u00f5\3\2\2\2\u0112\u00f6\3\2\2\2\u0112\u00f7\3\2"+
		"\2\2\u0112\u00f8\3\2\2\2\u0112\u00f9\3\2\2\2\u0112\u00fa\3\2\2\2\u0112"+
		"\u00fb\3\2\2\2\u0112\u00fc\3\2\2\2\u0112\u00fd\3\2\2\2\u0112\u00fe\3\2"+
		"\2\2\u0112\u00ff\3\2\2\2\u0112\u0100\3\2\2\2\u0112\u0101\3\2\2\2\u0112"+
		"\u0102\3\2\2\2\u0112\u0103\3\2\2\2\u0112\u0104\3\2\2\2\u0112\u0105\3\2"+
		"\2\2\u0112\u0106\3\2\2\2\u0112\u0107\3\2\2\2\u0112\u0108\3\2\2\2\u0112"+
		"\u0109\3\2\2\2\u0112\u010a\3\2\2\2\u0112\u010b\3\2\2\2\u0112\u010c\3\2"+
		"\2\2\u0112\u010d\3\2\2\2\u0112\u010e\3\2\2\2\u0112\u010f\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113\13\3\2\2\2\u0114\u0117\5\n\6"+
		"\2\u0115\u0117\7e\2\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\r"+
		"\3\2\2\2\u0118\u0124\5\n\6\2\u0119\u011a\7\3\2\2\u011a\u011f\5\22\n\2"+
		"\u011b\u011c\7\4\2\2\u011c\u011e\5\22\n\2\u011d\u011b\3\2\2\2\u011e\u0121"+
		"\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0122\u0123\7\5\2\2\u0123\u0125\3\2\2\2\u0124\u0119\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0128\5\6\4\2\u0127"+
		"\u0118\3\2\2\2\u0127\u0126\3\2\2\2\u0128\17\3\2\2\2\u0129\u012a\5\16\b"+
		"\2\u012a\21\3\2\2\2\u012b\u0132\5\2\2\2\u012c\u0132\7e\2\2\u012d\u0132"+
		"\5\n\6\2\u012e\u0132\5\6\4\2\u012f\u0132\5\20\t\2\u0130\u0132\5\26\f\2"+
		"\u0131\u012b\3\2\2\2\u0131\u012c\3\2\2\2\u0131\u012d\3\2\2\2\u0131\u012e"+
		"\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0130\3\2\2\2\u0132\23\3\2\2\2\u0133"+
		"\u0136\5\16\b\2\u0134\u0136\7e\2\2\u0135\u0133\3\2\2\2\u0135\u0134\3\2"+
		"\2\2\u0136\25\3\2\2\2\u0137\u0138\b\f\1\2\u0138\u0139\5\30\r\2\u0139\u0142"+
		"\3\2\2\2\u013a\u013b\f\5\2\2\u013b\u013c\7\6\2\2\u013c\u0141\5\30\r\2"+
		"\u013d\u013e\f\4\2\2\u013e\u013f\7\7\2\2\u013f\u0141\5\30\r\2\u0140\u013a"+
		"\3\2\2\2\u0140\u013d\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\27\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\b\r\1"+
		"\2\u0146\u0147\5\32\16\2\u0147\u0148\7\n\2\2\u0148\u0149\5\32\16\2\u0149"+
		"\u014c\3\2\2\2\u014a\u014c\5\32\16\2\u014b\u0145\3\2\2\2\u014b\u014a\3"+
		"\2\2\2\u014c\u0158\3\2\2\2\u014d\u014e\f\7\2\2\u014e\u014f\7\b\2\2\u014f"+
		"\u0157\5\32\16\2\u0150\u0151\f\6\2\2\u0151\u0152\7\t\2\2\u0152\u0157\5"+
		"\32\16\2\u0153\u0154\f\5\2\2\u0154\u0155\7\23\2\2\u0155\u0157\5\32\16"+
		"\2\u0156\u014d\3\2\2\2\u0156\u0150\3\2\2\2\u0156\u0153\3\2\2\2\u0157\u015a"+
		"\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\31\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015b\u016c\7e\2\2\u015c\u015d\7\7\2\2\u015d\u016c\7e\2"+
		"\2\u015e\u016c\5\6\4\2\u015f\u016c\5\20\t\2\u0160\u0161\7\7\2\2\u0161"+
		"\u016c\5\20\t\2\u0162\u0163\7\3\2\2\u0163\u0164\5\26\f\2\u0164\u0165\7"+
		"\5\2\2\u0165\u016c\3\2\2\2\u0166\u0167\7\7\2\2\u0167\u0168\7\3\2\2\u0168"+
		"\u0169\5\26\f\2\u0169\u016a\7\5\2\2\u016a\u016c\3\2\2\2\u016b\u015b\3"+
		"\2\2\2\u016b\u015c\3\2\2\2\u016b\u015e\3\2\2\2\u016b\u015f\3\2\2\2\u016b"+
		"\u0160\3\2\2\2\u016b\u0162\3\2\2\2\u016b\u0166\3\2\2\2\u016c\33\3\2\2"+
		"\2\u016d\u016e\7\31\2\2\u016e\u016f\7\3\2\2\u016f\u0170\5\24\13\2\u0170"+
		"\u0171\7\5\2\2\u0171\35\3\2\2\2\u0172\u0173\7\32\2\2\u0173\u0174\7\3\2"+
		"\2\u0174\u0175\5\24\13\2\u0175\u0176\7\4\2\2\u0176\u0177\5P)\2\u0177\u0178"+
		"\7\5\2\2\u0178\37\3\2\2\2\u0179\u017a\7\33\2\2\u017a\u017b\7\3\2\2\u017b"+
		"\u017c\5\24\13\2\u017c\u017d\7\4\2\2\u017d\u017e\5P)\2\u017e\u017f\7\5"+
		"\2\2\u017f!\3\2\2\2\u0180\u0181\7\36\2\2\u0181\u0182\7\3\2\2\u0182\u0183"+
		"\5P)\2\u0183\u0184\7\4\2\2\u0184\u0185\5P)\2\u0185\u0186\7\5\2\2\u0186"+
		"#\3\2\2\2\u0187\u0188\7!\2\2\u0188\u0189\7\3\2\2\u0189\u018a\5P)\2\u018a"+
		"\u018b\7\4\2\2\u018b\u018c\5P)\2\u018c\u018d\7\5\2\2\u018d%\3\2\2\2\u018e"+
		"\u018f\7\34\2\2\u018f\u0190\7\3\2\2\u0190\u0191\5P)\2\u0191\u0192\7\5"+
		"\2\2\u0192\'\3\2\2\2\u0193\u0194\7\35\2\2\u0194\u0195\7\3\2\2\u0195\u0196"+
		"\5P)\2\u0196\u0197\7\5\2\2\u0197)\3\2\2\2\u0198\u0199\7 \2\2\u0199\u019a"+
		"\7\3\2\2\u019a\u019b\5P)\2\u019b\u019c\7\5\2\2\u019c+\3\2\2\2\u019d\u019e"+
		"\7\37\2\2\u019e\u019f\7\3\2\2\u019f\u01a0\5P)\2\u01a0\u01a1\7\5\2\2\u01a1"+
		"-\3\2\2\2\u01a2\u01ac\5\36\20\2\u01a3\u01ac\5 \21\2\u01a4\u01ac\5\"\22"+
		"\2\u01a5\u01ac\5$\23\2\u01a6\u01ac\5&\24\2\u01a7\u01ac\5(\25\2\u01a8\u01ac"+
		"\5*\26\2\u01a9\u01ac\5,\27\2\u01aa\u01ac\5\20\t\2\u01ab\u01a2\3\2\2\2"+
		"\u01ab\u01a3\3\2\2\2\u01ab\u01a4\3\2\2\2\u01ab\u01a5\3\2\2\2\u01ab\u01a6"+
		"\3\2\2\2\u01ab\u01a7\3\2\2\2\u01ab\u01a8\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab"+
		"\u01aa\3\2\2\2\u01ac/\3\2\2\2\u01ad\u01b5\5.\30\2\u01ae\u01af\7\7\2\2"+
		"\u01af\u01b5\5.\30\2\u01b0\u01b1\5\22\n\2\u01b1\u01b2\5\b\5\2\u01b2\u01b3"+
		"\5\22\n\2\u01b3\u01b5\3\2\2\2\u01b4\u01ad\3\2\2\2\u01b4\u01ae\3\2\2\2"+
		"\u01b4\u01b0\3\2\2\2\u01b5\61\3\2\2\2\u01b6\u01ba\5\34\17\2\u01b7\u01b8"+
		"\7\7\2\2\u01b8\u01ba\5\34\17\2\u01b9\u01b6\3\2\2\2\u01b9\u01b7\3\2\2\2"+
		"\u01ba\63\3\2\2\2\u01bb\u01bf\5:\36\2\u01bc\u01bf\5> \2\u01bd\u01bf\5"+
		"D#\2\u01be\u01bb\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bd\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01c1\7\2\2\3\u01c1\65\3\2\2\2\u01c2\u01c3\5\f\7"+
		"\2\u01c3\67\3\2\2\2\u01c4\u01c5\5\f\7\2\u01c59\3\2\2\2\u01c6\u01c7\7)"+
		"\2\2\u01c7\u01c8\7*\2\2\u01c8\u01c9\58\35\2\u01c9\u01ce\5> \2\u01ca\u01cc"+
		"\5\u0088E\2\u01cb\u01cd\5\u009aN\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2"+
		"\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01ca\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01d0\3\2\2\2\u01d0\u01d1\7\2\2\3\u01d1;\3\2\2\2\u01d2\u01d3\5\f\7\2"+
		"\u01d3=\3\2\2\2\u01d4\u01d5\7+\2\2\u01d5\u01d6\5<\37\2\u01d6\u01d7\5B"+
		"\"\2\u01d7\u01de\3\2\2\2\u01d8\u01d9\7-\2\2\u01d9\u01da\5<\37\2\u01da"+
		"\u01db\7.\2\2\u01db\u01dc\5\66\34\2\u01dc\u01de\3\2\2\2\u01dd\u01d4\3"+
		"\2\2\2\u01dd\u01d8\3\2\2\2\u01de?\3\2\2\2\u01df\u01e0\5\f\7\2\u01e0A\3"+
		"\2\2\2\u01e1\u01e3\5D#\2\u01e2\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5C\3\2\2\2\u01e6\u01e7\7,\2\2\u01e7"+
		"\u01e8\5@!\2\u01e8\u01e9\5F$\2\u01e9\u01f4\3\2\2\2\u01ea\u01eb\7-\2\2"+
		"\u01eb\u01ee\5<\37\2\u01ec\u01ed\7\13\2\2\u01ed\u01ef\5@!\2\u01ee\u01ec"+
		"\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\7.\2\2\u01f1"+
		"\u01f2\5\66\34\2\u01f2\u01f4\3\2\2\2\u01f3\u01e6\3\2\2\2\u01f3\u01ea\3"+
		"\2\2\2\u01f4E\3\2\2\2\u01f5\u01f7\5H%\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7"+
		"\3\2\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01fa\5T+\2\u01f9\u01f8\3\2\2\2\u01f9"+
		"\u01fa\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01fd\5\\/\2\u01fc\u01fb\3\2"+
		"\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01ff\3\2\2\2\u01fe\u0200\5b\62\2\u01ff"+
		"\u01fe\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0202\3\2\2\2\u0201\u0203\5t"+
		";\2\u0202\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203G\3\2\2\2\u0204\u0205"+
		"\7/\2\2\u0205\u0206\7\60\2\2\u0206\u020b\5J&\2\u0207\u0208\7\4\2\2\u0208"+
		"\u020a\5J&\2\u0209\u0207\3\2\2\2\u020a\u020d\3\2\2\2\u020b\u0209\3\2\2"+
		"\2\u020b\u020c\3\2\2\2\u020cI\3\2\2\2\u020d\u020b\3\2\2\2\u020e\u020f"+
		"\5<\37\2\u020f\u0210\7\13\2\2\u0210\u0212\3\2\2\2\u0211\u020e\3\2\2\2"+
		"\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\5@!\2\u0214K\3\2"+
		"\2\2\u0215\u0216\5\6\4\2\u0216\u0217\7\f\2\2\u0217\u0218\5\6\4\2\u0218"+
		"M\3\2\2\2\u0219\u021d\7^\2\2\u021a\u021d\7_\2\2\u021b\u021d\5L\'\2\u021c"+
		"\u0219\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021b\3\2\2\2\u021dO\3\2\2\2"+
		"\u021e\u0223\5N(\2\u021f\u0223\7`\2\2\u0220\u0223\7a\2\2\u0221\u0223\5"+
		"\n\6\2\u0222\u021e\3\2\2\2\u0222\u021f\3\2\2\2\u0222\u0220\3\2\2\2\u0222"+
		"\u0221\3\2\2\2\u0223Q\3\2\2\2\u0224\u0227\5\n\6\2\u0225\u0227\5L\'\2\u0226"+
		"\u0224\3\2\2\2\u0226\u0225\3\2\2\2\u0227S\3\2\2\2\u0228\u0229\7#\2\2\u0229"+
		"\u022b\7\'\2\2\u022a\u022c\5V,\2\u022b\u022a\3\2\2\2\u022c\u022d\3\2\2"+
		"\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022eU\3\2\2\2\u022f\u0234"+
		"\5R*\2\u0230\u0231\7\4\2\2\u0231\u0233\5R*\2\u0232\u0230\3\2\2\2\u0233"+
		"\u0236\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0237\3\2"+
		"\2\2\u0236\u0234\3\2\2\2\u0237\u0238\7\r\2\2\u0238\u023d\5P)\2\u0239\u023a"+
		"\7\4\2\2\u023a\u023c\5P)\2\u023b\u0239\3\2\2\2\u023c\u023f\3\2\2\2\u023d"+
		"\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0241\3\2\2\2\u023f\u023d\3\2"+
		"\2\2\u0240\u0242\5X-\2\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242W"+
		"\3\2\2\2\u0243\u0245\7\61\2\2\u0244\u0246\5Z.\2\u0245\u0244\3\2\2\2\u0246"+
		"\u0247\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248Y\3\2\2\2"+
		"\u0249\u024a\5\n\6\2\u024a\u0255\7\16\2\2\u024b\u0250\5P)\2\u024c\u024d"+
		"\7\4\2\2\u024d\u024f\5P)\2\u024e\u024c\3\2\2\2\u024f\u0252\3\2\2\2\u0250"+
		"\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0253\3\2\2\2\u0252\u0250\3\2"+
		"\2\2\u0253\u0254\7\30\2\2\u0254\u0256\3\2\2\2\u0255\u024b\3\2\2\2\u0255"+
		"\u0256\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\5P)\2\u0258[\3\2\2\2\u0259"+
		"\u025a\7\63\2\2\u025a\u025c\7\'\2\2\u025b\u025d\5^\60\2\u025c\u025b\3"+
		"\2\2\2\u025d\u025e\3\2\2\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2\2\2\u025f"+
		"]\3\2\2\2\u0260\u0265\5\16\b\2\u0261\u0262\7\4\2\2\u0262\u0264\5\16\b"+
		"\2\u0263\u0261\3\2\2\2\u0264\u0267\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0266"+
		"\3\2\2\2\u0266\u0268\3\2\2\2\u0267\u0265\3\2\2\2\u0268\u0269\7\16\2\2"+
		"\u0269\u026e\5P)\2\u026a\u026b\7\4\2\2\u026b\u026d\5P)\2\u026c\u026a\3"+
		"\2\2\2\u026d\u0270\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f"+
		"\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0271\u0273\5\u0092J\2\u0272\u0271"+
		"\3\2\2\2\u0272\u0273\3\2\2\2\u0273_\3\2\2\2\u0274\u0275\5\n\6\2\u0275"+
		"a\3\2\2\2\u0276\u0277\7&\2\2\u0277\u0279\7\'\2\2\u0278\u027a\5d\63\2\u0279"+
		"\u0278\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027c\3\2\2\2\u027b\u027d\5f"+
		"\64\2\u027c\u027b\3\2\2\2\u027c\u027d\3\2\2\2\u027dc\3\2\2\2\u027e\u0280"+
		"\7\64\2\2\u027f\u0281\5h\65\2\u0280\u027f\3\2\2\2\u0280\u0281\3\2\2\2"+
		"\u0281\u0283\3\2\2\2\u0282\u0284\5j\66\2\u0283\u0282\3\2\2\2\u0283\u0284"+
		"\3\2\2\2\u0284e\3\2\2\2\u0285\u0287\7\65\2\2\u0286\u0288\5h\65\2\u0287"+
		"\u0286\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u028a\3\2\2\2\u0289\u028b\5j"+
		"\66\2\u028a\u0289\3\2\2\2\u028a\u028b\3\2\2\2\u028bg\3\2\2\2\u028c\u028e"+
		"\7\66\2\2\u028d\u028f\5l\67\2\u028e\u028d\3\2\2\2\u028f\u0290\3\2\2\2"+
		"\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291i\3\2\2\2\u0292\u0294\7"+
		"\67\2\2\u0293\u0295\5l\67\2\u0294\u0293\3\2\2\2\u0295\u0296\3\2\2\2\u0296"+
		"\u0294\3\2\2\2\u0296\u0297\3\2\2\2\u0297k\3\2\2\2\u0298\u029a\78\2\2\u0299"+
		"\u0298\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\5`"+
		"\61\2\u029c\u029d\7\16\2\2\u029d\u02a7\5P)\2\u029e\u029f\7\b\2\2\u029f"+
		"\u02a1\5P)\2\u02a0\u029e\3\2\2\2\u02a1\u02a4\3\2\2\2\u02a2\u02a0\3\2\2"+
		"\2\u02a2\u02a3\3\2\2\2\u02a3\u02a5\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a5\u02a6"+
		"\7\30\2\2\u02a6\u02a8\5P)\2\u02a7\u02a2\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8"+
		"m\3\2\2\2\u02a9\u02aa\5\20\t\2\u02aa\u02ab\7\24\2\2\u02ab\u02ac\5\22\n"+
		"\2\u02ac\u02b1\3\2\2\2\u02ad\u02b1\5\20\t\2\u02ae\u02af\7\7\2\2\u02af"+
		"\u02b1\5\20\t\2\u02b0\u02a9\3\2\2\2\u02b0\u02ad\3\2\2\2\u02b0\u02ae\3"+
		"\2\2\2\u02b1o\3\2\2\2\u02b2\u02b3\5\20\t\2\u02b3\u02b4\7\25\2\2\u02b4"+
		"\u02b5\5\22\n\2\u02b5q\3\2\2\2\u02b6\u02b9\5n8\2\u02b7\u02b9\5p9\2\u02b8"+
		"\u02b6\3\2\2\2\u02b8\u02b7\3\2\2\2\u02b9s\3\2\2\2\u02ba\u02bf\79\2\2\u02bb"+
		"\u02c0\5v<\2\u02bc\u02c0\5x=\2\u02bd\u02c0\5z>\2\u02be\u02c0\5|?\2\u02bf"+
		"\u02bb\3\2\2\2\u02bf\u02bc\3\2\2\2\u02bf\u02bd\3\2\2\2\u02bf\u02be\3\2"+
		"\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2"+
		"u\3\2\2\2\u02c3\u02c4\7:\2\2\u02c4\u02c5\7;\2\2\u02c5\u02c9\7<\2\2\u02c6"+
		"\u02c8\5~@\2\u02c7\u02c6\3\2\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02c7\3\2\2"+
		"\2\u02c9\u02ca\3\2\2\2\u02caw\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cc\u02cd"+
		"\7=\2\2\u02cd\u02d1\7>\2\2\u02ce\u02d0\5\u0080A\2\u02cf\u02ce\3\2\2\2"+
		"\u02d0\u02d3\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2y\3"+
		"\2\2\2\u02d3\u02d1\3\2\2\2\u02d4\u02d5\7$\2\2\u02d5\u02d9\7%\2\2\u02d6"+
		"\u02d8\5\u0082B\2\u02d7\u02d6\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9\u02d7"+
		"\3\2\2\2\u02d9\u02da\3\2\2\2\u02da{\3\2\2\2\u02db\u02d9\3\2\2\2\u02dc"+
		"\u02dd\7&\2\2\u02dd\u02e1\7(\2\2\u02de\u02e0\5\u0084C\2\u02df\u02de\3"+
		"\2\2\2\u02e0\u02e3\3\2\2\2\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2"+
		"}\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e4\u02e5\5\34\17\2\u02e5\u02e6\7?\2\2"+
		"\u02e6\u02e7\5n8\2\u02e7\u02e8\7A\2\2\u02e8\u02ed\5\36\20\2\u02e9\u02ea"+
		"\7\4\2\2\u02ea\u02ec\5\60\31\2\u02eb\u02e9\3\2\2\2\u02ec\u02ef\3\2\2\2"+
		"\u02ed\u02eb\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02f0\3\2\2\2\u02ef\u02ed"+
		"\3\2\2\2\u02f0\u02f1\7\13\2\2\u02f1\177\3\2\2\2\u02f2\u02f3\7@\2\2\u02f3"+
		"\u02f4\5\34\17\2\u02f4\u02f5\7A\2\2\u02f5\u02fd\5\36\20\2\u02f6\u02f9"+
		"\7\4\2\2\u02f7\u02fa\5\62\32\2\u02f8\u02fa\5\60\31\2\u02f9\u02f7\3\2\2"+
		"\2\u02f9\u02f8\3\2\2\2\u02fa\u02fc\3\2\2\2\u02fb\u02f6\3\2\2\2\u02fc\u02ff"+
		"\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0300\3\2\2\2\u02ff"+
		"\u02fd\3\2\2\2\u0300\u0301\7\13\2\2\u0301\u0081\3\2\2\2\u0302\u0303\5"+
		"r:\2\u0303\u0304\7\13\2\2\u0304\u0315\3\2\2\2\u0305\u0308\7B\2\2\u0306"+
		"\u0308\5r:\2\u0307\u0305\3\2\2\2\u0307\u0306\3\2\2\2\u0308\u0309\3\2\2"+
		"\2\u0309\u030a\7A\2\2\u030a\u030f\5\60\31\2\u030b\u030c\7\4\2\2\u030c"+
		"\u030e\5\60\31\2\u030d\u030b\3\2\2\2\u030e\u0311\3\2\2\2\u030f\u030d\3"+
		"\2\2\2\u030f\u0310\3\2\2\2\u0310\u0312\3\2\2\2\u0311\u030f\3\2\2\2\u0312"+
		"\u0313\7\13\2\2\u0313\u0315\3\2\2\2\u0314\u0302\3\2\2\2\u0314\u0307\3"+
		"\2\2\2\u0315\u0083\3\2\2\2\u0316\u0317\5\20\t\2\u0317\u0318\7\13\2\2\u0318"+
		"\u0326\3\2\2\2\u0319\u031a\5\20\t\2\u031a\u031b\7A\2\2\u031b\u0320\5\60"+
		"\31\2\u031c\u031d\7\4\2\2\u031d\u031f\5\60\31\2\u031e\u031c\3\2\2\2\u031f"+
		"\u0322\3\2\2\2\u0320\u031e\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0323\3\2"+
		"\2\2\u0322\u0320\3\2\2\2\u0323\u0324\7\13\2\2\u0324\u0326\3\2\2\2\u0325"+
		"\u0316\3\2\2\2\u0325\u0319\3\2\2\2\u0326\u0085\3\2\2\2\u0327\u0328\5\f"+
		"\7\2\u0328\u0087\3\2\2\2\u0329\u032a\7D\2\2\u032a\u0330\5\u0086D\2\u032b"+
		"\u032f\5\u008aF\2\u032c\u032f\5\u008eH\2\u032d\u032f\5\u0096L\2\u032e"+
		"\u032b\3\2\2\2\u032e\u032c\3\2\2\2\u032e\u032d\3\2\2\2\u032f\u0332\3\2"+
		"\2\2\u0330\u032e\3\2\2\2\u0330\u0331\3\2\2\2\u0331\u0089\3\2\2\2\u0332"+
		"\u0330\3\2\2\2\u0333\u0334\7\63\2\2\u0334\u0336\7(\2\2\u0335\u0337\5\u008c"+
		"G\2\u0336\u0335\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u0336\3\2\2\2\u0338"+
		"\u0339\3\2\2\2\u0339\u008b\3\2\2\2\u033a\u033b\5\16\b\2\u033b\u033c\7"+
		"\24\2\2\u033c\u033d\5\22\n\2\u033d\u008d\3\2\2\2\u033e\u0340\7I\2\2\u033f"+
		"\u0341\5\u0090I\2\u0340\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0340"+
		"\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u008f\3\2\2\2\u0344\u0349\5\16\b\2"+
		"\u0345\u0346\7\4\2\2\u0346\u0348\5\16\b\2\u0347\u0345\3\2\2\2\u0348\u034b"+
		"\3\2\2\2\u0349\u0347\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u034c\3\2\2\2\u034b"+
		"\u0349\3\2\2\2\u034c\u034d\7E\2\2\u034d\u0352\5P)\2\u034e\u034f\7\4\2"+
		"\2\u034f\u0351\5P)\2\u0350\u034e\3\2\2\2\u0351\u0354\3\2\2\2\u0352\u0350"+
		"\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u035e\3\2\2\2\u0354\u0352\3\2\2\2\u0355"+
		"\u0356\7F\2\2\u0356\u035b\5\60\31\2\u0357\u0358\7\4\2\2\u0358\u035a\5"+
		"\60\31\2\u0359\u0357\3\2\2\2\u035a\u035d\3\2\2\2\u035b\u0359\3\2\2\2\u035b"+
		"\u035c\3\2\2\2\u035c\u035f\3\2\2\2\u035d\u035b\3\2\2\2\u035e\u0355\3\2"+
		"\2\2\u035e\u035f\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0361\5\u0092J\2\u0361"+
		"\u0091\3\2\2\2\u0362\u0364\5\u0094K\2\u0363\u0362\3\2\2\2\u0364\u0367"+
		"\3\2\2\2\u0365\u0363\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0093\3\2\2\2\u0367"+
		"\u0365\3\2\2\2\u0368\u0369\5\20\t\2\u0369\u036a\7\24\2\2\u036a\u036b\5"+
		"\22\n\2\u036b\u0095\3\2\2\2\u036c\u036d\7G\2\2\u036d\u036e\7H\2\2\u036e"+
		"\u0370\7\64\2\2\u036f\u0371\5\u0098M\2\u0370\u036f\3\2\2\2\u0371\u0372"+
		"\3\2\2\2\u0372\u0370\3\2\2\2\u0372\u0373\3\2\2\2\u0373\u0097\3\2\2\2\u0374"+
		"\u037e\5r:\2\u0375\u0376\7A\2\2\u0376\u037b\5\60\31\2\u0377\u0378\7\4"+
		"\2\2\u0378\u037a\5\60\31\2\u0379\u0377\3\2\2\2\u037a\u037d\3\2\2\2\u037b"+
		"\u0379\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u037f\3\2\2\2\u037d\u037b\3\2"+
		"\2\2\u037e\u0375\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u0380\3\2\2\2\u0380"+
		"\u0381\7\13\2\2\u0381\u0099\3\2\2\2\u0382\u0386\5\u00aeX\2\u0383\u0386"+
		"\5\u00b0Y\2\u0384\u0386\5\u00b4[\2\u0385\u0382\3\2\2\2\u0385\u0383\3\2"+
		"\2\2\u0385\u0384\3\2\2\2\u0386\u0388\3\2\2\2\u0387\u0389\5\u00a6T\2\u0388"+
		"\u0387\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038b\3\2\2\2\u038a\u038c\5\u00aa"+
		"V\2\u038b\u038a\3\2\2\2\u038b\u038c\3\2\2\2\u038c\u009b\3\2\2\2\u038d"+
		"\u038e\7L\2\2\u038e\u038f\7M\2\2\u038f\u0390\7f\2\2\u0390\u009d\3\2\2"+
		"\2\u0391\u0392\7b\2\2\u0392\u0393\7c\2\2\u0393\u0394\5\4\3\2\u0394\u009f"+
		"\3\2\2\2\u0395\u0398\7N\2\2\u0396\u0399\5\u00a2R\2\u0397\u0399\5\u00a4"+
		"S\2\u0398\u0396\3\2\2\2\u0398\u0397\3\2\2\2\u0399\u039a\3\2\2\2\u039a"+
		"\u0398\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u00a1\3\2\2\2\u039c\u039d\7O"+
		"\2\2\u039d\u039e\7\3\2\2\u039e\u039f\5\20\t\2\u039f\u03a0\7\4\2\2\u03a0"+
		"\u03a1\5\22\n\2\u03a1\u03a2\7\4\2\2\u03a2\u03a3\5\4\3\2\u03a3\u03a4\7"+
		"\5\2\2\u03a4\u03a5\7\13\2\2\u03a5\u00a3\3\2\2\2\u03a6\u03a7\7P\2\2\u03a7"+
		"\u03a8\7\3\2\2\u03a8\u03a9\5\16\b\2\u03a9\u03aa\7\4\2\2\u03aa\u03ab\5"+
		"\4\3\2\u03ab\u03ac\7\5\2\2\u03ac\u03ad\7\13\2\2\u03ad\u00a5\3\2\2\2\u03ae"+
		"\u03af\7Y\2\2\u03af\u03b1\7%\2\2\u03b0\u03b2\5\u00a8U\2\u03b1\u03b0\3"+
		"\2\2\2\u03b2\u03b3\3\2\2\2\u03b3\u03b1\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4"+
		"\u00a7\3\2\2\2\u03b5\u03b6\t\6\2\2\u03b6\u03bb\5\60\31\2\u03b7\u03b8\7"+
		"\4\2\2\u03b8\u03ba\5\60\31\2\u03b9\u03b7\3\2\2\2\u03ba\u03bd\3\2\2\2\u03bb"+
		"\u03b9\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03be\3\2\2\2\u03bd\u03bb\3\2"+
		"\2\2\u03be\u03bf\7\13\2\2\u03bf\u00a9\3\2\2\2\u03c0\u03c1\7X\2\2\u03c1"+
		"\u03c3\t\7\2\2\u03c2\u03c4\5\u00acW\2\u03c3\u03c2\3\2\2\2\u03c4\u03c5"+
		"\3\2\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u00ab\3\2\2\2\u03c7"+
		"\u03c8\t\b\2\2\u03c8\u03c9\5\20\t\2\u03c9\u03ca\7V\2\2\u03ca\u03cf\5\60"+
		"\31\2\u03cb\u03cc\7\4\2\2\u03cc\u03ce\5\60\31\2\u03cd\u03cb\3\2\2\2\u03ce"+
		"\u03d1\3\2\2\2\u03cf\u03cd\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d2\3\2"+
		"\2\2\u03d1\u03cf\3\2\2\2\u03d2\u03d3\7\13\2\2\u03d3\u00ad\3\2\2\2\u03d4"+
		"\u03d5\7J\2\2\u03d5\u03d6\7K\2\2\u03d6\u03d7\5\u009cO\2\u03d7\u03d8\5"+
		"\u00a0Q\2\u03d8\u00af\3\2\2\2\u03d9\u03da\7Q\2\2\u03da\u03db\7R\2\2\u03db"+
		"\u03dd\5\u009cO\2\u03dc\u03de\5\u009eP\2\u03dd\u03dc\3\2\2\2\u03dd\u03de"+
		"\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e0\5\u00a0Q\2\u03e0\u03e1\5\u00b2"+
		"Z\2\u03e1\u00b1\3\2\2\2\u03e2\u03e3\7T\2\2\u03e3\u03e4\7\24\2\2\u03e4"+
		"\u03e5\7\17\2\2\u03e5\u03ea\5\60\31\2\u03e6\u03e7\7\4\2\2\u03e7\u03e9"+
		"\5\60\31\2\u03e8\u03e6\3\2\2\2\u03e9\u03ec\3\2\2\2\u03ea\u03e8\3\2\2\2"+
		"\u03ea\u03eb\3\2\2\2\u03eb\u03ed\3\2\2\2\u03ec\u03ea\3\2\2\2\u03ed\u03ee"+
		"\7\20\2\2\u03ee\u00b3\3\2\2\2\u03ef\u03f0\7S\2\2\u03f0\u03f1\7R\2\2\u03f1"+
		"\u03f3\5\u009cO\2\u03f2\u03f4\5\u009eP\2\u03f3\u03f2\3\2\2\2\u03f3\u03f4"+
		"\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f7\5\u00a0Q\2\u03f6\u03f8\5\u00b6"+
		"\\\2\u03f7\u03f6\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9"+
		"\u03fa\5\u00ba^\2\u03fa\u00b5\3\2\2\2\u03fb\u03fc\7W\2\2\u03fc\u03fe\7"+
		">\2\2\u03fd\u03ff\5\u00b8]\2\u03fe\u03fd\3\2\2\2\u03ff\u0400\3\2\2\2\u0400"+
		"\u03fe\3\2\2\2\u0400\u0401\3\2\2\2\u0401\u00b7\3\2\2\2\u0402\u0403\5\n"+
		"\6\2\u0403\u0404\7\16\2\2\u0404\u040e\5\60\31\2\u0405\u0406\7V\2\2\u0406"+
		"\u040b\5\60\31\2\u0407\u0408\7\4\2\2\u0408\u040a\5\60\31\2\u0409\u0407"+
		"\3\2\2\2\u040a\u040d\3\2\2\2\u040b\u0409\3\2\2\2\u040b\u040c\3\2\2\2\u040c"+
		"\u040f\3\2\2\2\u040d\u040b\3\2\2\2\u040e\u0405\3\2\2\2\u040e\u040f\3\2"+
		"\2\2\u040f\u0410\3\2\2\2\u0410\u0411\7\13\2\2\u0411\u00b9\3\2\2\2\u0412"+
		"\u0413\7U\2\2\u0413\u0414\7\24\2\2\u0414\u0415\7\17\2\2\u0415\u041a\5"+
		"\60\31\2\u0416\u0417\7\4\2\2\u0417\u0419\5\60\31\2\u0418\u0416\3\2\2\2"+
		"\u0419\u041c\3\2\2\2\u041a\u0418\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041d"+
		"\3\2\2\2\u041c\u041a\3\2\2\2\u041d\u041e\7\20\2\2\u041e\u041f\7\13\2\2"+
		"\u041f\u00bb\3\2\2\2f\u0112\u0116\u011f\u0124\u0127\u0131\u0135\u0140"+
		"\u0142\u014b\u0156\u0158\u016b\u01ab\u01b4\u01b9\u01be\u01cc\u01ce\u01dd"+
		"\u01e4\u01ee\u01f3\u01f6\u01f9\u01fc\u01ff\u0202\u020b\u0211\u021c\u0222"+
		"\u0226\u022d\u0234\u023d\u0241\u0247\u0250\u0255\u025e\u0265\u026e\u0272"+
		"\u0279\u027c\u0280\u0283\u0287\u028a\u0290\u0296\u0299\u02a2\u02a7\u02b0"+
		"\u02b8\u02bf\u02c1\u02c9\u02d1\u02d9\u02e1\u02ed\u02f9\u02fd\u0307\u030f"+
		"\u0314\u0320\u0325\u032e\u0330\u0338\u0342\u0349\u0352\u035b\u035e\u0365"+
		"\u0372\u037b\u037e\u0385\u0388\u038b\u0398\u039a\u03b3\u03bb\u03c5\u03cf"+
		"\u03dd\u03ea\u03f3\u03f7\u0400\u040b\u040e\u041a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}