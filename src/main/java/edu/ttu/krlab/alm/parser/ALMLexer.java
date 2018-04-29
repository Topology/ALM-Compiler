// Generated from ALM.g4 by ANTLR 4.7

    package edu.ttu.krlab.alm.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ALMLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "WhiteSpace", "MOD", "EQ", 
		"NEQ", "ARITH_OP", "COMP_REL", "RIGHT_ARROW", "OCCURS", "INSTANCE", "IS_A", 
		"HAS_CHILD", "HAS_PARENT", "LINK", "SOURCE", "SINK", "SUBSORT", "DOM", 
		"SORT", "STATE", "CONSTRAINTS", "FUNCTION", "DECLARATIONS", "DEFINITIONS", 
		"SYSTEM", "DESCRIPTION", "THEORY", "MODULE", "IMPORT", "FROM", "DEPENDS", 
		"ON", "ATTRIBUTES", "OBJECT", "CONSTANT", "STATICS", "FLUENTS", "BASIC", 
		"DEFINED", "TOTAL", "AXIOMS", "DYNAMIC", "CAUSAL", "LAWS", "EXECUTABILITY", 
		"CONDITIONS", "CAUSES", "IMPOSSIBLE", "IF", "FALSE", "TRUE", "STRUCTURE", 
		"IN", "WHERE", "VALUE", "OF", "INSTANCES", "TEMPORAL", "PROJECTION", "MAX", 
		"STEPS", "HISTORY", "OBSERVED", "HAPPENED", "BOOLEAN", "INTEGERS", "UNIVERSE", 
		"ACTIONS", "ID", "VAR", "POSINT", "NEGINT", "ZERO"
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


	public ALMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ALM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2X\u02d9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00e0\n\24\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00e7\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3"+
		")\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\38\38\38\38\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3;\3"+
		";\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3"+
		"<\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3@\3"+
		"@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3"+
		"D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3"+
		"G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3J\3"+
		"J\3J\3J\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3"+
		"M\3M\3M\3N\3N\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O\3O\3P\3P\3"+
		"P\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3R\3R\3"+
		"R\3S\3S\7S\u02ba\nS\fS\16S\u02bd\13S\3T\3T\7T\u02c1\nT\fT\16T\u02c4\13"+
		"T\3U\3U\7U\u02c8\nU\fU\16U\u02cb\13U\3V\3V\3V\7V\u02d0\nV\fV\16V\u02d3"+
		"\13V\3W\6W\u02d6\nW\rW\16W\u02d7\2\2X\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097"+
		"M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00ab"+
		"W\u00adX\3\2\13\5\2\13\f\17\17\"\"\5\2,-//\61\61\4\2>>@@\3\2c|\7\2//\62"+
		";C\\aac|\3\2C\\\3\2\63;\3\2\62;\3\2\62\62\2\u02e1\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3"+
		"\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2"+
		"\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2"+
		"\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab"+
		"\3\2\2\2\2\u00ad\3\2\2\2\3\u00af\3\2\2\2\5\u00b1\3\2\2\2\7\u00b3\3\2\2"+
		"\2\t\u00b5\3\2\2\2\13\u00b7\3\2\2\2\r\u00b9\3\2\2\2\17\u00bb\3\2\2\2\21"+
		"\u00bd\3\2\2\2\23\u00bf\3\2\2\2\25\u00c1\3\2\2\2\27\u00c3\3\2\2\2\31\u00c6"+
		"\3\2\2\2\33\u00c8\3\2\2\2\35\u00cb\3\2\2\2\37\u00cd\3\2\2\2!\u00d1\3\2"+
		"\2\2#\u00d5\3\2\2\2%\u00d7\3\2\2\2\'\u00df\3\2\2\2)\u00e6\3\2\2\2+\u00e8"+
		"\3\2\2\2-\u00eb\3\2\2\2/\u00f2\3\2\2\2\61\u00fb\3\2\2\2\63\u0100\3\2\2"+
		"\2\65\u010a\3\2\2\2\67\u0115\3\2\2\29\u011a\3\2\2\2;\u0121\3\2\2\2=\u0126"+
		"\3\2\2\2?\u012e\3\2\2\2A\u0132\3\2\2\2C\u0137\3\2\2\2E\u013d\3\2\2\2G"+
		"\u0149\3\2\2\2I\u0152\3\2\2\2K\u015f\3\2\2\2M\u016b\3\2\2\2O\u0172\3\2"+
		"\2\2Q\u017e\3\2\2\2S\u0185\3\2\2\2U\u018c\3\2\2\2W\u0193\3\2\2\2Y\u0198"+
		"\3\2\2\2[\u01a0\3\2\2\2]\u01a3\3\2\2\2_\u01ae\3\2\2\2a\u01b5\3\2\2\2c"+
		"\u01be\3\2\2\2e\u01c6\3\2\2\2g\u01ce\3\2\2\2i\u01d4\3\2\2\2k\u01dc\3\2"+
		"\2\2m\u01e2\3\2\2\2o\u01e9\3\2\2\2q\u01f1\3\2\2\2s\u01f8\3\2\2\2u\u01fd"+
		"\3\2\2\2w\u020b\3\2\2\2y\u0216\3\2\2\2{\u021d\3\2\2\2}\u0228\3\2\2\2\177"+
		"\u022b\3\2\2\2\u0081\u0231\3\2\2\2\u0083\u0236\3\2\2\2\u0085\u0240\3\2"+
		"\2\2\u0087\u0243\3\2\2\2\u0089\u0249\3\2\2\2\u008b\u024f\3\2\2\2\u008d"+
		"\u0252\3\2\2\2\u008f\u025c\3\2\2\2\u0091\u0265\3\2\2\2\u0093\u0270\3\2"+
		"\2\2\u0095\u0274\3\2\2\2\u0097\u027a\3\2\2\2\u0099\u0282\3\2\2\2\u009b"+
		"\u028b\3\2\2\2\u009d\u0294\3\2\2\2\u009f\u029d\3\2\2\2\u00a1\u02a6\3\2"+
		"\2\2\u00a3\u02af\3\2\2\2\u00a5\u02b7\3\2\2\2\u00a7\u02be\3\2\2\2\u00a9"+
		"\u02c5\3\2\2\2\u00ab\u02cc\3\2\2\2\u00ad\u02d5\3\2\2\2\u00af\u00b0\7*"+
		"\2\2\u00b0\4\3\2\2\2\u00b1\u00b2\7.\2\2\u00b2\6\3\2\2\2\u00b3\u00b4\7"+
		"+\2\2\u00b4\b\3\2\2\2\u00b5\u00b6\7-\2\2\u00b6\n\3\2\2\2\u00b7\u00b8\7"+
		"/\2\2\u00b8\f\3\2\2\2\u00b9\u00ba\7,\2\2\u00ba\16\3\2\2\2\u00bb\u00bc"+
		"\7\61\2\2\u00bc\20\3\2\2\2\u00bd\u00be\7`\2\2\u00be\22\3\2\2\2\u00bf\u00c0"+
		"\7\60\2\2\u00c0\24\3\2\2\2\u00c1\u00c2\7]\2\2\u00c2\26\3\2\2\2\u00c3\u00c4"+
		"\7\60\2\2\u00c4\u00c5\7\60\2\2\u00c5\30\3\2\2\2\u00c6\u00c7\7_\2\2\u00c7"+
		"\32\3\2\2\2\u00c8\u00c9\7<\2\2\u00c9\u00ca\7<\2\2\u00ca\34\3\2\2\2\u00cb"+
		"\u00cc\7<\2\2\u00cc\36\3\2\2\2\u00cd\u00ce\t\2\2\2\u00ce\u00cf\3\2\2\2"+
		"\u00cf\u00d0\b\20\2\2\u00d0 \3\2\2\2\u00d1\u00d2\7o\2\2\u00d2\u00d3\7"+
		"q\2\2\u00d3\u00d4\7f\2\2\u00d4\"\3\2\2\2\u00d5\u00d6\7?\2\2\u00d6$\3\2"+
		"\2\2\u00d7\u00d8\7#\2\2\u00d8\u00d9\7?\2\2\u00d9&\3\2\2\2\u00da\u00e0"+
		"\t\3\2\2\u00db\u00dc\7o\2\2\u00dc\u00dd\7q\2\2\u00dd\u00e0\7f\2\2\u00de"+
		"\u00e0\7`\2\2\u00df\u00da\3\2\2\2\u00df\u00db\3\2\2\2\u00df\u00de\3\2"+
		"\2\2\u00e0(\3\2\2\2\u00e1\u00e7\t\4\2\2\u00e2\u00e3\7>\2\2\u00e3\u00e7"+
		"\7?\2\2\u00e4\u00e5\7@\2\2\u00e5\u00e7\7?\2\2\u00e6\u00e1\3\2\2\2\u00e6"+
		"\u00e2\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7*\3\2\2\2\u00e8\u00e9\7/\2\2\u00e9"+
		"\u00ea\7@\2\2\u00ea,\3\2\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7e\2\2\u00ed"+
		"\u00ee\7e\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7t\2\2\u00f0\u00f1\7u\2\2"+
		"\u00f1.\3\2\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7u\2"+
		"\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7c\2\2\u00f7\u00f8\7p\2\2\u00f8\u00f9"+
		"\7e\2\2\u00f9\u00fa\7g\2\2\u00fa\60\3\2\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd"+
		"\7u\2\2\u00fd\u00fe\7a\2\2\u00fe\u00ff\7c\2\2\u00ff\62\3\2\2\2\u0100\u0101"+
		"\7j\2\2\u0101\u0102\7c\2\2\u0102\u0103\7u\2\2\u0103\u0104\7a\2\2\u0104"+
		"\u0105\7e\2\2\u0105\u0106\7j\2\2\u0106\u0107\7k\2\2\u0107\u0108\7n\2\2"+
		"\u0108\u0109\7f\2\2\u0109\64\3\2\2\2\u010a\u010b\7j\2\2\u010b\u010c\7"+
		"c\2\2\u010c\u010d\7u\2\2\u010d\u010e\7a\2\2\u010e\u010f\7r\2\2\u010f\u0110"+
		"\7c\2\2\u0110\u0111\7t\2\2\u0111\u0112\7g\2\2\u0112\u0113\7p\2\2\u0113"+
		"\u0114\7v\2\2\u0114\66\3\2\2\2\u0115\u0116\7n\2\2\u0116\u0117\7k\2\2\u0117"+
		"\u0118\7p\2\2\u0118\u0119\7m\2\2\u01198\3\2\2\2\u011a\u011b\7u\2\2\u011b"+
		"\u011c\7q\2\2\u011c\u011d\7w\2\2\u011d\u011e\7t\2\2\u011e\u011f\7e\2\2"+
		"\u011f\u0120\7g\2\2\u0120:\3\2\2\2\u0121\u0122\7u\2\2\u0122\u0123\7k\2"+
		"\2\u0123\u0124\7p\2\2\u0124\u0125\7m\2\2\u0125<\3\2\2\2\u0126\u0127\7"+
		"u\2\2\u0127\u0128\7w\2\2\u0128\u0129\7d\2\2\u0129\u012a\7u\2\2\u012a\u012b"+
		"\7q\2\2\u012b\u012c\7t\2\2\u012c\u012d\7v\2\2\u012d>\3\2\2\2\u012e\u012f"+
		"\7F\2\2\u012f\u0130\7Q\2\2\u0130\u0131\7O\2\2\u0131@\3\2\2\2\u0132\u0133"+
		"\7u\2\2\u0133\u0134\7q\2\2\u0134\u0135\7t\2\2\u0135\u0136\7v\2\2\u0136"+
		"B\3\2\2\2\u0137\u0138\7u\2\2\u0138\u0139\7v\2\2\u0139\u013a\7c\2\2\u013a"+
		"\u013b\7v\2\2\u013b\u013c\7g\2\2\u013cD\3\2\2\2\u013d\u013e\7e\2\2\u013e"+
		"\u013f\7q\2\2\u013f\u0140\7p\2\2\u0140\u0141\7u\2\2\u0141\u0142\7v\2\2"+
		"\u0142\u0143\7t\2\2\u0143\u0144\7c\2\2\u0144\u0145\7k\2\2\u0145\u0146"+
		"\7p\2\2\u0146\u0147\7v\2\2\u0147\u0148\7u\2\2\u0148F\3\2\2\2\u0149\u014a"+
		"\7h\2\2\u014a\u014b\7w\2\2\u014b\u014c\7p\2\2\u014c\u014d\7e\2\2\u014d"+
		"\u014e\7v\2\2\u014e\u014f\7k\2\2\u014f\u0150\7q\2\2\u0150\u0151\7p\2\2"+
		"\u0151H\3\2\2\2\u0152\u0153\7f\2\2\u0153\u0154\7g\2\2\u0154\u0155\7e\2"+
		"\2\u0155\u0156\7n\2\2\u0156\u0157\7c\2\2\u0157\u0158\7t\2\2\u0158\u0159"+
		"\7c\2\2\u0159\u015a\7v\2\2\u015a\u015b\7k\2\2\u015b\u015c\7q\2\2\u015c"+
		"\u015d\7p\2\2\u015d\u015e\7u\2\2\u015eJ\3\2\2\2\u015f\u0160\7f\2\2\u0160"+
		"\u0161\7g\2\2\u0161\u0162\7h\2\2\u0162\u0163\7k\2\2\u0163\u0164\7p\2\2"+
		"\u0164\u0165\7k\2\2\u0165\u0166\7v\2\2\u0166\u0167\7k\2\2\u0167\u0168"+
		"\7q\2\2\u0168\u0169\7p\2\2\u0169\u016a\7u\2\2\u016aL\3\2\2\2\u016b\u016c"+
		"\7u\2\2\u016c\u016d\7{\2\2\u016d\u016e\7u\2\2\u016e\u016f\7v\2\2\u016f"+
		"\u0170\7g\2\2\u0170\u0171\7o\2\2\u0171N\3\2\2\2\u0172\u0173\7f\2\2\u0173"+
		"\u0174\7g\2\2\u0174\u0175\7u\2\2\u0175\u0176\7e\2\2\u0176\u0177\7t\2\2"+
		"\u0177\u0178\7k\2\2\u0178\u0179\7r\2\2\u0179\u017a\7v\2\2\u017a\u017b"+
		"\7k\2\2\u017b\u017c\7q\2\2\u017c\u017d\7p\2\2\u017dP\3\2\2\2\u017e\u017f"+
		"\7v\2\2\u017f\u0180\7j\2\2\u0180\u0181\7g\2\2\u0181\u0182\7q\2\2\u0182"+
		"\u0183\7t\2\2\u0183\u0184\7{\2\2\u0184R\3\2\2\2\u0185\u0186\7o\2\2\u0186"+
		"\u0187\7q\2\2\u0187\u0188\7f\2\2\u0188\u0189\7w\2\2\u0189\u018a\7n\2\2"+
		"\u018a\u018b\7g\2\2\u018bT\3\2\2\2\u018c\u018d\7k\2\2\u018d\u018e\7o\2"+
		"\2\u018e\u018f\7r\2\2\u018f\u0190\7q\2\2\u0190\u0191\7t\2\2\u0191\u0192"+
		"\7v\2\2\u0192V\3\2\2\2\u0193\u0194\7h\2\2\u0194\u0195\7t\2\2\u0195\u0196"+
		"\7q\2\2\u0196\u0197\7o\2\2\u0197X\3\2\2\2\u0198\u0199\7f\2\2\u0199\u019a"+
		"\7g\2\2\u019a\u019b\7r\2\2\u019b\u019c\7g\2\2\u019c\u019d\7p\2\2\u019d"+
		"\u019e\7f\2\2\u019e\u019f\7u\2\2\u019fZ\3\2\2\2\u01a0\u01a1\7q\2\2\u01a1"+
		"\u01a2\7p\2\2\u01a2\\\3\2\2\2\u01a3\u01a4\7c\2\2\u01a4\u01a5\7v\2\2\u01a5"+
		"\u01a6\7v\2\2\u01a6\u01a7\7t\2\2\u01a7\u01a8\7k\2\2\u01a8\u01a9\7d\2\2"+
		"\u01a9\u01aa\7w\2\2\u01aa\u01ab\7v\2\2\u01ab\u01ac\7g\2\2\u01ac\u01ad"+
		"\7u\2\2\u01ad^\3\2\2\2\u01ae\u01af\7q\2\2\u01af\u01b0\7d\2\2\u01b0\u01b1"+
		"\7l\2\2\u01b1\u01b2\7g\2\2\u01b2\u01b3\7e\2\2\u01b3\u01b4\7v\2\2\u01b4"+
		"`\3\2\2\2\u01b5\u01b6\7e\2\2\u01b6\u01b7\7q\2\2\u01b7\u01b8\7p\2\2\u01b8"+
		"\u01b9\7u\2\2\u01b9\u01ba\7v\2\2\u01ba\u01bb\7c\2\2\u01bb\u01bc\7p\2\2"+
		"\u01bc\u01bd\7v\2\2\u01bdb\3\2\2\2\u01be\u01bf\7u\2\2\u01bf\u01c0\7v\2"+
		"\2\u01c0\u01c1\7c\2\2\u01c1\u01c2\7v\2\2\u01c2\u01c3\7k\2\2\u01c3\u01c4"+
		"\7e\2\2\u01c4\u01c5\7u\2\2\u01c5d\3\2\2\2\u01c6\u01c7\7h\2\2\u01c7\u01c8"+
		"\7n\2\2\u01c8\u01c9\7w\2\2\u01c9\u01ca\7g\2\2\u01ca\u01cb\7p\2\2\u01cb"+
		"\u01cc\7v\2\2\u01cc\u01cd\7u\2\2\u01cdf\3\2\2\2\u01ce\u01cf\7d\2\2\u01cf"+
		"\u01d0\7c\2\2\u01d0\u01d1\7u\2\2\u01d1\u01d2\7k\2\2\u01d2\u01d3\7e\2\2"+
		"\u01d3h\3\2\2\2\u01d4\u01d5\7f\2\2\u01d5\u01d6\7g\2\2\u01d6\u01d7\7h\2"+
		"\2\u01d7\u01d8\7k\2\2\u01d8\u01d9\7p\2\2\u01d9\u01da\7g\2\2\u01da\u01db"+
		"\7f\2\2\u01dbj\3\2\2\2\u01dc\u01dd\7v\2\2\u01dd\u01de\7q\2\2\u01de\u01df"+
		"\7v\2\2\u01df\u01e0\7c\2\2\u01e0\u01e1\7n\2\2\u01e1l\3\2\2\2\u01e2\u01e3"+
		"\7c\2\2\u01e3\u01e4\7z\2\2\u01e4\u01e5\7k\2\2\u01e5\u01e6\7q\2\2\u01e6"+
		"\u01e7\7o\2\2\u01e7\u01e8\7u\2\2\u01e8n\3\2\2\2\u01e9\u01ea\7f\2\2\u01ea"+
		"\u01eb\7{\2\2\u01eb\u01ec\7p\2\2\u01ec\u01ed\7c\2\2\u01ed\u01ee\7o\2\2"+
		"\u01ee\u01ef\7k\2\2\u01ef\u01f0\7e\2\2\u01f0p\3\2\2\2\u01f1\u01f2\7e\2"+
		"\2\u01f2\u01f3\7c\2\2\u01f3\u01f4\7w\2\2\u01f4\u01f5\7u\2\2\u01f5\u01f6"+
		"\7c\2\2\u01f6\u01f7\7n\2\2\u01f7r\3\2\2\2\u01f8\u01f9\7n\2\2\u01f9\u01fa"+
		"\7c\2\2\u01fa\u01fb\7y\2\2\u01fb\u01fc\7u\2\2\u01fct\3\2\2\2\u01fd\u01fe"+
		"\7g\2\2\u01fe\u01ff\7z\2\2\u01ff\u0200\7g\2\2\u0200\u0201\7e\2\2\u0201"+
		"\u0202\7w\2\2\u0202\u0203\7v\2\2\u0203\u0204\7c\2\2\u0204\u0205\7d\2\2"+
		"\u0205\u0206\7k\2\2\u0206\u0207\7n\2\2\u0207\u0208\7k\2\2\u0208\u0209"+
		"\7v\2\2\u0209\u020a\7{\2\2\u020av\3\2\2\2\u020b\u020c\7e\2\2\u020c\u020d"+
		"\7q\2\2\u020d\u020e\7p\2\2\u020e\u020f\7f\2\2\u020f\u0210\7k\2\2\u0210"+
		"\u0211\7v\2\2\u0211\u0212\7k\2\2\u0212\u0213\7q\2\2\u0213\u0214\7p\2\2"+
		"\u0214\u0215\7u\2\2\u0215x\3\2\2\2\u0216\u0217\7e\2\2\u0217\u0218\7c\2"+
		"\2\u0218\u0219\7w\2\2\u0219\u021a\7u\2\2\u021a\u021b\7g\2\2\u021b\u021c"+
		"\7u\2\2\u021cz\3\2\2\2\u021d\u021e\7k\2\2\u021e\u021f\7o\2\2\u021f\u0220"+
		"\7r\2\2\u0220\u0221\7q\2\2\u0221\u0222\7u\2\2\u0222\u0223\7u\2\2\u0223"+
		"\u0224\7k\2\2\u0224\u0225\7d\2\2\u0225\u0226\7n\2\2\u0226\u0227\7g\2\2"+
		"\u0227|\3\2\2\2\u0228\u0229\7k\2\2\u0229\u022a\7h\2\2\u022a~\3\2\2\2\u022b"+
		"\u022c\7h\2\2\u022c\u022d\7c\2\2\u022d\u022e\7n\2\2\u022e\u022f\7u\2\2"+
		"\u022f\u0230\7g\2\2\u0230\u0080\3\2\2\2\u0231\u0232\7v\2\2\u0232\u0233"+
		"\7t\2\2\u0233\u0234\7w\2\2\u0234\u0235\7g\2\2\u0235\u0082\3\2\2\2\u0236"+
		"\u0237\7u\2\2\u0237\u0238\7v\2\2\u0238\u0239\7t\2\2\u0239\u023a\7w\2\2"+
		"\u023a\u023b\7e\2\2\u023b\u023c\7v\2\2\u023c\u023d\7w\2\2\u023d\u023e"+
		"\7t\2\2\u023e\u023f\7g\2\2\u023f\u0084\3\2\2\2\u0240\u0241\7k\2\2\u0241"+
		"\u0242\7p\2\2\u0242\u0086\3\2\2\2\u0243\u0244\7y\2\2\u0244\u0245\7j\2"+
		"\2\u0245\u0246\7g\2\2\u0246\u0247\7t\2\2\u0247\u0248\7g\2\2\u0248\u0088"+
		"\3\2\2\2\u0249\u024a\7x\2\2\u024a\u024b\7c\2\2\u024b\u024c\7n\2\2\u024c"+
		"\u024d\7w\2\2\u024d\u024e\7g\2\2\u024e\u008a\3\2\2\2\u024f\u0250\7q\2"+
		"\2\u0250\u0251\7h\2\2\u0251\u008c\3\2\2\2\u0252\u0253\7k\2\2\u0253\u0254"+
		"\7p\2\2\u0254\u0255\7u\2\2\u0255\u0256\7v\2\2\u0256\u0257\7c\2\2\u0257"+
		"\u0258\7p\2\2\u0258\u0259\7e\2\2\u0259\u025a\7g\2\2\u025a\u025b\7u\2\2"+
		"\u025b\u008e\3\2\2\2\u025c\u025d\7v\2\2\u025d\u025e\7g\2\2\u025e\u025f"+
		"\7o\2\2\u025f\u0260\7r\2\2\u0260\u0261\7q\2\2\u0261\u0262\7t\2\2\u0262"+
		"\u0263\7c\2\2\u0263\u0264\7n\2\2\u0264\u0090\3\2\2\2\u0265\u0266\7r\2"+
		"\2\u0266\u0267\7t\2\2\u0267\u0268\7q\2\2\u0268\u0269\7l\2\2\u0269\u026a"+
		"\7g\2\2\u026a\u026b\7e\2\2\u026b\u026c\7v\2\2\u026c\u026d\7k\2\2\u026d"+
		"\u026e\7q\2\2\u026e\u026f\7p\2\2\u026f\u0092\3\2\2\2\u0270\u0271\7o\2"+
		"\2\u0271\u0272\7c\2\2\u0272\u0273\7z\2\2\u0273\u0094\3\2\2\2\u0274\u0275"+
		"\7u\2\2\u0275\u0276\7v\2\2\u0276\u0277\7g\2\2\u0277\u0278\7r\2\2\u0278"+
		"\u0279\7u\2\2\u0279\u0096\3\2\2\2\u027a\u027b\7j\2\2\u027b\u027c\7k\2"+
		"\2\u027c\u027d\7u\2\2\u027d\u027e\7v\2\2\u027e\u027f\7q\2\2\u027f\u0280"+
		"\7t\2\2\u0280\u0281\7{\2\2\u0281\u0098\3\2\2\2\u0282\u0283\7q\2\2\u0283"+
		"\u0284\7d\2\2\u0284\u0285\7u\2\2\u0285\u0286\7g\2\2\u0286\u0287\7t\2\2"+
		"\u0287\u0288\7x\2\2\u0288\u0289\7g\2\2\u0289\u028a\7f\2\2\u028a\u009a"+
		"\3\2\2\2\u028b\u028c\7j\2\2\u028c\u028d\7c\2\2\u028d\u028e\7r\2\2\u028e"+
		"\u028f\7r\2\2\u028f\u0290\7g\2\2\u0290\u0291\7p\2\2\u0291\u0292\7g\2\2"+
		"\u0292\u0293\7f\2\2\u0293\u009c\3\2\2\2\u0294\u0295\7d\2\2\u0295\u0296"+
		"\7q\2\2\u0296\u0297\7q\2\2\u0297\u0298\7n\2\2\u0298\u0299\7g\2\2\u0299"+
		"\u029a\7c\2\2\u029a\u029b\7p\2\2\u029b\u029c\7u\2\2\u029c\u009e\3\2\2"+
		"\2\u029d\u029e\7k\2\2\u029e\u029f\7p\2\2\u029f\u02a0\7v\2\2\u02a0\u02a1"+
		"\7g\2\2\u02a1\u02a2\7i\2\2\u02a2\u02a3\7g\2\2\u02a3\u02a4\7t\2\2\u02a4"+
		"\u02a5\7u\2\2\u02a5\u00a0\3\2\2\2\u02a6\u02a7\7w\2\2\u02a7\u02a8\7p\2"+
		"\2\u02a8\u02a9\7k\2\2\u02a9\u02aa\7x\2\2\u02aa\u02ab\7g\2\2\u02ab\u02ac"+
		"\7t\2\2\u02ac\u02ad\7u\2\2\u02ad\u02ae\7g\2\2\u02ae\u00a2\3\2\2\2\u02af"+
		"\u02b0\7c\2\2\u02b0\u02b1\7e\2\2\u02b1\u02b2\7v\2\2\u02b2\u02b3\7k\2\2"+
		"\u02b3\u02b4\7q\2\2\u02b4\u02b5\7p\2\2\u02b5\u02b6\7u\2\2\u02b6\u00a4"+
		"\3\2\2\2\u02b7\u02bb\t\5\2\2\u02b8\u02ba\t\6\2\2\u02b9\u02b8\3\2\2\2\u02ba"+
		"\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u00a6\3\2"+
		"\2\2\u02bd\u02bb\3\2\2\2\u02be\u02c2\t\7\2\2\u02bf\u02c1\t\6\2\2\u02c0"+
		"\u02bf\3\2\2\2\u02c1\u02c4\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c2\u02c3\3\2"+
		"\2\2\u02c3\u00a8\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c5\u02c9\t\b\2\2\u02c6"+
		"\u02c8\t\t\2\2\u02c7\u02c6\3\2\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02c7\3\2"+
		"\2\2\u02c9\u02ca\3\2\2\2\u02ca\u00aa\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cc"+
		"\u02cd\7/\2\2\u02cd\u02d1\t\b\2\2\u02ce\u02d0\t\t\2\2\u02cf\u02ce\3\2"+
		"\2\2\u02d0\u02d3\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2"+
		"\u00ac\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d4\u02d6\t\n\2\2\u02d5\u02d4\3\2"+
		"\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8"+
		"\u00ae\3\2\2\2\n\2\u00df\u00e6\u02bb\u02c2\u02c9\u02d1\u02d7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}