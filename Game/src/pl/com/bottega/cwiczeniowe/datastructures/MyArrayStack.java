package pl.com.bottega.cwiczeniowe.datastructures;


public class MyArrayStack<T> implements MyStack<T> {

    private T[] contents;
    private int count;

    public MyArrayStack(){
        contents = (T[]) new Object[100];
    }


    @Override
    public void push(T t) {
        if (count == contents.length) {
            T[] newContents = (T[]) new Object[contents.length + 100];
            System.arraycopy(contents, 0, newContents, 0, contents.length);
            contents = newContents;
        }
        contents[count] = t;
        count++;
    }

    @Override
    public T pop() {
        if (count == 0)
            return null;

        T poppedElement = contents[count - 1];
        contents[count - 1] = null;
        count--;
        return poppedElement;
    }

    @Override
    public boolean empty() {

        return count == 0;
    }
}
