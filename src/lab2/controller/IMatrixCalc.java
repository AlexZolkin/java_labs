package lab2.controller;

import lab2.model.IMatrix;

/**
 * Created by Алексей on 10.04.2017.
 */
public interface IMatrixCalc {
    static IMatrixCalc create() {
        return new MatrixCalc();
    }

    IMatrix multiplyMatrix(IMatrix matrixA, IMatrix matrixB) throws NullPointerException;

    long calcMin(IMatrix matrixC) throws NullPointerException;

    long calcMax(IMatrix matrixC) throws NullPointerException;
}
