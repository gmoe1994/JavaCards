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

    public void illustrateASCIICards(){
        Suit suit = this.suit;
        Value value = this.value;
        String ascii;
        String valueString;
        switch (suit){
            case CLUBS -> ascii = "♣";
            case HEARTS -> ascii = "♥";
            case SPADES -> ascii = "♠";
            case DIAMONDS -> ascii = "♦";
            default -> throw new IllegalStateException("Unexpected value: " + suit);
        }
        switch (value){
            case TWO -> valueString = "2";
            case THREE -> valueString = "3";
            case FOUR -> valueString = "4";
            case FIVE -> valueString = "5";
            case SIX -> valueString = "6";
            case SEVEN -> valueString = "7";
            case EIGHT -> valueString = "8";
            case NINE -> valueString = "9";
            case TEN -> valueString = "10";
            case JACK -> valueString = "Jack";
            case QUEEN -> valueString = "Queen";
            case KING -> valueString = "King";
            case ACE -> valueString = "Ace";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        System.out.printf(" %s%s ", ascii, valueString);

    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                '}';
    }
}
