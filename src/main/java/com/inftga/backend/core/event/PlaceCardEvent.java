package com.inftga.backend.core.event;

import com.inftga.backend.core.Field.ELineType;
import com.inftga.backend.core.Player.EPlayer;
import com.inftga.backend.core.card.Card;

public class PlaceCardEvent extends Event{
    private EPlayer p;
    private Card c;

    private ELineType l;

    private int i;

    public PlaceCardEvent(EPlayer p, Card c, ELineType l,int i){
        super();
        this.p=p;
        this.c=c;
        this.l=l;
        this.i=i;
    }
}
