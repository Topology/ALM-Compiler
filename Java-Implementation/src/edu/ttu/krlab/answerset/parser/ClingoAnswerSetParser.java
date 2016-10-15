package edu.ttu.krlab.answerset.parser;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class ClingoAnswerSetParser implements AnswerSetParser{

    public ArrayList<AnswerSet> getAnswerSets(BufferedReader content) {
        Scanner sc =new Scanner(content);
        ArrayList<AnswerSet> result=new ArrayList<AnswerSet>();
        while(sc.hasNext()) {
          String nextLine=sc.nextLine();
          if(nextLine.startsWith("Answer")) {
              AnswerSet answerSet=new AnswerSet();
              String answerSetLine=sc.nextLine();
              if(answerSetLine.length()>0 && !answerSetLine.matches("/^\\s*$/")) {
            	   String[] list= answerSetLine.split("\\s+");
                   Collections.addAll(answerSet.atoms,list);
              }
           
              result.add(answerSet);
          }
        }
        sc.close();
        return result;
    }
}