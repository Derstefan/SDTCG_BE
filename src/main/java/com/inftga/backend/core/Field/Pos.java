package com.inftga.backend.core.Field;

import com.inftga.backend.core.Player.EPlayer;

public class Pos {

    private ELineType l;
    private EPlayer p;
    private int i;


    public Pos(ELineType l, EPlayer p, int i) {
        this.l = l;
        this.p = p;
        this.i = i;
    }

    public ELineType getL() {
        return l;
    }

    public EPlayer getP() {
        return p;
    }


    public int getI() {
        return i;
    }

}
