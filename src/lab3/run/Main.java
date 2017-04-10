package lab3.run;

import lab3.controller.ITextTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 11.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        StringBuffer text = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your text: ");
            text = new StringBuffer(reader.readLine());
        }catch (IOException e){
            System.out.println("Error occurred: input error");
            System.exit(-1);
        }
        System.out.print("Text with first and last words in sentences replaced: ");
        System.out.println(ITextTask.create().textReplace(text));
    }
}
