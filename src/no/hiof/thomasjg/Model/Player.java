package no.hiof.thomasjg.Model;

import java.util.ArrayList;

public class Player {
    private String name;
    private int valueOfCards = 0;
    private ArrayList<Card> onHand = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public void draw(Deck deck, int amount){
        for (int i = 0; i < amount; i++) {
            onHand.add(deck.draw());
        }
    }

    public void showCards(){
        for (Card card: onHand){
            card.illustrateASCIICards();
        }
    }

    public void emptyHands(){
        onHand.clear();
    }

    public void calculateValueOfCards(){
        for (Card card: onHand){
            int value = card.values.get(card.getValue());
            valueOfCards += value;
        }
    }
}
