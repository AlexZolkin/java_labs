package lab4.model.implementation;

import lab4.model.interfaces.IDelimiter;
import lab4.model.interfaces.ISentence;
import lab4.model.interfaces.IWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 11.04.2017.
 */
public class Sentence implements ISentence {
    private StringBuffer sentence;
    private List<IWord> words;
    public Sentence(StringBuffer sentence) {
        this.sentence = sentence;
        this.words = splitSentence(sentence);
    }

    @Override
    public void replaceWords() {
        if(this.words.size() < 2)
            return;
        IDelimiter delimiter = this.words.get(0).getDelimiter();
        if(delimiter != null){
            this.words.get(this.words.size() - 1).setDelimiter(delimiter);
            this.words.get(0).setDelimiter(null);
        }
        IWord tmp = this.words.get(0);
        this.words.set(0, this.words.get(this.words.size() - 1));
        this.words.set(this.words.size() - 1, tmp);
    }

    @Override
    public List<IWord> splitSentence(StringBuffer sentence) {
        List<IWord> words = new ArrayList<>();
        String[] parts = sentence.toString().split(" ");
        for (String part : parts){
            if(!Character.isLetter(part.charAt(part.length() - 1)))
                words.add(IWord.create(new StringBuffer(part), new Character(part.charAt(part.length() - 1))));
            else
                words.add(IWord.create(new StringBuffer(part)));
        }
        return words;
    }

    @Override
    public StringBuffer getSentence() {
        StringBuffer sentence = new StringBuffer();
        for (IWord word : this.words){
            sentence.append(word.getWord());
            if(this.words.indexOf(word) < this.words.size() - 1)
                sentence.append(" ");
        }
        return sentence;
    }
}
