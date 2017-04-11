package lab4.model.implementation;

import lab4.model.interfaces.IDelimiter;
import lab4.model.interfaces.ILetter;
import lab4.model.interfaces.IWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 11.04.2017.
 */
public class Word implements IWord {
    private StringBuffer word;
    private List<ILetter> letters;
    private IDelimiter delimiter;
    public Word(StringBuffer word, Character delimiter) {
        this.word = word;
        this.delimiter = IDelimiter.create(delimiter);
        this.letters = splitWord(new StringBuffer(word.toString()));
    }

    @Override
    public IDelimiter getDelimiter() {
        return this.delimiter;
    }

    @Override
    public void setDelimiter(IDelimiter delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public StringBuffer getWord() {
        StringBuffer word = new StringBuffer();
        for(ILetter letter : this.letters){
            word.append(letter.getLetter());
        }
        if(this.delimiter != null)
            word.append(this.delimiter.getDelimiter() == null ? "" : this.delimiter.getDelimiter());
        return word;
    }

    private List<ILetter> splitWord(StringBuffer word){
        List<ILetter> letters = new ArrayList<>();
        for(Character letter : word.toString().toCharArray()){
            letters.add(ILetter.create(letter));
        }
        return letters;
    }
}
