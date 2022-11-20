package com.inftga.backend.core.card;

import java.util.UUID;

public class Card {

    //match inside id (not from outside the Game)
    private final UUID uuid = UUID.randomUUID();

    private CardType cardType;

    public Card(){

    }

}
