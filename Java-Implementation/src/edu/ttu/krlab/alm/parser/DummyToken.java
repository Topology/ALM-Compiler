package edu.ttu.krlab.alm.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

public class DummyToken implements Token {
	
	private int line;
	private int col;
	
	public DummyToken(int Line, int Col){
		this.line = Line;
		this.col = Col;
	}

	@Override
	public int getChannel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCharPositionInLine() {
		return col;
	}

	@Override
	public CharStream getInputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getStartIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStopIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTokenIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TokenSource getTokenSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

}
