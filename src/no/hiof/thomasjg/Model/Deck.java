package no.hiof.thomasjg.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {
    protected ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        createDeck();
    }

    /**
     * Adds one of each card to the deck, creating the deck.
     */
    protected void createDeck(){
        for (Card.Suit suit: Card.Suit.values()){
            for (Card.Value value: Card.Value.values())
                deck.add(new Card(suit, value));
        }
    }

    /**
     * Shuffles the deck using Fisher-yates shuffle algorithm
     */
    public void shuffleDeck(){
        Random r = new Random();
        for (int i = deck.size()-1; i > 0; i--) {
            int j = r.nextInt(51);
            Collections.swap(deck, i, j);
        }
    }

    /**
     * Checks if the deck is empty
     * @return true or false
     */
    public boolean isEmpty(){
        return deck.size() == 0;
    }

    /**
     * Draws one card from the deck
     * @return one Card
     */
    public Card draw(){
        return deck.remove(0);
    }



 }
