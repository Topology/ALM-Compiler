package edu.ttu.krlab.alm.datastruct.err;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;
import edu.ttu.krlab.alm.datastruct.sig.SortEntry;

public class SemanticError{
	//Errors
	public static final String ANS001 = "ANS001";
	public static final String SRT001 = "SRT001";
	public static final String SRT002 = "SRT002";
	public static final String SRT003 = "SRT003";
	public static final String SRT004 = "SRT004";
	public static final String SRT005 = "SRT005";
	public static final String ATF001 = "ATF001";
	public static final String ATF002 = "ATF002";
	public static final String ATF003 = "ATF003";
	public static final String CND001 = "CND001";
	public static final String CND002 = "CND002";
	public static final String CND003 = "CND003";
	public static final String CND004 = "CND004";
	public static final String CND005 = "CND005";
	public static final String FND001 = "FND001";
	public static final String FND002 = "FND002";
	public static final String FND003 = "FND003";
	public static final String FND004 = "FND004";
	public static final String FND005 = "FND005";
	public static final String FND006 = "FND006";
	public static final String FND007 = "FND007";
	public static final String FND008 = "FND008";
	public static final String AXM001 = "AXM001";
	public static final String AXM002 = "AXM002";
	public static final String AXM003 = "AXM003";
	public static final String AXM004 = "AXM004";
	public static final String AXM005 = "AXM005";
	public static final String AXM006 = "AXM006";
	public static final String AXM007 = "AXM007";
	public static final String AXM008 = "AXM008";
	public static final String AXM009 = "AXM009";
	public static final String AXM010 = "AXM010";
	public static final String AXM011 = "AXM011";
	public static final String AXM012 = "AXM012";
	public static final String SPF001 = "SPF001";
	public static final String SPF002 = "SPF002";
	public static final String SPF003 = "SPF003";
	public static final String SPF004 = "SPF004";
	public static final String SPF005 = "SPF005";
	public static final String SPF006 = "SPF006";
	public static final String SPF007 = "SPF007";
	public static final String SPF008 = "SPF008";
	public static final String SPF009 = "SPF009";
	public static final String SPF010 = "SPF010";
	public static final String SPF011 = "SPF011";
	public static final String SPF012 = "SPF012";
	public static final String SPF013 = "SPF013";
	public static final String SPF014 = "SPF014";
	public static final String SID001 = "SID001";
	public static final String SID002 = "SID002";
	public static final String SID003 = "SID003";
	public static final String SID004 = "SID004";
	public static final String SID005 = "SID005";
	public static final String SFD001 = "SFD001";
	public static final String SFD002 = "SFD002";
	public static final String TYP001 = "TYP001";
	public static final String TYP002 = "TYP002";
	public static final String TYP003 = "TYP003";
	
	
	
	String errID;
	String completeMessage;
	List<Location> locations;
	ErrorMetaData emd;
	
	public SemanticError(String errorID){
		errID = errorID;
		locations = null;
		completeMessage = null;
		emd = ErrorMessageTable.getMetaData(errID);
	}
	
	public SemanticError add(Location loc) {
		if(locations == null)
			locations = new ArrayList<Location>();
		locations.add(loc);
		completeMessage = null;
		return this;
	}
	

	public SemanticError add(ParserRuleContext location){
		this.add(new Location(location));
		return this;
	}

	public String getErrorID() {
		return errID;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public String getErrorMessage() {
		if(emd == null)return "META DATA MISSING FOR ERROR MESSAGE";
		//need to perform appropriate substitutions in string.  
		if(completeMessage == null)
			createCompleteMessage();
		return completeMessage; 
	}

	private void createCompleteMessage() {
		completeMessage = emd.getMessage();
		if(locations == null || locations.size() == 0)
			return;
		int num_subs = this.locations.size();
		for(int i = 1; i <= num_subs; i++){
			String spot = "["+i+"]";
			Location loc = locations.get(i-1);
			String subst = "["+loc.getText()+" "+loc.getLineCol()+"]";
			completeMessage = completeMessage.replaceAll(spot, subst);
		}
	}

	public String getErrorExplanation() {
		if(emd == null)return "META DATA MISSING FOR ERROR EXPLANATION";
		return emd.getExplanation();
	}

	public String getErrorRecommendation() {
		if(emd == null)return "META DATA MISSING FOR ERROR RECOMMENDATION";
		return emd.getRecommendation();
	}

	public void writeTo(BufferedWriter err) throws IOException {
		err.write("ErrorID: "+this.errID + "\n");
		err.write("Message: "+this.getErrorMessage()+"\n");
		err.write("Explanation: "+this.getErrorExplanation()+"\n");
		err.write("Recommendation: "+this.getErrorRecommendation()+"\n");
		err.flush();
	}

	public void add(TerminalNode termnode) {
		this.add(new Location(termnode));
		
	}

	public SemanticError add(ALMTerm aterm) {
		return add(aterm.getLocation());
		
	}

	public SemanticError add(SortEntry se) {
		return this.add(se.getLocation());
	}

}
