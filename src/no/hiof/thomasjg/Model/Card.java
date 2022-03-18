package no.hiof.thomasjg.Model;

import java.util.Map;

import static java.util.Map.entry;

public class Card {
    // Put in IGameType implementation?
    final public Map<Value, Integer> values = Map.ofEntries(
    entry(Value.TWO,2),
    entry(Value.THREE,3),
    entry(Value.FOUR,4),
    entry(Value.FIVE,5),
    entry(Value.SIX,6),
    entry(Value.SEVEN,7),
    entry(Value.EIGHT,8),
    entry(Value.NINE,9),
    entry(Value.TEN,10),
    entry(Value.JACK,11),
    entry(Value.QUEEN,12),
    entry(Value.KING,13),
    entry(Value.ACE,14));
    private final Value value;
    private final Suit suit;

    enum Suit{
        HEARTS,
        SPADES,
        CLUBS,
        DIAMONDS
    }

    enum Value{
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }



    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public void illustrateCards(){

    }

}
