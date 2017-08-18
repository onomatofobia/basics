package pl.com.bottega.cwiczeniowe.datastructures;

import org.junit.jupiter.api.Test;
import pl.com.bottega.cwiczeniowe.datastructures.MyArrayStack;
import pl.com.bottega.cwiczeniowe.datastructures.MyStack;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayStackTest {
    MyStack<String> stack = new MyArrayStack<>();

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
        stack.push("one");
        stack.pop();
        assertEquals(null, stack.pop());
    }


}
