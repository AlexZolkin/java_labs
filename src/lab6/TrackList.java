package lab6;

import java.util.*;

/**
 * Created by Алексей on 17.04.2017.
 */
public class TrackList<T> implements List<T>{
    private T[] array;
    @Override
    public int size() {
        if(array != null)
            return array.length;
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return array == null || array.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(T item : array){
            if(item.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new MyIterator<T>(array);
        return iterator;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) throws ClassCastException{
        T1[] array = a.clone();
        for(int i=0;i<array.length;i++){
            array[i] = (T1) this.array[i];
        }
        return array;
    }

    @Override
    public boolean add(T t) {
        T[] array = (T[]) new Object[this.array.length +1];
        for(int i=0;i<this.array.length;i++){
            array[i] = this.array[i];
        }
        array[array.length-1] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        T tmp = (T) o;
        for(int i=0;i<array.length;i++){
            if(array[i].equals(tmp)){
                for(int j=i+1;j<array.length;j++){
                    array[j-1] = array[j];
                }
                array[array.length-1] = null;
                array = Arrays.copyOf(array, array.length-1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


}
