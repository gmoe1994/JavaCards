package no.hiof.thomasjg.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
        for(Card card: deck){
            card.illustrateASCIICards();
        }
    }

    // Fisher-yates shuffle algorithm
    public void shuffleDeck(){
        Random r = new Random();
        for (int i = deck.size()-1; i > 0; i--) {
            int j = r.nextInt(i+1);
            Collections.swap(deck, i, j);
        }
    }



 }
