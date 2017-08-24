package edu.ttu.krlab.alm.datastruct;

/**
 * This class is a massive kludge.  It's basically an in-memory hybrid object model 
 * to represents all objects in ALM and logic program.  Anything of the form: 
 * -? STRING_1 
 * -? STRING_1 ( STRING_2, ..., STRING_N) 
 * and recursively.  
 * The type attribute indicates which it is.
 * The "writeTo" function renders the ALMTerm in the appropriate flattened string form bysed on type
 * The sign can be set and is relevant if the type supports the sign 
 * This implements both the literal interfaces for ASPf and SPARC. 
 * This class is the nexus for changing stylistic rendering on output. 
 * This class is the target of using ALM.Parse* which handles many literal and terms as ParserRuleContexts
 * When constructing an ALMTerm you use this pattern: 
 * ALMTerm foo = new ALMTerm(<STRING_1>, ALMTERM.<TYPE>, <PARSER_RULE_CONTEXT>)
 * foo.addArg(<ALMTerm>);
 * foo.setSign(<BOOLEAN>); 
 * 
 */


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfLiteral;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.datastruct.sig.ConstantEntry;
import edu.ttu.krlab.alm.datastruct.sig.FunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.FunctionNotFound;
import edu.ttu.krlab.alm.datastruct.sig.SortEntry;
import edu.ttu.krlab.alm.datastruct.sig.SortNotFoundException;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCLiteral;
import edu.ttu.krlab.alm.parser.ALMParser;


public class ALMTerm implements ASPfLiteral, SPARCLiteral{

	public static final String SIGN_NEG = "-";
	public static final String SIGN_POS = "";
	public static final String SIGN_NOT = "not ";
	public static final String ID = "ID";
	public static final String VAR = "VAR";
	public static final String INT = "INTEGER";
	public static final String FUN = "FUN";
	public static final String BOOL = "BOOLEAN";
	public static final String MATH_NEG = "-";
	public static final String MATH_ADD = "ADD";
	public static final String MATH_SUB = "SUBTRACT";
	public static final String MATH_MULT = "MULTIPLY";
	public static final String MATH_DIV = "DIVIDE";
	public static final String MATH_MOD = "MODULO";
	public static final String MATH_EXP = "EXPONENT";
	public static final String TERM_RELATION = "RELATION";
	public static final String SORT = "SORT";
	public static final String ATTR_DEF = "ATTRIBUTE_DEFINITION";

	private static ALMTerm NEXT_TIME_STEP= null;
	private static ALMTerm CURRENT_TIME_STEP = null;
	private static ALMTerm BOOLEAN_TRUE= null;
	private static ALMTerm BOOLEAN_FALSE = null;
	
	private String name;
	private String type;
	private String sort;
	private String sign;
	private List<ALMTerm> args;
	private ParserRuleContext prc;
	private VariableManager typechecker;
	
	private void defaultInit() {
		this.args = null;
		this.sign = ALMTerm.SIGN_POS; //positive by default
		typechecker = null;
		
		switch(type){
			case INT: sort = ALM.SORT_INTEGERS; break;
			case BOOL: sort = ALM.SORT_BOOLEANS; break;
			case VAR: sort = ALM.SORT_UNKNOWN; break;
			default: sort = null;
		}
	}
	
	public ALMTerm(String name, String type){
		this.name = name;
		this.type = type;
		this.prc = null;
		ALMTerm next;
		defaultInit();
		
	}
	
	public ALMTerm(String name, String type, ParserRuleContext prc){
		this.name = name;
		this.type = type;
		this.prc = prc;
		defaultInit();
	}
	
	public ALMTerm(String name, String type, String sort, String sign, List<ALMTerm> args, ParserRuleContext prc, VariableManager typechecker) {
		this.name = name;
		this.type = type;
		this.sort = sort;
		this.sign = sign;
		this.args = args;
		this.prc = prc;
		this.typechecker = typechecker;
	}
	
	public ALMTerm(String name, String type, Location loc) {
		this.name = name;
		this.type = type;
		this.prc = loc.getParserRuleContext();
		defaultInit();
	}


	public String getName(){return name;}
	public void setName(String newName){this.name = newName;}
	public String getType(){return type;}
	public List<ALMTerm> getArgs(){return args;}
	
	public ALMTerm addArg(ALMTerm arg){
		if(args == null)
			args = new ArrayList<ALMTerm>();
		args.add(arg);
		return this;
	}
	
	public ALMTerm addArg(int index, ALMTerm arg){
		args.set(index,arg);
		return this;
	}
	
	public void setArg(int index, ALMTerm arg) {
		this.args.set(index, arg);
	}
	
	public void setSort(String var, String sort){
		if (this.type == VAR && this.name.compareTo(var) == 0)
			this.sort = sort;
		for(ALMTerm arg : args)
			arg.setSort(var, sort);
	}
	
	/*
		private VariableManager typechecker;
	 * Set content of ALMTerm to that of t's content
	 */
	
	public void setContent(ALMTerm t) {
		setName(t.name);
		setType(t.type);
		this.sort = t.getSort();
		setSign(t.getSign());
		setArgs(t.getArgs());
		this.prc = t.getParserRuleContext();
		this.typechecker = t.getTypeChecker();
	}
	
	public String getSort(){ return sort;}
	
	public ParserRuleContext getParserRuleContext() {
		return this.prc;
	}
	
	public VariableManager getTypeChecker() {
		return this.typechecker;
	}
	
	public void setArgsToNull() {
		this.args = null;
	}
	
	public void setArgs(List<ALMTerm> newArgs) {
		this.args = newArgs;
	}

	public boolean isSchema() {
		//schemas have string constants and variables, no mathematical expressions. 
		switch(this.type){
		case ID: 
			if(this.args == null || args.size() == 0)
				return true;
			return false;
		case FUN:
			if(this.args == null || args.size() == 0)
				return true;
			for(ALMTerm arg : args)
				if(!arg.recIsSchema())
					return false;
			return true;
		default:
			return false;
		}
	}

	private boolean recIsSchema(){
		//schemas have string constants and variables, no mathematical expressions. 
		switch(this.type){
		case ID:
		case VAR:
		case INT:
		case BOOL:
			if(this.args == null || args.size() == 0)
				return true;
			return false;
		case FUN:
			if(this.args == null || args.size() == 0)
				return true;
			for(ALMTerm arg : args)
				if(!arg.recIsSchema())
					return false;
			return true;
		default:
			return false;
		}
	}

	public void typeCheck(VariableManager vm,  SymbolTable st, ErrorReport er){
		typechecker = vm;
		this.typeCheck(vm, st, er, null);
	}

	//Recursive type checking that communicates forwards and backwards of what sorts are expected.  
	//Adds type information for variables to variable manager. 
	//expected == null indicates that there is no type expected at this position.  
	private SortEntry typeCheck(VariableManager vm, SymbolTable st, ErrorReport er, SortEntry expected) {
		SortEntry integers = st.getIntegersSortEntry();
		SortEntry booleans = st.getBooleansSortEntry();
			
		//common variables. 
		SortEntry se = null;
		ALMTerm arg1 = null, arg2 = null;
		
		boolean compatible = false;
		SortEntry returnSort = null;
		
		switch(this.type){
		case ALMTerm.ID:
			//write those cases where is the object constant as a single name occurs, instance
			ConstantEntry cnst = st.getConstantEntry(this.getName());
			if(cnst != null){
				List<SortEntry> sourceSort = cnst.getSourceSorts();
				for(SortEntry sEntry: sourceSort){
					if(expected != null && sEntry.subsortof(expected)){
						compatible = true;
						returnSort = sEntry;
						break;
					}
				}
				if(compatible == false)
					er.newSemanticError(SemanticError.TYP003);
	
				return returnSort;
			}else{
				//it is an instance of the expected sort
				compatible = false;
				returnSort = isInstance(expected);
				
				if(returnSort == null)
					er.newSemanticError(SemanticError.TYP003);
				else
					return returnSort;
				
			}
		case ALMTerm.VAR: 
			if(expected != null)
				vm.addTypedVar(this.name, expected, this.prc);
			else 
				vm.addVar(this.name, this.prc);
			return expected;
		case ALMTerm.INT: 
			if(expected != null && expected != integers)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(integers);
			return integers;
		case ALMTerm.BOOL: 
			if(expected != null && expected != booleans)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(booleans);
			return booleans;
		case ALMTerm.MATH_NEG: 
			if(expected != null && expected != integers)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(integers);
			args.get(0).typeCheck(vm, st, er, integers);
			return integers;
		case ALMTerm.MATH_ADD: 
			if(expected != null && expected != integers)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(integers);
			args.get(0).typeCheck(vm, st, er, integers);
			args.get(1).typeCheck(vm, st, er, integers);
			return integers;
		case ALMTerm.MATH_SUB: 
			if(expected != null && expected != integers)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(integers);
			args.get(0).typeCheck(vm, st, er, integers);
			args.get(1).typeCheck(vm, st, er, integers);
			return integers;
		case ALMTerm.MATH_MULT: 
			if(expected != null && expected != integers)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(integers);
			args.get(0).typeCheck(vm, st, er, integers);
			args.get(1).typeCheck(vm, st, er, integers);
			return integers;
		case ALMTerm.MATH_DIV: 
			if(expected != null && expected != integers)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(integers);
			args.get(0).typeCheck(vm, st, er, integers);
			args.get(1).typeCheck(vm, st, er, integers);
			return integers;
		case ALMTerm.MATH_MOD: 
			if(expected != null && expected != integers)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(integers);
			args.get(0).typeCheck(vm, st, er, integers);
			args.get(1).typeCheck(vm, st, er, integers);
			return integers;
		case ALMTerm.MATH_EXP: 
			if(expected != null && expected != integers)
				er.newSemanticError(SemanticError.TYP003).add(this.prc).add(expected).add(integers);
			args.get(0).typeCheck(vm, st, er, integers);
			args.get(1).typeCheck(vm, st, er, integers);
			return integers;
		case ALMTerm.SORT:
			//TODO: Is there anything special we should do here?   
			return null;
		case ALMTerm.TERM_RELATION: 
			//Check sorts of left and right hand side.   Make sure they match up.  
			//NOTE that getting null back as the returned sort indicates we should try again if a sort can be determined. 
			SortEntry leftSort = args.get(0).typeCheck(vm, st, er, null);
			SortEntry rightSort = args.get(1).typeCheck(vm, st, er, leftSort);
			if(rightSort != null)
				leftSort = args.get(0).typeCheck(vm, st, er, rightSort);
			if(leftSort != null && rightSort != null)
				if(!leftSort.subsortof(rightSort) && !rightSort.subsortof(leftSort))
					er.newSemanticError(SemanticError.TYP003).add(this).add(leftSort).add(rightSort);
			return booleans;
		case ALMTerm.FUN:
			String fun_name = this.getName();
			switch(fun_name){
			case ALM.SPECIAL_FUNCTION_HAS_CHILD:
				arg1 = args.get(0);
				try {
					se = st.getSortEntry(arg1.getName());
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF007).add(this.prc);
				}
				return booleans;
			case ALM.SPECIAL_FUNCTION_HAS_PARENT:
				arg1 = args.get(0);
				try {
					se = st.getSortEntry(arg1.getName());
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF008).add(this.prc);
				}
				return booleans;
			case ALM.SPECIAL_FUNCTION_SINK:
				arg1 = args.get(0);
				try {
					se = st.getSortEntry(arg1.getName());
					Set<SortEntry> sorts = se.getChildSorts();
					if(sorts != null && sorts.size() > 0)
						er.newSemanticError(SemanticError.SPF013).add(this.prc);
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF009).add(this.prc);
				}
				return booleans;
			case ALM.SPECIAL_FUNCTION_SOURCE:
				arg1 = args.get(0);
				try {
					se = st.getSortEntry(arg1.getName());
					Set<SortEntry> sorts = se.getChildSorts();
					if(sorts != null && sorts.size() > 0)
						er.newSemanticError(SemanticError.SPF013).add(this.prc);
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF010).add(this.prc);
				}
				return booleans;
			case ALM.SPECIAL_FUNCTION_IS_A:
				arg1 = args.get(0);
				arg2 = args.get(1);
				if(!arg1.isVariable() && ! arg1.isObjectConstant())
					er.newSemanticError(SemanticError.SPF004).add(arg1);
				try {
					se = st.getSortEntry(arg2.getName());
					Set<SortEntry> sorts = se.getChildSorts();
					if(sorts != null && sorts.size() > 0)
						er.newSemanticError(SemanticError.SPF005).add(this.prc);
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF005).add(this.prc);
				}
				return booleans;
			case ALM.SPECIAL_FUNCTION_INSTANCE:
				arg1 = args.get(0);
				arg2 = args.get(1);
				if(!arg1.isVariable() && ! arg1.isObjectConstant())
					er.newSemanticError(SemanticError.SPF002).add(arg1);
				try {
					se = st.getSortEntry(arg2.getName());
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF001).add(this.prc);
				}
				return booleans;
			case ALM.SPECIAL_FUNCTION_LINK:
				arg1 = args.get(0);
				arg2 = args.get(1);
				try {
					se = st.getSortEntry(arg1.getName());
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF003).add(this.prc);
				}
				try {
					se = st.getSortEntry(arg2.getName());
					Set<SortEntry> sorts = se.getChildSorts();
					if(sorts == null && sorts.size() == 0)
						er.newSemanticError(SemanticError.SPF013).add(this.prc);
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF003).add(this.prc);
				}
				return booleans;
			case ALM.SPECIAL_FUNCTION_SUBSORT:
				arg1 = args.get(0);
				arg2 = args.get(1);
				try {
					se = st.getSortEntry(arg1.getName());
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF006).add(this.prc);
				}
				try {
					se = st.getSortEntry(arg2.getName());
					Set<SortEntry> sorts = se.getChildSorts();
					if(sorts == null && sorts.size() == 0)
						er.newSemanticError(SemanticError.SPF014).add(this.prc);
				} catch (SortNotFoundException e1) {
					er.newSemanticError(SemanticError.SPF006).add(this.prc);
				}
				return booleans;
			case ALM.SPECIAL_FUNCTION_OCCURS:
				//argument could be the name of an action sort, a variable, or an object constant declared to be an instance of an action sort.
				ALMTerm arg = getArg(0);
				if(arg.getType() == ALMTerm.VAR)
					return booleans;
				//attempt to get a sort entry
				try {
					se = st.getSortEntry(arg.getName());
					if(se.subsortof(st.getActionsSortEntry()))
						return booleans;
				} catch (SortNotFoundException e1) {
				}
				if(arg.isObjectConstant())
					return booleans;
				er.newSemanticError(SemanticError.SPF011).add(this);
				return booleans;
			default:
				try {
					//check if t is object constant or not
					ConstantEntry ce = st.getConstantEntry(this.getName());
					if(ce == null){ // t is a normal function
						//get the function entry of the t
						FunctionEntry fe = st.getFunctionEntry(this);
						//get the signature of t's function entry
						List<SortEntry> sig = fe.getSignature();
						//check type of t's function entry's argument
						if(sig != null && sig.size() > 0){
							int num_args = sig.size();
							for(int i = 0; i < num_args-1; i++)
								this.getArg(i).typeCheck(vm, st, er, sig.get(i));
							//get the range of the t's function entry
							returnSort = sig.get(num_args-1);
							//check the compatibility of the expected sort and the range of the t's function entry
							if(expected != null && !returnSort.subsortof(expected))
								er.newSemanticError(SemanticError.TYP003).add(this).add(expected).add(returnSort);
							return returnSort; //range sort of function.
						}	
					}else{
						
						//typeCheck the parameter(s) of the object constant ce
						List<SortEntry> sig = ce.getArguments();
						if(sig != null && sig.size() >0){
							int num_args = sig.size();
							for(int i = 0; i < num_args; i++)
								this.getArg(i).typeCheck(vm, st, er, sig.get(i));
						}
						//get the source sort(s) of object constant ce
						List<SortEntry> sourceSorts = ce.getSourceSorts();
						returnSort = null;
						compatible = false;
						//check the range of the attribute function is subsort of the source sort(s) of the object constant otherwise return false
						for(SortEntry sEntry: sourceSorts){
							if(expected != null && sEntry.subsortof(expected)){
								compatible = true;
								returnSort = sEntry;
								break;
							}
						}
						if(compatible == false)
							er.newSemanticError(SemanticError.TYP003).add(this).add(expected);
						else
							return returnSort;
					}
				} catch (FunctionNotFound e) {
					er.newSemanticError(SemanticError.FND003).add(this.prc);
				}
				
			}
		
		default: 
			ALMCompiler.PROGRAM_FAILURE("Type Checking ALMTerm", "All Cases Should Be Explicit, but case ["+type+"] was not handled.");
		}
		return null;
		
	}


	public boolean isVariable() {
		return type == ALMTerm.VAR;
	}

	public boolean isObjectConstant() {
		switch(type){
		case ALMTerm.ID:
			return true;
		case ALMTerm.FUN: 
			if(args == null || args.size() == 0)
				return false;
			for(ALMTerm arg : args)
				if(!arg.isObjectConstant())
					return false;
			return true;
		}
		return false;
	}
	
	
	public SortEntry isInstance(SortEntry sort) {
		boolean compatible = false;
		SortEntry returnSort = null;
		//check compability to the instances of expected sort
		List<ALMTerm> instances = sort.getInstances();
		for(ALMTerm inst: instances){
			if(inst.getName().equals(this.getName())){ 
				compatible = true;
				returnSort = sort;
				break;
			}
		}
		if(compatible == false){
			//we can have multi-level of child sort so it needs to have a recursive function, write a function that called instance function
			//if it is not compatible with expected sort's instances check the child sort's instances
			Set<SortEntry> childSorts = sort.getChildSorts();
			for(SortEntry child: childSorts){
				returnSort = isInstance(child);
				if( returnSort != null)
					break;
			}
		}
		
		if(returnSort != null)
			return returnSort;
		else
			return null;
	}

	@Override
	public void writeTo(BufferedWriter out) throws IOException {
		switch(this.type){

		case ALMTerm.MATH_NEG:
			out.write("-");
			args.get(0).writeTo(out);
			break;
		case ALMTerm.MATH_ADD:
			args.get(0).writeTo(out);
			out.write("+");
			args.get(1).writeTo(out);
			break;
		case ALMTerm.MATH_DIV:
			args.get(0).writeTo(out);
			out.write("/");
			args.get(1).writeTo(out);
			break;
		case ALMTerm.MATH_EXP:
			args.get(0).writeTo(out);
			out.write("^");
			args.get(1).writeTo(out);
			break;
		case ALMTerm.MATH_MOD:
			args.get(0).writeTo(out);
			out.write(" mod ");
			args.get(1).writeTo(out);
			break;
		case ALMTerm.MATH_MULT:
			args.get(0).writeTo(out);
			out.write("*");
			args.get(1).writeTo(out);
			break;
		case ALMTerm.TERM_RELATION:
			args.get(0).writeTo(out);
			out.write(this.name);
			args.get(1).writeTo(out);
			break;
		case ALMTerm.BOOL:
		case ALMTerm.ID:
		case ALMTerm.INT:
		case ALMTerm.VAR:
		case ALMTerm.SORT:
			out.write(this.name);
			break;
		case ALMTerm.FUN:
			out.write(this.sign);
			out.write(this.name);
			if(this.args != null && this.args.size() >0){
				boolean first = true;
				out.write("(");
				for(ALMTerm arg : args){
					if(first)
						first = false;
					else 
						out.write(", ");
					arg.writeTo(out);
				}
				out.write(")");
			}
			break;
		default:
			ALMCompiler.PROGRAM_FAILURE("Writing Out ALMTerm", "Unhandled type ["+this.type+"]");
				
		}	
	}
	
	@Override
	public String toString(){
		StringWriter sw = new StringWriter();
		BufferedWriter out = new BufferedWriter(sw);
		try {
			this.writeTo(out);
			out.flush();
			out.close();
			return sw.toString();
		} catch (IOException e) {
			ALMCompiler.PROGRAM_FAILURE("To String", "Failed to write out term due to IO error");
		}
		return null;
	}


	public void setSign(String sign) {
		this.sign = sign;
		
	}


	public void setType(String type) {
		this.type = type;
	}


	public String toSortInstance() {
		switch(this.type){
		case ALMTerm.VAR:
			if(typechecker == null)
				return ALM.SORT_UNKNOWN;
			SortEntry sort = this.typechecker.getNarrowestSort(this.name);
			return "#"+sort.getSortName();
		case ALMTerm.FUN:
			StringBuffer out = new StringBuffer();
			out.append(this.name);
			if(this.args != null && this.args.size() >0){
				boolean first = true;
				out.append("(");
				for(ALMTerm arg : args){
					if(first)
						first = false;
					else 
						out.append(", ");
					out.append(arg.toSortInstance());
				}
				out.append(")");
			}
			return out.toString();
			
		case ALMTerm.ID:
		case ALMTerm.BOOL:
		case ALMTerm.INT:
			return this.name;
		default:
			ALMCompiler.PROGRAM_FAILURE("SortInstance As String", "Unhandled type ["+this.type+"]");
			return null;
		}	
	}


	public ALMTerm getArg(int i) {
		if(args != null && args.size() > i)
			return args.get(i);
		return null;
	}


	public ParserRuleContext getLocation() {
		return prc;
	}


	public static ALMTerm NEXT_TIME_STEP() {
		if(ALMTerm.NEXT_TIME_STEP == null)
			ALMTerm.NEXT_TIME_STEP = new ALMTerm("I+1", ALMTerm.VAR);
		return ALMTerm.NEXT_TIME_STEP;
	}


	public static ALMTerm CURRENT_TIME_STEP() {
		if(ALMTerm.CURRENT_TIME_STEP == null)
			ALMTerm.CURRENT_TIME_STEP = new ALMTerm("I", ALMTerm.VAR);
		return ALMTerm.CURRENT_TIME_STEP;
	}


	public static ALMTerm BOOLEAN_TRUE() {
		if(ALMTerm.BOOLEAN_TRUE == null)
			ALMTerm.BOOLEAN_TRUE = new ALMTerm("true", ALMTerm.BOOL);
		return ALMTerm.BOOLEAN_TRUE;
	}

	public static ALMTerm BOOLEAN_FALSE() {
		if(ALMTerm.BOOLEAN_FALSE == null)
			ALMTerm.BOOLEAN_FALSE = new ALMTerm("false", ALMTerm.BOOL);
		return ALMTerm.BOOLEAN_FALSE;
	}


	public boolean isGround() {
		switch(this.type){
		case ALMTerm.VAR: 
			return false;
		case ALMTerm.INT:
		case ALMTerm.BOOL:
		case ALMTerm.ID:
			return true;
		default:
			if(args != null && args.size()>0)
				for(ALMTerm arg: args)
					if(!arg.isGround())
						return false;
			return true;
				
			
		}
	}

	
	
	
	@Override
	public boolean hasFluentFunction(SymbolTable st) {
		switch(this.type){
			case FUN:
			FunctionEntry f;
			try {
				f = st.getFunctionEntry(this);
				return f.isFluent();
			} catch (FunctionNotFound e) {
				return false;
			}
			default:
				if(this.args == null || this.args.size() == 0)
					return false;
				for(ALMTerm arg : args)
					if(arg.hasFluentFunction(st))
						return true;
				return false;
		}
	}

	@Override
	public void registerVariables(VariableManager vm) {
		switch(this.type){
		case ALMTerm.VAR:
			vm.addVar(this.name, this.getLocation());
		default:
			if(this.args != null && this.args.size() >0)
				for(ALMTerm arg:args)
					arg.registerVariables(vm);
		}
	}

	public void recordVariableOccurrences(VariableManager vm, SymbolTable st, ErrorReport er) {
		this.typechecker = vm;
		switch(type){
		case ALMTerm.VAR:
			vm.addVar(this.name, this.prc);
		default:
			if(args != null && args.size() > 0)
				for(ALMTerm arg: args)
					arg.recordVariableOccurrences(vm, st, er);
		}
	}

	public String getSign() {
		return this.sign;
	}


}
