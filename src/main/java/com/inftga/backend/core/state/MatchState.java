package com.inftga.backend.core.state;

import com.inftga.backend.config.Config;
import com.inftga.backend.core.Field.ELineType;
import com.inftga.backend.core.Field.Field;
import com.inftga.backend.core.Field.Pos;
import com.inftga.backend.core.Player.EPlayer;


import com.inftga.backend.core.Player.Player;
import com.inftga.backend.core.card.Card;
import com.inftga.backend.core.deck.Deck;
import com.inftga.backend.core.hand.Hand;

import java.util.Optional;

public class MatchState {

    private Deck deckP1;
    private Deck deckP2;

    private Hand handP1;
    private Hand handP2;

    private Field field = new Field();

    private EPlayer turn;

    private int turns = 0;

/*    public MatchState(Deck deckP1, Deck deckP2){
        this.deckP1 = deckP1;
        this.deckP2 = deckP2;
    }*/

    public MatchState(Player player1, Player player2, EPlayer firstTurn){
        //TODO: copy Deck!!
        this.deckP1 = player1.getDeckClone();
        this.deckP2 = player2.getDeckClone();
        this.turn = firstTurn;
    }

    public void nextTurn(){
        turn = turn.getEnemy();
        turns++;
    }

    public Optional<Card> takeNewCard(EPlayer p){
        Deck d = getDeck(p);
        Hand h = getHand(p);

        Optional<Card> c = d.getCard();
        if(c.isPresent()){
            h.addCard(c.get());
            d.removeCard();
        }
        return c;
    }


    public void placeCardFromHandToField(Card card, ELineType l,EPlayer p, int i){
        Hand h = getHand(p);
        if(h.includes(card)){
            if(field.isFree(l,p,i)){
               putCardOnField(card, l, p, i);
               removeCardFromHand(card,p);
            }
        }
    }

    public void removeCardFromHand(Card card, EPlayer p){
        Hand h = getHand(p);
        h.removeCard(card);
    }

    public void putCardOnField(Card card, ELineType l,EPlayer p, int i){
        if(field.isFree(l,p,i)){
            field.putCardAt(card,l,p,i);
        }
    }


    //getter
    public Optional<Card> getCardAt(Pos pos){
        return field.getCardAt(pos);
    }


    public Hand getHand(EPlayer p){
        if(EPlayer.P1.equals(p)){
            return handP1;
        }
        return handP2;
    }

    public Deck getDeck(EPlayer p){
        if(EPlayer.P1.equals(p)){
            return deckP1;
        }
        return deckP2;
    }


}
