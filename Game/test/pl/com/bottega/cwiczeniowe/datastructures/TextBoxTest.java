package pl.com.bottega.cwiczeniowe.datastructures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.com.bottega.cwiczeniowe.others.TextBox;

public class TextBoxTest {
    private TextBox nonEmptyBox = new TextBox("test");

    @Test
    public void canCreateNonEmptyBox(){
        assertFalse(nonEmptyBox.empty());
    }

    @Test
    public void canCreateEmptyBox(){
        TextBox box = new TextBox();
        assertTrue(box.empty());
    }

    @Test
    public void pullsEllementFromBox(){
        String pulledElement = (String) nonEmptyBox.pull();
        assertEquals("test", pulledElement);
    }

    @Test
    public void boxIsEmptyAfterPull(){
        nonEmptyBox.pull();
        assertTrue(nonEmptyBox.empty());
    }

    @Test
    public void canInsertAndPullElement(){
        //given
        TextBox box = new TextBox();

        //when
        box.insert("test");
        String pulledElement = (String) box.pull();

        //then
        assertEquals("test", pulledElement);
    }

   /* @Test
    public void throwsWhenInsertingNonEmptyBox() {

        try {
            nonEmptyBox.insert("something");
            fail("Should throw exception");
        }
        catch (IllegalStateException ex) {
            assertEquals("Box is not empty", ex.getMessage());
        }
    }*/

    @Test
    public void throwsWhenPullingFromNonEmptyBox() {
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new TextBox().pull();
            }
        });
    }

    @Test
    public void throwsWhenInsertingNonEmptyBox() {
        assertThrows(IllegalStateException.class, new Executable() {  // anonimowa klasa
            @Override
            public void execute() throws Throwable {
                nonEmptyBox.insert("something");
            }
        });
    }

    @Test
    public void canHoldIntegers(){
        TextBox<Integer> integerBox = new TextBox<>();

        integerBox.insert(666);
        Integer pulledInteger = integerBox.pull();

        assertEquals(new Integer(666), pulledInteger);
    }
}
