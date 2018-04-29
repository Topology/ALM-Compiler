package edu.ttu.krlab.answerset.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.ttu.krlab.alm.datastruct.ALMTerm;

public class AnswerSet {
    public ArrayList<String> atoms;
    private HashMap<String, List<ALMTerm>> hash;

    public AnswerSet() {
        atoms = new ArrayList<String>();
        hash = new HashMap<String, List<ALMTerm>>();
    }

    // adds atoms to ALM Term Hash Table
    public void hashALMTerms() {
        for (int i = 0; i < atoms.size(); i++) {
            String atom = atoms.get(i);
            ALMTerm term;
            if (atom.charAt(0) == '-') {
                term = parseALMTerm(atom, 1);
                term.setSign(ALMTerm.SIGN_NEG);
            } else {
                term = parseALMTerm(atom, 0);
            }
            List<ALMTerm> previous = hash.get(term.getName());

            if (previous == null) {
                previous = new ArrayList<ALMTerm>();
                hash.put(term.getName(), previous);
            }
            previous.add(term);
        }
    }

    // parse ALMTerm
    private ALMTerm parseALMTerm(String term, int start) {
        int firstOpenParenthesis = term.indexOf('(', start);
        if (firstOpenParenthesis < 0) {
            //a simple term.  
            return new ALMTerm(term, Character.isUpperCase(term.charAt(start)) ? ALMTerm.VAR : ALMTerm.ID);
        }
        int lastCloseParenthesis = term.lastIndexOf(')');
        if (lastCloseParenthesis < firstOpenParenthesis) {
            throw new IllegalStateException("The last ')' does not follow the first '(' in the term: " + term);
        }

        String predicate = term.substring(start, firstOpenParenthesis);
        ALMTerm almTerm = new ALMTerm(predicate, ALMTerm.FUN);
        parseALMTermList(term.substring(firstOpenParenthesis + 1, lastCloseParenthesis), almTerm.getArgs());
        return almTerm;
    }

    private void parseALMTermList(String termList, List<ALMTerm> destination) throws IllegalStateException {
        int firstComma = termList.indexOf(',');
        if (firstComma < 0) {
            //no sequence detected, at worst a nesting of unary predicates.   
            destination.add(parseALMTerm(termList, 0));
            return;
        }
        //check if there exists an open parenthesis. 
        int firstOpenParenthesis = termList.indexOf('(');
        if (firstOpenParenthesis < 0) {
            //ensure there is no closing parenthesis.  
            if (termList.indexOf(')') > 0) {
                throw new IllegalStateException("There is a ')' but no '(' in the termList: " + termList);
            }
            //this is a sequence of simple terms, rapidly popuplate the list and return.
            int termStart = 0;
            int termEnd = firstComma;
            while (termEnd > 0) {
                destination.add(new ALMTerm(termList.substring(termStart, termEnd),
                        Character.isUpperCase(termList.charAt(termStart)) ? ALMTerm.VAR : ALMTerm.ID));
                termStart = termEnd + 1; //skip comma in next term
                termEnd = termList.indexOf(',', termStart);
                if (termEnd < 0) {
                    destination.add(new ALMTerm(termList.substring(termStart),
                            Character.isUpperCase(termList.charAt(termStart)) ? ALMTerm.VAR : ALMTerm.ID));
                }
            }
            return;
        }

        //find the location of the closing parenthesis that matches the first.
        int firstCloseParenthesis = termList.indexOf(')');
        if (firstCloseParenthesis < firstOpenParenthesis) {
            throw new IllegalStateException("The first ')' does not follow the first '(' in the termList: " + termList);
        }

        //There is a sub-termList to parse.  Determine if '(' is before or after the first comma.
        if (firstCloseParenthesis < firstComma) {
            //the first comma is outside the nested term.
            destination.add(parseALMTerm(termList.substring(0, firstComma), 0));
            parseALMTermList(termList.substring(firstComma + 1), destination);
        } else {
            //The first comma belongs to the termList between the parenthesis.
            //Parse the first term ending with the first closing parenthesis.
            destination.add(parseALMTerm(termList.substring(0, firstCloseParenthesis + 1), 0));

            //Is there a first comma after the parenthesis?  
            firstComma = termList.indexOf(',', firstCloseParenthesis);
            if (firstComma > 0) {
                //parse the remainder of the termList
                parseALMTermList(termList.substring(firstComma + 1), destination);
            }
        }

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
    public List<ALMTerm> getLiterals(String predicateName) {
        return hash.get(predicateName);
    }

    // will return number of distinct literals
    public int size() {
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

    /**
     * WARNING: THIS OPERATION MAY CHANGE THIS ANSWERSET'S RELATION TO THE PROGRAM THAT GENERATED IT. <br>
     * WARNING: USE THIS FUNCTION WITH EXTREME CAUTION AND FULLY UNDERSTAND ITS EFFECTS ON THE SEMANTICS OF ANSWERSETS.
     * <br>
     * Purges any literal from the answer set which contains the given text as a substring.
     * 
     * @param text
     *            The text to use to identify which literals to purge.
     */
    public void purgeLiteralsContaining(String text) {
        Set<ALMTerm> remove = new HashSet<>();
        for (List<ALMTerm> litList : hash.values()) {
            remove.clear();
            for (ALMTerm lit : litList) {
                if (lit.toString().contains(text))
                    remove.add(lit);
            }
            for (ALMTerm l : remove) {
                litList.remove(l);
            }
        }
    }
}