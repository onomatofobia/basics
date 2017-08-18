package pl.com.bottega.cwiczeniowe.datastructures;

public interface MyStack<T> {

    //odkłada na szczyt stosu element t
    void push(T t);

    //zdejmuje ze szczytu stosu element i zwraca go, zwraca null jeśli stos pusty
    T pop();

    //zwraca informację czy są jakieś elementy na stosie
    boolean empty();

}
