// Generated from java-escape by ANTLR 4.11.1
package translator;

    import java.util.*;
    import java.lang.*;
    import java.util.stream.Collectors;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT=11, ID=12, NEWLINE=13, IDENT=14, WS=15;
	public static final int
		RULE_file = 0, RULE_stat = 1, RULE_assign = 2, RULE_expr = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "stat", "assign", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'int'", "'('", "'input'", "')'", "'print'", "'//'", "'*'", 
			"'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INT", 
			"ID", "NEWLINE", "IDENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public StringBuilder translated = new StringBuilder();
	    Set<String> memory = new HashSet<String>();

	public PythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public String res;
		public StatContext stat;
		public List<StatContext> stats = new ArrayList<StatContext>();
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 14408L) != 0) {
				{
				{
				setState(8);
				((FileContext)_localctx).stat = stat();
				((FileContext)_localctx).stats.add(((FileContext)_localctx).stat);
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(14);
			match(EOF);

			String stats = ((FileContext)_localctx).stats.stream().filter(it -> it.res != null).map(it -> "\t" + it.res + ";\n").collect(Collectors.joining());
			String varDecls = "int " + memory.stream().collect(Collectors.joining(", "));
			translated.append(String.format("""
			#include <stdio.h>
			%s;
			int main() {
			%s
			    return 0;
			}
			""", varDecls, stats));

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public String res;
		public Token ID;
		public ExprContext expr;
		public AssignContext assign;
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				((StatContext)_localctx).ID = match(ID);
				setState(18);
				match(T__0);
				setState(19);
				match(T__1);
				setState(20);
				match(T__2);
				setState(21);
				match(T__3);
				setState(22);
				match(T__2);
				setState(23);
				match(T__4);
				setState(24);
				match(T__4);

				((StatContext)_localctx).res =  "scanf(\"%d\", &" + (((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null) + ")";
				memory.add((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null));

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				match(T__5);
				setState(27);
				match(T__2);
				setState(28);
				((StatContext)_localctx).expr = expr(0);
				setState(29);
				match(T__4);
				 ((StatContext)_localctx).res =  "printf(\"%d\\n\", " + ((StatContext)_localctx).expr.res + ")"; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				((StatContext)_localctx).assign = assign();
				setState(33);
				match(NEWLINE);
				 ((StatContext)_localctx).res =  ((StatContext)_localctx).assign.res; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				((StatContext)_localctx).expr = expr(0);
				setState(37);
				match(NEWLINE);
				 ((StatContext)_localctx).res =  ((StatContext)_localctx).expr.res; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				match(NEWLINE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public String res;
		public Token ID;
		public ExprContext e;
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			((AssignContext)_localctx).ID = match(ID);
			setState(44);
			match(T__0);
			setState(45);
			((AssignContext)_localctx).e = expr(0);

			((AssignContext)_localctx).res =  (((AssignContext)_localctx).ID!=null?((AssignContext)_localctx).ID.getText():null) + "=" + ((AssignContext)_localctx).e.res;
			memory.add((((AssignContext)_localctx).ID!=null?((AssignContext)_localctx).ID.getText():null));

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public String res;
		public ExprContext a;
		public ExprContext expr;
		public Token ID;
		public Token INT;
		public ExprContext b;
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public TerminalNode INT() { return getToken(PythonParser.INT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(49);
				match(T__2);
				setState(50);
				((ExprContext)_localctx).expr = expr(0);
				setState(51);
				match(T__4);
				 ((ExprContext)_localctx).res =  ((ExprContext)_localctx).expr.res; 
				}
				break;
			case ID:
				{
				setState(54);
				((ExprContext)_localctx).ID = match(ID);
				 ((ExprContext)_localctx).res =  (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null); 
				}
				break;
			case INT:
				{
				setState(56);
				((ExprContext)_localctx).INT = match(INT);
				 ((ExprContext)_localctx).res =  (((ExprContext)_localctx).INT!=null?((ExprContext)_localctx).INT.getText():null); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(75);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(61);
						match(T__6);
						setState(62);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(7);
						 ((ExprContext)_localctx).res =  ((ExprContext)_localctx).a.res + "/" + ((ExprContext)_localctx).b.res; 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(65);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(66);
						match(T__7);
						setState(67);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(6);
						 ((ExprContext)_localctx).res =  ((ExprContext)_localctx).a.res + "*" + ((ExprContext)_localctx).b.res; 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(71);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(72);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(5);
						 ((ExprContext)_localctx).res =  ((ExprContext)_localctx).a.res + (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null) + ((ExprContext)_localctx).b.res; 
						}
						break;
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000fQ\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0005\u0000\n\b"+
		"\u0000\n\u0000\f\u0000\r\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001*\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003;\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003L\b\u0003\n\u0003"+
		"\f\u0003O\t\u0003\u0001\u0003\u0000\u0001\u0006\u0004\u0000\u0002\u0004"+
		"\u0006\u0000\u0001\u0001\u0000\t\nV\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0002)\u0001\u0000\u0000\u0000\u0004+\u0001\u0000\u0000\u0000\u0006:"+
		"\u0001\u0000\u0000\u0000\b\n\u0003\u0002\u0001\u0000\t\b\u0001\u0000\u0000"+
		"\u0000\n\r\u0001\u0000\u0000\u0000\u000b\t\u0001\u0000\u0000\u0000\u000b"+
		"\f\u0001\u0000\u0000\u0000\f\u000e\u0001\u0000\u0000\u0000\r\u000b\u0001"+
		"\u0000\u0000\u0000\u000e\u000f\u0005\u0000\u0000\u0001\u000f\u0010\u0006"+
		"\u0000\uffff\uffff\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0005\f\u0000\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013\u0014\u0005"+
		"\u0002\u0000\u0000\u0014\u0015\u0005\u0003\u0000\u0000\u0015\u0016\u0005"+
		"\u0004\u0000\u0000\u0016\u0017\u0005\u0003\u0000\u0000\u0017\u0018\u0005"+
		"\u0005\u0000\u0000\u0018\u0019\u0005\u0005\u0000\u0000\u0019*\u0006\u0001"+
		"\uffff\uffff\u0000\u001a\u001b\u0005\u0006\u0000\u0000\u001b\u001c\u0005"+
		"\u0003\u0000\u0000\u001c\u001d\u0003\u0006\u0003\u0000\u001d\u001e\u0005"+
		"\u0005\u0000\u0000\u001e\u001f\u0006\u0001\uffff\uffff\u0000\u001f*\u0001"+
		"\u0000\u0000\u0000 !\u0003\u0004\u0002\u0000!\"\u0005\r\u0000\u0000\""+
		"#\u0006\u0001\uffff\uffff\u0000#*\u0001\u0000\u0000\u0000$%\u0003\u0006"+
		"\u0003\u0000%&\u0005\r\u0000\u0000&\'\u0006\u0001\uffff\uffff\u0000\'"+
		"*\u0001\u0000\u0000\u0000(*\u0005\r\u0000\u0000)\u0011\u0001\u0000\u0000"+
		"\u0000)\u001a\u0001\u0000\u0000\u0000) \u0001\u0000\u0000\u0000)$\u0001"+
		"\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*\u0003\u0001\u0000\u0000"+
		"\u0000+,\u0005\f\u0000\u0000,-\u0005\u0001\u0000\u0000-.\u0003\u0006\u0003"+
		"\u0000./\u0006\u0002\uffff\uffff\u0000/\u0005\u0001\u0000\u0000\u0000"+
		"01\u0006\u0003\uffff\uffff\u000012\u0005\u0003\u0000\u000023\u0003\u0006"+
		"\u0003\u000034\u0005\u0005\u0000\u000045\u0006\u0003\uffff\uffff\u0000"+
		"5;\u0001\u0000\u0000\u000067\u0005\f\u0000\u00007;\u0006\u0003\uffff\uffff"+
		"\u000089\u0005\u000b\u0000\u00009;\u0006\u0003\uffff\uffff\u0000:0\u0001"+
		"\u0000\u0000\u0000:6\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		";M\u0001\u0000\u0000\u0000<=\n\u0006\u0000\u0000=>\u0005\u0007\u0000\u0000"+
		">?\u0003\u0006\u0003\u0007?@\u0006\u0003\uffff\uffff\u0000@L\u0001\u0000"+
		"\u0000\u0000AB\n\u0005\u0000\u0000BC\u0005\b\u0000\u0000CD\u0003\u0006"+
		"\u0003\u0006DE\u0006\u0003\uffff\uffff\u0000EL\u0001\u0000\u0000\u0000"+
		"FG\n\u0004\u0000\u0000GH\u0007\u0000\u0000\u0000HI\u0003\u0006\u0003\u0005"+
		"IJ\u0006\u0003\uffff\uffff\u0000JL\u0001\u0000\u0000\u0000K<\u0001\u0000"+
		"\u0000\u0000KA\u0001\u0000\u0000\u0000KF\u0001\u0000\u0000\u0000LO\u0001"+
		"\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"N\u0007\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000\u0005\u000b"+
		"):KM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}