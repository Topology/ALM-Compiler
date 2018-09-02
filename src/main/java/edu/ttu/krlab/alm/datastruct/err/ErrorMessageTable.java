package edu.ttu.krlab.alm.datastruct.err;

import java.util.HashMap;
import java.util.Map;

public abstract class ErrorMessageTable {

    private static boolean initialized = false;

    static Map<String, ErrorMetaData> errorMetaData = null;

    public static ErrorMetaData getMetaData(String errorid) {
        if (initialized == false) {
            initialize();
        }
        return errorMetaData.get(errorid);
    }

    public static String getMessage(String errorid) {
        if (initialized == false) {
            initialize();
        }
        return errorMetaData.get(errorid).getMessage();
    }

    public static String getExplanation(String errorid) {
        if (initialized == false) {
            initialize();
        }
        return errorMetaData.get(errorid).getExplanation();
    }

    public static String getRecommendations(String errorid) {
        if (initialized == false) {
            initialize();
        }
        return errorMetaData.get(errorid).getRecommendation();
    }

    private static void initialize() {

        errorMetaData = new HashMap<String, ErrorMetaData>();
        initialized = true;

        // SRT001
        ErrorMetaDataBase srt001 = new ErrorMetaDataBase(SemanticError.SRT001,
                "Predefined sort [1] cannot appear on right hand side of the '::' token in sort specifications.",
                "Predefined sorts have a fixed interpretation which cannot be extended through specification in the sort-hierarchy.",
                "Remove the predefined sort from the sort specification.  If you are intending to populate the sort on the left hand side of the '::' token with the values in the predefined sort, you must do so through specifying sort instances in the structure.  ");
        errorMetaData.put(SemanticError.SRT001, srt001);

        // SRT002
        ErrorMetaDataBase srt002 = new ErrorMetaDataBase(SemanticError.SRT002,
                "Sort [1] on the right hand side of the '::' token must occur on the left hand side of the '::' token in an earlier sort declaration. ",
                "The sort hierarchy is a directed acyclic graph where every sort is a sub-sort of the universe.  If the parent of a user defined sort is not the universe and does not have its own parent in the hierarchy, then neither the user defined sort or its parent are a subsort of the universe. ",
                "Add or move a sort specification for the parent sort earlier in the sort declarations.");
        errorMetaData.put(SemanticError.SRT002, srt002);

        // SRT003
        ErrorMetaDataBase srt003 = new ErrorMetaDataBase(SemanticError.SRT003,
                "Sort [1] In the attribute declaration is not declared in the sort hierarchy.  ",
                "Every sort name must be declared in the hierarchy before use.  ",
                "Either create the missing sort declaration prior to the use of the sort name or move an existing sort declaration for the sort name prior to the current use.");
        errorMetaData.put(SemanticError.SRT003, srt003);

        // SRT004
        ErrorMetaDataBase srt004 = new ErrorMetaDataBase(SemanticError.SRT004,
                "Sort [1] cannot be a sub-sort of itself [2], violating the  DAG property. ",
                "The sort hierarchy is a directed acyclic graph.",
                "Refactor the structure of the sort hierarchy and eliminate the cycle.");
        errorMetaData.put(SemanticError.SRT004, srt004);

        // SRT005
        ErrorMetaDataBase srt005 = new ErrorMetaDataBase(SemanticError.SRT005,
                "Sort [1] has already been specified [2]",
                "This is a design decision for the first implementation of the ALM Translator.  This ensures that only one sort specification needs to be reference when reporting semantic errors with sorts.",
                "If you would like to indicate that a sort occurs as a child to multiple parent sorts, create a separate sort specification for detailing all the parent-child relationships at once. ");
        errorMetaData.put(SemanticError.SRT005, srt005);

        // ATF001
        ErrorMetaDataBase atf001 = new ErrorMetaDataBase(SemanticError.ATF001,
                "Attribute function [1] has not been declared as an attribute for sort [2]",
                "When used the first argument of the attribute function is the sort to which the attribute function belongs.  When defining the attribute function in the structure it must first have been declared in the sort declaration section.",
                "Either add the declaration of the attribute function to the specification of the sort, or change the sort for which the attribute function is being defined.");
        errorMetaData.put(SemanticError.ATF001, atf001);

        // ATF002
        ErrorMetaDataBase atf002 = new ErrorMetaDataBase(SemanticError.ATF002,
                "The signature of attribute function [1] references a sort [2] which has not been declared",
                "All sorts used in the signature of an attribute function must be previously declared in the sort hierarchy.",
                "If the missing sort declaration exists later in the document, move the sort declaration which contains the attribute to a position after the missing sort or add a new sort declaration for the missing sort prior to this sort declaration.");
        errorMetaData.put(SemanticError.ATF002, atf002);

        // ATF003
        ErrorMetaDataBase atf003 = new ErrorMetaDataBase(SemanticError.ATF003,
                "Attribute function [1] has already been defined  [2]",
                "All functions must have unique signatures.  A function signature is a combination of the name of the function and the sequence of sorts for its domain followed by the range sort. Note: The signature of an attribute function declaration is not complete.  The complete signature includes the sort to which the attribute function belongs as the first sort in the sequence of domain sorts.",
                "If the pre-existing function declaration has the correct signature, either change the name of the attribute function being declared or change its domain or range sorts.");
        errorMetaData.put(SemanticError.ATF003, atf003);

        // ATF004
        ErrorMetaDataBase atf004 = new ErrorMetaDataBase(SemanticError.ATF004,
                "Attribute function [1] has the same name and number of arguments as a previously defined attribute function [2].",
                "All functions are uniquely identified by function name and number of arguments. There can be at most one function declaration per function name and number of arguments.",
                "Either change the attribute name for one of the sorts or declare a common ancestor sort and define the function as an attribute of that sort.");
        errorMetaData.put(SemanticError.ATF004, atf004);

        // CND001
        ErrorMetaDataBase cnd001 = new ErrorMetaDataBase(SemanticError.CND001,
                "Object Constant [1] cannot be declared for sort [2] since it is has a subsort [3] and is not a source sort.",
                "Object constants can only be declared for source sorts in the sort hierarchy.",
                "Either change the sort to which the object constant is declared  or change the structure of the hierarchy so that the sort is a source sort and has no sub-sorts.");
        errorMetaData.put(SemanticError.CND001, cnd001);

        // CND002
        ErrorMetaDataBase cnd002 = new ErrorMetaDataBase(SemanticError.CND002,
                "Object Constant parameter [1] is not a source sort in the hierarchy since it has sub-sort [2]",
                "Only source sorts can be parameters of object constants",
                "Either change the name of the parameter to an existing source sort or change the declaration of the sort hierarchy so that the sort has no sub-sorts.");
        errorMetaData.put(SemanticError.CND002, cnd002);

        // CND003
        ErrorMetaDataBase cnd003 = new ErrorMetaDataBase(SemanticError.CND003,
                "Sort [1] has not been declared in the sort hierarchy and cannot have object constants declared for it.",
                "Object constants can only be declared for source sorts in the sort hierarchy.",
                "Create the missing declaration for the sort in the hierarchy, or change the name of the sort to one that has been declared already.");
        errorMetaData.put(SemanticError.CND003, cnd003);

        // CND004
        ErrorMetaDataBase cnd004 = new ErrorMetaDataBase(SemanticError.CND004,
                "Object Constant parameter [1] has not been declared as a source sort in the sort hierarchy.",
                "Only names of source sorts in the sort hierarchy can be parameters of object constants.",
                "Either change the name of the parameter to an existing source sort or create the declaration for the sort in the sort hierarchy.");
        errorMetaData.put(SemanticError.CND004, cnd004);

        // CND005
        ErrorMetaDataBase cnd005 = new ErrorMetaDataBase(SemanticError.CND005,
                "Object Constant [1] has already been declared [2].", "Constants can only be declared once per sort. ",
                "Remove the duplicate object constant declaration.");
        errorMetaData.put(SemanticError.CND005, cnd005);

        // CND006
        ErrorMetaDataBase cnd006 = new ErrorMetaDataBase(SemanticError.CND006,
                "Object Constant [1] has the same name and argument structure as function [2].",
                "There is an ambiguity between the constant usage and the function usage if they have the same name and the same argument signature.",
                "Remove either the constant declaration or the function declaration.");
        errorMetaData.put(SemanticError.CND006, cnd006);

        //CND007
        ErrorMetaDataBase cnd007 = new ErrorMetaDataBase(SemanticError.CND007,
                "Ambiguous Constant term [1] matches more than one constant declaration: [2] and [3].",
                "Ambiguous constant terms are not supported in this version of ALM.",
                "Add instance(X,sort) declarations to disambiguate the usage of the constant or remove one of the constant declarations.");
        errorMetaData.put(SemanticError.CND007, cnd007);

        //CND008
        ErrorMetaDataBase cnd008 = new ErrorMetaDataBase(SemanticError.CND008,
                "Term  [1] has not been declared as a function term or a constant for any sort.",
                "Non pre-defined and non-variable terms must be declared before they are used.",
                "Either add a function definition or a constant definition for the term, or replace it with a declared term.");
        errorMetaData.put(SemanticError.CND008, cnd008);

        // FND001
        ErrorMetaDataBase fnd001 = new ErrorMetaDataBase(SemanticError.FND001,
                "Defined function [1] must be a boolean function.",
                "Defined functions must be boolean functions and are automatically considered total.",
                "There are two options.  Either change the function declaration (and its later definition) to be boolean, or move the function declaration to the appropriate basic function declaration section.");
        errorMetaData.put(SemanticError.FND001, fnd001);
        // PER ERROR ID = new ErrorMetaDataBase("errorid", "message", "explanation",
        // "recommendation");
        // errorMetaData.put("errorid", emd);

        // FND002
        ErrorMetaDataBase fnd002 = new ErrorMetaDataBase(SemanticError.FND002,
                "Sort [1] in the function declaration has not been declared.",
                "All sorts in a function declaration must be either declared in the hierarchy or be special sorts.",
                "There are two options.  Either change the sort used in the function declaration, or add a new sort declaration for the sort.");
        errorMetaData.put(SemanticError.FND002, fnd002);

        // FND003
        ErrorMetaDataBase fnd003 = new ErrorMetaDataBase(SemanticError.FND003,
                "Function [1] has not been declared prior to use.", "All functions must be declared prior to use.",
                "Either create a function declaration for the function to change it to the correct function name.");
        errorMetaData.put(SemanticError.FND003, fnd003);

        // FND004
        ErrorMetaDataBase fnd004 = new ErrorMetaDataBase(SemanticError.FND004,
                "Domain function [1] cannot occur in the head of axioms.",
                "The positive occurrence of a domain function on a set of arguments is determined by the function being defined on those arguments. ",
                "Remove the axiom or have the axiom define the function instead.");
        errorMetaData.put(SemanticError.FND004, fnd004);

        // FND005
        ErrorMetaDataBase fnd005 = new ErrorMetaDataBase(SemanticError.FND005,
                "The negation of domain function [1] can only occur in dynamic causal laws.",
                "Only dynamic causal laws can cause a function to become undefined.",
                "Remove the axiom or create the axiom in the dynamic causal law section.");
        errorMetaData.put(SemanticError.FND005, fnd005);

        // FND006
        ErrorMetaDataBase fnd006 = new ErrorMetaDataBase(SemanticError.FND006,
                "In the dom_f function [1], the name of the function has not been declared as either an attribute or in the function declaration section.",
                "The function f must be declared before its domain function dom_f can be referenced or used.",
                "Add the declaration of the function to the function declaration section, or change the name of the function f in the dom_f function.");
        errorMetaData.put(SemanticError.FND006, fnd006);

        // FND007
        ErrorMetaDataBase fnd007 = new ErrorMetaDataBase(SemanticError.FND007,
                "In the dom_f function [1], the the number and sort of arguments to the function do not match the declaration of function f [2].",
                "The argument structure of the dom_f function must match the function f.",
                "Either correct the argument structure for the dom_f function or alter the declaration of the f function to match.");
        errorMetaData.put(SemanticError.FND007, fnd007);

        // FND008
        ErrorMetaDataBase fnd008 = new ErrorMetaDataBase(SemanticError.FND008,
                "Function Declaration [1] has the same signature as another function [2].",
                "Function signatures must be unique across the whole system description.   The function signature is the combination of the function name, sequence of domain sorts, and the range sort.",
                "If the previous function declaration is correct, then either change the name of the current function, or change its domain sorts, or change its range sort to achieve a unique signature.  Otherwise change the previous function declaration appropriately.");
        errorMetaData.put(SemanticError.FND008, fnd008);

        //FND009
        ErrorMetaDataBase fnd009 = new ErrorMetaDataBase(SemanticError.FND009,
                "Function usage [1] is ambiguous and matches more than one function declaration: [2] and [3].",
                "Ambiguous function usage is not supported in this version of ALM.",
                "Either add instance(X,sort) literals to disambiguate the arguments signature or remove one of the function declarations.");
        errorMetaData.put(SemanticError.FND009, fnd009);

        // AXM001
        ErrorMetaDataBase axm001 = new ErrorMetaDataBase(SemanticError.AXM001,
                "Variable [1] does not have an associated sort.",
                "All variables must have a sort which can be determined through sort inference.",
                "Either the variable must occur within a function's arguments, be set to equal a function's range or be related to another variable whose sort can be determined through sort inference.");
        errorMetaData.put(SemanticError.AXM001, axm001);

        // AXM002
        ErrorMetaDataBase axm002 = new ErrorMetaDataBase(SemanticError.AXM002,
                "Object constant [1] must be declared in a module in the theory before use.",
                "Object constants used in axioms must be declared in the theory.",
                "Add a declaration for the object constant with the appropriate source sort to a module in the theory.");
        errorMetaData.put(SemanticError.AXM002, axm002);

        // AXM003
        ErrorMetaDataBase axm003 = new ErrorMetaDataBase(SemanticError.AXM003,
                "Function [1] must be a user defined function to occur in the head of an axiom.",
                "Only user defined functions can occur in the heads of axioms.", "Remove the axiom.");
        errorMetaData.put(SemanticError.AXM003, axm003);

        // AXM004
        ErrorMetaDataBase axm004 = new ErrorMetaDataBase(SemanticError.AXM004,
                "Function [1]  must be a basic function to occur in the head of a state constraint.",
                "Only basic functions can occur in the head of state constraints. Defined functions are defined in the definitions section.",
                "Either change the declaration of the function to be a basic, or remove the axiom, or move the axiom to the definitions section.");
        errorMetaData.put(SemanticError.AXM004, axm004);

        // AXM005
        ErrorMetaDataBase axm005 = new ErrorMetaDataBase(SemanticError.AXM005,
                "Function [1]  must be a basic fluent to occur in the head of a dynamic causal law.",
                "Only basic fluents can occur in the head of dynamic causal laws.",
                "Either change the declaration of the function to be a basic fluent, or remove the axiom.");
        errorMetaData.put(SemanticError.AXM005, axm005);

        // AXM006
        ErrorMetaDataBase axm006 = new ErrorMetaDataBase(SemanticError.AXM006,
                "Fluent function [1] cannot occur in the body of a definition where the function in the head is static.",
                "The value of static functions can only be determined by other static functions.",
                "Either remove the axiom or change it to meet the requirement.");
        errorMetaData.put(SemanticError.AXM006, axm006);

        // AXM007
        ErrorMetaDataBase axm007 = new ErrorMetaDataBase(SemanticError.AXM007,
                "Variable  [1] has a sort mismatch between  sort [2] and sort [3]",
                "If a variable is inferred to have multiple sorts within a statement, the intersection between the sorts must be non-empty.  (one of the sorts must be a descendant of the other in the hierarchy.",
                "Check the sorts of for the variable and the sorts of other variables in the statement to make sure they are correct.  Consider adding or altering the 'Instance(X,Y)' literal to indicate variable X is of sort Y.");
        errorMetaData.put(SemanticError.AXM007, axm007);

        // AXM008
        ErrorMetaDataBase axm008 = new ErrorMetaDataBase(SemanticError.AXM008,
                "Function [1]  must be a defined function to occur in the head of a definition axiom.",
                "The head of defined axioms must be defined functions.",
                "Either change the declaration of the function to defined, or remove the axiom.");
        errorMetaData.put(SemanticError.AXM008, axm008);

        // AXM009
        ErrorMetaDataBase axm009 = new ErrorMetaDataBase(SemanticError.AXM009,
                "For state constraint with function [1] in the head, the right hand side of the '=' [2] is not a variable and not an object constant belonging to the range sort [3] of the function.",
                "The entity on the right hand side of the '=' in the head of a state constraint must be either a variable or an object constant declared to be in the range sort of the function on the left hand side of '='",
                "Either change the right hand side to a variable, or declare the appropriate object constant in the range sort of the function.");
        errorMetaData.put(SemanticError.AXM009, axm009);

        // AXM010
        ErrorMetaDataBase axm010 = new ErrorMetaDataBase(SemanticError.AXM010,
                "For a dynamic causal law, the variable or constant in the occurs atom [1] must be the same  as in the instance atom [2].",
                "In a dynamic causal law, the first instance atom indicates the sort for the action in the occurs atom at the head of the law.",
                "Change either the variable in the occurs atom or in the first instance atom so that they are the same variable in both atoms.");
        errorMetaData.put(SemanticError.AXM010, axm010);

        // AXM011
        ErrorMetaDataBase axm011 = new ErrorMetaDataBase(SemanticError.AXM011,
                "For a dynamic causal law, the sort [1] in the occurs function [2] and located in the first instance function [3],  must be a subsort of the actions sort.",
                "In a dynamic causal law, the sort in the first instance atom indicates the subsort for the action in the occurs atom at the head of the law.",
                "Change either the sort used in the first instance atom or change the sort declaration to be a subsort of actions.");
        errorMetaData.put(SemanticError.AXM011, axm011);

        //AXM012
        ErrorMetaDataBase axm012 = new ErrorMetaDataBase(SemanticError.AXM012,
                "For dynamic causal law [1], the instance atom is either missing or malformed after the 'if'. ",
                "An instance(X,sort) atom is required to occur immediately after the 'if' where the sort is a subsort of actions.",
                "Add or fix the instance atom.");
        errorMetaData.put(SemanticError.AXM011, axm011);

        // SPF001
        ErrorMetaDataBase spf001 = new ErrorMetaDataBase(SemanticError.SPF001,
                "In instance(X,Y) function [1], the second argument is not a declared sort.",
                "The instance function takes an object constant or variable for its first argument and the name of a sort for its second argument.",
                "Either change the second argument to be a sort or add the specification of the sort to the sort declaration section.");
        errorMetaData.put(SemanticError.SPF001, spf001);

        // SPF002 -- SUBSUMED BY CND008
        ErrorMetaDataBase spf002 = new ErrorMetaDataBase(SemanticError.SPF002,
                "In instance(X,Y) function [1], the first argument is not an object constant or variable.",
                "The instance function takes an object constant or variable for its first argument and the name of a sort for its second argument.",
                "Either change the first argument to an object constant or variable, or remove the literal.");
        errorMetaData.put(SemanticError.SPF002, spf002);

        // SPF003
        ErrorMetaDataBase spf003 = new ErrorMetaDataBase(SemanticError.SPF003,
                "In link(X,Y) function [1], the first and second arguments must be names of sorts declared in the sort declaration section.",
                "The link function indicates a parent-child relationship between two sorts in the sort hierarchy.",
                "Change the arguments to be names of sorts which have been declared in the sort declaration section.");
        errorMetaData.put(SemanticError.SPF003, spf003);

        // SPF004  -- SUBSUMED BY CND008
        ErrorMetaDataBase spf004 = new ErrorMetaDataBase(SemanticError.SPF004,
                "In is_a(X,Y) function [1], the first argument must be an object constant or variable.",
                "The is_a(X,Y) function indicates that object X is an instance of sort Y.",
                "Change the first argument to be a variable or object constant.");
        errorMetaData.put(SemanticError.SPF004, spf004);

        // SPF005
        ErrorMetaDataBase spf005 = new ErrorMetaDataBase(SemanticError.SPF005,
                "In is_a(X,Y) function [1], the second arguments must be the name for a source sort declared in the sort declaration section.",
                "The is_a function indicates that the narrows sort for object X is sort Y.",
                "Either refactor the sort hierarchy to ensure the second argument is a source sort, or change the sort name of the second argument to be a source sort.");
        errorMetaData.put(SemanticError.SPF005, spf005);

        // SPF006
        ErrorMetaDataBase spf006 = new ErrorMetaDataBase(SemanticError.SPF006,
                "In subsort(X,Y) function [1], the first and second arguments must be names of sorts declared in the sort declaration section.",
                "The subsort function indicates a descendant-ancestor relationship between two sorts in the sort hierarchy.",
                "Change the arguments to be names of sorts which have been declared in the sort declaration section.");
        errorMetaData.put(SemanticError.SPF006, spf006);

        // SPF007
        ErrorMetaDataBase spf007 = new ErrorMetaDataBase(SemanticError.SPF007,
                "In has_child(X) function [1], the argument must be the name of a sort declared in the sort declaration section.",
                "The has_child function indicates when a sort in the hierarchy has a child sort.",
                "Change the argument to be the name of a sort which has been declared in the sort declaration section.");
        errorMetaData.put(SemanticError.SPF007, spf007);

        // SPF008
        ErrorMetaDataBase spf008 = new ErrorMetaDataBase(SemanticError.SPF008,
                "In has_parent(X) function [1], the argument must be the name of a sort declared in the sort declaration section.",
                "The has_parent function indicates when a sort in the hierarchy has a parent sort.",
                "Change the argument to be the name of a sort which has been declared in the sort declaration section.");
        errorMetaData.put(SemanticError.SPF008, spf008);

        // SPF009
        ErrorMetaDataBase spf009 = new ErrorMetaDataBase(SemanticError.SPF009,
                "In sink(X) function [1], the argument must be the name of a sort declared in the sort declaration section.",
                "The sink function indicates when a sort in the hierarchy has not a parent sort",
                "Change the arguments to be the name of a sort which has been declared in the sort declaration section.");
        errorMetaData.put(SemanticError.SPF009, spf009);

        // SPF010
        ErrorMetaDataBase spf010 = new ErrorMetaDataBase(SemanticError.SPF010,
                "In source(X) function [1], the argument must be the name of a sort declared in the sort declaration section.",
                "The source function indicates when a sort in the hierarchy has not a child sort.",
                "Change the arguments to be the name of a sort which has been declared in the sort declaration section.");
        errorMetaData.put(SemanticError.SPF010, spf010);

        // SPF011
        ErrorMetaDataBase spf011 = new ErrorMetaDataBase(SemanticError.SPF011,
                "In occurs(X) function [1], the argument must be the name of a sort declared in the sort declaration section.",
                " The argument X to occurs(X) must be a sub-sort of the actions sort.",
                "Change the arguments to be the name of a sort which has been declared in the sort declaration section.");

        // SPF012
        ErrorMetaDataBase spf012 = new ErrorMetaDataBase(SemanticError.SPF012,
                "For argument [1] of the occurs function, its declared sort in instance function [2] is not a sub-sort of the actions sort.",
                "Only variables and constants of sorts that are sub-sorts of the actions sort can occur for X in occurs(X).",
                "Either refactor the sort hierarchy to ensure the sort is a sub-sort of actions, or change the sort to be an action sub-sort, or remove the axiom.");
        errorMetaData.put(SemanticError.SPF012, spf012);

        // SPF013
        ErrorMetaDataBase spf013 = new ErrorMetaDataBase(SemanticError.SPF013,
                "The instance function [1] does not have the correct number of arguments.",
                "The first argument must be a variable or term.  The second argument must be the name of a sort.",
                "Change the form of the instance function to match the expected number of arguments.");
        errorMetaData.put(SemanticError.SPF013, spf013);

        // SID001
        ErrorMetaDataBase sid001 = new ErrorMetaDataBase(SemanticError.SID001,
                "Sort [1]  is a predefined sort and cannot have its instances extended.",
                "The interpretation for predefined sorts is fixed and cannot be extended.",
                "Either change the sort for the instances being declared, or remove the instance definition.");
        errorMetaData.put(SemanticError.SID001, sid001);

        // SID002
        ErrorMetaDataBase sid002 = new ErrorMetaDataBase(SemanticError.SID002,
                "Sort [1] is not declared in the sort hierarchy.",
                "Sorts must be declared in the hierarchy before they can be used.",
                "Either add the sort declaration to the sort hierarchy or change the sort name to one that is in the hierarchy.");
        errorMetaData.put(SemanticError.SID002, sid002);

        // SID003
        ErrorMetaDataBase sid003 = new ErrorMetaDataBase(SemanticError.SID003,
                "Sort Instance [1] must either be a variable or a ground function term or a function term whose arguments are either ground function terms or variables.",
                "Sort Instances must be string constants (ground function terms) or schemas for string constants (function terms containing only ground function terms or variables).",
                "Change the sort instance's structure to either be a string constant or a schema.");
        errorMetaData.put(SemanticError.SID003, sid003);

        // SID004
        ErrorMetaDataBase sid004 = new ErrorMetaDataBase(SemanticError.SID004,
                "Attribute Definition [1] must contain only variables as parameters and range values.",
                "Attribute definitions can only take the form of attr(X1,..., Xn) = Y.",
                "Change the attribute definition to only have variables for parameters and range values.");
        errorMetaData.put(SemanticError.SID004, sid004);

        // SID005
        ErrorMetaDataBase sid005 = new ErrorMetaDataBase(SemanticError.SID005,
                "Attribute Definition [1] does not have the correct number of parameters to match the attribute declaration [2].",
                "The number of parameters in the attribute definition must match the number of parameters in the attribute declaration.",
                "Change either the attribute declaration signature or the attribute definition to match the number of arguments for the function.");
        errorMetaData.put(SemanticError.SID005, sid005);

        // SID006
        errorMetaData.put(SemanticError.SID006, new ErrorMetaDataBase(SemanticError.SID006,
                "Instances [1] declared for sorts [2] are defining attribute functions [3].",
                "This version of ALM does not support attribute definitions while defining instances for multiple sorts.",
                "Define the instances for each sort separately in order to define the related sort attributes."));

        // SID007
        errorMetaData.put(SemanticError.SID007, new ErrorMetaDataBase(SemanticError.SID007,
                "Instances [1] failed to parse as a term.",
                "All instances must either be variable or terms.",
                "Change the structure of the instance to allow parsing as a term."));

        // SFD001
        ErrorMetaDataBase sfd001 = new ErrorMetaDataBase(SemanticError.SFD001,
                "The function [1] being defined must be a static function. It's declaration [2] does not match.",
                "Only static functions can be defined in the values of statics section of the structure.",
                "Either move the non-static function definition to the axiom section or change the declaration of the function to be static.");
        errorMetaData.put(SemanticError.SFD001, sfd001);

        // SFD002
        ErrorMetaDataBase sfd002 = new ErrorMetaDataBase(SemanticError.SFD002,
                "Fluet function [1]  cannot occur in the body of the definition of a static function.",
                "The value of static functions do not change over time and cannot have their value determined by the value of fluent functions which can change over time.",
                "Either remove the fluent function from the definition, or remove the definition, or change the defined function to be a fluent and move the definition to the appropriate axiom section.");
        errorMetaData.put(SemanticError.SFD002, sfd002);

        // TYP001
        ErrorMetaDataBase typ001 = new ErrorMetaDataBase(SemanticError.TYP001,
                "The sort of variable [1] cannot be determined.",
                "Every variable must have a sort from which it obtains its possible values.",
                "Consider adding an instance(Var, sort) literal to the body of the rule.");
        errorMetaData.put(SemanticError.TYP001, typ001);

        // TYP002
        ErrorMetaDataBase typ002 = new ErrorMetaDataBase(SemanticError.TYP002,
                "The sorts inferred for variable [1] are not compatible.",
                "Every variable must have a single sort from which it obtains its possible values.",
                "Check that usage of the variable and ensure all usages have a common subsort.");
        errorMetaData.put(SemanticError.TYP002, typ002);

        // TYP003
        ErrorMetaDataBase typ003 = new ErrorMetaDataBase(SemanticError.TYP003,
                "Sort mismatch in expression [1].  Sort [2] was expected but a term of sort [3] occurred.",
                "The occurring term must belong to a subsort of the expected sort.",
                "Determine if the factors that contribute to the expected sort need to change or if the term must change.");
        errorMetaData.put(SemanticError.TYP003, typ003);

        // CDF001
        ErrorMetaDataBase cdf001 = new ErrorMetaDataBase(SemanticError.CDF001,
                "For constant definition [1], the term to the left of '=' does not match any declared constants.",
                "In order to perform constant substitution, a valid constant must be provided.",
                "Either add a new constant declaration in the theory or change the constant definition to match a valid constant.");
        errorMetaData.put(SemanticError.CDF001, cdf001);

        // CDF002
        ErrorMetaDataBase cdf002 = new ErrorMetaDataBase(SemanticError.CDF002,
                "In constant definition [1], the defining term [2] on the right is itself a constant defined by term [3].",
                "Indirect constant definitions are not supported in this version of ALM.",
                "Define the constant directly with its intended final value.");
        errorMetaData.put(SemanticError.CDF002, cdf002);

        // CDF003
        ErrorMetaDataBase cdf003 = new ErrorMetaDataBase(SemanticError.CDF003,
                "In constant definition [1], the term to the left of '=' is not a ground term.",
                "Constant definitions define substitutions on terms.  This version of ALM only supports simple ground constant substitution.",
                "Remove the constant definition or change the definition to be for a simple ground constant.");
        errorMetaData.put(SemanticError.CDF003, cdf003);

        // CDF004
        ErrorMetaDataBase cdf004 = new ErrorMetaDataBase(SemanticError.CDF004,
                "In constant definition [1], the term to the right of '=' is not a ground term.",
                "Constant definitions define substitutions on terms.  This version of ALM only supports substitution with ground terms.",
                "Ensure that the right hand side of the constant definition is a ground term.");
        errorMetaData.put(SemanticError.CDF004, cdf004);

        // CDF005
        ErrorMetaDataBase cdf005 = new ErrorMetaDataBase(SemanticError.CDF005,
                "Duplicate constant definition [1].  The constant is defined elsewhere as [2].",
                "Constants can have at most 1 definition.", "Remove one of the constant definitions.");
        errorMetaData.put(SemanticError.CDF005, cdf005);

        // CDF006
        ErrorMetaDataBase cdf006 = new ErrorMetaDataBase(SemanticError.CDF006,
                "Constant definition [1] is not supported in this version of ALM.",
                "This version of ALM only supports the definition of simple ground constants.",
                "Remove or change the constant definition to be for a simple ground constant.");
        errorMetaData.put(SemanticError.CDF006, cdf006);

        // IMP001
        ErrorMetaDataBase imp001 = new ErrorMetaDataBase(SemanticError.IMP001,
                "Module Dependency [1] resolves with more than one imported theory [2] and [3].",
                "Module dependency must have unique resolutions.",
                "Remove one of the conflicting import statements or prefix the module dependency with the name of the theory it should import from.");
        errorMetaData.put(SemanticError.IMP001, imp001);

        // NAM001
        ErrorMetaDataBase nam001 = new ErrorMetaDataBase(SemanticError.NAM001,
                "Attribute Function [1] cannot have the same name as element [2].",
                "There may be semantic ambiguity through name collision between Herbrand terms (sort instance and constants) and non-Herbrand terms (functions).",
                "Change the name of either the function or instance/constant to avoid name collision.");
        errorMetaData.put(SemanticError.NAM001, nam001);

        // NAM002
        ErrorMetaDataBase nam002 = new ErrorMetaDataBase(SemanticError.NAM002,
                "Constant [1] cannot have the same name as element [2].",
                "There may be semantic ambiguity through name collision between Herbrand terms (sort instance and constants) and non-Herbrand terms (functions).",
                "Change the name of either the function or instance/constant to avoid name collision.");
        errorMetaData.put(SemanticError.NAM002, nam002);

        // NAM003
        ErrorMetaDataBase nam003 = new ErrorMetaDataBase(SemanticError.NAM003,
                "Sort Instance [1] cannot have the same name as element [2].",
                "There may be semantic ambiguity through name collision between Herbrand terms (sort instance and constants) and non-Herbrand terms (functions).",
                "Change the name of either the function or instance/constant to avoid name collision.");
        errorMetaData.put(SemanticError.NAM003, nam003);

        // NAM001
        ErrorMetaDataBase nam004 = new ErrorMetaDataBase(SemanticError.NAM004,
                "Function [1] cannot have the same name as element [2].",
                "There may be semantic ambiguity through name collision between Herbrand terms (sort instance and constants) and non-Herbrand terms (functions).",
                "Change the name of either the function or instance/constant to avoid name collision.");
        errorMetaData.put(SemanticError.NAM004, nam004);

        // PER ERROR ID = new ErrorMetaDataBase("errorid", "message", "explanation",
        // "recommendation");
        // errorMetaData.put("errorid", emd);
    }

}
