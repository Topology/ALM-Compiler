package edu.ttu.krlab.alm;

import edu.ttu.krlab.alm.parser.ALMParser.ModuleContext;

public class DuplicateModuleException extends Exception {

    ModuleContext modCtx;

    public DuplicateModuleException(ModuleContext modCtx) {
        this.modCtx = modCtx;
    }

    public ModuleContext getModuleContext() {
        return modCtx;
    }
}
