package pl.com.bottega.cwiczeniowe.datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList<E> {

    private E[] contents;
    private int count;

    public MyArrayList(){
        contents = (E[]) new Object[100];
    }

    @Override
    public void add(E e) {
        if (count == contents.length) {
            E[] newContents = (E[]) new Object[contents.length + 100];
            System.arraycopy(contents, 0, newContents, 0, contents.length);
            contents = newContents;
        }
        contents[count] = e;
        count++;
    }

    @Override
    public void remove(E e) {
        for(int i = 0 ; i < count ; i++)
            if (e.equals(contents[i])) {
                remove(i);
                break;
            }
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public void remove(int i) {
        if(i>=count || i<0)
            throw new ArrayIndexOutOfBoundsException();
        System.arraycopy(contents, i+1, contents, i, contents.length - i - 1);
        contents[count - 1] = null;
        count--;
    }

    @Override
    public E first() {
        if (count == 0)
            return null;
        return contents[0];
    }

    @Override
    public E last() {
        if (count == 0)
            return null;
        return contents[count-1];
    }

    @Override
    public E get(int i) {
        if(i<0 || i>=count)
            throw new ArrayIndexOutOfBoundsException();
        return contents[i];
    }

    @Override
    public boolean contains(E element) {
        for (E tmp : contents) {
            if (tmp.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < count; i++) {
            if (element.equals(contents[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        Arrays.fill(contents, null);

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (E tmp : contents) {
            sb.append(tmp).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator(){
        return new Iterator<E>() {

            private  int currentIndex;
            @Override
            public boolean hasNext() {
                return currentIndex < count;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return contents[currentIndex++];
            }
        };
    }
}
