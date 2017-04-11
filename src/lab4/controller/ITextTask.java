package lab4.controller;

/**
 * Created by Алексей on 11.04.2017.
 */
public interface ITextTask {
    static TextTask create() {
        return new TextTask();
    }
    String textReplace(StringBuffer text);
}
