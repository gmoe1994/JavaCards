package no.hiof.thomasjg;

import no.hiof.thomasjg.Model.*;
import no.hiof.thomasjg.Model.TypeOfGames.War;
import no.hiof.thomasjg.Model.TypeOfGames.WarConsole;

public class Main {


    public static void main(String[] args) {
//        Deck deck = new Deck();
//        deck.shuffleDeck();
//        Player player1 = new Player("Thomas");
//
//        player1.draw(deck, 2);
//        player1.showCards();
//        System.out.println(player1.calculateValueOfCards());
        WarConsole war = new WarConsole();
        war.start();

    }
}
