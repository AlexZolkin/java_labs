package lab4.model.implementation;

import lab4.model.interfaces.ISentence;
import lab4.model.interfaces.IText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 11.04.2017.
 */
public class Text implements IText {
    private StringBuffer text;
    private List<ISentence> sentences;
    public Text(StringBuffer text) {
        this.text = text;
        this.sentences = splitText(text);
    }

    @Override
    public List<ISentence> getSentences() {
        return this.sentences;
    }

    @Override
    public String getText() {
        StringBuffer text = new StringBuffer();
        for (ISentence sentence : this.sentences){
            text.append(sentence.getSentence() + " ");
        }
        return text.toString();
    }


    private List<ISentence> splitText(StringBuffer text){
        List<ISentence> list = new ArrayList<>();
        String[] sentences = text.toString().split("\\.");
        for(String sentence : sentences){
            list.add(ISentence.create(new StringBuffer(sentence)));
        }
        return list;
    }
}
