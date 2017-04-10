package lab3.controller;

/**
 * Created by Алексей on 11.04.2017.
 */
public interface ITextTask {
    static TextTask create() {
        return new TextTask();
    }
    StringBuffer textReplace(StringBuffer text);
}
