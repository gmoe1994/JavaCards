package no.hiof.thomasjg;

import no.hiof.thomasjg.Model.*;
import no.hiof.thomasjg.Model.TypeOfGames.War;

public class Main {


    public static void main(String[] args) {
        Game theGame = new Game(War.getInstance());
        theGame.addPlayer("player1");
        theGame.addPlayer("player2");
        theGame.start();

        Deck deck = new Deck();
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");



        boolean playing = true;
        while(playing){
            player1.draw(1);
            player2.draw(1);

            if(player1.onHand[-1] == player2.onHand[-1]){

                player1.draw(3);
                player2.draw(3);


            player1.showCards();
            player2.showCards();

            player1.calculateValueOfCards();
            player2.calculateValueOfCards();

            if(player1.valueOfCards > player2){
                // do this
                else
                    // do that
            }







        }
        // game.resultOfGame(War.getInstance());
    }
}
