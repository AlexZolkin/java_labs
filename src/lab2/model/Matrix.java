package lab2.model;

import java.util.Random;

/**
 * Created by Алексей on 10.04.2017.
 */
public class Matrix implements IMatrix {
    private long[][] matrix;
    private final int rows, columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new long[rows][columns];
        fillMatrix();
    }
    public Matrix(int rows, int columns, long value) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new long[rows][columns];
        fillMatrix(value);
    }

    @Override
    public void show() {
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(j == columns - 1)
                    System.out.print(matrix[i][j]);
                else
                    System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
    }

    @Override
    public long getElement(int row, int column) throws NullPointerException {
        if(row < rows && column < columns)
            return matrix[row][column];
        else
            throw new NullPointerException();
    }

    @Override
    public void setElement(int row, int column, long value) throws NullPointerException {
        if(row < rows && column < columns)
            matrix[row][column] = value;
        else
            throw new NullPointerException();
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return columns;
    }

    private void fillMatrix(){
        Random rand = new Random();
        for (int i=0;i<this.rows;i++)
            for (int j=0;j<this.columns;j++){
                long randLong = rand.nextLong() % 10;
                matrix[i][j] = randLong < 0 ? (-1) * randLong : randLong;
            }
    }
    private void fillMatrix(long value){
        for (int i=0;i<this.rows;i++)
            for (int j=0;j<this.columns;j++){
                matrix[i][j] = value;
            }
    }
}
