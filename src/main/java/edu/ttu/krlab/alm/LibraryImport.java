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
public class LibraryImport {

    private final String importingTheory;
    private final LibraryReference importedLibrary;
    private final ParserRuleContext importStatement;

    public LibraryImport(String importingTheory, String importedLibrary, String importedTheory, String importedModule, ParserRuleContext importStatement) {
        this.importingTheory = importingTheory;
        this.importedLibrary = new LibraryReference(importedLibrary, importedTheory, importedModule);
        this.importStatement = importStatement;
    }

    public String getImportingTheory() {
        return importingTheory;
    }

    public String getImportedLibrary() {
        return importedLibrary.getLibrary();
    }

    public String getImportedTheory() {
        return importedLibrary.getTheory();
    }

    public String getImportedModule() {
        return importedLibrary.getModule();
    }

    public LibraryReference getLibraryReference() {
        return importedLibrary;
    }

    public ParserRuleContext getImportStatement() {
        return importStatement;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.importingTheory);
        hash = 31 * hash + Objects.hashCode(this.importedLibrary);
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
        final LibraryImport other = (LibraryImport) obj;
        if (!Objects.equals(this.importingTheory, other.importingTheory)) {
            return false;
        }
        if (!Objects.equals(this.importedLibrary, other.importedLibrary)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LibraryImport{" + "importingTheory=" + importingTheory + ", importedLibrary=" + importedLibrary + '}';
    }
}
