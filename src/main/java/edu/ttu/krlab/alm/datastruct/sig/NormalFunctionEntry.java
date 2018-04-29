package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.datastruct.Location;

public class NormalFunctionEntry implements FunctionEntry {

	private String funName;
	private List<SortEntry> signature;
	private Location loc;
	private boolean isAttribute;
	private boolean isStatic;
	private boolean isFluent;
	private boolean isDefined;
	private boolean isBasic;
	private boolean isTotal;
	private boolean isSpecial;

	public NormalFunctionEntry(String funname, List<SortEntry> signature, Location loc) {
		this.funName = funname;
		this.signature = signature;
		if (loc == null)
			this.loc = new Location();
		else
			this.loc = loc;
		isAttribute = false;
		isStatic = false;
		isFluent = false;
		isDefined = false;
		isBasic = false;
		isTotal = false;
		isSpecial = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#setAttribute()
	 */
	@Override
	public void setAttribute() {
		this.isAttribute = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#setStatic()
	 */
	@Override
	public void setStatic() {
		this.isStatic = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#setFluent()
	 */
	@Override
	public void setFluent() {
		this.isFluent = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#setBasic()
	 */
	@Override
	public void setBasic() {
		this.isBasic = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#setDefined()
	 */
	@Override
	public void setDefined() {
		this.isDefined = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#setTotal()
	 */
	@Override
	public void setTotal() {
		this.isTotal = true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#setSpecial()
	 */
	@Override
	public void setSpecial() {
		this.isSpecial = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#isAttribute()
	 */
	@Override
	public boolean isAttribute() {
		return isAttribute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#isStatic()
	 */
	@Override
	public boolean isStatic() {
		return isStatic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#isFluent()
	 */
	@Override
	public boolean isFluent() {
		return isFluent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#isBasic()
	 */
	@Override
	public boolean isBasic() {
		return isBasic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#isDefined()
	 */
	@Override
	public boolean isDefined() {
		return isDefined;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#isTotal()
	 */
	@Override
	public boolean isTotal() {
		return isTotal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#isSpecial()
	 */
	@Override
	public boolean isSpecial() {
		return isSpecial;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return this.funName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#getSignature()
	 */
	@Override
	public List<SortEntry> getSignature() {
		return this.signature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#getLocation()
	 */
	@Override
	public Location getLocation() {
		return this.loc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#sigMatch(java.util.List)
	 */
	@Override
	public boolean sigMatch(List<SortEntry> signature) {
		if (this.signature.size() != signature.size())
			return false;
		for (int i = 0; i < signature.size(); i++) {
			if (this.signature.get(i) != signature.get(i))
				return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#writeTo(java.io.
	 * BufferedWriter)
	 */
	@Override
	public void writeTo(BufferedWriter out) throws IOException {

		out.write(this.funName + ": ");
		int length = signature.size();
		for (int i = 0; i < length - 1; i++) {
			out.write(signature.get(i).getSortName());
			if (i < signature.size() - 2)
				out.write(" * ");
		}
		if (length == 0)
			ALMCompiler.IMPLEMENTATION_FAILURE("Writing Function Entry",
					"Length Of Signature is 0 for function [" + this.funName + "]");
		out.write(" -> ");
		out.write(signature.get(signature.size() - 1).getSortName());
		out.write(" " + loc.toString() + " ");

		if (isTotal())
			out.write("total ");
		if (isAttribute())
			out.write("attribute ");
		if (isStatic())
			out.write("static ");
		if (isFluent())
			out.write("fluent ");
		if (isDefined())
			out.write("defined ");
		if (isBasic())
			out.write("basic ");

		out.write("\n");

		out.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#getQualifiedFunctionName()
	 */
	@Override
	public String getQualifiedFunctionName() {

		if (isAttribute()) {
			String sortname = this.signature.get(0).getSortName();
			String funname = getFunctionName();
			return sortname + "_" + funname;
		} else {
			return getFunctionName();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#getRangeSort()
	 */
	@Override
	public SortEntry getRangeSort() {
		return signature.get(signature.size() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ttu.krlab.alm.datastruct.sig.FunctionEntry#isBoolean()
	 */
	@Override
	public boolean isBoolean() {
		SortEntry range = getRangeSort();
		return range.getSortName() == ALM.SORT_BOOLEANS;
	}

}
