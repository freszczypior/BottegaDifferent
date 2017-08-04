package pl.com.bottega;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.com.bottega.list.MyArrayList;
import pl.com.bottega.list.MyLinkedList;
import pl.com.bottega.list.MyList;


class MyListTest {

    //private MyList<String> list = new MyArrayList<>();
    private MyList<String> list = new MyLinkedList<>();

    @BeforeEach
    void setUp() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
    }

    @Test
    void canAddElement() {
        //MyList<String> list = new MyArrayList<>();
        MyList<String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        String test = list.get(2);
        assertEquals("two", test);
    }

    @Test
    void canRemoveElementsByIndex() {
        list.remove(3);
        String test = list.get(3);
        assertEquals("four", test);
    }

    @Test
    void canRemoveElementsByItem() {
        list.remove("two");
        String test = list.get(2);
        assertEquals("four", test);
    }

    @Test
    void canCheckLength() {
        int length = list.length();
        assertEquals(4, length);
    }

    @Test
    void canGetFirstFromNonEmptyList() {
        String test = list.first();
        assertEquals("one", test);
    }

    @Test
    void canGetLastFromNonEmptyList() {
        String test = list.last();
        assertEquals("four", test);
    }

    @Test
    void canGetElementByIndex() {
        String test = list.get(2);
        assertEquals("two", test);
    }

    @Test
    void throwsWhenTryingRemovElementOutsideTheList() {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                list.remove(6);
            }
        });
    }
    @Test
    void canChectIfContainElement(){
        boolean test = list.containElement("three");
        assertTrue(test);
    }
    @Test
    void canCheckElementIndex(){
        int test = list.indexOf("three");
        assertEquals(3, test);
    }

    @Test
    void canUseMyOwnToStringMethod(){
        String test = list.toString();
        assertEquals("one, two, three, four", test);
    }

}
