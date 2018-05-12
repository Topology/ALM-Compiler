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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ALMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WhiteSpace=17, 
		MOD=18, EQ=19, NEQ=20, ARITH_OP=21, COMP_REL=22, RIGHT_ARROW=23, OCCURS=24, 
		INSTANCE=25, IS_A=26, HAS_CHILD=27, HAS_PARENT=28, LINK=29, SOURCE=30, 
		SINK=31, SUBSORT=32, DOM=33, SORT=34, STATE=35, CONSTRAINTS=36, FUNCTION=37, 
		DECLARATIONS=38, DEFINITIONS=39, SYSTEM=40, DESCRIPTION=41, THEORY=42, 
		MODULE=43, IMPORT=44, FROM=45, DEPENDS=46, ON=47, ATTRIBUTES=48, OBJECT=49, 
		CONSTANT=50, STATICS=51, FLUENTS=52, BASIC=53, DEFINED=54, TOTAL=55, AXIOMS=56, 
		DYNAMIC=57, CAUSAL=58, LAWS=59, EXECUTABILITY=60, CONDITIONS=61, CAUSES=62, 
		IMPOSSIBLE=63, IF=64, FALSE=65, TRUE=66, STRUCTURE=67, IN=68, WHERE=69, 
		VALUE=70, OF=71, INSTANCES=72, TEMPORAL=73, PROJECTION=74, MAX=75, STEPS=76, 
		HISTORY=77, OBSERVED=78, HAPPENED=79, PLANNING=80, PROBLEM=81, DIAGNOSTIC=82, 
		GOAL=83, SITUATION=84, WHEN=85, NORMAL=86, ACTION=87, ADDITIONAL=88, RESTRICTIONS=89, 
		PERMISSIONS=90, POSSIBLE=91, AVOID=92, BOOLEAN=93, INTEGERS=94, UNIVERSE=95, 
		ACTIONS=96, ID=97, VAR=98, POSINT=99, NEGINT=100, ZERO=101;
	public static final int
		RULE_id = 0, RULE_bool = 1, RULE_nat_num = 2, RULE_integer = 3, RULE_relation = 4, 
		RULE_alm_name = 5, RULE_object_constant = 6, RULE_function_term = 7, RULE_term = 8, 
		RULE_var_or_obj = 9, RULE_expression = 10, RULE_arithmetic_term = 11, 
		RULE_factor = 12, RULE_occurs_atom = 13, RULE_instance_atom = 14, RULE_is_a_atom = 15, 
		RULE_link_atom = 16, RULE_subsort_atom = 17, RULE_has_child_atom = 18, 
		RULE_has_parent_atom = 19, RULE_sink_atom = 20, RULE_source_atom = 21, 
		RULE_atom = 22, RULE_literal = 23, RULE_occurs_literal = 24, RULE_library_name = 25, 
		RULE_sys_desc_name = 26, RULE_system_description = 27, RULE_theory_name = 28, 
		RULE_theory = 29, RULE_module_name = 30, RULE_sequence_of_modules = 31, 
		RULE_module = 32, RULE_module_body = 33, RULE_module_dependencies = 34, 
		RULE_one_dependency = 35, RULE_integer_range = 36, RULE_predefined_sorts = 37, 
		RULE_sort_name = 38, RULE_sort_declarations = 39, RULE_one_sort_decl = 40, 
		RULE_attributes = 41, RULE_one_attribute_decl = 42, RULE_constant_declarations = 43, 
		RULE_one_constant_decl = 44, RULE_function_name = 45, RULE_function_declarations = 46, 
		RULE_static_declarations = 47, RULE_fluent_declarations = 48, RULE_basic_function_declarations = 49, 
		RULE_defined_function_declarations = 50, RULE_one_function_decl = 51, 
		RULE_pos_fun_def = 52, RULE_neg_fun_def = 53, RULE_fun_def = 54, RULE_axioms = 55, 
		RULE_dynamic_causal_laws = 56, RULE_executability_conditions = 57, RULE_state_constraints = 58, 
		RULE_definitions = 59, RULE_one_dynamic_causal_law = 60, RULE_one_executability_condition = 61, 
		RULE_one_state_constraint = 62, RULE_one_definition = 63, RULE_structure_name = 64, 
		RULE_structure = 65, RULE_constant_defs = 66, RULE_one_constant_def = 67, 
		RULE_instance_defs = 68, RULE_one_instance_def = 69, RULE_attribute_defs = 70, 
		RULE_one_attribute_def = 71, RULE_statics_defs = 72, RULE_one_static_def = 73, 
		RULE_solver_mode = 74, RULE_max_steps = 75, RULE_history = 76, RULE_observed = 77, 
		RULE_happened = 78, RULE_added_constraints = 79, RULE_one_added_constraint = 80, 
		RULE_action_conditions = 81, RULE_one_action_condition = 82, RULE_temporal_projection = 83, 
		RULE_planning_problem = 84, RULE_goal_state = 85, RULE_diagnostic_problem = 86, 
		RULE_normal_conditions = 87, RULE_one_normal_condition = 88, RULE_current_state = 89;
	public static final String[] ruleNames = {
		"id", "bool", "nat_num", "integer", "relation", "alm_name", "object_constant", 
		"function_term", "term", "var_or_obj", "expression", "arithmetic_term", 
		"factor", "occurs_atom", "instance_atom", "is_a_atom", "link_atom", "subsort_atom", 
		"has_child_atom", "has_parent_atom", "sink_atom", "source_atom", "atom", 
		"literal", "occurs_literal", "library_name", "sys_desc_name", "system_description", 
		"theory_name", "theory", "module_name", "sequence_of_modules", "module", 
		"module_body", "module_dependencies", "one_dependency", "integer_range", 
		"predefined_sorts", "sort_name", "sort_declarations", "one_sort_decl", 
		"attributes", "one_attribute_decl", "constant_declarations", "one_constant_decl", 
		"function_name", "function_declarations", "static_declarations", "fluent_declarations", 
		"basic_function_declarations", "defined_function_declarations", "one_function_decl", 
		"pos_fun_def", "neg_fun_def", "fun_def", "axioms", "dynamic_causal_laws", 
		"executability_conditions", "state_constraints", "definitions", "one_dynamic_causal_law", 
		"one_executability_condition", "one_state_constraint", "one_definition", 
		"structure_name", "structure", "constant_defs", "one_constant_def", "instance_defs", 
		"one_instance_def", "attribute_defs", "one_attribute_def", "statics_defs", 
		"one_static_def", "solver_mode", "max_steps", "history", "observed", "happened", 
		"added_constraints", "one_added_constraint", "action_conditions", "one_action_condition", 
		"temporal_projection", "planning_problem", "goal_state", "diagnostic_problem", 
		"normal_conditions", "one_normal_condition", "current_state"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'+'", "'-'", "'*'", "'/'", "'^'", "'.'", "'['", 
		"'..'", "']'", "'::'", "':'", "'{'", "'}'", null, "'mod'", "'='", "'!='", 
		null, null, "'->'", "'occurs'", "'instance'", "'is_a'", "'has_child'", 
		"'has_parent'", "'link'", "'source'", "'sink'", "'subsort'", "'DOM'", 
		"'sort'", "'state'", "'constraints'", "'function'", "'declarations'", 
		"'definitions'", "'system'", "'description'", "'theory'", "'module'", 
		"'import'", "'from'", "'depends'", "'on'", "'attributes'", "'object'", 
		"'constant'", "'statics'", "'fluents'", "'basic'", "'defined'", "'total'", 
		"'axioms'", "'dynamic'", "'causal'", "'laws'", "'executability'", "'conditions'", 
		"'causes'", "'impossible'", "'if'", "'false'", "'true'", "'structure'", 
		"'in'", "'where'", "'value'", "'of'", "'instances'", "'temporal'", "'projection'", 
		"'max'", "'steps'", "'history'", "'observed'", "'happened'", "'planning'", 
		"'problem'", "'diagnostic'", "'goal'", "'situation'", "'when'", "'normal'", 
		"'action'", "'additional'", "'restrictions'", "'permissions'", "'possible'", 
		"'avoid'", "'booleans'", "'integers'", "'universe'", "'actions'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "WhiteSpace", "MOD", "EQ", "NEQ", "ARITH_OP", 
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
		"POSSIBLE", "AVOID", "BOOLEAN", "INTEGERS", "UNIVERSE", "ACTIONS", "ID", 
		"VAR", "POSINT", "NEGINT", "ZERO"
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
	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
		public TerminalNode MOD() { return getToken(ALMParser.MOD, 0); }
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
		public TerminalNode BOOLEAN() { return getToken(ALMParser.BOOLEAN, 0); }
		public TerminalNode INTEGERS() { return getToken(ALMParser.INTEGERS, 0); }
		public TerminalNode UNIVERSE() { return getToken(ALMParser.UNIVERSE, 0); }
		public TerminalNode ACTIONS() { return getToken(ALMParser.ACTIONS, 0); }
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
		enterRule(_localctx, 0, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << OCCURS) | (1L << INSTANCE) | (1L << IS_A) | (1L << HAS_CHILD) | (1L << HAS_PARENT) | (1L << LINK) | (1L << SOURCE) | (1L << SINK) | (1L << SUBSORT) | (1L << DOM) | (1L << SORT) | (1L << STATE) | (1L << CONSTRAINTS) | (1L << FUNCTION) | (1L << DECLARATIONS) | (1L << DEFINITIONS) | (1L << SYSTEM) | (1L << DESCRIPTION) | (1L << THEORY) | (1L << MODULE) | (1L << IMPORT) | (1L << FROM) | (1L << DEPENDS) | (1L << ON) | (1L << ATTRIBUTES) | (1L << OBJECT) | (1L << CONSTANT) | (1L << STATICS) | (1L << FLUENTS) | (1L << BASIC) | (1L << DEFINED) | (1L << TOTAL) | (1L << AXIOMS) | (1L << DYNAMIC) | (1L << CAUSAL) | (1L << LAWS) | (1L << EXECUTABILITY) | (1L << CONDITIONS) | (1L << CAUSES) | (1L << IMPOSSIBLE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IF - 64)) | (1L << (FALSE - 64)) | (1L << (TRUE - 64)) | (1L << (STRUCTURE - 64)) | (1L << (IN - 64)) | (1L << (WHERE - 64)) | (1L << (VALUE - 64)) | (1L << (OF - 64)) | (1L << (INSTANCES - 64)) | (1L << (TEMPORAL - 64)) | (1L << (PROJECTION - 64)) | (1L << (MAX - 64)) | (1L << (STEPS - 64)) | (1L << (HISTORY - 64)) | (1L << (OBSERVED - 64)) | (1L << (HAPPENED - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INTEGERS - 64)) | (1L << (UNIVERSE - 64)) | (1L << (ACTIONS - 64)) | (1L << (ID - 64)))) != 0)) ) {
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
		enterRule(_localctx, 2, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		enterRule(_localctx, 4, RULE_nat_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
		enterRule(_localctx, 6, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_la = _input.LA(1);
			if ( !(((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (POSINT - 99)) | (1L << (NEGINT - 99)) | (1L << (ZERO - 99)))) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
			setState(192);
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
			case BOOLEAN:
			case INTEGERS:
			case UNIVERSE:
			case ACTIONS:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				id();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
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
			setState(194);
			id();
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(195);
				match(T__0);
				setState(196);
				term();
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(197);
					match(T__1);
					setState(198);
					term();
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204);
				match(T__2);
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
			setState(208);
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
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				bool();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				id();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(213);
				integer();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(214);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(215);
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
			setState(220);
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
			case BOOLEAN:
			case INTEGERS:
			case UNIVERSE:
			case ACTIONS:
			case ID:
				{
				setState(218);
				object_constant();
				}
				break;
			case VAR:
				{
				setState(219);
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
			setState(223);
			arithmetic_term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(231);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(226);
						match(T__3);
						setState(227);
						arithmetic_term(0);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(229);
						match(T__4);
						setState(230);
						arithmetic_term(0);
						}
						break;
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(237);
				factor();
				setState(238);
				match(T__7);
				setState(239);
				factor();
				}
				break;
			case 2:
				{
				setState(241);
				factor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(253);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(244);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(245);
						match(T__5);
						setState(246);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(247);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(248);
						match(T__6);
						setState(249);
						factor();
						}
						break;
					case 3:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(250);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(251);
						match(MOD);
						setState(252);
						factor();
						}
						break;
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(T__4);
				setState(260);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				integer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				function_term();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				match(T__4);
				setState(264);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(265);
				match(T__0);
				setState(266);
				expression(0);
				setState(267);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(269);
				match(T__4);
				setState(270);
				match(T__0);
				setState(271);
				expression(0);
				setState(272);
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
			setState(276);
			match(OCCURS);
			setState(277);
			match(T__0);
			setState(278);
			var_or_obj();
			setState(279);
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
			setState(281);
			match(INSTANCE);
			setState(282);
			match(T__0);
			setState(283);
			var_or_obj();
			setState(284);
			match(T__1);
			setState(285);
			sort_name();
			setState(286);
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
			setState(288);
			match(IS_A);
			setState(289);
			match(T__0);
			setState(290);
			var_or_obj();
			setState(291);
			match(T__1);
			setState(292);
			sort_name();
			setState(293);
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
			setState(295);
			match(LINK);
			setState(296);
			match(T__0);
			setState(297);
			sort_name();
			setState(298);
			match(T__1);
			setState(299);
			sort_name();
			setState(300);
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
			setState(302);
			match(SUBSORT);
			setState(303);
			match(T__0);
			setState(304);
			sort_name();
			setState(305);
			match(T__1);
			setState(306);
			sort_name();
			setState(307);
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
			setState(309);
			match(HAS_CHILD);
			setState(310);
			match(T__0);
			setState(311);
			sort_name();
			setState(312);
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
			setState(314);
			match(HAS_PARENT);
			setState(315);
			match(T__0);
			setState(316);
			sort_name();
			setState(317);
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
			setState(319);
			match(SINK);
			setState(320);
			match(T__0);
			setState(321);
			sort_name();
			setState(322);
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
			setState(324);
			match(SOURCE);
			setState(325);
			match(T__0);
			setState(326);
			sort_name();
			setState(327);
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
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				instance_atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(330);
				is_a_atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(331);
				link_atom();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(332);
				subsort_atom();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(333);
				has_child_atom();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(334);
				has_parent_atom();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(335);
				sink_atom();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(336);
				source_atom();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(337);
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
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				match(T__4);
				setState(342);
				atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				term();
				setState(344);
				relation();
				setState(345);
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
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OCCURS:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				occurs_atom();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				match(T__4);
				setState(351);
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
		enterRule(_localctx, 50, RULE_library_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
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
		enterRule(_localctx, 52, RULE_sys_desc_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
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
		enterRule(_localctx, 54, RULE_system_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(SYSTEM);
			setState(359);
			match(DESCRIPTION);
			setState(360);
			sys_desc_name();
			setState(361);
			theory();
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRUCTURE) {
				{
				setState(362);
				structure();
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (TEMPORAL - 73)) | (1L << (PLANNING - 73)) | (1L << (DIAGNOSTIC - 73)))) != 0)) {
					{
					setState(363);
					solver_mode();
					}
				}

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
		enterRule(_localctx, 56, RULE_theory_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
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
		enterRule(_localctx, 58, RULE_theory);
		try {
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THEORY:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(370);
				match(THEORY);
				setState(371);
				theory_name();
				setState(372);
				sequence_of_modules();
				}
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(374);
				match(IMPORT);
				setState(375);
				theory_name();
				setState(376);
				match(FROM);
				setState(377);
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
		enterRule(_localctx, 60, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
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
		enterRule(_localctx, 62, RULE_sequence_of_modules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(383);
				module();
				}
				}
				setState(386); 
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
		enterRule(_localctx, 64, RULE_module);
		int _la;
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(388);
				match(MODULE);
				setState(389);
				module_name();
				setState(390);
				module_body();
				}
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(392);
				match(IMPORT);
				setState(393);
				theory_name();
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(394);
					match(T__8);
					setState(395);
					module_name();
					}
				}

				setState(398);
				match(FROM);
				setState(399);
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
		enterRule(_localctx, 66, RULE_module_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEPENDS) {
				{
				setState(403);
				module_dependencies();
				}
			}

			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORT) {
				{
				setState(406);
				sort_declarations();
				}
			}

			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(409);
				constant_declarations();
				}
			}

			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNCTION) {
				{
				setState(412);
				function_declarations();
				}
			}

			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AXIOMS) {
				{
				setState(415);
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
		enterRule(_localctx, 68, RULE_module_dependencies);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(DEPENDS);
			setState(419);
			match(ON);
			setState(421); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(420);
					one_dependency();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(423); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 70, RULE_one_dependency);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(425);
				theory_name();
				setState(426);
				match(T__8);
				}
				break;
			}
			setState(430);
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
		enterRule(_localctx, 72, RULE_integer_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(T__9);
			setState(433);
			integer();
			setState(434);
			match(T__10);
			setState(435);
			integer();
			setState(436);
			match(T__11);
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
		public TerminalNode BOOLEAN() { return getToken(ALMParser.BOOLEAN, 0); }
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
		enterRule(_localctx, 74, RULE_predefined_sorts);
		try {
			setState(441);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				match(BOOLEAN);
				}
				break;
			case INTEGERS:
				enterOuterAlt(_localctx, 2);
				{
				setState(439);
				match(INTEGERS);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(440);
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
		enterRule(_localctx, 76, RULE_sort_name);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				predefined_sorts();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(444);
				match(UNIVERSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(445);
				match(ACTIONS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(446);
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
		enterRule(_localctx, 78, RULE_sort_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(SORT);
			setState(450);
			match(DECLARATIONS);
			setState(452); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(451);
					one_sort_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(454); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
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
		enterRule(_localctx, 80, RULE_one_sort_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			id();
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(457);
				match(T__1);
				setState(458);
				id();
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(464);
			match(T__12);
			setState(465);
			sort_name();
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(466);
				match(T__1);
				setState(467);
				sort_name();
				}
				}
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(473);
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
		enterRule(_localctx, 82, RULE_attributes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(ATTRIBUTES);
			setState(478); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(477);
					one_attribute_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(480); 
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
		enterRule(_localctx, 84, RULE_one_attribute_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			id();
			setState(483);
			match(T__13);
			setState(494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(484);
				sort_name();
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(485);
					match(T__1);
					setState(486);
					sort_name();
					}
					}
					setState(491);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(492);
				match(RIGHT_ARROW);
				}
				break;
			}
			setState(496);
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
		enterRule(_localctx, 86, RULE_constant_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(CONSTANT);
			setState(499);
			match(DECLARATIONS);
			setState(501); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(500);
					one_constant_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(503); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 88, RULE_one_constant_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			object_constant();
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(506);
				match(T__1);
				setState(507);
				object_constant();
				}
				}
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(513);
			match(T__13);
			setState(514);
			sort_name();
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(515);
				match(T__1);
				setState(516);
				sort_name();
				}
				}
				setState(521);
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

	public static class Function_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
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
		enterRule(_localctx, 90, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			match(ID);
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
		enterRule(_localctx, 92, RULE_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(FUNCTION);
			setState(525);
			match(DECLARATIONS);
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATICS) {
				{
				setState(526);
				static_declarations();
				}
			}

			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLUENTS) {
				{
				setState(529);
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
		enterRule(_localctx, 94, RULE_static_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(STATICS);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BASIC) {
				{
				setState(533);
				basic_function_declarations();
				}
			}

			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINED) {
				{
				setState(536);
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
		enterRule(_localctx, 96, RULE_fluent_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			match(FLUENTS);
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BASIC) {
				{
				setState(540);
				basic_function_declarations();
				}
			}

			setState(544);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINED) {
				{
				setState(543);
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
		enterRule(_localctx, 98, RULE_basic_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(BASIC);
			setState(548); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(547);
				one_function_decl();
				}
				}
				setState(550); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOTAL || _la==ID );
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
		enterRule(_localctx, 100, RULE_defined_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			match(DEFINED);
			setState(554); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(553);
				one_function_decl();
				}
				}
				setState(556); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOTAL || _la==ID );
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
		enterRule(_localctx, 102, RULE_one_function_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TOTAL) {
				{
				setState(558);
				match(TOTAL);
				}
			}

			setState(561);
			function_name();
			setState(562);
			match(T__13);
			setState(563);
			sort_name();
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==RIGHT_ARROW) {
				{
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(564);
					match(T__5);
					setState(565);
					sort_name();
					}
					}
					setState(570);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(571);
				match(RIGHT_ARROW);
				setState(572);
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
		enterRule(_localctx, 104, RULE_pos_fun_def);
		try {
			setState(582);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				function_term();
				setState(576);
				match(EQ);
				setState(577);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				function_term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(580);
				match(T__4);
				setState(581);
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
		enterRule(_localctx, 106, RULE_neg_fun_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			function_term();
			setState(585);
			match(NEQ);
			setState(586);
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
		enterRule(_localctx, 108, RULE_fun_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(588);
				pos_fun_def();
				}
				break;
			case 2:
				{
				setState(589);
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
		public List<DefinitionsContext> definitions() {
			return getRuleContexts(DefinitionsContext.class);
		}
		public DefinitionsContext definitions(int i) {
			return getRuleContext(DefinitionsContext.class,i);
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
		enterRule(_localctx, 110, RULE_axioms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			match(AXIOMS);
			setState(599);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STATE) | (1L << FUNCTION) | (1L << DYNAMIC) | (1L << EXECUTABILITY))) != 0)) {
				{
				setState(597);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DYNAMIC:
					{
					setState(593);
					dynamic_causal_laws();
					}
					break;
				case EXECUTABILITY:
					{
					setState(594);
					executability_conditions();
					}
					break;
				case STATE:
					{
					setState(595);
					state_constraints();
					}
					break;
				case FUNCTION:
					{
					setState(596);
					definitions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(601);
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
		enterRule(_localctx, 112, RULE_dynamic_causal_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			match(DYNAMIC);
			setState(603);
			match(CAUSAL);
			setState(604);
			match(LAWS);
			setState(606); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(605);
				one_dynamic_causal_law();
				}
				}
				setState(608); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OCCURS );
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
		enterRule(_localctx, 114, RULE_executability_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			match(EXECUTABILITY);
			setState(611);
			match(CONDITIONS);
			setState(613); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(612);
				one_executability_condition();
				}
				}
				setState(615); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPOSSIBLE );
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
		enterRule(_localctx, 116, RULE_state_constraints);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(STATE);
			setState(618);
			match(CONSTRAINTS);
			setState(620); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(619);
					one_state_constraint();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(622); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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

	public static class DefinitionsContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(ALMParser.FUNCTION, 0); }
		public TerminalNode DEFINITIONS() { return getToken(ALMParser.DEFINITIONS, 0); }
		public List<One_definitionContext> one_definition() {
			return getRuleContexts(One_definitionContext.class);
		}
		public One_definitionContext one_definition(int i) {
			return getRuleContext(One_definitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).enterDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALMListener ) ((ALMListener)listener).exitDefinitions(this);
		}
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(FUNCTION);
			setState(625);
			match(DEFINITIONS);
			setState(627); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(626);
					one_definition();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(629); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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
		enterRule(_localctx, 120, RULE_one_dynamic_causal_law);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			occurs_atom();
			setState(632);
			match(CAUSES);
			setState(633);
			pos_fun_def();
			setState(634);
			match(IF);
			setState(635);
			instance_atom();
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(636);
				match(T__1);
				setState(637);
				literal();
				}
				}
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(643);
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
		enterRule(_localctx, 122, RULE_one_executability_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			match(IMPOSSIBLE);
			setState(646);
			occurs_atom();
			setState(647);
			match(IF);
			setState(648);
			instance_atom();
			setState(656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(649);
				match(T__1);
				setState(652);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(650);
					occurs_literal();
					}
					break;
				case 2:
					{
					setState(651);
					literal();
					}
					break;
				}
				}
				}
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(659);
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
		enterRule(_localctx, 124, RULE_one_state_constraint);
		int _la;
		try {
			setState(679);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(661);
				fun_def();
				setState(662);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(666);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(664);
					match(FALSE);
					}
					break;
				case 2:
					{
					setState(665);
					fun_def();
					}
					break;
				}
				setState(668);
				match(IF);
				setState(669);
				literal();
				setState(674);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(670);
					match(T__1);
					setState(671);
					literal();
					}
					}
					setState(676);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(677);
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
		enterRule(_localctx, 126, RULE_one_definition);
		int _la;
		try {
			setState(696);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(681);
				function_term();
				setState(682);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(684);
				function_term();
				setState(685);
				match(IF);
				setState(686);
				literal();
				setState(691);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(687);
					match(T__1);
					setState(688);
					literal();
					}
					}
					setState(693);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(694);
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
		enterRule(_localctx, 128, RULE_structure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
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
		enterRule(_localctx, 130, RULE_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			match(STRUCTURE);
			setState(701);
			structure_name();
			setState(707);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 50)) & ~0x3f) == 0 && ((1L << (_la - 50)) & ((1L << (CONSTANT - 50)) | (1L << (VALUE - 50)) | (1L << (INSTANCES - 50)))) != 0)) {
				{
				setState(705);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONSTANT:
					{
					setState(702);
					constant_defs();
					}
					break;
				case INSTANCES:
					{
					setState(703);
					instance_defs();
					}
					break;
				case VALUE:
					{
					setState(704);
					statics_defs();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(709);
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
		enterRule(_localctx, 132, RULE_constant_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			match(CONSTANT);
			setState(711);
			match(DEFINITIONS);
			setState(713); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(712);
					one_constant_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(715); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
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
		enterRule(_localctx, 134, RULE_one_constant_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			object_constant();
			setState(718);
			match(EQ);
			setState(719);
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
		enterRule(_localctx, 136, RULE_instance_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			match(INSTANCES);
			setState(723); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(722);
					one_instance_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(725); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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
		enterRule(_localctx, 138, RULE_one_instance_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(727);
			object_constant();
			setState(732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(728);
				match(T__1);
				setState(729);
				object_constant();
				}
				}
				setState(734);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(735);
			match(IN);
			setState(736);
			sort_name();
			setState(741);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(737);
				match(T__1);
				setState(738);
				sort_name();
				}
				}
				setState(743);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(753);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(744);
				match(WHERE);
				setState(745);
				literal();
				setState(750);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(746);
					match(T__1);
					setState(747);
					literal();
					}
					}
					setState(752);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(755);
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
		enterRule(_localctx, 140, RULE_attribute_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(757);
					one_attribute_def();
					}
					} 
				}
				setState(762);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
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
		enterRule(_localctx, 142, RULE_one_attribute_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(763);
			function_term();
			setState(764);
			match(EQ);
			setState(765);
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
		enterRule(_localctx, 144, RULE_statics_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(VALUE);
			setState(768);
			match(OF);
			setState(769);
			match(STATICS);
			setState(771); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(770);
					one_static_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(773); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
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
		enterRule(_localctx, 146, RULE_one_static_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			fun_def();
			setState(785);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(776);
				match(IF);
				setState(777);
				literal();
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(778);
					match(T__1);
					setState(779);
					literal();
					}
					}
					setState(784);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(787);
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
		enterRule(_localctx, 148, RULE_solver_mode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPORAL:
				{
				setState(789);
				temporal_projection();
				}
				break;
			case PLANNING:
				{
				setState(790);
				planning_problem();
				}
				break;
			case DIAGNOSTIC:
				{
				setState(791);
				diagnostic_problem();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(795);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADDITIONAL) {
				{
				setState(794);
				added_constraints();
				}
			}

			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACTION) {
				{
				setState(797);
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
		enterRule(_localctx, 150, RULE_max_steps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			match(MAX);
			setState(801);
			match(STEPS);
			setState(802);
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
		enterRule(_localctx, 152, RULE_history);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			match(HISTORY);
			setState(807); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(807);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OBSERVED:
					{
					setState(805);
					observed();
					}
					break;
				case HAPPENED:
					{
					setState(806);
					happened();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(809); 
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
		enterRule(_localctx, 154, RULE_observed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			match(OBSERVED);
			setState(812);
			match(T__0);
			setState(813);
			function_term();
			setState(814);
			match(T__1);
			setState(815);
			term();
			setState(816);
			match(T__1);
			setState(817);
			nat_num();
			setState(818);
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
		enterRule(_localctx, 156, RULE_happened);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
			match(HAPPENED);
			setState(821);
			match(T__0);
			setState(822);
			object_constant();
			setState(823);
			match(T__1);
			setState(824);
			nat_num();
			setState(825);
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
		enterRule(_localctx, 158, RULE_added_constraints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			match(ADDITIONAL);
			setState(828);
			match(CONSTRAINTS);
			setState(830); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(829);
				one_added_constraint();
				}
				}
				setState(832); 
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
		enterRule(_localctx, 160, RULE_one_added_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834);
			_la = _input.LA(1);
			if ( !(_la==IMPOSSIBLE || _la==AVOID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(835);
			literal();
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(836);
				match(T__1);
				setState(837);
				literal();
				}
				}
				setState(842);
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
		enterRule(_localctx, 162, RULE_action_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			match(ACTION);
			setState(844);
			_la = _input.LA(1);
			if ( !(_la==RESTRICTIONS || _la==PERMISSIONS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(846); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(845);
				one_action_condition();
				}
				}
				setState(848); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (IMPOSSIBLE - 63)) | (1L << (POSSIBLE - 63)) | (1L << (AVOID - 63)))) != 0) );
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
		enterRule(_localctx, 164, RULE_one_action_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850);
			_la = _input.LA(1);
			if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (IMPOSSIBLE - 63)) | (1L << (POSSIBLE - 63)) | (1L << (AVOID - 63)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(851);
			function_term();
			setState(852);
			match(WHEN);
			setState(853);
			literal();
			setState(858);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(854);
				match(T__1);
				setState(855);
				literal();
				}
				}
				setState(860);
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
		enterRule(_localctx, 166, RULE_temporal_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			match(TEMPORAL);
			setState(862);
			match(PROJECTION);
			setState(863);
			max_steps();
			setState(864);
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
		enterRule(_localctx, 168, RULE_planning_problem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			match(PLANNING);
			setState(867);
			match(PROBLEM);
			setState(868);
			max_steps();
			setState(869);
			history();
			setState(870);
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
		enterRule(_localctx, 170, RULE_goal_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			match(GOAL);
			setState(873);
			match(EQ);
			setState(874);
			match(T__14);
			setState(875);
			literal();
			setState(880);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(876);
				match(T__1);
				setState(877);
				literal();
				}
				}
				setState(882);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(883);
			match(T__15);
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
		enterRule(_localctx, 172, RULE_diagnostic_problem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			match(DIAGNOSTIC);
			setState(886);
			match(PROBLEM);
			setState(887);
			max_steps();
			setState(888);
			history();
			setState(890);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NORMAL) {
				{
				setState(889);
				normal_conditions();
				}
			}

			setState(892);
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
		enterRule(_localctx, 174, RULE_normal_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			match(NORMAL);
			setState(895);
			match(CONDITIONS);
			setState(897); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(896);
				one_normal_condition();
				}
				}
				setState(899); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
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
		enterRule(_localctx, 176, RULE_one_normal_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			match(ID);
			setState(902);
			match(T__13);
			setState(903);
			literal();
			setState(913);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(904);
				match(WHEN);
				setState(905);
				literal();
				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(906);
					match(T__1);
					setState(907);
					literal();
					}
					}
					setState(912);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		enterRule(_localctx, 178, RULE_current_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			match(SITUATION);
			setState(916);
			match(EQ);
			setState(917);
			match(T__14);
			setState(918);
			literal();
			setState(923);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(919);
				match(T__1);
				setState(920);
				literal();
				}
				}
				setState(925);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(926);
			match(T__15);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3g\u03a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\5\7\u00c3\n\7\3\b\3\b\3\b\3\b\3\b\7\b\u00ca\n\b\f"+
		"\b\16\b\u00cd\13\b\3\b\3\b\5\b\u00d1\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u00db\n\n\3\13\3\13\5\13\u00df\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u00ea\n\f\f\f\16\f\u00ed\13\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00f5\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0100\n\r\f\r\16\r"+
		"\u0103\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u0115\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0155\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u015e\n\31\3\32\3"+
		"\32\3\32\5\32\u0163\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\5\35\u016f\n\35\5\35\u0171\n\35\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\5\37\u017e\n\37\3 \3 \3!\6!\u0183\n!\r!\16!\u0184"+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u018f\n\"\3\"\3\"\3\"\5\"\u0194\n"+
		"\"\3#\5#\u0197\n#\3#\5#\u019a\n#\3#\5#\u019d\n#\3#\5#\u01a0\n#\3#\5#\u01a3"+
		"\n#\3$\3$\3$\6$\u01a8\n$\r$\16$\u01a9\3%\3%\3%\5%\u01af\n%\3%\3%\3&\3"+
		"&\3&\3&\3&\3&\3\'\3\'\3\'\5\'\u01bc\n\'\3(\3(\3(\3(\5(\u01c2\n(\3)\3)"+
		"\3)\6)\u01c7\n)\r)\16)\u01c8\3*\3*\3*\7*\u01ce\n*\f*\16*\u01d1\13*\3*"+
		"\3*\3*\3*\7*\u01d7\n*\f*\16*\u01da\13*\3*\5*\u01dd\n*\3+\3+\6+\u01e1\n"+
		"+\r+\16+\u01e2\3,\3,\3,\3,\3,\7,\u01ea\n,\f,\16,\u01ed\13,\3,\3,\5,\u01f1"+
		"\n,\3,\3,\3-\3-\3-\6-\u01f8\n-\r-\16-\u01f9\3.\3.\3.\7.\u01ff\n.\f.\16"+
		".\u0202\13.\3.\3.\3.\3.\7.\u0208\n.\f.\16.\u020b\13.\3/\3/\3\60\3\60\3"+
		"\60\5\60\u0212\n\60\3\60\5\60\u0215\n\60\3\61\3\61\5\61\u0219\n\61\3\61"+
		"\5\61\u021c\n\61\3\62\3\62\5\62\u0220\n\62\3\62\5\62\u0223\n\62\3\63\3"+
		"\63\6\63\u0227\n\63\r\63\16\63\u0228\3\64\3\64\6\64\u022d\n\64\r\64\16"+
		"\64\u022e\3\65\5\65\u0232\n\65\3\65\3\65\3\65\3\65\3\65\7\65\u0239\n\65"+
		"\f\65\16\65\u023c\13\65\3\65\3\65\5\65\u0240\n\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\5\66\u0249\n\66\3\67\3\67\3\67\3\67\38\38\58\u0251\n8"+
		"\39\39\39\39\39\79\u0258\n9\f9\169\u025b\139\3:\3:\3:\3:\6:\u0261\n:\r"+
		":\16:\u0262\3;\3;\3;\6;\u0268\n;\r;\16;\u0269\3<\3<\3<\6<\u026f\n<\r<"+
		"\16<\u0270\3=\3=\3=\6=\u0276\n=\r=\16=\u0277\3>\3>\3>\3>\3>\3>\3>\7>\u0281"+
		"\n>\f>\16>\u0284\13>\3>\3>\3?\3?\3?\3?\3?\3?\3?\5?\u028f\n?\7?\u0291\n"+
		"?\f?\16?\u0294\13?\3?\3?\3@\3@\3@\3@\3@\5@\u029d\n@\3@\3@\3@\3@\7@\u02a3"+
		"\n@\f@\16@\u02a6\13@\3@\3@\5@\u02aa\n@\3A\3A\3A\3A\3A\3A\3A\3A\7A\u02b4"+
		"\nA\fA\16A\u02b7\13A\3A\3A\5A\u02bb\nA\3B\3B\3C\3C\3C\3C\3C\7C\u02c4\n"+
		"C\fC\16C\u02c7\13C\3D\3D\3D\6D\u02cc\nD\rD\16D\u02cd\3E\3E\3E\3E\3F\3"+
		"F\6F\u02d6\nF\rF\16F\u02d7\3G\3G\3G\7G\u02dd\nG\fG\16G\u02e0\13G\3G\3"+
		"G\3G\3G\7G\u02e6\nG\fG\16G\u02e9\13G\3G\3G\3G\3G\7G\u02ef\nG\fG\16G\u02f2"+
		"\13G\5G\u02f4\nG\3G\3G\3H\7H\u02f9\nH\fH\16H\u02fc\13H\3I\3I\3I\3I\3J"+
		"\3J\3J\3J\6J\u0306\nJ\rJ\16J\u0307\3K\3K\3K\3K\3K\7K\u030f\nK\fK\16K\u0312"+
		"\13K\5K\u0314\nK\3K\3K\3L\3L\3L\5L\u031b\nL\3L\5L\u031e\nL\3L\5L\u0321"+
		"\nL\3M\3M\3M\3M\3N\3N\3N\6N\u032a\nN\rN\16N\u032b\3O\3O\3O\3O\3O\3O\3"+
		"O\3O\3O\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\6Q\u0341\nQ\rQ\16Q\u0342\3R\3R\3"+
		"R\3R\7R\u0349\nR\fR\16R\u034c\13R\3S\3S\3S\6S\u0351\nS\rS\16S\u0352\3"+
		"T\3T\3T\3T\3T\3T\7T\u035b\nT\fT\16T\u035e\13T\3U\3U\3U\3U\3U\3V\3V\3V"+
		"\3V\3V\3V\3W\3W\3W\3W\3W\3W\7W\u0371\nW\fW\16W\u0374\13W\3W\3W\3X\3X\3"+
		"X\3X\3X\5X\u037d\nX\3X\3X\3Y\3Y\3Y\6Y\u0384\nY\rY\16Y\u0385\3Z\3Z\3Z\3"+
		"Z\3Z\3Z\3Z\7Z\u038f\nZ\fZ\16Z\u0392\13Z\5Z\u0394\nZ\3[\3[\3[\3[\3[\3["+
		"\7[\u039c\n[\f[\16[\u039f\13[\3[\3[\3[\2\4\26\30\\\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp"+
		"rtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\2\n\5\2\24\24\32Q_c\3\2CD\4\2eegg\3\2eg\4\2\25"+
		"\26\30\30\4\2AA^^\3\2[\\\4\2AA]^\2\u03bf\2\u00b6\3\2\2\2\4\u00b8\3\2\2"+
		"\2\6\u00ba\3\2\2\2\b\u00bc\3\2\2\2\n\u00be\3\2\2\2\f\u00c2\3\2\2\2\16"+
		"\u00c4\3\2\2\2\20\u00d2\3\2\2\2\22\u00da\3\2\2\2\24\u00de\3\2\2\2\26\u00e0"+
		"\3\2\2\2\30\u00f4\3\2\2\2\32\u0114\3\2\2\2\34\u0116\3\2\2\2\36\u011b\3"+
		"\2\2\2 \u0122\3\2\2\2\"\u0129\3\2\2\2$\u0130\3\2\2\2&\u0137\3\2\2\2(\u013c"+
		"\3\2\2\2*\u0141\3\2\2\2,\u0146\3\2\2\2.\u0154\3\2\2\2\60\u015d\3\2\2\2"+
		"\62\u0162\3\2\2\2\64\u0164\3\2\2\2\66\u0166\3\2\2\28\u0168\3\2\2\2:\u0172"+
		"\3\2\2\2<\u017d\3\2\2\2>\u017f\3\2\2\2@\u0182\3\2\2\2B\u0193\3\2\2\2D"+
		"\u0196\3\2\2\2F\u01a4\3\2\2\2H\u01ae\3\2\2\2J\u01b2\3\2\2\2L\u01bb\3\2"+
		"\2\2N\u01c1\3\2\2\2P\u01c3\3\2\2\2R\u01ca\3\2\2\2T\u01de\3\2\2\2V\u01e4"+
		"\3\2\2\2X\u01f4\3\2\2\2Z\u01fb\3\2\2\2\\\u020c\3\2\2\2^\u020e\3\2\2\2"+
		"`\u0216\3\2\2\2b\u021d\3\2\2\2d\u0224\3\2\2\2f\u022a\3\2\2\2h\u0231\3"+
		"\2\2\2j\u0248\3\2\2\2l\u024a\3\2\2\2n\u0250\3\2\2\2p\u0252\3\2\2\2r\u025c"+
		"\3\2\2\2t\u0264\3\2\2\2v\u026b\3\2\2\2x\u0272\3\2\2\2z\u0279\3\2\2\2|"+
		"\u0287\3\2\2\2~\u02a9\3\2\2\2\u0080\u02ba\3\2\2\2\u0082\u02bc\3\2\2\2"+
		"\u0084\u02be\3\2\2\2\u0086\u02c8\3\2\2\2\u0088\u02cf\3\2\2\2\u008a\u02d3"+
		"\3\2\2\2\u008c\u02d9\3\2\2\2\u008e\u02fa\3\2\2\2\u0090\u02fd\3\2\2\2\u0092"+
		"\u0301\3\2\2\2\u0094\u0309\3\2\2\2\u0096\u031a\3\2\2\2\u0098\u0322\3\2"+
		"\2\2\u009a\u0326\3\2\2\2\u009c\u032d\3\2\2\2\u009e\u0336\3\2\2\2\u00a0"+
		"\u033d\3\2\2\2\u00a2\u0344\3\2\2\2\u00a4\u034d\3\2\2\2\u00a6\u0354\3\2"+
		"\2\2\u00a8\u035f\3\2\2\2\u00aa\u0364\3\2\2\2\u00ac\u036a\3\2\2\2\u00ae"+
		"\u0377\3\2\2\2\u00b0\u0380\3\2\2\2\u00b2\u0387\3\2\2\2\u00b4\u0395\3\2"+
		"\2\2\u00b6\u00b7\t\2\2\2\u00b7\3\3\2\2\2\u00b8\u00b9\t\3\2\2\u00b9\5\3"+
		"\2\2\2\u00ba\u00bb\t\4\2\2\u00bb\7\3\2\2\2\u00bc\u00bd\t\5\2\2\u00bd\t"+
		"\3\2\2\2\u00be\u00bf\t\6\2\2\u00bf\13\3\2\2\2\u00c0\u00c3\5\2\2\2\u00c1"+
		"\u00c3\7d\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\r\3\2\2\2"+
		"\u00c4\u00d0\5\2\2\2\u00c5\u00c6\7\3\2\2\u00c6\u00cb\5\22\n\2\u00c7\u00c8"+
		"\7\4\2\2\u00c8\u00ca\5\22\n\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2"+
		"\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00cf\7\5\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00c5\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\17\3\2\2\2\u00d2\u00d3\5\16\b\2\u00d3\21\3\2\2\2"+
		"\u00d4\u00db\5\4\3\2\u00d5\u00db\7d\2\2\u00d6\u00db\5\2\2\2\u00d7\u00db"+
		"\5\b\5\2\u00d8\u00db\5\20\t\2\u00d9\u00db\5\26\f\2\u00da\u00d4\3\2\2\2"+
		"\u00da\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7\3\2\2\2\u00da\u00d8"+
		"\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\23\3\2\2\2\u00dc\u00df\5\16\b\2\u00dd"+
		"\u00df\7d\2\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\25\3\2\2\2"+
		"\u00e0\u00e1\b\f\1\2\u00e1\u00e2\5\30\r\2\u00e2\u00eb\3\2\2\2\u00e3\u00e4"+
		"\f\5\2\2\u00e4\u00e5\7\6\2\2\u00e5\u00ea\5\30\r\2\u00e6\u00e7\f\4\2\2"+
		"\u00e7\u00e8\7\7\2\2\u00e8\u00ea\5\30\r\2\u00e9\u00e3\3\2\2\2\u00e9\u00e6"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\27\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\b\r\1\2\u00ef\u00f0\5\32\16"+
		"\2\u00f0\u00f1\7\n\2\2\u00f1\u00f2\5\32\16\2\u00f2\u00f5\3\2\2\2\u00f3"+
		"\u00f5\5\32\16\2\u00f4\u00ee\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u0101\3"+
		"\2\2\2\u00f6\u00f7\f\7\2\2\u00f7\u00f8\7\b\2\2\u00f8\u0100\5\32\16\2\u00f9"+
		"\u00fa\f\6\2\2\u00fa\u00fb\7\t\2\2\u00fb\u0100\5\32\16\2\u00fc\u00fd\f"+
		"\5\2\2\u00fd\u00fe\7\24\2\2\u00fe\u0100\5\32\16\2\u00ff\u00f6\3\2\2\2"+
		"\u00ff\u00f9\3\2\2\2\u00ff\u00fc\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102\31\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0115\7d\2\2\u0105\u0106\7\7\2\2\u0106\u0115\7d\2\2\u0107\u0115\5\b\5"+
		"\2\u0108\u0115\5\20\t\2\u0109\u010a\7\7\2\2\u010a\u0115\5\20\t\2\u010b"+
		"\u010c\7\3\2\2\u010c\u010d\5\26\f\2\u010d\u010e\7\5\2\2\u010e\u0115\3"+
		"\2\2\2\u010f\u0110\7\7\2\2\u0110\u0111\7\3\2\2\u0111\u0112\5\26\f\2\u0112"+
		"\u0113\7\5\2\2\u0113\u0115\3\2\2\2\u0114\u0104\3\2\2\2\u0114\u0105\3\2"+
		"\2\2\u0114\u0107\3\2\2\2\u0114\u0108\3\2\2\2\u0114\u0109\3\2\2\2\u0114"+
		"\u010b\3\2\2\2\u0114\u010f\3\2\2\2\u0115\33\3\2\2\2\u0116\u0117\7\32\2"+
		"\2\u0117\u0118\7\3\2\2\u0118\u0119\5\24\13\2\u0119\u011a\7\5\2\2\u011a"+
		"\35\3\2\2\2\u011b\u011c\7\33\2\2\u011c\u011d\7\3\2\2\u011d\u011e\5\24"+
		"\13\2\u011e\u011f\7\4\2\2\u011f\u0120\5N(\2\u0120\u0121\7\5\2\2\u0121"+
		"\37\3\2\2\2\u0122\u0123\7\34\2\2\u0123\u0124\7\3\2\2\u0124\u0125\5\24"+
		"\13\2\u0125\u0126\7\4\2\2\u0126\u0127\5N(\2\u0127\u0128\7\5\2\2\u0128"+
		"!\3\2\2\2\u0129\u012a\7\37\2\2\u012a\u012b\7\3\2\2\u012b\u012c\5N(\2\u012c"+
		"\u012d\7\4\2\2\u012d\u012e\5N(\2\u012e\u012f\7\5\2\2\u012f#\3\2\2\2\u0130"+
		"\u0131\7\"\2\2\u0131\u0132\7\3\2\2\u0132\u0133\5N(\2\u0133\u0134\7\4\2"+
		"\2\u0134\u0135\5N(\2\u0135\u0136\7\5\2\2\u0136%\3\2\2\2\u0137\u0138\7"+
		"\35\2\2\u0138\u0139\7\3\2\2\u0139\u013a\5N(\2\u013a\u013b\7\5\2\2\u013b"+
		"\'\3\2\2\2\u013c\u013d\7\36\2\2\u013d\u013e\7\3\2\2\u013e\u013f\5N(\2"+
		"\u013f\u0140\7\5\2\2\u0140)\3\2\2\2\u0141\u0142\7!\2\2\u0142\u0143\7\3"+
		"\2\2\u0143\u0144\5N(\2\u0144\u0145\7\5\2\2\u0145+\3\2\2\2\u0146\u0147"+
		"\7 \2\2\u0147\u0148\7\3\2\2\u0148\u0149\5N(\2\u0149\u014a\7\5\2\2\u014a"+
		"-\3\2\2\2\u014b\u0155\5\36\20\2\u014c\u0155\5 \21\2\u014d\u0155\5\"\22"+
		"\2\u014e\u0155\5$\23\2\u014f\u0155\5&\24\2\u0150\u0155\5(\25\2\u0151\u0155"+
		"\5*\26\2\u0152\u0155\5,\27\2\u0153\u0155\5\20\t\2\u0154\u014b\3\2\2\2"+
		"\u0154\u014c\3\2\2\2\u0154\u014d\3\2\2\2\u0154\u014e\3\2\2\2\u0154\u014f"+
		"\3\2\2\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0153\3\2\2\2\u0155/\3\2\2\2\u0156\u015e\5.\30\2\u0157\u0158\7\7\2\2"+
		"\u0158\u015e\5.\30\2\u0159\u015a\5\22\n\2\u015a\u015b\5\n\6\2\u015b\u015c"+
		"\5\22\n\2\u015c\u015e\3\2\2\2\u015d\u0156\3\2\2\2\u015d\u0157\3\2\2\2"+
		"\u015d\u0159\3\2\2\2\u015e\61\3\2\2\2\u015f\u0163\5\34\17\2\u0160\u0161"+
		"\7\7\2\2\u0161\u0163\5\34\17\2\u0162\u015f\3\2\2\2\u0162\u0160\3\2\2\2"+
		"\u0163\63\3\2\2\2\u0164\u0165\5\f\7\2\u0165\65\3\2\2\2\u0166\u0167\5\f"+
		"\7\2\u0167\67\3\2\2\2\u0168\u0169\7*\2\2\u0169\u016a\7+\2\2\u016a\u016b"+
		"\5\66\34\2\u016b\u0170\5<\37\2\u016c\u016e\5\u0084C\2\u016d\u016f\5\u0096"+
		"L\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2\2\2\u0170"+
		"\u016c\3\2\2\2\u0170\u0171\3\2\2\2\u01719\3\2\2\2\u0172\u0173\5\f\7\2"+
		"\u0173;\3\2\2\2\u0174\u0175\7,\2\2\u0175\u0176\5:\36\2\u0176\u0177\5@"+
		"!\2\u0177\u017e\3\2\2\2\u0178\u0179\7.\2\2\u0179\u017a\5:\36\2\u017a\u017b"+
		"\7/\2\2\u017b\u017c\5\64\33\2\u017c\u017e\3\2\2\2\u017d\u0174\3\2\2\2"+
		"\u017d\u0178\3\2\2\2\u017e=\3\2\2\2\u017f\u0180\5\f\7\2\u0180?\3\2\2\2"+
		"\u0181\u0183\5B\"\2\u0182\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0182"+
		"\3\2\2\2\u0184\u0185\3\2\2\2\u0185A\3\2\2\2\u0186\u0187\7-\2\2\u0187\u0188"+
		"\5> \2\u0188\u0189\5D#\2\u0189\u0194\3\2\2\2\u018a\u018b\7.\2\2\u018b"+
		"\u018e\5:\36\2\u018c\u018d\7\13\2\2\u018d\u018f\5> \2\u018e\u018c\3\2"+
		"\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\7/\2\2\u0191"+
		"\u0192\5\64\33\2\u0192\u0194\3\2\2\2\u0193\u0186\3\2\2\2\u0193\u018a\3"+
		"\2\2\2\u0194C\3\2\2\2\u0195\u0197\5F$\2\u0196\u0195\3\2\2\2\u0196\u0197"+
		"\3\2\2\2\u0197\u0199\3\2\2\2\u0198\u019a\5P)\2\u0199\u0198\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u019c\3\2\2\2\u019b\u019d\5X-\2\u019c\u019b\3\2\2"+
		"\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u01a0\5^\60\2\u019f\u019e"+
		"\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u01a3\5p9\2\u01a2"+
		"\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3E\3\2\2\2\u01a4\u01a5\7\60\2\2"+
		"\u01a5\u01a7\7\61\2\2\u01a6\u01a8\5H%\2\u01a7\u01a6\3\2\2\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aaG\3\2\2\2\u01ab"+
		"\u01ac\5:\36\2\u01ac\u01ad\7\13\2\2\u01ad\u01af\3\2\2\2\u01ae\u01ab\3"+
		"\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\5> \2\u01b1"+
		"I\3\2\2\2\u01b2\u01b3\7\f\2\2\u01b3\u01b4\5\b\5\2\u01b4\u01b5\7\r\2\2"+
		"\u01b5\u01b6\5\b\5\2\u01b6\u01b7\7\16\2\2\u01b7K\3\2\2\2\u01b8\u01bc\7"+
		"_\2\2\u01b9\u01bc\7`\2\2\u01ba\u01bc\5J&\2\u01bb\u01b8\3\2\2\2\u01bb\u01b9"+
		"\3\2\2\2\u01bb\u01ba\3\2\2\2\u01bcM\3\2\2\2\u01bd\u01c2\5L\'\2\u01be\u01c2"+
		"\7a\2\2\u01bf\u01c2\7b\2\2\u01c0\u01c2\5\2\2\2\u01c1\u01bd\3\2\2\2\u01c1"+
		"\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2O\3\2\2\2"+
		"\u01c3\u01c4\7$\2\2\u01c4\u01c6\7(\2\2\u01c5\u01c7\5R*\2\u01c6\u01c5\3"+
		"\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"Q\3\2\2\2\u01ca\u01cf\5\2\2\2\u01cb\u01cc\7\4\2\2\u01cc\u01ce\5\2\2\2"+
		"\u01cd\u01cb\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2\u01d3\7\17\2\2"+
		"\u01d3\u01d8\5N(\2\u01d4\u01d5\7\4\2\2\u01d5\u01d7\5N(\2\u01d6\u01d4\3"+
		"\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01db\u01dd\5T+\2\u01dc\u01db\3\2\2"+
		"\2\u01dc\u01dd\3\2\2\2\u01ddS\3\2\2\2\u01de\u01e0\7\62\2\2\u01df\u01e1"+
		"\5V,\2\u01e0\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e3U\3\2\2\2\u01e4\u01e5\5\2\2\2\u01e5\u01f0\7\20\2\2"+
		"\u01e6\u01eb\5N(\2\u01e7\u01e8\7\4\2\2\u01e8\u01ea\5N(\2\u01e9\u01e7\3"+
		"\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec"+
		"\u01ee\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01ef\7\31\2\2\u01ef\u01f1\3"+
		"\2\2\2\u01f0\u01e6\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2"+
		"\u01f3\5N(\2\u01f3W\3\2\2\2\u01f4\u01f5\7\64\2\2\u01f5\u01f7\7(\2\2\u01f6"+
		"\u01f8\5Z.\2\u01f7\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01f7\3\2\2"+
		"\2\u01f9\u01fa\3\2\2\2\u01faY\3\2\2\2\u01fb\u0200\5\16\b\2\u01fc\u01fd"+
		"\7\4\2\2\u01fd\u01ff\5\16\b\2\u01fe\u01fc\3\2\2\2\u01ff\u0202\3\2\2\2"+
		"\u0200\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0203\3\2\2\2\u0202\u0200"+
		"\3\2\2\2\u0203\u0204\7\20\2\2\u0204\u0209\5N(\2\u0205\u0206\7\4\2\2\u0206"+
		"\u0208\5N(\2\u0207\u0205\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u0207\3\2\2"+
		"\2\u0209\u020a\3\2\2\2\u020a[\3\2\2\2\u020b\u0209\3\2\2\2\u020c\u020d"+
		"\7c\2\2\u020d]\3\2\2\2\u020e\u020f\7\'\2\2\u020f\u0211\7(\2\2\u0210\u0212"+
		"\5`\61\2\u0211\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0214\3\2\2\2\u0213"+
		"\u0215\5b\62\2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215_\3\2\2\2"+
		"\u0216\u0218\7\65\2\2\u0217\u0219\5d\63\2\u0218\u0217\3\2\2\2\u0218\u0219"+
		"\3\2\2\2\u0219\u021b\3\2\2\2\u021a\u021c\5f\64\2\u021b\u021a\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021ca\3\2\2\2\u021d\u021f\7\66\2\2\u021e\u0220\5d\63\2"+
		"\u021f\u021e\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0222\3\2\2\2\u0221\u0223"+
		"\5f\64\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223c\3\2\2\2\u0224"+
		"\u0226\7\67\2\2\u0225\u0227\5h\65\2\u0226\u0225\3\2\2\2\u0227\u0228\3"+
		"\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2\2\2\u0229e\3\2\2\2\u022a\u022c"+
		"\78\2\2\u022b\u022d\5h\65\2\u022c\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e"+
		"\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022fg\3\2\2\2\u0230\u0232\79\2\2\u0231"+
		"\u0230\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0234\5\\"+
		"/\2\u0234\u0235\7\20\2\2\u0235\u023f\5N(\2\u0236\u0237\7\b\2\2\u0237\u0239"+
		"\5N(\2\u0238\u0236\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u0238\3\2\2\2\u023a"+
		"\u023b\3\2\2\2\u023b\u023d\3\2\2\2\u023c\u023a\3\2\2\2\u023d\u023e\7\31"+
		"\2\2\u023e\u0240\5N(\2\u023f\u023a\3\2\2\2\u023f\u0240\3\2\2\2\u0240i"+
		"\3\2\2\2\u0241\u0242\5\20\t\2\u0242\u0243\7\25\2\2\u0243\u0244\5\22\n"+
		"\2\u0244\u0249\3\2\2\2\u0245\u0249\5\20\t\2\u0246\u0247\7\7\2\2\u0247"+
		"\u0249\5\20\t\2\u0248\u0241\3\2\2\2\u0248\u0245\3\2\2\2\u0248\u0246\3"+
		"\2\2\2\u0249k\3\2\2\2\u024a\u024b\5\20\t\2\u024b\u024c\7\26\2\2\u024c"+
		"\u024d\5\22\n\2\u024dm\3\2\2\2\u024e\u0251\5j\66\2\u024f\u0251\5l\67\2"+
		"\u0250\u024e\3\2\2\2\u0250\u024f\3\2\2\2\u0251o\3\2\2\2\u0252\u0259\7"+
		":\2\2\u0253\u0258\5r:\2\u0254\u0258\5t;\2\u0255\u0258\5v<\2\u0256\u0258"+
		"\5x=\2\u0257\u0253\3\2\2\2\u0257\u0254\3\2\2\2\u0257\u0255\3\2\2\2\u0257"+
		"\u0256\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u025a\3\2"+
		"\2\2\u025aq\3\2\2\2\u025b\u0259\3\2\2\2\u025c\u025d\7;\2\2\u025d\u025e"+
		"\7<\2\2\u025e\u0260\7=\2\2\u025f\u0261\5z>\2\u0260\u025f\3\2\2\2\u0261"+
		"\u0262\3\2\2\2\u0262\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263s\3\2\2\2"+
		"\u0264\u0265\7>\2\2\u0265\u0267\7?\2\2\u0266\u0268\5|?\2\u0267\u0266\3"+
		"\2\2\2\u0268\u0269\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a"+
		"u\3\2\2\2\u026b\u026c\7%\2\2\u026c\u026e\7&\2\2\u026d\u026f\5~@\2\u026e"+
		"\u026d\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2"+
		"\2\2\u0271w\3\2\2\2\u0272\u0273\7\'\2\2\u0273\u0275\7)\2\2\u0274\u0276"+
		"\5\u0080A\2\u0275\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0275\3\2\2"+
		"\2\u0277\u0278\3\2\2\2\u0278y\3\2\2\2\u0279\u027a\5\34\17\2\u027a\u027b"+
		"\7@\2\2\u027b\u027c\5j\66\2\u027c\u027d\7B\2\2\u027d\u0282\5\36\20\2\u027e"+
		"\u027f\7\4\2\2\u027f\u0281\5\60\31\2\u0280\u027e\3\2\2\2\u0281\u0284\3"+
		"\2\2\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0285\3\2\2\2\u0284"+
		"\u0282\3\2\2\2\u0285\u0286\7\13\2\2\u0286{\3\2\2\2\u0287\u0288\7A\2\2"+
		"\u0288\u0289\5\34\17\2\u0289\u028a\7B\2\2\u028a\u0292\5\36\20\2\u028b"+
		"\u028e\7\4\2\2\u028c\u028f\5\62\32\2\u028d\u028f\5\60\31\2\u028e\u028c"+
		"\3\2\2\2\u028e\u028d\3\2\2\2\u028f\u0291\3\2\2\2\u0290\u028b\3\2\2\2\u0291"+
		"\u0294\3\2\2\2\u0292\u0290\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0295\3\2"+
		"\2\2\u0294\u0292\3\2\2\2\u0295\u0296\7\13\2\2\u0296}\3\2\2\2\u0297\u0298"+
		"\5n8\2\u0298\u0299\7\13\2\2\u0299\u02aa\3\2\2\2\u029a\u029d\7C\2\2\u029b"+
		"\u029d\5n8\2\u029c\u029a\3\2\2\2\u029c\u029b\3\2\2\2\u029d\u029e\3\2\2"+
		"\2\u029e\u029f\7B\2\2\u029f\u02a4\5\60\31\2\u02a0\u02a1\7\4\2\2\u02a1"+
		"\u02a3\5\60\31\2\u02a2\u02a0\3\2\2\2\u02a3\u02a6\3\2\2\2\u02a4\u02a2\3"+
		"\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7"+
		"\u02a8\7\13\2\2\u02a8\u02aa\3\2\2\2\u02a9\u0297\3\2\2\2\u02a9\u029c\3"+
		"\2\2\2\u02aa\177\3\2\2\2\u02ab\u02ac\5\20\t\2\u02ac\u02ad\7\13\2\2\u02ad"+
		"\u02bb\3\2\2\2\u02ae\u02af\5\20\t\2\u02af\u02b0\7B\2\2\u02b0\u02b5\5\60"+
		"\31\2\u02b1\u02b2\7\4\2\2\u02b2\u02b4\5\60\31\2\u02b3\u02b1\3\2\2\2\u02b4"+
		"\u02b7\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b8\3\2"+
		"\2\2\u02b7\u02b5\3\2\2\2\u02b8\u02b9\7\13\2\2\u02b9\u02bb\3\2\2\2\u02ba"+
		"\u02ab\3\2\2\2\u02ba\u02ae\3\2\2\2\u02bb\u0081\3\2\2\2\u02bc\u02bd\5\f"+
		"\7\2\u02bd\u0083\3\2\2\2\u02be\u02bf\7E\2\2\u02bf\u02c5\5\u0082B\2\u02c0"+
		"\u02c4\5\u0086D\2\u02c1\u02c4\5\u008aF\2\u02c2\u02c4\5\u0092J\2\u02c3"+
		"\u02c0\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c2\3\2\2\2\u02c4\u02c7\3\2"+
		"\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u0085\3\2\2\2\u02c7"+
		"\u02c5\3\2\2\2\u02c8\u02c9\7\64\2\2\u02c9\u02cb\7)\2\2\u02ca\u02cc\5\u0088"+
		"E\2\u02cb\u02ca\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cb\3\2\2\2\u02cd"+
		"\u02ce\3\2\2\2\u02ce\u0087\3\2\2\2\u02cf\u02d0\5\16\b\2\u02d0\u02d1\7"+
		"\25\2\2\u02d1\u02d2\5\22\n\2\u02d2\u0089\3\2\2\2\u02d3\u02d5\7J\2\2\u02d4"+
		"\u02d6\5\u008cG\2\u02d5\u02d4\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d5"+
		"\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u008b\3\2\2\2\u02d9\u02de\5\16\b\2"+
		"\u02da\u02db\7\4\2\2\u02db\u02dd\5\16\b\2\u02dc\u02da\3\2\2\2\u02dd\u02e0"+
		"\3\2\2\2\u02de\u02dc\3\2\2\2\u02de\u02df\3\2\2\2\u02df\u02e1\3\2\2\2\u02e0"+
		"\u02de\3\2\2\2\u02e1\u02e2\7F\2\2\u02e2\u02e7\5N(\2\u02e3\u02e4\7\4\2"+
		"\2\u02e4\u02e6\5N(\2\u02e5\u02e3\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e5"+
		"\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02f3\3\2\2\2\u02e9\u02e7\3\2\2\2\u02ea"+
		"\u02eb\7G\2\2\u02eb\u02f0\5\60\31\2\u02ec\u02ed\7\4\2\2\u02ed\u02ef\5"+
		"\60\31\2\u02ee\u02ec\3\2\2\2\u02ef\u02f2\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f0"+
		"\u02f1\3\2\2\2\u02f1\u02f4\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f3\u02ea\3\2"+
		"\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f6\5\u008eH\2\u02f6"+
		"\u008d\3\2\2\2\u02f7\u02f9\5\u0090I\2\u02f8\u02f7\3\2\2\2\u02f9\u02fc"+
		"\3\2\2\2\u02fa\u02f8\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u008f\3\2\2\2\u02fc"+
		"\u02fa\3\2\2\2\u02fd\u02fe\5\20\t\2\u02fe\u02ff\7\25\2\2\u02ff\u0300\5"+
		"\22\n\2\u0300\u0091\3\2\2\2\u0301\u0302\7H\2\2\u0302\u0303\7I\2\2\u0303"+
		"\u0305\7\65\2\2\u0304\u0306\5\u0094K\2\u0305\u0304\3\2\2\2\u0306\u0307"+
		"\3\2\2\2\u0307\u0305\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0093\3\2\2\2\u0309"+
		"\u0313\5n8\2\u030a\u030b\7B\2\2\u030b\u0310\5\60\31\2\u030c\u030d\7\4"+
		"\2\2\u030d\u030f\5\60\31\2\u030e\u030c\3\2\2\2\u030f\u0312\3\2\2\2\u0310"+
		"\u030e\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0314\3\2\2\2\u0312\u0310\3\2"+
		"\2\2\u0313\u030a\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315\3\2\2\2\u0315"+
		"\u0316\7\13\2\2\u0316\u0095\3\2\2\2\u0317\u031b\5\u00a8U\2\u0318\u031b"+
		"\5\u00aaV\2\u0319\u031b\5\u00aeX\2\u031a\u0317\3\2\2\2\u031a\u0318\3\2"+
		"\2\2\u031a\u0319\3\2\2\2\u031b\u031d\3\2\2\2\u031c\u031e\5\u00a0Q\2\u031d"+
		"\u031c\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u0320\3\2\2\2\u031f\u0321\5\u00a4"+
		"S\2\u0320\u031f\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0097\3\2\2\2\u0322"+
		"\u0323\7M\2\2\u0323\u0324\7N\2\2\u0324\u0325\7e\2\2\u0325\u0099\3\2\2"+
		"\2\u0326\u0329\7O\2\2\u0327\u032a\5\u009cO\2\u0328\u032a\5\u009eP\2\u0329"+
		"\u0327\3\2\2\2\u0329\u0328\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u0329\3\2"+
		"\2\2\u032b\u032c\3\2\2\2\u032c\u009b\3\2\2\2\u032d\u032e\7P\2\2\u032e"+
		"\u032f\7\3\2\2\u032f\u0330\5\20\t\2\u0330\u0331\7\4\2\2\u0331\u0332\5"+
		"\22\n\2\u0332\u0333\7\4\2\2\u0333\u0334\5\6\4\2\u0334\u0335\7\5\2\2\u0335"+
		"\u009d\3\2\2\2\u0336\u0337\7Q\2\2\u0337\u0338\7\3\2\2\u0338\u0339\5\16"+
		"\b\2\u0339\u033a\7\4\2\2\u033a\u033b\5\6\4\2\u033b\u033c\7\5\2\2\u033c"+
		"\u009f\3\2\2\2\u033d\u033e\7Z\2\2\u033e\u0340\7&\2\2\u033f\u0341\5\u00a2"+
		"R\2\u0340\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0340\3\2\2\2\u0342"+
		"\u0343\3\2\2\2\u0343\u00a1\3\2\2\2\u0344\u0345\t\7\2\2\u0345\u034a\5\60"+
		"\31\2\u0346\u0347\7\4\2\2\u0347\u0349\5\60\31\2\u0348\u0346\3\2\2\2\u0349"+
		"\u034c\3\2\2\2\u034a\u0348\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u00a3\3\2"+
		"\2\2\u034c\u034a\3\2\2\2\u034d\u034e\7Y\2\2\u034e\u0350\t\b\2\2\u034f"+
		"\u0351\5\u00a6T\2\u0350\u034f\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0350"+
		"\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u00a5\3\2\2\2\u0354\u0355\t\t\2\2\u0355"+
		"\u0356\5\20\t\2\u0356\u0357\7W\2\2\u0357\u035c\5\60\31\2\u0358\u0359\7"+
		"\4\2\2\u0359\u035b\5\60\31\2\u035a\u0358\3\2\2\2\u035b\u035e\3\2\2\2\u035c"+
		"\u035a\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u00a7\3\2\2\2\u035e\u035c\3\2"+
		"\2\2\u035f\u0360\7K\2\2\u0360\u0361\7L\2\2\u0361\u0362\5\u0098M\2\u0362"+
		"\u0363\5\u009aN\2\u0363\u00a9\3\2\2\2\u0364\u0365\7R\2\2\u0365\u0366\7"+
		"S\2\2\u0366\u0367\5\u0098M\2\u0367\u0368\5\u009aN\2\u0368\u0369\5\u00ac"+
		"W\2\u0369\u00ab\3\2\2\2\u036a\u036b\7U\2\2\u036b\u036c\7\25\2\2\u036c"+
		"\u036d\7\21\2\2\u036d\u0372\5\60\31\2\u036e\u036f\7\4\2\2\u036f\u0371"+
		"\5\60\31\2\u0370\u036e\3\2\2\2\u0371\u0374\3\2\2\2\u0372\u0370\3\2\2\2"+
		"\u0372\u0373\3\2\2\2\u0373\u0375\3\2\2\2\u0374\u0372\3\2\2\2\u0375\u0376"+
		"\7\22\2\2\u0376\u00ad\3\2\2\2\u0377\u0378\7T\2\2\u0378\u0379\7S\2\2\u0379"+
		"\u037a\5\u0098M\2\u037a\u037c\5\u009aN\2\u037b\u037d\5\u00b0Y\2\u037c"+
		"\u037b\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u037f\5\u00b4"+
		"[\2\u037f\u00af\3\2\2\2\u0380\u0381\7X\2\2\u0381\u0383\7?\2\2\u0382\u0384"+
		"\5\u00b2Z\2\u0383\u0382\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0383\3\2\2"+
		"\2\u0385\u0386\3\2\2\2\u0386\u00b1\3\2\2\2\u0387\u0388\7c\2\2\u0388\u0389"+
		"\7\20\2\2\u0389\u0393\5\60\31\2\u038a\u038b\7W\2\2\u038b\u0390\5\60\31"+
		"\2\u038c\u038d\7\4\2\2\u038d\u038f\5\60\31\2\u038e\u038c\3\2\2\2\u038f"+
		"\u0392\3\2\2\2\u0390\u038e\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0394\3\2"+
		"\2\2\u0392\u0390\3\2\2\2\u0393\u038a\3\2\2\2\u0393\u0394\3\2\2\2\u0394"+
		"\u00b3\3\2\2\2\u0395\u0396\7V\2\2\u0396\u0397\7\25\2\2\u0397\u0398\7\21"+
		"\2\2\u0398\u039d\5\60\31\2\u0399\u039a\7\4\2\2\u039a\u039c\5\60\31\2\u039b"+
		"\u0399\3\2\2\2\u039c\u039f\3\2\2\2\u039d\u039b\3\2\2\2\u039d\u039e\3\2"+
		"\2\2\u039e\u03a0\3\2\2\2\u039f\u039d\3\2\2\2\u03a0\u03a1\7\22\2\2\u03a1"+
		"\u00b5\3\2\2\2_\u00c2\u00cb\u00d0\u00da\u00de\u00e9\u00eb\u00f4\u00ff"+
		"\u0101\u0114\u0154\u015d\u0162\u016e\u0170\u017d\u0184\u018e\u0193\u0196"+
		"\u0199\u019c\u019f\u01a2\u01a9\u01ae\u01bb\u01c1\u01c8\u01cf\u01d8\u01dc"+
		"\u01e2\u01eb\u01f0\u01f9\u0200\u0209\u0211\u0214\u0218\u021b\u021f\u0222"+
		"\u0228\u022e\u0231\u023a\u023f\u0248\u0250\u0257\u0259\u0262\u0269\u0270"+
		"\u0277\u0282\u028e\u0292\u029c\u02a4\u02a9\u02b5\u02ba\u02c3\u02c5\u02cd"+
		"\u02d7\u02de\u02e7\u02f0\u02f3\u02fa\u0307\u0310\u0313\u031a\u031d\u0320"+
		"\u0329\u032b\u0342\u034a\u0352\u035c\u0372\u037c\u0385\u0390\u0393\u039d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}