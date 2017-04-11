package lab4.model.implementation;

import lab4.model.interfaces.IDelimiter;

/**
 * Created by Алексей on 11.04.2017.
 */
public class Delimiter implements IDelimiter {
    private Character delimiter;
    public Delimiter(Character delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public Character getDelimiter() {
        return this.delimiter;
    }
}
