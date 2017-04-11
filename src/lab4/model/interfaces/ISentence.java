package lab4.model.interfaces;

import lab4.model.implementation.Sentence;

import java.util.List;

/**
 * Created by Алексей on 11.04.2017.
 */
public interface ISentence {
    static ISentence create(StringBuffer sentence) {
        return new Sentence(sentence);
    }

    void replaceWords();

    List<IWord> splitSentence(StringBuffer sentence);

    StringBuffer getSentence();
}
