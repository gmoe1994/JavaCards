package no.hiof.thomasjg.Model;

import no.hiof.thomasjg.Model.TypeOfGames.IGameType;

import java.util.ArrayList;

// Make class to represent builder design?
public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> lastResult = new ArrayList<>();
    private String nameOfTheGame;
    private Player winner;
    private static IGameType game; //singleton?

    public Game(IGameType game){
        Game.game = game;
    }
    // has to be singleton, else constructor cannot recognise which class to call?

    public Game(String name){
        this.nameOfTheGame = name;
        // used if you want to make the game in main, without creating a IGameType
    }

    public void addPlayer(Player player){
        // adds a player to the game, player has to be instantiated beforehand
    }

    public void addPlayer(String name){
        // creates a player and adds it to the game
    }


    public static void resultOfRound(){
        // iterates the players of the games, for each player the cards on hand are checked.
        // depending on the game the result of round is returned
        // Bridge pattern?
        game.result();

    }

    public void resultOfRound(IGameType game){
        game.result();
    }

//    public Player resultOfGame(IGameType typeOfGame){
//        // return the player who is the winner of the game
//    }


    public void start(IGameType typeOfGame){
        // starts a game loop with this game instance as configuration for the game of choice
        // might configure all this and type of game in main instead?
    }

}
