package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import edu.ttu.krlab.alm.datastruct.Location;

public interface FunctionEntry {

	void setAttribute();

	void setStatic();

	void setFluent();

	void setBasic();

	void setDefined();

	void setTotal();

	void setSpecial();

	boolean isAttribute();

	boolean isStatic();

	boolean isFluent();

	boolean isBasic();

	boolean isDefined();

	boolean isTotal();

	boolean isSpecial();

	String getFunctionName();

	List<SortEntry> getSignature();

	Location getLocation();

	boolean sigMatch(List<SortEntry> signature);

	void writeTo(BufferedWriter out) throws IOException;

	String getQualifiedFunctionName();

	SortEntry getRangeSort();

	boolean isBoolean();

}