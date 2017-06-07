//BPT-IP54-2
package lab1.run;

import lab1.controller.ILab1;
import lab1.controller.Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 10.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        ILab1<Double> task = new Lab1<Double>();
        int n = 0, m = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter n: ");
            n = Integer.parseInt(reader.readLine());
            System.out.print("Enter m: ");
            m = Integer.parseInt(reader.readLine());
        }catch (NumberFormatException e){
            System.out.println("Error occurred: not a number");
            System.exit(-1);
        }catch (IOException e){
            System.out.println("Error occurred: input error");
        }
        System.out.println("Answer: " + task.calculateTask(n, m));
    }
}
