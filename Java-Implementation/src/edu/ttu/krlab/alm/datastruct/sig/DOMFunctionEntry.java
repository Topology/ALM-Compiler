package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMTranslator;
import edu.ttu.krlab.alm.datastruct.Location;

public class DOMFunctionEntry implements FunctionEntry {
	
	private FunctionEntry f;
	private List<SortEntry> signature;
	
	public DOMFunctionEntry(FunctionEntry f, SortEntry booleans){
		this.f = f;
		signature = new ArrayList<SortEntry>();
		List<SortEntry> f_sig = f.getSignature();
		int sig_size = f_sig.size()-1;
		for(int i = 0; i < sig_size; i++)
			signature.add(f_sig.get(i));
		signature.add(booleans);
	}

	@Override
	public void setAttribute() {
		//does nothing, as attribute value is determined by wrapped function.
	}

	@Override
	public void setStatic() {
		//does nothing, as attribute value is determined by wrapped function.
	}

	@Override
	public void setFluent() {
		//does nothing, as attribute value is determined by wrapped function.
	}

	@Override
	public void setBasic() {
		//does nothing, as attribute value is determined by wrapped function.
	}

	@Override
	public void setDefined() {
		//does nothing, as attribute value is determined by wrapped function.
	}

	@Override
	public void setTotal() {
		//does nothing, as attribute value is determined by wrapped function.
	}

	@Override
	public void setSpecial() {
		//does nothing, as attribute value is determined by wrapped function.
	}

	@Override
	public boolean isAttribute() {
		return f.isAttribute();
	}

	@Override
	public boolean isStatic() {
		return	f.isStatic();
	}

	@Override
	public boolean isFluent() {
		return f.isFluent();
	}

	@Override
	public boolean isBasic() {
		return f.isBasic();
	}

	@Override
	public boolean isDefined() {
		return f.isDefined();
	}

	@Override
	public boolean isTotal() {
		return f.isTotal();
	}

	@Override
	public boolean isSpecial() {
		return f.isSpecial();
	}

	@Override
	public String getFunctionName() {
		return ALM.DOM_PREFIX+f.getFunctionName();
	}

	@Override
	public List<SortEntry> getSignature() {
		return signature;
	}

	@Override
	public Location getLocation() {
		return f.getLocation();
	}

	@Override
	public boolean sigMatch(List<SortEntry> signature) {
		int sig_size = this.signature.size();
		if(signature.size() != sig_size)
			return false;
		for(int i = 0; i < sig_size; i++)
			if(this.signature.get(i) != signature.get(i))
				return false;
		return true;
	}

	@Override
	public void writeTo(BufferedWriter out) throws IOException {
		
		out.write(this.getFunctionName()+": ");
		int length = signature.size();
		for(int i = 0; i < length -1; i++){
			out.write(signature.get(i).getSortName());
			if(i < signature.size()-2)
				out.write(" * ");
		}
		if(length == 0)
			ALMTranslator.PROGRAM_FAILURE("Writing Function Entry", "Length Of Signature is 0 for function ["+this.getFunctionName()+"]");
		out.write(" -> ");
		out.write(signature.get(signature.size()-1).getSortName());
		out.write(" "+f.getLocation().toString()+ " ");
		

		if(isTotal())
			out.write("total ");
		if(isAttribute())
			out.write("attribute ");
		if(isStatic())
			out.write("static ");
		if(isFluent())
			out.write("fluent ");
		if(isDefined())
			out.write("defined ");
		if(isBasic())
			out.write("basic ");
		
		out.write("\n");
		
		out.flush();

	}

	@Override
	public String getQualifiedFunctionName() {
		return ALM.DOM_PREFIX+f.getQualifiedFunctionName();
	}

	@Override
	public SortEntry getRangeSort() {
		return signature.get(signature.size()-1);
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

}
