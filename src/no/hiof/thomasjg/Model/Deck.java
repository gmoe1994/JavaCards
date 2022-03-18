package no.hiof.thomasjg.Model;

import java.util.ArrayList;
// instantiate as singleton?
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        createDeck();
    }

    private void createDeck(){
        for (Card.Suit suit: Card.Suit.values()){
            for (Card.Value value: Card.Value.values())
                deck.add(new Card(suit, value));
        }
    }

    public void shuffleDeck(){

    }



 }
