package lab2.model;

/**
 * Created by Алексей on 10.04.2017.
 */
public interface IMatrix {
    static IMatrix create(int rows, int columns) {
        return new Matrix(rows, columns);
    }
    static IMatrix createEmpty(int rows, int columns) {
        return new Matrix(rows, columns, 0);
    }

    void show();
    long getElement(int row, int column) throws NullPointerException;
    void setElement(int row, int column, long value) throws NullPointerException;
    int getRows();
    int getCols();
}
