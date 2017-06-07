//BPT-IP54-2
package lab4.run;

import lab4.controller.ITextTask;

/**
 * Created by Алексей on 11.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        StringBuffer text = new StringBuffer(lab3.run.Main.readText());
        System.out.print("Text with first and last words in sentences replaced: ");
        System.out.println(ITextTask.create().textReplace(text));
    }
}
