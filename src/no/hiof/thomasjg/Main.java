package no.hiof.thomasjg;

import no.hiof.thomasjg.Model.TypeOfGames.Blackjack;
import no.hiof.thomasjg.Model.TypeOfGames.WarSimulation;

public class Main {


    public static void main(String[] args) {
//        Deck deck = new Deck();
//        deck.shuffleDeck();
//        Player player1 = new Player("Thomas");
//        Player player2 = new Player("Thomas");
//
//        player1.drawFromHand();
//        player1.drawFromHand(2);
//
//        card.illustrateCard();
//
//        if (player1.calculateValueOfCards() > player2.calculateValueOfCards()){
//            //do this
//        }
//
//        deck.draw();
//        player1.draw(deck, 2);
//        player1.showCards();
//        System.out.println(player1.calculateValueOfCards());
//
//        Game game = new Game();
//        game.start();
//        game.addPlayer("Player1");
//        game.addPlayer("Player2");
//        game.start();
//        WarSimulation war = new WarSimulation();
//        war.start();
        Blackjack blackjack = new Blackjack();
        blackjack.start();

    }
}
