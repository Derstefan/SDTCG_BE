package com.inftga.backend.core.Field;

import com.inftga.backend.core.Player.EPlayer;
import com.inftga.backend.core.card.Card;

import java.util.Optional;

public class Field {

    private Line backLineP1 = new Line(ELineType.BACK, EPlayer.P1);
    private Line frontLineP1 = new Line(ELineType.FRONT, EPlayer.P1);

    private Line frontLineP2 = new Line(ELineType.FRONT, EPlayer.P2);
    private Line backLineP2 = new Line(ELineType.BACK, EPlayer.P2);



    private Line getLine(ELineType l, EPlayer p){
        if(EPlayer.P1.equals(p)){
            if(ELineType.BACK.equals(l)){
                return backLineP1;
            }
            return frontLineP1;
        }
        if(ELineType.BACK.equals(l)){
            return backLineP2;
        }
        return frontLineP2;
    }

    public boolean isFree(ELineType l, EPlayer p, int i){
        return getLine(l,p).getCard(i).isEmpty();
    }

    public boolean isFree(Pos pos){
        return getLine(pos.getL(),pos.getP()).getCard(pos.getI()).isEmpty();
    }

    public Optional<Card> getCardAt(ELineType l, EPlayer p, int i){
        return getLine(l,p).getCard(i);
    }

    public Optional<Card> getCardAt(Pos pos){
        return getLine(pos.getL(),pos.getP()).getCard(pos.getI());
    }


    public boolean putCardAt(Card card,ELineType l, EPlayer p, int i){
        return getLine(l,p).putCard(i,card);
    }

    public boolean putCardAt(Card card,Pos pos){
        return getLine(pos.getL(),pos.getP()).putCard(pos.getI(),card);
    }

    public boolean removeCard(ELineType l, EPlayer p, int i){
        return getLine(l,p).removeCard(i);
    }

    public boolean removeCard(Pos pos){
        return getLine(pos.getL(),pos.getP()).removeCard(pos.getI());
    }
}
