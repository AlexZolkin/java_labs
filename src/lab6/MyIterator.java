package lab6;

import java.util.Iterator;

/**
 * Created by Алексей on 17.04.2017.
 */
public class MyIterator<T> implements Iterator<T>{
    private T[] array;
    private int curPos = 0;
    public MyIterator(T[] array){
        this.array = array;
    }
    @Override
    public boolean hasNext() {
        return array.length - 1 - curPos > 0;
    }

    @Override
    public T next() {
        return hasNext() ? array[++curPos] : null;
    }
}
