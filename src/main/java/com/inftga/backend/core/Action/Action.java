package com.inftga.backend.core.Action;

import com.inftga.backend.core.Player.EPlayer;

public abstract class Action {
    private EPlayer p;

    public Action(EPlayer p) {
        this.p = p;
    }
}
