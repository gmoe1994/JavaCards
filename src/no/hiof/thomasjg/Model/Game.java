package no.hiof.thomasjg.Model;

import java.util.ArrayList;

// Make class to represent builder design?
public class Game {
    protected ArrayList<Player> players = new ArrayList<>();
    protected Player winner = null;
    // private static IGameType game; //singleton?
    protected Deck deck = new Deck();

    public Game(){
    }


    public void addPlayer(String name){
        players.add(new Player(name));
    }

    public Player getPlayer(String name) {
        for(Player player: players){
            if (player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }


    public void resultOfRound(){
        // iterates the players of the games, for each player the cards on hand are checked.
        // depending on the game the result of round is returned
        // Bridge pattern?

    }


    public void start(){
        // starts a game loop with this game instance as configuration for the game of choice
        // might configure all this and type of game in main instead?
    }

}
