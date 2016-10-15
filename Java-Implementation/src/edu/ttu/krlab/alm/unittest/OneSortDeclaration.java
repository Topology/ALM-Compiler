package edu.ttu.krlab.alm.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ttu.krlab.alm.datastruct.err.SemanticError;

public class OneSortDeclaration extends TestingCommon {

	@Test
	public void SemanticErrorSRT001Booleans(){
		
		String TestProgram = "system description travel\n theory basic_motion\n module moving\n sort declarations\n x::booleans\n structure bob_and_John";
		Translate(TestProgram);
		assertNoSyntaxErrors();
		assertSemanticErrors();
		boolean passed = false;
		for(SemanticError e : er.getSemanticErrors()){
			assertEquals("Semantic Error SRT001 Booleans", e.getErrorID(), SemanticError.SRT001);
			passed = true;
		}
		assertEquals("Semantic Error SRT001 Booleans", passed, true);
		
		
	}
	
	@Test
	public void SemanticErrorSRT001Integerss(){
		
		String TestProgram = "system description travel\n theory basic_motion\n module moving\n sort declarations\n x::booleans\n structure bob_and_John";
		Translate(TestProgram);
		assertNoSyntaxErrors();
		assertSemanticErrors();
		boolean passed = false;
		for(SemanticError e : er.getSemanticErrors()){
			assertEquals("Semantic Error SRT001 Integers", e.getErrorID(), SemanticError.SRT001);
			passed = true;
		}
		assertEquals("Semantic Error SRT001 Integers", passed, true);
		
		
	}
	
	@Test
	public void SemanticErrorSRT002Carry(){
		
		String TestProgram = "system description travel\n theory basic_motion\n module moving\n sort declarations\n x::carry\n structure bob_and_John";
		Translate(TestProgram);
		assertNoSyntaxErrors();
		assertSemanticErrors();
		boolean passed = false;
		for(SemanticError e : er.getSemanticErrors()){
			assertEquals("Semantic Error SRT002 Carry", e.getErrorID(), SemanticError.SRT002);
			passed = true;
		}
		assertEquals("Semantic Error SRT002 Carry", passed, true);

	}
	

	
}

