package lab6;

import java.util.*;

/**
 * Created by Алексей on 17.04.2017.
 */
public class TrackList<T> implements List<T>{
    private T[] array;

    public TrackList(){
        array = (T[]) new Object[0];
    }
    public TrackList(T element){
        array = (T[]) new Object[1];
        array[0] = element;
    }
    public TrackList(List<T> list){
        array = list.toArray(array);
    }

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
        this.array = array;
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
        for(Object o : c){
            boolean flag = false;
            for(T tmp : array){
                if(tmp.equals((T)o))
                    flag = true;
            }
            if(!flag)
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] array = (T[]) new Object[this.array.length + c.size()];
        for(int i=0;i<this.array.length;i++){
            array[i] = this.array[i];
        }
        T[] tmpArray =  c.toArray(array);
        for(int i=this.array.length;i<array.length;i++){
            array[i] = tmpArray[i];
        }
        this.array = array;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        T[] array = (T[]) new Object[c.size() - index -1];
        System.arraycopy(c.toArray(), index, array, 0, array.length);
        return addAll(Arrays.asList(array));
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
        array = (T[]) new Object[0];
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        return array[index];
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        array[index] = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        T[] array = (T[]) new Object[this.array.length+1];
        for(int i=0;i<this.array.length;i++){
            array[i] = this.array[i];
        }
        for(int i=index;i<array.length-1;i++){
            array[i + 1] = array[i];
        }
        array[index] = element;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException{
        T result = array[index];
        for(int i=index;i<array.length-1;i++){
            array[i] = array[i+1];
        }
        T[] array = (T[]) new Object[this.array.length-1];
        array = this.array.clone();
        return result;
    }

    @Override
    public int indexOf(Object o) {
        T tmp = (T)o;
        for(int i=0;i<array.length;i++){
            if(array[i].equals(tmp))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        T tmp = (T)o;
        for(int i=array.length-1;i>-1;i--){
            if(array[i].equals(tmp))
                return i;
        }
        return -1;
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
        T[] arr = (T[]) new Object[fromIndex + toIndex];
        for(int i=fromIndex, k=0;i< toIndex;i++,k++)
            arr[k] = array[i];
        return new TrackList<T>(Arrays.asList(arr));
    }


}
