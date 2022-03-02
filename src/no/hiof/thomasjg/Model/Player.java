package no.hiof.thomasjg.Model;

import java.util.ArrayList;

public class Player {
    private String name;
    private int valueOfCards;
    private ArrayList<Card> onHand = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public void draw(int amountToDraw){
        // draws a card from deck and adds it to onHand Array
    }

    public void showCards(){
        // iterates all cards on hand and calls  illustrateCard() method from Card class
    }

    public void emptyHands(){
        // empty the cards on hand. mostly used for new rounds or games.
    }

    public void calculateValueOfCards(){
        // calculates the number value of all cards on hand. And aggregates it to the ValueOfCards field.
    }
}
