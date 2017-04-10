package lab2.controller;

import lab2.model.IMatrix;

/**
 * Created by Алексей on 10.04.2017.
 */
public class MatrixCalc implements IMatrixCalc {
    @Override
    public IMatrix multiplyMatrix(IMatrix matrixA, IMatrix matrixB) throws NullPointerException{
        if(matrixA == null || matrixB == null)
            throw new NullPointerException();
        IMatrix matrixC = IMatrix.createEmpty(matrixA.getRows(), matrixB.getCols());
        for(int i=0;i<matrixA.getRows();i++)
            for(int j=0;j<matrixB.getCols();j++){
                long sum = 0;
                for(int k=0;k<matrixB.getRows();k++){
                    sum += matrixA.getElement(i, k) + matrixB.getElement(k, j);
                }
                matrixC.setElement(i, j, sum);
            }
        return matrixC;
    }

    @Override
    public long calcMin(IMatrix matrixC) throws NullPointerException{
        if(matrixC == null)
            throw new NullPointerException();
        long sum = 0;
        for(int i=0;i<matrixC.getRows();i+=2){
            long min = matrixC.getElement(i, 0);
            for(int j=1;j<matrixC.getCols();j++){
                if(matrixC.getElement(i,j) < min)
                    min = matrixC.getElement(i, j);
            }
            sum += min;
        }
        return sum;
    }

    @Override
    public long calcMax(IMatrix matrixC) throws NullPointerException{
        if(matrixC == null)
            throw new NullPointerException();
        long sum = 0;
        for(int i=1;i<matrixC.getRows();i+=2){
            long max = matrixC.getElement(i, 0);
            for(int j=1;j<matrixC.getCols();j++){
                if(matrixC.getElement(i,j) > max)
                    max = matrixC.getElement(i, j);
            }
            sum += max;
        }
        return sum;
    }
}
