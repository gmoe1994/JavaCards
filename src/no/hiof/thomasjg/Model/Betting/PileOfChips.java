package no.hiof.thomasjg.Model.Betting;

import java.util.ArrayList;

public class PileOfChips {
    private ArrayList<Chips> pile = new ArrayList<>();

    public PileOfChips(boolean startChips) {
        if (startChips) {
            addOneChips(50);
            addFiveChips(14);
            addTENChips(15);
            addTwentyFiveChips(10);
            addFiftyChips(10);
        }
    }

    public PileOfChips(int amount){
        addChips(amount);
    }

    public void addOneChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(1));
        }
    }

    public void addFiveChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(5));
        }
    }

    public void addTENChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(10));
        }
    }

    public void addTwentyFiveChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(25));
        }
    }

    public void addFiftyChips(int amount){
        for (int i = 0; i < amount; i++) {
            pile.add(new Chips(50));
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


    public void addChips(ArrayList<Chips> chips){
        pile.addAll(chips);
    }

    public void cleanTable(){
        pile.clear();
    }

    public ArrayList<Chips> returnChips(){
        ArrayList<Chips> toReturn = new ArrayList<>();
        toReturn.addAll(pile);
        pile.clear();
        return toReturn;
    }

    public void betOneChips(int amount, ArrayList<Chips> listToAddChips){
        for (int i = 0; i < amount; i++) {
            for (Chips chip : pile){
                if (chip.getValue() == 1){
                    Chips toAdd = pile.remove(pile.indexOf(chip));
                    listToAddChips.add(toAdd);
                    break;
                }
            }
        }
    }

    public void betFiveChips(int amount, ArrayList<Chips> listToAddChips){
        for (int i = 0; i < amount; i++) {
            for (Chips chip : pile){
                if (chip.getValue() == 5){
                    Chips toAdd = pile.remove(pile.indexOf(chip));
                    listToAddChips.add(toAdd);
                    break;
                }
            }
        }
    }

    public void betTENChips(int amount, ArrayList<Chips> listToAddChips){
        for (int i = 0; i < amount; i++) {
            for (Chips chip : pile){
                if (chip.getValue() == 10){
                    Chips toAdd = pile.remove(pile.indexOf(chip));
                    listToAddChips.add(toAdd);
                    break;
                }
            }
        }
    }

    public void betTwentyFiveChips(int amount, ArrayList<Chips> listToAddChips){
        for (int i = 0; i < amount; i++) {
            for (Chips chip : pile){
                if (chip.getValue() == 25){
                    Chips toAdd = pile.remove(pile.indexOf(chip));
                    listToAddChips.add(toAdd);
                    break;
                }
            }
        }
    }

    public void betFiftyChips(int amount, ArrayList<Chips> listToAddChips){
        for (int i = 0; i < amount; i++) {
            for (Chips chip : pile){
                if (chip.getValue() == 50){
                    Chips toAdd = pile.remove(pile.indexOf(chip));
                    listToAddChips.add(toAdd);
                    break;
                }
            }
        }
    }

    public ArrayList<Chips> placeBet(int amount){
        ArrayList<Chips> chips = new ArrayList<>();
        int temp;
        betFiftyChips(amount/50, chips);
        temp = amount % 50;
        betTwentyFiveChips(temp/25, chips);
        temp = temp % 25;
        betTENChips(temp/10, chips);
        temp = temp % 10;
        betFiveChips(temp/5, chips);
        temp = temp % 5;
        betOneChips(temp, chips);
        return chips;
    }

}
