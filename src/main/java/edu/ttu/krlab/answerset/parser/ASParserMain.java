package edu.ttu.krlab.answerset.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ASParserMain {


	private static String SPARC = "SPARC";
	private static String DLV = "DLV";
	private static String CLINGO = "CLINGO";
	private static String XML = "XML";
	private static String JSON = "JSON";
	
	
	
	public static void main(String[] args) {
		BufferedReader input= null;
		BufferedWriter output = null;
		String inputFormat = SPARC;
		String outputFormat = XML;
		Boolean printUsage = false;
		
		//open stdin/out by default
		try {
			input = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
			output = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could Not Create Buffered Reader/Writer for Standard IO.");
			e.printStackTrace();
			System.exit(1);
		}
		
		int i, length = args.length;
		
		for(i = 0; i < length; i++){
			String arg = args[i];
			
			if(arg.contains("-input:")){
				//indicates file to use for input instead of standard in
				String filename = arg.substring(arg.indexOf(':')+1);
				File f = new File(filename);
				try {
					input = new BufferedReader( new FileReader(f));
				} catch (FileNotFoundException e) {
					System.err.println("Not able to open file indicated by "+arg);
					e.printStackTrace();
					System.exit(1);
				}
			} else if(arg.contains("-output:")){
				//indicates file to use for input instead of standard in
				String filename = arg.substring(arg.indexOf(':')+1);
				File f = new File(filename);
				try {
					output = new BufferedWriter( new FileWriter(f));
				} catch (Exception e) {
					System.err.println("Not able to open output file indicated by "+arg);
					e.printStackTrace();
					System.exit(1);
				}
			} else if(arg.contains("-inputformat:")){
				String format = arg.substring(arg.indexOf(':')+1);
				if(SPARC.equals(format))
					inputFormat = SPARC;
				else if(DLV.equals(format))
					inputFormat = DLV;
				else if(CLINGO.equals(format))
					inputFormat = CLINGO;
				else {
					System.err.println("Unrecognized input format in:"+arg);
					System.exit(1);
				}
			} else if(arg.contains("-outputformat:")){
				String format = arg.substring(arg.indexOf(':')+1);
				if(XML.equals(format))
					inputFormat = XML;
				else if(JSON.equals(format)){
					System.err.println("JSON as output format is not yet supported.");
					System.exit(1);	
				}
				else {
					System.err.println("Unrecognized output format in:"+arg);
					System.exit(1);
				}
			} else {
				System.err.println("Unrecognized commandline argument: "+arg);
				printUsage = true;
			}
		}
		
		if(printUsage){
			System.out.println("Usage: ");
			System.out.println("-input:<filename>  (uses standard input if missing)");
			System.out.println("-output:<filename>  (uses standard output if missing)");
			System.out.println("-inputformat:DLV/SPARC/CLINGO  (uses SPARC if inputformat is missing");
			System.out.println("-outputformat:XML/JSON  (uses XML if outputformat is missing");
			System.exit(1);
		}
		
		
		//Parse Answersets From Input Reader	
		ArrayList<AnswerSet> AnswerSets = null;
		AnswerSetParser asp = null;
		if(inputFormat.equals(CLINGO)){
			asp = new ClingoAnswerSetParser();
		} else {
			//Sparc and DLV use same parser. 
			asp = new DLVAnswerSetParser();
		}
	
		AnswerSets = asp.getAnswerSets(input);
		
		//Since only output possible is XML, no test is needed for JSON otherwise it would go here.
		
		try {
			ParseAnswerSetsToXML(AnswerSets, output);
			output.flush();
			output.close();
		} catch (IOException e) {
			System.err.println("Not able to write to output with the following commandline arguments: ");
			System.err.println(args.toString());
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	

	
	static private String INDENT = "   ";
	
	static private void ParseAnswerSetsToXML(ArrayList<AnswerSet> ASets, BufferedWriter xml) throws IOException{
    	xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //preamble
    	xml.append("<answersets xmlns=\"http://www.ttu.edu/KRLab/AnswerSetSchema\">\n");
    	Iterator<AnswerSet> it = ASets.iterator();
    	while(it.hasNext()){
    		AnswerSet as = it.next();
    		ParseAnswerSetToXML(INDENT, as, xml);
    	}
    	xml.append("</answersets>\n");
    }
	

	
	
	static private void ParseAnswerSetToXML(String indent, AnswerSet as, BufferedWriter xml) throws IOException{
		
		//Split AnswerSet into Positive and Negative. 
		Map<String, Pair<ArrayList<String>,ArrayList<String>>> split = splitAnswerSet(as);
		
		Iterator<String> names = split.keySet().iterator();

		xml.append(indent).append("<answerset>\n");
		
		String nIndent = indent+INDENT;
		String nnIndent = nIndent+INDENT;
		
		while(names.hasNext()){
			String literal = names.next();
			Pair<ArrayList<String>,ArrayList<String>> pair = split.get(literal);
			ArrayList<String> positive = pair.first;
			ArrayList<String> negative = pair.second;
			
			xml.append(nIndent).append("<literal name = \"").append(literal).append("\">\n");
			
			Iterator<String> instances = positive.iterator();
			
			while(instances.hasNext()){
				String instance = instances.next();
				xml.append(nnIndent).append("<instance sign = \"true\">\n");
				ParseTermsToXML(nnIndent+INDENT, 0, instance, xml);
				xml.append(nnIndent).append("</instance>\n");
			}
			
			instances = negative.iterator();
				
			while(instances.hasNext()){
				String instance = instances.next();
				xml.append(nnIndent).append("<instance sign = \"false\">\n");
				ParseTermsToXML(nnIndent+INDENT, 0, instance, xml);
				xml.append(nnIndent).append("</instance>\n");
			}

			xml.append(nIndent).append("</literal>\n");
			
		}
		xml.append(indent).append("</answerset>\n");
	}
	
	static private int ParseTermsToXML(String indent, int index, String atom, BufferedWriter xml) throws IOException{
		//We assume that index is currently pointing to the position of the '(' character. 
		if(atom.length() == 0)
			return 0;
		index++; //"consume" the open parenthesis. 
		index = SkipWhiteSpace(index, atom);
		
		//We must check if the first term is complex or simple by checking for which occurs earlier '(' or ','.
		int openParen = atom.indexOf('(', index);
		int comma = atom.indexOf(',', index);
		int closeParen = atom.indexOf(')', index); //may not be matching close paren of the consumed open paren above. 
		
		//CURRENT STATE: Ready to parse first sub-term inside parenthesis
		while( openParen >=0 && openParen < closeParen){
			//CURRENT STATE: ready to parse the next sub-term in the sequence
			//exists a complex sub-term to parse
			while (comma >= 0 && comma <  openParen){
				//but before the complex term, there exists a simple term to parse
				index = ParseSimpleTermToXML(indent, index, atom, xml); //returns the index of comma
				index++; //consume the comma
				comma = atom.indexOf(',', index);//location of next comma
			}
			//ready to parse complex sub-term
			String name = atom.substring(index, openParen).trim();
			if(name.length()>0){
				xml.append(indent).append("<term name = \"").append(name).append("\">\n");
				index = ParseTermsToXML(indent+INDENT, openParen, atom, xml); //returns index of )
				xml.append(indent).append("</term>\n");
			}
			index++; // consume closing parenthesis for complex sub-term
			//reset state
			openParen = atom.indexOf('(', index);
			comma = atom.indexOf(',', index);
			closeParen = atom.indexOf(')', index);
			if(comma <0 || closeParen >= 0 && closeParen < comma ){
				//we parsed the last term in the sequence. return index of close parenthesis for sequence of terms.
				return closeParen;
			}
			if(comma >= 0 && comma < closeParen){
				//consume the comma between subterms
				index = comma+1;
			}
			//ready to parse next sub-term
			comma = atom.indexOf(',', index);// find comma after next sub-term
			//if comma doesn't exist or close paren is before comma, then we parsed the last term in the sequence. 
		}

		//CURRENT STATE: ready to parse the next sub-term in the sequence
		// closeParen <= openParen, no complex sub-term exists to parse, just simple terms
		while (comma >= 0 && comma <  closeParen){
			//but before the last simple term, there exists an additional simple term to parse
			if(comma == index) index++; //consume the comma
			index = ParseSimpleTermToXML(indent, index, atom, xml); //returns the index of comma
			index++; //consume the comma
			comma = atom.indexOf(',', index);//location of next comma
		}
		//final simple term ready to parse. 
		return ParseSimpleTermToXML(indent, index, atom, xml);// returns location of closeParenthesis
		
	}

	static private int ParseSimpleTermToXML(String indent, int index, String atom, BufferedWriter xml) throws IOException{
		//indent is at proper depth, only a simple term needs to be parsed.
		//open parenthesis or separating comma has been consumed. 
		index = SkipWhiteSpace(index, atom);
		
		//since term is simple, we look for closing paren or comma.
		int comma = atom.indexOf(',', index);
		int closeParen = atom.indexOf(')',index); //may not be matching close paren of the consumed open paren above.
		String name = null;
		if(comma >= 0 && comma < closeParen){
			name = atom.substring(index, comma).trim();
			index = comma;
		}else if (closeParen >= 0){
			name = atom.substring(index, closeParen).trim();
			index = closeParen;
		} else {
			name = atom.substring(index).trim();
			index = closeParen; //dosn't matter they are the same, should be length of atom.
		}
		
		if(name.length() >0){
			xml.append(indent).append("<term name = \"").append(name).append("\" />\n");
		}
		return index;
	}
	
	
	
	
	static private int SkipWhiteSpace(int index, String atom){
		char c = atom.charAt(index);
		boolean ws = true;
		int length = atom.length();
		while(ws && index < length ){
			if(c == ' ' | c == '\n' | c == '\t' | c == '\r'){
				index++;
				c = atom.charAt(index);
			} else
				ws = false;
		}
		return index;
	}

	

	static private Map<String, Pair<ArrayList<String>,ArrayList<String>>> splitAnswerSet(AnswerSet as){
		
		Map<String, Pair<ArrayList<String>,ArrayList<String>>> map = new HashMap<String, Pair<ArrayList<String>,ArrayList<String>>>();
				
		Iterator<String> it = as.atoms.iterator();
		while(it.hasNext()){
			
			String atom = it.next();
			int sign = atom.indexOf('-');
			int openParen = atom.indexOf('(');
			String name = null;
			if(sign < 0){
				if(openParen < 0){
					//positive occurrence no sub-terms.
					name = atom.trim();
				} else{
					//positive occurrence, has sub-terms
					name = atom.substring(0, openParen).trim();
				}
			} else {
				if(openParen < 0){
					//negative occurrence no sub-terms.
					name = atom.substring(sign+1).trim();
				} else{
					//negative occurrence, has sub-terms
					name = atom.substring(sign+1, openParen).trim();
				}
				
			}
			Pair<ArrayList<String>,ArrayList<String>> instances = map.get(name);
			if(instances == null){
				instances = new Pair<ArrayList<String>,ArrayList<String>>(new ArrayList<String>(), new ArrayList<String>());
				map.put(name, instances);
			}
			if(sign < 0){
				if(openParen < 0){
					//positive occurrence no sub-terms.
					instances.first.add("");
				} else{
					//positive occurrence, has sub-terms
					instances.first.add(atom.substring(openParen));
				}
			} else {
				if(openParen < 0){
					//negative occurrence no sub-terms.
					instances.second.add("");
				} else{
					//negative occurrence, has sub-terms
					instances.second.add(atom.substring(openParen));
				}
				
			}
			
		}
		return map;
	}
	

}
