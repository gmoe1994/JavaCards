package no.hiof.thomasjg.Model.TypeOfGames;

import no.hiof.thomasjg.Model.Card;
import no.hiof.thomasjg.Model.Game;
import no.hiof.thomasjg.Model.Player;

import java.util.ArrayList;

public class WarConsole extends Game {
    private ArrayList<Card> thomas = new ArrayList<>();
    private ArrayList<Card> elon = new ArrayList<>();
    public WarConsole(){
        super();
    }



    @Override
    public void start(){
        deck.shuffleDeck();
        addPlayer("Thomas");
        addPlayer("Elon");
        while(!deck.isEmpty()) {
            for (Player player : players) {
                player.draw(deck, 1);
            }
        }


        while(winner == null){


            thomas.add(this.getPlayer("Thomas").drawFromHand());
            elon.add(this.getPlayer("Elon").drawFromHand());

            System.out.println("Thomas draws: ");
            thomas.get(0).illustrateASCIICards();
            System.out.println("\nElon draws: ");
            elon.get(0).illustrateASCIICards();

            if (Player.calculateValueOfCards(thomas) > Player.calculateValueOfCards(elon)){
                thomas.add(elon.get(0));
                this.getPlayer("Thomas").addCardsToHand(thomas);
                thomas.clear();
                elon.clear();
                System.out.println("\nThomas has highest card\n");
            }

            else if (Player.calculateValueOfCards(thomas) < Player.calculateValueOfCards(elon)){
                elon.add(thomas.get(0));
                this.getPlayer("Elon").addCardsToHand(elon);
                elon.clear();
                thomas.clear();
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
                return;
            }
            else{
                System.out.println("Thomas does not have enough cards to go to war\nElon is the winner");
                winner = this.getPlayer("Elon");
                return;
            }
        }
        thomas.addAll(this.getPlayer("Thomas").drawFromHand(4));
        elon.addAll(this.getPlayer("Elon").drawFromHand(4));

        System.out.println("\nThomas draws: ");
        thomas.get(thomas.size() -1).illustrateASCIICards();
        System.out.println("\nElon draws: ");
        elon.get(elon.size() -1).illustrateASCIICards();
        if (thomas.get(thomas.size() -1).getValue() > elon.get(elon.size() -1).getValue()){
            for(Card card: elon){
                thomas.add(card);
            }
            elon.clear();
            this.getPlayer("Thomas").addCardsToHand(thomas);
            thomas.clear();
            System.out.println("\nThomas wins the war\n");
        }

        else if (thomas.get(thomas.size() -1).getValue() < elon.get(elon.size() -1).getValue()){
            for(Card card: thomas){
                elon.add(card);
            }
            thomas.clear();
            this.getPlayer("Elon").addCardsToHand(elon);
            elon.clear();
            System.out.println("\nElon wins the war\n");
        }
        else {
            itsWar();
        }
    }
}
