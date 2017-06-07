package lab2.controller;

import lab2.model.IMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Алексей on 07.06.2017.
 */
public class MatrixCalcTest {
    IMatrix matrixA;
    IMatrix matrixB;
    static IMatrixCalc matrixCalc;

    @BeforeClass
    public void setUpStatic(){
        matrixCalc = IMatrixCalc.create();
    }

    @Before
    public void setUp(){
        matrixA = IMatrix.create(2, 2);
        matrixB = IMatrix.create(2, 2);
    }

    @Test
    public void multiplyMatrix() throws Exception {
        IMatrix matrixC = matrixCalc.multiplyMatrix(matrixA, matrixB);
        Assert.assertEquals(true,
                matrixA.getRows() == matrixC.getRows() &&
                matrixA.getCols() == matrixC.getCols());
    }


}