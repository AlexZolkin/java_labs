package lab1.controller;

/**
 * Created by Алексей on 10.04.2017.
 */
/*
№5404
* C2 = 0
* C3 = 1
* C5 = 4
* C7 = 4
* */
public class Lab1<T extends Number> implements ILab1<T> {
    @Override
    public T calculateTask(int n, int m) {
        Double result = 0.0;
        for(char i = 0; i < n; i++)
            for(char j = 0; j < m; j++)
                result += (i - j) / (i + 1);
        return (T)result;
    }
}
