package lab4.model.implementation;

import lab4.model.interfaces.ILetter;

/**
 * Created by Алексей on 11.04.2017.
 */
public class Letter implements ILetter{
    private Character letter;
    public Letter(Character letter) {
        this.letter = letter;
    }

    @Override
    public Character getLetter() {
        return this.letter;
    }
}
