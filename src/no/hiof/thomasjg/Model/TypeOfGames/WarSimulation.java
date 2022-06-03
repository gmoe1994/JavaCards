package no.hiof.thomasjg.Model.TypeOfGames;

import no.hiof.thomasjg.Model.Card;
import no.hiof.thomasjg.Model.Game;
import no.hiof.thomasjg.Model.Player;

import java.util.ArrayList;

public class WarSimulation extends Game {
    public WarSimulation(){
        super();
    }



    @Override
    public void start(){
        deck.shuffleDeck();
        Player player = new Player("Arne");
        addPlayer("Thomas");
        addPlayer("Elon");
        dealAllCardsToPlayers();

        while(winner == null){
            Card thomas = getPlayer("Thomas").drawFromHand();
            Card elon = getPlayer("Elon").drawFromHand();
            System.out.println("Thomas draws: ");
            thomas.illustrateASCIICards();
            System.out.println("\nElon draws: ");
            elon.illustrateASCIICards();

            if (thomas.getValue() > elon.getValue()){
                getPlayer("Thomas").addCardToHand(thomas);
                getPlayer("Thomas").addCardToHand(elon);
                System.out.println("\nThomas has highest card\n");
            }

            else if (thomas.getValue() < elon.getValue()){
                getPlayer("Elon").addCardToHand(elon);
                getPlayer("Elon").addCardToHand(thomas);
                System.out.println("\nElon has highest card\n");
            }

            else {
                itsWar();
            }

            if(getPlayer("Thomas").isHandsEmpty() || getPlayer("Elon").isHandsEmpty()){
                if (getPlayer("Thomas").calculateValueOfCards() > getPlayer("Elon").calculateValueOfCards()){
                    System.out.println("Elon is out of cards\nThomas is the winner");
                    winner = getPlayer("Thomas");
                }
                else {
                    System.out.println("Thomas is out of cards\nElon is the winner");
                    winner = getPlayer("Elon");
                }

            }

        }

    }
    public void itsWar(){
        System.out.println("\nIt's war");
        if (getPlayer("Thomas").cardsOnHand() < 4 || getPlayer("Elon").cardsOnHand() < 4){
            if(this.getPlayer("Thomas").cardsOnHand() > getPlayer("Elon").cardsOnHand()){
                System.out.println("Elon does not have enough cards to go to war\nThomas is the winner");
                winner = getPlayer("Thomas");
            }
            else{
                System.out.println("Thomas does not have enough cards to go to war\nElon is the winner");
                winner = getPlayer("Elon");
            }
            return;
        }
        ArrayList<Card> cardsToWinFromWar = new ArrayList<>();
        cardsToWinFromWar.addAll(getPlayer("Elon").drawFromHand(3));
        cardsToWinFromWar.addAll(getPlayer("Thomas").drawFromHand(3));

        Card thomas = getPlayer("Thomas").drawFromHand();
        Card elon = getPlayer("Elon").drawFromHand();

        System.out.println("Thomas draws: ");
        thomas.illustrateASCIICards();
        System.out.println("\nElon draws: ");
        elon.illustrateASCIICards();
        if (thomas.getValue() > elon.getValue()){
            getPlayer("Thomas").addCardsToHand(cardsToWinFromWar);
            getPlayer("Thomas").addCardToHand(elon);
            getPlayer("Thomas").addCardToHand(thomas);
            System.out.println("\nThomas wins the war\n");
        }

        else if (thomas.getValue() < elon.getValue()){
            getPlayer("Elon").addCardsToHand(cardsToWinFromWar);
            getPlayer("Elon").addCardToHand(elon);
            getPlayer("Elon").addCardToHand(thomas);
            System.out.println("\nElon wins the war\n");
        }
        else {
            itsWar();
        }
    }
}
