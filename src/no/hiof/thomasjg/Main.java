package no.hiof.thomasjg;

import no.hiof.thomasjg.Model.*;
import no.hiof.thomasjg.Model.TypeOfGames.War;

public class Main {


    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleDeck();
        Player player1 = new Player("Thomas");

        player1.draw(deck, 2);
        player1.showCards();
    }
}
