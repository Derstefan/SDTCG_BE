package com.inftga.backend.core.Action;

import com.inftga.backend.core.Field.Pos;
import com.inftga.backend.core.Player.EPlayer;

public class PosToPosAction extends Action {

    private Pos fromPos;
    private Pos toPos;

    public PosToPosAction(EPlayer p, Pos fromPos, Pos toPos) {
        super(p);
        this.fromPos = fromPos;
        this.toPos = toPos;
    }

    public Pos getFromPos() {
        return fromPos;
    }

    public Pos getToPos() {
        return toPos;
    }
}
