package pl.com.bottega.cwiczeniowe.datastructures;

public class MyArrayListStack<T> implements MyStack<T> {

    MyArrayList<T> contents = new MyArrayList<T>();
    private int count;

    @Override
    public void push(T t) {

        contents.add(t);
    }

    @Override
    public T pop() {

        if (contents.length() == 0)
            return null;

        T poppedElement = contents.last();
        contents.remove(contents.length()-1);

        return poppedElement;
    }

    @Override
    public boolean empty() {

        return contents.length() == 0;
    }
}
