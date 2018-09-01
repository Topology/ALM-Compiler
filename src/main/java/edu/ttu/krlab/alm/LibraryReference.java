/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ttu.krlab.alm;

import java.util.Objects;

/**
 *
 * @author Topology
 */
public class LibraryReference {

    private final String library;
    private final String theory;
    private final String module;

    public LibraryReference(String library, String theory, String module) {
        this.library = library;
        this.theory = theory;
        this.module = module;
    }

    public String getLibrary() {
        return library;
    }

    public String getTheory() {
        return theory;
    }

    public String getModule() {
        return module;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.library);
        hash = 17 * hash + Objects.hashCode(this.theory);
        hash = 17 * hash + Objects.hashCode(this.module);
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
        final LibraryReference other = (LibraryReference) obj;
        if (!Objects.equals(this.library, other.library)) {
            return false;
        }
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
        return "LibraryReference{" + "library=" + library + ", theory=" + theory + ", module=" + module + '}';
    }
}
