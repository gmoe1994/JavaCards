package no.hiof.thomasjg.Model.Betting;

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

    public Chips(Value value) {
        this.value = value;
    }

    public int getValues() {
        return values.get(value);
    }
}
