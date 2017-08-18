package pl.com.bottega.cwiczeniowe.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {

    private Link<E> first, last, currentElement;
    private int length;
    private E e;

    @Override
    public void add(E e) {
        Link<E> newLink = new Link<>();
        newLink.element = e;
        if(first == null){
            first = newLink;
            last = newLink;
        }
        last.next = newLink;
        last = newLink;
    }

/*    @Override
    public void remove(E e) {

        Link<E> tmp = first;
        Link<E> previous = null;
        while (tmp != null) {
            if (tmp.element.equals(e)) {
                previous.next = tmp.next;
                return;
            }
                previous = tmp;
                tmp = tmp.next;
            }
        }*/

    @Override
    public void remove(E e) {

        Link<E> tmp = first;
        Link<E> previous = null;
        while (tmp != null) {
            if (tmp.contains(e))
                remove(tmp, previous);
            return;
        }
        previous = tmp;
        tmp = tmp.next;
    }



    @Override
    public int length() {
        int counter=0;
        Link<E> tmpLink = first;

        while(tmpLink != null) {
            counter+=1;
            tmpLink = tmpLink.next;
        }
        return counter;
    }


/*    @Override
    public void remove(int i) {
        Link<E> tmpLink = first;
        Link<E> prevLink = null;
        int counter = 0;

        while (tmpLink != null) {
            if (counter == i) {
                if (tmpLink.equals(first)) {
                    first = first.next;
                    return;
                }
                prevLink.next = tmpLink.next;
                return;
            }
                prevLink = tmpLink;
                tmpLink = tmpLink.next;
                counter++;
            }
        }*/

    @Override
    public void remove(int i){
            if (i >= 0 && i < length) {
                Link tmp = first;
                Link previous = null;
                int k = 0;
                while (k < i) {
                    previous = tmp;
                    tmp = tmp.next;
                    k++;
                }
                remove(tmp, previous);
            }
        }



    private void remove(Link tmp, Link previous){
        if (previous != null && tmp.next != null) {
            previous.next = tmp.next;
        }
        else if(previous == null && tmp.next == null) {
            first = null;
            last = null;
        }
        else if (previous == null && tmp.next != null) {
            first = tmp.next;
        }
        else {
            previous.next = null;
            last = previous;
        }
        length--;
        return;
    }



    @Override
    public E first() {
        return first.element;
    }

    @Override
    public E last() {
        return last.element;
    }

    @Override
    public E get(int i) {
        Link<E> tmp = first;
        for (int counter = 0; counter < i; counter++) {
            tmp = tmp.next;
        }
        return tmp.element;
    }

    @Override
    public boolean contains(E other) {

        return (e == null && other == null) || e.equals(other);
    }


    @Override
    public int indexOf(E element) {
        int counter = 0;
        Link<E> tmp = first;
        while (tmp != null) {
            if (tmp.element.equals(element)) {
                return counter;
            }
            counter++;
            tmp = tmp.next;
        }
        return -1;
    }

    @Override
    public void clear() {
        while (first != null) {
            first = first.next;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Link<E> tmp = first;
        while (tmp != null) {
            sb.append(tmp.element).append(", ");
            tmp = tmp.next;
        }
        sb.append("]");
        return sb.toString();
        }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {


            @Override
            public boolean hasNext() {

                return currentElement != null;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                E tmp = currentElement.e;
                currentElement = currentElement.next;
                return tmp;
            }
        };
    }


    private class Link<E> {

        private E e;
        private E element;
        private Link<E> next;

        public boolean contains(E other) {
            return (e == null && other == null) || e.equals(other);
        }
    }

}
