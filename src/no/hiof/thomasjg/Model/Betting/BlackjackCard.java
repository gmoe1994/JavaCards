package no.hiof.thomasjg.Model.Betting;

import no.hiof.thomasjg.Model.Card;

import java.util.Map;

import static java.util.Map.entry;

public class BlackjackCard extends Card {
    public BlackjackCard(BlackjackCard.Suit suit, BlackjackCard.Value value) {
        super(suit, value);
        values = Map.ofEntries(
                entry(Value.TWO,2),
                entry(Value.THREE,3),
                entry(Value.FOUR,4),
                entry(Value.FIVE,5),
                entry(Value.SIX,6),
                entry(Value.SEVEN,7),
                entry(Value.EIGHT,8),
                entry(Value.NINE,9),
                entry(Value.TEN,10),
                entry(Value.JACK,10),
                entry(Value.QUEEN,10),
                entry(Value.KING,10),
                entry(Value.ACE,11));
    }

}
