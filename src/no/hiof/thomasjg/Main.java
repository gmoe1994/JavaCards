package no.hiof.thomasjg;

import no.hiof.thomasjg.Model.*;
import no.hiof.thomasjg.Model.TypeOfGames.War;

public class Main {


    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleDeck();
        Game game = new Game(War.getInstance());
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");



        boolean playing = true;
        while(playing){
            player1.draw(1);
            player2.draw(1);

//            if(player1.onHand[-1] == player2.onHand[-1]){
//                War.getInstance().warDraw();
//            }

            player1.showCards();
            player2.showCards();

            game.resultOfRound();




        }
        // game.resultOfGame(War.getInstance());
    }
}
