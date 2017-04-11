package lab4.model.interfaces;

import lab4.model.implementation.Word;

/**
 * Created by Алексей on 11.04.2017.
 */
public interface IWord {
    IDelimiter getDelimiter();

    void setDelimiter(IDelimiter delimiter);

    static IWord create(StringBuffer word, Character delimiter) {
        return new Word(word, delimiter);
    }

    static IWord create(StringBuffer word) {
        return new Word(word, null);
    }
    StringBuffer getWord();
}
