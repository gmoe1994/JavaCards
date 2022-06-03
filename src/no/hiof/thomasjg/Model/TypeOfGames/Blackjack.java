package no.hiof.thomasjg.Model.TypeOfGames;

import no.hiof.thomasjg.Model.Betting.BlackjackDeck;
import no.hiof.thomasjg.Model.Betting.Dealer;
import no.hiof.thomasjg.Model.Game;
import no.hiof.thomasjg.Model.Player;

import java.util.Objects;
import java.util.Scanner;

public class Blackjack extends Game {
    Dealer dealer = new Dealer("dealer");



    public Blackjack(){
        super();
        this.deck = new BlackjackDeck();
    }

    @Override
    public void givePotToPlayer(Player player) {
        player.addChips(player.getBet() * 2);
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

            takeBet(getPlayer(playerName), bet);
            getPlayer(playerName).draw(deck, 2);
            System.out.printf("%s has: \n", playerName);
            getPlayer(playerName).showCards();

            dealer.draw(deck, 2);
            System.out.println("Dealer has: ");
            dealer.showCards();

            if ((getPlayer(playerName).calculateValueOfCards() == 21) && (dealer.calculateValueOfCards() < 21)){
                System.out.println("You got blackjack, you win!");
                givePotToPlayer(getPlayer(playerName));
                winner = getPlayer(playerName);
            }
            else if ((dealer.calculateValueOfCards()) == 21 && (getPlayer(playerName).calculateValueOfCards() < 21)){
                System.out.println("Dealer got blackjack, you lose");
                winner = dealer;
                table.cleanTable();
            }

            while (getPlayer(playerName).calculateValueOfCards() < 21){
                System.out.println("to HIT press y, to STAND hit n");
                Scanner choice = new Scanner(System.in);

                if(Objects.equals(choice.nextLine(), "y")){
                    getPlayer(playerName).draw(deck, 1);
                    System.out.printf("%s now has: \n", playerName);
                    getPlayer(playerName).showCards();

                    if(getPlayer(playerName).calculateValueOfCards() > 21){
                        break;
                    }
                }
                else break;
            }

            while (dealer.calculateValueOfCards() < 16) {
                dealer.draw(deck, 1);
                System.out.println("Dealer now has: ");
                dealer.showCards();
            }

            if (dealer.calculateValueOfCards() > 21 && getPlayer(playerName).calculateValueOfCards() < 21){
                System.out.printf("%s wins the round!\n", playerName);
                givePotToPlayer(getPlayer(playerName));
                winner = getPlayer(playerName);
            }
            else if ((dealer.calculateValueOfCards() < 21) && (getPlayer(playerName).calculateValueOfCards() > 21)){
                System.out.println("Dealer wins!");
                winner = dealer;
            }

            else if((getPlayer(playerName).calculateValueOfCards() > dealer.calculateValueOfCards()) && (getPlayer(playerName).calculateValueOfCards() <= 21)){
                System.out.printf("%s wins the round!\n", playerName);
                givePotToPlayer(getPlayer(playerName));
                winner = getPlayer(playerName);
            }
            else if ((getPlayer(playerName).calculateValueOfCards() < dealer.calculateValueOfCards()) && (dealer.calculateValueOfCards() <= 21)){
                System.out.println("Dealer wins!");
                winner = dealer;
            }
            else {
                System.out.println("It's a draw!");
                givePotToPlayer(getPlayer(playerName));
            }

        }


    }

}
