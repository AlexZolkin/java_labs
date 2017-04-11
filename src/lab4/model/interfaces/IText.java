package lab4.model.interfaces;

import lab4.model.implementation.Text;

import java.util.List;

/**
 * Created by Алексей on 11.04.2017.
 */
public interface IText {
    static IText create(StringBuffer text) {
        return new Text(text);
    }

    List<ISentence> getSentences();

    String getText();
}
