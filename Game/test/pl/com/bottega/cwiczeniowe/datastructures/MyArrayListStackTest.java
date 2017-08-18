package pl.com.bottega.cwiczeniowe.datastructures;

import org.junit.jupiter.api.Test;
import pl.com.bottega.cwiczeniowe.datastructures.MyArrayListStack;
import pl.com.bottega.cwiczeniowe.datastructures.MyStack;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListStackTest {

    MyStack<String> stack = new MyArrayListStack<>();

    @Test
    public void canAddElementToStack(){
        stack.push("one");

        assertFalse(stack.empty());
    }

    @Test
    public void canRemoveElementFromStack(){
        stack.push("one");
        stack.push("two");

        String poppedText = stack.pop();

        assertEquals(poppedText, "two");
    }

    @Test
    public void isAnyElementOnStack(){

        assertTrue(stack.empty());
    }

    @Test
    public void returnNullWhenStackIsEmpty(){

        assertNull(stack.pop());
    }
}
