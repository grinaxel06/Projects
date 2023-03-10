import java.util.Collections;
import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements Iterable<T> {
    private Object[] data;
    private int capacity; // real size
    private int size = 0; // fill size

    public int size() {
        return size;
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }
    public Object[] getData(){return data;}

    public MyArrayList() {
        this(10);
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        return (T) data[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        data[index] = value;
    }

    public void add(T value) {
        if (capacity == size) {
            capacity *= 1.5;
            Object[] newData = new Object[capacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size] = value;
        ++size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size - 1] = null;
        --size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }
    public boolean contains(String c,int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        return data[index].equals(c);
    }
    public int indexOf(T value){
        int index;
        for (index =0;index<size;index++){
            if ( data[index]== value){
                return index;
            }
        }
        return -1;
    }



    public void addAll( MyArrayList arrayList){
        Object[] arr = new Object[size + arrayList.size()];
        System.arraycopy(this.data, 0, arr, 0, size);
        System.arraycopy(arrayList.getData(), 0, arr, size, arrayList.size());
        this.data = arr;
        size += arrayList.size();
    }
    public int binarySearch( T value) {
        int l = 0;
        int r = size - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (data[mid] == value) {
                return mid;
            } else if (value.compareTo((T) data[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1; // not found
    }




    private class MyArrayListIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            return (T) data[cursor++]; // data[cursor]; cursor++;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(cursor);
        }


    }




}

