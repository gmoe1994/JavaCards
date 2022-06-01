package no.hiof.thomasjg.Model;

import no.hiof.thomasjg.Model.Betting.Chips;
import no.hiof.thomasjg.Model.Betting.PileOfChips;

import java.util.ArrayList;

public class Player {
    private String name;
    private int valueOfCards = 0;
    private ArrayList<Card> onHand = new ArrayList<>();
    private PileOfChips chips = new PileOfChips(true);
    private int bet = 0;

    /**
     * Constructor which adds a player
     * The player will start with chips
     * @param name name of the player
     */
    public Player(String name){
        this.name = name;
    }

    /**
     * Constructor which adds a player with a desired amount of start chips
     * @param name name of the player
     * @param amountOfChips value of the total chips to add
     */
    public Player(String name, int amountOfChips){
        this.name = name;
        this.chips = new PileOfChips(amountOfChips);
    }

    /**
     * Draw cards from deck to add on players hands
     * @param deck deck to draw from
     * @param amount how many cards to draw
     */
    public void draw(Deck deck, int amount){
        for (int i = 0; i < amount; i++) {
            onHand.add(deck.draw());
        }
    }

    /**
     * Draw a card from players hand
     * @return the card drawn
     */
    public Card drawFromHand(){
        return onHand.remove(0);
    }

    /**
     * Draw cards from the players hand
     * @param amount how many cards to draw
     * @return Arraylist with the cards
     */
    public ArrayList<Card> drawFromHand(int amount){
        ArrayList<Card> cardsToBeReturned = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            cardsToBeReturned.add(onHand.remove(0));
        }
        return cardsToBeReturned;
    }


    /**
     * Prints the cards on players hand to console
     */
    public void showCards(){
        for (Card card: onHand){
            card.illustrateASCIICards();
        }
    }

    /**
     * remove cards from players hand
     */
    public void removeCardsFromHands(){
        onHand.clear();
    }

    /**
     * Counts how many cards is on a players hands
     * @return number of cards
     */
    public int cardsOnHand(){
        return onHand.size();
    }

    /**
     * Checks if there are any cards on players hands
     * @return boolean
     */
    public boolean isHandsEmpty(){
        return onHand.isEmpty();
    }

    /**
     * Add cards to players hand from an Arraylist
     * @param cards cards to add to hand
     */
    public void addCardsToHand(ArrayList<Card> cards){
        onHand.addAll(cards);
    }

    /**
     * Add a single card to hand
     * @param card card to add
     */
    public void addCardToHand(Card card){
        onHand.add(card);
    }

    /**
     * Add a certain amount of chips to a players pile of chips
     * @param amount amount to add
     */
    public void addChips(int amount){
        chips.addChips(amount);
    }

    /**
     * Add a pile of chips to a players hand
     * @param pot pile of chips to add
     */
    public void addChips(PileOfChips pot){
        this.chips.addChips(pot.returnChips());
    }

    /**
     * Place a bet of a certain amount from the players pile of chips
     * @param amount amount to bet
     * @return an Arraylist with the chips to bet
     */
    public ArrayList<Chips> betChips(int amount){
        bet = amount;
        return chips.placeBet(amount);
    }

    /**
     * Calculates the value of the cards on a players hand
     * @return value of cards on hand
     */
    public int calculateValueOfCards(){
        valueOfCards = 0;
        for (Card card: onHand){
            int value = card.getValue();
            valueOfCards += value;
        }
        return valueOfCards;
    }

    /**
     * Get the name of the player
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the value of the players placed bet
     * @return value of placed bet
     */
    public int getBet() {
        return bet;
    }
}
