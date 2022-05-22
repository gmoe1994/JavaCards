package no.hiof.thomasjg.Model.Betting;

import java.util.ArrayList;

public class PileOfChips {
    private ArrayList<Chips> pile = new ArrayList<>();

    public PileOfChips() {
        addOneChips(20);
        addFiveChips(20);
        addTENChips(15);
        addTwentyFiveChips(10);
        addFiftyChips(10);
    }

    public PileOfChips(int amount){
        addChips(amount);
    }

    public void addOneChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(Chips.Value.ONE));
        }
    }

    public void addFiveChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(Chips.Value.FIVE));
        }
    }

    public void addTENChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(Chips.Value.TEN));
        }
    }

    public void addTwentyFiveChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(Chips.Value.TWENTY_FIVE));
        }
    }

    public void addFiftyChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(Chips.Value.FIFTY));
        }
    }

    public void addChips(int amount){
        int temp;
        addFiftyChips(amount/50);
        temp = amount % 50;
        addTwentyFiveChips(temp/25);
        temp = temp % 25;
        addTENChips(temp/10);
        temp = temp % 10;
        addFiveChips(temp/5);
        temp = temp % 5;
        addOneChips(temp);
    }

    public void addPot(ArrayList<Chips> pot){
        pile.addAll(pot);
    }

    public void betOneChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.remove(new Chips(Chips.Value.ONE));
        }
    }

    public void betFiveChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.remove(new Chips(Chips.Value.FIVE));
        }
    }

    public void betTENChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.remove(new Chips(Chips.Value.TEN));
        }
    }

    public void betTwentyFiveChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.remove(new Chips(Chips.Value.TWENTY_FIVE));
        }
    }

    public void betFiftyChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.remove(new Chips(Chips.Value.FIFTY));
        }
    }

    public void placeBet(int amount){
        int temp;
        betFiftyChips(amount/50);
        temp = amount % 50;
        betTwentyFiveChips(temp/25);
        temp = temp % 25;
        betTENChips(temp/10);
        temp = temp % 10;
        betFiveChips(temp/5);
        temp = temp % 5;
        betOneChips(temp);
    }

}
