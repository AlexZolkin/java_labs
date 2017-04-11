package lab4.controller;

import lab4.model.interfaces.ISentence;
import lab4.model.interfaces.IText;

import java.util.List;

/**
 * Created by Алексей on 11.04.2017.
 */
public class TextTask implements ITextTask{
    @Override
    public String textReplace(StringBuffer text) {
        IText iText = IText.create(text);
        List<ISentence> sentences = iText.getSentences();
        for(ISentence sentence : sentences){
            sentence.replaceWords();
        }
        return iText.getText();
    }
}
