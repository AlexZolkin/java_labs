package lab2;

import lab2.controller.IMatrixCalc;
import lab2.model.IMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 10.04.2017.
 */
/*
* C5 = 4
* C7 = 4
* C11 = 4
* */
public class Main {
    public static void main(String[] args) {
        int rows = 0, columns = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter number of rows for the first matrix: ");
            rows = Integer.parseInt(reader.readLine());
            System.out.print("Enter number of columns for the first matrix: ");
            columns = Integer.parseInt(reader.readLine());
        }catch (IOException e){
            System.out.println("Error occurred: input error");
            System.exit(-1);
        }catch (NumberFormatException e){
            System.out.println("Error occurred: not a number");
            System.exit(-1);
        }
        IMatrixCalc task = IMatrixCalc.create();
        IMatrix matrixA = IMatrix.create(rows, columns);
        System.out.println("Matrix A");
        matrixA.show();
        IMatrix matrixB = IMatrix.create(columns, rows);
        System.out.println("Matrix B");
        matrixB.show();
        IMatrix matrixC = task.multiplyMatrix(matrixA, matrixB);
        System.out.println("Matrix C -> A * B");
        matrixC.show();
        System.out.println("Sum(min) = " + task.calcMin(matrixC));
        System.out.println("Sum(max) = " + task.calcMax(matrixC));
    }

}
