package no.hiof.thomasjg.Model.Betting;

import no.hiof.thomasjg.Model.Deck;

public class BlackjackDeck extends Deck {

    @Override
    protected void createDeck(){
        for (int i = 0; i < 4; i++) {
            for (BlackjackCard.Suit suit: BlackjackCard.Suit.values()){
                for (BlackjackCard.Value value: BlackjackCard.Value.values())
                    deck.add(new BlackjackCard(suit, value));
            }
        }

    }

}
