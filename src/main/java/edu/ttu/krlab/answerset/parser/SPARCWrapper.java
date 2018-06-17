package edu.ttu.krlab.answerset.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class SPARCWrapper {

    // take in a string that represents a sparc file
    // return a list of answer sets that are queryable for alm terms
    public static ArrayList<AnswerSet> solve(String sparcProgram, String pathToSPARCJar, String pathToJava,
            String PathToASPSolver, String whichSolver) {

        String answerSetsString = computeAnswerSets(sparcProgram, pathToSPARCJar, pathToJava, PathToASPSolver,
                whichSolver);
        ArrayList<AnswerSet> answerSets = parseAnswerSets(answerSetsString);
        for (int i = 0; i < answerSets.size(); i++) {
            answerSets.get(i).hashALMTerms();
        }
        return answerSets;
    }

    // computes the answer sets of a program
    // requires the paths necessary to run the program as well as which solver to use
    // returns a string representation of the answer sets
    private static String computeAnswerSets(String sparcProgram, String pathToSPARCJar, String pathToJava,
            String pathToASPSolver, String whichSolver) {

        List<String> command = new ArrayList<String>();
        command.add(pathToJava);
        command.add("-jar");
        command.add(pathToSPARCJar);
        command.add("-A");
        command.add("--disable-empty-sort-check");
        if (whichSolver.toUpperCase().charAt(0) == 'C') {
            command.add("-solver");
            command.add("clingo");
        }
        OsUtils.runCommand(command, sparcProgram, pathToASPSolver);
        if (OsUtils.errors.toString().length() > 31
                && OsUtils.errors.toString().substring(0, 31).equals("Error: Unable to access jarfile")) {
            throw new RuntimeException("Unable to find Sparc Solver at given path: "+pathToSPARCJar);
        }
        if (OsUtils.errors.toString().length() > 38
                && OsUtils.errors.toString().substring(0, 38).equals("java.lang.UnsupportedClassVersionError")) {
            throw new RuntimeException("Newer version of java required");
        }
        if (OsUtils.errors.toString().length() > 45
                && OsUtils.errors.toString().substring(32, 45).equals("dlv not found")) {
            throw new RuntimeException("Unable to locate dlv solver: "+pathToASPSolver);
        }
        if (OsUtils.errors.toString().length() > 45
                && OsUtils.errors.toString().substring(32, 48).equals("Clingo not found")) {
            throw new RuntimeException("Unable to locate clingo solver: "+pathToASPSolver);
        }

        if (OsUtils.result.toString().equals("")) {
            System.err.println("FAILED PROGRAM:\n"+sparcProgram);
            throw new RuntimeException(OsUtils.errors.toString());
        }
        return OsUtils.result.toString();
    }

    private static ArrayList<AnswerSet> parseAnswerSets(String answerSets) {
        StringReader sr = new StringReader(answerSets);
        BufferedReader br = new BufferedReader(sr);
        DLVAnswerSetParser parser = new DLVAnswerSetParser();
        return parser.getAnswerSets(br);
    }
}

class OsUtils { // from Evgenii Balai and modified to meet ALM's Needs

    public static StringBuffer result;
    public static StringBuffer errors;

    public static void runCommand(List<String> command, String input, String aspsolverpath) {
        Object lockStdOut = new Object();
        Object lockStdErr = new Object();
        Process process = null;
        OsUtils.errors = new StringBuffer();
        OsUtils.result = new StringBuffer();
        try {
            ProcessBuilder sparcprocess = new ProcessBuilder(command);
            String currentPATH = sparcprocess.environment().get("PATH");
            if (aspsolverpath != null && aspsolverpath.length() > 0)
                sparcprocess.environment().put("PATH", aspsolverpath + File.pathSeparatorChar + currentPATH);
            process = sparcprocess.start();

            //create a new process for dlv
            //process = Runtime.getRuntime().exec(path+options);

        } catch (IOException e) {
            throw new RuntimeException("Unable to find java at given path");
            //System.err.println(e.getMessage());

        }

        StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR", lockStdErr);
        StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream(), "STDOUT", lockStdOut);
        // kick them off
        errorGobbler.start();
        outputGobbler.start();
        try {
            // write the provided input to the process
            if (input != null) {
                OutputStream stdin = process.getOutputStream();
                stdin.write(input.getBytes(), 0, input.length());
                stdin.flush();
                stdin.close();
            }
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException("Sparc Solver process interruped while being executed");
                //e.printStackTrace();
            }

            // wait until error stream is ready:
            synchronized (lockStdErr) {
                while (!errorGobbler.isReady()) {
                    try {
                        lockStdErr.wait();
                    } catch (InterruptedException e) {
                        // This should never happen!
                        throw new RuntimeException("error stream interrupted while loading");
                        //e.printStackTrace();
                    }
                }
            }

            // wait until std out stream is ready:
            synchronized (lockStdOut) {
                while (!outputGobbler.isReady()) {
                    try {
                        lockStdOut.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        throw new RuntimeException("standard output stream interrupted while being loaded");
                        //e.printStackTrace();
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(result);
            System.err.println(errors);
            throw new RuntimeException(
                    "IOException occurred from function runCommand in class OsUtils (by the end of the function)");
            //ex.printStackTrace(); // this exception should not occur!
        }
    }

}

class StreamGobbler // from Evgenii Balai
        extends Thread {

    InputStream is;
    String type;
    Object lock;
    boolean ready = false;

    StreamGobbler(InputStream is, String type, Object lock) {
        this.is = is;
        this.type = type;
        this.lock = lock;

    }

    @Override
    public void run() {
        int count = 0;
        final int maxCount = 100000000;
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                count += line.length();
                if (count > maxCount) {
                    System.err.println(
                            "ERROR: the output from the solver exceeds " + Integer.toString(maxCount) + " characters."
                                    + "\n Your program has too many answer sets and we can't process all of them.");
                    // finish him!
                    Runtime.getRuntime().halt(0);
                }
                if (type.equals("STDOUT")) {
                    OsUtils.result.append(line).append("\n");
                } else if (type.equals("ERROR")) {
                    OsUtils.errors.append(line).append("\n");
                }

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        synchronized (lock) {
            ready = true;
            lock.notifyAll();
        }

    }

    public boolean isReady() {
        return ready;
    }
}