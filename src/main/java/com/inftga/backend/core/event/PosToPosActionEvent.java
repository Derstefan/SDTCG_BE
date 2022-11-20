package com.inftga.backend.core.event;

import com.inftga.backend.core.Field.Pos;
import com.inftga.backend.core.card.Card;

public class PosToPosActionEvent extends Event {

    private Card card;

    private Pos fromPos;
    private Pos toPos;


    public PosToPosActionEvent(Card card, Pos fromPos, Pos toPos) {
        this.card = card;
        this.fromPos = fromPos;
        this.toPos = toPos;
    }
}
