package edu.ttu.krlab.alm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ALMCompilerSettings {

    public static final String CL_H = "-h";
    public static final String CL_HELP = "--help";
    public static final String CL_SP = "-sp";
    public static final String CL_SPARC = "--sparc";
    public static final String CL_J = "-j";
    public static final String CL_JAVA = "--java";
    public static final String CL_SO = "-so";
    public static final String CL_SOLVER = "--solver";
    public static final String CL_PM = "-pm";
    public static final String CL_PREMODEL = "--premodel";
    public static final String CL_PAS = "-pas";
    public static final String CL_PREMODEL_ANSWERSET = "--premodel-answerset";
    public static final String CL_FAS = "-fas";
    public static final String CL_FINAL_ANSWERSET = "--final-answerset";
    public static final String CL_TM = "-o";
    public static final String CL_TRANSITIONMODEL = "--out";
    public static final String CL_ER = "-er";
    public static final String CL_ERRORS = "--errors";
    public static final String CL_ST = "-st";
    public static final String CL_SYMBOLTABLE = "--symboltable";
    public static final String CL_ASPF = "-aspf";
    public static final String CL_INTERMEDIATEASPF = "--intermediate-aspf";
    public static final String CL_SD = "-sd";
    public static final String CL_SYSTEMDESCRIPTION = "--system-description";
    public static final String CL_D = "-d";
    public static final String CL_DEBUG = "--debug";
    public static final String CL_C = "-c";
    public static final String CL_CONFIG = "--config";
    public static final String CL_CC = "-cc";
    public static final String CL_CREATECONFIG = "--create-config";
    public static final String CL_OPT = "-opt";
    public static final String CL_OPTIMIZATION = "--optimization";
    public static final String CL_LIB = "-l";
    public static final String CL_LIBRARY = "--libraries";
    public static final String CL_HIST = "-hist";
    public static final String CL_HISTORY = "--history";
    public static final String CL_TPROJ = "-tproj";
    public static final String CL_TEMPORAL_PROJECTION = "--temporal-projection";
    public static final String CL_PLAN = "-plan";
    public static final String CL_PLANNING = "--planning";
    public static final String CL_ABD = "-abd";
    public static final String CL_ABDUCTIVE = "--abductive";

    public static final String SPARC_LOCATION = "SPARC_LOCATION";
    public static final String JAVA_LOCATION = "JAVA_LOCATION";
    public static final String SOLVER_LOCATION = "SOLVER_LOCATION";
    public static final String SOLVER_TYPE = "SOLVER_TYPE";
    public static final String PM_DESTINATION = "PM_DESTINATION";
    public static final String PREMODEL_AS_DESTINATION = "PREMODEL_AS_DESTINATION";
    public static final String FINAL_AS_DESTINATION = "FINAL_AS_DESTINATION";
    public static final String TM_DESTINATION = "TM_DESTINATION";
    public static final String ER_DESTINATION = "ER_DESTINATION";
    public static final String ST_DESTINATION = "ST_DESTINATION";
    public static final String TP_DESTINATION = "TP_DESTINATION";
    public static final String PLAN_DESTINATION = "PLAN_DESTINATION";
    public static final String ASPF_DESTINATION = "ASPF_DESTINATION";
    public static final String SYS_DESC_SOURCE = "SYS_DESC_SOURCE";
    public static final String OPT_ALL_PM_FACTS = "OPT_ALL_PM_FACTS";
    public static final String IMPORT_CONFIG = "IMPORT_CONFIG";
    public static final String LIBRARY_LOCATION = "LIBRARY_LOCATION";

    public static final String STD_ERR = "standard_err";
    public static final String STD_OUT = "standard_out";
    public static final String STD_IN = "standard_in";

    public static final String ON = "on";
    public static final String OFF = "off";

    public static final String SOLVER_DLV = "dlv";
    public static final String SOLVER_CLINGO = "clingo";

    private Map<String, String> settings;
    private BufferedWriter er_destination = null;
    private BufferedWriter st_destination = null;
    private BufferedWriter aspf_destination = null;
    private BufferedWriter pm_destination = null;
    private BufferedWriter tm_destination = null;
    private BufferedWriter premodel_as_destination = null;
    private BufferedWriter final_as_destination = null;

    public ALMCompilerSettings() {
        settings = new HashMap<String, String>();
        defaultSettings();
    }

    public static final String DEFAULT_JAVA_LOCATION = "java"; // assumes java is in a directory on the path.
    public static final String DEFAULT_SPARC_LOCATION = "sparc.jar"; // assumes sparc.jar is in current working
                                                                     // directory
    public static final String DEFAULT_SOLVER_LOCATION = "./"; // assumes current working directory
    public static final String DEFAULT_SOLVER_TYPE = SOLVER_DLV; // assume using dlv
    public static final String DEFAULT_PM_DESTINATION = null; // no destination
    public static final String DEFAULT_INTERMEDIATE_AS_DESTINATION = null; // no destination
    public static final String DEFAULT_FINAL_AS_DESTINATION = null;
    public static final String DEFAULT_TM_DESTINATION = STD_OUT;
    public static final String DEFAULT_ER_DESTINATION = STD_ERR;
    public static final String DEFAULT_ST_DESTINATION = null; // no destination
    public static final String DEFAULT_ASPF_DESTINATION = null; // no destination
    public static final String DEFAULT_SYS_DESC_SOURCE = STD_IN;
    public static final String DEFAULT_OPT_ALL_PM_FACTS = ON;
    public static final String DEFAULT_LIBRARY_LOCATION = "./";

    public void defaultSettings() {

        settings.put(SPARC_LOCATION, DEFAULT_SPARC_LOCATION);
        settings.put(JAVA_LOCATION, DEFAULT_JAVA_LOCATION);
        settings.put(SOLVER_LOCATION, DEFAULT_SOLVER_LOCATION);
        settings.put(SOLVER_TYPE, DEFAULT_SOLVER_TYPE);
        settings.put(PM_DESTINATION, DEFAULT_PM_DESTINATION);
        settings.put(PREMODEL_AS_DESTINATION, DEFAULT_INTERMEDIATE_AS_DESTINATION); // default is no destination
        settings.put(FINAL_AS_DESTINATION, DEFAULT_FINAL_AS_DESTINATION);
        settings.put(ER_DESTINATION, DEFAULT_ER_DESTINATION); // default is std_err
        settings.put(TM_DESTINATION, DEFAULT_TM_DESTINATION); // default is standard out
        settings.put(ST_DESTINATION, DEFAULT_ST_DESTINATION); // default is no destination.
        settings.put(ASPF_DESTINATION, DEFAULT_ASPF_DESTINATION); // default is no destination.
        settings.put(SYS_DESC_SOURCE, DEFAULT_SYS_DESC_SOURCE); // default is read from standard input
        settings.put(OPT_ALL_PM_FACTS, DEFAULT_OPT_ALL_PM_FACTS);
        settings.put(LIBRARY_LOCATION, DEFAULT_LIBRARY_LOCATION);
    }

    public void debugSettings() {
        settings.put(PM_DESTINATION, STD_OUT);
        settings.put(PREMODEL_AS_DESTINATION, STD_OUT);
        settings.put(FINAL_AS_DESTINATION, STD_OUT);
        settings.put(ER_DESTINATION, STD_ERR);
        settings.put(TM_DESTINATION, STD_OUT);
        settings.put(ST_DESTINATION, STD_OUT);
        settings.put(ASPF_DESTINATION, STD_OUT);
        settings.put(OPT_ALL_PM_FACTS, OFF);

    }

    public void printUsage() {
        System.out.print("The ALM Traslator requires specific settings in order to run.");
        System.out.print("  The location of the SPARC's jar file must be provided.");
        System.out.print(
                "  If java version 1.8.* is not installed on your path then the location of the proper java executable must be provided.");
        System.out.print(
                "  SPARC requires an ASP Solver, either clingo or dlv and the directory and type of solver must be indicated.");
        System.out.print("  These settings can be specified on the commandline or be provided in a config file.");
        System.out.print(
                "  Once the proper settings are determined, you can export them to a config file with '-cc configfile' at the end of the commandline.");
        System.out.print("  You can use a config file with '-c configfile'.\n");
        System.out.println("Usage:\n");
        System.out.println(
                "Any entry without a commandline option is assumed to be the path to the input ALM System Description.\n");

        System.out.println("(" + CL_H + " |  " + CL_HELP + ")\n");
        System.out.println("  Describe Commandline Arguments\n");

        System.out.println("(" + CL_SP + " |  " + CL_SPARC + ") <path>\n");
        System.out.print("  Provide the <path> To SPARC's jar file.");
        System.out.println("  If absent, we assume it is in the current working directory.\n");

        System.out.println("(" + CL_J + " |  " + CL_JAVA + ") <path>\n");
        System.out.print("  Provide the <path> To java executable for JRE 1.8.*");
        System.out.println("  If absent, we assume it is in the current working directory.\n");

        System.out.println("(" + CL_SO + " |  " + CL_SOLVER + ") <path> <type>\n");
        System.out.print(
                "  Provide the <path> to the directory containing the ASP Solver and indicate the <type> as one of (dlv | clingo).");
        System.out.println("  If absent, we assume dlv is in the current working directory.\n");
        ;

        System.out.println("(" + CL_PM + " |  " + CL_PREMODEL + ") <filename>\n");
        System.out.print("  Provide <filename> to write the pre-model program.");
        System.out.println("  If absent, the default is to not output the premodel program.\n");

        System.out.println("(" + CL_PAS + " |  " + CL_PREMODEL_ANSWERSET + ") <filename>\n");
        System.out.print("  Provide <filename> to write the answerset of the pre-model program.");
        System.out.println("  If absent, the default is to not output the answerset of the premodel program.\n");

        System.out.println("(" + CL_FAS + " |  " + CL_FINAL_ANSWERSET + ") <filename>\n");
        System.out
                .print("  Provide <filename> to write the answerset resulting from the application of the TM program.");
        System.out.println("  If absent, the default destination is standard output.\n");

        System.out.println("(" + CL_TM + " |  " + CL_TRANSITIONMODEL + ") <filename>\n");
        System.out.print("  Provide <filename> to write the final transition diagram program.");
        System.out.println("  If absent, the default is to print to standard out on the console.\n");

        System.out.println("(" + CL_ER + " |  " + CL_ERRORS + ") <filename>\n");
        System.out.print("  Provide <filename> to write the errors in the system description.");
        System.out.println("  If absent, the default is to print to standard err on the console.\n");

        System.out.println("(" + CL_ST + " |  " + CL_SYMBOLTABLE + ") <filename>\n");
        System.out.print("  Provide <filename> to write the symbol table representing the action signature.");
        System.out.println("  If absent, the default is to not output the symboltable.\n");

        System.out.println("(" + CL_ASPF + " |  " + CL_INTERMEDIATEASPF + ") <filename>\n");
        System.out.print(
                "  Provide <filename> to write the intermediate ASPf representation of the axioms and structure.");
        System.out.println("  If absent, the default is to not output the intermediate ASPf rules.\n");

        System.out.println("(" + CL_SD + " |  " + CL_SYSTEMDESCRIPTION + ") <filename>\n");
        System.out.print("  Provide <filename> to read the input system description from.");
        System.out.print(
                "  If absent, the first unqualified commandline argument is assumed to be the proper input file.");
        System.out.print(
                "  If absent, and there is no unqualified commandline argument, input is read from standard in on console.");
        System.out.println("  To override a config file and force reading from standard in, use '" + STD_IN
                + "' as the filename.\n");

        System.out.println("(" + CL_D + " |  " + CL_DEBUG + ")\n");
        System.out.print("  Indicate debug settings should be used, modified by following commandline arguments.");
        System.out.println(
                "  Debug Settings send errors to standard err and all content to standard out on the console.\n");

        System.out.println("(" + CL_C + " |  " + CL_CONFIG + ") <filename>\n");
        System.out.print("  Provide <filename> from which to read a configuration for the ALM Translator.");
        System.out.print("  Any following commandline arguments modify the given configuration.");
        System.out.println("  If absent, the default settings are applied. \n");

        System.out.println("(" + CL_CC + " |  " + CL_CREATECONFIG + ") <filename>\n");
        System.out.print("  Provide <filename> of the settings config file to create.");
        System.out.print("  Captures any preceding commandline configurations into the config file.");
        System.out.println("  Only creates the settings file and does not translate a system description.\n");

        System.out.println("(" + CL_OPT + " |  " + CL_OPTIMIZATION + ") <name of optimization> (on | off)\n");
        System.out.println("  If absent, the default settings have the optimization on.");
        System.out.println("  '" + OPT_ALL_PM_FACTS + "' -- add all facts from premodel answerset to final program.\n");

        System.out.println("(" + CL_LIB + " |  " + CL_LIBRARY + ") <path to directory containing libraries>\n");
        System.out.println("  If absent, the default location for libraries is the current working directory.");
        System.out.println("  Library names refer to names of sub-directories of the library directory.");
        System.out.println(
                "  Theory names within a library refer to file names of alm system descriptions within the library's directory.\n");

    }

    public BufferedWriter ErrorDestination() throws IOException {
        String destination = settings.get(ER_DESTINATION);
        if (destination == null)
            return null;
        switch (destination) {
        case STD_ERR:
            return new BufferedWriter(new OutputStreamWriter(System.err)); // send to console error
        case STD_OUT:
            return new BufferedWriter(new OutputStreamWriter(System.out));
        default:
            // ensure parent directories exist
            try {
                new File(new File(destination).getParent()).mkdirs();
            } catch (Exception ex) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Opening file for output.",
                        "Parent directories could not be created along path: " + destination);
            }
            er_destination = new BufferedWriter(new FileWriter(destination));
            return er_destination;
        }
    }

    public BufferedWriter SymbolTableDestination() throws IOException {
        String destination = settings.get(ST_DESTINATION);
        if (destination == null)
            return null;
        switch (destination) {
        case STD_ERR:
            return new BufferedWriter(new OutputStreamWriter(System.err)); // send to console error
        case STD_OUT:
            return new BufferedWriter(new OutputStreamWriter(System.out));
        default:
            // ensure parent directories exist
            try {
                new File(new File(destination).getParent()).mkdirs();
            } catch (Exception ex) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Opening file for output.",
                        "Parent directories could not be created along path: " + destination);
            }
            st_destination = new BufferedWriter(new FileWriter(destination));
            return st_destination;
        }
    }

    public BufferedWriter IntermediateASPfDestination() throws IOException {
        String destination = settings.get(ASPF_DESTINATION);
        if (destination == null)
            return null;
        switch (destination) {
        case STD_ERR:
            return new BufferedWriter(new OutputStreamWriter(System.err)); // send to console error
        case STD_OUT:
            return new BufferedWriter(new OutputStreamWriter(System.out));
        default:
            // ensure parent directories exist
            try {
                new File(new File(destination).getParent()).mkdirs();
            } catch (Exception ex) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Opening file for output.",
                        "Parent directories could not be created along path: " + destination);
            }
            aspf_destination = new BufferedWriter(new FileWriter(destination));
            return aspf_destination;
        }
    }

    public BufferedWriter PreModelDestination() throws IOException {
        String destination = settings.get(PM_DESTINATION);
        if (destination == null)
            return null;
        switch (destination) {
        case STD_ERR:
            return new BufferedWriter(new OutputStreamWriter(System.err)); // send to console error
        case STD_OUT:
            return new BufferedWriter(new OutputStreamWriter(System.out));
        default:
            // ensure parent directories exist
            try {
                new File(new File(destination).getParent()).mkdirs();
            } catch (Exception ex) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Opening file for output.",
                        "Parent directories could not be created along path: " + destination);
            }
            pm_destination = new BufferedWriter(new FileWriter(destination));
            return pm_destination;
        }
    }

    public BufferedWriter AnswerSetsDestination() throws IOException {
        String destination = settings.get(PREMODEL_AS_DESTINATION);
        if (destination == null)
            return null;
        switch (destination) {
        case STD_ERR:
            return new BufferedWriter(new OutputStreamWriter(System.err)); // send to console error
        case STD_OUT:
            return new BufferedWriter(new OutputStreamWriter(System.out));
        default:
            // ensure parent directories exist
            try {
                new File(new File(destination).getParent()).mkdirs();
            } catch (Exception ex) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Opening file for output.",
                        "Parent directories could not be created along path: " + destination);
            }
            premodel_as_destination = new BufferedWriter(new FileWriter(destination));
            return premodel_as_destination;
        }
    }

    public BufferedWriter FinalAnswerSetsDestination() throws IOException {
        String destination = settings.get(FINAL_AS_DESTINATION);
        if (destination == null)
            return null;
        switch (destination) {
        case STD_ERR:
            return new BufferedWriter(new OutputStreamWriter(System.err));
        case STD_OUT:
            return new BufferedWriter(new OutputStreamWriter(System.out));
        default:
            // ensure parent directories exist
            try {
                new File(new File(destination).getParent()).mkdirs();
            } catch (Exception ex) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Opening file for output",
                        "Parent directories could not be created along path: " + destination);
            }
            final_as_destination = new BufferedWriter(new FileWriter(destination));
            return final_as_destination;
        }
    }

    public BufferedWriter TransitionModelDestination() throws IOException {
        String destination = settings.get(TM_DESTINATION);
        if (destination == null)
            return null;
        switch (destination) {
        case STD_ERR:
            return new BufferedWriter(new OutputStreamWriter(System.err)); // send to console error
        case STD_OUT:
            return new BufferedWriter(new OutputStreamWriter(System.out));
        default:
            // ensure parent directories exist
            try {
                new File(new File(destination).getParent()).mkdirs();
            } catch (Exception ex) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Opening file for output.",
                        "Parent directories could not be created along path: " + destination);
            }
            tm_destination = new BufferedWriter(new FileWriter(destination));
            return tm_destination;
        }
    }

    public void processCommandlineArgs(String[] args) {
        boolean sourceset = false;

        if (args.length < 1)
            printUsageAndExit();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
            case CL_H:
            case CL_HELP:
                printUsageAndExit();
            case CL_SP:
            case CL_SPARC:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(SPARC_LOCATION, args[i]);
                break;
            case CL_J:
            case CL_JAVA:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(JAVA_LOCATION, args[i]);
                break;
            case CL_SO:
            case CL_SOLVER:
                i++;
                i++;
                if (i >= args.length || isCLCommand(args[i - 1]) || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 2]);
                File f = new File(args[i - 1]);
                // System.out.println(f.getParent());
                if (f.isDirectory() || !f.exists()) {
                    printUsageAndExitWithError("Clingo not found at " + args[i - 1]);
                }
                settings.put(SOLVER_LOCATION, f.getParent());
                settings.put(SOLVER_TYPE, args[i].toLowerCase());
                break;
            case CL_PM:
            case CL_PREMODEL:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(PM_DESTINATION, args[i]);
                break;
            case CL_PAS:
            case CL_PREMODEL_ANSWERSET:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(PREMODEL_AS_DESTINATION, args[i]);
                break;
            case CL_FAS:
            case CL_FINAL_ANSWERSET:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(FINAL_AS_DESTINATION, args[i]);
                break;
            case CL_TM:
            case CL_TRANSITIONMODEL:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(TM_DESTINATION, args[i]);
                break;
            case CL_ER:
            case CL_ERRORS:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(ER_DESTINATION, args[i]);
                break;
            case CL_ST:
            case CL_SYMBOLTABLE:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(ST_DESTINATION, args[i]);
                break;
            case CL_ASPF:
            case CL_INTERMEDIATEASPF:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(ASPF_DESTINATION, args[i]);
                break;
            case CL_SD:
            case CL_SYSTEMDESCRIPTION:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(SYS_DESC_SOURCE, args[i]);
                break;
            case CL_D:
            case CL_DEBUG:
                debugSettings();
                break;
            case CL_C:
            case CL_CONFIG:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                processConfigFile(args[i], null, null);
                break;
            case CL_OPT:
            case CL_OPTIMIZATION:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                String optimizationname = args[i].toUpperCase().trim();
                switch (optimizationname) {
                case OPT_ALL_PM_FACTS:
                    break;
                default:
                    printUsageAndExitWithError("unrecognized optimization " + args[i]);
                }
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 2]);
                String setting = args[i].toLowerCase().trim();
                switch (setting) {
                case ON:
                case OFF:
                    break;
                default:
                    printUsageAndExitWithError(
                            "Optimization setting must be either 'on' or 'off', and not '" + args[i] + "'");
                }
                settings.put(optimizationname, setting);
                break;
            case CL_CC:
            case CL_CREATECONFIG:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing filename following " + args[i - 1]);
                createConfigFile(args[i]);
                System.out.println("Config file created at: " + args[i]);
                System.exit(0);
            case CL_LIB:
            case CL_LIBRARY:
                i++;
                if (i > args.length || isCLCommand(args[i]))
                    printUsageAndExitWithError("Missing value following " + args[i - 1]);
                settings.put(LIBRARY_LOCATION, args[i]);
                break;

            default:
                if (!sourceset) {
                    settings.put(SYS_DESC_SOURCE, args[i]);
                    sourceset = true;
                } else {
                    System.err.println("Too Many Entries Without Flags.");
                    System.err.println("Assumed System Description Source: " + settings.get(SYS_DESC_SOURCE));
                    printUsageAndExitWithError("Unrecognized Commandline Argument: " + args[i]);
                }
            }
        }
    }

    private void TestSettings() {

        TestJava();
        TestSOLVER();
        TestSPARC();

    }

    private void TestJava() {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add(settings.get(JAVA_LOCATION));
        commands.add("-version");
        ProcessBuilder pb_java = new ProcessBuilder(commands);
        try {
            Process java = pb_java.start();
            BufferedReader read = new BufferedReader(new InputStreamReader(java.getErrorStream())); // output from java
            boolean version18found = false;
            String line = null;
            java.waitFor();
            while ((line = read.readLine()) != null) {
                int version = line.indexOf("version", 0);
                if (version > 0) {
                    int ver18 = line.indexOf("1.8.", version);
                    if (ver18 > 0)
                        version18found = true;
                }
            }
            if (!version18found)
                ALMCompiler.IMPLEMENTATION_FAILURE("Testing Java Version",
                        "Java is not version 1.8.*  Location of jre version 1.8.* must be provided.");
        } catch (IOException e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Testing Java Version",
                    "Could not start java executable from filename: " + settings.get(JAVA_LOCATION));
        } catch (InterruptedException e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Testing Java Version",
                    "Java was started but was interrupted, could not get version information.");
        }
    }

    private void TestSOLVER() {
        switch (settings.get(SOLVER_TYPE)) {
        case SOLVER_DLV:
        case SOLVER_CLINGO:
            break;
        default:
            ALMCompiler.IMPLEMENTATION_FAILURE("Testing ASP Solver",
                    "SOLVER_TYPE must be set to one of (clingo | dlv).  (See commandline option --help)");
        }
        String solver = settings.get(SOLVER_TYPE);
        String solver_path = settings.get(SOLVER_LOCATION);
        String qualified_prog = solver_path + File.separator + solver;
        ArrayList<String> commands = new ArrayList<String>();
        commands.add(qualified_prog);
        commands.add("-v");
        ProcessBuilder pb_solver = new ProcessBuilder(commands);
        String existing_path = pb_solver.environment().get("PATH");
        String new_path = solver_path + File.pathSeparator + existing_path;
        if (solver_path != null && solver_path.length() > 0)
            pb_solver.environment().put("PATH", new_path);
        try {
            Process solver_proc = pb_solver.start();
            solver_proc.waitFor();
        } catch (IOException e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Testing Solver " + solver,
                    "Could not start solver from location: " + settings.get(SOLVER_LOCATION));
        } catch (InterruptedException e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Testing Solver " + solver, "solver was started but was interrupted.");
        }

    }

    private void TestSPARC() {
        String sparc_loc = settings.get(SPARC_LOCATION);
        ArrayList<String> commands = new ArrayList<String>();
        commands.add(settings.get(JAVA_LOCATION));
        commands.add("-jar");
        commands.add(sparc_loc);
        commands.add("-h");
        ProcessBuilder pb_java = new ProcessBuilder(commands);
        try {
            Process java = pb_java.start();
            BufferedReader read = new BufferedReader(new InputStreamReader(java.getErrorStream())); // output from java
            String line = null;
            java.waitFor();
            while ((line = read.readLine()) != null) {
                if (line.contains("Error"))
                    ALMCompiler.IMPLEMENTATION_FAILURE("Testing SPARC Jar",
                            "Could not start sparc from filename: " + sparc_loc);

            }
        } catch (IOException e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Testing SPARC Jar",
                    "Could not start sparc from filename: " + sparc_loc);
        } catch (InterruptedException e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Testing SPARC Jar", "java was started but was interrupted.");
        }

    }

    private void processConfigFile(String config_file_name, String CD_Replace, String FN_Replace) {
        String line;
        File configfile = new File(config_file_name);
        if (CD_Replace == null)
            CD_Replace = configfile.getParentFile().getAbsolutePath();
        try {
            BufferedReader foo = new BufferedReader(new FileReader(configfile));
            try {
                while ((line = foo.readLine()) != null) {
                    line = line.trim();
                    if (line.length() == 0 || line.charAt(0) == '#')
                        continue;
                    int pos = line.indexOf(':');
                    if (pos > 0) {
                        String key = line.substring(0, pos).toUpperCase().trim();
                        String value = line.substring(pos + 1).trim();
                        // process <CD> and <FN> in value
                        int cdPos = value.indexOf("<CD>");
                        if (cdPos >= 0) {
                            value = CD_Replace + File.separator + value.substring(cdPos + 5);
                        }
                        if (FN_Replace != null) {
                            value = value.replaceFirst("<FN>", FN_Replace);
                        }
                        switch (key) {
                        case PREMODEL_AS_DESTINATION:
                        case FINAL_AS_DESTINATION:
                        case ASPF_DESTINATION:
                        case TM_DESTINATION:
                        case ER_DESTINATION:
                        case ST_DESTINATION:
                        case TP_DESTINATION:
                        case PM_DESTINATION:
                        case SYS_DESC_SOURCE:
                        case IMPORT_CONFIG:
                        case LIBRARY_LOCATION:
                            value = (new File(value)).getCanonicalPath();

                        }
                        if (key.compareTo(SYS_DESC_SOURCE) == 0) {
                            int lastslash = value.lastIndexOf(File.separator);
                            int firstdot = value.indexOf('.', lastslash);
                            if (firstdot == -1) {
                                FN_Replace = value.substring(lastslash + 1);
                            } else {
                                FN_Replace = value.substring(lastslash + 1, firstdot);
                            }
                        } else if (key.compareTo(IMPORT_CONFIG) == 0) {
                            processConfigFile(value, CD_Replace, FN_Replace);
                            continue; // skip recording setting.
                        }
                        settings.put(key, value);
                    }
                }
                foo.close();
            } catch (IOException e) {
                this.printUsageAndExitWithError("Could not read from configuration file:" + config_file_name);
            }
        } catch (FileNotFoundException e) {
            this.printUsageAndExitWithError("Configuration file was not found at path:" + config_file_name);
        }
    }

    private void createConfigFile(String filename) {
        File f = new File(filename);

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            out.write("#ALMCompiler Settings File\n");
            out.write("#Comments Are lines starting with '#' characters.\n");
            out.write("#If there is no uncommented line for a setting, the default behavior is used.  \n");
            out.write("\n");

            out.write("# Path Overrides (Do not uncomment, just FYI) \n");
            out.write(
                    "# <CD> - shorthand for the name of the directory containing the config file setting SYS_DESC_SOURCE.\n");
            out.write(
                    "# <FN> - the name of the file (prior to the first '.') containing the system description (set by SYS_DESC_SOURCE)\n");
            out.write("\n");

            out.write("#IMPORT CONFIG FILE\n");
            out.write("#If commented out, default is to not import any other settings.\n");
            out.write("#The SYS_DESC_SOURCE must be set prior to using <CD> and <FN> in paths.");
            out.write("#IMPORT_CONFIG : <path to config file to import>\n");
            out.write("\n");

            out.write("# SYSTEM SETUP CONFIGURATIONS\n");
            out.write("\n");

            out.write("#setting " + JAVA_LOCATION + "\n");
            out.write("#Java executable for Java version 1.8 or later must be used.\n");
            out.write("#If commented out, default is current working directory or active path.\n");
            out.write("#" + JAVA_LOCATION + " : " + "<path to java executable>\n");
            String current_java_location = settings.get(JAVA_LOCATION);
            if (current_java_location != null)
                out.write(JAVA_LOCATION + " : " + current_java_location + "\n");
            out.write("\n");

            out.write("#setting " + SPARC_LOCATION + "\n");
            out.write("#Location of SPARC's jar file must be provided.\n");
            out.write("#If commented out, default is find it in current working directory or active path.\n");
            out.write("#" + SPARC_LOCATION + " : " + "<path to sparc.jar>\n");
            String current_sparc_location = settings.get(SPARC_LOCATION);
            if (current_sparc_location != null)
                out.write(SPARC_LOCATION + " : " + current_sparc_location + "\n");
            out.write("\n");

            out.write("#setting " + SOLVER_LOCATION + ": \n");
            out.write("#SPARC needs to have access to an ASP solver.\n");
            out.write("#If commented out, default is current working directory or active path.\n");
            out.write("#" + SOLVER_LOCATION + " : " + "<path to asp solver>\n");
            String current_solver_location = settings.get(SOLVER_LOCATION);
            if (current_solver_location != null)
                out.write(SOLVER_LOCATION + " : " + current_solver_location + "\n");
            out.write("\n");

            out.write("#setting " + SOLVER_TYPE + ": (dlv | clingo)\n");
            out.write("#SPARC only recognizes 'dlv' and 'clingo' as names for executables of ASP solvers.\n");
            out.write(
                    "#Executable name of solver on file system will need to be changed to match either dlv or clingo.\n");
            out.write("#If commented out, default is dlv.\n");
            out.write("#" + SOLVER_TYPE + " : " + SOLVER_DLV + "\n");
            out.write("#" + SOLVER_TYPE + " : " + SOLVER_CLINGO + "\n");
            String current_solver_type = settings.get(SOLVER_TYPE);
            if (current_solver_type != null)
                out.write(SOLVER_TYPE + " : " + current_solver_type + "\n");
            out.write("\n");

            out.write("#setting " + LIBRARY_LOCATION + ": <path to library directory>\n");
            out.write("#Give the path to the root directory of where the library directories are located.\n");
            out.write("#The names of the sub-directories of the root directories are names of libraries.\n");
            out.write("#The names of .alm files in the library directory are theory names.\n");
            out.write("#The names of libraries and theories must contain only alphanumeric characters and '_'.\n");
            out.write("#Example path for library directory 'libraries', library 'move', theory 'discrete_movement':\n");
            out.write("#<path to sysdesc>\\libraries\\move\\discrete_movement.alm\n");
            out.write(LIBRARY_LOCATION + " : " + "<CD>/../../libraries");
            out.write("\n");

            out.write("# TRANSLATOR INPUT OUTPUT AND ERROR DESTINATIONS \n");
            out.write("\n");

            out.write("#setting " + SYS_DESC_SOURCE + " : <filename>\n");
            out.write("#Source of the input ALM System Description.\n");
            out.write("#If commented out, default is to read from std_in.\n");
            out.write("#" + SYS_DESC_SOURCE + " : <path to file containing system description>\n");
            out.write("#The following setting also indicates the source as standard in:\n");
            out.write("#" + SYS_DESC_SOURCE + " : " + STD_IN + "\n");
            String current_sys_desc_source = settings.get(SYS_DESC_SOURCE);
            if (current_sys_desc_source != null)
                out.write(SYS_DESC_SOURCE + " : " + current_sys_desc_source + "\n");
            out.write("\n");

            out.write("#setting " + TM_DESTINATION + " : <filename>\n");
            out.write("#Destination for resulting answersets of pre model sparc program.\n");
            out.write("#If commented out, default is not to output the answersets.\n");
            out.write("#uncomment the following to send to standard out. \n");
            out.write("#" + TM_DESTINATION + " : " + STD_OUT + "\n");
            out.write("#uncomment the following to send to standard err. \n");
            out.write("#" + TM_DESTINATION + " : " + STD_ERR + "\n");
            String current_tm_dest = settings.get(TM_DESTINATION);
            if (current_tm_dest != null)
                out.write(TM_DESTINATION + " : " + current_tm_dest + "\n");
            out.write("\n");

            out.write("#setting " + ER_DESTINATION + " : <filename>\n");
            out.write("#Destination for syntax and semantic errors.\n");
            out.write("#If commented out, default is output to standard err.\n");
            out.write("#Even when there are no errors, the version will always be output on the first line.\n");
            out.write("#uncomment the following to send to standard out. \n");
            out.write("#" + ER_DESTINATION + " : " + STD_OUT + "\n");
            out.write("#uncomment the following to send to standard err. \n");
            out.write("#" + ER_DESTINATION + " : " + STD_ERR + "\n");
            String current_er_dest = settings.get(ER_DESTINATION);
            if (current_er_dest != null)
                out.write(ER_DESTINATION + " : " + current_er_dest + "\n");
            out.write("\n");

            out.write("# OPTIMIZATION OPTIONS \n");
            out.write("\n");

            out.write("#setting " + OPT_ALL_PM_FACTS + " : (on | off)\n");
            out.write("#Optimization to copy all facts from pre model answerset to final program.\n");
            out.write("#If commented out, default is to have the optimization turned on.\n");
            out.write("#" + OPT_ALL_PM_FACTS + " : on\n");
            out.write("#" + OPT_ALL_PM_FACTS + " : off\n");
            String current_opt_all_pm_facts = settings.get(OPT_ALL_PM_FACTS);
            if (current_opt_all_pm_facts != null)
                out.write(OPT_ALL_PM_FACTS + " : " + current_opt_all_pm_facts + "\n");
            out.write("\n");

            out.write("# DEBUGGING OPTIONS \n");
            out.write("\n");

            out.write("#setting " + ST_DESTINATION + " : <filename>\n");
            out.write("#Destination file for symbol table dump. (Primarily for debugging purposes)\n");
            out.write("#If commented out, default is not to output symbol table.\n");
            out.write("#uncomment the following to send to standard out. \n");
            out.write("#" + ST_DESTINATION + " : " + STD_OUT + "\n");
            out.write("#uncomment the following to send to standard err. \n");
            out.write("#" + ST_DESTINATION + " : " + STD_ERR + "\n");
            String current_st_dest = settings.get(ST_DESTINATION);
            if (current_st_dest != null)
                out.write(ST_DESTINATION + " : " + current_st_dest + "\n");
            out.write("\n");

            out.write("#setting " + ASPF_DESTINATION + " : <filename>\n");
            out.write(
                    "#Destination file for intermediate ASP{f} representation of axioms and structure. (Primarily for debugging purposes)\n");
            out.write("#If commented out, default is not to output ASP{f} rules.\n");
            out.write("#uncomment the following to send to standard out. \n");
            out.write("#" + ASPF_DESTINATION + " : " + STD_OUT + "\n");
            out.write("#uncomment the following to send to standard err. \n");
            out.write("#" + ASPF_DESTINATION + " : " + STD_ERR + "\n");
            String current_aspf_dest = settings.get(ASPF_DESTINATION);
            if (current_aspf_dest != null)
                out.write(ASPF_DESTINATION + " : " + current_aspf_dest + "\n");
            out.write("\n");

            out.write("#setting " + PM_DESTINATION + " : <filename>\n");
            out.write("#Destination for pre model sparc program.\n");
            out.write(
                    "#If commented out, default is not to output the program to the user, merely send it to SPARC.\n");
            out.write("#uncomment the following to send to standard out. \n");
            out.write("#" + PM_DESTINATION + " : " + STD_OUT + "\n");
            out.write("#uncomment the following to send to standard err. \n");
            out.write("#" + PM_DESTINATION + " : " + STD_ERR + "\n");
            String current_pm_dest = settings.get(PM_DESTINATION);
            if (current_pm_dest != null)
                out.write(PM_DESTINATION + " : " + current_pm_dest + "\n");
            out.write("\n");

            out.write("#setting " + PREMODEL_AS_DESTINATION + " : <filename>\n");
            out.write("#Destination for pre-model answersets of pre-model sparc program.\n");
            out.write("#If commented out, default is not to output the answersets.\n");
            out.write("#uncomment the following to send to standard out. \n");
            out.write("#" + PREMODEL_AS_DESTINATION + " : " + STD_OUT + "\n");
            out.write("#uncomment the following to send to standard err. \n");
            out.write("#" + PREMODEL_AS_DESTINATION + " : " + STD_ERR + "\n");
            String current_premodel_as_dest = settings.get(PREMODEL_AS_DESTINATION);
            if (current_premodel_as_dest != null)
                out.write(PREMODEL_AS_DESTINATION + " : " + current_premodel_as_dest + "\n");
            out.write("\n");

            out.write("#setting " + FINAL_AS_DESTINATION + " : <filename>\n");
            out.write("#Destination for the answersets resulting from the application of the TM sparc program.\n");
            out.write("#If commented out, the default destination is standard output.\n");
            out.write("#uncomment the following to send to standard out. \n");
            out.write("#" + FINAL_AS_DESTINATION + " : " + STD_OUT + "\n");
            out.write("#uncomment the following to send to standard err. \n");
            out.write("#" + FINAL_AS_DESTINATION + " : " + STD_ERR + "\n");
            String current_final_as_dest = settings.get(FINAL_AS_DESTINATION);
            if (current_final_as_dest != null)
                out.write(PREMODEL_AS_DESTINATION + " : " + current_final_as_dest + "\n");
            out.write("\n");

            out.flush();
            out.close();

        } catch (FileNotFoundException e) {
            System.err.println("Could not write configuration to file: " + filename);
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Could not write configuration to file: " + filename);
            System.exit(-1);
        }
    }

    private void printUsageAndExitWithError(String string) {
        System.err.println(string);
        printUsage();
        System.exit(-1);

    }

    private boolean isCLCommand(String string) {
        switch (string) {
        case CL_H:
        case CL_HELP:
        case CL_SP:
        case CL_SPARC:
        case CL_J:
        case CL_JAVA:
        case CL_SO:
        case CL_SOLVER:
        case CL_PM:
        case CL_PREMODEL:
        case CL_PAS:
        case CL_PREMODEL_ANSWERSET:
        case CL_FAS:
        case CL_FINAL_ANSWERSET:
        case CL_TM:
        case CL_TRANSITIONMODEL:
        case CL_ER:
        case CL_ERRORS:
        case CL_ST:
        case CL_SYMBOLTABLE:
        case CL_ASPF:
        case CL_INTERMEDIATEASPF:
        case CL_SD:
        case CL_SYSTEMDESCRIPTION:
        case CL_D:
        case CL_DEBUG:
        case CL_C:
        case CL_CONFIG:
        case CL_CC:
        case CL_CREATECONFIG:
        case CL_OPT:
        case CL_OPTIMIZATION:
        case CL_LIB:
        case CL_LIBRARY:
            return true;
        default:
            return false;
        }
    }

    private void printUsageAndExit() {
        printUsage();
        System.exit(0);
    }

    public Reader SystemDescriptionReader() throws FileNotFoundException {
        String filename = settings.get(SYS_DESC_SOURCE);
        if (filename == null || filename.compareTo(STD_IN) == 0)
            return new BufferedReader(new InputStreamReader(System.in));
        else
            return new BufferedReader(new FileReader(new File(filename)));
    }

    public String getSystemDescriptionFileName() {
        return settings.get(SYS_DESC_SOURCE);
    }

    public void closeIntermediateASPfDestination() throws IOException {
        if (aspf_destination != null) {
            aspf_destination.close();
            aspf_destination = null;
        }
    }

    public void closeSymbolTableDestination() throws IOException {
        if (st_destination != null) {
            st_destination.close();
            st_destination = null;
        }
    }

    public void closeErrorDestination() throws IOException {
        if (er_destination != null) {
            er_destination.close();
            er_destination = null;
        }
    }

    public void closePreModelDestination() throws IOException {
        if (pm_destination != null) {
            pm_destination.close();
            pm_destination = null;
        }
    }

    public void closePremodelAnswerSetsDestination() throws IOException {
        if (premodel_as_destination != null) {
            premodel_as_destination.close();
            premodel_as_destination = null;
        }
    }

    public void closeFinalAnswerSetsDestination() throws IOException {
        if (final_as_destination != null) {
            final_as_destination.close();
            final_as_destination = null;
        }
    }

    public void closeTransitionModelDestination() throws IOException {
        if (tm_destination != null) {
            tm_destination.close();
            tm_destination = null;
        }
    }

    public String getSPARCLocation() {
        return settings.get(SPARC_LOCATION);
    }

    public String getJavaLocation() {
        return settings.get(JAVA_LOCATION);
    }

    public String getSolverType() {
        String solvertype = settings.get(SOLVER_TYPE);
        if (solvertype == null)
            return "";
        else
            return solvertype;
    }

    public String getSolverLocation() {
        return settings.get(SOLVER_LOCATION);
    }

    public boolean OptimizationAddAllFactsFromPreModelAnswerset() {
        return settings.get(OPT_ALL_PM_FACTS).compareTo(ON) == 0;
    }

    public String getLibraryEntryFileName(String libraryName, String theoryName) {
        String library_location = settings.get(LIBRARY_LOCATION);
        if (library_location == null) {
            return null;
        }
        if (libraryName == null || libraryName.trim().length() == 0) {
            return null;
        }
        if (theoryName == null || theoryName.trim().length() == 0) {
            return null;
        }
        return library_location + File.separator + libraryName + File.separator + theoryName + ".alm";
    }

}
