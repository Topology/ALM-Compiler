package edu.ttu.krlab.alm.datastruct.sparc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.datastruct.LogicProgramArtifact;

public class SPARCProgram extends LogicProgramArtifact {

    private List<SPARCSort> sorts;
    private Map<String, SPARCSort> sortmap;
    private List<SPARCPredicate> predicates;
    private Map<String, SPARCPredicate> predbyname;
    private Map<String, List<SPARCRule>> rules;
    private Comparator<String> sectionComparer;

    private class SectionComparator implements Comparator<String> {

        private Map<String, Integer> rank;

        public SectionComparator() {

            rank = new HashMap<String, Integer>();
            rank.put(ALM.SPECIAL_FUNCTION_LINK, 100);
            rank.put(ALM.SPECIAL_FUNCTION_IS_A, 101);
            rank.put(ALM.SPECIAL_FUNCTION_INSTANCE, 102);
            rank.put(ALM.SPECIAL_FUNCTION_SUBSORT, 103);
            rank.put(ALM.SPECIAL_FUNCTION_HAS_PARENT, 104);
            rank.put(ALM.SPECIAL_FUNCTION_HAS_CHILD, 105);
            rank.put(ALM.SPECIAL_FUNCTION_SOURCE, 106);
            rank.put(ALM.SPECIAL_FUNCTION_SINK, 107);
            rank.put(ALM.RULES_STATIC_FUNCTIONS, 200);
            rank.put(ALM.AXIOMS_STATE_CONSTRAINTS_STATIC, 300);
            rank.put(ALM.AXIOMS_DEFINITIONS_STATIC, 301);
            rank.put(ALM.STRUCTURE_CONSTANT_DEFINITIONS, 400);
            rank.put(ALM.STRUCTURE_SORT_INSTANCES, 401);
            rank.put(ALM.STRUCTURE_ATTRIBUTE_DEFINITIONS, 402);
            rank.put(ALM.STRUCTURE_STATIC_FUNCTION_DEFINITIONS, 403);
            rank.put(ALM.RULES_FLUENT_FUNCTIONS, 1000);
            rank.put(ALM.AXIOMS_DYNAMIC_CAUSAL_LAWS, 1010);
            rank.put(ALM.AXIOMS_EXECUTABILITY_CONDITIONS, 1020);
            rank.put(ALM.AXIOMS_STATE_CONSTRAINTS_FLUENT, 1030);
            rank.put(ALM.AXIOMS_DEFINITIONS_FLUENT, 1040);
            rank.put(ALM.HISTORY, 10000);
            rank.put(ALM.HISTORY_GAMMA_INTIAL_OBSERVATIONS, 10001);
            rank.put(ALM.HISTORY_GAMMA_NON_INTIAL_OBSERVATIONS, 10002);
            rank.put(ALM.HISTORY_GAMMA_ACTION_OCCURRENCES, 10003);
            rank.put(ALM.HISTORY_OMEGA_INTIAL_OBSERVATIONS, 10004);
            rank.put(ALM.HISTORY_OMEGA_NON_INTIAL_OBSERVATIONS, 10005);
            rank.put(ALM.HISTORY_OMEGA_ACTION_OCCURRENCES, 10006);
            rank.put(ALM.SOLVER_MODE_PP, 20000);
            rank.put(ALM.SKIP_TRANSLATION_RULES, 30000);
            rank.put(ALM.CR_RULES, 50000);
            rank.put(ALM.OPTIMIZATION_ADD_FACTS_FROM_PRE_MODEL_ANSWERSET, 100000);
        }

        @Override
        public int compare(String arg0, String arg1) {
            try {
                return rank.get(arg0) - rank.get(arg1);
            } catch (Exception ex) {
                ex.printStackTrace();
                ALMCompiler.IMPLEMENTATION_FAILURE("rank undefined", arg0 + " or " + arg1 + " is undefined.");
                return -1;
            }
        }

    }

    public SPARCProgram() {
        sorts = new ArrayList<SPARCSort>();
        sortmap = new HashMap<String, SPARCSort>();
        predicates = new ArrayList<SPARCPredicate>();
        predbyname = new HashMap<String, SPARCPredicate>();
        rules = new HashMap<String, List<SPARCRule>>();
    }

    public List<SPARCSort> getSorts() {
        return sorts;
    }

    public void setSorts(List<SPARCSort> sorts) {
        this.sorts = sorts;
    }

    public List<SPARCPredicate> getPredicates() {
        return predicates;
    }

    public SPARCSort getSPARCSort(String sortName) throws SPARCSortNotDefined {

        if (!sortmap.containsKey(sortName)) {
            throw new SPARCSortNotDefined(sortName);
        }

        return sortmap.get(sortName);
    }

    public void addSPARCSort(SPARCSort psort) throws SPARCSortAlreadyDefined {
        String sortname = psort.getSortName();
        if (sortmap.containsKey(sortname)) {
            throw new SPARCSortAlreadyDefined(sortname);
        }
        //safe to add
        sorts.add(psort);
        sortmap.put(sortname, psort);
    }

    @Override
    public void writeTo(BufferedWriter out) throws IOException {
        if (out == null) {
            return;
        }
        super.writeTo(out);
        out.write("% Automatically Generated By ALM Translator " + ALMCompiler.VERSION + ".\n");
        out.write("\n\nsorts\n\n");

        for (SPARCSort sort : sorts) {
            sort.writeTo(out);
        }

        out.write("\n\npredicates\n\n");

        for (SPARCPredicate pred : predicates) {
            pred.writeTo(out);
        }

        out.write("\n\nrules\n\n");

        List<String> sortedSections = SortSections(rules.keySet());

        int length = sortedSections.size();
        for (int i = 0; i < length; i++) {

            String sect = sortedSections.get(i);

            out.write("%---------------------\n");
            out.write("%-- Section: " + sect + "\n");
            out.write("%---------------------\n\n");
            List<SPARCRule> sect_rules = rules.get(sect);
            if (sect_rules.size() == 0) {
                out.write("% There are no rules in this section.\n\n");
            } else {
                for (SPARCRule rule : sect_rules) {
                    rule.writeTo(out);
                }
            }
        }

        out.write("% END OF PROGRAM\n");
        out.flush();
    }

    private List<String> SortSections(Collection<String> section_names) {
        List<String> sections = new ArrayList<String>();
        sections.addAll(section_names);
        Collections.sort(sections, getSectionComparator());
        return sections;
    }

    private Comparator<String> getSectionComparator() {
        if (sectionComparer == null) {
            sectionComparer = new SectionComparator();
        }
        return sectionComparer;
    }

    public void addSPARCPredicate(SPARCPredicate pred) throws PredicateAlreadyDeclared {
        String pred_name = pred.getPredicateName();
        if (this.predbyname.containsKey(pred_name)) {
            throw new PredicateAlreadyDeclared(pred_name);
        }

        this.predicates.add(pred);
        this.predbyname.put(pred_name, pred);

    }

    public SPARCPredicate getPredicate(String functionName) {
        return this.predbyname.get(functionName);
    }

    public void createSection(String section) {
        List<SPARCRule> section_rules = rules.get(section);
        if (section_rules == null) {
            section_rules = new ArrayList<SPARCRule>();
            rules.put(section, section_rules);
        }
    }

    public SPARCRule newSPARCRule(String section, SPARCLiteral head, List<SPARCLiteral> body) {
        SPARCRule rule = new SPARCRule(head, body);
        List<SPARCRule> section_rules = rules.get(section);
        if (section_rules == null) {
            section_rules = new ArrayList<SPARCRule>();
            rules.put(section, section_rules);
        }
        section_rules.add(rule);
        return rule;
    }

    public SPARC_CR_Rule newSPARC_CR_Rule(String section, SPARCLiteral head, List<SPARCLiteral> body) {
        SPARC_CR_Rule rule = new SPARC_CR_Rule(head, body);
        List<SPARCRule> section_rules = rules.get(section);
        if (section_rules == null) {
            section_rules = new ArrayList<SPARCRule>();
            rules.put(section, section_rules);
        }
        section_rules.add(rule);
        return rule;
    }

    public void copyRulesSections(SPARCProgram pm) {
        for (String section : pm.rules.keySet()) {
            this.rules.put(section, pm.rules.get(section));
        }
    }

    public void removeSPARCSortWithName(String name) {
        SPARCSort matching = null;
        for (SPARCSort sort : sorts) {
            if (sort.getSortName().equals(name)) {
                matching = sort;
            }
        }
        if (matching != null) {
            sorts.remove(matching);
            sortmap.remove(name);
        }
    }

    public void removePredicatesContaining(String text) {
        Set<SPARCPredicate> matching = new HashSet<>();
        for (SPARCPredicate pred : predicates) {
            if (pred.toString().contains(text)) {
                matching.add(pred);
            }
        }
        for (SPARCPredicate pred : matching) {
            predicates.remove(pred);
        }
    }

    public void removeRulesContaining(String text) {
        //must remove per section. 
        for (Map.Entry<String, List<SPARCRule>> sectionEntry : rules.entrySet()) {
            Set<SPARCRule> matching = new HashSet<>();
            List<SPARCRule> ruleList = sectionEntry.getValue();
            for (SPARCRule rule : ruleList) {
                if (rule.toString().contains(text)) {
                    matching.add(rule);
                }
            }
            for (SPARCRule rule : matching) {
                ruleList.remove(rule);
            }
        }
    }
}
