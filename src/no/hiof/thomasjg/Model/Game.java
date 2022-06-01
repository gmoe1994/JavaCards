package no.hiof.thomasjg.Model;

import no.hiof.thomasjg.Model.Betting.PileOfChips;

import java.util.ArrayList;


public class Game {
    protected ArrayList<Player> players = new ArrayList<>();
    protected Deck deck = new Deck();
    protected PileOfChips table = new PileOfChips(false);
    protected Player winner = null;

    /**
     * Constructor for creating a game
     */
    public Game(){
    }

    /**
     * Adds a new player to the game
     * @param name name of the player
     */
    public void addPlayer(String name){
        players.add(new Player(name));
    }

    /**
     * Adds an existing player to the game
     * @param player player to add
     */
    public void addPlayer(Player player){
        players.add(player);
    }

    /**
     * Selects player by name, for the purpose of using the methods from the player class
     * @param name name of player
     * @return Player
     */
    public Player getPlayer(String name) {
        for(Player player: players){
            if (player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }

    /**
     * Deals all the card distributed evenly on all players of the game
     */
    public void dealAllCardsToPlayers(){
        while(!deck.isEmpty()) {
            for (Player player : players)
                player.draw(deck, 1);
        }
    }

    /**
     * Calculates the value of an Arraylist with cards
     * @param cards cards to estimate value
     * @return value of cards
     */
    public static int calculateValueOfCards(ArrayList<Card> cards){
        int temp = 0;
        for (Card card: cards){
            int value = card.getValue();
            temp += value;
        }
        return temp;
    }

    /**
     * Takes chips out of players pileOfChips and lays it on the table as a bet
     * @param player player to place a bet
     * @param amount value of bet
     */
    public void takeBet(Player player, int amount){
        table.addChips(player.betChips(amount));
    }

    /**
     * Gives all the chips on table to a player, should be overridden for the specific game
     * @param player player to recieve pot
     */
    public void givePotToPlayer(Player player){
        player.addChips(table);
    }


    /**
     * Method to start a game loop
     * it's meant to be overridden
     */
    public void start(){}

}
