package lab4.model.interfaces;

import lab4.model.implementation.Delimiter;

/**
 * Created by Алексей on 11.04.2017.
 */
public interface IDelimiter {

    static IDelimiter create(Character delimiter) {
        return new Delimiter(delimiter);
    }

    Character getDelimiter();
}
