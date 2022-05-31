package no.hiof.thomasjg.Model.TypeOfGames;

import no.hiof.thomasjg.Model.Betting.BlackjackDeck;
import no.hiof.thomasjg.Model.Betting.Dealer;
import no.hiof.thomasjg.Model.Game;

import java.util.Objects;
import java.util.Scanner;

public class Blackjack extends Game {
    Dealer dealer = new Dealer("dealer");



    public Blackjack(){
        super();
        this.deck = new BlackjackDeck();
    }


    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your nickname: ");
        String playerName = scanner.nextLine();
        addPlayer(playerName);
        deck.shuffleDeck();

        while(winner == null){
            Scanner betScanner = new Scanner(System.in);
            System.out.println("how much would you like to bet: ");
            int bet = betScanner.nextInt();

            this.takeBet(this.getPlayer(playerName), bet);
            this.getPlayer(playerName).draw(this.deck, 2);
            System.out.printf("%s has: \n", playerName);
            this.getPlayer(playerName).showCards();

            dealer.draw(this.deck, 2);
            System.out.println("Dealer has: ");
            dealer.showCards();

            if ((this.getPlayer(playerName).calculateValueOfCards() == 21) && (dealer.calculateValueOfCards() < 21)){
                System.out.println("You got blackjack, you win!");
                givePotToPlayer(this.getPlayer(playerName));
                winner = this.getPlayer(playerName);
            }
            else if ((dealer.calculateValueOfCards()) == 21 && (this.getPlayer(playerName).calculateValueOfCards() < 21)){
                System.out.println("Dealer got blackjack, you lose");
                winner = dealer;
                table.cleanTable();
            }

            while (this.getPlayer(playerName).calculateValueOfCards() < 21){
                System.out.println("to HIT press y, to STAND hit n");
                Scanner choice = new Scanner(System.in);

                if(Objects.equals(choice.nextLine(), "y")){
                    this.getPlayer(playerName).draw(this.deck, 1);
                    System.out.printf("%s now has: \n", playerName);
                    this.getPlayer(playerName).showCards();

                    if(this.getPlayer(playerName).calculateValueOfCards() > 21){
                        break;
                    }
                }
                else break;
            }

            while (dealer.calculateValueOfCards() < 16) {
                dealer.draw(this.deck, 1);
                System.out.println("Dealer now has: ");
                dealer.showCards();
            }

            if (dealer.calculateValueOfCards() > 21 && this.getPlayer(playerName).calculateValueOfCards() < 21){
                System.out.printf("%s wins the round!\n", playerName);
                givePotToPlayer(this.getPlayer(playerName));
                winner = this.getPlayer(playerName);
            }
            else if ((dealer.calculateValueOfCards() < 21) && (this.getPlayer(playerName).calculateValueOfCards() > 21)){
                System.out.println("Dealer wins!");
                winner = dealer;
            }

            else if((this.getPlayer(playerName).calculateValueOfCards() > dealer.calculateValueOfCards()) && (this.getPlayer(playerName).calculateValueOfCards() <= 21)){
                System.out.printf("%s wins the round!\n", playerName);
                givePotToPlayer(this.getPlayer(playerName));
                winner = this.getPlayer(playerName);
            }
            else if ((this.getPlayer(playerName).calculateValueOfCards() < dealer.calculateValueOfCards()) && (dealer.calculateValueOfCards() <= 21)){
                System.out.println("Dealer wins!");
                winner = dealer;
            }
            else {
                System.out.println("It's a draw!");
                givePotToPlayer(this.getPlayer(playerName));
            }

        }


    }

}
