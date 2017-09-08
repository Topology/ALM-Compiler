package edu.ttu.krlab.alm.datastruct.sparc;

import java.io.BufferedWriter;
import java.io.IOException;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.LogicProgramArtifact;

public class SPARCSort extends LogicProgramArtifact {

	String sortName;
	String sorts;
	String patterns;
	String groundTerms;
	String expression;

	public SPARCSort(String sortName2) {
		this.sortName = sortName2;
		this.sorts = null;
		this.patterns = null;
		this.groundTerms = null;
		this.expression = null;
	}

	public String getSortName() {
		return sortName;
	}

	public String getExpression() {
		if (expression == null)
			create_expression();
		return expression;
	}

	public void union(SPARCSort sparcSort) {
		expression = null;
		if (this.sorts == null) {
			sorts = "#" + sparcSort.getSortName();
		} else {
			this.sorts = this.sorts + " + #" + sparcSort.getSortName();
		}
	}

	@Override
	public void writeTo(BufferedWriter out) throws IOException {
		super.writeTo(out);
		if (expression == null)
			create_expression();
		out.write("#" + sortName + " = " + expression + ".\n\n");
	}

	public void addInstance(ALMTerm si) {
		expression = null;
		if (si.isGround()) {
			if (this.groundTerms == null)
				this.groundTerms = si.toSortInstance();
			else
				this.groundTerms = this.groundTerms + ", " + si.toSortInstance();
		} else {
			if (this.patterns == null) {
				this.patterns = si.toSortInstance();
			} else {
				this.patterns = this.patterns + " + " + si.toSortInstance();
			}
		}
	}

	private void create_expression() {
		expression = null;

		if (groundTerms != null)
			expression = "{" + groundTerms + "}";

		if (patterns != null)
			if (expression == null)
				expression = patterns;
			else
				expression = expression + " + " + patterns;

		if (sorts != null)
			if (expression == null)
				expression = sorts;
			else
				expression = expression + " + " + sorts;

		if (expression == null)
			expression = "{}";
	}

}
