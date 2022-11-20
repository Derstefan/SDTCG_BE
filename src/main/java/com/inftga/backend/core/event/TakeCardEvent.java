package com.inftga.backend.core.event;

import com.inftga.backend.core.Player.EPlayer;
import com.inftga.backend.core.card.Card;

public class TakeCardEvent extends Event{

    private EPlayer p;
    private Card c;

    public TakeCardEvent(EPlayer p, Card c){
        super();
        this.p=p;
        this.c=c;
    }
}
