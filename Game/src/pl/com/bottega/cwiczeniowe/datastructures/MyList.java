package pl.com.bottega.cwiczeniowe.datastructures;

public interface MyList<E> extends Iterable<E> {

    //dodaje element na koniec listy
    void add(E e);

    //usuwa z listy pierwsze wsytąpienie elementu e
    void remove(E e);

    //zwraca długość listy
    int length();

    //usuwa z listy element występujący na pozycji i (i >= 0, i<length())
    void remove(int i);

    //zwraca pierwszy element listy
    E first();

    //zwraca ostatni element listy
    E last();

    //zwraca element listy na pozycji i
    E get(int i);

    //zwraca true jeśli element znajduje się na liście
    boolean contains(E element);

    //zwraca index zadanego elementu na liście lub -1 jeśli element nie istnieje
    int indexOf(E element);

    //usuwa wszystkie elementy listy
    void clear();


}
