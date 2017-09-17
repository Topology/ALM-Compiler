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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		WhiteSpace=60, BOOL=61, EQ=62, NEQ=63, ARITH_OP=64, COMP_REL=65, RIGHT_ARROW=66, 
		OCCURS=67, INSTANCE=68, IS_A=69, HAS_CHILD=70, HAS_PARENT=71, LINK=72, 
		SOURCE=73, SINK=74, SUBSORT=75, DOM=76, BOOLEAN=77, INTEGERS=78, UNIVERSE=79, 
		ACTIONS=80, ID=81, VAR=82, POSINT=83, NEGINT=84, ZERO=85;
	public static final int
		RULE_nat_num = 0, RULE_integer = 1, RULE_relation = 2, RULE_alm_name = 3, 
		RULE_object_constant = 4, RULE_function_term = 5, RULE_term = 6, RULE_var_or_obj = 7, 
		RULE_expression = 8, RULE_arithmetic_term = 9, RULE_factor = 10, RULE_occurs_atom = 11, 
		RULE_instance_atom = 12, RULE_is_a_atom = 13, RULE_link_atom = 14, RULE_subsort_atom = 15, 
		RULE_has_child_atom = 16, RULE_has_parent_atom = 17, RULE_sink_atom = 18, 
		RULE_source_atom = 19, RULE_atom = 20, RULE_literal = 21, RULE_occurs_literal = 22, 
		RULE_library_name = 23, RULE_sys_desc_name = 24, RULE_system_description = 25, 
		RULE_theory_name = 26, RULE_theory = 27, RULE_module_name = 28, RULE_sequence_of_modules = 29, 
		RULE_module = 30, RULE_module_body = 31, RULE_integer_range = 32, RULE_predefined_sorts = 33, 
		RULE_sort_name = 34, RULE_sort_declarations = 35, RULE_one_sort_decl = 36, 
		RULE_attributes = 37, RULE_one_attribute_decl = 38, RULE_constant_declarations = 39, 
		RULE_one_constant_decl = 40, RULE_function_name = 41, RULE_function_declarations = 42, 
		RULE_static_declarations = 43, RULE_fluent_declarations = 44, RULE_basic_function_declarations = 45, 
		RULE_defined_function_declarations = 46, RULE_one_function_decl = 47, 
		RULE_pos_fun_def = 48, RULE_neg_fun_def = 49, RULE_fun_def = 50, RULE_axioms = 51, 
		RULE_dynamic_causal_laws = 52, RULE_executability_conditions = 53, RULE_state_constraints = 54, 
		RULE_definitions = 55, RULE_one_dynamic_causal_law = 56, RULE_one_executability_condition = 57, 
		RULE_one_state_constraint = 58, RULE_one_definition = 59, RULE_structure_name = 60, 
		RULE_structure = 61, RULE_constant_defs = 62, RULE_one_constant_def = 63, 
		RULE_instance_defs = 64, RULE_one_instance_def = 65, RULE_attribute_defs = 66, 
		RULE_one_attribute_def = 67, RULE_statics_defs = 68, RULE_one_static_def = 69, 
		RULE_solver_mode = 70, RULE_temporal_projection = 71, RULE_max_steps = 72, 
		RULE_history = 73, RULE_observed = 74, RULE_happened = 75;
	public static final String[] ruleNames = {
		"nat_num", "integer", "relation", "alm_name", "object_constant", "function_term", 
		"term", "var_or_obj", "expression", "arithmetic_term", "factor", "occurs_atom", 
		"instance_atom", "is_a_atom", "link_atom", "subsort_atom", "has_child_atom", 
		"has_parent_atom", "sink_atom", "source_atom", "atom", "literal", "occurs_literal", 
		"library_name", "sys_desc_name", "system_description", "theory_name", 
		"theory", "module_name", "sequence_of_modules", "module", "module_body", 
		"integer_range", "predefined_sorts", "sort_name", "sort_declarations", 
		"one_sort_decl", "attributes", "one_attribute_decl", "constant_declarations", 
		"one_constant_decl", "function_name", "function_declarations", "static_declarations", 
		"fluent_declarations", "basic_function_declarations", "defined_function_declarations", 
		"one_function_decl", "pos_fun_def", "neg_fun_def", "fun_def", "axioms", 
		"dynamic_causal_laws", "executability_conditions", "state_constraints", 
		"definitions", "one_dynamic_causal_law", "one_executability_condition", 
		"one_state_constraint", "one_definition", "structure_name", "structure", 
		"constant_defs", "one_constant_def", "instance_defs", "one_instance_def", 
		"attribute_defs", "one_attribute_def", "statics_defs", "one_static_def", 
		"solver_mode", "temporal_projection", "max_steps", "history", "observed", 
		"happened"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'^'", 
		"'system'", "'description'", "'theory'", "'import'", "'from'", "'module'", 
		"'.'", "'['", "'..'", "']'", "'sort'", "'declarations'", "'::'", "'attributes'", 
		"':'", "'object'", "'constants'", "'function'", "'statics'", "'fluents'", 
		"'basic'", "'defined'", "'total'", "'axioms'", "'dynamic'", "'causal'", 
		"'laws'", "'executability'", "'conditions'", "'state'", "'constraints'", 
		"'definitions'", "'causes'", "'if'", "'impossible'", "'false'", "'structure'", 
		"'constant'", "'instances'", "'in'", "'where'", "'value'", "'of'", "'temporal'", 
		"'projection'", "'max'", "'steps'", "'history'", "'observed'", "'happened'", 
		null, null, "'='", "'!='", null, null, "'->'", "'occurs'", "'instance'", 
		"'is_a'", "'has_child'", "'has_parent'", "'link'", "'source'", "'sink'", 
		"'subsort'", "'DOM'", "'booleans'", "'integers'", "'universe'", "'actions'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"WhiteSpace", "BOOL", "EQ", "NEQ", "ARITH_OP", "COMP_REL", "RIGHT_ARROW", 
		"OCCURS", "INSTANCE", "IS_A", "HAS_CHILD", "HAS_PARENT", "LINK", "SOURCE", 
		"SINK", "SUBSORT", "DOM", "BOOLEAN", "INTEGERS", "UNIVERSE", "ACTIONS", 
		"ID", "VAR", "POSINT", "NEGINT", "ZERO"
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
		enterRule(_localctx, 0, RULE_nat_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
		enterRule(_localctx, 2, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (POSINT - 83)) | (1L << (NEGINT - 83)) | (1L << (ZERO - 83)))) != 0)) ) {
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
		enterRule(_localctx, 4, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (EQ - 62)) | (1L << (NEQ - 62)) | (1L << (COMP_REL - 62)))) != 0)) ) {
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
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
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
		enterRule(_localctx, 6, RULE_alm_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==VAR) ) {
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

	public static class Object_constantContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
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
		enterRule(_localctx, 8, RULE_object_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(ID);
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(161);
				match(T__0);
				setState(162);
				term();
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(163);
					match(T__1);
					setState(164);
					term();
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(170);
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
		enterRule(_localctx, 10, RULE_function_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
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
		public TerminalNode BOOL() { return getToken(ALMParser.BOOL, 0); }
		public TerminalNode VAR() { return getToken(ALMParser.VAR, 0); }
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
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
		enterRule(_localctx, 12, RULE_term);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(BOOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				integer();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
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
		enterRule(_localctx, 14, RULE_var_or_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(184);
				object_constant();
				}
				break;
			case VAR:
				{
				setState(185);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(189);
			arithmetic_term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(192);
						match(T__3);
						setState(193);
						arithmetic_term(0);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(195);
						match(T__4);
						setState(196);
						arithmetic_term(0);
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_arithmetic_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(203);
				factor();
				setState(204);
				match(T__8);
				setState(205);
				factor();
				}
				break;
			case 2:
				{
				setState(207);
				factor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(219);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(210);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(211);
						match(T__5);
						setState(212);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(213);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(214);
						match(T__6);
						setState(215);
						factor();
						}
						break;
					case 3:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(216);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(217);
						match(T__7);
						setState(218);
						factor();
						}
						break;
					}
					} 
				}
				setState(223);
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
		enterRule(_localctx, 20, RULE_factor);
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(T__4);
				setState(226);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				integer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				function_term();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(229);
				match(T__4);
				setState(230);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(231);
				match(T__0);
				setState(232);
				expression(0);
				setState(233);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(235);
				match(T__4);
				setState(236);
				match(T__0);
				setState(237);
				expression(0);
				setState(238);
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
		enterRule(_localctx, 22, RULE_occurs_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(OCCURS);
			setState(243);
			match(T__0);
			setState(244);
			var_or_obj();
			setState(245);
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
		enterRule(_localctx, 24, RULE_instance_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(INSTANCE);
			setState(248);
			match(T__0);
			setState(249);
			var_or_obj();
			setState(250);
			match(T__1);
			setState(251);
			sort_name();
			setState(252);
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
		enterRule(_localctx, 26, RULE_is_a_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(IS_A);
			setState(255);
			match(T__0);
			setState(256);
			var_or_obj();
			setState(257);
			match(T__1);
			setState(258);
			sort_name();
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
		enterRule(_localctx, 28, RULE_link_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(LINK);
			setState(262);
			match(T__0);
			setState(263);
			sort_name();
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
		enterRule(_localctx, 30, RULE_subsort_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(SUBSORT);
			setState(269);
			match(T__0);
			setState(270);
			sort_name();
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
		enterRule(_localctx, 32, RULE_has_child_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(HAS_CHILD);
			setState(276);
			match(T__0);
			setState(277);
			sort_name();
			setState(278);
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
		enterRule(_localctx, 34, RULE_has_parent_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(HAS_PARENT);
			setState(281);
			match(T__0);
			setState(282);
			sort_name();
			setState(283);
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
		enterRule(_localctx, 36, RULE_sink_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(SINK);
			setState(286);
			match(T__0);
			setState(287);
			sort_name();
			setState(288);
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
		enterRule(_localctx, 38, RULE_source_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(SOURCE);
			setState(291);
			match(T__0);
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
		enterRule(_localctx, 40, RULE_atom);
		try {
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INSTANCE:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				instance_atom();
				}
				break;
			case IS_A:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				is_a_atom();
				}
				break;
			case LINK:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				link_atom();
				}
				break;
			case SUBSORT:
				enterOuterAlt(_localctx, 4);
				{
				setState(298);
				subsort_atom();
				}
				break;
			case HAS_CHILD:
				enterOuterAlt(_localctx, 5);
				{
				setState(299);
				has_child_atom();
				}
				break;
			case HAS_PARENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(300);
				has_parent_atom();
				}
				break;
			case SINK:
				enterOuterAlt(_localctx, 7);
				{
				setState(301);
				sink_atom();
				}
				break;
			case SOURCE:
				enterOuterAlt(_localctx, 8);
				{
				setState(302);
				source_atom();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 9);
				{
				setState(303);
				function_term();
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
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(T__4);
				setState(308);
				atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				term();
				setState(310);
				relation();
				setState(311);
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
		enterRule(_localctx, 44, RULE_occurs_literal);
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OCCURS:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				occurs_atom();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				match(T__4);
				setState(317);
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
		enterRule(_localctx, 46, RULE_library_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
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
		enterRule(_localctx, 48, RULE_sys_desc_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
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
		enterRule(_localctx, 50, RULE_system_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(T__9);
			setState(325);
			match(T__10);
			setState(326);
			sys_desc_name();
			setState(327);
			theory();
			setState(328);
			structure();
			setState(329);
			solver_mode();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 52, RULE_theory_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
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
		public Theory_nameContext theory_name() {
			return getRuleContext(Theory_nameContext.class,0);
		}
		public Sequence_of_modulesContext sequence_of_modules() {
			return getRuleContext(Sequence_of_modulesContext.class,0);
		}
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
		enterRule(_localctx, 54, RULE_theory);
		try {
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(333);
				match(T__11);
				setState(334);
				theory_name();
				setState(335);
				sequence_of_modules();
				}
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(337);
				match(T__12);
				setState(338);
				theory_name();
				setState(339);
				match(T__13);
				setState(340);
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
		enterRule(_localctx, 56, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
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
		enterRule(_localctx, 58, RULE_sequence_of_modules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(346);
				module();
				}
				}
				setState(349); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 || _la==T__14 );
			}
		}
		catch (RecognitionException re) {
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
		public Module_nameContext module_name() {
			return getRuleContext(Module_nameContext.class,0);
		}
		public Module_bodyContext module_body() {
			return getRuleContext(Module_bodyContext.class,0);
		}
		public Theory_nameContext theory_name() {
			return getRuleContext(Theory_nameContext.class,0);
		}
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
		enterRule(_localctx, 60, RULE_module);
		try {
			setState(362);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(351);
				match(T__14);
				setState(352);
				module_name();
				setState(353);
				module_body();
				}
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(355);
				match(T__12);
				setState(356);
				theory_name();
				setState(357);
				match(T__15);
				setState(358);
				module_name();
				setState(359);
				match(T__13);
				setState(360);
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
		enterRule(_localctx, 62, RULE_module_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(364);
				sort_declarations();
				}
			}

			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(367);
				constant_declarations();
				}
			}

			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(370);
				function_declarations();
				}
			}

			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(373);
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
		enterRule(_localctx, 64, RULE_integer_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(T__16);
			setState(377);
			integer();
			setState(378);
			match(T__17);
			setState(379);
			integer();
			setState(380);
			match(T__18);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_predefined_sorts);
		try {
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				match(BOOLEAN);
				}
				break;
			case INTEGERS:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				match(INTEGERS);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(384);
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
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
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
		enterRule(_localctx, 68, RULE_sort_name);
		try {
			setState(391);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
			case BOOLEAN:
			case INTEGERS:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				predefined_sorts();
				}
				break;
			case UNIVERSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				match(UNIVERSE);
				}
				break;
			case ACTIONS:
				enterOuterAlt(_localctx, 3);
				{
				setState(389);
				match(ACTIONS);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				match(ID);
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

	public static class Sort_declarationsContext extends ParserRuleContext {
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
		enterRule(_localctx, 70, RULE_sort_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(T__19);
			setState(394);
			match(T__20);
			setState(396); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(395);
				one_sort_decl();
				}
				}
				setState(398); 
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

	public static class One_sort_declContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ALMParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ALMParser.ID, i);
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
		enterRule(_localctx, 72, RULE_one_sort_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(ID);
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(401);
				match(T__1);
				setState(402);
				match(ID);
				}
				}
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(408);
			match(T__21);
			setState(409);
			sort_name();
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(410);
				match(T__1);
				setState(411);
				sort_name();
				}
				}
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(417);
				attributes();
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

	public static class AttributesContext extends ParserRuleContext {
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
		enterRule(_localctx, 74, RULE_attributes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			match(T__22);
			setState(422); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(421);
					one_attribute_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(424); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		public TerminalNode ID() { return getToken(ALMParser.ID, 0); }
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
		enterRule(_localctx, 76, RULE_one_attribute_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(ID);
			setState(427);
			match(T__23);
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(428);
				sort_name();
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(429);
					match(T__1);
					setState(430);
					sort_name();
					}
					}
					setState(435);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(436);
				match(RIGHT_ARROW);
				}
				break;
			}
			setState(440);
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
		enterRule(_localctx, 78, RULE_constant_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(T__24);
			setState(443);
			match(T__25);
			setState(445); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(444);
				one_constant_decl();
				}
				}
				setState(447); 
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
		enterRule(_localctx, 80, RULE_one_constant_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			object_constant();
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(450);
				match(T__1);
				setState(451);
				object_constant();
				}
				}
				setState(456);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(457);
			match(T__23);
			setState(458);
			sort_name();
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(459);
				match(T__1);
				setState(460);
				sort_name();
				}
				}
				setState(465);
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
		enterRule(_localctx, 82, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
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
		enterRule(_localctx, 84, RULE_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(T__26);
			setState(469);
			match(T__20);
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(470);
				static_declarations();
				}
			}

			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(473);
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
		enterRule(_localctx, 86, RULE_static_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(T__27);
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(477);
				basic_function_declarations();
				}
			}

			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(480);
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
		enterRule(_localctx, 88, RULE_fluent_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(T__28);
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(484);
				basic_function_declarations();
				}
			}

			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(487);
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
		enterRule(_localctx, 90, RULE_basic_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(T__29);
			setState(492); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(491);
				one_function_decl();
				}
				}
				setState(494); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__31 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 92, RULE_defined_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(T__30);
			setState(498); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(497);
				one_function_decl();
				}
				}
				setState(500); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__31 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_one_function_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(502);
				match(T__31);
				}
			}

			setState(505);
			function_name();
			setState(506);
			match(T__23);
			setState(507);
			sort_name();
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==RIGHT_ARROW) {
				{
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(508);
					match(T__5);
					setState(509);
					sort_name();
					}
					}
					setState(514);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(515);
				match(RIGHT_ARROW);
				setState(516);
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
		enterRule(_localctx, 96, RULE_pos_fun_def);
		try {
			setState(526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				function_term();
				setState(520);
				match(EQ);
				setState(521);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				function_term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(524);
				match(T__4);
				setState(525);
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
		enterRule(_localctx, 98, RULE_neg_fun_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			function_term();
			setState(529);
			match(NEQ);
			setState(530);
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
		enterRule(_localctx, 100, RULE_fun_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(532);
				pos_fun_def();
				}
				break;
			case 2:
				{
				setState(533);
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
		enterRule(_localctx, 102, RULE_axioms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			match(T__32);
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__33) | (1L << T__36) | (1L << T__38))) != 0)) {
				{
				setState(541);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__33:
					{
					setState(537);
					dynamic_causal_laws();
					}
					break;
				case T__36:
					{
					setState(538);
					executability_conditions();
					}
					break;
				case T__38:
					{
					setState(539);
					state_constraints();
					}
					break;
				case T__26:
					{
					setState(540);
					definitions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(545);
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
		enterRule(_localctx, 104, RULE_dynamic_causal_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(T__33);
			setState(547);
			match(T__34);
			setState(548);
			match(T__35);
			setState(550); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(549);
				one_dynamic_causal_law();
				}
				}
				setState(552); 
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
		enterRule(_localctx, 106, RULE_executability_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(T__36);
			setState(555);
			match(T__37);
			setState(557); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(556);
				one_executability_condition();
				}
				}
				setState(559); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__43 );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 108, RULE_state_constraints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(T__38);
			setState(562);
			match(T__39);
			setState(564); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(563);
				one_state_constraint();
				}
				}
				setState(566); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 || _la==T__44 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 110, RULE_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			match(T__26);
			setState(569);
			match(T__40);
			setState(571); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(570);
				one_definition();
				}
				}
				setState(573); 
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

	public static class One_dynamic_causal_lawContext extends ParserRuleContext {
		public Occurs_atomContext occurs_atom() {
			return getRuleContext(Occurs_atomContext.class,0);
		}
		public Pos_fun_defContext pos_fun_def() {
			return getRuleContext(Pos_fun_defContext.class,0);
		}
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
		enterRule(_localctx, 112, RULE_one_dynamic_causal_law);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			occurs_atom();
			setState(576);
			match(T__41);
			setState(577);
			pos_fun_def();
			setState(578);
			match(T__42);
			setState(579);
			instance_atom();
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(580);
				match(T__1);
				setState(581);
				literal();
				}
				}
				setState(586);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(587);
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

	public static class One_executability_conditionContext extends ParserRuleContext {
		public Occurs_atomContext occurs_atom() {
			return getRuleContext(Occurs_atomContext.class,0);
		}
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
		enterRule(_localctx, 114, RULE_one_executability_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(T__43);
			setState(590);
			occurs_atom();
			setState(591);
			match(T__42);
			setState(592);
			instance_atom();
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(593);
				match(T__1);
				setState(596);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(594);
					occurs_literal();
					}
					break;
				case 2:
					{
					setState(595);
					literal();
					}
					break;
				}
				}
				}
				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(603);
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

	public static class One_state_constraintContext extends ParserRuleContext {
		public Fun_defContext fun_def() {
			return getRuleContext(Fun_defContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
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
		enterRule(_localctx, 116, RULE_one_state_constraint);
		int _la;
		try {
			setState(623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(605);
				fun_def();
				setState(606);
				match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(610);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__44:
					{
					setState(608);
					match(T__44);
					}
					break;
				case T__4:
				case ID:
					{
					setState(609);
					fun_def();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(612);
				match(T__42);
				setState(613);
				literal();
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(614);
					match(T__1);
					setState(615);
					literal();
					}
					}
					setState(620);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(621);
				match(T__15);
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
		enterRule(_localctx, 118, RULE_one_definition);
		int _la;
		try {
			setState(640);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(625);
				function_term();
				setState(626);
				match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(628);
				function_term();
				setState(629);
				match(T__42);
				setState(630);
				literal();
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(631);
					match(T__1);
					setState(632);
					literal();
					}
					}
					setState(637);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(638);
				match(T__15);
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
		enterRule(_localctx, 120, RULE_structure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
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
		enterRule(_localctx, 122, RULE_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			match(T__45);
			setState(645);
			structure_name();
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__50))) != 0)) {
				{
				setState(649);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__46:
					{
					setState(646);
					constant_defs();
					}
					break;
				case T__47:
					{
					setState(647);
					instance_defs();
					}
					break;
				case T__50:
					{
					setState(648);
					statics_defs();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(653);
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
		enterRule(_localctx, 124, RULE_constant_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			match(T__46);
			setState(655);
			match(T__40);
			setState(657); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(656);
				one_constant_def();
				}
				}
				setState(659); 
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
		enterRule(_localctx, 126, RULE_one_constant_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			object_constant();
			setState(662);
			match(EQ);
			setState(663);
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
		enterRule(_localctx, 128, RULE_instance_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			match(T__47);
			setState(667); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(666);
				one_instance_def();
				}
				}
				setState(669); 
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

	public static class One_instance_defContext extends ParserRuleContext {
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
		enterRule(_localctx, 130, RULE_one_instance_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			object_constant();
			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(672);
				match(T__1);
				setState(673);
				object_constant();
				}
				}
				setState(678);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(679);
			match(T__48);
			setState(680);
			sort_name();
			setState(685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(681);
				match(T__1);
				setState(682);
				sort_name();
				}
				}
				setState(687);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__49) {
				{
				setState(688);
				match(T__49);
				setState(689);
				literal();
				setState(694);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(690);
					match(T__1);
					setState(691);
					literal();
					}
					}
					setState(696);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(699);
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
		enterRule(_localctx, 132, RULE_attribute_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(701);
					one_attribute_def();
					}
					} 
				}
				setState(706);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
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
		enterRule(_localctx, 134, RULE_one_attribute_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			function_term();
			setState(708);
			match(EQ);
			setState(709);
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
		enterRule(_localctx, 136, RULE_statics_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711);
			match(T__50);
			setState(712);
			match(T__51);
			setState(713);
			match(T__27);
			setState(715); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(714);
				one_static_def();
				}
				}
				setState(717); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_one_static_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			fun_def();
			setState(729);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__42) {
				{
				setState(720);
				match(T__42);
				setState(721);
				literal();
				setState(726);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(722);
					match(T__1);
					setState(723);
					literal();
					}
					}
					setState(728);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(731);
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
		enterRule(_localctx, 140, RULE_solver_mode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__52) {
				{
				setState(733);
				temporal_projection();
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

	public static class Temporal_projectionContext extends ParserRuleContext {
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
		enterRule(_localctx, 142, RULE_temporal_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
			match(T__52);
			setState(737);
			match(T__53);
			setState(738);
			max_steps();
			setState(739);
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
		enterRule(_localctx, 144, RULE_max_steps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741);
			match(T__54);
			setState(742);
			match(T__55);
			setState(743);
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
		enterRule(_localctx, 146, RULE_history);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			match(T__56);
			setState(748); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(748);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(746);
					observed();
					}
					break;
				case T__58:
					{
					setState(747);
					happened();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(750); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__57 || _la==T__58 );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_observed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(752);
			match(T__57);
			setState(753);
			match(T__0);
			setState(754);
			function_term();
			setState(755);
			match(T__1);
			setState(756);
			term();
			setState(757);
			match(T__1);
			setState(758);
			nat_num();
			setState(759);
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
		enterRule(_localctx, 150, RULE_happened);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			match(T__58);
			setState(762);
			match(T__0);
			setState(763);
			object_constant();
			setState(764);
			match(T__1);
			setState(765);
			nat_num();
			setState(766);
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
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 9:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3W\u0303\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\7\6\u00a8\n\6\f\6\16\6\u00ab\13\6\3\6\3\6\5\6\u00af\n\6\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00b9\n\b\3\t\3\t\5\t\u00bd\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00c8\n\n\f\n\16\n\u00cb\13\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00d3\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00de\n\13\f\13\16\13\u00e1\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f3\n\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0133\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u013c\n\27\3\30\3\30\3\30\5\30\u0141\n\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u0159\n\35\3\36\3\36\3\37\6\37\u015e\n\37\r\37"+
		"\16\37\u015f\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u016d\n \3!\5!\u0170"+
		"\n!\3!\5!\u0173\n!\3!\5!\u0176\n!\3!\5!\u0179\n!\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\5#\u0184\n#\3$\3$\3$\3$\5$\u018a\n$\3%\3%\3%\6%\u018f\n%\r"+
		"%\16%\u0190\3&\3&\3&\7&\u0196\n&\f&\16&\u0199\13&\3&\3&\3&\3&\7&\u019f"+
		"\n&\f&\16&\u01a2\13&\3&\5&\u01a5\n&\3\'\3\'\6\'\u01a9\n\'\r\'\16\'\u01aa"+
		"\3(\3(\3(\3(\3(\7(\u01b2\n(\f(\16(\u01b5\13(\3(\3(\5(\u01b9\n(\3(\3(\3"+
		")\3)\3)\6)\u01c0\n)\r)\16)\u01c1\3*\3*\3*\7*\u01c7\n*\f*\16*\u01ca\13"+
		"*\3*\3*\3*\3*\7*\u01d0\n*\f*\16*\u01d3\13*\3+\3+\3,\3,\3,\5,\u01da\n,"+
		"\3,\5,\u01dd\n,\3-\3-\5-\u01e1\n-\3-\5-\u01e4\n-\3.\3.\5.\u01e8\n.\3."+
		"\5.\u01eb\n.\3/\3/\6/\u01ef\n/\r/\16/\u01f0\3\60\3\60\6\60\u01f5\n\60"+
		"\r\60\16\60\u01f6\3\61\5\61\u01fa\n\61\3\61\3\61\3\61\3\61\3\61\7\61\u0201"+
		"\n\61\f\61\16\61\u0204\13\61\3\61\3\61\5\61\u0208\n\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u0211\n\62\3\63\3\63\3\63\3\63\3\64\3\64\5\64"+
		"\u0219\n\64\3\65\3\65\3\65\3\65\3\65\7\65\u0220\n\65\f\65\16\65\u0223"+
		"\13\65\3\66\3\66\3\66\3\66\6\66\u0229\n\66\r\66\16\66\u022a\3\67\3\67"+
		"\3\67\6\67\u0230\n\67\r\67\16\67\u0231\38\38\38\68\u0237\n8\r8\168\u0238"+
		"\39\39\39\69\u023e\n9\r9\169\u023f\3:\3:\3:\3:\3:\3:\3:\7:\u0249\n:\f"+
		":\16:\u024c\13:\3:\3:\3;\3;\3;\3;\3;\3;\3;\5;\u0257\n;\7;\u0259\n;\f;"+
		"\16;\u025c\13;\3;\3;\3<\3<\3<\3<\3<\5<\u0265\n<\3<\3<\3<\3<\7<\u026b\n"+
		"<\f<\16<\u026e\13<\3<\3<\5<\u0272\n<\3=\3=\3=\3=\3=\3=\3=\3=\7=\u027c"+
		"\n=\f=\16=\u027f\13=\3=\3=\5=\u0283\n=\3>\3>\3?\3?\3?\3?\3?\7?\u028c\n"+
		"?\f?\16?\u028f\13?\3@\3@\3@\6@\u0294\n@\r@\16@\u0295\3A\3A\3A\3A\3B\3"+
		"B\6B\u029e\nB\rB\16B\u029f\3C\3C\3C\7C\u02a5\nC\fC\16C\u02a8\13C\3C\3"+
		"C\3C\3C\7C\u02ae\nC\fC\16C\u02b1\13C\3C\3C\3C\3C\7C\u02b7\nC\fC\16C\u02ba"+
		"\13C\5C\u02bc\nC\3C\3C\3D\7D\u02c1\nD\fD\16D\u02c4\13D\3E\3E\3E\3E\3F"+
		"\3F\3F\3F\6F\u02ce\nF\rF\16F\u02cf\3G\3G\3G\3G\3G\7G\u02d7\nG\fG\16G\u02da"+
		"\13G\5G\u02dc\nG\3G\3G\3H\5H\u02e1\nH\3I\3I\3I\3I\3I\3J\3J\3J\3J\3K\3"+
		"K\3K\6K\u02ef\nK\rK\16K\u02f0\3L\3L\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3"+
		"M\3M\3M\3M\2\4\22\24N\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\2\6\4\2UUWW\3\2"+
		"UW\4\2@ACC\3\2ST\2\u0319\2\u009a\3\2\2\2\4\u009c\3\2\2\2\6\u009e\3\2\2"+
		"\2\b\u00a0\3\2\2\2\n\u00a2\3\2\2\2\f\u00b0\3\2\2\2\16\u00b8\3\2\2\2\20"+
		"\u00bc\3\2\2\2\22\u00be\3\2\2\2\24\u00d2\3\2\2\2\26\u00f2\3\2\2\2\30\u00f4"+
		"\3\2\2\2\32\u00f9\3\2\2\2\34\u0100\3\2\2\2\36\u0107\3\2\2\2 \u010e\3\2"+
		"\2\2\"\u0115\3\2\2\2$\u011a\3\2\2\2&\u011f\3\2\2\2(\u0124\3\2\2\2*\u0132"+
		"\3\2\2\2,\u013b\3\2\2\2.\u0140\3\2\2\2\60\u0142\3\2\2\2\62\u0144\3\2\2"+
		"\2\64\u0146\3\2\2\2\66\u014d\3\2\2\28\u0158\3\2\2\2:\u015a\3\2\2\2<\u015d"+
		"\3\2\2\2>\u016c\3\2\2\2@\u016f\3\2\2\2B\u017a\3\2\2\2D\u0183\3\2\2\2F"+
		"\u0189\3\2\2\2H\u018b\3\2\2\2J\u0192\3\2\2\2L\u01a6\3\2\2\2N\u01ac\3\2"+
		"\2\2P\u01bc\3\2\2\2R\u01c3\3\2\2\2T\u01d4\3\2\2\2V\u01d6\3\2\2\2X\u01de"+
		"\3\2\2\2Z\u01e5\3\2\2\2\\\u01ec\3\2\2\2^\u01f2\3\2\2\2`\u01f9\3\2\2\2"+
		"b\u0210\3\2\2\2d\u0212\3\2\2\2f\u0218\3\2\2\2h\u021a\3\2\2\2j\u0224\3"+
		"\2\2\2l\u022c\3\2\2\2n\u0233\3\2\2\2p\u023a\3\2\2\2r\u0241\3\2\2\2t\u024f"+
		"\3\2\2\2v\u0271\3\2\2\2x\u0282\3\2\2\2z\u0284\3\2\2\2|\u0286\3\2\2\2~"+
		"\u0290\3\2\2\2\u0080\u0297\3\2\2\2\u0082\u029b\3\2\2\2\u0084\u02a1\3\2"+
		"\2\2\u0086\u02c2\3\2\2\2\u0088\u02c5\3\2\2\2\u008a\u02c9\3\2\2\2\u008c"+
		"\u02d1\3\2\2\2\u008e\u02e0\3\2\2\2\u0090\u02e2\3\2\2\2\u0092\u02e7\3\2"+
		"\2\2\u0094\u02eb\3\2\2\2\u0096\u02f2\3\2\2\2\u0098\u02fb\3\2\2\2\u009a"+
		"\u009b\t\2\2\2\u009b\3\3\2\2\2\u009c\u009d\t\3\2\2\u009d\5\3\2\2\2\u009e"+
		"\u009f\t\4\2\2\u009f\7\3\2\2\2\u00a0\u00a1\t\5\2\2\u00a1\t\3\2\2\2\u00a2"+
		"\u00ae\7S\2\2\u00a3\u00a4\7\3\2\2\u00a4\u00a9\5\16\b\2\u00a5\u00a6\7\4"+
		"\2\2\u00a6\u00a8\5\16\b\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ac\u00ad\7\5\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a3\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\13\3\2\2\2\u00b0\u00b1\5\n\6\2\u00b1\r\3\2\2\2\u00b2"+
		"\u00b9\7?\2\2\u00b3\u00b9\7T\2\2\u00b4\u00b9\7S\2\2\u00b5\u00b9\5\4\3"+
		"\2\u00b6\u00b9\5\f\7\2\u00b7\u00b9\5\22\n\2\u00b8\u00b2\3\2\2\2\u00b8"+
		"\u00b3\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6\3\2"+
		"\2\2\u00b8\u00b7\3\2\2\2\u00b9\17\3\2\2\2\u00ba\u00bd\5\n\6\2\u00bb\u00bd"+
		"\7T\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\21\3\2\2\2\u00be"+
		"\u00bf\b\n\1\2\u00bf\u00c0\5\24\13\2\u00c0\u00c9\3\2\2\2\u00c1\u00c2\f"+
		"\5\2\2\u00c2\u00c3\7\6\2\2\u00c3\u00c8\5\24\13\2\u00c4\u00c5\f\4\2\2\u00c5"+
		"\u00c6\7\7\2\2\u00c6\u00c8\5\24\13\2\u00c7\u00c1\3\2\2\2\u00c7\u00c4\3"+
		"\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\23\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\b\13\1\2\u00cd\u00ce\5\26"+
		"\f\2\u00ce\u00cf\7\13\2\2\u00cf\u00d0\5\26\f\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00d3\5\26\f\2\u00d2\u00cc\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00df\3"+
		"\2\2\2\u00d4\u00d5\f\7\2\2\u00d5\u00d6\7\b\2\2\u00d6\u00de\5\26\f\2\u00d7"+
		"\u00d8\f\6\2\2\u00d8\u00d9\7\t\2\2\u00d9\u00de\5\26\f\2\u00da\u00db\f"+
		"\5\2\2\u00db\u00dc\7\n\2\2\u00dc\u00de\5\26\f\2\u00dd\u00d4\3\2\2\2\u00dd"+
		"\u00d7\3\2\2\2\u00dd\u00da\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\25\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00f3"+
		"\7T\2\2\u00e3\u00e4\7\7\2\2\u00e4\u00f3\7T\2\2\u00e5\u00f3\5\4\3\2\u00e6"+
		"\u00f3\5\f\7\2\u00e7\u00e8\7\7\2\2\u00e8\u00f3\5\f\7\2\u00e9\u00ea\7\3"+
		"\2\2\u00ea\u00eb\5\22\n\2\u00eb\u00ec\7\5\2\2\u00ec\u00f3\3\2\2\2\u00ed"+
		"\u00ee\7\7\2\2\u00ee\u00ef\7\3\2\2\u00ef\u00f0\5\22\n\2\u00f0\u00f1\7"+
		"\5\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00e2\3\2\2\2\u00f2\u00e3\3\2\2\2\u00f2"+
		"\u00e5\3\2\2\2\u00f2\u00e6\3\2\2\2\u00f2\u00e7\3\2\2\2\u00f2\u00e9\3\2"+
		"\2\2\u00f2\u00ed\3\2\2\2\u00f3\27\3\2\2\2\u00f4\u00f5\7E\2\2\u00f5\u00f6"+
		"\7\3\2\2\u00f6\u00f7\5\20\t\2\u00f7\u00f8\7\5\2\2\u00f8\31\3\2\2\2\u00f9"+
		"\u00fa\7F\2\2\u00fa\u00fb\7\3\2\2\u00fb\u00fc\5\20\t\2\u00fc\u00fd\7\4"+
		"\2\2\u00fd\u00fe\5F$\2\u00fe\u00ff\7\5\2\2\u00ff\33\3\2\2\2\u0100\u0101"+
		"\7G\2\2\u0101\u0102\7\3\2\2\u0102\u0103\5\20\t\2\u0103\u0104\7\4\2\2\u0104"+
		"\u0105\5F$\2\u0105\u0106\7\5\2\2\u0106\35\3\2\2\2\u0107\u0108\7J\2\2\u0108"+
		"\u0109\7\3\2\2\u0109\u010a\5F$\2\u010a\u010b\7\4\2\2\u010b\u010c\5F$\2"+
		"\u010c\u010d\7\5\2\2\u010d\37\3\2\2\2\u010e\u010f\7M\2\2\u010f\u0110\7"+
		"\3\2\2\u0110\u0111\5F$\2\u0111\u0112\7\4\2\2\u0112\u0113\5F$\2\u0113\u0114"+
		"\7\5\2\2\u0114!\3\2\2\2\u0115\u0116\7H\2\2\u0116\u0117\7\3\2\2\u0117\u0118"+
		"\5F$\2\u0118\u0119\7\5\2\2\u0119#\3\2\2\2\u011a\u011b\7I\2\2\u011b\u011c"+
		"\7\3\2\2\u011c\u011d\5F$\2\u011d\u011e\7\5\2\2\u011e%\3\2\2\2\u011f\u0120"+
		"\7L\2\2\u0120\u0121\7\3\2\2\u0121\u0122\5F$\2\u0122\u0123\7\5\2\2\u0123"+
		"\'\3\2\2\2\u0124\u0125\7K\2\2\u0125\u0126\7\3\2\2\u0126\u0127\5F$\2\u0127"+
		"\u0128\7\5\2\2\u0128)\3\2\2\2\u0129\u0133\5\32\16\2\u012a\u0133\5\34\17"+
		"\2\u012b\u0133\5\36\20\2\u012c\u0133\5 \21\2\u012d\u0133\5\"\22\2\u012e"+
		"\u0133\5$\23\2\u012f\u0133\5&\24\2\u0130\u0133\5(\25\2\u0131\u0133\5\f"+
		"\7\2\u0132\u0129\3\2\2\2\u0132\u012a\3\2\2\2\u0132\u012b\3\2\2\2\u0132"+
		"\u012c\3\2\2\2\u0132\u012d\3\2\2\2\u0132\u012e\3\2\2\2\u0132\u012f\3\2"+
		"\2\2\u0132\u0130\3\2\2\2\u0132\u0131\3\2\2\2\u0133+\3\2\2\2\u0134\u013c"+
		"\5*\26\2\u0135\u0136\7\7\2\2\u0136\u013c\5*\26\2\u0137\u0138\5\16\b\2"+
		"\u0138\u0139\5\6\4\2\u0139\u013a\5\16\b\2\u013a\u013c\3\2\2\2\u013b\u0134"+
		"\3\2\2\2\u013b\u0135\3\2\2\2\u013b\u0137\3\2\2\2\u013c-\3\2\2\2\u013d"+
		"\u0141\5\30\r\2\u013e\u013f\7\7\2\2\u013f\u0141\5\30\r\2\u0140\u013d\3"+
		"\2\2\2\u0140\u013e\3\2\2\2\u0141/\3\2\2\2\u0142\u0143\5\b\5\2\u0143\61"+
		"\3\2\2\2\u0144\u0145\5\b\5\2\u0145\63\3\2\2\2\u0146\u0147\7\f\2\2\u0147"+
		"\u0148\7\r\2\2\u0148\u0149\5\62\32\2\u0149\u014a\58\35\2\u014a\u014b\5"+
		"|?\2\u014b\u014c\5\u008eH\2\u014c\65\3\2\2\2\u014d\u014e\5\b\5\2\u014e"+
		"\67\3\2\2\2\u014f\u0150\7\16\2\2\u0150\u0151\5\66\34\2\u0151\u0152\5<"+
		"\37\2\u0152\u0159\3\2\2\2\u0153\u0154\7\17\2\2\u0154\u0155\5\66\34\2\u0155"+
		"\u0156\7\20\2\2\u0156\u0157\5\60\31\2\u0157\u0159\3\2\2\2\u0158\u014f"+
		"\3\2\2\2\u0158\u0153\3\2\2\2\u01599\3\2\2\2\u015a\u015b\5\b\5\2\u015b"+
		";\3\2\2\2\u015c\u015e\5> \2\u015d\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160=\3\2\2\2\u0161\u0162\7\21\2\2"+
		"\u0162\u0163\5:\36\2\u0163\u0164\5@!\2\u0164\u016d\3\2\2\2\u0165\u0166"+
		"\7\17\2\2\u0166\u0167\5\66\34\2\u0167\u0168\7\22\2\2\u0168\u0169\5:\36"+
		"\2\u0169\u016a\7\20\2\2\u016a\u016b\5\60\31\2\u016b\u016d\3\2\2\2\u016c"+
		"\u0161\3\2\2\2\u016c\u0165\3\2\2\2\u016d?\3\2\2\2\u016e\u0170\5H%\2\u016f"+
		"\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u0173\5P"+
		")\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174"+
		"\u0176\5V,\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2"+
		"\2\u0177\u0179\5h\65\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179A"+
		"\3\2\2\2\u017a\u017b\7\23\2\2\u017b\u017c\5\4\3\2\u017c\u017d\7\24\2\2"+
		"\u017d\u017e\5\4\3\2\u017e\u017f\7\25\2\2\u017fC\3\2\2\2\u0180\u0184\7"+
		"O\2\2\u0181\u0184\7P\2\2\u0182\u0184\5B\"\2\u0183\u0180\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184E\3\2\2\2\u0185\u018a\5D#\2\u0186"+
		"\u018a\7Q\2\2\u0187\u018a\7R\2\2\u0188\u018a\7S\2\2\u0189\u0185\3\2\2"+
		"\2\u0189\u0186\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u0188\3\2\2\2\u018aG"+
		"\3\2\2\2\u018b\u018c\7\26\2\2\u018c\u018e\7\27\2\2\u018d\u018f\5J&\2\u018e"+
		"\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2"+
		"\2\2\u0191I\3\2\2\2\u0192\u0197\7S\2\2\u0193\u0194\7\4\2\2\u0194\u0196"+
		"\7S\2\2\u0195\u0193\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197"+
		"\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019b\7\30"+
		"\2\2\u019b\u01a0\5F$\2\u019c\u019d\7\4\2\2\u019d\u019f\5F$\2\u019e\u019c"+
		"\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a5\5L\'\2\u01a4\u01a3\3\2"+
		"\2\2\u01a4\u01a5\3\2\2\2\u01a5K\3\2\2\2\u01a6\u01a8\7\31\2\2\u01a7\u01a9"+
		"\5N(\2\u01a8\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01abM\3\2\2\2\u01ac\u01ad\7S\2\2\u01ad\u01b8\7\32\2\2"+
		"\u01ae\u01b3\5F$\2\u01af\u01b0\7\4\2\2\u01b0\u01b2\5F$\2\u01b1\u01af\3"+
		"\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b7\7D\2\2\u01b7\u01b9\3\2"+
		"\2\2\u01b8\u01ae\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01bb\5F$\2\u01bbO\3\2\2\2\u01bc\u01bd\7\33\2\2\u01bd\u01bf\7\34\2\2"+
		"\u01be\u01c0\5R*\2\u01bf\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01bf"+
		"\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2Q\3\2\2\2\u01c3\u01c8\5\n\6\2\u01c4"+
		"\u01c5\7\4\2\2\u01c5\u01c7\5\n\6\2\u01c6\u01c4\3\2\2\2\u01c7\u01ca\3\2"+
		"\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01cb\3\2\2\2\u01ca"+
		"\u01c8\3\2\2\2\u01cb\u01cc\7\32\2\2\u01cc\u01d1\5F$\2\u01cd\u01ce\7\4"+
		"\2\2\u01ce\u01d0\5F$\2\u01cf\u01cd\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf"+
		"\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2S\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4"+
		"\u01d5\7S\2\2\u01d5U\3\2\2\2\u01d6\u01d7\7\35\2\2\u01d7\u01d9\7\27\2\2"+
		"\u01d8\u01da\5X-\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc"+
		"\3\2\2\2\u01db\u01dd\5Z.\2\u01dc\u01db\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd"+
		"W\3\2\2\2\u01de\u01e0\7\36\2\2\u01df\u01e1\5\\/\2\u01e0\u01df\3\2\2\2"+
		"\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01e4\5^\60\2\u01e3\u01e2"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4Y\3\2\2\2\u01e5\u01e7\7\37\2\2\u01e6"+
		"\u01e8\5\\/\2\u01e7\u01e6\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2"+
		"\2\2\u01e9\u01eb\5^\60\2\u01ea\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb"+
		"[\3\2\2\2\u01ec\u01ee\7 \2\2\u01ed\u01ef\5`\61\2\u01ee\u01ed\3\2\2\2\u01ef"+
		"\u01f0\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1]\3\2\2\2"+
		"\u01f2\u01f4\7!\2\2\u01f3\u01f5\5`\61\2\u01f4\u01f3\3\2\2\2\u01f5\u01f6"+
		"\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7_\3\2\2\2\u01f8"+
		"\u01fa\7\"\2\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\3\2"+
		"\2\2\u01fb\u01fc\5T+\2\u01fc\u01fd\7\32\2\2\u01fd\u0207\5F$\2\u01fe\u01ff"+
		"\7\b\2\2\u01ff\u0201\5F$\2\u0200\u01fe\3\2\2\2\u0201\u0204\3\2\2\2\u0202"+
		"\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204\u0202\3\2"+
		"\2\2\u0205\u0206\7D\2\2\u0206\u0208\5F$\2\u0207\u0202\3\2\2\2\u0207\u0208"+
		"\3\2\2\2\u0208a\3\2\2\2\u0209\u020a\5\f\7\2\u020a\u020b\7@\2\2\u020b\u020c"+
		"\5\16\b\2\u020c\u0211\3\2\2\2\u020d\u0211\5\f\7\2\u020e\u020f\7\7\2\2"+
		"\u020f\u0211\5\f\7\2\u0210\u0209\3\2\2\2\u0210\u020d\3\2\2\2\u0210\u020e"+
		"\3\2\2\2\u0211c\3\2\2\2\u0212\u0213\5\f\7\2\u0213\u0214\7A\2\2\u0214\u0215"+
		"\5\16\b\2\u0215e\3\2\2\2\u0216\u0219\5b\62\2\u0217\u0219\5d\63\2\u0218"+
		"\u0216\3\2\2\2\u0218\u0217\3\2\2\2\u0219g\3\2\2\2\u021a\u0221\7#\2\2\u021b"+
		"\u0220\5j\66\2\u021c\u0220\5l\67\2\u021d\u0220\5n8\2\u021e\u0220\5p9\2"+
		"\u021f\u021b\3\2\2\2\u021f\u021c\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u021e"+
		"\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222"+
		"i\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u0225\7$\2\2\u0225\u0226\7%\2\2\u0226"+
		"\u0228\7&\2\2\u0227\u0229\5r:\2\u0228\u0227\3\2\2\2\u0229\u022a\3\2\2"+
		"\2\u022a\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022bk\3\2\2\2\u022c\u022d"+
		"\7\'\2\2\u022d\u022f\7(\2\2\u022e\u0230\5t;\2\u022f\u022e\3\2\2\2\u0230"+
		"\u0231\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232m\3\2\2\2"+
		"\u0233\u0234\7)\2\2\u0234\u0236\7*\2\2\u0235\u0237\5v<\2\u0236\u0235\3"+
		"\2\2\2\u0237\u0238\3\2\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239"+
		"o\3\2\2\2\u023a\u023b\7\35\2\2\u023b\u023d\7+\2\2\u023c\u023e\5x=\2\u023d"+
		"\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2"+
		"\2\2\u0240q\3\2\2\2\u0241\u0242\5\30\r\2\u0242\u0243\7,\2\2\u0243\u0244"+
		"\5b\62\2\u0244\u0245\7-\2\2\u0245\u024a\5\32\16\2\u0246\u0247\7\4\2\2"+
		"\u0247\u0249\5,\27\2\u0248\u0246\3\2\2\2\u0249\u024c\3\2\2\2\u024a\u0248"+
		"\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024d\3\2\2\2\u024c\u024a\3\2\2\2\u024d"+
		"\u024e\7\22\2\2\u024es\3\2\2\2\u024f\u0250\7.\2\2\u0250\u0251\5\30\r\2"+
		"\u0251\u0252\7-\2\2\u0252\u025a\5\32\16\2\u0253\u0256\7\4\2\2\u0254\u0257"+
		"\5.\30\2\u0255\u0257\5,\27\2\u0256\u0254\3\2\2\2\u0256\u0255\3\2\2\2\u0257"+
		"\u0259\3\2\2\2\u0258\u0253\3\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2"+
		"\2\2\u025a\u025b\3\2\2\2\u025b\u025d\3\2\2\2\u025c\u025a\3\2\2\2\u025d"+
		"\u025e\7\22\2\2\u025eu\3\2\2\2\u025f\u0260\5f\64\2\u0260\u0261\7\22\2"+
		"\2\u0261\u0272\3\2\2\2\u0262\u0265\7/\2\2\u0263\u0265\5f\64\2\u0264\u0262"+
		"\3\2\2\2\u0264\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0267\7-\2\2\u0267"+
		"\u026c\5,\27\2\u0268\u0269\7\4\2\2\u0269\u026b\5,\27\2\u026a\u0268\3\2"+
		"\2\2\u026b\u026e\3\2\2\2\u026c\u026a\3\2\2\2\u026c\u026d\3\2\2\2\u026d"+
		"\u026f\3\2\2\2\u026e\u026c\3\2\2\2\u026f\u0270\7\22\2\2\u0270\u0272\3"+
		"\2\2\2\u0271\u025f\3\2\2\2\u0271\u0264\3\2\2\2\u0272w\3\2\2\2\u0273\u0274"+
		"\5\f\7\2\u0274\u0275\7\22\2\2\u0275\u0283\3\2\2\2\u0276\u0277\5\f\7\2"+
		"\u0277\u0278\7-\2\2\u0278\u027d\5,\27\2\u0279\u027a\7\4\2\2\u027a\u027c"+
		"\5,\27\2\u027b\u0279\3\2\2\2\u027c\u027f\3\2\2\2\u027d\u027b\3\2\2\2\u027d"+
		"\u027e\3\2\2\2\u027e\u0280\3\2\2\2\u027f\u027d\3\2\2\2\u0280\u0281\7\22"+
		"\2\2\u0281\u0283\3\2\2\2\u0282\u0273\3\2\2\2\u0282\u0276\3\2\2\2\u0283"+
		"y\3\2\2\2\u0284\u0285\5\b\5\2\u0285{\3\2\2\2\u0286\u0287\7\60\2\2\u0287"+
		"\u028d\5z>\2\u0288\u028c\5~@\2\u0289\u028c\5\u0082B\2\u028a\u028c\5\u008a"+
		"F\2\u028b\u0288\3\2\2\2\u028b\u0289\3\2\2\2\u028b\u028a\3\2\2\2\u028c"+
		"\u028f\3\2\2\2\u028d\u028b\3\2\2\2\u028d\u028e\3\2\2\2\u028e}\3\2\2\2"+
		"\u028f\u028d\3\2\2\2\u0290\u0291\7\61\2\2\u0291\u0293\7+\2\2\u0292\u0294"+
		"\5\u0080A\2\u0293\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0293\3\2\2"+
		"\2\u0295\u0296\3\2\2\2\u0296\177\3\2\2\2\u0297\u0298\5\n\6\2\u0298\u0299"+
		"\7@\2\2\u0299\u029a\5\16\b\2\u029a\u0081\3\2\2\2\u029b\u029d\7\62\2\2"+
		"\u029c\u029e\5\u0084C\2\u029d\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029f"+
		"\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u0083\3\2\2\2\u02a1\u02a6\5\n"+
		"\6\2\u02a2\u02a3\7\4\2\2\u02a3\u02a5\5\n\6\2\u02a4\u02a2\3\2\2\2\u02a5"+
		"\u02a8\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a9\3\2"+
		"\2\2\u02a8\u02a6\3\2\2\2\u02a9\u02aa\7\63\2\2\u02aa\u02af\5F$\2\u02ab"+
		"\u02ac\7\4\2\2\u02ac\u02ae\5F$\2\u02ad\u02ab\3\2\2\2\u02ae\u02b1\3\2\2"+
		"\2\u02af\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02bb\3\2\2\2\u02b1\u02af"+
		"\3\2\2\2\u02b2\u02b3\7\64\2\2\u02b3\u02b8\5,\27\2\u02b4\u02b5\7\4\2\2"+
		"\u02b5\u02b7\5,\27\2\u02b6\u02b4\3\2\2\2\u02b7\u02ba\3\2\2\2\u02b8\u02b6"+
		"\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02bb"+
		"\u02b2\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02be\5\u0086"+
		"D\2\u02be\u0085\3\2\2\2\u02bf\u02c1\5\u0088E\2\u02c0\u02bf\3\2\2\2\u02c1"+
		"\u02c4\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u0087\3\2"+
		"\2\2\u02c4\u02c2\3\2\2\2\u02c5\u02c6\5\f\7\2\u02c6\u02c7\7@\2\2\u02c7"+
		"\u02c8\5\16\b\2\u02c8\u0089\3\2\2\2\u02c9\u02ca\7\65\2\2\u02ca\u02cb\7"+
		"\66\2\2\u02cb\u02cd\7\36\2\2\u02cc\u02ce\5\u008cG\2\u02cd\u02cc\3\2\2"+
		"\2\u02ce\u02cf\3\2\2\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u008b"+
		"\3\2\2\2\u02d1\u02db\5f\64\2\u02d2\u02d3\7-\2\2\u02d3\u02d8\5,\27\2\u02d4"+
		"\u02d5\7\4\2\2\u02d5\u02d7\5,\27\2\u02d6\u02d4\3\2\2\2\u02d7\u02da\3\2"+
		"\2\2\u02d8\u02d6\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02dc\3\2\2\2\u02da"+
		"\u02d8\3\2\2\2\u02db\u02d2\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02dd\3\2"+
		"\2\2\u02dd\u02de\7\22\2\2\u02de\u008d\3\2\2\2\u02df\u02e1\5\u0090I\2\u02e0"+
		"\u02df\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u008f\3\2\2\2\u02e2\u02e3\7\67"+
		"\2\2\u02e3\u02e4\78\2\2\u02e4\u02e5\5\u0092J\2\u02e5\u02e6\5\u0094K\2"+
		"\u02e6\u0091\3\2\2\2\u02e7\u02e8\79\2\2\u02e8\u02e9\7:\2\2\u02e9\u02ea"+
		"\7U\2\2\u02ea\u0093\3\2\2\2\u02eb\u02ee\7;\2\2\u02ec\u02ef\5\u0096L\2"+
		"\u02ed\u02ef\5\u0098M\2\u02ee\u02ec\3\2\2\2\u02ee\u02ed\3\2\2\2\u02ef"+
		"\u02f0\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u0095\3\2"+
		"\2\2\u02f2\u02f3\7<\2\2\u02f3\u02f4\7\3\2\2\u02f4\u02f5\5\f\7\2\u02f5"+
		"\u02f6\7\4\2\2\u02f6\u02f7\5\16\b\2\u02f7\u02f8\7\4\2\2\u02f8\u02f9\5"+
		"\2\2\2\u02f9\u02fa\7\5\2\2\u02fa\u0097\3\2\2\2\u02fb\u02fc\7=\2\2\u02fc"+
		"\u02fd\7\3\2\2\u02fd\u02fe\5\n\6\2\u02fe\u02ff\7\4\2\2\u02ff\u0300\5\2"+
		"\2\2\u0300\u0301\7\5\2\2\u0301\u0099\3\2\2\2L\u00a9\u00ae\u00b8\u00bc"+
		"\u00c7\u00c9\u00d2\u00dd\u00df\u00f2\u0132\u013b\u0140\u0158\u015f\u016c"+
		"\u016f\u0172\u0175\u0178\u0183\u0189\u0190\u0197\u01a0\u01a4\u01aa\u01b3"+
		"\u01b8\u01c1\u01c8\u01d1\u01d9\u01dc\u01e0\u01e3\u01e7\u01ea\u01f0\u01f6"+
		"\u01f9\u0202\u0207\u0210\u0218\u021f\u0221\u022a\u0231\u0238\u023f\u024a"+
		"\u0256\u025a\u0264\u026c\u0271\u027d\u0282\u028b\u028d\u0295\u029f\u02a6"+
		"\u02af\u02b8\u02bb\u02c2\u02cf\u02d8\u02db\u02e0\u02ee\u02f0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}