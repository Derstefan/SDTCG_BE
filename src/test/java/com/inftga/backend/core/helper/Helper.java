package com.inftga.backend.core.helper;

import com.inftga.backend.config.Config;
import com.inftga.backend.core.card.Card;
import com.inftga.backend.core.deck.Deck;

import java.util.ArrayList;

public class Helper {

    public static Card getRandomCardInstance(){
        return new Card();
    }

    public static Deck getRandomDeckInstance(){
        ArrayList<Card> cards = new ArrayList<>();
        for(int i=0;i< Config.DECK_MIN_SIZE;i++){
            cards.add(getRandomCardInstance());
        }
        return new Deck(cards);
    }
}
