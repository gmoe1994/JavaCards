package no.hiof.thomasjg.Model.Betting;

import no.hiof.thomasjg.Model.Card;

import java.util.Map;

import static java.util.Map.entry;

public class Chips {
    private final int value;

    /**
     * Constructor for chips
     * @param value value of the chip to create
     */
    public Chips(int value){
        this.value = value;
    }

    /**
     * Return a string of the picture to represent the chip
     * @return string of picture
     */
    public String illustrateChips(){
        int value = this.value;
        String chipLogo;
        switch (value){
            case 1 -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            case 5 -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            case 10 -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            case 25 -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            case 50 -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return chipLogo;
    }

    /**
     * Get the value of the chip
     * @return value of chip
     */
    public int getValue() {
        return value;
    }
}
