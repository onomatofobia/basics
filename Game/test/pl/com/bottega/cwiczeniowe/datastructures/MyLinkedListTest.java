package pl.com.bottega.cwiczeniowe.datastructures;

import org.junit.jupiter.api.Test;
import pl.com.bottega.cwiczeniowe.datastructures.MyLinkedList;
import pl.com.bottega.cwiczeniowe.datastructures.MyList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyLinkedListTest {

    @Test
    public void canAddAndRemoveElements(){
        MyList<String> l = new MyLinkedList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        l.remove("three");
        String four = l.get(2);

        assertEquals("four", four);
    }

    @Test
    public void addingElementShouldChangeSize(){
        MyList<String> l = new MyLinkedList<>();
        l.add("one");
        int sizeBefore = l.length();
        l.add("two");

        assertEquals(true, sizeBefore < l.length());
    }

    @Test
    public void removingElementShouldChangeSize(){
        MyList<String> l = new MyLinkedList<>();
        l.add("one");
        l.add("two");
        int sizeBefore = l.length();
        l.remove("two");

        assertEquals(true, sizeBefore > l.length());
    }

    @Test
    public void hasAccessToElementsByIndex(){
        MyList<String> l = new MyLinkedList<>();
        l.add("one");
        l.add("two");

        assertEquals(l.get(0), "one");
    }

    @Test
    public void hasAccessToFirstElement(){
        MyList<String> l = new MyLinkedList<>();

        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");

        assertEquals(l.first(), "one");
    }

    @Test
    public void hasAccessToLastElement(){
        MyList<String> l = new MyLinkedList<>();

        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");

        assertEquals(l.last(), "four");
    }

    @Test
    public void canHaveNullElements(){
        MyList<String> l = new MyLinkedList<>();

        l.add("one");
        l.add("two");
        l.add(null);
        l.add("four");

        assertNull(l.get(2));
    }

    @Test
    public void shouldIterateOverList(){
        MyList<String> l = new MyLinkedList<>();

        l.add("one");
        l.add("two");
        l.add("three");

        for (String s : l){
            System.out.println(s);
        }
    }
}
