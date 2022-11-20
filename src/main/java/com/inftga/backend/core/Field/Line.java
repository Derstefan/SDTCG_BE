package com.inftga.backend.core.Field;

import com.inftga.backend.config.Config;
import com.inftga.backend.core.Player.EPlayer;
import com.inftga.backend.core.card.Card;

import java.util.ArrayList;
import java.util.Optional;

public class Line {
    private ELineType type;
    private EPlayer player;

    private ArrayList<Optional<Card>> cards = new ArrayList<>();

    public Line( ELineType type, EPlayer player){
        this.type = type;
        this.player = player;
    }

    private void initLine(){
        // fill line with empty Optionals
        for(int i=0;i<Config.LINE_SIZE;i++){
            cards.add(Optional.empty());
        }
    }

    public Optional<Card> getCard(int index){
        return cards.get(index);
    }

    public boolean putCard(int index, Card card){
        if(cards.get(index).isEmpty()){
            cards.set(index,Optional.of(card));
            return true;
        }
        return false;
    }



    public boolean removeCard(int index){
        if(cards.get(index).isEmpty()){
            cards.set(index,Optional.empty());
            return true;
        }
        return false;
    }



    public ELineType getType() {
        return type;
    }

    public EPlayer getPlayer() {
        return player;
    }
}
