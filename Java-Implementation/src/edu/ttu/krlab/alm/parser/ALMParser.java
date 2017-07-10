// Generated from ALM.g4 by ANTLR 4.5.3

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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

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
		T__52=53, WhiteSpace=54, BOOL=55, EQ=56, NEQ=57, ARITH_OP=58, COMP_REL=59, 
		RIGHT_ARROW=60, OCCURS=61, INSTANCE=62, IS_A=63, HAS_CHILD=64, HAS_PARENT=65, 
		LINK=66, SOURCE=67, SINK=68, SUBSORT=69, DOM=70, BOOLEAN=71, INTEGERS=72, 
		UNIVERSE=73, ACTIONS=74, ID=75, VAR=76, POSINT=77, NEGINT=78, ZERO=79;
	public static final int
		RULE_integer = 0, RULE_relation = 1, RULE_alm_name = 2, RULE_object_constant = 3, 
		RULE_function_term = 4, RULE_term = 5, RULE_var_or_obj = 6, RULE_expression = 7, 
		RULE_arithmetic_term = 8, RULE_factor = 9, RULE_occurs_atom = 10, RULE_instance_atom = 11, 
		RULE_is_a_atom = 12, RULE_link_atom = 13, RULE_subsort_atom = 14, RULE_has_child_atom = 15, 
		RULE_has_parent_atom = 16, RULE_sink_atom = 17, RULE_source_atom = 18, 
		RULE_atom = 19, RULE_literal = 20, RULE_occurs_literal = 21, RULE_library_name = 22, 
		RULE_sys_desc_name = 23, RULE_system_description = 24, RULE_theory_name = 25, 
		RULE_theory = 26, RULE_module_name = 27, RULE_sequence_of_modules = 28, 
		RULE_module = 29, RULE_module_body = 30, RULE_integer_range = 31, RULE_predefined_sorts = 32, 
		RULE_sort_name = 33, RULE_sort_declarations = 34, RULE_one_sort_decl = 35, 
		RULE_attributes = 36, RULE_one_attribute_decl = 37, RULE_constant_declarations = 38, 
		RULE_one_constant_decl = 39, RULE_function_name = 40, RULE_function_declarations = 41, 
		RULE_static_declarations = 42, RULE_fluent_declarations = 43, RULE_basic_function_declarations = 44, 
		RULE_defined_function_declarations = 45, RULE_one_function_decl = 46, 
		RULE_pos_fun_def = 47, RULE_neg_fun_def = 48, RULE_fun_def = 49, RULE_axioms = 50, 
		RULE_dynamic_causal_laws = 51, RULE_executability_conditions = 52, RULE_state_constraints = 53, 
		RULE_definitions = 54, RULE_one_dynamic_causal_law = 55, RULE_one_executability_condition = 56, 
		RULE_one_state_constraint = 57, RULE_one_definition = 58, RULE_structure_name = 59, 
		RULE_structure = 60, RULE_constant_defs = 61, RULE_one_constant_def = 62, 
		RULE_instance_defs = 63, RULE_one_instance_def = 64, RULE_attribute_defs = 65, 
		RULE_one_attribute_def = 66, RULE_statics_defs = 67, RULE_one_static_def = 68;
	public static final String[] ruleNames = {
		"integer", "relation", "alm_name", "object_constant", "function_term", 
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
		"attribute_defs", "one_attribute_def", "statics_defs", "one_static_def"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'^'", 
		"'system'", "'description'", "'theory'", "'import'", "'from'", "'module'", 
		"'depends'", "'on'", "'.'", "'['", "'..'", "']'", "'sort'", "'declarations'", 
		"'::'", "'attributes'", "':'", "'object'", "'constants'", "'function'", 
		"'statics'", "'fluents'", "'basic'", "'defined'", "'total'", "'axioms'", 
		"'dynamic'", "'causal'", "'laws'", "'executability'", "'conditions'", 
		"'state'", "'constraints'", "'definitions'", "'causes'", "'if'", "'impossible'", 
		"'false'", "'structure'", "'instances'", "'in'", "'where'", "'value'", 
		"'of'", null, null, "'='", "'!='", null, null, "'->'", "'occurs'", "'instance'", 
		"'is_a'", "'has_child'", "'has_parent'", "'link'", "'source'", "'sink'", 
		"'subsort'", "'DOM'", "'booleans'", "'integers'", "'universe'", "'actions'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "WhiteSpace", "BOOL", "EQ", "NEQ", 
		"ARITH_OP", "COMP_REL", "RIGHT_ARROW", "OCCURS", "INSTANCE", "IS_A", "HAS_CHILD", 
		"HAS_PARENT", "LINK", "SOURCE", "SINK", "SUBSORT", "DOM", "BOOLEAN", "INTEGERS", 
		"UNIVERSE", "ACTIONS", "ID", "VAR", "POSINT", "NEGINT", "ZERO"
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
		enterRule(_localctx, 0, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (POSINT - 77)) | (1L << (NEGINT - 77)) | (1L << (ZERO - 77)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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
		enterRule(_localctx, 2, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << COMP_REL))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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
		enterRule(_localctx, 4, RULE_alm_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==VAR) ) {
			_errHandler.recoverInline(this);
			} else {
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
		enterRule(_localctx, 6, RULE_object_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(ID);
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(145);
				match(T__0);
				setState(146);
				term();
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(147);
					match(T__1);
					setState(148);
					term();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
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
		enterRule(_localctx, 8, RULE_function_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
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
		enterRule(_localctx, 10, RULE_term);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(BOOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				integer();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(165);
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
		enterRule(_localctx, 12, RULE_var_or_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(168);
				object_constant();
				}
				break;
			case VAR:
				{
				setState(169);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(173);
			arithmetic_term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(181);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(175);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(176);
						match(T__3);
						setState(177);
						arithmetic_term(0);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(179);
						match(T__4);
						setState(180);
						arithmetic_term(0);
						}
						break;
					}
					} 
				}
				setState(185);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_arithmetic_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(187);
				factor();
				setState(188);
				match(T__8);
				setState(189);
				factor();
				}
				break;
			case 2:
				{
				setState(191);
				factor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(203);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(194);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(195);
						match(T__5);
						setState(196);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(197);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(198);
						match(T__6);
						setState(199);
						factor();
						}
						break;
					case 3:
						{
						_localctx = new Arithmetic_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
						setState(200);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(201);
						match(T__7);
						setState(202);
						factor();
						}
						break;
					}
					} 
				}
				setState(207);
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
		enterRule(_localctx, 18, RULE_factor);
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(T__4);
				setState(210);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				integer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				function_term();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				match(T__4);
				setState(214);
				function_term();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(215);
				match(T__0);
				setState(216);
				expression(0);
				setState(217);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				match(T__4);
				setState(220);
				match(T__0);
				setState(221);
				expression(0);
				setState(222);
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
		enterRule(_localctx, 20, RULE_occurs_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(OCCURS);
			setState(227);
			match(T__0);
			setState(228);
			var_or_obj();
			setState(229);
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
		enterRule(_localctx, 22, RULE_instance_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(INSTANCE);
			setState(232);
			match(T__0);
			setState(233);
			var_or_obj();
			setState(234);
			match(T__1);
			setState(235);
			sort_name();
			setState(236);
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
		enterRule(_localctx, 24, RULE_is_a_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(IS_A);
			setState(239);
			match(T__0);
			setState(240);
			var_or_obj();
			setState(241);
			match(T__1);
			setState(242);
			sort_name();
			setState(243);
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
		enterRule(_localctx, 26, RULE_link_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(LINK);
			setState(246);
			match(T__0);
			setState(247);
			sort_name();
			setState(248);
			match(T__1);
			setState(249);
			sort_name();
			setState(250);
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
		enterRule(_localctx, 28, RULE_subsort_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(SUBSORT);
			setState(253);
			match(T__0);
			setState(254);
			sort_name();
			setState(255);
			match(T__1);
			setState(256);
			sort_name();
			setState(257);
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
		enterRule(_localctx, 30, RULE_has_child_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(HAS_CHILD);
			setState(260);
			match(T__0);
			setState(261);
			sort_name();
			setState(262);
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
		enterRule(_localctx, 32, RULE_has_parent_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(HAS_PARENT);
			setState(265);
			match(T__0);
			setState(266);
			sort_name();
			setState(267);
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
		enterRule(_localctx, 34, RULE_sink_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(SINK);
			setState(270);
			match(T__0);
			setState(271);
			sort_name();
			setState(272);
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
		enterRule(_localctx, 36, RULE_source_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(SOURCE);
			setState(275);
			match(T__0);
			setState(276);
			sort_name();
			setState(277);
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
		enterRule(_localctx, 38, RULE_atom);
		try {
			setState(288);
			switch (_input.LA(1)) {
			case INSTANCE:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				instance_atom();
				}
				break;
			case IS_A:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				is_a_atom();
				}
				break;
			case LINK:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				link_atom();
				}
				break;
			case SUBSORT:
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				subsort_atom();
				}
				break;
			case HAS_CHILD:
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				has_child_atom();
				}
				break;
			case HAS_PARENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(284);
				has_parent_atom();
				}
				break;
			case SINK:
				enterOuterAlt(_localctx, 7);
				{
				setState(285);
				sink_atom();
				}
				break;
			case SOURCE:
				enterOuterAlt(_localctx, 8);
				{
				setState(286);
				source_atom();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 9);
				{
				setState(287);
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
		enterRule(_localctx, 40, RULE_literal);
		try {
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				match(T__4);
				setState(292);
				atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				term();
				setState(294);
				relation();
				setState(295);
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
		enterRule(_localctx, 42, RULE_occurs_literal);
		try {
			setState(302);
			switch (_input.LA(1)) {
			case OCCURS:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				occurs_atom();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				match(T__4);
				setState(301);
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
		enterRule(_localctx, 44, RULE_library_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
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
		enterRule(_localctx, 46, RULE_sys_desc_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
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
		enterRule(_localctx, 48, RULE_system_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(T__9);
			setState(309);
			match(T__10);
			setState(310);
			sys_desc_name();
			setState(311);
			theory();
			setState(312);
			structure();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 50, RULE_theory_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
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
		enterRule(_localctx, 52, RULE_theory);
		try {
			setState(325);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(316);
				match(T__11);
				setState(317);
				theory_name();
				setState(318);
				sequence_of_modules();
				}
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(320);
				match(T__12);
				setState(321);
				theory_name();
				setState(322);
				match(T__13);
				setState(323);
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
		enterRule(_localctx, 54, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
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
		enterRule(_localctx, 56, RULE_sequence_of_modules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(329);
				module();
				}
				}
				setState(332); 
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
		public List<Module_nameContext> module_name() {
			return getRuleContexts(Module_nameContext.class);
		}
		public Module_nameContext module_name(int i) {
			return getRuleContext(Module_nameContext.class,i);
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
		enterRule(_localctx, 58, RULE_module);
		int _la;
		try {
			setState(357);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(334);
				match(T__14);
				setState(335);
				module_name();
				setState(346);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(336);
					match(T__15);
					setState(337);
					match(T__16);
					setState(338);
					module_name();
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(339);
						match(T__1);
						setState(340);
						module_name();
						}
						}
						setState(345);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(348);
				module_body();
				}
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(350);
				match(T__12);
				setState(351);
				theory_name();
				setState(352);
				match(T__17);
				setState(353);
				module_name();
				setState(354);
				match(T__13);
				setState(355);
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
		enterRule(_localctx, 60, RULE_module_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(359);
				sort_declarations();
				}
			}

			setState(363);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(362);
				constant_declarations();
				}
			}

			setState(366);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(365);
				function_declarations();
				}
			}

			setState(369);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(368);
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
		enterRule(_localctx, 62, RULE_integer_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(T__18);
			setState(372);
			integer();
			setState(373);
			match(T__19);
			setState(374);
			integer();
			setState(375);
			match(T__20);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_predefined_sorts);
		try {
			setState(380);
			switch (_input.LA(1)) {
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(BOOLEAN);
				}
				break;
			case INTEGERS:
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
				match(INTEGERS);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(379);
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
		enterRule(_localctx, 66, RULE_sort_name);
		try {
			setState(386);
			switch (_input.LA(1)) {
			case T__18:
			case BOOLEAN:
			case INTEGERS:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				predefined_sorts();
				}
				break;
			case UNIVERSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				match(UNIVERSE);
				}
				break;
			case ACTIONS:
				enterOuterAlt(_localctx, 3);
				{
				setState(384);
				match(ACTIONS);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(385);
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
		enterRule(_localctx, 68, RULE_sort_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(T__21);
			setState(389);
			match(T__22);
			setState(391); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(390);
				one_sort_decl();
				}
				}
				setState(393); 
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
		enterRule(_localctx, 70, RULE_one_sort_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(ID);
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(396);
				match(T__1);
				setState(397);
				match(ID);
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(403);
			match(T__23);
			setState(404);
			sort_name();
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(405);
				match(T__1);
				setState(406);
				sort_name();
				}
				}
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(413);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(412);
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
		enterRule(_localctx, 72, RULE_attributes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(T__24);
			setState(417); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(416);
					one_attribute_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(419); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		enterRule(_localctx, 74, RULE_one_attribute_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(ID);
			setState(422);
			match(T__25);
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(423);
				sort_name();
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(424);
					match(T__1);
					setState(425);
					sort_name();
					}
					}
					setState(430);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(431);
				match(RIGHT_ARROW);
				}
				break;
			}
			setState(435);
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
		enterRule(_localctx, 76, RULE_constant_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(T__26);
			setState(438);
			match(T__27);
			setState(440); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(439);
				one_constant_decl();
				}
				}
				setState(442); 
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
		enterRule(_localctx, 78, RULE_one_constant_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			object_constant();
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(445);
				match(T__1);
				setState(446);
				object_constant();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
			match(T__25);
			setState(453);
			sort_name();
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(454);
				match(T__1);
				setState(455);
				sort_name();
				}
				}
				setState(460);
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
		enterRule(_localctx, 80, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
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
		enterRule(_localctx, 82, RULE_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(T__28);
			setState(464);
			match(T__22);
			setState(466);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(465);
				static_declarations();
				}
			}

			setState(469);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(468);
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
		enterRule(_localctx, 84, RULE_static_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(T__29);
			setState(473);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(472);
				basic_function_declarations();
				}
			}

			setState(476);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(475);
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
		enterRule(_localctx, 86, RULE_fluent_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(T__30);
			setState(480);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(479);
				basic_function_declarations();
				}
			}

			setState(483);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(482);
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
		enterRule(_localctx, 88, RULE_basic_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(T__31);
			setState(487); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(486);
				one_function_decl();
				}
				}
				setState(489); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__33 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_defined_function_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			match(T__32);
			setState(493); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(492);
				one_function_decl();
				}
				}
				setState(495); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__33 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 92, RULE_one_function_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(497);
				match(T__33);
				}
			}

			setState(500);
			function_name();
			setState(501);
			match(T__25);
			setState(502);
			sort_name();
			setState(512);
			_la = _input.LA(1);
			if (_la==T__5 || _la==RIGHT_ARROW) {
				{
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(503);
					match(T__5);
					setState(504);
					sort_name();
					}
					}
					setState(509);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(510);
				match(RIGHT_ARROW);
				setState(511);
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
		enterRule(_localctx, 94, RULE_pos_fun_def);
		try {
			setState(521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(514);
				function_term();
				setState(515);
				match(EQ);
				setState(516);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
				function_term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(519);
				match(T__4);
				setState(520);
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
		enterRule(_localctx, 96, RULE_neg_fun_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			function_term();
			setState(524);
			match(NEQ);
			setState(525);
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
		enterRule(_localctx, 98, RULE_fun_def);
		try {
			setState(529);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(527);
				pos_fun_def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
				neg_fun_def();
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
		enterRule(_localctx, 100, RULE_axioms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(T__34);
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__35) | (1L << T__38) | (1L << T__40))) != 0)) {
				{
				setState(536);
				switch (_input.LA(1)) {
				case T__35:
					{
					setState(532);
					dynamic_causal_laws();
					}
					break;
				case T__38:
					{
					setState(533);
					executability_conditions();
					}
					break;
				case T__40:
					{
					setState(534);
					state_constraints();
					}
					break;
				case T__28:
					{
					setState(535);
					definitions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(540);
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
		enterRule(_localctx, 102, RULE_dynamic_causal_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			match(T__35);
			setState(542);
			match(T__36);
			setState(543);
			match(T__37);
			setState(545); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(544);
				one_dynamic_causal_law();
				}
				}
				setState(547); 
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
		enterRule(_localctx, 104, RULE_executability_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			match(T__38);
			setState(550);
			match(T__39);
			setState(552); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(551);
				one_executability_condition();
				}
				}
				setState(554); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__45 );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 106, RULE_state_constraints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			match(T__40);
			setState(557);
			match(T__41);
			setState(559); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(558);
				one_state_constraint();
				}
				}
				setState(561); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 || _la==T__46 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 108, RULE_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(T__28);
			setState(564);
			match(T__42);
			setState(566); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(565);
				one_definition();
				}
				}
				setState(568); 
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
		enterRule(_localctx, 110, RULE_one_dynamic_causal_law);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			occurs_atom();
			setState(571);
			match(T__43);
			setState(572);
			pos_fun_def();
			setState(573);
			match(T__44);
			setState(574);
			instance_atom();
			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(575);
				match(T__1);
				setState(576);
				literal();
				}
				}
				setState(581);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(582);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 112, RULE_one_executability_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			match(T__45);
			setState(585);
			occurs_atom();
			setState(586);
			match(T__44);
			setState(587);
			instance_atom();
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(588);
				match(T__1);
				setState(591);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(589);
					occurs_literal();
					}
					break;
				case 2:
					{
					setState(590);
					literal();
					}
					break;
				}
				}
				}
				setState(597);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(598);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_one_state_constraint);
		int _la;
		try {
			setState(618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(600);
				fun_def();
				setState(601);
				match(T__17);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(605);
				switch (_input.LA(1)) {
				case T__46:
					{
					setState(603);
					match(T__46);
					}
					break;
				case T__4:
				case ID:
					{
					setState(604);
					fun_def();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(607);
				match(T__44);
				setState(608);
				literal();
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(609);
					match(T__1);
					setState(610);
					literal();
					}
					}
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(616);
				match(T__17);
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
		public Fun_defContext fun_def() {
			return getRuleContext(Fun_defContext.class,0);
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
		enterRule(_localctx, 116, RULE_one_definition);
		int _la;
		try {
			setState(635);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(620);
				fun_def();
				setState(621);
				match(T__17);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(623);
				fun_def();
				setState(624);
				match(T__44);
				setState(625);
				literal();
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(626);
					match(T__1);
					setState(627);
					literal();
					}
					}
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(633);
				match(T__17);
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
		enterRule(_localctx, 118, RULE_structure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
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
		enterRule(_localctx, 120, RULE_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			match(T__47);
			setState(640);
			structure_name();
			setState(646);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__48) | (1L << T__51))) != 0)) {
				{
				setState(644);
				switch (_input.LA(1)) {
				case T__27:
					{
					setState(641);
					constant_defs();
					}
					break;
				case T__48:
					{
					setState(642);
					instance_defs();
					}
					break;
				case T__51:
					{
					setState(643);
					statics_defs();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(648);
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
		enterRule(_localctx, 122, RULE_constant_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(T__27);
			setState(651); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(650);
				one_constant_def();
				}
				}
				setState(653); 
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
		enterRule(_localctx, 124, RULE_one_constant_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			object_constant();
			setState(656);
			match(EQ);
			setState(657);
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
		enterRule(_localctx, 126, RULE_instance_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			match(T__48);
			setState(661); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(660);
				one_instance_def();
				}
				}
				setState(663); 
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
		enterRule(_localctx, 128, RULE_one_instance_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			object_constant();
			setState(670);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(666);
				match(T__1);
				setState(667);
				object_constant();
				}
				}
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(673);
			match(T__49);
			setState(674);
			sort_name();
			setState(679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(675);
				match(T__1);
				setState(676);
				sort_name();
				}
				}
				setState(681);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(691);
			_la = _input.LA(1);
			if (_la==T__50) {
				{
				setState(682);
				match(T__50);
				setState(683);
				literal();
				setState(688);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(684);
					match(T__1);
					setState(685);
					literal();
					}
					}
					setState(690);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(693);
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
		enterRule(_localctx, 130, RULE_attribute_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(695);
					one_attribute_def();
					}
					} 
				}
				setState(700);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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
		enterRule(_localctx, 132, RULE_one_attribute_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			function_term();
			setState(702);
			match(EQ);
			setState(703);
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
		enterRule(_localctx, 134, RULE_statics_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			match(T__51);
			setState(706);
			match(T__52);
			setState(707);
			match(T__29);
			setState(709); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(708);
				one_static_def();
				}
				}
				setState(711); 
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
		enterRule(_localctx, 136, RULE_one_static_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(713);
			fun_def();
			setState(723);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(714);
				match(T__44);
				setState(715);
				literal();
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(716);
					match(T__1);
					setState(717);
					literal();
					}
					}
					setState(722);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(725);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
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
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 8:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Q\u02da\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5\u0098\n\5\f\5\16\5\u009b\13\5\3\5\3\5"+
		"\5\5\u009f\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a9\n\7\3\b\3\b\5"+
		"\b\u00ad\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b8\n\t\f\t\16"+
		"\t\u00bb\13\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c3\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u00ce\n\n\f\n\16\n\u00d1\13\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e3"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\5\25\u0123\n\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u012c\n\26\3\27\3\27\3\27\5\27\u0131\n\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\5\34\u0148\n\34\3\35\3\35\3\36\6\36\u014d\n\36\r\36"+
		"\16\36\u014e\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0158\n\37\f\37\16"+
		"\37\u015b\13\37\5\37\u015d\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u0168\n\37\3 \5 \u016b\n \3 \5 \u016e\n \3 \5 \u0171\n \3 "+
		"\5 \u0174\n \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\5\"\u017f\n\"\3#\3#\3#\3#\5"+
		"#\u0185\n#\3$\3$\3$\6$\u018a\n$\r$\16$\u018b\3%\3%\3%\7%\u0191\n%\f%\16"+
		"%\u0194\13%\3%\3%\3%\3%\7%\u019a\n%\f%\16%\u019d\13%\3%\5%\u01a0\n%\3"+
		"&\3&\6&\u01a4\n&\r&\16&\u01a5\3\'\3\'\3\'\3\'\3\'\7\'\u01ad\n\'\f\'\16"+
		"\'\u01b0\13\'\3\'\3\'\5\'\u01b4\n\'\3\'\3\'\3(\3(\3(\6(\u01bb\n(\r(\16"+
		"(\u01bc\3)\3)\3)\7)\u01c2\n)\f)\16)\u01c5\13)\3)\3)\3)\3)\7)\u01cb\n)"+
		"\f)\16)\u01ce\13)\3*\3*\3+\3+\3+\5+\u01d5\n+\3+\5+\u01d8\n+\3,\3,\5,\u01dc"+
		"\n,\3,\5,\u01df\n,\3-\3-\5-\u01e3\n-\3-\5-\u01e6\n-\3.\3.\6.\u01ea\n."+
		"\r.\16.\u01eb\3/\3/\6/\u01f0\n/\r/\16/\u01f1\3\60\5\60\u01f5\n\60\3\60"+
		"\3\60\3\60\3\60\3\60\7\60\u01fc\n\60\f\60\16\60\u01ff\13\60\3\60\3\60"+
		"\5\60\u0203\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u020c\n\61\3"+
		"\62\3\62\3\62\3\62\3\63\3\63\5\63\u0214\n\63\3\64\3\64\3\64\3\64\3\64"+
		"\7\64\u021b\n\64\f\64\16\64\u021e\13\64\3\65\3\65\3\65\3\65\6\65\u0224"+
		"\n\65\r\65\16\65\u0225\3\66\3\66\3\66\6\66\u022b\n\66\r\66\16\66\u022c"+
		"\3\67\3\67\3\67\6\67\u0232\n\67\r\67\16\67\u0233\38\38\38\68\u0239\n8"+
		"\r8\168\u023a\39\39\39\39\39\39\39\79\u0244\n9\f9\169\u0247\139\39\39"+
		"\3:\3:\3:\3:\3:\3:\3:\5:\u0252\n:\7:\u0254\n:\f:\16:\u0257\13:\3:\3:\3"+
		";\3;\3;\3;\3;\5;\u0260\n;\3;\3;\3;\3;\7;\u0266\n;\f;\16;\u0269\13;\3;"+
		"\3;\5;\u026d\n;\3<\3<\3<\3<\3<\3<\3<\3<\7<\u0277\n<\f<\16<\u027a\13<\3"+
		"<\3<\5<\u027e\n<\3=\3=\3>\3>\3>\3>\3>\7>\u0287\n>\f>\16>\u028a\13>\3?"+
		"\3?\6?\u028e\n?\r?\16?\u028f\3@\3@\3@\3@\3A\3A\6A\u0298\nA\rA\16A\u0299"+
		"\3B\3B\3B\7B\u029f\nB\fB\16B\u02a2\13B\3B\3B\3B\3B\7B\u02a8\nB\fB\16B"+
		"\u02ab\13B\3B\3B\3B\3B\7B\u02b1\nB\fB\16B\u02b4\13B\5B\u02b6\nB\3B\3B"+
		"\3C\7C\u02bb\nC\fC\16C\u02be\13C\3D\3D\3D\3D\3E\3E\3E\3E\6E\u02c8\nE\r"+
		"E\16E\u02c9\3F\3F\3F\3F\3F\7F\u02d1\nF\fF\16F\u02d4\13F\5F\u02d6\nF\3"+
		"F\3F\3F\2\4\20\22G\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\2\5\3\2OQ\4\2:;==\3\2MN\u02f6\2\u008c\3\2\2\2\4\u008e\3\2"+
		"\2\2\6\u0090\3\2\2\2\b\u0092\3\2\2\2\n\u00a0\3\2\2\2\f\u00a8\3\2\2\2\16"+
		"\u00ac\3\2\2\2\20\u00ae\3\2\2\2\22\u00c2\3\2\2\2\24\u00e2\3\2\2\2\26\u00e4"+
		"\3\2\2\2\30\u00e9\3\2\2\2\32\u00f0\3\2\2\2\34\u00f7\3\2\2\2\36\u00fe\3"+
		"\2\2\2 \u0105\3\2\2\2\"\u010a\3\2\2\2$\u010f\3\2\2\2&\u0114\3\2\2\2(\u0122"+
		"\3\2\2\2*\u012b\3\2\2\2,\u0130\3\2\2\2.\u0132\3\2\2\2\60\u0134\3\2\2\2"+
		"\62\u0136\3\2\2\2\64\u013c\3\2\2\2\66\u0147\3\2\2\28\u0149\3\2\2\2:\u014c"+
		"\3\2\2\2<\u0167\3\2\2\2>\u016a\3\2\2\2@\u0175\3\2\2\2B\u017e\3\2\2\2D"+
		"\u0184\3\2\2\2F\u0186\3\2\2\2H\u018d\3\2\2\2J\u01a1\3\2\2\2L\u01a7\3\2"+
		"\2\2N\u01b7\3\2\2\2P\u01be\3\2\2\2R\u01cf\3\2\2\2T\u01d1\3\2\2\2V\u01d9"+
		"\3\2\2\2X\u01e0\3\2\2\2Z\u01e7\3\2\2\2\\\u01ed\3\2\2\2^\u01f4\3\2\2\2"+
		"`\u020b\3\2\2\2b\u020d\3\2\2\2d\u0213\3\2\2\2f\u0215\3\2\2\2h\u021f\3"+
		"\2\2\2j\u0227\3\2\2\2l\u022e\3\2\2\2n\u0235\3\2\2\2p\u023c\3\2\2\2r\u024a"+
		"\3\2\2\2t\u026c\3\2\2\2v\u027d\3\2\2\2x\u027f\3\2\2\2z\u0281\3\2\2\2|"+
		"\u028b\3\2\2\2~\u0291\3\2\2\2\u0080\u0295\3\2\2\2\u0082\u029b\3\2\2\2"+
		"\u0084\u02bc\3\2\2\2\u0086\u02bf\3\2\2\2\u0088\u02c3\3\2\2\2\u008a\u02cb"+
		"\3\2\2\2\u008c\u008d\t\2\2\2\u008d\3\3\2\2\2\u008e\u008f\t\3\2\2\u008f"+
		"\5\3\2\2\2\u0090\u0091\t\4\2\2\u0091\7\3\2\2\2\u0092\u009e\7M\2\2\u0093"+
		"\u0094\7\3\2\2\u0094\u0099\5\f\7\2\u0095\u0096\7\4\2\2\u0096\u0098\5\f"+
		"\7\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\5"+
		"\2\2\u009d\u009f\3\2\2\2\u009e\u0093\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\t\3\2\2\2\u00a0\u00a1\5\b\5\2\u00a1\13\3\2\2\2\u00a2\u00a9\79\2\2\u00a3"+
		"\u00a9\7N\2\2\u00a4\u00a9\7M\2\2\u00a5\u00a9\5\2\2\2\u00a6\u00a9\5\n\6"+
		"\2\u00a7\u00a9\5\20\t\2\u00a8\u00a2\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a8"+
		"\u00a4\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2"+
		"\2\2\u00a9\r\3\2\2\2\u00aa\u00ad\5\b\5\2\u00ab\u00ad\7N\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\17\3\2\2\2\u00ae\u00af\b\t\1\2\u00af"+
		"\u00b0\5\22\n\2\u00b0\u00b9\3\2\2\2\u00b1\u00b2\f\5\2\2\u00b2\u00b3\7"+
		"\6\2\2\u00b3\u00b8\5\22\n\2\u00b4\u00b5\f\4\2\2\u00b5\u00b6\7\7\2\2\u00b6"+
		"\u00b8\5\22\n\2\u00b7\u00b1\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b8\u00bb\3"+
		"\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\21\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bc\u00bd\b\n\1\2\u00bd\u00be\5\24\13\2\u00be\u00bf\7"+
		"\13\2\2\u00bf\u00c0\5\24\13\2\u00c0\u00c3\3\2\2\2\u00c1\u00c3\5\24\13"+
		"\2\u00c2\u00bc\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00cf\3\2\2\2\u00c4\u00c5"+
		"\f\7\2\2\u00c5\u00c6\7\b\2\2\u00c6\u00ce\5\24\13\2\u00c7\u00c8\f\6\2\2"+
		"\u00c8\u00c9\7\t\2\2\u00c9\u00ce\5\24\13\2\u00ca\u00cb\f\5\2\2\u00cb\u00cc"+
		"\7\n\2\2\u00cc\u00ce\5\24\13\2\u00cd\u00c4\3\2\2\2\u00cd\u00c7\3\2\2\2"+
		"\u00cd\u00ca\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0\23\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00e3\7N\2\2\u00d3"+
		"\u00d4\7\7\2\2\u00d4\u00e3\7N\2\2\u00d5\u00e3\5\2\2\2\u00d6\u00e3\5\n"+
		"\6\2\u00d7\u00d8\7\7\2\2\u00d8\u00e3\5\n\6\2\u00d9\u00da\7\3\2\2\u00da"+
		"\u00db\5\20\t\2\u00db\u00dc\7\5\2\2\u00dc\u00e3\3\2\2\2\u00dd\u00de\7"+
		"\7\2\2\u00de\u00df\7\3\2\2\u00df\u00e0\5\20\t\2\u00e0\u00e1\7\5\2\2\u00e1"+
		"\u00e3\3\2\2\2\u00e2\u00d2\3\2\2\2\u00e2\u00d3\3\2\2\2\u00e2\u00d5\3\2"+
		"\2\2\u00e2\u00d6\3\2\2\2\u00e2\u00d7\3\2\2\2\u00e2\u00d9\3\2\2\2\u00e2"+
		"\u00dd\3\2\2\2\u00e3\25\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\u00e6\7\3\2\2"+
		"\u00e6\u00e7\5\16\b\2\u00e7\u00e8\7\5\2\2\u00e8\27\3\2\2\2\u00e9\u00ea"+
		"\7@\2\2\u00ea\u00eb\7\3\2\2\u00eb\u00ec\5\16\b\2\u00ec\u00ed\7\4\2\2\u00ed"+
		"\u00ee\5D#\2\u00ee\u00ef\7\5\2\2\u00ef\31\3\2\2\2\u00f0\u00f1\7A\2\2\u00f1"+
		"\u00f2\7\3\2\2\u00f2\u00f3\5\16\b\2\u00f3\u00f4\7\4\2\2\u00f4\u00f5\5"+
		"D#\2\u00f5\u00f6\7\5\2\2\u00f6\33\3\2\2\2\u00f7\u00f8\7D\2\2\u00f8\u00f9"+
		"\7\3\2\2\u00f9\u00fa\5D#\2\u00fa\u00fb\7\4\2\2\u00fb\u00fc\5D#\2\u00fc"+
		"\u00fd\7\5\2\2\u00fd\35\3\2\2\2\u00fe\u00ff\7G\2\2\u00ff\u0100\7\3\2\2"+
		"\u0100\u0101\5D#\2\u0101\u0102\7\4\2\2\u0102\u0103\5D#\2\u0103\u0104\7"+
		"\5\2\2\u0104\37\3\2\2\2\u0105\u0106\7B\2\2\u0106\u0107\7\3\2\2\u0107\u0108"+
		"\5D#\2\u0108\u0109\7\5\2\2\u0109!\3\2\2\2\u010a\u010b\7C\2\2\u010b\u010c"+
		"\7\3\2\2\u010c\u010d\5D#\2\u010d\u010e\7\5\2\2\u010e#\3\2\2\2\u010f\u0110"+
		"\7F\2\2\u0110\u0111\7\3\2\2\u0111\u0112\5D#\2\u0112\u0113\7\5\2\2\u0113"+
		"%\3\2\2\2\u0114\u0115\7E\2\2\u0115\u0116\7\3\2\2\u0116\u0117\5D#\2\u0117"+
		"\u0118\7\5\2\2\u0118\'\3\2\2\2\u0119\u0123\5\30\r\2\u011a\u0123\5\32\16"+
		"\2\u011b\u0123\5\34\17\2\u011c\u0123\5\36\20\2\u011d\u0123\5 \21\2\u011e"+
		"\u0123\5\"\22\2\u011f\u0123\5$\23\2\u0120\u0123\5&\24\2\u0121\u0123\5"+
		"\n\6\2\u0122\u0119\3\2\2\2\u0122\u011a\3\2\2\2\u0122\u011b\3\2\2\2\u0122"+
		"\u011c\3\2\2\2\u0122\u011d\3\2\2\2\u0122\u011e\3\2\2\2\u0122\u011f\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2\2\u0123)\3\2\2\2\u0124\u012c"+
		"\5(\25\2\u0125\u0126\7\7\2\2\u0126\u012c\5(\25\2\u0127\u0128\5\f\7\2\u0128"+
		"\u0129\5\4\3\2\u0129\u012a\5\f\7\2\u012a\u012c\3\2\2\2\u012b\u0124\3\2"+
		"\2\2\u012b\u0125\3\2\2\2\u012b\u0127\3\2\2\2\u012c+\3\2\2\2\u012d\u0131"+
		"\5\26\f\2\u012e\u012f\7\7\2\2\u012f\u0131\5\26\f\2\u0130\u012d\3\2\2\2"+
		"\u0130\u012e\3\2\2\2\u0131-\3\2\2\2\u0132\u0133\5\6\4\2\u0133/\3\2\2\2"+
		"\u0134\u0135\5\6\4\2\u0135\61\3\2\2\2\u0136\u0137\7\f\2\2\u0137\u0138"+
		"\7\r\2\2\u0138\u0139\5\60\31\2\u0139\u013a\5\66\34\2\u013a\u013b\5z>\2"+
		"\u013b\63\3\2\2\2\u013c\u013d\5\6\4\2\u013d\65\3\2\2\2\u013e\u013f\7\16"+
		"\2\2\u013f\u0140\5\64\33\2\u0140\u0141\5:\36\2\u0141\u0148\3\2\2\2\u0142"+
		"\u0143\7\17\2\2\u0143\u0144\5\64\33\2\u0144\u0145\7\20\2\2\u0145\u0146"+
		"\5.\30\2\u0146\u0148\3\2\2\2\u0147\u013e\3\2\2\2\u0147\u0142\3\2\2\2\u0148"+
		"\67\3\2\2\2\u0149\u014a\5\6\4\2\u014a9\3\2\2\2\u014b\u014d\5<\37\2\u014c"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014f;\3\2\2\2\u0150\u0151\7\21\2\2\u0151\u015c\58\35\2\u0152\u0153"+
		"\7\22\2\2\u0153\u0154\7\23\2\2\u0154\u0159\58\35\2\u0155\u0156\7\4\2\2"+
		"\u0156\u0158\58\35\2\u0157\u0155\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157"+
		"\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015c"+
		"\u0152\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\5>"+
		" \2\u015f\u0168\3\2\2\2\u0160\u0161\7\17\2\2\u0161\u0162\5\64\33\2\u0162"+
		"\u0163\7\24\2\2\u0163\u0164\58\35\2\u0164\u0165\7\20\2\2\u0165\u0166\5"+
		".\30\2\u0166\u0168\3\2\2\2\u0167\u0150\3\2\2\2\u0167\u0160\3\2\2\2\u0168"+
		"=\3\2\2\2\u0169\u016b\5F$\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u016d\3\2\2\2\u016c\u016e\5N(\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2"+
		"\2\u016e\u0170\3\2\2\2\u016f\u0171\5T+\2\u0170\u016f\3\2\2\2\u0170\u0171"+
		"\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u0174\5f\64\2\u0173\u0172\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174?\3\2\2\2\u0175\u0176\7\25\2\2\u0176\u0177\5\2\2\2"+
		"\u0177\u0178\7\26\2\2\u0178\u0179\5\2\2\2\u0179\u017a\7\27\2\2\u017aA"+
		"\3\2\2\2\u017b\u017f\7I\2\2\u017c\u017f\7J\2\2\u017d\u017f\5@!\2\u017e"+
		"\u017b\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017fC\3\2\2\2"+
		"\u0180\u0185\5B\"\2\u0181\u0185\7K\2\2\u0182\u0185\7L\2\2\u0183\u0185"+
		"\7M\2\2\u0184\u0180\3\2\2\2\u0184\u0181\3\2\2\2\u0184\u0182\3\2\2\2\u0184"+
		"\u0183\3\2\2\2\u0185E\3\2\2\2\u0186\u0187\7\30\2\2\u0187\u0189\7\31\2"+
		"\2\u0188\u018a\5H%\2\u0189\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0189"+
		"\3\2\2\2\u018b\u018c\3\2\2\2\u018cG\3\2\2\2\u018d\u0192\7M\2\2\u018e\u018f"+
		"\7\4\2\2\u018f\u0191\7M\2\2\u0190\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0195\u0196\7\32\2\2\u0196\u019b\5D#\2\u0197\u0198\7\4\2\2\u0198"+
		"\u019a\5D#\2\u0199\u0197\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2"+
		"\2\u019b\u019c\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u01a0"+
		"\5J&\2\u019f\u019e\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0I\3\2\2\2\u01a1\u01a3"+
		"\7\33\2\2\u01a2\u01a4\5L\'\2\u01a3\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5"+
		"\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6K\3\2\2\2\u01a7\u01a8\7M\2\2\u01a8"+
		"\u01b3\7\34\2\2\u01a9\u01ae\5D#\2\u01aa\u01ab\7\4\2\2\u01ab\u01ad\5D#"+
		"\2\u01ac\u01aa\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af"+
		"\3\2\2\2\u01af\u01b1\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b2\7>\2\2\u01b2"+
		"\u01b4\3\2\2\2\u01b3\u01a9\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\3\2"+
		"\2\2\u01b5\u01b6\5D#\2\u01b6M\3\2\2\2\u01b7\u01b8\7\35\2\2\u01b8\u01ba"+
		"\7\36\2\2\u01b9\u01bb\5P)\2\u01ba\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bdO\3\2\2\2\u01be\u01c3\5\b\5\2"+
		"\u01bf\u01c0\7\4\2\2\u01c0\u01c2\5\b\5\2\u01c1\u01bf\3\2\2\2\u01c2\u01c5"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c6\u01c7\7\34\2\2\u01c7\u01cc\5D#\2\u01c8\u01c9\7\4"+
		"\2\2\u01c9\u01cb\5D#\2\u01ca\u01c8\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca"+
		"\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cdQ\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf"+
		"\u01d0\7M\2\2\u01d0S\3\2\2\2\u01d1\u01d2\7\37\2\2\u01d2\u01d4\7\31\2\2"+
		"\u01d3\u01d5\5V,\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7"+
		"\3\2\2\2\u01d6\u01d8\5X-\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"U\3\2\2\2\u01d9\u01db\7 \2\2\u01da\u01dc\5Z.\2\u01db\u01da\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01df\5\\/\2\u01de\u01dd\3\2"+
		"\2\2\u01de\u01df\3\2\2\2\u01dfW\3\2\2\2\u01e0\u01e2\7!\2\2\u01e1\u01e3"+
		"\5Z.\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4"+
		"\u01e6\5\\/\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6Y\3\2\2\2\u01e7"+
		"\u01e9\7\"\2\2\u01e8\u01ea\5^\60\2\u01e9\u01e8\3\2\2\2\u01ea\u01eb\3\2"+
		"\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec[\3\2\2\2\u01ed\u01ef"+
		"\7#\2\2\u01ee\u01f0\5^\60\2\u01ef\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2]\3\2\2\2\u01f3\u01f5\7$\2\2\u01f4"+
		"\u01f3\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\5R"+
		"*\2\u01f7\u01f8\7\34\2\2\u01f8\u0202\5D#\2\u01f9\u01fa\7\b\2\2\u01fa\u01fc"+
		"\5D#\2\u01fb\u01f9\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd"+
		"\u01fe\3\2\2\2\u01fe\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0201\7>"+
		"\2\2\u0201\u0203\5D#\2\u0202\u01fd\3\2\2\2\u0202\u0203\3\2\2\2\u0203_"+
		"\3\2\2\2\u0204\u0205\5\n\6\2\u0205\u0206\7:\2\2\u0206\u0207\5\f\7\2\u0207"+
		"\u020c\3\2\2\2\u0208\u020c\5\n\6\2\u0209\u020a\7\7\2\2\u020a\u020c\5\n"+
		"\6\2\u020b\u0204\3\2\2\2\u020b\u0208\3\2\2\2\u020b\u0209\3\2\2\2\u020c"+
		"a\3\2\2\2\u020d\u020e\5\n\6\2\u020e\u020f\7;\2\2\u020f\u0210\5\f\7\2\u0210"+
		"c\3\2\2\2\u0211\u0214\5`\61\2\u0212\u0214\5b\62\2\u0213\u0211\3\2\2\2"+
		"\u0213\u0212\3\2\2\2\u0214e\3\2\2\2\u0215\u021c\7%\2\2\u0216\u021b\5h"+
		"\65\2\u0217\u021b\5j\66\2\u0218\u021b\5l\67\2\u0219\u021b\5n8\2\u021a"+
		"\u0216\3\2\2\2\u021a\u0217\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u0219\3\2"+
		"\2\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d"+
		"g\3\2\2\2\u021e\u021c\3\2\2\2\u021f\u0220\7&\2\2\u0220\u0221\7\'\2\2\u0221"+
		"\u0223\7(\2\2\u0222\u0224\5p9\2\u0223\u0222\3\2\2\2\u0224\u0225\3\2\2"+
		"\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226i\3\2\2\2\u0227\u0228"+
		"\7)\2\2\u0228\u022a\7*\2\2\u0229\u022b\5r:\2\u022a\u0229\3\2\2\2\u022b"+
		"\u022c\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022dk\3\2\2\2"+
		"\u022e\u022f\7+\2\2\u022f\u0231\7,\2\2\u0230\u0232\5t;\2\u0231\u0230\3"+
		"\2\2\2\u0232\u0233\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234"+
		"m\3\2\2\2\u0235\u0236\7\37\2\2\u0236\u0238\7-\2\2\u0237\u0239\5v<\2\u0238"+
		"\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2"+
		"\2\2\u023bo\3\2\2\2\u023c\u023d\5\26\f\2\u023d\u023e\7.\2\2\u023e\u023f"+
		"\5`\61\2\u023f\u0240\7/\2\2\u0240\u0245\5\30\r\2\u0241\u0242\7\4\2\2\u0242"+
		"\u0244\5*\26\2\u0243\u0241\3\2\2\2\u0244\u0247\3\2\2\2\u0245\u0243\3\2"+
		"\2\2\u0245\u0246\3\2\2\2\u0246\u0248\3\2\2\2\u0247\u0245\3\2\2\2\u0248"+
		"\u0249\7\24\2\2\u0249q\3\2\2\2\u024a\u024b\7\60\2\2\u024b\u024c\5\26\f"+
		"\2\u024c\u024d\7/\2\2\u024d\u0255\5\30\r\2\u024e\u0251\7\4\2\2\u024f\u0252"+
		"\5,\27\2\u0250\u0252\5*\26\2\u0251\u024f\3\2\2\2\u0251\u0250\3\2\2\2\u0252"+
		"\u0254\3\2\2\2\u0253\u024e\3\2\2\2\u0254\u0257\3\2\2\2\u0255\u0253\3\2"+
		"\2\2\u0255\u0256\3\2\2\2\u0256\u0258\3\2\2\2\u0257\u0255\3\2\2\2\u0258"+
		"\u0259\7\24\2\2\u0259s\3\2\2\2\u025a\u025b\5d\63\2\u025b\u025c\7\24\2"+
		"\2\u025c\u026d\3\2\2\2\u025d\u0260\7\61\2\2\u025e\u0260\5d\63\2\u025f"+
		"\u025d\3\2\2\2\u025f\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0262\7/"+
		"\2\2\u0262\u0267\5*\26\2\u0263\u0264\7\4\2\2\u0264\u0266\5*\26\2\u0265"+
		"\u0263\3\2\2\2\u0266\u0269\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2"+
		"\2\2\u0268\u026a\3\2\2\2\u0269\u0267\3\2\2\2\u026a\u026b\7\24\2\2\u026b"+
		"\u026d\3\2\2\2\u026c\u025a\3\2\2\2\u026c\u025f\3\2\2\2\u026du\3\2\2\2"+
		"\u026e\u026f\5d\63\2\u026f\u0270\7\24\2\2\u0270\u027e\3\2\2\2\u0271\u0272"+
		"\5d\63\2\u0272\u0273\7/\2\2\u0273\u0278\5*\26\2\u0274\u0275\7\4\2\2\u0275"+
		"\u0277\5*\26\2\u0276\u0274\3\2\2\2\u0277\u027a\3\2\2\2\u0278\u0276\3\2"+
		"\2\2\u0278\u0279\3\2\2\2\u0279\u027b\3\2\2\2\u027a\u0278\3\2\2\2\u027b"+
		"\u027c\7\24\2\2\u027c\u027e\3\2\2\2\u027d\u026e\3\2\2\2\u027d\u0271\3"+
		"\2\2\2\u027ew\3\2\2\2\u027f\u0280\5\6\4\2\u0280y\3\2\2\2\u0281\u0282\7"+
		"\62\2\2\u0282\u0288\5x=\2\u0283\u0287\5|?\2\u0284\u0287\5\u0080A\2\u0285"+
		"\u0287\5\u0088E\2\u0286\u0283\3\2\2\2\u0286\u0284\3\2\2\2\u0286\u0285"+
		"\3\2\2\2\u0287\u028a\3\2\2\2\u0288\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289"+
		"{\3\2\2\2\u028a\u0288\3\2\2\2\u028b\u028d\7\36\2\2\u028c\u028e\5~@\2\u028d"+
		"\u028c\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2"+
		"\2\2\u0290}\3\2\2\2\u0291\u0292\5\b\5\2\u0292\u0293\7:\2\2\u0293\u0294"+
		"\5\f\7\2\u0294\177\3\2\2\2\u0295\u0297\7\63\2\2\u0296\u0298\5\u0082B\2"+
		"\u0297\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u0297\3\2\2\2\u0299\u029a"+
		"\3\2\2\2\u029a\u0081\3\2\2\2\u029b\u02a0\5\b\5\2\u029c\u029d\7\4\2\2\u029d"+
		"\u029f\5\b\5\2\u029e\u029c\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0\u029e\3\2"+
		"\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a3\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a3"+
		"\u02a4\7\64\2\2\u02a4\u02a9\5D#\2\u02a5\u02a6\7\4\2\2\u02a6\u02a8\5D#"+
		"\2\u02a7\u02a5\3\2\2\2\u02a8\u02ab\3\2\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02aa"+
		"\3\2\2\2\u02aa\u02b5\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ac\u02ad\7\65\2\2"+
		"\u02ad\u02b2\5*\26\2\u02ae\u02af\7\4\2\2\u02af\u02b1\5*\26\2\u02b0\u02ae"+
		"\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3"+
		"\u02b6\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5\u02ac\3\2\2\2\u02b5\u02b6\3\2"+
		"\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\5\u0084C\2\u02b8\u0083\3\2\2\2\u02b9"+
		"\u02bb\5\u0086D\2\u02ba\u02b9\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba"+
		"\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u0085\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf"+
		"\u02c0\5\n\6\2\u02c0\u02c1\7:\2\2\u02c1\u02c2\5\f\7\2\u02c2\u0087\3\2"+
		"\2\2\u02c3\u02c4\7\66\2\2\u02c4\u02c5\7\67\2\2\u02c5\u02c7\7 \2\2\u02c6"+
		"\u02c8\5\u008aF\2\u02c7\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02c7"+
		"\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u0089\3\2\2\2\u02cb\u02d5\5d\63\2\u02cc"+
		"\u02cd\7/\2\2\u02cd\u02d2\5*\26\2\u02ce\u02cf\7\4\2\2\u02cf\u02d1\5*\26"+
		"\2\u02d0\u02ce\3\2\2\2\u02d1\u02d4\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2\u02d3"+
		"\3\2\2\2\u02d3\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d5\u02cc\3\2\2\2\u02d5"+
		"\u02d6\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d8\7\24\2\2\u02d8\u008b\3"+
		"\2\2\2K\u0099\u009e\u00a8\u00ac\u00b7\u00b9\u00c2\u00cd\u00cf\u00e2\u0122"+
		"\u012b\u0130\u0147\u014e\u0159\u015c\u0167\u016a\u016d\u0170\u0173\u017e"+
		"\u0184\u018b\u0192\u019b\u019f\u01a5\u01ae\u01b3\u01bc\u01c3\u01cc\u01d4"+
		"\u01d7\u01db\u01de\u01e2\u01e5\u01eb\u01f1\u01f4\u01fd\u0202\u020b\u0213"+
		"\u021a\u021c\u0225\u022c\u0233\u023a\u0245\u0251\u0255\u025f\u0267\u026c"+
		"\u0278\u027d\u0286\u0288\u028f\u0299\u02a0\u02a9\u02b2\u02b5\u02bc\u02c9"+
		"\u02d2\u02d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}