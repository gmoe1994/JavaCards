package no.hiof.thomasjg.Model.Betting;

import java.util.ArrayList;

public class PileOfChips {
    private ArrayList<Chips> pile = new ArrayList<>();

    /**
     * Constructor which either gives you a start amount with 1000 chips or no chips at all
     * @param startChips ture if chips wanted, false if not
     */
    public PileOfChips(boolean startChips) {
        if (startChips) {
            addOneChips(50);
            addFiveChips(14);
            addTENChips(15);
            addTwentyFiveChips(10);
            addFiftyChips(10);
        }
    }

    /**
     * Constructor which adds the desired value of chips
     * @param value value of the chips in total
     */
    public PileOfChips(int value){
        addChips(value);
    }

    /**
     * Calculates the total value of the chips in the pile
     * @param pileToCount pile to count the total value
     * @return value of pile
     */
    public int calculateValueOfChips(ArrayList<Chips> pileToCount){
        int value = 0;
        for (Chips chip: pileToCount){
            value += chip.getValue();
        }
        return value;
    }

    /**
     * Calculates the total value of the chips in the pile
     * @return value of the chips
     */
    public int calculateValueOfChips(){
        int value = 0;
        for (Chips chip: pile){
            value += chip.getValue();
        }
        return value;
    }

    /**
     * Adds ONE chips to your pile
     * @param amount amount of ONE chips to add
     */
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

    /**
     * Adds chips to the collection of chips (pile).
     * @param amount value of the chips in total
     */
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

    /**
     * Adds chips to the pile
     * @param chips chips to add to the pile
     */
    public void addChips(ArrayList<Chips> chips){
        pile.addAll(chips);
    }

    /**
     * deletes all chips from pile
     */
    public void cleanTable(){
        pile.clear();
    }

    /**
     * A helper method which takes all the chips in the pile and returns them
     * @return arraylist of all chips from the pile
     */
    public ArrayList<Chips> returnChips(){
        ArrayList<Chips> toReturn = new ArrayList<>();
        toReturn.addAll(pile);
        pile.clear();
        return toReturn;
    }

    /**
     * Removes ONE chips from you pile and adds it to an Arraylist
     * This is thought of as a helper method to placeBet, but can also be used separately if needed
     * @param amount amount of ONE chips to bet
     * @param listToAddChips list the chips gets added to
     */
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



    /**
     * Takes chips out of the pile, starts with adding the highest chip value then tries the rest in descending order of chip values
     * @param amount
     * @return Arraylist with the chips taken out of the pile
     */
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
        if (calculateValueOfChips(chips) != amount){
            System.out.println("User does not have enough chips to place this bet");
            return new ArrayList<>();
        }
        return chips;

    }

}
