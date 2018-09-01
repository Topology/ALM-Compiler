package edu.ttu.krlab.alm.datastruct;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Location {

    private List<? extends ParserRuleContext> listPrc = null;
    private ParserRuleContext prc = null;
    private Token token = null;

    public Location() {

    }

    public Location(ParserRuleContext prc) {
        this.prc = prc;
        token = prc.start;

    }

    public Location(Token token) {
        this.token = token;
    }

    public Location(TerminalNode termnode) {
        this.token = termnode.getSymbol();
    }

    public Location(List<? extends ParserRuleContext> location) {
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Location cannot receive an null or empty list of parser rule contexts");
        }
        this.listPrc = location;
        this.prc = location.get(0);
        this.token = prc.start;
    }

    public int getLineNumber() {
        if (token != null) {
            return token.getLine();
        }
        return 0;
    }

    public int getColumnNumber() {
        if (token != null) {
            return token.getCharPositionInLine();
        }
        return 0;
    }

    @Override
    public String toString() {
        String result = getFileName();
        if (result.length() > 0) {
            result += " ";
        }
        result += "[" + getText() + " " + getLineCol() + "]";
        return result;
    }

    public void writeTo(BufferedWriter out) throws IOException {
        out.write(toString());
    }

    public ParserRuleContext getParserRuleContext() {
        return prc;
    }

    public Token getFirstToken() {
        return token;
    }

    public String getText() {
        if (listPrc != null) {
            StringBuilder result = new StringBuilder();
            for (ParserRuleContext prc : listPrc) {
                result.append(prc.getText()).append(',');
            }
            return result.substring(0, result.length() - 1);
        }
        if (prc != null) {
            return prc.getText();
        }
        if (token != null) {
            return token.getText();
        }
        return "[NO TEXT]";
    }

    private String getLineCol() {
        if (token != null) {
            return String.format("%d:%d", token.getLine(), token.getCharPositionInLine());
        } else {
            return "(0,0)";
        }
    }

    private String getFileName() {
        String fileName = null;
        if (token != null) {
            fileName =  token.getTokenSource().getSourceName();
        } else if (prc != null) {
            fileName = prc.start.getTokenSource().getSourceName();
        } 
        if(fileName != null){
            int lastSlash = fileName.lastIndexOf('\\');
            if(lastSlash > 0){
                return fileName.substring(lastSlash+1);
            }
            return fileName;
        }
        return "";
    }

    public String getFileLineCol() {
        return "("+getFileName()+":"+getLineCol()+")";
    }
}
