/**
 * This Grammar Follows the BNF for ALM as described in Appendix A of "Modular Action Language ALM" 
 * by Daniela Inclezan and Michael Gelfond. 
 * 
 * This document was created by Edward Wertz
 * Date: 7/2/2015
 * Copyright: Texas Tech University
 *  
 */

grammar ALM;

/*
 * Considered bad form, but I've added the package in the header since this code will be generated once
 */
@header {
    package edu.ttu.krlab.alm.parser;
}


/* ABOUT THE GRAMMAR RULES THAT FOLLOW:
 * 1) Lexer Rules and TOKEN names start with capitol letters. 
 * 2) parser rules start with lowercase letters
 * 
 * Parser rules are clustered based on their "rank",
 * "rank" is the maximum distance from lexer tokens in the BNF grammer
 * The top-level rule will be the last rule in the grammar.  
 */

/*
 * LEXER RULES
 */

//ORDER OF RULES IN FILE (TOP TO BOTTOM) matters
//ORDER OF DEFINITIONS (LEFT TO RIGHT) within  NON-TERMINAL and TOKENS matters

WhiteSpace: (' '|'\t'|'\r'|'\n') -> skip; //SKIP WHITESPACE

//EAGERLY CREATE THESE SPECIFIC TOKENS AHEAD OF MORE GENERAL CLASS
MOD: 'mod';
EQ: '=';// Describes <eq>
NEQ: '!='; //Describes <neq>
ARITH_OP: '+' | '-' | '*' | '/' | 'mod' | '^'; //Describes <arithmetic_op>
COMP_REL: '>' | '<' | '<=' | '>='; //Describes <comparison_rel>
RIGHT_ARROW: '->'; //Used in describing Function sorts.
OCCURS: 'occurs'; //prevents the word 'occurs' from being recognized as an identifier
INSTANCE: 'instance'; //prevents the word 'instance' from being recognized as an identifier
IS_A: 'is_a'; //prevents the word 'is_a' from being recognized as an identifier
HAS_CHILD: 'has_child'; //prevents the word 'has_child' from being recognized as an identifier
HAS_PARENT: 'has_parent'; //prevents the word 'has_parent' from being recognized as an identifier
LINK: 'link'; //prevents the word 'link' from being recognized as an identifier
SOURCE: 'source'; //prevents the word 'source' from being recognized as an identifier
SINK: 'sink'; //prevents the word 'sink' from being recognized as an identifier
SUBSORT: 'subsort'; //prevents the word 'subsort' from being recognized as an identifier
DOM: 'DOM';  //prevents the word 'DOM' from being recognized as an identifier
SORT: 'sort';
STATE: 'state';
CONSTRAINTS: 'constraints';
FUNCTION: 'function';
DECLARATIONS: 'declarations';
DEFINITIONS: 'definitions';
SYSTEM: 'system';
DESCRIPTION: 'description';
THEORY: 'theory';
MODULE: 'module';
IMPORT: 'import';
FROM: 'from';
DEPENDS: 'depends';
ON: 'on';
ATTRIBUTES: 'attributes';
OBJECT: 'object';
CONSTANT: 'constant';
STATICS: 'statics';
FLUENTS: 'fluents';
BASIC: 'basic';
DEFINED: 'defined';
TOTAL: 'total';
AXIOMS: 'axioms';
DYNAMIC: 'dynamic';
CAUSAL: 'causal';
LAWS: 'laws';
EXECUTABILITY: 'executability';
CONDITIONS: 'conditions';
CAUSES: 'causes';
IMPOSSIBLE: 'impossible';
IF: 'if';
FALSE: 'false';
TRUE: 'true';
STRUCTURE: 'structure';
IN: 'in';
WHERE: 'where';
VALUE: 'value';
OF: 'of';
INSTANCES: 'instances';
TEMPORAL : 'temporal';
PROJECTION : 'projection';
MAX: 'max';
STEPS: 'steps';
HISTORY : 'history'; 
OBSERVED: 'observed';
HAPPENED: 'happened';

//PREDEFINED SORT NAMES, reserved and cannot be any kind of ID
BOOLEAN: 'booleans';
INTEGERS: 'integers';
UNIVERSE: 'universe';
ACTIONS: 'actions';

// THESE TOKENS ARE MORE GENERAL AND LESS EAGERLY DETERMINED
ID: [a-z]([a-zA-Z0-9_\-])*;  //Describes <identifier> in the ALM BNF, includes <lowercase_letter>, <uppercase_letter>
VAR: [A-Z]([a-zA-Z0-9_\-])*; //Describes <variable> in the ALM BNF.
POSINT: [1-9][0-9]*; //Describes <positive_integer>, includes <non_zero_digit>, <digit>
NEGINT: '-'[1-9][0-9]*;//not explicitly modeled in ALM BNF,  used in 'integer' rule  
ZERO: [0]+; //TOKEN For ZERO, not a non-terminal in ALM BNF, used in 'integer'  rule

/*
 * ALM BNF RULES subsumed by LEXER rules
 * ----------------------------
 * <boolean> -> BOOL
 * <non_zero_digit> -> POSINT and NEGINT 
 * <digit> -> POSINT and NEGINT and ID and VAR
 * <lowercase_letter> -> ID and VAR
 * <uppercase_letter> -> ID and VAR
 * <letter> -> ID and VAR
 * <identifier> -> ID
 * <variable> -> VAR
 * <positive_integer> -> POSINT
 * <integer> -> ZERO and POSINT and NEGINT
 * <arithmetic_op> -> ARITH_OP
 * <comparison_rel> -> COMP_REL
 */

// RECOVER KEYWORDS INTO IDENTIFIER

id : ID | MOD | OCCURS | INSTANCE | IS_A | HAS_CHILD | HAS_PARENT | LINK | SOURCE | SINK | SUBSORT | DOM | SORT 
| STATE | CONSTRAINTS | FUNCTION | DECLARATIONS | DEFINITIONS | SYSTEM | DESCRIPTION | THEORY | MODULE | IMPORT 
| FROM | DEPENDS | ON | ATTRIBUTES | OBJECT | CONSTANT | STATICS | FLUENTS | BASIC | DEFINED | TOTAL | AXIOMS 
| DYNAMIC | CAUSAL | LAWS | EXECUTABILITY | CONDITIONS | CAUSES | IMPOSSIBLE | IF | FALSE | TRUE | STRUCTURE 
| IN | WHERE | VALUE | OF | INSTANCES | TEMPORAL | PROJECTION  | MAX | STEPS | HISTORY  | OBSERVED | HAPPENED 
| BOOLEAN | INTEGERS | UNIVERSE  | ACTIONS;


/*
 * BASIC PARSER RULES BUILT OUT OF SPECIAL LEXER TOKENS
 */

bool : TRUE | FALSE;

nat_num : ZERO | POSINT; //<natural_number>
integer : ZERO | POSINT | NEGINT; //<integer>
relation: EQ | NEQ | COMP_REL; //<arithmetic_rel>

alm_name : id | VAR;

/* TERMS 
 * denote objects which populate sorts
 * integers are terms
 * true and false are terms. 
 * variables are terms. 
 * and f(t1, ..., tn) is a term where all ti are terms and f is an identifier.  
 * 
 * */


object_constant: id ( '(' term (',' term)*   ')')?; //Pattern for any object instance of any sort.
function_term: object_constant;  // the distinction here is that function_terms denote functions even though they have the same syntactic structure as object_constants. 

term: bool | VAR | id | integer | function_term | expression; //terms can appear on either side of EQ operators and denote values of sorts. 

var_or_obj: (object_constant | VAR);
 
/* EXPRESSIONS 
 * An expression is a mathematical entity which denotes an integer.  
 * addition/subtraction
 * multiplication/division/modulus/exponent
 * factors are individual units which participate in the above operations. 
 */
expression: expression '+' arithmetic_term | expression '-' arithmetic_term | arithmetic_term;
arithmetic_term: arithmetic_term '*' factor | arithmetic_term '/' factor | arithmetic_term MOD factor | factor '^' factor | factor;
factor: VAR | '-' VAR  | integer | function_term | '-' function_term | '(' expression ')' | '-' '(' expression ')'; 
// ('-' integer) is not a factor because integer include NEGINT



/* LITERALS */

//These these literals are parsed distinctly so that they may be handled per occurrence.  
occurs_atom: OCCURS '(' var_or_obj ')';
instance_atom: INSTANCE '(' var_or_obj ',' sort_name ')';  
is_a_atom: IS_A '(' var_or_obj ',' sort_name ')'; 
link_atom: LINK '(' sort_name ',' sort_name ')'; 
subsort_atom: SUBSORT '(' sort_name ',' sort_name ')'; 
has_child_atom: HAS_CHILD '(' sort_name ')'; 
has_parent_atom: HAS_PARENT '(' sort_name ')'; 
sink_atom: SINK '(' sort_name ')'; 
source_atom: SOURCE '(' sort_name ')'; 

//Pattern for any atom (positive occurrence of a predicate), including special atoms. 
atom:  instance_atom | is_a_atom | link_atom | subsort_atom | has_child_atom | has_parent_atom | sink_atom | source_atom | function_term ;  
 
literal: atom | '-' atom |  term relation term ;//<literal> not including special literals 

occurs_literal:  occurs_atom | '-' occurs_atom; 


/* ALM SYSTEM DESCRIPTION */
 
library_name: alm_name;     
sys_desc_name: alm_name;
system_description  : SYSTEM DESCRIPTION sys_desc_name theory (structure solver_mode?)?;    //<system_description>

/* ALM THEORY */


theory_name: alm_name; 
theory: (THEORY theory_name sequence_of_modules) | (IMPORT theory_name FROM library_name);//<theory>
 

/* ALM MODULE */

module_name: alm_name;
sequence_of_modules: (module)+;//<set_of_modules><remainder_modules>
module: (MODULE module_name module_body) | (IMPORT theory_name ('.' module_name)? FROM library_name); //<module> 
module_body: module_dependencies? sort_declarations? constant_declarations? function_declarations? axioms?;//<axioms>,<remainder_axioms>


/* ALM MODULE DEPENDENCIES */

module_dependencies: DEPENDS ON one_dependency+;
one_dependency: (theory_name '.')? module_name;

/* ALM SORT DECLARATIONS */

integer_range: '[' integer '..' integer ']';
predefined_sorts: BOOLEAN | INTEGERS | integer_range;
sort_name: predefined_sorts | UNIVERSE | ACTIONS | id;


sort_declarations: SORT DECLARATIONS  (one_sort_decl)+ ;//<sort_declaration><remainder_sort_declaration>
one_sort_decl: id (',' id)* '::' sort_name (',' sort_name)* attributes?;  //<one_sort_decl>,<sort_name>,<remainder_sort_names>,<remainder_sorts>
attributes: ATTRIBUTES (one_attribute_decl)+;//<attributes><remainder_attribute_declarations>
one_attribute_decl: id ':' (sort_name (',' sort_name )* RIGHT_ARROW)? sort_name;//<one_attribue_decl>,<arguments>,<remainder_args>

 
 
/* ALM CONSTANT DECLARATIONS */
  
constant_declarations: CONSTANT DECLARATIONS (one_constant_decl)+;//<constant_declaraions><remainder_constant_declarations>
one_constant_decl:   object_constant (',' object_constant)*  ':' sort_name (',' sort_name)*;//<one_constant_decl>,<const_params>,<remainder_const_params>
 
 
 
/* ALM FUNCTION DECLARATIONS */

function_name:ID;
function_declarations: FUNCTION DECLARATIONS static_declarations? fluent_declarations?;// 
static_declarations: STATICS basic_function_declarations? defined_function_declarations?;//<static_declarations>
fluent_declarations: FLUENTS basic_function_declarations? defined_function_declarations?;//<static_declarations>
basic_function_declarations: BASIC (one_function_decl)+;//<basic_function_declarations>,<remainder_function_declarations>
defined_function_declarations: DEFINED (one_function_decl)+;//<defined_function_declarations>,<remainder_function_declarations> 
one_function_decl: (TOTAL)? function_name ':' sort_name (('*' sort_name )* RIGHT_ARROW sort_name)?;//<one_function_decl><total_partial><one_f_decl> <remainder_args>



pos_fun_def: function_term EQ term | function_term | '-' function_term;
neg_fun_def: function_term NEQ term;
fun_def : (pos_fun_def | neg_fun_def);

/* ALM AXIOMS */

axioms: AXIOMS (dynamic_causal_laws | executability_conditions | state_constraints | definitions)* ;//<axioms>,<remainder_axioms>
dynamic_causal_laws: DYNAMIC CAUSAL LAWS (one_dynamic_causal_law)+;
executability_conditions: EXECUTABILITY CONDITIONS (one_executability_condition)+;
state_constraints: STATE CONSTRAINTS (one_state_constraint)+;
definitions: FUNCTION DEFINITIONS (one_definition)+;

 /* DYNAMIC CAUSAL LAW */
 
 one_dynamic_causal_law: occurs_atom CAUSES pos_fun_def IF instance_atom (',' literal)* '.'; //<dynamic_causal_law><body>
 
 
 /* EXECUTABILITY CONDITION */
 
one_executability_condition: IMPOSSIBLE occurs_atom IF instance_atom ( ',' ( occurs_literal| literal))* '.'; //<executability_condition>, <extended body> 
 
 
 /* STATE CONSTRAINT */
 
 one_state_constraint: fun_def '.' | (FALSE | fun_def) IF literal (',' literal)* '.'; // 
 
 /* DEFINITION */
 
one_definition: function_term '.' |  function_term IF literal (',' literal)* '.';
 
/* ALM STRUCTURE */

structure_name: alm_name;
structure: STRUCTURE structure_name (constant_defs | instance_defs | statics_defs)*;//<structure>
 

/* CONSTANT DEFINITIONS */

constant_defs: CONSTANT DEFINITIONS (one_constant_def)+;//<constant_defs><remainder_constant_defs>  
one_constant_def: object_constant '=' term;//<one_constant_def> 


/* INSTANCE DEFINITIONS */
 
instance_defs: INSTANCES (one_instance_def)+;//<instance_defs><remainder_instance_defs> 
one_instance_def: object_constant (',' object_constant)* IN sort_name (',' sort_name)* (WHERE literal (',' literal)* )? attribute_defs;//<one_instance_def>
attribute_defs: (one_attribute_def)*;
one_attribute_def: function_term EQ term;

/* STATICS DEFINITIONS */

statics_defs:  VALUE OF STATICS (one_static_def)+ ; 
one_static_def: fun_def (IF literal (',' literal)*)? '.';
//<one_static_literal><body>

/* SOLVER MODE */


solver_mode : temporal_projection;

temporal_projection : TEMPORAL PROJECTION max_steps history;
max_steps: MAX STEPS  POSINT;
history : HISTORY (observed | happened)+;
observed : OBSERVED '(' function_term ',' term ',' nat_num ')' ;
happened : HAPPENED '(' object_constant ',' nat_num ')' ;
