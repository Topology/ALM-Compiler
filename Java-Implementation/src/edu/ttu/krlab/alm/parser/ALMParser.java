// Generated from ALM.g4 by ANTLR 4.7

    package edu.ttu.krlab.alm.parser;

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
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, WhiteSpace=15, MOD=16, 
		EQ=17, NEQ=18, ARITH_OP=19, COMP_REL=20, RIGHT_ARROW=21, OCCURS=22, INSTANCE=23, 
		IS_A=24, HAS_CHILD=25, HAS_PARENT=26, LINK=27, SOURCE=28, SINK=29, SUBSORT=30, 
		DOM=31, SORT=32, STATE=33, CONSTRAINTS=34, FUNCTION=35, DECLARATIONS=36, 
		DEFINITIONS=37, SYSTEM=38, DESCRIPTION=39, THEORY=40, MODULE=41, IMPORT=42, 
		FROM=43, DEPENDS=44, ON=45, ATTRIBUTES=46, OBJECT=47, CONSTANT=48, STATICS=49, 
		FLUENTS=50, BASIC=51, DEFINED=52, TOTAL=53, AXIOMS=54, DYNAMIC=55, CAUSAL=56, 
		LAWS=57, EXECUTABILITY=58, CONDITIONS=59, CAUSES=60, IMPOSSIBLE=61, IF=62, 
		FALSE=63, TRUE=64, STRUCTURE=65, IN=66, WHERE=67, VALUE=68, OF=69, INSTANCES=70, 
		TEMPORAL=71, PROJECTION=72, MAX=73, STEPS=74, HISTORY=75, OBSERVED=76, 
		HAPPENED=77, BOOLEAN=78, INTEGERS=79, UNIVERSE=80, ACTIONS=81, ID=82, 
		VAR=83, POSINT=84, NEGINT=85, ZERO=86;
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
		RULE_solver_mode = 74, RULE_temporal_projection = 75, RULE_max_steps = 76, 
		RULE_history = 77, RULE_observed = 78, RULE_happened = 79;
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
		"one_static_def", "solver_mode", "temporal_projection", "max_steps", "history", 
		"observed", "happened"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'+'", "'-'", "'*'", "'/'", "'^'", "'.'", "'['", 
		"'..'", "']'", "'::'", "':'", null, "'mod'", "'='", "'!='", null, null, 
		"'->'", "'occurs'", "'instance'", "'is_a'", "'has_child'", "'has_parent'", 
		"'link'", "'source'", "'sink'", "'subsort'", "'DOM'", "'sort'", "'state'", 
		"'constraints'", "'function'", "'declarations'", "'definitions'", "'system'", 
		"'description'", "'theory'", "'module'", "'import'", "'from'", "'depends'", 
		"'on'", "'attributes'", "'object'", "'constant'", "'statics'", "'fluents'", 
		"'basic'", "'defined'", "'total'", "'axioms'", "'dynamic'", "'causal'", 
		"'laws'", "'executability'", "'conditions'", "'causes'", "'impossible'", 
		"'if'", "'false'", "'true'", "'structure'", "'in'", "'where'", "'value'", 
		"'of'", "'instances'", "'temporal'", "'projection'", "'max'", "'steps'", 
		"'history'", "'observed'", "'happened'", "'booleans'", "'integers'", "'universe'", 
		"'actions'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "WhiteSpace", "MOD", "EQ", "NEQ", "ARITH_OP", "COMP_REL", 
		"RIGHT_ARROW", "OCCURS", "INSTANCE", "IS_A", "HAS_CHILD", "HAS_PARENT", 
		"LINK", "SOURCE", "SINK", "SUBSORT", "DOM", "SORT", "STATE", "CONSTRAINTS", 
		"FUNCTION", "DECLARATIONS", "DEFINITIONS", "SYSTEM", "DESCRIPTION", "THEORY", 
		"MODULE", "IMPORT", "FROM", "DEPENDS", "ON", "ATTRIBUTES", "OBJECT", "CONSTANT", 
		"STATICS", "FLUENTS", "BASIC", "DEFINED", "TOTAL", "AXIOMS", "DYNAMIC", 
		"CAUSAL", "LAWS", "EXECUTABILITY", "CONDITIONS", "CAUSES", "IMPOSSIBLE", 
		"IF", "FALSE", "TRUE", "STRUCTURE", "IN", "WHERE", "VALUE", "OF", "INSTANCES", 
		"TEMPORAL", "PROJECTION", "MAX", "STEPS", "HISTORY", "OBSERVED", "HAPPENED", 
		"BOOLEAN", "INTEGERS", "UNIVERSE", "ACTIONS", "ID", "VAR", "POSINT", "NEGINT", 
		"ZERO"
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
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << OCCURS) | (1L << INSTANCE) | (1L << IS_A) | (1L << HAS_CHILD) | (1L << HAS_PARENT) | (1L << LINK) | (1L << SOURCE) | (1L << SINK) | (1L << SUBSORT) | (1L << DOM) | (1L << SORT) | (1L << STATE) | (1L << CONSTRAINTS) | (1L << FUNCTION) | (1L << DECLARATIONS) | (1L << DEFINITIONS) | (1L << SYSTEM) | (1L << DESCRIPTION) | (1L << THEORY) | (1L << MODULE) | (1L << IMPORT) | (1L << FROM) | (1L << DEPENDS) | (1L << ON) | (1L << ATTRIBUTES) | (1L << OBJECT) | (1L << CONSTANT) | (1L << STATICS) | (1L << FLUENTS) | (1L << BASIC) | (1L << DEFINED) | (1L << TOTAL) | (1L << AXIOMS) | (1L << DYNAMIC) | (1L << CAUSAL) | (1L << LAWS) | (1L << EXECUTABILITY) | (1L << CONDITIONS) | (1L << CAUSES) | (1L << IMPOSSIBLE) | (1L << IF) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TRUE - 64)) | (1L << (STRUCTURE - 64)) | (1L << (IN - 64)) | (1L << (WHERE - 64)) | (1L << (VALUE - 64)) | (1L << (OF - 64)) | (1L << (INSTANCES - 64)) | (1L << (TEMPORAL - 64)) | (1L << (PROJECTION - 64)) | (1L << (MAX - 64)) | (1L << (STEPS - 64)) | (1L << (HISTORY - 64)) | (1L << (OBSERVED - 64)) | (1L << (HAPPENED - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INTEGERS - 64)) | (1L << (UNIVERSE - 64)) | (1L << (ACTIONS - 64)) | (1L << (ID - 64)))) != 0)) ) {
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
			setState(162);
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
			setState(164);
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
			setState(166);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (POSINT - 84)) | (1L << (NEGINT - 84)) | (1L << (ZERO - 84)))) != 0)) ) {
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
			setState(168);
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
			setState(172);
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
				setState(170);
				id();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
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
			setState(174);
			id();
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(175);
				match(T__0);
				setState(176);
				term();
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(177);
					match(T__1);
					setState(178);
					term();
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
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
			setState(188);
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
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				bool();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				id();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				integer();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(194);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(195);
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
			setState(200);
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
				setState(198);
				object_constant();
				}
				break;
			case VAR:
				{
				setState(199);
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
			setState(203);
			arithmetic_term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(211);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(206);
						match(T__3);
						setState(207);
						arithmetic_term(0);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(209);
						match(T__4);
						setState(210);
						arithmetic_term(0);
						}
						break;
					}
					} 
				}
				setState(215);
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
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(217);
				factor();
				setState(218);
				match(T__7);
				setState(219);
				factor();
				}
				break;
			case 2:
				{
				setState(221);
				factor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(233);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(224);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(225);
						match(T__5);
						setState(226);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(227);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(228);
						match(T__6);
						setState(229);
						factor();
						}
						break;
					case 3:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(230);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(231);
						match(MOD);
						setState(232);
						factor();
						}
						break;
					}
					} 
				}
				setState(237);
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
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(T__4);
				setState(240);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(241);
				integer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(242);
				function_term();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(243);
				match(T__4);
				setState(244);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(245);
				match(T__0);
				setState(246);
				expression(0);
				setState(247);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(249);
				match(T__4);
				setState(250);
				match(T__0);
				setState(251);
				expression(0);
				setState(252);
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
			setState(256);
			match(OCCURS);
			setState(257);
			match(T__0);
			setState(258);
			var_or_obj();
			setState(259);
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
			setState(261);
			match(INSTANCE);
			setState(262);
			match(T__0);
			setState(263);
			var_or_obj();
			setState(264);
			match(T__1);
			setState(265);
			sort_name();
			setState(266);
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
			setState(268);
			match(IS_A);
			setState(269);
			match(T__0);
			setState(270);
			var_or_obj();
			setState(271);
			match(T__1);
			setState(272);
			sort_name();
			setState(273);
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
			setState(275);
			match(LINK);
			setState(276);
			match(T__0);
			setState(277);
			sort_name();
			setState(278);
			match(T__1);
			setState(279);
			sort_name();
			setState(280);
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
			setState(282);
			match(SUBSORT);
			setState(283);
			match(T__0);
			setState(284);
			sort_name();
			setState(285);
			match(T__1);
			setState(286);
			sort_name();
			setState(287);
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
			setState(289);
			match(HAS_CHILD);
			setState(290);
			match(T__0);
			setState(291);
			sort_name();
			setState(292);
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
			setState(294);
			match(HAS_PARENT);
			setState(295);
			match(T__0);
			setState(296);
			sort_name();
			setState(297);
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
			setState(299);
			match(SINK);
			setState(300);
			match(T__0);
			setState(301);
			sort_name();
			setState(302);
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
			setState(304);
			match(SOURCE);
			setState(305);
			match(T__0);
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
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				instance_atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				is_a_atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				link_atom();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				subsort_atom();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(313);
				has_child_atom();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(314);
				has_parent_atom();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(315);
				sink_atom();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(316);
				source_atom();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(317);
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
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(T__4);
				setState(322);
				atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(323);
				term();
				setState(324);
				relation();
				setState(325);
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
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OCCURS:
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				occurs_atom();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(330);
				match(T__4);
				setState(331);
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
			setState(334);
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
			setState(336);
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
			setState(338);
			match(SYSTEM);
			setState(339);
			match(DESCRIPTION);
			setState(340);
			sys_desc_name();
			setState(341);
			theory();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRUCTURE) {
				{
				setState(342);
				structure();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TEMPORAL) {
					{
					setState(343);
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
			setState(348);
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
			setState(359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THEORY:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(350);
				match(THEORY);
				setState(351);
				theory_name();
				setState(352);
				sequence_of_modules();
				}
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(354);
				match(IMPORT);
				setState(355);
				theory_name();
				setState(356);
				match(FROM);
				setState(357);
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
			setState(361);
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
			setState(364); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(363);
				module();
				}
				}
				setState(366); 
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
			setState(381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(368);
				match(MODULE);
				setState(369);
				module_name();
				setState(370);
				module_body();
				}
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(372);
				match(IMPORT);
				setState(373);
				theory_name();
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(374);
					match(T__8);
					setState(375);
					module_name();
					}
				}

				setState(378);
				match(FROM);
				setState(379);
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
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEPENDS) {
				{
				setState(383);
				module_dependencies();
				}
			}

			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORT) {
				{
				setState(386);
				sort_declarations();
				}
			}

			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(389);
				constant_declarations();
				}
			}

			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNCTION) {
				{
				setState(392);
				function_declarations();
				}
			}

			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AXIOMS) {
				{
				setState(395);
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
			setState(398);
			match(DEPENDS);
			setState(399);
			match(ON);
			setState(401); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(400);
					one_dependency();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(403); 
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
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(405);
				theory_name();
				setState(406);
				match(T__8);
				}
				break;
			}
			setState(410);
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
			setState(412);
			match(T__9);
			setState(413);
			integer();
			setState(414);
			match(T__10);
			setState(415);
			integer();
			setState(416);
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
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				match(BOOLEAN);
				}
				break;
			case INTEGERS:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				match(INTEGERS);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(420);
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
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				predefined_sorts();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				match(UNIVERSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				match(ACTIONS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(426);
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
			setState(429);
			match(SORT);
			setState(430);
			match(DECLARATIONS);
			setState(432); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(431);
					one_sort_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(434); 
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
			setState(436);
			id();
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(437);
				match(T__1);
				setState(438);
				id();
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(444);
			match(T__12);
			setState(445);
			sort_name();
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(446);
				match(T__1);
				setState(447);
				sort_name();
				}
				}
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(453);
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
			setState(456);
			match(ATTRIBUTES);
			setState(458); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(457);
					one_attribute_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(460); 
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
			setState(462);
			id();
			setState(463);
			match(T__13);
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(464);
				sort_name();
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(465);
					match(T__1);
					setState(466);
					sort_name();
					}
					}
					setState(471);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(472);
				match(RIGHT_ARROW);
				}
				break;
			}
			setState(476);
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
			setState(478);
			match(CONSTANT);
			setState(479);
			match(DECLARATIONS);
			setState(481); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(480);
					one_constant_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(483); 
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
			setState(485);
			object_constant();
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(486);
				match(T__1);
				setState(487);
				object_constant();
				}
				}
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(493);
			match(T__13);
			setState(494);
			sort_name();
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(495);
				match(T__1);
				setState(496);
				sort_name();
				}
				}
				setState(501);
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
			setState(502);
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
			setState(504);
			match(FUNCTION);
			setState(505);
			match(DECLARATIONS);
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATICS) {
				{
				setState(506);
				static_declarations();
				}
			}

			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLUENTS) {
				{
				setState(509);
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
			setState(512);
			match(STATICS);
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BASIC) {
				{
				setState(513);
				basic_function_declarations();
				}
			}

			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINED) {
				{
				setState(516);
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
			setState(519);
			match(FLUENTS);
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BASIC) {
				{
				setState(520);
				basic_function_declarations();
				}
			}

			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINED) {
				{
				setState(523);
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
			setState(526);
			match(BASIC);
			setState(528); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(527);
				one_function_decl();
				}
				}
				setState(530); 
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
			setState(532);
			match(DEFINED);
			setState(534); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(533);
				one_function_decl();
				}
				}
				setState(536); 
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
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TOTAL) {
				{
				setState(538);
				match(TOTAL);
				}
			}

			setState(541);
			function_name();
			setState(542);
			match(T__13);
			setState(543);
			sort_name();
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==RIGHT_ARROW) {
				{
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(544);
					match(T__5);
					setState(545);
					sort_name();
					}
					}
					setState(550);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(551);
				match(RIGHT_ARROW);
				setState(552);
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
			setState(562);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(555);
				function_term();
				setState(556);
				match(EQ);
				setState(557);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(559);
				function_term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(560);
				match(T__4);
				setState(561);
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
			setState(564);
			function_term();
			setState(565);
			match(NEQ);
			setState(566);
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
			setState(570);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(568);
				pos_fun_def();
				}
				break;
			case 2:
				{
				setState(569);
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
			setState(572);
			match(AXIOMS);
			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STATE) | (1L << FUNCTION) | (1L << DYNAMIC) | (1L << EXECUTABILITY))) != 0)) {
				{
				setState(577);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DYNAMIC:
					{
					setState(573);
					dynamic_causal_laws();
					}
					break;
				case EXECUTABILITY:
					{
					setState(574);
					executability_conditions();
					}
					break;
				case STATE:
					{
					setState(575);
					state_constraints();
					}
					break;
				case FUNCTION:
					{
					setState(576);
					definitions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(581);
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
			setState(582);
			match(DYNAMIC);
			setState(583);
			match(CAUSAL);
			setState(584);
			match(LAWS);
			setState(586); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(585);
				one_dynamic_causal_law();
				}
				}
				setState(588); 
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
			setState(590);
			match(EXECUTABILITY);
			setState(591);
			match(CONDITIONS);
			setState(593); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(592);
				one_executability_condition();
				}
				}
				setState(595); 
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
			setState(597);
			match(STATE);
			setState(598);
			match(CONSTRAINTS);
			setState(600); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(599);
					one_state_constraint();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(602); 
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
			setState(604);
			match(FUNCTION);
			setState(605);
			match(DEFINITIONS);
			setState(607); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(606);
					one_definition();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(609); 
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
			setState(611);
			occurs_atom();
			setState(612);
			match(CAUSES);
			setState(613);
			pos_fun_def();
			setState(614);
			match(IF);
			setState(615);
			instance_atom();
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(616);
				match(T__1);
				setState(617);
				literal();
				}
				}
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(623);
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
			setState(625);
			match(IMPOSSIBLE);
			setState(626);
			occurs_atom();
			setState(627);
			match(IF);
			setState(628);
			instance_atom();
			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(629);
				match(T__1);
				setState(632);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(630);
					occurs_literal();
					}
					break;
				case 2:
					{
					setState(631);
					literal();
					}
					break;
				}
				}
				}
				setState(638);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(639);
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
			setState(659);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(641);
				fun_def();
				setState(642);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(646);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(644);
					match(FALSE);
					}
					break;
				case 2:
					{
					setState(645);
					fun_def();
					}
					break;
				}
				setState(648);
				match(IF);
				setState(649);
				literal();
				setState(654);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(650);
					match(T__1);
					setState(651);
					literal();
					}
					}
					setState(656);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(657);
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
			setState(676);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(661);
				function_term();
				setState(662);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(664);
				function_term();
				setState(665);
				match(IF);
				setState(666);
				literal();
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(667);
					match(T__1);
					setState(668);
					literal();
					}
					}
					setState(673);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(674);
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
			setState(678);
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
			setState(680);
			match(STRUCTURE);
			setState(681);
			structure_name();
			setState(687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 48)) & ~0x3f) == 0 && ((1L << (_la - 48)) & ((1L << (CONSTANT - 48)) | (1L << (VALUE - 48)) | (1L << (INSTANCES - 48)))) != 0)) {
				{
				setState(685);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONSTANT:
					{
					setState(682);
					constant_defs();
					}
					break;
				case INSTANCES:
					{
					setState(683);
					instance_defs();
					}
					break;
				case VALUE:
					{
					setState(684);
					statics_defs();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(689);
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
			setState(690);
			match(CONSTANT);
			setState(691);
			match(DEFINITIONS);
			setState(693); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(692);
					one_constant_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(695); 
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
			setState(697);
			object_constant();
			setState(698);
			match(EQ);
			setState(699);
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
			setState(701);
			match(INSTANCES);
			setState(703); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(702);
					one_instance_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(705); 
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
			setState(707);
			object_constant();
			setState(712);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(708);
				match(T__1);
				setState(709);
				object_constant();
				}
				}
				setState(714);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(715);
			match(IN);
			setState(716);
			sort_name();
			setState(721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(717);
				match(T__1);
				setState(718);
				sort_name();
				}
				}
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(733);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(724);
				match(WHERE);
				setState(725);
				literal();
				setState(730);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(726);
					match(T__1);
					setState(727);
					literal();
					}
					}
					setState(732);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(735);
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
			setState(740);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(737);
					one_attribute_def();
					}
					} 
				}
				setState(742);
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
			setState(743);
			function_term();
			setState(744);
			match(EQ);
			setState(745);
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
			setState(747);
			match(VALUE);
			setState(748);
			match(OF);
			setState(749);
			match(STATICS);
			setState(751); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(750);
					one_static_def();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(753); 
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
			setState(755);
			fun_def();
			setState(765);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(756);
				match(IF);
				setState(757);
				literal();
				setState(762);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(758);
					match(T__1);
					setState(759);
					literal();
					}
					}
					setState(764);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(767);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			temporal_projection();
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
		enterRule(_localctx, 150, RULE_temporal_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(771);
			match(TEMPORAL);
			setState(772);
			match(PROJECTION);
			setState(773);
			max_steps();
			setState(774);
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
		enterRule(_localctx, 152, RULE_max_steps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			match(MAX);
			setState(777);
			match(STEPS);
			setState(778);
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
		enterRule(_localctx, 154, RULE_history);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(780);
			match(HISTORY);
			setState(783); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(783);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OBSERVED:
					{
					setState(781);
					observed();
					}
					break;
				case HAPPENED:
					{
					setState(782);
					happened();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(785); 
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
		enterRule(_localctx, 156, RULE_observed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			match(OBSERVED);
			setState(788);
			match(T__0);
			setState(789);
			function_term();
			setState(790);
			match(T__1);
			setState(791);
			term();
			setState(792);
			match(T__1);
			setState(793);
			nat_num();
			setState(794);
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
		enterRule(_localctx, 158, RULE_happened);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			match(HAPPENED);
			setState(797);
			match(T__0);
			setState(798);
			object_constant();
			setState(799);
			match(T__1);
			setState(800);
			nat_num();
			setState(801);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3X\u0326\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\5\7\u00af\n\7\3\b\3\b\3\b\3\b\3\b\7\b\u00b6"+
		"\n\b\f\b\16\b\u00b9\13\b\3\b\3\b\5\b\u00bd\n\b\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00c7\n\n\3\13\3\13\5\13\u00cb\n\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\7\f\u00d6\n\f\f\f\16\f\u00d9\13\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00e1\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ec\n\r\f\r"+
		"\16\r\u00ef\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u0101\n\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0141\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u014a\n\31\3"+
		"\32\3\32\3\32\5\32\u014f\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u015b\n\35\5\35\u015d\n\35\3\36\3\36\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\5\37\u016a\n\37\3 \3 \3!\6!\u016f\n!\r!\16"+
		"!\u0170\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u017b\n\"\3\"\3\"\3\"\5\""+
		"\u0180\n\"\3#\5#\u0183\n#\3#\5#\u0186\n#\3#\5#\u0189\n#\3#\5#\u018c\n"+
		"#\3#\5#\u018f\n#\3$\3$\3$\6$\u0194\n$\r$\16$\u0195\3%\3%\3%\5%\u019b\n"+
		"%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\5\'\u01a8\n\'\3(\3(\3(\3(\5(\u01ae"+
		"\n(\3)\3)\3)\6)\u01b3\n)\r)\16)\u01b4\3*\3*\3*\7*\u01ba\n*\f*\16*\u01bd"+
		"\13*\3*\3*\3*\3*\7*\u01c3\n*\f*\16*\u01c6\13*\3*\5*\u01c9\n*\3+\3+\6+"+
		"\u01cd\n+\r+\16+\u01ce\3,\3,\3,\3,\3,\7,\u01d6\n,\f,\16,\u01d9\13,\3,"+
		"\3,\5,\u01dd\n,\3,\3,\3-\3-\3-\6-\u01e4\n-\r-\16-\u01e5\3.\3.\3.\7.\u01eb"+
		"\n.\f.\16.\u01ee\13.\3.\3.\3.\3.\7.\u01f4\n.\f.\16.\u01f7\13.\3/\3/\3"+
		"\60\3\60\3\60\5\60\u01fe\n\60\3\60\5\60\u0201\n\60\3\61\3\61\5\61\u0205"+
		"\n\61\3\61\5\61\u0208\n\61\3\62\3\62\5\62\u020c\n\62\3\62\5\62\u020f\n"+
		"\62\3\63\3\63\6\63\u0213\n\63\r\63\16\63\u0214\3\64\3\64\6\64\u0219\n"+
		"\64\r\64\16\64\u021a\3\65\5\65\u021e\n\65\3\65\3\65\3\65\3\65\3\65\7\65"+
		"\u0225\n\65\f\65\16\65\u0228\13\65\3\65\3\65\5\65\u022c\n\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\5\66\u0235\n\66\3\67\3\67\3\67\3\67\38\38\5"+
		"8\u023d\n8\39\39\39\39\39\79\u0244\n9\f9\169\u0247\139\3:\3:\3:\3:\6:"+
		"\u024d\n:\r:\16:\u024e\3;\3;\3;\6;\u0254\n;\r;\16;\u0255\3<\3<\3<\6<\u025b"+
		"\n<\r<\16<\u025c\3=\3=\3=\6=\u0262\n=\r=\16=\u0263\3>\3>\3>\3>\3>\3>\3"+
		">\7>\u026d\n>\f>\16>\u0270\13>\3>\3>\3?\3?\3?\3?\3?\3?\3?\5?\u027b\n?"+
		"\7?\u027d\n?\f?\16?\u0280\13?\3?\3?\3@\3@\3@\3@\3@\5@\u0289\n@\3@\3@\3"+
		"@\3@\7@\u028f\n@\f@\16@\u0292\13@\3@\3@\5@\u0296\n@\3A\3A\3A\3A\3A\3A"+
		"\3A\3A\7A\u02a0\nA\fA\16A\u02a3\13A\3A\3A\5A\u02a7\nA\3B\3B\3C\3C\3C\3"+
		"C\3C\7C\u02b0\nC\fC\16C\u02b3\13C\3D\3D\3D\6D\u02b8\nD\rD\16D\u02b9\3"+
		"E\3E\3E\3E\3F\3F\6F\u02c2\nF\rF\16F\u02c3\3G\3G\3G\7G\u02c9\nG\fG\16G"+
		"\u02cc\13G\3G\3G\3G\3G\7G\u02d2\nG\fG\16G\u02d5\13G\3G\3G\3G\3G\7G\u02db"+
		"\nG\fG\16G\u02de\13G\5G\u02e0\nG\3G\3G\3H\7H\u02e5\nH\fH\16H\u02e8\13"+
		"H\3I\3I\3I\3I\3J\3J\3J\3J\6J\u02f2\nJ\rJ\16J\u02f3\3K\3K\3K\3K\3K\7K\u02fb"+
		"\nK\fK\16K\u02fe\13K\5K\u0300\nK\3K\3K\3L\3L\3M\3M\3M\3M\3M\3N\3N\3N\3"+
		"N\3O\3O\3O\6O\u0312\nO\rO\16O\u0313\3P\3P\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3"+
		"Q\3Q\3Q\3Q\3Q\3Q\2\4\26\30R\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"+
		"\u009e\u00a0\2\7\4\2\22\22\30T\3\2AB\4\2VVXX\3\2VX\4\2\23\24\26\26\2\u033e"+
		"\2\u00a2\3\2\2\2\4\u00a4\3\2\2\2\6\u00a6\3\2\2\2\b\u00a8\3\2\2\2\n\u00aa"+
		"\3\2\2\2\f\u00ae\3\2\2\2\16\u00b0\3\2\2\2\20\u00be\3\2\2\2\22\u00c6\3"+
		"\2\2\2\24\u00ca\3\2\2\2\26\u00cc\3\2\2\2\30\u00e0\3\2\2\2\32\u0100\3\2"+
		"\2\2\34\u0102\3\2\2\2\36\u0107\3\2\2\2 \u010e\3\2\2\2\"\u0115\3\2\2\2"+
		"$\u011c\3\2\2\2&\u0123\3\2\2\2(\u0128\3\2\2\2*\u012d\3\2\2\2,\u0132\3"+
		"\2\2\2.\u0140\3\2\2\2\60\u0149\3\2\2\2\62\u014e\3\2\2\2\64\u0150\3\2\2"+
		"\2\66\u0152\3\2\2\28\u0154\3\2\2\2:\u015e\3\2\2\2<\u0169\3\2\2\2>\u016b"+
		"\3\2\2\2@\u016e\3\2\2\2B\u017f\3\2\2\2D\u0182\3\2\2\2F\u0190\3\2\2\2H"+
		"\u019a\3\2\2\2J\u019e\3\2\2\2L\u01a7\3\2\2\2N\u01ad\3\2\2\2P\u01af\3\2"+
		"\2\2R\u01b6\3\2\2\2T\u01ca\3\2\2\2V\u01d0\3\2\2\2X\u01e0\3\2\2\2Z\u01e7"+
		"\3\2\2\2\\\u01f8\3\2\2\2^\u01fa\3\2\2\2`\u0202\3\2\2\2b\u0209\3\2\2\2"+
		"d\u0210\3\2\2\2f\u0216\3\2\2\2h\u021d\3\2\2\2j\u0234\3\2\2\2l\u0236\3"+
		"\2\2\2n\u023c\3\2\2\2p\u023e\3\2\2\2r\u0248\3\2\2\2t\u0250\3\2\2\2v\u0257"+
		"\3\2\2\2x\u025e\3\2\2\2z\u0265\3\2\2\2|\u0273\3\2\2\2~\u0295\3\2\2\2\u0080"+
		"\u02a6\3\2\2\2\u0082\u02a8\3\2\2\2\u0084\u02aa\3\2\2\2\u0086\u02b4\3\2"+
		"\2\2\u0088\u02bb\3\2\2\2\u008a\u02bf\3\2\2\2\u008c\u02c5\3\2\2\2\u008e"+
		"\u02e6\3\2\2\2\u0090\u02e9\3\2\2\2\u0092\u02ed\3\2\2\2\u0094\u02f5\3\2"+
		"\2\2\u0096\u0303\3\2\2\2\u0098\u0305\3\2\2\2\u009a\u030a\3\2\2\2\u009c"+
		"\u030e\3\2\2\2\u009e\u0315\3\2\2\2\u00a0\u031e\3\2\2\2\u00a2\u00a3\t\2"+
		"\2\2\u00a3\3\3\2\2\2\u00a4\u00a5\t\3\2\2\u00a5\5\3\2\2\2\u00a6\u00a7\t"+
		"\4\2\2\u00a7\7\3\2\2\2\u00a8\u00a9\t\5\2\2\u00a9\t\3\2\2\2\u00aa\u00ab"+
		"\t\6\2\2\u00ab\13\3\2\2\2\u00ac\u00af\5\2\2\2\u00ad\u00af\7U\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\r\3\2\2\2\u00b0\u00bc\5\2\2\2"+
		"\u00b1\u00b2\7\3\2\2\u00b2\u00b7\5\22\n\2\u00b3\u00b4\7\4\2\2\u00b4\u00b6"+
		"\5\22\n\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2"+
		"\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb"+
		"\7\5\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b1\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\17\3\2\2\2\u00be\u00bf\5\16\b\2\u00bf\21\3\2\2\2\u00c0\u00c7\5\4\3\2"+
		"\u00c1\u00c7\7U\2\2\u00c2\u00c7\5\2\2\2\u00c3\u00c7\5\b\5\2\u00c4\u00c7"+
		"\5\20\t\2\u00c5\u00c7\5\26\f\2\u00c6\u00c0\3\2\2\2\u00c6\u00c1\3\2\2\2"+
		"\u00c6\u00c2\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5"+
		"\3\2\2\2\u00c7\23\3\2\2\2\u00c8\u00cb\5\16\b\2\u00c9\u00cb\7U\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\25\3\2\2\2\u00cc\u00cd\b\f\1"+
		"\2\u00cd\u00ce\5\30\r\2\u00ce\u00d7\3\2\2\2\u00cf\u00d0\f\5\2\2\u00d0"+
		"\u00d1\7\6\2\2\u00d1\u00d6\5\30\r\2\u00d2\u00d3\f\4\2\2\u00d3\u00d4\7"+
		"\7\2\2\u00d4\u00d6\5\30\r\2\u00d5\u00cf\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d6"+
		"\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\27\3\2\2"+
		"\2\u00d9\u00d7\3\2\2\2\u00da\u00db\b\r\1\2\u00db\u00dc\5\32\16\2\u00dc"+
		"\u00dd\7\n\2\2\u00dd\u00de\5\32\16\2\u00de\u00e1\3\2\2\2\u00df\u00e1\5"+
		"\32\16\2\u00e0\u00da\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\u00ed\3\2\2\2\u00e2"+
		"\u00e3\f\7\2\2\u00e3\u00e4\7\b\2\2\u00e4\u00ec\5\32\16\2\u00e5\u00e6\f"+
		"\6\2\2\u00e6\u00e7\7\t\2\2\u00e7\u00ec\5\32\16\2\u00e8\u00e9\f\5\2\2\u00e9"+
		"\u00ea\7\22\2\2\u00ea\u00ec\5\32\16\2\u00eb\u00e2\3\2\2\2\u00eb\u00e5"+
		"\3\2\2\2\u00eb\u00e8\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\31\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u0101\7U\2\2"+
		"\u00f1\u00f2\7\7\2\2\u00f2\u0101\7U\2\2\u00f3\u0101\5\b\5\2\u00f4\u0101"+
		"\5\20\t\2\u00f5\u00f6\7\7\2\2\u00f6\u0101\5\20\t\2\u00f7\u00f8\7\3\2\2"+
		"\u00f8\u00f9\5\26\f\2\u00f9\u00fa\7\5\2\2\u00fa\u0101\3\2\2\2\u00fb\u00fc"+
		"\7\7\2\2\u00fc\u00fd\7\3\2\2\u00fd\u00fe\5\26\f\2\u00fe\u00ff\7\5\2\2"+
		"\u00ff\u0101\3\2\2\2\u0100\u00f0\3\2\2\2\u0100\u00f1\3\2\2\2\u0100\u00f3"+
		"\3\2\2\2\u0100\u00f4\3\2\2\2\u0100\u00f5\3\2\2\2\u0100\u00f7\3\2\2\2\u0100"+
		"\u00fb\3\2\2\2\u0101\33\3\2\2\2\u0102\u0103\7\30\2\2\u0103\u0104\7\3\2"+
		"\2\u0104\u0105\5\24\13\2\u0105\u0106\7\5\2\2\u0106\35\3\2\2\2\u0107\u0108"+
		"\7\31\2\2\u0108\u0109\7\3\2\2\u0109\u010a\5\24\13\2\u010a\u010b\7\4\2"+
		"\2\u010b\u010c\5N(\2\u010c\u010d\7\5\2\2\u010d\37\3\2\2\2\u010e\u010f"+
		"\7\32\2\2\u010f\u0110\7\3\2\2\u0110\u0111\5\24\13\2\u0111\u0112\7\4\2"+
		"\2\u0112\u0113\5N(\2\u0113\u0114\7\5\2\2\u0114!\3\2\2\2\u0115\u0116\7"+
		"\35\2\2\u0116\u0117\7\3\2\2\u0117\u0118\5N(\2\u0118\u0119\7\4\2\2\u0119"+
		"\u011a\5N(\2\u011a\u011b\7\5\2\2\u011b#\3\2\2\2\u011c\u011d\7 \2\2\u011d"+
		"\u011e\7\3\2\2\u011e\u011f\5N(\2\u011f\u0120\7\4\2\2\u0120\u0121\5N(\2"+
		"\u0121\u0122\7\5\2\2\u0122%\3\2\2\2\u0123\u0124\7\33\2\2\u0124\u0125\7"+
		"\3\2\2\u0125\u0126\5N(\2\u0126\u0127\7\5\2\2\u0127\'\3\2\2\2\u0128\u0129"+
		"\7\34\2\2\u0129\u012a\7\3\2\2\u012a\u012b\5N(\2\u012b\u012c\7\5\2\2\u012c"+
		")\3\2\2\2\u012d\u012e\7\37\2\2\u012e\u012f\7\3\2\2\u012f\u0130\5N(\2\u0130"+
		"\u0131\7\5\2\2\u0131+\3\2\2\2\u0132\u0133\7\36\2\2\u0133\u0134\7\3\2\2"+
		"\u0134\u0135\5N(\2\u0135\u0136\7\5\2\2\u0136-\3\2\2\2\u0137\u0141\5\36"+
		"\20\2\u0138\u0141\5 \21\2\u0139\u0141\5\"\22\2\u013a\u0141\5$\23\2\u013b"+
		"\u0141\5&\24\2\u013c\u0141\5(\25\2\u013d\u0141\5*\26\2\u013e\u0141\5,"+
		"\27\2\u013f\u0141\5\20\t\2\u0140\u0137\3\2\2\2\u0140\u0138\3\2\2\2\u0140"+
		"\u0139\3\2\2\2\u0140\u013a\3\2\2\2\u0140\u013b\3\2\2\2\u0140\u013c\3\2"+
		"\2\2\u0140\u013d\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141"+
		"/\3\2\2\2\u0142\u014a\5.\30\2\u0143\u0144\7\7\2\2\u0144\u014a\5.\30\2"+
		"\u0145\u0146\5\22\n\2\u0146\u0147\5\n\6\2\u0147\u0148\5\22\n\2\u0148\u014a"+
		"\3\2\2\2\u0149\u0142\3\2\2\2\u0149\u0143\3\2\2\2\u0149\u0145\3\2\2\2\u014a"+
		"\61\3\2\2\2\u014b\u014f\5\34\17\2\u014c\u014d\7\7\2\2\u014d\u014f\5\34"+
		"\17\2\u014e\u014b\3\2\2\2\u014e\u014c\3\2\2\2\u014f\63\3\2\2\2\u0150\u0151"+
		"\5\f\7\2\u0151\65\3\2\2\2\u0152\u0153\5\f\7\2\u0153\67\3\2\2\2\u0154\u0155"+
		"\7(\2\2\u0155\u0156\7)\2\2\u0156\u0157\5\66\34\2\u0157\u015c\5<\37\2\u0158"+
		"\u015a\5\u0084C\2\u0159\u015b\5\u0096L\2\u015a\u0159\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u0158\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"9\3\2\2\2\u015e\u015f\5\f\7\2\u015f;\3\2\2\2\u0160\u0161\7*\2\2\u0161"+
		"\u0162\5:\36\2\u0162\u0163\5@!\2\u0163\u016a\3\2\2\2\u0164\u0165\7,\2"+
		"\2\u0165\u0166\5:\36\2\u0166\u0167\7-\2\2\u0167\u0168\5\64\33\2\u0168"+
		"\u016a\3\2\2\2\u0169\u0160\3\2\2\2\u0169\u0164\3\2\2\2\u016a=\3\2\2\2"+
		"\u016b\u016c\5\f\7\2\u016c?\3\2\2\2\u016d\u016f\5B\"\2\u016e\u016d\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"A\3\2\2\2\u0172\u0173\7+\2\2\u0173\u0174\5> \2\u0174\u0175\5D#\2\u0175"+
		"\u0180\3\2\2\2\u0176\u0177\7,\2\2\u0177\u017a\5:\36\2\u0178\u0179\7\13"+
		"\2\2\u0179\u017b\5> \2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c"+
		"\3\2\2\2\u017c\u017d\7-\2\2\u017d\u017e\5\64\33\2\u017e\u0180\3\2\2\2"+
		"\u017f\u0172\3\2\2\2\u017f\u0176\3\2\2\2\u0180C\3\2\2\2\u0181\u0183\5"+
		"F$\2\u0182\u0181\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184"+
		"\u0186\5P)\2\u0185\u0184\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0188\3\2\2"+
		"\2\u0187\u0189\5X-\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018b"+
		"\3\2\2\2\u018a\u018c\5^\60\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u018e\3\2\2\2\u018d\u018f\5p9\2\u018e\u018d\3\2\2\2\u018e\u018f\3\2\2"+
		"\2\u018fE\3\2\2\2\u0190\u0191\7.\2\2\u0191\u0193\7/\2\2\u0192\u0194\5"+
		"H%\2\u0193\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0193\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196G\3\2\2\2\u0197\u0198\5:\36\2\u0198\u0199\7\13\2\2"+
		"\u0199\u019b\3\2\2\2\u019a\u0197\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c"+
		"\3\2\2\2\u019c\u019d\5> \2\u019dI\3\2\2\2\u019e\u019f\7\f\2\2\u019f\u01a0"+
		"\5\b\5\2\u01a0\u01a1\7\r\2\2\u01a1\u01a2\5\b\5\2\u01a2\u01a3\7\16\2\2"+
		"\u01a3K\3\2\2\2\u01a4\u01a8\7P\2\2\u01a5\u01a8\7Q\2\2\u01a6\u01a8\5J&"+
		"\2\u01a7\u01a4\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8M"+
		"\3\2\2\2\u01a9\u01ae\5L\'\2\u01aa\u01ae\7R\2\2\u01ab\u01ae\7S\2\2\u01ac"+
		"\u01ae\5\2\2\2\u01ad\u01a9\3\2\2\2\u01ad\u01aa\3\2\2\2\u01ad\u01ab\3\2"+
		"\2\2\u01ad\u01ac\3\2\2\2\u01aeO\3\2\2\2\u01af\u01b0\7\"\2\2\u01b0\u01b2"+
		"\7&\2\2\u01b1\u01b3\5R*\2\u01b2\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5Q\3\2\2\2\u01b6\u01bb\5\2\2\2"+
		"\u01b7\u01b8\7\4\2\2\u01b8\u01ba\5\2\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bd"+
		"\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd"+
		"\u01bb\3\2\2\2\u01be\u01bf\7\17\2\2\u01bf\u01c4\5N(\2\u01c0\u01c1\7\4"+
		"\2\2\u01c1\u01c3\5N(\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2"+
		"\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7"+
		"\u01c9\5T+\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9S\3\2\2\2\u01ca"+
		"\u01cc\7\60\2\2\u01cb\u01cd\5V,\2\u01cc\u01cb\3\2\2\2\u01cd\u01ce\3\2"+
		"\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cfU\3\2\2\2\u01d0\u01d1"+
		"\5\2\2\2\u01d1\u01dc\7\20\2\2\u01d2\u01d7\5N(\2\u01d3\u01d4\7\4\2\2\u01d4"+
		"\u01d6\5N(\2\u01d5\u01d3\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d5\3\2\2"+
		"\2\u01d7\u01d8\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01db"+
		"\7\27\2\2\u01db\u01dd\3\2\2\2\u01dc\u01d2\3\2\2\2\u01dc\u01dd\3\2\2\2"+
		"\u01dd\u01de\3\2\2\2\u01de\u01df\5N(\2\u01dfW\3\2\2\2\u01e0\u01e1\7\62"+
		"\2\2\u01e1\u01e3\7&\2\2\u01e2\u01e4\5Z.\2\u01e3\u01e2\3\2\2\2\u01e4\u01e5"+
		"\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6Y\3\2\2\2\u01e7"+
		"\u01ec\5\16\b\2\u01e8\u01e9\7\4\2\2\u01e9\u01eb\5\16\b\2\u01ea\u01e8\3"+
		"\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed"+
		"\u01ef\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f0\7\20\2\2\u01f0\u01f5\5"+
		"N(\2\u01f1\u01f2\7\4\2\2\u01f2\u01f4\5N(\2\u01f3\u01f1\3\2\2\2\u01f4\u01f7"+
		"\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6[\3\2\2\2\u01f7"+
		"\u01f5\3\2\2\2\u01f8\u01f9\7T\2\2\u01f9]\3\2\2\2\u01fa\u01fb\7%\2\2\u01fb"+
		"\u01fd\7&\2\2\u01fc\u01fe\5`\61\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe\3\2"+
		"\2\2\u01fe\u0200\3\2\2\2\u01ff\u0201\5b\62\2\u0200\u01ff\3\2\2\2\u0200"+
		"\u0201\3\2\2\2\u0201_\3\2\2\2\u0202\u0204\7\63\2\2\u0203\u0205\5d\63\2"+
		"\u0204\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0207\3\2\2\2\u0206\u0208"+
		"\5f\64\2\u0207\u0206\3\2\2\2\u0207\u0208\3\2\2\2\u0208a\3\2\2\2\u0209"+
		"\u020b\7\64\2\2\u020a\u020c\5d\63\2\u020b\u020a\3\2\2\2\u020b\u020c\3"+
		"\2\2\2\u020c\u020e\3\2\2\2\u020d\u020f\5f\64\2\u020e\u020d\3\2\2\2\u020e"+
		"\u020f\3\2\2\2\u020fc\3\2\2\2\u0210\u0212\7\65\2\2\u0211\u0213\5h\65\2"+
		"\u0212\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215"+
		"\3\2\2\2\u0215e\3\2\2\2\u0216\u0218\7\66\2\2\u0217\u0219\5h\65\2\u0218"+
		"\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2"+
		"\2\2\u021bg\3\2\2\2\u021c\u021e\7\67\2\2\u021d\u021c\3\2\2\2\u021d\u021e"+
		"\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\5\\/\2\u0220\u0221\7\20\2\2\u0221"+
		"\u022b\5N(\2\u0222\u0223\7\b\2\2\u0223\u0225\5N(\2\u0224\u0222\3\2\2\2"+
		"\u0225\u0228\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0229"+
		"\3\2\2\2\u0228\u0226\3\2\2\2\u0229\u022a\7\27\2\2\u022a\u022c\5N(\2\u022b"+
		"\u0226\3\2\2\2\u022b\u022c\3\2\2\2\u022ci\3\2\2\2\u022d\u022e\5\20\t\2"+
		"\u022e\u022f\7\23\2\2\u022f\u0230\5\22\n\2\u0230\u0235\3\2\2\2\u0231\u0235"+
		"\5\20\t\2\u0232\u0233\7\7\2\2\u0233\u0235\5\20\t\2\u0234\u022d\3\2\2\2"+
		"\u0234\u0231\3\2\2\2\u0234\u0232\3\2\2\2\u0235k\3\2\2\2\u0236\u0237\5"+
		"\20\t\2\u0237\u0238\7\24\2\2\u0238\u0239\5\22\n\2\u0239m\3\2\2\2\u023a"+
		"\u023d\5j\66\2\u023b\u023d\5l\67\2\u023c\u023a\3\2\2\2\u023c\u023b\3\2"+
		"\2\2\u023do\3\2\2\2\u023e\u0245\78\2\2\u023f\u0244\5r:\2\u0240\u0244\5"+
		"t;\2\u0241\u0244\5v<\2\u0242\u0244\5x=\2\u0243\u023f\3\2\2\2\u0243\u0240"+
		"\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0242\3\2\2\2\u0244\u0247\3\2\2\2\u0245"+
		"\u0243\3\2\2\2\u0245\u0246\3\2\2\2\u0246q\3\2\2\2\u0247\u0245\3\2\2\2"+
		"\u0248\u0249\79\2\2\u0249\u024a\7:\2\2\u024a\u024c\7;\2\2\u024b\u024d"+
		"\5z>\2\u024c\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024c\3\2\2\2\u024e"+
		"\u024f\3\2\2\2\u024fs\3\2\2\2\u0250\u0251\7<\2\2\u0251\u0253\7=\2\2\u0252"+
		"\u0254\5|?\2\u0253\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0253\3\2\2"+
		"\2\u0255\u0256\3\2\2\2\u0256u\3\2\2\2\u0257\u0258\7#\2\2\u0258\u025a\7"+
		"$\2\2\u0259\u025b\5~@\2\u025a\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025dw\3\2\2\2\u025e\u025f\7%\2\2\u025f"+
		"\u0261\7\'\2\2\u0260\u0262\5\u0080A\2\u0261\u0260\3\2\2\2\u0262\u0263"+
		"\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0264\3\2\2\2\u0264y\3\2\2\2\u0265"+
		"\u0266\5\34\17\2\u0266\u0267\7>\2\2\u0267\u0268\5j\66\2\u0268\u0269\7"+
		"@\2\2\u0269\u026e\5\36\20\2\u026a\u026b\7\4\2\2\u026b\u026d\5\60\31\2"+
		"\u026c\u026a\3\2\2\2\u026d\u0270\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f"+
		"\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u026e\3\2\2\2\u0271\u0272\7\13\2\2"+
		"\u0272{\3\2\2\2\u0273\u0274\7?\2\2\u0274\u0275\5\34\17\2\u0275\u0276\7"+
		"@\2\2\u0276\u027e\5\36\20\2\u0277\u027a\7\4\2\2\u0278\u027b\5\62\32\2"+
		"\u0279\u027b\5\60\31\2\u027a\u0278\3\2\2\2\u027a\u0279\3\2\2\2\u027b\u027d"+
		"\3\2\2\2\u027c\u0277\3\2\2\2\u027d\u0280\3\2\2\2\u027e\u027c\3\2\2\2\u027e"+
		"\u027f\3\2\2\2\u027f\u0281\3\2\2\2\u0280\u027e\3\2\2\2\u0281\u0282\7\13"+
		"\2\2\u0282}\3\2\2\2\u0283\u0284\5n8\2\u0284\u0285\7\13\2\2\u0285\u0296"+
		"\3\2\2\2\u0286\u0289\7A\2\2\u0287\u0289\5n8\2\u0288\u0286\3\2\2\2\u0288"+
		"\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b\7@\2\2\u028b\u0290\5\60"+
		"\31\2\u028c\u028d\7\4\2\2\u028d\u028f\5\60\31\2\u028e\u028c\3\2\2\2\u028f"+
		"\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0293\3\2"+
		"\2\2\u0292\u0290\3\2\2\2\u0293\u0294\7\13\2\2\u0294\u0296\3\2\2\2\u0295"+
		"\u0283\3\2\2\2\u0295\u0288\3\2\2\2\u0296\177\3\2\2\2\u0297\u0298\5\20"+
		"\t\2\u0298\u0299\7\13\2\2\u0299\u02a7\3\2\2\2\u029a\u029b\5\20\t\2\u029b"+
		"\u029c\7@\2\2\u029c\u02a1\5\60\31\2\u029d\u029e\7\4\2\2\u029e\u02a0\5"+
		"\60\31\2\u029f\u029d\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1"+
		"\u02a2\3\2\2\2\u02a2\u02a4\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02a5\7\13"+
		"\2\2\u02a5\u02a7\3\2\2\2\u02a6\u0297\3\2\2\2\u02a6\u029a\3\2\2\2\u02a7"+
		"\u0081\3\2\2\2\u02a8\u02a9\5\f\7\2\u02a9\u0083\3\2\2\2\u02aa\u02ab\7C"+
		"\2\2\u02ab\u02b1\5\u0082B\2\u02ac\u02b0\5\u0086D\2\u02ad\u02b0\5\u008a"+
		"F\2\u02ae\u02b0\5\u0092J\2\u02af\u02ac\3\2\2\2\u02af\u02ad\3\2\2\2\u02af"+
		"\u02ae\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1\u02af\3\2\2\2\u02b1\u02b2\3\2"+
		"\2\2\u02b2\u0085\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b4\u02b5\7\62\2\2\u02b5"+
		"\u02b7\7\'\2\2\u02b6\u02b8\5\u0088E\2\u02b7\u02b6\3\2\2\2\u02b8\u02b9"+
		"\3\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u0087\3\2\2\2\u02bb"+
		"\u02bc\5\16\b\2\u02bc\u02bd\7\23\2\2\u02bd\u02be\5\22\n\2\u02be\u0089"+
		"\3\2\2\2\u02bf\u02c1\7H\2\2\u02c0\u02c2\5\u008cG\2\u02c1\u02c0\3\2\2\2"+
		"\u02c2\u02c3\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u008b"+
		"\3\2\2\2\u02c5\u02ca\5\16\b\2\u02c6\u02c7\7\4\2\2\u02c7\u02c9\5\16\b\2"+
		"\u02c8\u02c6\3\2\2\2\u02c9\u02cc\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb"+
		"\3\2\2\2\u02cb\u02cd\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cd\u02ce\7D\2\2\u02ce"+
		"\u02d3\5N(\2\u02cf\u02d0\7\4\2\2\u02d0\u02d2\5N(\2\u02d1\u02cf\3\2\2\2"+
		"\u02d2\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02df"+
		"\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d6\u02d7\7E\2\2\u02d7\u02dc\5\60\31\2"+
		"\u02d8\u02d9\7\4\2\2\u02d9\u02db\5\60\31\2\u02da\u02d8\3\2\2\2\u02db\u02de"+
		"\3\2\2\2\u02dc\u02da\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de"+
		"\u02dc\3\2\2\2\u02df\u02d6\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e1\3\2"+
		"\2\2\u02e1\u02e2\5\u008eH\2\u02e2\u008d\3\2\2\2\u02e3\u02e5\5\u0090I\2"+
		"\u02e4\u02e3\3\2\2\2\u02e5\u02e8\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e6\u02e7"+
		"\3\2\2\2\u02e7\u008f\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e9\u02ea\5\20\t\2"+
		"\u02ea\u02eb\7\23\2\2\u02eb\u02ec\5\22\n\2\u02ec\u0091\3\2\2\2\u02ed\u02ee"+
		"\7F\2\2\u02ee\u02ef\7G\2\2\u02ef\u02f1\7\63\2\2\u02f0\u02f2\5\u0094K\2"+
		"\u02f1\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3\u02f4"+
		"\3\2\2\2\u02f4\u0093\3\2\2\2\u02f5\u02ff\5n8\2\u02f6\u02f7\7@\2\2\u02f7"+
		"\u02fc\5\60\31\2\u02f8\u02f9\7\4\2\2\u02f9\u02fb\5\60\31\2\u02fa\u02f8"+
		"\3\2\2\2\u02fb\u02fe\3\2\2\2\u02fc\u02fa\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd"+
		"\u0300\3\2\2\2\u02fe\u02fc\3\2\2\2\u02ff\u02f6\3\2\2\2\u02ff\u0300\3\2"+
		"\2\2\u0300\u0301\3\2\2\2\u0301\u0302\7\13\2\2\u0302\u0095\3\2\2\2\u0303"+
		"\u0304\5\u0098M\2\u0304\u0097\3\2\2\2\u0305\u0306\7I\2\2\u0306\u0307\7"+
		"J\2\2\u0307\u0308\5\u009aN\2\u0308\u0309\5\u009cO\2\u0309\u0099\3\2\2"+
		"\2\u030a\u030b\7K\2\2\u030b\u030c\7L\2\2\u030c\u030d\7V\2\2\u030d\u009b"+
		"\3\2\2\2\u030e\u0311\7M\2\2\u030f\u0312\5\u009eP\2\u0310\u0312\5\u00a0"+
		"Q\2\u0311\u030f\3\2\2\2\u0311\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313"+
		"\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u009d\3\2\2\2\u0315\u0316\7N"+
		"\2\2\u0316\u0317\7\3\2\2\u0317\u0318\5\20\t\2\u0318\u0319\7\4\2\2\u0319"+
		"\u031a\5\22\n\2\u031a\u031b\7\4\2\2\u031b\u031c\5\6\4\2\u031c\u031d\7"+
		"\5\2\2\u031d\u009f\3\2\2\2\u031e\u031f\7O\2\2\u031f\u0320\7\3\2\2\u0320"+
		"\u0321\5\16\b\2\u0321\u0322\7\4\2\2\u0322\u0323\5\6\4\2\u0323\u0324\7"+
		"\5\2\2\u0324\u00a1\3\2\2\2R\u00ae\u00b7\u00bc\u00c6\u00ca\u00d5\u00d7"+
		"\u00e0\u00eb\u00ed\u0100\u0140\u0149\u014e\u015a\u015c\u0169\u0170\u017a"+
		"\u017f\u0182\u0185\u0188\u018b\u018e\u0195\u019a\u01a7\u01ad\u01b4\u01bb"+
		"\u01c4\u01c8\u01ce\u01d7\u01dc\u01e5\u01ec\u01f5\u01fd\u0200\u0204\u0207"+
		"\u020b\u020e\u0214\u021a\u021d\u0226\u022b\u0234\u023c\u0243\u0245\u024e"+
		"\u0255\u025c\u0263\u026e\u027a\u027e\u0288\u0290\u0295\u02a1\u02a6\u02af"+
		"\u02b1\u02b9\u02c3\u02ca\u02d3\u02dc\u02df\u02e6\u02f3\u02fc\u02ff\u0311"+
		"\u0313";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}