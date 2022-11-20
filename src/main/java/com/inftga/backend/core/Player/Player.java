package com.inftga.backend.core.Player;


import com.inftga.backend.core.deck.Deck;

/**
 * Player class for a match.
 * That's why he has only one Deck.(It's not the stat but the complete collection of his cards.)
 *
 */
public class Player {

    /**
     * Type of Player for a Match. (P1 or P2)
     */
    private EPlayer playerType;

    /**
     * all of his cards, not the currecnt state of a match
     */
    private Deck completeDeck;


    private int gold = 0;

    private String name;


    public EPlayer getPlayerType() {
        return playerType;
    }

    public Deck getDeckClone() {
        return completeDeck.clone();
    }

    public String getName() {
        return name;
    }
}
