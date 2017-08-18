package pl.com.bottega.cwiczeniowe.collections;

public interface TreeNodeVisitor<E> {

    void visit(E element, int level );

}
