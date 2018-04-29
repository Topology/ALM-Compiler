package edu.ttu.krlab.answerset.parser;

import java.io.BufferedReader;
import java.util.ArrayList;

public interface AnswerSetParser {
	public ArrayList<AnswerSet> getAnswerSets(BufferedReader content);
}
