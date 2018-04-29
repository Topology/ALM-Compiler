package edu.ttu.krlab.answerset.parser;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;




public class DLVAnswerSetParser implements AnswerSetParser{
    private Scanner sc;
    private String buf;
    int bufIdx;
    public DLVAnswerSetParser() {

    }

    private Character nextChar() {
        if(buf==null || bufIdx==buf.length()) {
           if(sc.hasNext()) {
               buf=sc.next();
               bufIdx=0;
           }
           else {
               return null;
           }
        }
        return buf.charAt(bufIdx++);
    }

    public ArrayList<AnswerSet> getAnswerSets(BufferedReader content) {
        sc=new Scanner(content);
        ArrayList<AnswerSet> result=new ArrayList<AnswerSet>();
        Character next=null;
        while((next=nextChar())!=null) {
            if(next=='{') {
                StringBuilder sb=new StringBuilder();
                while((next=nextChar())!='}') {
                    sb.append(next);
                }
                AnswerSet answerSet=new AnswerSet();
               
                answerSet.atoms.addAll(StringListUtils.splitCommaSequence(sb.toString()));
                result.add(answerSet);
            }
        }
        sc.close();

        return result;
    }
}