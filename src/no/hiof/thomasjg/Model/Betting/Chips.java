package no.hiof.thomasjg.Model.Betting;

import no.hiof.thomasjg.Model.Card;

import java.util.Map;

import static java.util.Map.entry;

public class Chips {
    final public Map<Chips.Value, Integer> values = Map.ofEntries(
            entry(Value.ONE,1),
            entry(Value.FIVE,5),
            entry(Value.TEN,10),
            entry(Value.TWENTY_FIVE,25),
            entry(Value.FIFTY,50));
    private final Value value;

    enum Value{
        ONE,
        FIVE,
        TEN,
        TWENTY_FIVE,
        FIFTY
    }


    public String illustrateChips(){
        Value value = this.value;
        String chipLogo;
        switch (value){
            case ONE -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            case FIVE -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            case TEN -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            case TWENTY_FIVE -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            case FIFTY -> chipLogo = "INSERT PICTURE PATH, PICTURE FILENAME";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return chipLogo;
    }


    public Chips(Value value) {
        this.value = value;
    }

    public int getValues() {
        return values.get(value);
    }
}
