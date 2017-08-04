package pl.com.bottega;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.com.bottega.stack.MyArrayListStack;
import pl.com.bottega.stack.MyArrayStack;

public class StackTest {

    // testy dla MyArrayStack

    @Test
    void canAddItemToStack() {
        MyArrayStack<String> stack = new MyArrayStack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        assertFalse(stack.empty());
    }

    @Test
    void canRemoveItemFromStack() {
        MyArrayStack<String> stack = new MyArrayStack<>();
        stack.push("one");
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void cantRemoveFromEmptyStack() {
        MyArrayStack<String> stack = new MyArrayStack<>();
        String test = stack.pop();
        assertEquals(null, test);
    }

    @Test
    void canCheckIfStackIsEmpty(){
        MyArrayStack<String> stack = new MyArrayStack<>();
        assertTrue(stack.empty());
    }

    // testy dla MyArrayListStack

    @Test
    void canAddItemToListStack() {
        MyArrayListStack<String> stack = new MyArrayListStack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        assertFalse(stack.empty());
    }

    @Test
    void canRemoveItemFromListStack() {
        MyArrayListStack<String> stack = new MyArrayListStack<>();
        stack.push("one");
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void cantRemoveFromEmptyListStack() {
        MyArrayListStack<String> stack = new MyArrayListStack<>();
        String test = stack.pop();
        assertEquals(null, test);
    }

    @Test
    void canCheckIfListStackIsEmpty(){
        MyArrayListStack<String> stack = new MyArrayListStack<>();
        assertTrue(stack.empty());
    }
}
