package com.inftga.backend.core.hand;

import com.inftga.backend.core.card.Card;

import java.util.ArrayList;
import java.util.HashSet;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    public Card getCard(int index){
        return cards.get(index);
    }

    public boolean includes(Card card){
        if(cards.indexOf(card)!=-1){
            return true;
        }
        return false;
    }
}
