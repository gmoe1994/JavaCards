package no.hiof.thomasjg.Model;

import no.hiof.thomasjg.Model.Betting.PileOfChips;

import java.util.ArrayList;


public class Game {
    protected ArrayList<Player> players = new ArrayList<>();
    protected Deck deck = new Deck();
    protected PileOfChips table = new PileOfChips(false);
    protected Player winner = null;

    public Game(){
    }


    public void addPlayer(String name){
        players.add(new Player(name));
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Player getPlayer(String name) {
        for(Player player: players){
            if (player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }

    public void dealAllCardsToPlayers(){
        while(!deck.isEmpty()) {
            for (Player player : players)
                player.draw(deck, 1);
        }
    }

    public static int calculateValueOfCards(ArrayList<Card> cards){
        int temp = 0;
        for (Card card: cards){
            int value = card.getValue();
            temp += value;
        }
        return temp;
    }

    public void takeBet(Player player, int amount){
        table.addChips(player.betChips(amount));
    }

    public void givePotToPlayer(Player player){
        player.addChips(player.getBet());
    }

    public void clearTable(){
        table.cleanTable();
    }


    public void start(){
        // starts a game loop with this game instance as configuration for the game of choice
        // might configure all this and type of game in main instead?
    }

}
