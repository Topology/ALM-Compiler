package edu.ttu.krlab.alm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfLiteral;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfProgram;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfRule;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.sig.ConstantEntry;
import edu.ttu.krlab.alm.datastruct.sig.DOMFunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.FunctionEntry;
import edu.ttu.krlab.alm.datastruct.sig.SortEntry;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.sparc.PredicateAlreadyDeclared;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCLiteral;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCPredicate;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCProgram;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCRule;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCSort;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCSortAlreadyDefined;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCSortNotDefined;
import edu.ttu.krlab.alm.datastruct.type.TypeChecker;
import edu.ttu.krlab.answerset.parser.AnswerSet;

public abstract class ALMTranslator {

    public static void ConstructPreModelProgram(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
        PreModelCreateSortsSection(pm, st);
        PreModelCreatePredicatesSection(pm, st);
        PreModelCreateRules(pm, st, aspf);
    }

    private static void PreModelCreateSortsSection(SPARCProgram pm, SymbolTable st) {
        Set<SortEntry> started = new HashSet<SortEntry>();
        Set<SortEntry> finished = new HashSet<SortEntry>();
        SortEntry universe = st.getUniverseSortEntry();

        PreModelSortHierarchy(universe, pm, st, started, finished);

        // need to add special sort nodes to pre-model.
        SortEntry nodesentry = st.getNodesSpecialSortEntry();
        SPARCSort nodes = new SPARCSort(nodesentry.getSortName());
        for (ALMTerm si : nodesentry.getInstances()) {
            nodes.addInstance(si);
        }

        try {
            pm.addSPARCSort(nodes);
        } catch (SPARCSortAlreadyDefined e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("PreModel Creating Sorts Section",
                    "Special Sort For Nodes In Hierarchy Was Already Defined.");
            // This should never happen.
        }

        // add time steps to sorts.
        SortEntry timeSteps = st.getTimestepSortEntry();
        if (timeSteps.getInstances().isEmpty()) {
            st.setMaxSteps(2);
        }
        SPARCSort time = new SPARCSort(timeSteps.getSortName());
        // no instances added for static section.
        try {
            pm.addSPARCSort(time);
        } catch (SPARCSortAlreadyDefined e) {
            e.printStackTrace();
            ALMCompiler.IMPLEMENTATION_FAILURE("PreModel Creating Sorts Section",
                    "Special Sort For Time Steps In Hierarchy Was Already Defined.");
            // This should never happen.
        }
    }

    /**
     * Recursively constructs the sort section of the given SPARCProgram
     * ensuring that all dependencies are respected.
     * <br>
     * A sort S is dependent on S' under the following conditions:
     * <ol>
     * <li>S' is a child sort of S
     * <li>S' is used in the signature of an attribute function of S.
     * <li>S' is used as an argument to a descendant ConstantEntry functor.
     * </ol>
     *
     *
     * @param se
     * @param pm
     * @param st
     * @param started
     * @param finished
     */
    private static void PreModelSortHierarchy(SortEntry se, SPARCProgram pm, SymbolTable st, Set<SortEntry> started,
            Set<SortEntry> finished) {

        //Check to see if this sort is finished.  If so, return. 
        if (finished.contains(se)) {
            return;
        }

        //if se has been started before now, throw an error.  A semantic error should have caught this. 
        if (started.contains(se)) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Construct PREMODEL SORT SECTION",
                    "Loop detected in sort heierarchy.  This code path should not execute due to semantic error generation.");
        }

        //Add sort to the started set. 
        started.add(se);

        //Collect dependencies. 
        Set<SortEntry> dependencies = new HashSet<>();
        //1. S' is a child of S
        dependencies.addAll(se.getChildSorts());
        //2. S' is used in the signature of the attribute function of S
        for (FunctionEntry attr : se.getAttributes()) {
            List<SortEntry> sig = attr.getSignature();
            int sig_length = sig.size();
            for (int i = 0; i < sig_length; i++) { // skip the first sort for attributes, always.
                SortEntry sort = sig.get(i);
                if (finished.contains(sort) || started.contains(sort)) //skip completed  and started dependencies. 
                {
                    continue;
                }
                if (!sort.subsortof(se)) { // ignore references to se.  
                    dependencies.add(sort);
                }
            }
        }
        //3. S' is an argument of a one of the constants that can occur for this sort. 
        for (ConstantEntry ce : se.getConstants()) {
            for (SortEntry arg : ce.getArguments()) {
                if (arg != se) {
                    dependencies.add(arg);
                } else {
                    ALMCompiler.IMPLEMENTATION_FAILURE("Construct Pre-Model Sort Section",
                            "Constant [" + ce.getConstName() + "] is an instance of its own argument ["
                            + arg.getSortName() + "], creating a circular dependency.");
                }

            }
        }

        //first write out dependencies. 
        for (SortEntry dependency : dependencies) {
            PreModelSortHierarchy(dependency, pm, st, started, finished);
        }

        // writing out dependencies is finished, time to write out this sort.
        SPARCSort psort = new SPARCSort(se.getSortName());
        if (se.isSingletonSort()) {
            //singleton is a leaf sort
            ConstantEntry ce = se.getSingletonConstant();
            psort.addInstance(ce.getALMTerm());
        } else {
            //add any instances.  
            for (ALMTerm si : se.getInstances()) {
                psort.addInstance(si);
            }
            // add child sorts
            for (SortEntry sort : se.getChildSorts()) {
                try {
                    psort.union(pm.getSPARCSort(sort.getSortName()));
                } catch (SPARCSortNotDefined e) {
                    ALMCompiler.IMPLEMENTATION_FAILURE("Construct Premodel Sorts",
                            "Sort was not defined: " + e.getMessage());
                }
            }
        }

        try {
            pm.addSPARCSort(psort);
        } catch (SPARCSortAlreadyDefined e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Construct Premodel Sorts", "Sort was defined twice: " + e.getMessage());
        }

        //indicate se is finished. 
        finished.add(se);
    }

    private static void PreModelCreatePredicatesSection(SPARCProgram pm, SymbolTable st) {
        // For each function, generate a predicate signature for it and its dom_f
        // function.

        for (FunctionEntry f : st.getFunctions()) {
            String f_name = f.getFunctionName();
            DOMFunctionEntry dom_f = st.getDOMFunction(f);
            String dom_f_name = dom_f.getFunctionName();
            SPARCPredicate f_pred = null;
            SPARCPredicate dom_f_pred = null;
            if (f.isAttribute()) {
                f_pred = new SPARCPredicate(f.getQualifiedFunctionName());
                f_pred.addComment("Attribute Function [" + f_name + "] for sort ["
                        + f.getSignature().get(0).getSortName() + "].");
                dom_f_pred = new SPARCPredicate(dom_f.getQualifiedFunctionName());
                dom_f_pred.addComment(
                        "Domain Function [" + dom_f.getQualifiedFunctionName() + "] for attribute function [" + f_name
                        + "] of sort [" + f.getSignature().get(0).getSortName() + "].");
            } else {
                f_pred = new SPARCPredicate(f_name);
                dom_f_pred = new SPARCPredicate(dom_f_name);
                dom_f_pred.addComment("Domain Function [" + dom_f_name + "].");

                if (f.isSpecial()) {
                    f_pred.addComment("Special Function [" + f_name + "]");
                } else if (f.isStatic()) {
                    f_pred.addComment("Static Function [" + f_name + "]");
                } else if (f.isFluent()) {
                    f_pred.addComment("Fluent Function [" + f_name + "]");
                }
            }

            // need to add signature to predicate, leaving off boolean if that is the range
            // sort.
            List<SortEntry> sig = f.getSignature();
            if (sig == null) {
                ALMCompiler.IMPLEMENTATION_FAILURE("PreModelCreatePredicatesSection", "Function Has No Signature");
            }

            //populate f_pred with the sort of each argument. 
            int dom_length = sig.size() - 1;
            for (int i = 0; i <= dom_length; i++) {
                SortEntry se = sig.get(i);
                if (i < dom_length || se != st.getBooleansSortEntry()) {
                    try {
                        SPARCSort ss = pm.getSPARCSort(sig.get(i).getSortName());
                        f_pred.addSPARCSort(ss);
                        if (i < dom_length) {
                            dom_f_pred.addSPARCSort(ss);
                            ;
                        }
                    } catch (SPARCSortNotDefined e) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("PreModelCreatePredicatesSection",
                                "SPARC Sort [" + se.getSortName() + "] Not defined in pre model program for function ["
                                + f.getFunctionName() + "].");
                    }
                }
            }

            // adding time to fluents
            if (f.isFluent()) {
                SPARCSort step = new SPARCSort(st.getTimestepSortEntry().getSortName());
                f_pred.addSPARCSort(step);
                dom_f_pred.addSPARCSort(step);
            }

            try {
                pm.addSPARCPredicate(f_pred);
                pm.addSPARCPredicate(dom_f_pred);
            } catch (PredicateAlreadyDeclared e) {
                e.printStackTrace();
                ALMCompiler.IMPLEMENTATION_FAILURE("PreModelCreatePredicatesSection",
                        "A second predicate declaration with the same name cannot be created.");
                // This should be prevented by semantic error checking.
            }
        }
    }

    private static void PreModelCreateRules(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {

        // ST: Model Sort Hierarchy In Rules
        PreModelSortHierarchyRules(pm, st, aspf);

        // ST: Add Fundamental Axioms For ALL Static Functions
        PreModelRulesStaticFunctions(pm, st);

        // ASPF: Static State Constraint Axioms
        PreModelStaticStateConstraintAxioms(pm, st, aspf);

        // ASPF: Static Definitions Axioms
        PreModelStaticDefinitionsAxioms(pm, st, aspf);

        // ASPF: Attribute Definitions And Sort Instances
        PreModelSortInstancesAndAttributeDefinitions(pm, st, aspf);

        // ASPF: Static Function Definitions
        PreModelStructureStaticFunctionDefinitions(pm, st, aspf);

    }

    private static void PreModelSortHierarchyRules(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {

        // Link Function -- requires recursive enumeration over sort hierarchy
        SortEntry universe = st.getUniverseSortEntry();
        PreModelRecursivelyAddRulesForLink(pm, st, universe, new HashSet<SortEntry>()); // the set is to mark when the
        // sorts have had their links
        // written out.

        // Is_A Function -- uses structure to generate the rules from sort instance
        // declarations.
        PreModelAddRulesForIsA(pm, st, aspf);

        // Instance Function -- This closure of instances based on is_a and link
        // These cannot be enumerated as the pre-model logic program is necessary to
        // specify the enumeration.
        PreModelRulesForInstance(pm, st);

        // Subsort Function -- Closure of subsort relation based on link
        // General rule, optimization could enumerate the facts.
        PreModelRulesForSubsort(pm, st);

        // Has Parent Function -- General rule, optimization could enumerate the facts.
        PreModelRulesForHasParent(pm, st);

        // Has Child Function -- General rule, optimization could enumerate the facts.
        PreModelRulesForHasChild(pm, st);

        // Source Function -- General rule, optimization could enumerate the facts.
        PreModelRulesForSource(pm, st);

        // Sink Function -- General rule, optimization could enumerate the facts.
        PreModelRulesForSink(pm, st);

    }

    private static void PreModelRecursivelyAddRulesForLink(SPARCProgram pm, SymbolTable st, SortEntry parent,
            Set<SortEntry> finished) {
        if (finished.contains(parent)) {
            return;
        }
        Set<SortEntry> children = parent.getChildSorts();
        if (children != null && children.size() > 0) {
            for (SortEntry child : children) {
                ALMTerm is_a = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
                is_a.addArg(new ALMTerm(child.getSortName(), ALMTerm.ID));
                is_a.addArg(new ALMTerm(parent.getSortName(), ALMTerm.ID));
                SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_LINK, is_a, null);
                r.addComment("[" + child.getSortName() + "] is a child sort of [" + parent.getSortName() + "]");

                PreModelRecursivelyAddRulesForLink(pm, st, child, finished);
            }
        }
        finished.add(parent);
    }

    private static void PreModelAddRulesForIsA(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {

        // Add Rules and Facts For Each Instance
        // These were parsed into ASPf as an intermediate form
        for (ASPfRule aspf_rule : aspf.getRules(ALM.STRUCTURE_SORT_INSTANCES)) {
            // These rules should all be static, otherwise a semantic error would occur.
            // They can be transferred directly to SPARC without modification, casting to
            // ALMTerm as intermediate representation
            ASPfLiteral aspf_head = aspf_rule.getHead();
            SPARCLiteral head = (ALMTerm) aspf_head;

            List<ASPfLiteral> aspf_body = aspf_rule.getBody();
            List<SPARCLiteral> body = null;
            if (aspf_body != null) {
                body = new ArrayList<SPARCLiteral>();
                for (ASPfLiteral aspf_lit : aspf_body) {
                    body.add((ALMTerm) aspf_lit);
                }
            }

            SPARCRule instance_rule = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_IS_A, head, body);
            instance_rule.copyComments(aspf_rule);
        }
    }

    private static void PreModelRulesForInstance(SPARCProgram pm, SymbolTable st) {

        ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
        ALMTerm YVar = new ALMTerm("Y", ALMTerm.VAR);
        ALMTerm ZVar = new ALMTerm("Z", ALMTerm.VAR);

        // Add Rule for instance base case (is_a)
        ALMTerm instance_head = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
        instance_head.addArg(XVar);
        instance_head.addArg(YVar);

        List<SPARCLiteral> instance_body = new ArrayList<SPARCLiteral>();
        ALMTerm instance_body_is_a = new ALMTerm(ALM.SPECIAL_FUNCTION_IS_A, ALMTerm.FUN);
        instance_body_is_a.addArg(XVar);
        instance_body_is_a.addArg(YVar);
        instance_body.add(instance_body_is_a);

        SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_INSTANCE, instance_head, instance_body);
        r.addComment("Base case of [instance] relation.");
        r.addComment("If X is a Y then X is an instance of Y.");

        // Add Rule For Inference across links
        // X is an instance of Z if X is an instance of Y and there is a link from Y to
        // Z
        ALMTerm instance_closure_head = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
        instance_closure_head.addArg(XVar);
        instance_closure_head.addArg(ZVar);

        List<SPARCLiteral> instance_closure_body = new ArrayList<SPARCLiteral>();
        ALMTerm is_a_closure_body_is_a = new ALMTerm(ALM.SPECIAL_FUNCTION_INSTANCE, ALMTerm.FUN);
        is_a_closure_body_is_a.addArg(XVar);
        is_a_closure_body_is_a.addArg(YVar);
        instance_closure_body.add(is_a_closure_body_is_a);

        ALMTerm is_a_closure_body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
        is_a_closure_body_link.addArg(YVar);
        is_a_closure_body_link.addArg(ZVar);
        instance_closure_body.add(is_a_closure_body_link);

        SPARCRule closure = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_INSTANCE, instance_closure_head,
                instance_closure_body);
        closure.addComment("Closure On [instance] relation.");
        closure.addComment("X is an instance of Z if X is an instance of Y and there is a link from Y to Z.");

    }

    private static void PreModelRulesForSubsort(SPARCProgram pm, SymbolTable st) {

        ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
        ALMTerm YVar = new ALMTerm("Y", ALMTerm.VAR);
        ALMTerm ZVar = new ALMTerm("Z", ALMTerm.VAR);

        // Add Rule for subsort base case (link)
        ALMTerm instance_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
        instance_head.addArg(XVar);
        instance_head.addArg(YVar);

        List<SPARCLiteral> subsort_body = new ArrayList<SPARCLiteral>();
        ALMTerm subsort_body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
        subsort_body_link.addArg(XVar);
        subsort_body_link.addArg(YVar);
        subsort_body.add(subsort_body_link);

        SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SUBSORT, instance_head, subsort_body);
        r.addComment("Base case of [subsort] relation.");
        r.addComment("If there is a link from X to Y in the sort hierarchy then X is a subsort of Y.");

        // Add Rule For Inference across links
        // X is a subsort of Z if there is a link from X to Y and Y is a subsort of Z
        ALMTerm subsort_closure_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
        subsort_closure_head.addArg(XVar);
        subsort_closure_head.addArg(ZVar);

        List<SPARCLiteral> subsort_closure_body = new ArrayList<SPARCLiteral>();
        ALMTerm subsort_closure_body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
        subsort_closure_body_link.addArg(XVar);
        subsort_closure_body_link.addArg(YVar);
        subsort_closure_body.add(subsort_closure_body_link);

        ALMTerm subsort_closure_body_subsort = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
        subsort_closure_body_subsort.addArg(YVar);
        subsort_closure_body_subsort.addArg(ZVar);
        subsort_closure_body.add(subsort_closure_body_subsort);

        SPARCRule closure = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SUBSORT, subsort_closure_head, subsort_closure_body);
        closure.addComment("Closure On [subsort] relation.");
        closure.addComment("X is a subsort of Z if there is a link from X to Y and Y is a subsort of Z.");

        // Source needs the closed world assumption since it is a total boolean
        // function.
        ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
        closeworld_head.setSign(ALMTerm.SIGN_NEG);
        closeworld_head.addArg(XVar);
        closeworld_head.addArg(YVar);

        ALMTerm closeworld_body_subsort = new ALMTerm(ALM.SPECIAL_FUNCTION_SUBSORT, ALMTerm.FUN);
        closeworld_body_subsort.setSign(ALMTerm.SIGN_NOT);
        closeworld_body_subsort.addArg(XVar);
        closeworld_body_subsort.addArg(YVar);

        List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
        closeworld_body.add(closeworld_body_subsort);

        SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SUBSORT, closeworld_head, closeworld_body);
        rc.addComment("[subsort] needs the closed world assumption since it is a total boolean function.");
    }

    private static void PreModelRulesForHasParent(SPARCProgram pm, SymbolTable st) {

        // X has a parent if there is a link from X to some sort Y.
        ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
        ALMTerm YVar = new ALMTerm("Y", ALMTerm.VAR);

        ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_PARENT, ALMTerm.FUN);
        head.addArg(XVar);

        ALMTerm body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
        body_link.addArg(XVar);
        body_link.addArg(YVar);

        List<SPARCLiteral> body = new ArrayList<SPARCLiteral>();
        body.add(body_link);

        SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_HAS_PARENT, head, body);
        r.addComment("Sort X has a parent in the hierarchy if there is a link from X to some sort Y.");

        // Has parent needs the closed world assumption since it is a total boolean
        // function.
        ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_PARENT, ALMTerm.FUN);
        closeworld_head.setSign(ALMTerm.SIGN_NEG);
        closeworld_head.addArg(XVar);

        ALMTerm closeworld_body_has_parent = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_PARENT, ALMTerm.FUN);
        closeworld_body_has_parent.setSign(ALMTerm.SIGN_NOT);
        closeworld_body_has_parent.addArg(XVar);

        List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
        closeworld_body.add(closeworld_body_has_parent);

        SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_HAS_PARENT, closeworld_head, closeworld_body);
        rc.addComment("[has_parent] needs the closed world assumption since it is a total boolean function.");
    }

    private static void PreModelRulesForHasChild(SPARCProgram pm, SymbolTable st) {

        // X has a child in the hierarchy if there is a link from some sort Y to X.
        ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
        ALMTerm YVar = new ALMTerm("Y", ALMTerm.VAR);

        ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_CHILD, ALMTerm.FUN);
        head.addArg(XVar);

        ALMTerm body_link = new ALMTerm(ALM.SPECIAL_FUNCTION_LINK, ALMTerm.FUN);
        body_link.addArg(YVar);
        body_link.addArg(XVar);

        List<SPARCLiteral> body = new ArrayList<SPARCLiteral>();
        body.add(body_link);

        SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_HAS_CHILD, head, body);
        r.addComment("X has a child in the hierarchy if there is a link from some sort Y to X.");

        // Has child needs the closed world assumption since it is a total boolean
        // function.
        ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_CHILD, ALMTerm.FUN);
        closeworld_head.setSign(ALMTerm.SIGN_NEG);
        closeworld_head.addArg(XVar);

        ALMTerm closeworld_body_has_child = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_CHILD, ALMTerm.FUN);
        closeworld_body_has_child.setSign(ALMTerm.SIGN_NOT);
        closeworld_body_has_child.addArg(XVar);

        List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
        closeworld_body.add(closeworld_body_has_child);

        SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_HAS_CHILD, closeworld_head, closeworld_body);
        rc.addComment("[has_child] needs the closed world assumption since it is a total boolean function.");
    }

    private static void PreModelRulesForSource(SPARCProgram pm, SymbolTable st) {
        // if sort X has no child sort, X is a source sort
        ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
        ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_SOURCE, ALMTerm.FUN);
        head.addArg(XVar);

        ALMTerm body_has_child = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_CHILD, ALMTerm.FUN);
        body_has_child.setSign(ALMTerm.SIGN_NEG);
        body_has_child.addArg(XVar);

        List<SPARCLiteral> body = new ArrayList<SPARCLiteral>();
        body.add(body_has_child);

        SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SOURCE, head, body);
        r.addComment("If sort X has no child sort, X is a source sort");

        // Source needs the closed world assumption since it is a total boolean
        // function.
        ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SOURCE, ALMTerm.FUN);
        closeworld_head.setSign(ALMTerm.SIGN_NEG);
        closeworld_head.addArg(XVar);

        ALMTerm closeworld_body_source = new ALMTerm(ALM.SPECIAL_FUNCTION_SOURCE, ALMTerm.FUN);
        closeworld_body_source.setSign(ALMTerm.SIGN_NOT);
        closeworld_body_source.addArg(XVar);

        List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
        closeworld_body.add(closeworld_body_source);

        SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SOURCE, closeworld_head, closeworld_body);
        rc.addComment("[source] needs the closed world assumption since it is a total boolean function.");
    }

    private static void PreModelRulesForSink(SPARCProgram pm, SymbolTable st) {
        // if sort X has no parent sort, X is a sink sort
        ALMTerm XVar = new ALMTerm("X", ALMTerm.VAR);
        ALMTerm head = new ALMTerm(ALM.SPECIAL_FUNCTION_SINK, ALMTerm.FUN);
        head.addArg(XVar);

        ALMTerm body_has_child = new ALMTerm(ALM.SPECIAL_FUNCTION_HAS_PARENT, ALMTerm.FUN);
        body_has_child.setSign(ALMTerm.SIGN_NEG);
        body_has_child.addArg(XVar);

        List<SPARCLiteral> body = new ArrayList<SPARCLiteral>();
        body.add(body_has_child);

        SPARCRule r = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SINK, head, body);
        r.addComment("If sort X has no parent sort, X is a sink sort");

        // Sink needs the closed world assumption since it is a total boolean function.
        ALMTerm closeworld_head = new ALMTerm(ALM.SPECIAL_FUNCTION_SINK, ALMTerm.FUN);
        closeworld_head.setSign(ALMTerm.SIGN_NEG);
        closeworld_head.addArg(XVar);

        ALMTerm closeworld_body_source = new ALMTerm(ALM.SPECIAL_FUNCTION_SINK, ALMTerm.FUN);
        closeworld_body_source.setSign(ALMTerm.SIGN_NOT);
        closeworld_body_source.addArg(XVar);

        List<SPARCLiteral> closeworld_body = new ArrayList<SPARCLiteral>();
        closeworld_body.add(closeworld_body_source);

        SPARCRule rc = pm.newSPARCRule(ALM.SPECIAL_FUNCTION_SINK, closeworld_head, closeworld_body);
        rc.addComment("[sink] needs the closed world assumption since it is a total boolean function.");

    }

    /**
     * Static Functions have predicates declared in the predicate section, These
     * rules are described in the ALM paper as needing to be added per type of
     * function
     * <p>
     * defined functions need the closed world assumption. <br>
     * -f(X1..Xn) :- not f(X1..Xn).
     * <p>
     * non-boolean functions need uniqueness constraints to enforce uniqueness
     * of assignment. <br>
     * :- f(X1..Xn, V), f(X1..Xn, V2), V != V2. 3)
     * <p>
     * dom_f needs its axioms added: <br>
     * dom_f(X1..Xn) :- f(X1..Xn). when f's range is boolean. <br>
     * dom_f(X1..Xn) :- f(X1..Xn, V). when f's range is not boolean. <br>
     * -dom_f(X1..Xn) :- not dom_f(X1..Xn). closed world assumption on domain of
     * static functions. <br>
     * :- -dom_f(X1..Xn). when f is total.
     *
     * @param pm The SPARCProgram to compute the pre-model.
     * @param st The SymbolTable
     */
    private static void PreModelRulesStaticFunctions(SPARCProgram pm, SymbolTable st) {
        for (FunctionEntry f : st.getFunctions()) {
            if (f.isStatic()) {
                DOMFunctionEntry dom_f = st.getDOMFunction(f);
                List<SortEntry> sig = f.getSignature();
                boolean fIsBoolean = st.getBooleansSortEntry().equals(sig.get(sig.size() - 1));
                int dom_size = sig.size() - 1;
                int count;
                String XVar = "X";
                List<ALMTerm> XArgs = new ArrayList<>();
                for (count = 0; count < dom_size; count++) {
                    XArgs.add(new ALMTerm(XVar + count, ALMTerm.VAR));
                }
                List<SPARCLiteral> body;
                SPARCRule r;

                if (f.isDefined()) {
                    // defined static functions need the closed world assumption.
                    // -f(X1..Xn) :- not f(X1..Xn).
                    ALMTerm neg_f_bool = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
                    neg_f_bool.setSign(ALMTerm.SIGN_NEG);
                    neg_f_bool.getArgs().addAll(XArgs);
                    ALMTerm not_f_bool = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
                    not_f_bool.setSign(ALMTerm.SIGN_NOT);
                    not_f_bool.getArgs().addAll(XArgs);
                    body = new ArrayList<>();
                    body.add(not_f_bool);
                    r = pm.newSPARCRule(ALM.RULES_STATIC_FUNCTIONS, neg_f_bool, body);
                    r.addComment("Function [" + f.getQualifiedFunctionName()
                            + "] is a defined static function and has the closed world assumption.");
                    continue;
                    // static defined functions are total due to closed world assumption and do not
                    // need dom_f functions.
                }

                ALMTerm V = new ALMTerm("V", ALMTerm.VAR);
                ALMTerm V2 = new ALMTerm("V2", ALMTerm.VAR);

                ALMTerm pos_dom_f = new ALMTerm(dom_f.getQualifiedFunctionName(), ALMTerm.FUN);
                pos_dom_f.getArgs().addAll(XArgs);

                ALMTerm neg_dom_f = new ALMTerm(dom_f.getQualifiedFunctionName(), ALMTerm.FUN);
                neg_dom_f.getArgs().addAll(XArgs);
                neg_dom_f.setSign(ALMTerm.SIGN_NEG);

                ALMTerm not_dom_f = new ALMTerm(dom_f.getQualifiedFunctionName(), ALMTerm.FUN);
                not_dom_f.getArgs().addAll(XArgs);
                not_dom_f.setSign(ALMTerm.SIGN_NOT);

                if (fIsBoolean) {
                    // definition of dom_f when f is positieve boolean
                    // dom_f(X1..Xn) :- f(X1..Xn).
                    ALMTerm pos_f_bool = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
                    pos_f_bool.getArgs().addAll(XArgs);
                    body = new ArrayList<>();
                    body.add(pos_f_bool);
                    r = pm.newSPARCRule(ALM.RULES_STATIC_FUNCTIONS, pos_dom_f, body);
                    r.addComment("Definition of [" + dom_f.getQualifiedFunctionName() + "] when ["
                            + f.getQualifiedFunctionName() + "] is a positive boolean function.");

                    // definition of dom_f when f is negative boolean
                    // dom_f(X1..Xn) :- f(X1..Xn).
                    ALMTerm neg_f_bool = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
                    neg_f_bool.getArgs().addAll(XArgs);
                    neg_f_bool.setSign(ALMTerm.SIGN_NEG);
                    body = new ArrayList<>();
                    body.add(neg_f_bool);
                    r = pm.newSPARCRule(ALM.RULES_STATIC_FUNCTIONS, pos_dom_f, body);
                    r.addComment("Definition of [" + dom_f.getQualifiedFunctionName() + "] when ["
                            + f.getQualifiedFunctionName() + "] is a positive boolean function.");

                } else {
                    // non-boolean functions need uniqueness constraints to enforce uniqueness of
                    // assignment.
                    // :- f(X1..Xn, V), f(X1..Xn, V2), V != V2.
                    ALMTerm f_v = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
                    f_v.getArgs().addAll(XArgs);
                    f_v.addArg(V);
                    ALMTerm f_v2 = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
                    f_v2.getArgs().addAll(XArgs);
                    f_v2.addArg(V2);
                    ALMTerm v_not_eq_v2 = new ALMTerm(ALM.SYMBOL_NEQ, ALMTerm.TERM_RELATION);
                    v_not_eq_v2.addArg(V);
                    v_not_eq_v2.addArg(V2);
                    body = new ArrayList<>();
                    body.add(f_v);
                    body.add(f_v2);
                    body.add(v_not_eq_v2);
                    r = pm.newSPARCRule(ALM.RULES_STATIC_FUNCTIONS, null, body);
                    r.addComment("Unique Assignment Constraint to model non-boolean functions using relations.");

                    // definition of dom_f when f is boolean
                    // dom_f(X1..Xn) :- f(X1..Xn, V).
                    body = new ArrayList<>();
                    body.add(f_v);
                    r = pm.newSPARCRule(ALM.RULES_STATIC_FUNCTIONS, pos_dom_f, body);
                    r.addComment("Definition of [" + dom_f.getQualifiedFunctionName() + "] when ["
                            + f.getQualifiedFunctionName() + "] is not a boolean function.");
                }

                // closed world assumption for dom_f.
                // -dom_f(X1..Xn) :- not dom_f(X1..Xn).
                body = new ArrayList<>();
                body.add(not_dom_f);
                r = pm.newSPARCRule(ALM.RULES_STATIC_FUNCTIONS, neg_dom_f, body);
                r.addComment("Closed world assumption holds for [" + dom_f.getQualifiedFunctionName() + "] since ["
                        + f.getQualifiedFunctionName() + "] is a static function.");

                // total static functions that are not defined need a constraint on dom_f to
                // always be positive.
                // :- -dom_f(X1..Xn).
                if (f.isTotal()) {
                    body = new ArrayList<>();
                    body.add(neg_dom_f);
                    r = pm.newSPARCRule(ALM.RULES_STATIC_FUNCTIONS, null, body);
                    r.addComment("Function [" + f.getQualifiedFunctionName() + "] is a total total static function.");
                }
            }
        }

        // Any other rules related to simply the existence of static functions should go
        // here.
    }

    private static void PreModelStaticStateConstraintAxioms(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
        // Not All State Constraints are completely static. Only the state constraints
        // with purely static literals are added.
        pm.createSection(ALM.AXIOMS_STATE_CONSTRAINTS_STATIC);
        for (ASPfRule ar : aspf.getRules(ALM.AXIOMS_STATE_CONSTRAINTS)) {
            if (!ar.hasFluentFunction(st)) {
                // basic static functions are the only functions that need to be translated now
                TranslateRule(ar, st, pm, ALM.AXIOMS_STATE_CONSTRAINTS_STATIC);
            }
        }
    }

    private static void PreModelStaticDefinitionsAxioms(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
        // Not All definitions are completely static. Only the state constraints with
        // purely static literals are added.
        pm.createSection(ALM.AXIOMS_DEFINITIONS_STATIC);
        for (ASPfRule ar : aspf.getRules(ALM.AXIOMS_DEFINITIONS)) {
            if (!ar.hasFluentFunction(st)) {
                // basic static functions are the only functions that need to be translated now
                TranslateRule(ar, st, pm, ALM.AXIOMS_DEFINITIONS_STATIC);
            }
        }
    }

    private static void PreModelSortInstancesAndAttributeDefinitions(SPARCProgram pm, SymbolTable st,
            ASPfProgram aspf) {
        pm.createSection(ALM.STRUCTURE_SORT_INSTANCES);
        for (ASPfRule ar : aspf.getRules(ALM.STRUCTURE_SORT_INSTANCES)) {
            TranslateRule(ar, st, pm, ALM.STRUCTURE_SORT_INSTANCES);
        }

        pm.createSection(ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS);
        for (ASPfRule ar : aspf.getRules(ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS)) {
            TranslateRule(ar, st, pm, ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS);
        }

    }

    private static void PreModelStructureStaticFunctionDefinitions(SPARCProgram pm, SymbolTable st, ASPfProgram aspf) {
        pm.createSection(ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS);
        for (ASPfRule ar : aspf.getRules(ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS)) {
            TranslateRule(ar, st, pm, ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS);
        }
    }

    public static void ConstructFinalProgram(SPARCProgram tm, AnswerSet as, SPARCProgram pm, SymbolTable st,
            ASPfProgram aspf, ALMCompilerSettings s, ErrorReport er) {
        PurgeSingletonSorts(pm, as, st);
        CreateFinalSortsSection(tm, pm, as, st);
        CreateFinalPredicatesSection(tm, pm, as);
        CreateFinalProgramRules(tm, st, pm, aspf);
        if (st.isModeActive(ALM.SOLVER_MODE)) {
            if (st.isModeActive(ALM.HISTORY)) {
                CreateHistory(tm, st, aspf, er);
            }
            if(st.isModeActive(ALM.SOLVER_MODE_PP)){
                
            }
        }
        //LoadFactsFromPreModelAnswerSet(tm, as, s); // TOO NAIVE, NEED TO FILTER FACTS FROM MISSING SORT INSTANCES. 
    }

    private static void PurgeSingletonSorts(SPARCProgram pm, AnswerSet as, SymbolTable st) {
        Set<SortEntry> singletons = st.getSingletonSorts();
        st.purgeSingletonSorts();
        for (SortEntry singleton : singletons) {
            String name = singleton.getSortName();
            pm.removeSPARCSortWithName(name);
            pm.removePredicatesContaining(name);
            pm.removeRulesContaining(name);
            as.purgeLiteralsContaining(name);
        }
        //the nodes sort needs to be re-rendered to not contain the singleton sorts as instances.
        SortEntry nodes = st.getNodesSpecialSortEntry();
        pm.removeSPARCSortWithName(nodes.getSortName());
        SPARCSort nodeSort = new SPARCSort(nodes.getSortName());
        for (ALMTerm inst : nodes.getInstances()) {
            nodeSort.addInstance(inst);
        }
        try {
            pm.addSPARCSort(nodeSort);
        } catch (SPARCSortAlreadyDefined e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Purging Singleton Sorts", "purge was not successfull.");
        }

    }

    private static void CreateFinalSortsSection(SPARCProgram tm, SPARCProgram pm, AnswerSet as, SymbolTable st) {
        HashMap<String, SPARCSort> sortmap = new HashMap<String, SPARCSort>();
        List<SPARCSort> pmsorts = pm.getSorts();
        for (SPARCSort pmsort : pmsorts) {
            if (pmsort.getSortName() == ALM.SPECIAL_SORT_NODES) {
                try {
                    tm.addSPARCSort(pmsort);
                } catch (SPARCSortAlreadyDefined e) {
                    // This should never happen since the pre-model program did not have duplicate
                    // sorts.
                    ALMCompiler.IMPLEMENTATION_FAILURE("Final Program Sorts", "Redundant Sort Error In Final Program.");
                }
            } else {
                SPARCSort tmsort = new SPARCSort(pmsort.getSortName());
                sortmap.put(tmsort.getSortName(), tmsort);
                try {
                    tm.addSPARCSort(tmsort);
                } catch (SPARCSortAlreadyDefined e) {
                    // This should never happen since the pre-model program did not have duplicate
                    // sorts.
                    ALMCompiler.IMPLEMENTATION_FAILURE("Final Program Sorts", "Redundant Sort Error In Final Program.");
                }
            }
        }

        List<ALMTerm> instances = as.getLiterals(ALM.SPECIAL_FUNCTION_INSTANCE);
        if (instances != null) {
            for (ALMTerm instlit : instances) {
                ALMTerm ground_object = instlit.getArg(0);
                ALMTerm sort = instlit.getArg(1);
                if (instlit.getSign() == ALMTerm.SIGN_POS) {
                    SPARCSort tmsort = sortmap.get(sort.toString());
                    tmsort.addInstance(ground_object);
                }
            }
        }

        // add time steps to sorts.
        try {
            SPARCSort time = tm.getSPARCSort(ALM.SORT_TIMESTEP);
            for (ALMTerm si : st.getTimestepSortEntry().getInstances()) {
                time.addInstance(si);
            }
        } catch (SPARCSortNotDefined e1) {
            ALMCompiler.IMPLEMENTATION_FAILURE("TM Creating Sorts Section",
                    "Special Sort For Time Steps In Hierarchy Was Not In Pre-Model.");
            // This should never happen.
        }
    }

    private static void CreateFinalPredicatesSection(SPARCProgram tm, SPARCProgram pm, AnswerSet as) {
        for (SPARCPredicate pred : pm.getPredicates()) {
            try {
                tm.addSPARCPredicate(pred);
            } catch (PredicateAlreadyDeclared e) {
                // This should never happen since the pre-model program did not have duplicate
                // predicates.
                ALMCompiler.IMPLEMENTATION_FAILURE("Final Program Predicates",
                        "Redundant Predicate Error In Final Program.");
            }
        }
    }

    private static void CreateFinalProgramRules(SPARCProgram tm, SymbolTable st, SPARCProgram pm, ASPfProgram aspf) {
        // Copy section from pre model program
        tm.copyRulesSections(pm);

        // New Rules for dom_f fluents.
        FinalProgramFluentFunctionRules(tm, st);

        // Add sections containing fluent functions.
        FinalProgramDynamicCausalLaws(tm, st, aspf);

        FinalProgramExecutabilityConditions(tm, st, aspf);

        FinalProgramStateConstraints(tm, st, aspf);

        FinalProgramDefinitions(tm, st, aspf);
    }

    /**
     * Fluent functions need the following axioms:
     * <ol>
     * <li>-f(X1..Xn, I) :- not f(X1..Xn, I) defined fluents receive the closed
     * world assumption.
     * <li>:- f(X1..Xn, V, I), f(X1..Xn, V2, I), V != V2. (Unique Assignment
     * Constraint)
     * <li>f(X1..Xn, V, I+1) :- f(X1..Xn, V, I), not f(X1..Xn, V2, I), V != V2,
     * dom_f(X1...Xn, I+1). (Law Of Inertia for f).
     * <li>dom_f(X1..Xn, I) :- f(X1..Xn,V,I). 5) (Definition of positive dom_f)
     * <li>dom_f(X1..Xn, I+1) :- dom_f(X1..Xn, I), not -dom_f(X1..Xn, I+1).
     * (Positive Law Of Inertia for dom_f)
     * <li>-dom_f(X1..Xn, I+1) :- -dom_f(X1..Xn,I), not dom_f(X1..Xn, I+1).
     * (Negative Law Of Inertia for dom_f)
     * </ol>
     *
     * @param tm
     * @param st
     */
    private static void FinalProgramFluentFunctionRules(SPARCProgram tm, SymbolTable st) {

        ALMTerm V = new ALMTerm("V", ALMTerm.VAR);
        ALMTerm V2 = new ALMTerm("V2", ALMTerm.VAR);
        ALMTerm I = new ALMTerm("I", ALMTerm.VAR);
        ALMTerm Inc = new ALMTerm("I+1", ALMTerm.VAR);

        for (FunctionEntry f : st.getFunctions()) {
            if (f.isFluent() && !f.isSpecial()) {
                DOMFunctionEntry dom_f = st.getDOMFunction(f);
                String f_name = f.getFunctionName();
                String dom_f_name = dom_f.getFunctionName();
                String XVar = "X";
                List<ALMTerm> domain_args = new ArrayList<ALMTerm>();
                int count = 0;
                int dom_length = f.getSignature().size() - 1;
                for (count = 0; count < dom_length; count++) {
                    domain_args.add(new ALMTerm(XVar + count, ALMTerm.VAR));
                }
                SPARCRule r;
                List<SPARCLiteral> body;

                if (f.isDefined()) {
                    // -f(X1..Xn, I) :- not f(X1..Xn, I) defined fluents receive the closed world
                    // assumption.
                    ALMTerm neg_f_bool = new ALMTerm(f_name, ALMTerm.FUN);
                    neg_f_bool.setSign(ALMTerm.SIGN_NEG);
                    neg_f_bool.getArgs().addAll(domain_args);
                    neg_f_bool.addArg(I);
                    ALMTerm not_f_bool = new ALMTerm(f_name, ALMTerm.FUN);
                    not_f_bool.setSign(ALMTerm.SIGN_NOT);
                    not_f_bool.getArgs().addAll(domain_args);
                    not_f_bool.addArg(I);
                    body = new ArrayList<>();
                    body.add(not_f_bool);
                    r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, neg_f_bool, body);
                    r.addComment("Closed World Assumption for defined fluent [" + f_name + "].");
                    continue;
                }
                List<ALMTerm> args;

                ALMTerm f_V_I = new ALMTerm(f_name, ALMTerm.FUN);
                args = f_V_I.getArgs();
                args.addAll(domain_args);
                args.add(V);
                args.add(I);

                ALMTerm f_V_Inc = new ALMTerm(f_name, ALMTerm.FUN);
                args = f_V_Inc.getArgs();
                args.addAll(domain_args);
                args.add(V);
                args.add(Inc);

                ALMTerm not_f_V2_Inc = new ALMTerm(f_name, ALMTerm.FUN);
                not_f_V2_Inc.setSign(ALMTerm.SIGN_NOT);
                args = not_f_V2_Inc.getArgs();
                args.addAll(domain_args);
                args.add(V2);
                args.add(Inc);

                ALMTerm V_not_V2 = new ALMTerm(ALM.SYMBOL_NEQ, ALMTerm.TERM_RELATION);
                args = V_not_V2.getArgs();
                args.add(V);
                args.add(V2);

                ALMTerm dom_f_Inc = new ALMTerm(dom_f_name, ALMTerm.FUN);
                args = dom_f_Inc.getArgs();
                args.addAll(domain_args);
                args.add(Inc);

                ALMTerm f_I = new ALMTerm(f_name, ALMTerm.FUN);
                args = f_I.getArgs();
                args.addAll(domain_args);
                args.add(I);

                ALMTerm f_Inc = new ALMTerm(f_name, ALMTerm.FUN);
                args = f_Inc.getArgs();
                args.addAll(domain_args);
                args.add(Inc);

                ALMTerm not_f_Inc = new ALMTerm(f_name, ALMTerm.FUN);
                not_f_Inc.setSign(ALMTerm.SIGN_NOT);
                args = not_f_Inc.getArgs();
                args.addAll(domain_args);
                args.add(Inc);

                ALMTerm neg_f_I = new ALMTerm(f_name, ALMTerm.FUN);
                neg_f_I.setSign(ALMTerm.SIGN_NEG);
                args = neg_f_I.getArgs();
                args.addAll(domain_args);
                args.add(I);

                ALMTerm neg_f_Inc = new ALMTerm(f_name, ALMTerm.FUN);
                neg_f_Inc.setSign(ALMTerm.SIGN_NEG);
                args = neg_f_Inc.getArgs();
                args.addAll(domain_args);
                args.add(Inc);

                ALMTerm not_neg_f_Inc = new ALMTerm(f_name, ALMTerm.FUN);
                not_neg_f_Inc.setSign(ALMTerm.SIGN_NOT_NEG);
                args = not_neg_f_Inc.getArgs();
                args.addAll(domain_args);
                args.add(Inc);

                if (!f.isBoolean()) {
                    // Unique Assignment Constraint only applies to non-boolean functions. 
                    // :- f(X1..Xn, V, I), f(X1..Xn, V2, I), V != V2.
                    ALMTerm f_V2_I = new ALMTerm(f_name, ALMTerm.FUN);
                    f_V2_I.getArgs().addAll(domain_args);
                    f_V2_I.addArg(V2);
                    f_V2_I.addArg(I);
                    body = new ArrayList<>();
                    body.add(f_V_I);
                    body.add(f_V2_I);
                    body.add(V_not_V2);
                    r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, null, body);
                    r.addComment("Unique Assignment Constraint for modeling non-boolean functions using relations.");
                }

                if (f.isBoolean()) {
                    // f(X1..Xn, I+1) :- f(X1..Xn, I), not -f(X1..Xn, I+1), dom_f(X1...Xn, I+1).
                    body = new ArrayList<>();
                    body.add(f_I);
                    body.add(not_neg_f_Inc);
                    body.add(dom_f_Inc);
                    r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, f_Inc, body);
                    r.addComment("Law Of Inertia for positive boolean function [" + f_name + "].");

                    // -f(X1..Xn, I+1) :- -f(X1..Xn, I), not f(X1..Xn, I+1), dom_f(X1...Xn, I+1). 
                    body = new ArrayList<>();
                    body.add(neg_f_I);
                    body.add(not_f_Inc);
                    body.add(dom_f_Inc);
                    r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, neg_f_Inc, body);
                    r.addComment("Law Of Inertia for negative boolean function [" + f_name + "].");
                } else {
                    // f(X1..Xn, V, I+1) :- f(X1..Xn,V, I), not f(X1..Xn, V2, I+1), V != V2, dom_f(X1...Xn, I+1).
                    body = new ArrayList<>();
                    body.add(f_V_I);
                    body.add(not_f_V2_Inc);
                    body.add(V_not_V2);
                    body.add(dom_f_Inc);
                    r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, f_V_Inc, body);
                    r.addComment("Law Of Inertia for non-boolean function [" + f_name + "].");
                }

                ALMTerm dom_f_I = new ALMTerm(dom_f_name, ALMTerm.FUN);
                dom_f_I.getArgs().addAll(domain_args);
                dom_f_I.addArg(I);

                if (f.isBoolean()) {
                    // dom_f(X1..Xn, I) :- f(X1..Xn,I).
                    body = new ArrayList<>();
                    body.add(f_I);
                    r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, dom_f_I, body);
                    r.addComment("Definition of positive boolean function [" + dom_f_name + "].");

                    // dom_f(X1..Xn, I) :- -f(X1..Xn,I).
                    body = new ArrayList<>();
                    body.add(neg_f_I);
                    r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, dom_f_I, body);
                    r.addComment("Definition of negative boolean function [" + dom_f_name + "].");
                } else {
                    // dom_f(X1..Xn, I) :- f(X1..Xn,V,I).
                    body = new ArrayList<>();
                    body.add(f_V_I);
                    r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, dom_f_I, body);
                    r.addComment("Definition of positive non-boolean function [" + dom_f_name + "].");
                }

                // // -dom_f(X1..Xn, I) :- not dom_f(X1 .. Xn, I).
                // body = new ArrayList<>();
                // ALMTerm not_dom_f_I = new ALMTerm(dom_f_name, ALMTerm.FUN);
                // not_dom_f_I.setSign(ALMTerm.SIGN_NOT);
                // args = not_dom_f_I.getArgs();
                // args.addAll(domain_args);
                // args.add(I);
                // body.add(not_dom_f_I);
                // r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, neg_dom_f_I, body);
                // r.addComment("Definition of negative [" + dom_f_name + "] (Closed World
                // Assumption).");
                // dom_f(X1..Xn, I+1) :- dom_f(X1..Xn, I), not -dom_f(X1..Xn, I+1).
                body = new ArrayList<>();
                body.add(dom_f_I);
                ALMTerm not_neg_dom_f_Inc = new ALMTerm(dom_f_name, ALMTerm.FUN);
                not_neg_dom_f_Inc.setSign(ALMTerm.SIGN_NOT_NEG);
                args = not_neg_dom_f_Inc.getArgs();
                args.addAll(domain_args);
                args.add(Inc);
                body.add(not_neg_dom_f_Inc);
                r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, dom_f_Inc, body);
                r.addComment("Law Of Inertia for positive [" + dom_f_name + "].");

                // -dom_f(X1..Xn, I+1) :- -dom_f(X1..Xn,I), not dom_f(X1..Xn, I+1).
                body = new ArrayList<>();
                ALMTerm neg_dom_f_Inc = new ALMTerm(dom_f_name, ALMTerm.FUN);
                neg_dom_f_Inc.setSign(ALMTerm.SIGN_NEG);
                args = neg_dom_f_Inc.getArgs();
                args.addAll(domain_args);
                args.add(Inc);
                ALMTerm neg_dom_f_I = new ALMTerm(dom_f_name, ALMTerm.FUN);
                neg_dom_f_I.setSign(ALMTerm.SIGN_NEG);
                args = neg_dom_f_I.getArgs();
                args.addAll(domain_args);
                args.add(I);
                body.add(neg_dom_f_I);
                ALMTerm not_dom_f_Inc = new ALMTerm(dom_f_name, ALMTerm.FUN);
                not_dom_f_Inc.setSign(ALMTerm.SIGN_NOT);
                args = not_dom_f_Inc.getArgs();
                args.addAll(domain_args);
                args.add(Inc);
                body.add(not_dom_f_Inc);
                r = tm.newSPARCRule(ALM.RULES_FLUENT_FUNCTIONS, neg_dom_f_Inc, body);
                r.addComment("Law Of Intertia for negated [" + dom_f_name + "].");
            }
        }
    }

    private static void FinalProgramDynamicCausalLaws(SPARCProgram tm, SymbolTable st, ASPfProgram aspf) {
        // all rules are dynamic since it has actions.
        tm.createSection(ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS);
        for (ASPfRule ar : aspf.getRules(ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS)) {
            TranslateRule(ar, st, tm, ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS);
        }
    }

    private static void FinalProgramExecutabilityConditions(SPARCProgram tm, SymbolTable st, ASPfProgram aspf) {
        // all rules are dynamic since it has actions.
        tm.createSection(ALM.AXIOMS_EXECUTABILITY_CONDITIONS);
        for (ASPfRule ar : aspf.getRules(ALM.AXIOMS_EXECUTABILITY_CONDITIONS)) {
            TranslateRule(ar, st, tm, ALM.AXIOMS_EXECUTABILITY_CONDITIONS);
        }
    }

    private static void FinalProgramStateConstraints(SPARCProgram tm, SymbolTable st, ASPfProgram aspf) {
        // Not All State Constraints have fluents. Only the state constraints with
        // fluents are added.
        tm.createSection(ALM.AXIOMS_STATE_CONSTRAINTS_FLUENT);
        for (ASPfRule ar : aspf.getRules(ALM.AXIOMS_STATE_CONSTRAINTS)) {
            if (ar.hasFluentFunction(st)) {
                // basic static functions are the only functions that need to be translated now
                TranslateRule(ar, st, tm, ALM.AXIOMS_STATE_CONSTRAINTS_FLUENT);
            }
        }
    }

    private static void FinalProgramDefinitions(SPARCProgram tm, SymbolTable st, ASPfProgram aspf) {
        // Not All definitions have fluents. Only the state constraints with fluents are
        // added.
        tm.createSection(ALM.AXIOMS_DEFINITIONS_FLUENT);
        for (ASPfRule ar : aspf.getRules(ALM.AXIOMS_DEFINITIONS)) {
            if (ar.hasFluentFunction(st)) {
                // basic static functions are the only functions that need to be translated now
                TranslateRule(ar, st, tm, ALM.AXIOMS_DEFINITIONS_FLUENT);
            }
        }
    }

    /**
     * Translates the observed history into rules of the program.
     *
     * @param tm SPARCProgram that rules from facts of history will be added to.
     * @param st The SymbolTable of the ALMCompiler.
     * @param aspf The ASPf Program containing the History section parsed from
     * the system description.
     */
    private static void CreateHistory(SPARCProgram tm, SymbolTable st, ASPfProgram aspf, ErrorReport er) {
        //Create Sort For All Fluent Functions
        SPARCSort fluents_sort = new SPARCSort(ALM.SORT_FLUENT_FUNCTIONS);
        for (FunctionEntry fluent : st.getFluentFunctions()) {
            ALMTerm functor = new ALMTerm(fluent.getFunctionName(), ALMTerm.FUN);
            List<SortEntry> sig = fluent.getSignature();
            int len = sig.size();
            for (int i = 0; i < len - 1; i++) {
                SortEntry sorti = sig.get(i);
                functor.addArg(new ALMTerm(sorti.getSortName(), ALMTerm.ID));
            }
            fluents_sort.addInstance(functor);
        }
        try {
            tm.addSPARCSort(fluents_sort);
        } catch (SPARCSortAlreadyDefined e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Creating History",
                    "Incompatible Fluent Sort name.  This should never happen.");
        }

        //Create Sort For Booleans
        SPARCSort booleans_sort;
        try {
            booleans_sort = tm.getSPARCSort(ALM.SORT_BOOLEANS);
        } catch (SPARCSortNotDefined e) {
            booleans_sort = new SPARCSort(ALM.SORT_BOOLEANS);
            booleans_sort.addInstance(new ALMTerm(ALM.BOOLEAN_TRUE, ALMTerm.ID));
            booleans_sort.addInstance(new ALMTerm(ALM.BOOLEAN_FALSE, ALMTerm.ID));
            tm.getSorts().add(0, booleans_sort);
        }
        try {
            SPARCSort universe = tm.getSPARCSort(ALM.SORT_UNIVERSE);
            universe.union(booleans_sort);
        } catch (SPARCSortNotDefined e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Creating History",
                    "Universe Sort Undefined.  This should never happen.");
        }

        //Create Observed Predicate Declaration. 
        SPARCPredicate observed_predicate = new SPARCPredicate(ALM.HISTORY_OBSERVED);
        try {
            observed_predicate.addSPARCSort(fluents_sort);
            observed_predicate.addSPARCSort(tm.getSPARCSort(ALM.SORT_UNIVERSE));
            observed_predicate.addSPARCSort(tm.getSPARCSort(ALM.SORT_TIMESTEP));
            tm.addSPARCPredicate(observed_predicate);

            //Create Happened Predicate Declaration.
            SPARCPredicate happened_predicate = new SPARCPredicate(ALM.HISTORY_HAPPENED);
            happened_predicate.addSPARCSort(tm.getSPARCSort(ALM.SORT_ACTIONS));
            happened_predicate.addSPARCSort(tm.getSPARCSort(ALM.SORT_TIMESTEP));
            tm.addSPARCPredicate(happened_predicate);
        } catch (SPARCSortNotDefined | PredicateAlreadyDeclared e) {
            ALMCompiler.IMPLEMENTATION_FAILURE("Creating History", "Retrieving fundamental sorts. ");
        }
        /*
         * Due to the signatures of observed and happened, the automatic grounding of the rules in OMEGA would create
         * unnecessary instances of the rules. This implementation only adds ground versions of the rules in Definition
         * 15 based on the actual history provided in GAMMA.
         */
        //PART 1 (actions) occurs(a,i) <-- happened(a,i),
        //PART 2 (non-boolean): f(t, 0) = v <-- observed(f(t), v, 0)  for all non-boolean fluent functions f.
        //PART 2 (positive-boolean): f(t, 0) <-- observed(f(t), true, 0)  for all boolean fluent functions f.
        //PART 2 (negative-boolean): -f(t, 0) <-- observed(f(t), false, 0)  for all boolean fluent functions f.
        //PART 3 (non-boolean): <-- observed(f(t), v, i), dom_f(t, i), f(t, i) != v.
        //PART 3 (positive-boolean): <-- observed(f(t), true, i), dom_f(t, i), -f(t, i).
        //PART 3 (negative-boolean): <-- observed(f(t), false, i), dom_f(t, i), f(t, i). 

        //Definition of common variables and ALMTerms.
        SPARCRule r;
        List<SPARCLiteral> body;

        for (ASPfRule history_rule : aspf.getRules(ALM.HISTORY)) {
            ALMTerm head = history_rule.getHead().toALMTerm();

            body = new ArrayList<>();
            body.add(head);

            if (ALM.HISTORY_HAPPENED.equals(head.getName())) {
                //GAMMA contains happened(a, i).  Add fact to final program. 
                r = tm.newSPARCRule(ALM.HISTORY_GAMMA_ACTION_OCCURRENCES, head, null);

                //DEFINITION 15 PART 1: OMEGA contains rules occurs(a, i) :- happened(a,i).
                ALMTerm A = head.getArg(0);
                ALMTerm I = head.getArg(1);
                ALMTerm occurs = new ALMTerm(ALM.SPECIAL_FUNCTION_OCCURS, ALMTerm.FUN, A, I);
                r = tm.newSPARCRule(ALM.HISTORY_OMEGA_ACTION_OCCURRENCES, occurs, body);
                r.addComment("History Translation to create occurrences of actions that happened.");
            } else if (ALM.HISTORY_OBSERVED.equals(head.getName())) {
                //GAMMA contains observed(f(t), v, I). 
                ALMTerm f = head.getArg(0);
                ALMTerm v = head.getArg(1);
                ALMTerm I = head.getArg(2);

                //verify I is an integer. 
                int i = 0;
                try {
                    i = Integer.parseInt(I.toString());
                } catch (NumberFormatException ex) {
                    ALMCompiler.IMPLEMENTATION_FAILURE("Processing History",
                            "Need Semantic Error for when time variable is not an integer.");
                }

                //verify f resolves to a fluent function entry. 
                String f_name = f.getName();
                int num_args = f.getArgs().size();
                FunctionEntry fe = st.getFunctionEntry(f_name, num_args);
                if (fe == null) {
                    ALMCompiler.IMPLEMENTATION_FAILURE("Processing History",
                            "Need semantic error indicating that function is not recognized.");
                } else if (!fe.isFluent()) {
                    ALMCompiler.IMPLEMENTATION_FAILURE("Processing History",
                            "Need semantic error indicating that funtion is not fluent.");
                }

                //check if observation is of initial condition or a later constraint. 
                if (i == 0) {
                    //GAMMA contains observed(f(args), v, 0). Add fact to final program. 
                    r = tm.newSPARCRule(ALM.HISTORY_GAMMA_INTIAL_OBSERVATIONS, head, null);

                    //DEFINITION 15 PART 2: OMEGA contains f(args, 0) = v <-- observed(f(args), v, 0). 
                    //Boolean translation requires adding proper sign to f. 
                    if (fe.isBoolean()) {
                        //boolean, translate to: sign(v) f(args, 0) <-- observed(f(args), v, 0).
                        ALMTerm f_0 = new ALMTerm(f.getName(), ALMTerm.FUN);
                        f_0.getArgs().addAll(f.getArgs());
                        f_0.addArg(I);
                        if (v.getName().equals(ALM.BOOLEAN_FALSE)) {
                            f_0.setSign(ALMTerm.SIGN_NEG);
                        } else if (!v.getName().equals(ALM.BOOLEAN_TRUE)) { //semantic error when boolean fluent assigned non-bool value. 
                            ALMCompiler.IMPLEMENTATION_FAILURE("Processing History",
                                    "Need semantic error indicating that a boolean is not assigned true or false.");
                        } //no sign to add if boolean value is true.  
                        r = tm.newSPARCRule(ALM.HISTORY_OMEGA_INTIAL_OBSERVATIONS, f_0, body);
                        r.addComment("History translation for initial observation of boolean fluent");
                    } else {
                        //non-boolean create term constraint at head: f(args, v, 0) <-- observed(f(args), v, 0). 
                        ALMTerm f_ext = new ALMTerm(f.getName(), ALMTerm.FUN);
                        f_ext.getArgs().addAll(f.getArgs());
                        f_ext.addArg(v);
                        f_ext.addArg(I);

                        r = tm.newSPARCRule(ALM.HISTORY_OMEGA_INTIAL_OBSERVATIONS, f_ext, body);
                        r.addComment("History translation for initial observation of non-boolean fluent");
                    }

                } else {
                    //GAMMA contains observed(f(args), v, t) where t> 0, add fact to final program. 
                    r = tm.newSPARCRule(ALM.HISTORY_GAMMA_NON_INTIAL_OBSERVATIONS, head, null);

                    //DEFINITION 15 PART 3: OMEGA contains <-- observed(f(args), v, I), dom_f(args, I),  f(args, I) != v. 
                    ALMTerm f_I = new ALMTerm(f.getName(), ALMTerm.FUN);
                    f_I.getArgs().addAll(f.getArgs());
                    f_I.addArg(I);

                    ALMTerm dom_f_I = new ALMTerm(ALM.DOM_PREFIX + f.getName(), ALMTerm.FUN);
                    dom_f_I.getArgs().addAll(f.getArgs());
                    dom_f_I.addArg(I);

                    body.add(dom_f_I);
                    if (fe.isBoolean()) {
                        //boolean case <-- observed(f(args), v, I), dom_f(args, I),  flipped_sign(v) f(args, I). 
                        if (v.getName().equals(ALM.BOOLEAN_TRUE)) {
                            f_I.setSign(ALMTerm.SIGN_NEG);
                        } else if (!v.getName().equals(ALM.BOOLEAN_FALSE)) {
                            f_I.setSign(ALMTerm.SIGN_NOT_NEG);
                        } else {
                            ALMCompiler.IMPLEMENTATION_FAILURE("Processing History",
                                    "Need semantic error that a boolean fluent is not assigned true or false.");
                        } // when v = false, no sign to add to f. 
                        body.add(f_I);
                        r = tm.newSPARCRule(ALM.HISTORY_OMEGA_NON_INTIAL_OBSERVATIONS, null, body);
                        r.addComment("HISTORY: " + head.toString());
                    } else {
                        //non boolean case : <-- observed(f(args), v, I), dom_f(args, I),  not f(args, v, I). 
                        ALMTerm f_ext = new ALMTerm(f.getName(), ALMTerm.FUN);
                        f_ext.getArgs().addAll(f.getArgs());
                        f_ext.addArg(v);
                        f_ext.addArg(I);

                        f_ext.setSign(ALMTerm.SIGN_NOT);

                        body.add(f_ext);
                        r = tm.newSPARCRule(ALM.HISTORY_OMEGA_NON_INTIAL_OBSERVATIONS, null, body);
                        r.addComment("HISTORY: " + head.toString());
                    }
                }
            } else {
                ALMCompiler.IMPLEMENTATION_FAILURE("Processing History",
                        "This is likely a syntax error, otherwise we need semantic error for unrecognized "
                        + "literal in the history section.");
            }
        }
    }

    //    private static void LoadFactsFromPreModelAnswerSet(SPARCProgram tm, AnswerSet as, ALMCompilerSettings s) {
    //        tm.createSection(ALM.OPTIMIZATION_ADD_FACTS_FROM_PRE_MODEL_ANSWERSET);
    //        if (s.OptimizationAddAllFactsFromPreModelAnswerset())
    //           for (List<ALMTerm> lits : as.getAllAlmTerms())
    //                for (ALMTerm lit : lits)
    //                    tm.newSPARCRule(ALM.OPTIMIZATION_ADD_FACTS_FROM_PRE_MODEL_ANSWERSET, lit, null);
    //        else {
    //            SPARCRule dummy = tm.newSPARCRule(ALM.OPTIMIZATION_ADD_FACTS_FROM_PRE_MODEL_ANSWERSET, null, null);
    //            dummy.addComment("This optimization is turned off.");
    //        }
    //    }
    // THIS WAS TOO NAIVE. NEED TO FILTER OUT FACTS THAT ARE DEFINED ON SORT INSTANCES THAT ARE NO LONGER IN SORTS IN THE 
    // FINAL PROGRAM. 
    /**
     * *
     *
     * @param ar
     * @param body (the new body)
     * @param st
     * @return (the head of the rule)
     *
     * This function is the meat of the endeavor. Based on the type of literal
     * there are different translations case: function at top subcase: static
     * boolean function -- no change subcase: fluent boolean function -- add
     * time dimension at end of predicate. case: term relation replace each type
     * of function occurrence in the term with a variable. Add a new literal to
     * the body with the variable added and a time component if it is basic.
     */
    private static void TranslateRule(ASPfRule ar, SymbolTable st, SPARCProgram pm, String section) {
        String timestep = ar.newVariable("TS");
        boolean hasFluentFunction = false;

        String timeAdd = "+1";
        switch (section) {
            case ALM.AXIOMS_STATE_CONSTRAINTS_FLUENT:
                timeAdd = "";
                break;
        }

        TypeChecker tc = ar.getTypeChecker();
        if (tc == null) {
            tc = new TypeChecker(st);
        }

        // Translate HEAD
        SPARCLiteral head = null;
        ASPfLiteral ahead = ar.getHead();
        if (ahead != null) {
            ALMTerm thead = (ALMTerm) ahead;
            if (thead.hasFluentFunction(st)) {
                hasFluentFunction = true;
            }
            switch (thead.getType()) {
                case ALMTerm.FUN:
                    FunctionEntry f = null;
                    //translating only happens without any errors, no need for an ErrorReport here. 
                    f = st.getFunctionEntry(thead.getName(), thead.getArgs().size());
                    if (f != null) {
                        if (!f.isBoolean()) {
                            ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule", "Non Boolean Function ["
                                    + f.getFunctionName() + "] must be in a Term Relation at head of rule");
                        }
                        // Should be caught by semantic error.  
                        if (f.isStatic()) {
                            head = thead;
                        } else if (f.isFluent()) {
                            // construct corresponding sparc literal
                            head = new_SPARCLiteral_Boolean_Fluent(thead.getSign(), f, thead.getArgs(), timestep + timeAdd);
                        } else {
                            ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                    "Non Static Or Fluent Function [" + f.getFunctionName() + " at head of rule");
                        }
                        // Should never happen
                    } else {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                "Function  [" + thead.toString() + "] Is Not In The Symbol Table");
                        // Should be caught by semantic error.
                    }
                    break;
                case ALMTerm.TERM_RELATION:
                    // must be = or != relation with function on left and variable or ID on right.
                    ALMTerm left = thead.getArg(0);
                    ALMTerm right = thead.getArg(1);
                    if (thead.getName() != ALM.SYMBOL_EQ && thead.getName() != ALM.SYMBOL_NEQ) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                "Term relation at head of rule must be = or !=");
                    }
                    // Should be caught by syntax error.
                    // if(right.getType() != ALMTerm.ID && right.getType() != ALMTerm.VAR)//the
                    // object constant can be occur on the right and it is fun
                    // PROGRAM_FAILURE("Translate Rule", "Right hand side of term relation must be
                    // ID or VAR in head of rule.");
                    // Should be caught by syntax error.
                    if (left.getType() != ALMTerm.FUN) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                "Only a function can appear on the left hand side of a term relation at the head of a rule.");
                    }
                    // Should be caught by syntax error.
                    FunctionEntry ft;
                    //translating only happens without any errors, no need for an ErrorReport here. 
                    ft = st.getFunctionEntry(left.getName(), left.getArgs().size());
                    if (ft != null) {
                        if (ft.isBoolean()) {
                            ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                    "Boolean Function cannot be in a Term Relation at head of rule");
                        }
                        // Should be caught by semantic error.
                        if (ft.isStatic()) {
                            head = new_SPARCLiteral_NonBoolean_Static(ft, left.getArgs(), right);
                        } else if (ft.isFluent()) {
                            head = new_SPARCLiteral_NonBoolean_Fluent(ft, left.getArgs(), right, timestep + "+1");
                        } else // Should never happen
                        {
                            ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                    "Non Static Or Fluent Function [" + ft.getFunctionName() + "] at head of rule");
                        }
                        // need to determine sign of the predicate
                        if (thead.getName() == ALM.SYMBOL_NEQ) {
                            ((ALMTerm) head).setSign(ALMTerm.SIGN_NEG);
                        }
                    } else {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                "Function  [" + left.toString() + "] Is Not In The Symbol Table");
                        // Should be caught by semantic error.
                    }
                    break;
                default:
                    ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                            "Head [" + thead.toString() + "] existed in ASPF but could not create head for SPARC");
            }
        }

        // END CONSTRUCTION OF HEAD LITERAL
        // START CONSTRUCTION OF BODY
        List<SPARCLiteral> body = null;
        List<ASPfLiteral> abody = ar.getBody();
        if (abody != null && abody.size() > 0) {
            body = new ArrayList<SPARCLiteral>();
            for (ASPfLiteral alit : abody) {
                ALMTerm tlit = (ALMTerm) alit;
                switch (tlit.getType()) {
                    case ALMTerm.FUN:
                        FunctionEntry f;
                        //translating only happens without any errors, no need for an ErrorReport here. 
                        f = st.getFunctionEntry(tlit.getName(), tlit.getArgs().size());
                        if (f != null) {
                            if (!f.isBoolean()) {
                                ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule", "Non Boolean Function ["
                                        + tlit.toString() + "] must be in a Term Relation in body of rule");
                            }
                            // Should be caught by semantic error.
                            if (f.isStatic()) {
                                body.add(tlit);
                            } else if (f.isFluent()) {
                                // construct corresponding sparc literal
                                body.add(new_SPARCLiteral_Boolean_Fluent(tlit.getSign(), f, tlit.getArgs(), timestep));
                            } else {
                                ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                        "Non Static Or Fluent Function [" + f.getFunctionName() + "] in body of rule");
                            }
                            // Should never happen
                        } else {
                            ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                    "Function  [" + tlit.toString() + "] Is Not In The Symbol Table");
                            // Should be caught by semantic error.
                        }
                        break;
                    case ALMTerm.TERM_RELATION:
                        // A term relation can have any number of functions occurring inside of them
                        // Each function occurrence shall be replaced with a new variable and a new literal
                        // for the function is added to the body tying the new variable to the value of the
                        // function occurrence. This will be done with recursion to construct a brand new
                        // term relation that is free of all function occurrences.
                        ALMTerm new_term_relation = TranslateTermRelation(tlit, body, st, tc, timestep);
                        body.add(new_term_relation);
                        break;
                    default:
                        ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                                "Could Not Translate Literal [" + tlit.toString() + "] from ASPf in body of rule");
                }
            }

        }

        SPARCRule r = pm.newSPARCRule(section, head, body);
        r.copyComments(ar);
        if (hasFluentFunction) {
            r.addComment(timestep + " is the Time Step Variable.");
        }
    }

    private static ALMTerm TranslateTermRelation(ALMTerm tlit, List<SPARCLiteral> body, SymbolTable st, TypeChecker tc,
            String timestep) {
        ALMTerm termRelation = new ALMTerm(tlit.getName(), ALMTerm.TERM_RELATION);
        termRelation.addArg(TranslateTerm(tlit.getArg(0), body, st, tc, timestep));
        termRelation.addArg(TranslateTerm(tlit.getArg(1), body, st, tc, timestep));
        return termRelation;
    }

    /**
     * Returns the Normalized ALMTerm to be added to a SPARC program after
     * translating it from the intermediate ALMTerm representation. Function
     * terms are replaced by variables in the containing term and a new term
     * constraint is added to the body which binds the new variable to the
     * translated normalization of the nested term.
     *
     * @param term The ALMTerm to be translated.
     * @param body The body of rules that is accumulating the translation.
     * @param st The symbol table, used to retrieve the function associated with
     * the term.
     * @param tc The type checker for the rule, used to create new variables
     * within the body of the rule.
     * @param timestep The timestep variable to use for fluents.
     * @return The translated and normalized version of the outermost ALMTerm in
     * 'term'.
     */
    private static ALMTerm TranslateTerm(ALMTerm term, List<SPARCLiteral> body, SymbolTable st, TypeChecker tc,
            String timestep) {
        switch (term.getType()) {
            case ALMTerm.FUN:
                FunctionEntry f;
                f = st.getFunctionEntry(term.getName(), term.getArgs().size());
                if (f != null) {
                    //Determine pattern of variables to use in this rule.  
                    String new_var_base = f.getFunctionName().substring(0, 1).toUpperCase() + "O";
                    // Get New Variable
                    ALMTerm new_var = new ALMTerm(tc.newVariable(new_var_base), ALMTerm.VAR);
                    // Need To Add the Function To the Body of the rule we are constructing;
                    if (f.isBoolean()) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Translate Term", "Boolean function ["
                                + f.getQualifiedFunctionName() + "] is occurring nested within a term");
                    }
                    if (f.isStatic()) {
                        body.add(new_SPARCLiteral_NonBoolean_Static(f, term.getArgs(), new_var));
                    } else if (f.isFluent()) {
                        body.add(new_SPARCLiteral_NonBoolean_Fluent(f, term.getArgs(), new_var, timestep));
                    } else {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Translate Term",
                                "Could not create sparc literal for term [" + term.toString() + "]");
                    }
                    // return the variable as the function's replacement.
                    return new_var;
                } else {
                    ALMCompiler.IMPLEMENTATION_FAILURE("Translate Rule",
                            "Term  [" + term.toString() + "] Is Not In The Symbol Table");
                    // Should be caught by semantic error.
                }
            default:
                ALMTerm copy = new ALMTerm(term.getName(), term.getType());
                if (term.getArgs() != null) {
                    for (ALMTerm arg : term.getArgs()) {
                        copy.addArg(TranslateTerm(arg, body, st, tc, timestep));
                    }
                }
                return copy;
        }
    }

    private static SPARCLiteral new_SPARCLiteral_NonBoolean_Static(FunctionEntry f, List<ALMTerm> args, ALMTerm range) {
        ALMTerm slit = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
        if (args != null) {
            for (ALMTerm arg : args) {
                slit.addArg(arg);
            }
        }
        slit.addArg(range);
        return slit;
    }

    private static SPARCLiteral new_SPARCLiteral_Boolean_Fluent(String sign, FunctionEntry f, List<ALMTerm> args,
            String timestep) {
        ALMTerm slit = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
        if (args != null) {
            for (ALMTerm arg : args) {
                slit.addArg(arg);
            }
        }
        slit.addArg(new ALMTerm(timestep, ALMTerm.ID));
        return slit;
    }

    private static SPARCLiteral new_SPARCLiteral_NonBoolean_Fluent(FunctionEntry f, List<ALMTerm> args, ALMTerm range,
            String timestep) {
        ALMTerm slit = new ALMTerm(f.getQualifiedFunctionName(), ALMTerm.FUN);
        if (args != null) {
            for (ALMTerm arg : args) {
                slit.addArg(arg);
            }
        }
        slit.addArg(range);
        slit.addArg(new ALMTerm(timestep, ALMTerm.ID));
        return slit;
    }

}
