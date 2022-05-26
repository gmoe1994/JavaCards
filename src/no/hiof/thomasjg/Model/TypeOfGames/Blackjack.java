package no.hiof.thomasjg.Model.TypeOfGames;

import no.hiof.thomasjg.Model.Betting.Dealer;
import no.hiof.thomasjg.Model.Betting.PileOfChips;
import no.hiof.thomasjg.Model.Game;

import java.util.Objects;
import java.util.Scanner;

public class Blackjack extends Game {
    Dealer dealer = new Dealer("dealer");


    public Blackjack(){
        super();
    }


    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your nickname");
        String playerName = scanner.nextLine();
        addPlayer(playerName);

        while(winner == null){
            Scanner betScanner = new Scanner(System.in);
            System.out.println("how much would you like to bet: ");
            int bet = betScanner.nextInt();
            this.takeBet(this.getPlayer(playerName), bet);
            this.getPlayer(playerName).draw(this.deck, 2);
            this.getPlayer(playerName).showCards();
            dealer.draw(this.deck, 2);
            dealer.showCards();
            if (this.getPlayer(playerName).calculateValueOfCards() == 21){
                System.out.println("You got blackjack, you win!");
                this.getPlayer(playerName).addChips(table);
                winner = this.getPlayer(playerName);
            }
            else if (dealer.calculateValueOfCards() == 21){
                System.out.println("Dealer got blackjack, you lose");
                winner = dealer;
                table.cleanTable();
            }

            while (this.getPlayer(playerName).calculateValueOfCards() < 21){
                System.out.println("to HIT press y, to STAND hit n");
                Scanner choice = new Scanner(System.in);
                if(Objects.equals(choice.nextLine(), "y")){
                    this.getPlayer(playerName).draw(this.deck, 1);
                    this.getPlayer(playerName).showCards();
                }
                else break;
            }
            while (dealer.calculateValueOfCards() < 16){
                dealer.draw(this.deck, 1);
            }
            //TODO: finish game loop, fix if player gets over 21

        }


    }

    public void hitOrStand(){

    }
}
