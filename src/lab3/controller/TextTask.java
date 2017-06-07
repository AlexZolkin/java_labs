package lab3.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Алексей on 11.04.2017.
 */
public class TextTask implements ITextTask{
    @Override
    public StringBuffer textReplace(StringBuffer text) {
        StringBuffer result = new StringBuffer();
        List<String> sentences = Arrays.asList(text.toString().split("\\."));
        for(String sentence : sentences){
            List<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));
            if(words.get(0).equals(""))
                words.remove(0);
            if(words.get(words.size() - 1).equals(""))
                words.remove(words.size() - 1);
            if(words.size() > 1)
            swap(words);
            result.append(String.join(" ", words.toArray(new String[0])));
            result.append(". ");
        }
        return result;
    }
    private void swap(List<String> words){
        String tmp = words.get(0);
        words.set(0, words.get(words.size() - 1));
        words.set(words.size() - 1, tmp);
    }
}
