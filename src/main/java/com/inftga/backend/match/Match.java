package com.inftga.backend.match;

import com.inftga.backend.config.Config;
import com.inftga.backend.core.Action.Action;
import com.inftga.backend.core.Action.PosToPosAction;
import com.inftga.backend.core.Field.ELineType;
import com.inftga.backend.core.Player.EPlayer;
import com.inftga.backend.core.Player.Player;
import com.inftga.backend.core.card.Card;
import com.inftga.backend.core.event.PosToPosActionEvent;
import com.inftga.backend.core.event.EventHistroy;
import com.inftga.backend.core.event.PlaceCardEvent;
import com.inftga.backend.core.event.TakeCardEvent;
import com.inftga.backend.core.state.MatchState;

import java.util.Optional;
import java.util.UUID;

public class Match {

    private final UUID matchId = UUID.randomUUID();

    private MatchState matchState;

    private EventHistroy history = new EventHistroy();



    public Match(Player player1, Player player2){
        matchState = new MatchState(player1,player2,EPlayer.randomPlayer());

        init();
    }

    private void init(){
        // take the first Cards
        for(int i = 0; i< Config.HAND_START_SIZE; i++){
            takeNewCard(EPlayer.P1);
            takeNewCard(EPlayer.P2);
        }
    }


    //-----Game Controller
    public void takeNewCard(EPlayer p){
        Optional<Card> c = matchState.takeNewCard(p);

        history.addEvent(new TakeCardEvent(p,c.get()));
    }
    // ----- player Actions
    public void placeCard(EPlayer p,Card c, ELineType l, int i){
       matchState.placeCardFromHandToField(c,l,p,i);

       history.addEvent(new PlaceCardEvent(p,c,l,i));
    }

    public void doAction(Action action) {
        if(action instanceof PosToPosAction) {
            PosToPosAction a = (PosToPosAction) action;
            Optional<Card> c = matchState.getCardAt(a.getFromPos());
            if(c.isPresent()) {
                //do Action
                history.addEvent(new PosToPosActionEvent(c.get(),a.getFromPos(),a.getToPos()));
            }
        }
    }


}




