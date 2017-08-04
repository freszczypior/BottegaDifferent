package pl.com.bottega;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.com.bottega.myBox.Box;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {

    @Test
    void canCreateEmptyBox() {
        Box<String> emptyBox = new Box<>();
        assertTrue(emptyBox.empty());
    }

    @Test
    void canCreateNonEmptyBox() {
        Box<String> nonEmptyBox = new Box<>("test");
        assertFalse(nonEmptyBox.empty());
    }

    @Test
    void canAddElementToEmptyBox() {
        Box<Integer> emptyBox = new Box<>();
        emptyBox.add(123);
        assertEquals(123, 123);
    }

    @Test
    void throwsWhenAddingElelementToNonEmptyBox() {
        Box<Integer> nonEmptyBox = new Box<>(123);
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                nonEmptyBox.add(234);
            }
        });
    }

    @Test
    void canPullElementFromNonEmptyBox(){
        Box<String> nonEmptyBox = new Box<>("test");
        String temp = nonEmptyBox.pull();
        assertEquals("test", temp);
    }

    @Test
    void throwsWhenPullingElementFromEmptyBox(){
        Box<Integer> emptyBox = new Box<>();
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                int temp = emptyBox.pull();
            }
        });

    }
}
