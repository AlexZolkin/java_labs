package lab4.model.interfaces;

import lab4.model.implementation.Letter;

/**
 * Created by Алексей on 11.04.2017.
 */
public interface ILetter {

    static ILetter create(Character letter) {
        return new Letter(letter);
    }
    Character getLetter();
}
