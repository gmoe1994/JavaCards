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

    public Card drawFromHand(){
        return onHand.remove(0);
    }

    public ArrayList<Card> drawFromHand(int cards){
        ArrayList<Card> cardsToBeReturned = new ArrayList<>();
        for (int i = 0; i < cards; i++) {
            cardsToBeReturned.add(onHand.remove(0));
        }
        return cardsToBeReturned;
    }


    public void showCards(){
        for (Card card: onHand){
            card.illustrateASCIICards();
        }
    }

    public void emptyHands(){
        onHand.clear();
    }

    public int cardsOnHand(){
        return onHand.size();
    }

    public boolean isHandsEmpty(){
        return onHand.isEmpty();
    }

    public void addCardsToHand(ArrayList<Card> cards){
        onHand.addAll(cards);
    }

    public void addCardToHand(Card card){
        onHand.add(card);
    }

    public int calculateValueOfCards(){
        for (Card card: onHand){
            int value = card.getValue();
            valueOfCards += value;
        }
        return valueOfCards;
    }


    public static int calculateValueOfCards(ArrayList<Card> cards){
        int temp = 0;
        for (Card card: cards){
            int value = card.getValue();
            temp += value;
        }
        return temp;
    }

    public String getName() {
        return name;
    }


}
