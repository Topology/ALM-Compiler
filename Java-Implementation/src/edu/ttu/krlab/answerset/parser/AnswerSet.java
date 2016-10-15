 package edu.ttu.krlab.answerset.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.HashMap;

import edu.ttu.krlab.alm.datastruct.ALMTerm;


public class AnswerSet {
    public ArrayList<String> atoms;
    private HashMap<String, List<ALMTerm>> hash;
    public AnswerSet() {
        atoms = new ArrayList<String>();
        hash = new HashMap<String, List<ALMTerm>>();
    }
    // adds atoms to ALM Term Hash Table
    public void hashALMTerms () {
    	for (int i = 0; i < atoms.size(); i++) {
    		String atom = atoms.get(i);
    		ALMTerm term;
    		if (atom.charAt(0) == '-') {
    			term = createALMTerm(atom, 1); 
    			term.setSign(ALMTerm.SIGN_NEG);			
    		} else {
    			term = createALMTerm(atom, 0);
    		}
    		List<ALMTerm> previous = hash.get(term.getName());

    		if (previous == null) {
    			previous = new ArrayList<ALMTerm>();
        		hash.put(term.getName(),previous);
    		}
    		previous.add(term);
    	}
    }
    // acreate ALMTerm
    private ALMTerm createALMTerm (String atom, int start) {
    	String predicate = stringFromIndexToChar(atom, start, '(');
    	ALMTerm term = new ALMTerm (predicate, ALMTerm.FUN);
    	int lastProcessed = predicate.length() + 1 + start;
    	for (int i = predicate.length() + 1 + start; i < atom.length(); i++) {
    		if (atom.charAt(i) == ',') {
    			if (atom.charAt(i - 1) != ')') {
    				term.addArg(new ALMTerm(stringFromIndexToChar(atom,lastProcessed, ','), ALMTerm.ID));
    			}

    			lastProcessed = i + 1;
    		} else if (atom.charAt(i) == ')') {
    			term.addArg(new ALMTerm(stringFromIndexToChar(atom,lastProcessed, ')'), ALMTerm.ID));
    			return term;
    		} else if (atom.charAt(i) == '(') {
    			term.addArg(createALMTerm(atom,lastProcessed));
    			while (atom.charAt(i) != ')') {
    				i++;
    			}
    			lastProcessed = i + 1;
    		}
    	}
    	return term;
    }

    // used for getting predicate and record name strings
    private String stringFromIndexToChar(String atom, int index, char character) {
    	String s = "";
    	int max = atom.length();
    	for (int i = index; i < max && atom.charAt(i) != character; i++) {
    		s += atom.charAt(i);
    	}
    	return s;
    }
    // given a predicate name, return all alm terms that match
    // will return null if not found.
    public List<ALMTerm> getLiterals (String predicateName) {
    	return hash.get(predicateName);
    }
    // will return number of distinct literals
    public int size () {
    	return hash.size();
    }
    // returns all of the unique predicate names in string form
    public Set<String> getAllLiterals() {
    	return hash.keySet();
    }
    // returns all of the lists of ALMTerms (each list has a unique predicate name)
    public Collection<List<ALMTerm>> getAllAlmTerms() {
    	return hash.values();
    }
}