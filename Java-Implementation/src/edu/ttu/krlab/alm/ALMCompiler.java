package edu.ttu.krlab.alm;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
//import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;

import edu.ttu.krlab.alm.answerset.AnswerSets;
import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.VariableManager;
import edu.ttu.krlab.answerset.parser.AnswerSet;
import edu.ttu.krlab.answerset.parser.SPARCWrapper;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfLiteral;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfProgram;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfRule;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.datastruct.sig.FunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.FunctionNotFound;
import edu.ttu.krlab.alm.datastruct.sig.SortEntry;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.sparc.PredicateAlreadyDeclared;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCLiteral;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCPredicate;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCProgram;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCRule;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCSort;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCSortAlreadyDefined;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCSortNotDefined;
import edu.ttu.krlab.alm.parser.ALMBaseListener;
import edu.ttu.krlab.alm.parser.ALMLexer;
import edu.ttu.krlab.alm.parser.ALMParser;
import edu.ttu.krlab.alm.parser.ALMSyntaxErrorListener;

public class ALMCompiler {
	
	public static final String VERSION = "0.1.0";  //Major = huge features, Minor = smaller adjustments, Release Build = bugfixes  
	private static final boolean DEBUG_VERSION = true;

	/**
	 * Commandline Arguments: 
	 * 0) filename of ALM system description
	 * @param args
	 */
	public static void main(String[] args)  {
		

		System.err.println("ALM Translator Version: "+VERSION);
		
		ALMCompilerSettings s = new ALMCompilerSettings();
		s.processCommandlineArgs(args);
		
		SymbolTable st = new SymbolTable();
		ErrorReport er = new ErrorReport();
		ASPfProgram aspf = new ASPfProgram();
		SPARCProgram pm = new SPARCProgram();
		pm.addComment("Pre Model Program");
		List<AnswerSet> as = new ArrayList<AnswerSet>();
		SPARCProgram tm = new SPARCProgram();
		tm.addComment("Final Program For Transition Diagram");
		
		try {
			Reader br = s.SystemDescriptionReader();
		
			//Call The Translation Function (Where the magic happens)
			ALMCompiler.Translate(br, s, st, er, aspf, pm, as, tm);

			
		} catch (FileNotFoundException e) {
			System.err.println("Could not locate input system description in file: "+s.getSystemDescriptionFileName());
			e.printStackTrace();
			System.exit(-1);
		} catch(IOException e){
			System.err.println("Could Not Complete Translation Due To Java IO Exception:");
			e.printStackTrace();
			System.exit(-1);

		} 
		
	}

	private static List<AnswerSet> GetAnswerSet(SPARCProgram pm, ALMCompilerSettings s) throws IOException {
		StringWriter sparcwriter = new StringWriter();
		BufferedWriter out = new BufferedWriter(sparcwriter);
		pm.writeTo(out);
		String sparcProgram = sparcwriter.toString();
		//String sparcProgram, String pathToSPARCJar, String pathToJava, String PathToASPSolver, String whichSolver
		return SPARCWrapper.solve(sparcProgram, s.getSPARCLocation(),  s.getJavaLocation(), s.getSolverLocation(), s.getSolverType());
		
	}
		
	

	private static void ConstructPreModelProgram(SPARCProgram pm, SymbolTable st, ASPfProgram aspf)  {
		PreModelCreateSortsSection(pm, st);
		PreModelCreatePredicatesSection(pm, st);
		PreModelCreateRules(pm, st, aspf);
	}

	private static void PreModelCreateSortsSection(SPARCProgram pm, SymbolTable st)  {
		Set<SortEntry> started = new HashSet<SortEntry>();
		Set<SortEntry> finished = new HashSet<SortEntry>();
		SortEntry universe = st.getUniverseSortEntry();
		
		PreModelSortHierarchy(universe, pm, st, started, finished);
		finished.add(universe);
	
		//need to add special sort nodes to pre-model.
		SortEntry nodesentry = st.getNodesSpecialSortEntry();
		SPARCSort nodes = new SPARCSort(nodesentry.getSortName());
		for(ALMTerm si : nodesentry.getInstances())
			nodes.addInstance(si);
		
		try {
			pm.addSPARCSort(nodes);
		} catch (SPARCSortAlreadyDefined e) {
			e.printStackTrace();
			ALMCompiler.PROGRAM_FAILURE("PreModel Creating Sorts Section", "Special Sort For Nodes In Hierarchy Was Already Defined");
			//This should never happen. 
		}
		
	}

	private static void PreModelSortHierarchy(SortEntry se, SPARCProgram pm, SymbolTable st, Set<SortEntry> started, Set<SortEntry> finished)  {
		
		//enumerate sorts which are necessary for attribute functions.  
		for(FunctionEntry attr:se.getAttributes()){
			List<SortEntry> sig = attr.getSignature();
			int sig_length = sig.size();
			for(int i = 1; i < sig_length; i++){ //skip the first sort for attributes, always.  
				SortEntry sort = sig.get(i);
				if(finished.contains(sort))
					continue;
				if(sort.getSortName().compareTo(se.getSortName()) != 0){ //ignore references to sort of attribute.  
					if(started.contains(sort))
						//This should be caught by a semantic error and  premodel should not be constructed. 
						PROGRAM_FAILURE("Construct Premodel Sorts", "Loop Detected: attribute ["+
										attr.getFunctionName()+"] of sort ["+se.getSortName()+"] is dependent on sort ["+
										sort.getSortName()+"] which has started but not finished with writing out dependencies.");
					//the sort must be written out first since se's attribute depends on it.
					started.add(sort);
					PreModelSortHierarchy(sort, pm, st, started, finished);
					finished.add(sort);
				}
			}
		}
		
		//enumerate the remainder of the child sorts in the hierarchy
		for(SortEntry sort:se.getChildSorts()){
			if(finished.contains(sort))
				continue;
			if(started.contains(sort))
				//This should be caught by a semantic error and  premodel should not be constructed. 
				PROGRAM_FAILURE("Construct Premodel Sorts", "Loop Detected: sort ["+se.getSortName()+"] is dependent on sort ["+
								sort.getSortName()+"] which has started but not finished with writing out dependencies.");
			//the sort must be written out first since se's attribute depends on it.
			started.add(sort);
			PreModelSortHierarchy(sort, pm, st, started, finished);
			finished.add(sort);
		}
			
		//writing out dependencies is finished, time to write out this sort.  
		if(se.getChildSorts().size() > 0){
			//Not A Source Sort
			SPARCSort psort = new SPARCSort(se.getSortName());
			for(SortEntry sort:se.getChildSorts()){
				try {
					psort.union(pm.getSPARCSort(sort.getSortName()));
				} catch (SPARCSortNotDefined e) {
					e.printStackTrace();
					PROGRAM_FAILURE("Construct Premodel Sorts", "Sort was not defined: "+e.getMessage());	
				}
			}
			
			try {
				pm.addSPARCSort(psort);
			} catch (SPARCSortAlreadyDefined e) {
				//This shouldn't happen as it should generate a semantic error to catch this situation and not attempt to create the premodel.
				e.printStackTrace();
				PROGRAM_FAILURE("Construct Premodel Sorts", "Sort was defined twice: "+e.getMessage());
			}
		} else {
			//IS A SOURCE SORT
			SPARCSort psort = new SPARCSort(se.getSortName());
			psort.addComment("Source Sort");
			for(ALMTerm si : se.getInstances()){
				psort.addInstance(si);
			}
			try {
				pm.addSPARCSort(psort);
			} catch (SPARCSortAlreadyDefined e) {
				e.printStackTrace();
				PROGRAM_FAILURE("Construct Premodel Sorts", "Sort was defined twice: "+e.getMessage());
			}
		}
		SPARCSort timestep = new SPARCSort("timeStep");
		ALMTerm timestepValue0 = new ALMTerm("0", ALMTerm.INT);
		ALMTerm timestepValue1 = new ALMTerm("1", ALMTerm.INT);
		timestep.addInstance(timestepValue0);
		timestep.addInstance(timestepValue1);
		List<SPARCSort> addTime = pm.getSorts();
		boolean includeTime = false;
		for(SPARCSort tsort : addTime){
			if(tsort.getSortName() == "timeStep"){
				includeTime = true;
				break;
			}
		}
		if(!includeTime){
			try {
				pm.addSPARCSort(timestep);
			} catch (SPARCSortAlreadyDefined e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
		
	}




	private static void PreModelCreatePredicatesSection(SPARCProgram pm, SymbolTable st) {
		//For each static function, generate a predicate signature.
		//TODO: This needs to be altered to match any final naming convention. 
		
		for(FunctionEntry fun : st.getFunctions()){
			SPARCPredicate pred = null;
			if(fun.isAttribute()){
				pred = new SPARCPredicate(fun.getQualifiedFunctionName());
				pred.addComment("attribute function ["+fun.getFunctionName()+"] for sort ["+fun.getSignature().get(0).getSortName()+"]");
				
			} else if(fun.isStatic()){
				pred =  new SPARCPredicate(fun.getFunctionName());
				pred.addComment("static function");
			} else if(fun.isSpecial()){
				pred = new SPARCPredicate(fun.getFunctionName());
				pred.addComment("special function");
			} else if(fun.isFluent()){
				pred = new SPARCPredicate(fun.getFunctionName());
				pred.addComment("fluent function");
			}
				
			if(pred != null){
				//need to add signature to predicate, leaving off boolean if that is the range sort.
				List<SortEntry> sig = fun.getSignature();
				if(sig == null)
					ALMCompiler.PROGRAM_FAILURE("Pre Model Create Predicate Section", "Function Has No Signature");
				
				int length = sig.size()-1;
				for(int i = 0; i <= length; i++){
					SortEntry se = sig.get(i);
					if(i < length || se != st.getBooleansSortEntry())
						try{
							pred.addSPARCSort(pm.getSPARCSort(sig.get(i).getSortName()));
						} catch (SPARCSortNotDefined e) {
							ALMCompiler.PROGRAM_FAILURE("Premodel SPARC Program", "SPARC Sort ["+se.getSortName()+"] Not defined in pre model program for function ["+fun.getFunctionName()+"].");
						}
				}
				
				//adding time to the fluent
				if(fun.isFluent() || (fun.isSpecial() && fun.getFunctionName().contains("occurs"))) {
					SPARCSort step = new SPARCSort("timeStep");
					pred.addSPARCSort(step);
				}
				
			
				
				try {
					pm.addSPARCPredicate(pred);
				} catch (PredicateAlreadyDeclared e) {
					e.printStackTrace();
					PROGRAM_FAILURE("Adding SPARC Predicate Declaration", "A second predicate declaration with the same name cannot be created."); 
					//This should be prevented by semantic error checking.  
				}
			}		
		}
		
	}

	private static void PreModelCreateRules(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
		
		//ST: Model Sort Hierarchy In Rules
		PreModelSortHierarchyRules(pm, st, aspf);
		
		//ST: Add Fundamental Axioms For ALL Static Functions
		PreModelStaticFunctionsRules(pm, st);
		
		//ASPF: Static State Constraint Axioms
		PreModelStaticStateConstraintAxioms(pm, st, aspf);
		
		//ASPF: Static Definitions Axioms
		PreModelStaticDefinitionsAxioms(pm, st, aspf);
		
		//ASPF: Attribute Definitions And Sort Instances
		PreModelSortInstancesAndAttributeDefinitions(pm, st, aspf);
		
		//ASPF: Static Function Definitions
		PreModelStructureStaticFunctionDefinitions(pm, st, aspf);
			
	}


	private static void PreModelSortHierarchyRules(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
		
		//Link Function -- requires recursive enumeration over sort hierarchy
		SortEntry universe = st.getUniverseSortEntry();
		PreModelRecursivelyAddRulesForLink(pm, st, universe, new HashSet<SortEntry>()); //the set is to mark when the sorts have had their links written out.  
		
		//Is_A Function -- uses structure to generate the rules from sort instance declarations. 
		PreModelAddRulesForIsA(pm, st, aspf);
		
		//Instance Function  -- This closure of instances based on is_a and link
		//These cannot be enumerated as the pre-model logic program is necessary to specify the enumeration. 
		PreModelRulesForInstance(pm, st);
		
		//Subsort Function -- Closure of subsort relation based on link
		//General rule, optimization could enumerate the facts.
		PreModelRulesForSubsort(pm, st);
		
		//Has Parent Function -- General rule, optimization could enumerate the facts.
		PreModelRulesForHasParent(pm, st);
		
		//Has Child Function -- General rule, optimization could enumerate the facts.
		PreModelRulesForHasChild(pm, st);
		
		//Source Function -- General rule, optimization could enumerate the facts.
		PreModelRulesForSource(pm, st);
		
		//Sink Function -- General rule, optimization could enumerate the facts. 
		PreModelRulesForSink(pm, st);
				
	}



	private static void PreModelRecursivelyAddRulesForLink(SPARCProgram pm, SymbolTable st, SortEntry parent, Set<SortEntry> finished) {
		if(finished.contains(parent))
			return;
		Set<SortEntry> children = parent.getChildSorts();
		if(children != null && children.size() > 0){
			for(SortEntry child : children){
				ALMTerm is_a = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
				is_a.addArg(new ALMTerm(child.getSortName(), ALMTerm.ID));
				is_a.addArg(new ALMTerm(parent.getSortName(), ALMTerm.ID));
				SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_LINK, is_a, null);
				r.addComment("["+child.getSortName()+"] is a child sort of ["+parent.getSortName()+"]");
				
				PreModelRecursivelyAddRulesForLink(pm, st, child, finished);		
			}
		}
		finished.add(parent);
	}




	private static void PreModelAddRulesForIsA(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
			
		//Add Rules and Facts For Each Instance
		//These were parsed into ASPf as an intermediate form 
		for(ASPfRule aspf_rule : aspf.getRules(ALM.STRUCTURE_SORT_INSTANCES)){
			//These rules should all be static, otherwise a semantic error would occur.  
			//They can be transferred directly to SPARC without modification, casting to ALMTerm as intermediate representation
			ASPfLiteral aspf_head = aspf_rule.getHead();
			SPARCLiteral head = (ALMTerm) aspf_head;
			
			List<ASPfLiteral> aspf_body = aspf_rule.getBody();
			List<SPARCLiteral> body = null;
			if(aspf_body != null){
				body = new ArrayList<SPARCLiteral>();
				for(ASPfLiteral aspf_lit: aspf_body)
					body.add((ALMTerm) aspf_lit);
			}
			
			SPARCRule instance_rule = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_IS_A, head, body);
			instance_rule.copyComments(aspf_rule);
		}
	}
	
	
	

	private static void PreModelRulesForInstance(SPARCProgram pm, SymbolTable st) {
		
		ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
		ALMTerm YVar = new ALMTerm("Y", ALMTerm.VAR);
		ALMTerm ZVar = new ALMTerm("Z", ALMTerm.VAR);
		
		
		//Add Rule for instance base case (is_a) 
		ALMTerm instance_head = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
		instance_head.addArg(XVar);
		instance_head.addArg(YVar);
		
		List<SPARCLiteral> instance_body = new ArrayList<SPARCLiteral>();
		ALMTerm instance_body_is_a = new ALMTerm(ALM.SPECIAL_FUNCTION_IS_A, ALMTerm.FUN);
		instance_body_is_a.addArg(XVar);
		instance_body_is_a.addArg(YVar);
		instance_body.add(instance_body_is_a);
		
		SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_INSTANCE, instance_head, instance_body);
		r.addComment("Base case of [instance] relation.");
		r.addComment("If X is a Y then X is an instance of Y.");
		
		
		
		// Add Rule For Inference across links
		//X is an instance of Z if X is an instance of Y and there is a link from Y to Z
		ALMTerm instance_closure_head = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
		instance_closure_head.addArg(XVar);
		instance_closure_head.addArg(ZVar);
		
		List<SPARCLiteral> instance_closure_body = new ArrayList<SPARCLiteral>();
		ALMTerm is_a_closure_body_is_a = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
		is_a_closure_body_is_a.addArg(XVar);
		is_a_closure_body_is_a.addArg(YVar);
		instance_closure_body.add(is_a_closure_body_is_a);
		
		ALMTerm is_a_closure_body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
		is_a_closure_body_link.addArg(YVar);
		is_a_closure_body_link.addArg(ZVar);
		instance_closure_body.add(is_a_closure_body_link);
		
		SPARCRule closure = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_INSTANCE, instance_closure_head, instance_closure_body);
		closure.addComment("Closure On [instance] relation.");
		closure.addComment("X is an instance of Z if X is an instance of Y and there is a link from Y to Z.");
		
	}
	

	private static void PreModelRulesForSubsort(SPARCProgram pm, SymbolTable st) {

		ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
		ALMTerm YVar = new ALMTerm("Y", ALMTerm.VAR);
		ALMTerm ZVar = new ALMTerm("Z", ALMTerm.VAR);
		
		
		//Add Rule for subsort base case (link) 
		ALMTerm instance_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
		instance_head.addArg(XVar);
		instance_head.addArg(YVar);
		
		List<SPARCLiteral> subsort_body = new ArrayList<SPARCLiteral>();
		ALMTerm subsort_body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
		subsort_body_link.addArg(XVar);
		subsort_body_link.addArg(YVar);
		subsort_body.add(subsort_body_link);
		
		SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SUBSORT, instance_head, subsort_body);
		r.addComment("Base case of [subsort] relation.");
		r.addComment("If there is a link from X to Y in the sort hierarchy then X is a subsort of Y.");
		
		
		
		// Add Rule For Inference across links
		//X is a subsort of Z if there is a link from X to Y and Y is a subsort of Z
		ALMTerm subsort_closure_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
		subsort_closure_head.addArg(XVar);
		subsort_closure_head.addArg(ZVar);
		
		List<SPARCLiteral> subsort_closure_body = new ArrayList<SPARCLiteral>();
		ALMTerm subsort_closure_body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
		subsort_closure_body_link.addArg(XVar);
		subsort_closure_body_link.addArg(YVar);
		subsort_closure_body.add(subsort_closure_body_link);
		
		ALMTerm subsort_closure_body_subsort = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
		subsort_closure_body_subsort.addArg(YVar);
		subsort_closure_body_subsort.addArg(ZVar);
		subsort_closure_body.add(subsort_closure_body_subsort);
		
		SPARCRule closure = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SUBSORT, subsort_closure_head, subsort_closure_body);
		closure.addComment("Closure On [subsort] relation.");
		closure.addComment("X is a subsort of Z if there is a link from X to Y and Y is a subsort of Z.");
		

		//Source needs the closed world assumption since it is a total boolean function.  
		ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
		closeworld_head.setSign(ALMTerm.SIGN_NEG);
		closeworld_head.addArg(XVar);
		closeworld_head.addArg(YVar);
		
		ALMTerm closeworld_body_subsort = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
		closeworld_body_subsort.setSign(ALMTerm.SIGN_NOT);
		closeworld_body_subsort.addArg(XVar);
		closeworld_body_subsort.addArg(YVar);
		
		List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
		closeworld_body.add(closeworld_body_subsort);
		
		SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SUBSORT, closeworld_head, closeworld_body);
		rc.addComment("[subsort] needs the closed world assumption since it is a total boolean function.");
	}


	private static void PreModelRulesForHasParent(SPARCProgram pm, SymbolTable st) {
		
		//X has a parent if there is a link from X to some sort Y. 
		ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
		ALMTerm YVar = new ALMTerm("Y", ALMTerm.VAR);
		
		ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_PARENT, ALMTerm.FUN);
		head.addArg(XVar);
		
		ALMTerm body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
		body_link.addArg(XVar);
		body_link.addArg(YVar);
		
		List<SPARCLiteral> body = new ArrayList<SPARCLiteral>();
		body.add(body_link);
		
		SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_HAS_PARENT, head, body);
		r.addComment("Sort X has a parent in the hierarchy if there is a link from X to some sort Y.");
		
		
		//Has parent needs the closed world assumption since it is a total boolean function.  
		ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_PARENT, ALMTerm.FUN);
		closeworld_head.setSign(ALMTerm.SIGN_NEG);
		closeworld_head.addArg(XVar);
		
		ALMTerm closeworld_body_has_parent = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_PARENT, ALMTerm.FUN);
		closeworld_body_has_parent.setSign(ALMTerm.SIGN_NOT);
		closeworld_body_has_parent.addArg(XVar);
		
		List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
		closeworld_body.add(closeworld_body_has_parent);
		
		SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_HAS_PARENT, closeworld_head, closeworld_body);
		rc.addComment("[has_parent] needs the closed world assumption since it is a total boolean function.");
	}


	private static void PreModelRulesForHasChild(SPARCProgram pm, SymbolTable st) {
		
		//X has a child in the hierarchy if there is a link from some sort Y to X. 
		ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
		ALMTerm YVar = new ALMTerm("Y", ALMTerm.VAR);
		
		ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_CHILD, ALMTerm.FUN);
		head.addArg(XVar);
		
		ALMTerm body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
		body_link.addArg(YVar);
		body_link.addArg(XVar);
		
		List<SPARCLiteral> body = new ArrayList<SPARCLiteral>();
		body.add(body_link);
		
		SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_HAS_CHILD, head, body);
		r.addComment("X has a child in the hierarchy if there is a link from some sort Y to X.");
		
		//Has child needs the closed world assumption since it is a total boolean function.  
		ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_CHILD, ALMTerm.FUN);
		closeworld_head.setSign(ALMTerm.SIGN_NEG);
		closeworld_head.addArg(XVar);
		
		ALMTerm closeworld_body_has_child = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_CHILD, ALMTerm.FUN);
		closeworld_body_has_child.setSign(ALMTerm.SIGN_NOT);
		closeworld_body_has_child.addArg(XVar);
		
		List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
		closeworld_body.add(closeworld_body_has_child);
		
		SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_HAS_CHILD, closeworld_head, closeworld_body);
		rc.addComment("[has_child] needs the closed world assumption since it is a total boolean function.");
	}


	private static void PreModelRulesForSource(SPARCProgram pm, SymbolTable st) {
		//if sort X has no child sort, X is a source sort
		ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
		ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_SOURCE, ALMTerm.FUN);
		head.addArg(XVar);
		
		ALMTerm body_has_child = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_CHILD, ALMTerm.FUN);
		body_has_child.setSign(ALMTerm.SIGN_NEG);
		body_has_child.addArg(XVar);
		
		List<SPARCLiteral> body = new ArrayList<SPARCLiteral>();
		body.add(body_has_child);
		
		SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SOURCE, head, body);
		r.addComment("If sort X has no child sort, X is a source sort");
		
		//Source needs the closed world assumption since it is a total boolean function.  
		ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SOURCE, ALMTerm.FUN);
		closeworld_head.setSign(ALMTerm.SIGN_NEG);
		closeworld_head.addArg(XVar);
		
		ALMTerm closeworld_body_source = new ALMTerm(ALM.SPECIAL_FUNCTION_SOURCE, ALMTerm.FUN);
		closeworld_body_source.setSign(ALMTerm.SIGN_NOT);
		closeworld_body_source.addArg(XVar);
		
		List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
		closeworld_body.add(closeworld_body_source);
		
		SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SOURCE, closeworld_head, closeworld_body);
		rc.addComment("[source] needs the closed world assumption since it is a total boolean function.");
	}


	private static void PreModelRulesForSink(SPARCProgram pm, SymbolTable st) {
		//if sort X has no parent sort, X is a sink sort
		ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
		ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_SINK, ALMTerm.FUN);
		head.addArg(XVar);
		
		ALMTerm body_has_child = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_PARENT, ALMTerm.FUN);
		body_has_child.setSign(ALMTerm.SIGN_NEG);
		body_has_child.addArg(XVar);
		
		List<SPARCLiteral> body = new ArrayList<SPARCLiteral>();
		body.add(body_has_child);
		
		SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SINK, head, body);
		r.addComment("If sort X has no parent sort, X is a sink sort");
		
		//Sink needs the closed world assumption since it is a total boolean function.  
		ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SINK, ALMTerm.FUN);
		closeworld_head.setSign(ALMTerm.SIGN_NEG);
		closeworld_head.addArg(XVar);
		
		ALMTerm closeworld_body_source = new ALMTerm(ALM.SPECIAL_FUNCTION_SINK, ALMTerm.FUN);
		closeworld_body_source.setSign(ALMTerm.SIGN_NOT);
		closeworld_body_source.addArg(XVar);
		
		List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
		closeworld_body.add(closeworld_body_source);
		
		SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SINK, closeworld_head, closeworld_body);
		rc.addComment("[sink] needs the closed world assumption since it is a total boolean function.");
		
	}
	
	

	private static void PreModelStaticFunctionsRules(SPARCProgram pm, SymbolTable st) {
		//Static Functions have predicates declared in the predicate section, 
		//These rules are described in the ALM paper as needing to be added per type of function
		//1) defined functions need the closed world assumption.  -foo(t1..tn) :- not foo(t1..tn).
		
		for(FunctionEntry f : st.getFunctions()){
			if(f.isStatic())
				if(f.isDefined()){
					//defined static functions need the closed world assumption.
					ALMTerm closeworld_head = new ALMTerm(f.getFunctionName(), ALMTerm.FUN, f.getLocation());
					closeworld_head.setSign(ALMTerm.SIGN_NEG);
					ALMTerm closeworld_body_fun = new ALMTerm(f.getFunctionName(), ALMTerm.FUN, f.getLocation());
					closeworld_body_fun.setSign(ALMTerm.SIGN_NOT);
					List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
					closeworld_body.add(closeworld_body_fun);
					
					SPARCPredicate pred_sig = pm.getPredicate(f.getFunctionName());
					String XVar = "X";
					List<SPARCSort> sig = pred_sig.getSignatrue();
					for(int count = 1; count <= sig.size(); count++){
						ALMTerm arg = new ALMTerm(XVar+count, ALMTerm.VAR);
						closeworld_head.addArg(arg);
						closeworld_body_fun.addArg(arg);
					}
					
					SPARCRule r = pm.newSPARCRule(ALM.RULES_CWA_FOR_DEFINED_STATIC_FUNCTIONS, closeworld_head, closeworld_body);
					r.addComment("Function ["+f.getFunctionName()+"] is a defined static function and needs the closed world assumption.");
				}
		}
		
		//Any other rules related to simply the existence of static user defined functions should go here. 
		
	}


	private static void PreModelStaticStateConstraintAxioms(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
		//Not All State Constraints are completely static.  Only the state constraints with purely static literals are added.
		pm.createSection(ALM.AXIOMS_STATE_CONSTRAINTS_STATIC);
		for(ASPfRule ar : aspf.getRules(ALM.AXIOMS_STATE_CONSTRAINTS)){
			if(!ar.hasFluentFunction(st)){
				//basic static functions are the only functions that need to be translated now
				TranslateRule(ar, st, pm, ALM.AXIOMS_STATE_CONSTRAINTS_STATIC);
			}
		}
	}


	private static void PreModelStaticDefinitionsAxioms(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
		//Not All definitions are completely static.  Only the state constraints with purely static literals are added.
		pm.createSection(ALM.AXIOMS_DEFINITIONS_STATIC);
		for(ASPfRule ar : aspf.getRules(ALM.AXIOMS_DEFINITIONS)){
			if(!ar.hasFluentFunction(st)){
				//basic static functions are the only functions that need to be translated now
				TranslateRule(ar, st, pm, ALM.AXIOMS_DEFINITIONS_STATIC);
			}
		}
	}


	private static void PreModelSortInstancesAndAttributeDefinitions(SPARCProgram pm, SymbolTable st,
			ASPfProgram aspf) {
		pm.createSection(ALM.STRUCTURE_SORT_INSTANCES);
		for(ASPfRule ar: aspf.getRules(ALM.STRUCTURE_SORT_INSTANCES))
			TranslateRule(ar, st, pm, ALM.STRUCTURE_SORT_INSTANCES);
		
		pm.createSection(ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS);
		for(ASPfRule ar: aspf.getRules(ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS))
			TranslateRule(ar, st, pm, ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS);
		
	}


	private static void PreModelStructureStaticFunctionDefinitions(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
		pm.createSection(ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS);
		for(ASPfRule ar: aspf.getRules(ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS))
			TranslateRule(ar, st, pm, ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS);
	}


	private static void ConstructFinalProgram(SPARCProgram tm, AnswerSet as, SPARCProgram pm, SymbolTable st, ASPfProgram aspf, ALMCompilerSettings s) {
		CreateFinalSortsSection(tm, pm, as);
		CreateFinalPredicatesSection(tm, pm, as);
		CreateFinalProgramRules(tm, st, pm, aspf);
		LoadFactsFromPreModelAnswerSet(tm, as, s);
	}

	private static void CreateFinalSortsSection(SPARCProgram tm, SPARCProgram pm, AnswerSet as) {
		HashMap<String, SPARCSort> sortmap = new HashMap<String, SPARCSort>();
		List<SPARCSort> pmsorts = pm.getSorts();
		for(SPARCSort pmsort: pmsorts){
			if(pmsort.getSortName() == ALM.SPECIAL_SORT_NODES){
				try {
					tm.addSPARCSort(pmsort);
				} catch (SPARCSortAlreadyDefined e) {
					//This should never happen since the pre-model program did not have duplicate sorts.
					ALMCompiler.PROGRAM_FAILURE("Final Program Sorts", "Redundant Sort Error In Final Program.");
				}
			} else {
				SPARCSort tmsort = new SPARCSort(pmsort.getSortName());
				sortmap.put(tmsort.getSortName(), tmsort);
				try {
					tm.addSPARCSort(tmsort);
				} catch (SPARCSortAlreadyDefined e) {
					//This should never happen since the pre-model program did not have duplicate sorts.
					ALMCompiler.PROGRAM_FAILURE("Final Program Sorts", "Redundant Sort Error In Final Program.");
				}
			}
		}
		
		List<ALMTerm> instances = as.getLiterals(ALM.SPECIAL_FUNCTION_INSTANCE);
		if(instances != null)
			for(ALMTerm instlit : instances){
				ALMTerm ground_object = instlit.getArg(0);
				ALMTerm sort = instlit.getArg(1);
				if(instlit.getSign() == ALMTerm.SIGN_POS){
					SPARCSort tmsort = sortmap.get(sort.toString());
					tmsort.addInstance(ground_object);
				}
			}
		ALMTerm timstepValue0 = new ALMTerm("0", ALMTerm.INT);
		ALMTerm timstepValue1 = new ALMTerm("1", ALMTerm.INT);
		try {
			tm.getSPARCSort("timeStep").addInstance(timstepValue0);
			tm.getSPARCSort("timeStep").addInstance(timstepValue1);
		} catch (SPARCSortNotDefined e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static void CreateFinalPredicatesSection(SPARCProgram tm, SPARCProgram pm, AnswerSet as) {
		for(SPARCPredicate pred : pm.getPredicates())
			try {
				tm.addSPARCPredicate(pred);
			} catch (PredicateAlreadyDeclared e) {
				//This should never happen since the pre-model program did not have duplicate predicates.
				ALMCompiler.PROGRAM_FAILURE("Final Program Predicates", "Redundant Predicate Error In Final Program.");
			}	
	}

	private static void CreateFinalProgramRules( SPARCProgram tm, SymbolTable st, SPARCProgram pm, ASPfProgram aspf) {
		//Copy section from pre model program
		tm.copyRulesSections(pm);
		
		//Add sections containing fluent functions.
		FinalProgramDynamicCausalLaws(tm, st, aspf);
		
		FinalProgramExecutabilityConditions(tm, st, aspf);
		
		FinalProgramStateConstraints(tm, st, aspf);
		
		FinalProgramDefinitions(tm, st, aspf);
	}


	private static void FinalProgramDynamicCausalLaws(SPARCProgram tm, SymbolTable st, ASPfProgram aspf) {
		//all rules are dynamic since it has actions. 
		tm.createSection(ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS);
		for(ASPfRule ar: aspf.getRules(ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS)){
			TranslateRule(ar, st, tm, ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS);
		}
	}

	private static void FinalProgramExecutabilityConditions(SPARCProgram tm, SymbolTable st, ASPfProgram aspf) {
		//all rules are dynamic since it has actions. 
		tm.createSection(ALM.AXIOMS_EXECUTABILITY_CONDITIONS);
		for(ASPfRule ar: aspf.getRules(ALM.AXIOMS_EXECUTABILITY_CONDITIONS)){
			TranslateRule(ar, st, tm, ALM.AXIOMS_EXECUTABILITY_CONDITIONS);
		}
	}

	private static void FinalProgramStateConstraints(SPARCProgram tm, SymbolTable st, ASPfProgram aspf) {
		//Not All State Constraints have fluents.  Only the state constraints with fluents are added.
		tm.createSection(ALM.AXIOMS_STATE_CONSTRAINTS_FLUENT);
		for(ASPfRule ar : aspf.getRules(ALM.AXIOMS_STATE_CONSTRAINTS)){
			if(ar.hasFluentFunction(st)){
				//basic static functions are the only functions that need to be translated now
				TranslateRule(ar, st, tm, ALM.AXIOMS_STATE_CONSTRAINTS_FLUENT);
			}
		}
	}

	private static void FinalProgramDefinitions(SPARCProgram tm, SymbolTable st, ASPfProgram aspf) {
		//Not All definitions have fluents.  Only the state constraints with fluents are added.
		tm.createSection(ALM.AXIOMS_DEFINITIONS_FLUENT);
		for(ASPfRule ar : aspf.getRules(ALM.AXIOMS_DEFINITIONS)){
			if(ar.hasFluentFunction(st)){
				//basic static functions are the only functions that need to be translated now
				TranslateRule(ar, st, tm, ALM.AXIOMS_DEFINITIONS_FLUENT);
			}
		}
	}

	private static void LoadFactsFromPreModelAnswerSet(SPARCProgram tm, AnswerSet as, ALMCompilerSettings s) {
		tm.createSection(ALM.OPTIMIZATION_ADD_FACTS_FROM_PRE_MODEL_ANSWERSET);
		if(s.OptimizationAddAllFactsFromPreModelAnswerset())
			for(List<ALMTerm> lits : as.getAllAlmTerms())
				for(ALMTerm lit : lits)
					tm.newSPARCRule(ALM.OPTIMIZATION_ADD_FACTS_FROM_PRE_MODEL_ANSWERSET, lit, null);
		else{
			SPARCRule dummy = tm.newSPARCRule(ALM.OPTIMIZATION_ADD_FACTS_FROM_PRE_MODEL_ANSWERSET, null, null);
			dummy.addComment("This optimization is turned off.");
		}
		
	}

	
	
	

	public static void PROGRAM_FAILURE(String phase, String error) {
		if(DEBUG_VERSION)
			throw new AlmCompilerPermanentFailure(phase, error);
		
		System.err.println("["+phase+"] "+error);
		System.exit(-1);	
		
	}


	
	public static final void Translate(Reader r,ALMCompilerSettings s, SymbolTable st, ErrorReport er, 
			ASPfProgram aspf, SPARCProgram pm, List<AnswerSet> as, SPARCProgram tm) throws IOException{
		
		CharStream cs = null;
		try {
			cs = new ANTLRInputStream(r);
		} catch (IOException e) {
			e.printStackTrace();
			PROGRAM_FAILURE("Preparing ANTLR Parser Input", "Could not create ANTLRInputStream due to IOException.");
		}
		ALMLexer al = new ALMLexer(cs);
		TokenStream ts = new BufferedTokenStream(al);
		ALMParser foo = new ALMParser(ts);
		
		foo.addParseListener(new ALMBaseListener(s, st, er, aspf));
		foo.removeErrorListeners();
		foo.addErrorListener(new ALMSyntaxErrorListener(er));
		foo.system_description();


		st.writeTo(s.SymbolTableDestination());
		s.closeSymbolTableDestination();
		aspf.writeTo(s.IntermediateASPfDestination());
		s.closeIntermediateASPfDestination();
		
		if(er.noErrors()){
			ConstructPreModelProgram(pm, st, aspf);
			pm.writeTo(s.PreModelDestination());
			s.closePreModelDestination();
			as = GetAnswerSet(pm, s);
			AnswerSets.writeTo(s.AnswerSetsDestination(), as);
			s.closeAnswerSetsDestination();
			if(as.size() == 1){
				ConstructFinalProgram(tm, as.get(0), pm, st, aspf, s );
				tm.writeTo(s.TransitionModelDestination());
				s.closeTransitionModelDestination();
			} else {
				er.newSemanticError(SemanticError.ANS001);
				
			}
		
		}
		er.writeTo(s.ErrorDestination());
		s.closeErrorDestination();

		
		
	}
	
	
	

	/***
	 * 
	 * @param ar
	 * @param body (the new body)
	 * @param st
	 * @return  (the head of the rule) 
	 * 
	 * This function is the meat of the endeavor.   Based on the type of literal there are different translations
	 * case: function at top
	 * subcase: static boolean function --  no change
	 * subcase: fluent boolean function -- add time dimension at end of predicate. 
	 * case: term relation
	 * 		replace each type of function occurrence in the term with a variable. 
	 * 		Add a new literal to the body with the variable added and a time component if it is basic.
	 */
	private static void TranslateRule(ASPfRule ar, SymbolTable st, SPARCProgram pm, String section) {
		VariableManager vm = ar.initializeNewVariableManager(st);
		String timestep = vm.newVariable("TS");
		boolean hasFluentFunction = false;
		
		
		//Translate HEAD
		SPARCLiteral head = null;
		ASPfLiteral ahead = ar.getHead();
		if(ahead != null){
			ALMTerm thead = (ALMTerm)ahead;
			if(thead.hasFluentFunction(st))
				hasFluentFunction = true;
			switch(thead.getType()){
			case ALMTerm.FUN:
				FunctionEntry f = null;
				try {
					f = st.getFunctionEntry(thead);
					if(!f.isBoolean())
						PROGRAM_FAILURE("Translate Rule", "Non Boolean Function ["+f.getFunctionName()+"] must be in a Term Relation at head of rule");
						//Should be caught by semantic error. 
					if(f.isStatic())
							head = thead; 
					else if(f.isFluent()) {
							//construct corresponding sparc literal
							head = new_SPARCLiteral_Boolean_Fluent(f, thead.getArgs(), timestep);
					}else
						PROGRAM_FAILURE("Translate Rule", "Non Static Or Fluent Function ["+f.getFunctionName()+ " at head of rule");
						//Should never happen
				} catch (FunctionNotFound e) {
					PROGRAM_FAILURE("Translate Rule", "Function  ["+thead.toString()+"] Is Not In The Symbol Table");
					//Should be caught by semantic error. 
				}
				break;
			case ALMTerm.TERM_RELATION:
				//must be = or != relation with function on left and variable or ID on right. 
				ALMTerm left = thead.getArg(0);
				ALMTerm right = thead.getArg(1);
				if (thead.getName() != ALM.SYMBOL_EQ && thead.getName() != ALM.SYMBOL_NEQ)
					PROGRAM_FAILURE("Translate Rule", "Term relation at head of rule must be = or !=");
					//Should be caught by syntax error. 
//				if(right.getType() != ALMTerm.ID && right.getType() != ALMTerm.VAR)//the object constant can be occur on the right and it is fun
//					PROGRAM_FAILURE("Translate Rule", "Right hand side of term relation must be ID or VAR in head of rule.");
					//Should be caught by syntax error. 
				if(left.getType() != ALMTerm.FUN)
					PROGRAM_FAILURE("Translate Rule", "Only a function can appear on the left hand side of a term relation at the head of a rule.");
					//Should be caught by syntax error. 
				FunctionEntry ft;
				try {
					ft = st.getFunctionEntry(left);
					if(ft.isBoolean())
						PROGRAM_FAILURE("Translate Rule", "Boolean Function cannot be in a Term Relation at head of rule");
						//Should be caught by semantic error.
					if(ft.isStatic())
						head = new_SPARCLiteral_NonBoolean_Static(ft, left.getArgs(), right);
					else if(ft.isFluent()){
						head = new_SPARCLiteral_NonBoolean_Fluent(ft, left.getArgs(), right, timestep+"+1");
					} else 
						PROGRAM_FAILURE("Translate Rule", "Non Static Or Fluent Function ["+ft.getFunctionName()+ "] at head of rule");
						//Should never happen
					//need to determine sign of the predicate
					if(thead.getName() == ALM.SYMBOL_NEQ)
						((ALMTerm)head).setSign(ALMTerm.SIGN_NEG);
				} catch (FunctionNotFound e) {
					PROGRAM_FAILURE("Translate Rule", "Function  ["+left.toString()+"] Is Not In The Symbol Table");
					//Should be caught by semantic error. 
				}
				break;
			default: 
				PROGRAM_FAILURE("Translate Rule", "Head ["+thead.toString()+"] existed in ASPF but could not create head for SPARC");
			}
		}
		
		//END CONSTRUCTION OF HEAD LITERAL
		
		
		//START CONSTRUCTION OF BODY
		List<SPARCLiteral> body = null;
		List<ASPfLiteral> abody = ar.getBody();
		if(abody != null && abody.size() > 0){
			body = new ArrayList<SPARCLiteral>();
			for(ASPfLiteral alit : abody){
				ALMTerm tlit = (ALMTerm)alit;
				switch(tlit.getType()){
				case ALMTerm.FUN: 
					FunctionEntry f;
					try {
						f = st.getFunctionEntry(tlit);
						if(!f.isBoolean())
							PROGRAM_FAILURE("Translate Rule", "Non Boolean Function ["+tlit.toString()+"] must be in a Term Relation in body of rule");
							//Should be caught by semantic error. 
						if(f.isStatic())
								body.add(tlit); 
						else if(f.isFluent()) {
								//construct corresponding sparc literal
								body.add(new_SPARCLiteral_Boolean_Fluent(f, tlit.getArgs(), timestep));
						}else
							PROGRAM_FAILURE("Translate Rule", "Non Static Or Fluent Function ["+f.getFunctionName()+ "] in body of rule");
							//Should never happen
					} catch (FunctionNotFound e) {
						PROGRAM_FAILURE("Translate Rule", "Function  ["+tlit.toString()+"] Is Not In The Symbol Table");
						//Should be caught by semantic error. 
					}
					break;
				case ALMTerm.TERM_RELATION:
					//A term relation can have any number of functions occurring inside of them
					//Each function occurrence shall be replaces with a new variable and a new literal
					//for the function is added to the body tying the new variable to the value of the
					//function occurrence.   This will be done with recursion to construct a brand new 
					//term relation that is free of all function occurrences.  
					ALMTerm new_term_relation = TranslateTermRelation(tlit, body, st, vm, timestep);
					body.add(new_term_relation);
					break;
				default:
					PROGRAM_FAILURE("Translate Rule", "Could Not Translate Literal ["+tlit.toString()+"] from ASPf in body of rule"); 
				}
			}
			
		}

		SPARCRule r = pm.newSPARCRule(section, head, body);
		r.copyComments(ar);
		if(hasFluentFunction)
			r.addComment(timestep+" is the Time Step Variable." );
	}


	private static ALMTerm TranslateTermRelation(ALMTerm tlit, List<SPARCLiteral> body, SymbolTable st,
			VariableManager vm, String timestep) {
		ALMTerm termRelation = new ALMTerm(tlit.getName(), ALMTerm.TERM_RELATION);
		termRelation.addArg(TranslateTerm(tlit.getArg(0), body, st, vm, timestep));
		termRelation.addArg(TranslateTerm(tlit.getArg(1), body, st, vm, timestep));
		return termRelation;
	}


	private static ALMTerm TranslateTerm(ALMTerm term, List<SPARCLiteral> body, SymbolTable st, VariableManager vm, String timestep) {
		switch(term.getType()){
		case ALMTerm.FUN:
			FunctionEntry f;
			try {
				f = st.getFunctionEntry(term);
				String new_var_base = f.getFunctionName().substring(0, 1).toUpperCase()+"O";
				//Get New Variable
				ALMTerm new_var = new ALMTerm(vm.newVariable(new_var_base), ALMTerm.VAR);
				//Need To Add the Function To the Body of the rule we are constructing;
				if(f.isBoolean())
					PROGRAM_FAILURE("Translate Term", "Boolean function ["+f.getQualifiedFunctionName()+" is occurring nested within a term");
				if(f.isStatic()){
					body.add(new_SPARCLiteral_NonBoolean_Static(f, term.getArgs(), new_var ));
				} else if (f.isFluent()){
					body.add(new_SPARCLiteral_NonBoolean_Fluent(f, term.getArgs(), new_var, timestep));
				} else 
					PROGRAM_FAILURE("Translate Term", "Could not create sparl literal for term ["+term.toString()+"]");
				//return the variable as the function's replacement. 
				return new_var;
			} catch (FunctionNotFound e) {
				PROGRAM_FAILURE("Translate Rule", "Term  ["+term.toString()+"] Is Not In The Symbol Table");
				//Should be caught by semantic error. 
			}
		default:
			ALMTerm copy = new ALMTerm(term.getName(), term.getType());
			if(term.getArgs() != null)
				for(ALMTerm arg:term.getArgs())
					copy.addArg(TranslateTerm(arg, body, st, vm, timestep));
			return copy;
		}
	}


	private static SPARCLiteral new_SPARCLiteral_NonBoolean_Static(FunctionEntry f, List<ALMTerm> args, ALMTerm range) {
		ALMTerm slit = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
		if(args != null)
			for(ALMTerm arg:args)
				slit.addArg(arg);
		slit.addArg(range);
		return slit;
	}


	private static SPARCLiteral new_SPARCLiteral_Boolean_Fluent(FunctionEntry f, List<ALMTerm> args, String timestep) {
		ALMTerm slit = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
		if(args != null)
			for(ALMTerm arg:args)
				slit.addArg(arg);
		slit.addArg(new ALMTerm(timestep, ALMTerm.ID));
		return slit;
	}



	private static SPARCLiteral new_SPARCLiteral_NonBoolean_Fluent(FunctionEntry f, List<ALMTerm> args, ALMTerm range, String timestep) {
		ALMTerm slit = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
		if(args != null)
			for(ALMTerm arg:args)
				slit.addArg(arg);
		slit.addArg(range);
		slit.addArg(new ALMTerm(timestep, ALMTerm.ID));
		return slit;
	}
	


}

