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
        addPlayer("Thomas");
        addPlayer("Elon");
        dealAllCards();


        while(winner == null){


            Card thomas = this.getPlayer("Thomas").drawFromHand();
            Card elon = this.getPlayer("Elon").drawFromHand();

            System.out.println("Thomas draws: ");
            thomas.illustrateASCIICards();
            System.out.println("\nElon draws: ");
            elon.illustrateASCIICards();

            if (thomas.getValue() > elon.getValue()){
                this.getPlayer("Thomas").addCardToHand(thomas);
                this.getPlayer("Thomas").addCardToHand(elon);
                System.out.println("\nThomas has highest card\n");
            }

            else if (thomas.getValue() < elon.getValue()){
                this.getPlayer("Elon").addCardToHand(elon);
                this.getPlayer("Elon").addCardToHand(thomas);
                System.out.println("\nElon has highest card\n");
            }

            else {
                itsWar();
            }

            if(this.getPlayer("Thomas").isHandsEmpty() || this.getPlayer("Elon").isHandsEmpty()){
                if (this.getPlayer("Thomas").calculateValueOfCards() > this.getPlayer("Elon").calculateValueOfCards()){
                    System.out.println("Elon is out of cards\nThomas is the winner");
                    winner = this.getPlayer("Thomas");
                }
                else {
                    System.out.println("Thomas is out of cards\nElon is the winner");
                    winner = this.getPlayer("Elon");
                }

            }

        }

    }
    public void itsWar(){
        System.out.println("\nIt's war");
        if (this.getPlayer("Thomas").cardsOnHand() < 4 || this.getPlayer("Elon").cardsOnHand() < 4){
            if(this.getPlayer("Thomas").cardsOnHand() > this.getPlayer("Elon").cardsOnHand()){
                System.out.println("Elon does not have enough cards to go to war\nThomas is the winner");
                winner = this.getPlayer("Thomas");
            }
            else{
                System.out.println("Thomas does not have enough cards to go to war\nElon is the winner");
                winner = this.getPlayer("Elon");
            }
            return;
        }
        ArrayList<Card> cardsToWinFromWar = new ArrayList<>();
        cardsToWinFromWar.addAll(this.getPlayer("Elon").drawFromHand(3));
        cardsToWinFromWar.addAll(this.getPlayer("Thomas").drawFromHand(3));

        Card thomas = this.getPlayer("Thomas").drawFromHand();
        Card elon = this.getPlayer("Elon").drawFromHand();

        System.out.println("Thomas draws: ");
        thomas.illustrateASCIICards();
        System.out.println("\nElon draws: ");
        elon.illustrateASCIICards();
        if (thomas.getValue() > elon.getValue()){
            this.getPlayer("Thomas").addCardsToHand(cardsToWinFromWar);
            this.getPlayer("Thomas").addCardToHand(elon);
            this.getPlayer("Thomas").addCardToHand(thomas);
            System.out.println("\nThomas wins the war\n");
        }

        else if (thomas.getValue() < elon.getValue()){
            this.getPlayer("Elon").addCardsToHand(cardsToWinFromWar);
            this.getPlayer("Elon").addCardToHand(elon);
            this.getPlayer("Elon").addCardToHand(thomas);
            System.out.println("\nElon wins the war\n");
        }
        else {
            itsWar();
        }
    }
}
