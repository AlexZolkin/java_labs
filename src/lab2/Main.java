package lab2;

import lab2.controller.IMatrixCalc;
import lab2.model.IMatrix;

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
        IMatrixCalc task = IMatrixCalc.create();
        IMatrix matrixA = IMatrix.create();
        System.out.println("Matrix A");
        matrixA.show();
        IMatrix matrixB = IMatrix.create();
        System.out.println("Matrix B");
        matrixB.show();
        IMatrix matrixC = task.multiplyMatrix(matrixA, matrixB);
        System.out.println("Matrix C -> A * B");
        matrixC.show();
        System.out.println("Sum(min) = " + task.calcMin(matrixC));
        System.out.println("Sum(max) = " + task.calcMax(matrixC));
    }

}
