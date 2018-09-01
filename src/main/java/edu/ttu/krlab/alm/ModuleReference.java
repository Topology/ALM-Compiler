/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ttu.krlab.alm;

import java.util.Objects;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 *
 * @author Topology
 */
public class ModuleReference {

    public static String ALL_MODULES = "*";

    private final String theory;
    private final String module;
    private final ParserRuleContext dependencyStatement;

    public ModuleReference(String theory, String module, ParserRuleContext dependencyStatement) {
        this.theory = theory;
        this.module = module;
        this.dependencyStatement = dependencyStatement;
    }

    public String getTheory() {
        return theory;
    }

    public String getModule() {
        return module;
    }

    public ParserRuleContext getDependencyStatement() {
        return dependencyStatement;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.theory);
        hash = 37 * hash + Objects.hashCode(this.module);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModuleReference other = (ModuleReference) obj;
        if (!Objects.equals(this.theory, other.theory)) {
            return false;
        }
        if (!Objects.equals(this.module, other.module)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuleReference{" + "theory=" + theory + ", module=" + module + '}';
    }

}
