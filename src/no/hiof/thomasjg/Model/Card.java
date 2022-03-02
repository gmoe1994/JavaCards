package no.hiof.thomasjg.Model;

import java.util.Map;

import static java.util.Map.entry;

public class Card {
    // Put in IGameType implementation?
    final public Map<Integer, Value> values = Map.ofEntries(
    entry(2, Value.TWO),
    entry(3, Value.THREE),
    entry(4, Value.FOUR),
    entry(5, Value.FIVE),
    entry(6, Value.SIX),
    entry(7,  Value.SEVEN),
    entry(8, Value.EIGHT),
    entry(9, Value.NINE),
    entry(10, Value.TEN),
    entry(11, Value.JACK),
    entry(12, Value.QUEEN),
    entry(13, Value.KING),
    entry(14, Value.ACE));
    private Value value;
    private Suit suit;

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
