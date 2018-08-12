package edu.ttu.krlab.alm.datastruct;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class LogicProgramArtifact {
	
	private List<String> comments = null;
	
	public void addComment(String comment){
		if(comments == null)
			comments = new ArrayList<String>();
		comments.add(comment);
	}
	
	public void  writeTo(BufferedWriter out) throws IOException {
		if(comments == null)
			return;
		
		for(String comment:comments)
			out.write("% "+comment + "\n");
	}

	public void copyComments(LogicProgramArtifact other){
		if(other.comments == null)
			return;
		if(this.comments == null)
			comments = new ArrayList<String>();
		this.comments.addAll(other.comments);
	}
}
