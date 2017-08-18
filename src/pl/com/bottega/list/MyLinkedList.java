package pl.com.bottega.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {

    private Link<E> first, last;
    private static int counter;

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);

    }

    @Override
    public void add(E e) {
        Link<E> newLink = new Link<>(last, e, null);    // TODO o co cho z tym konstr?
        newLink.element = e;
        if (first == null) {
            first = newLink;
            last = newLink;
            counter++;
        } else {
            last.next = newLink;
            last = newLink;
            counter++;
        }
    }

    @Override
    public void remove(E e) {
        if (e == null) {
            for (Link<E> temp = first; temp != null; temp = temp.next) {
                if (temp.element == null) {
                    moveElement(temp);
                    counter--;
                }
            }
        } else {
            for (Link<E> temp = first; temp != null; temp = temp.next) {
                if (temp.element == null)
                    continue;
                if (temp.element.equals(e)) {
                    moveElement(temp);
                    counter--;
                }
            }
        }
    }

    @Override
    public void remove(int index) {
        if (outOfBounds(index))
            throw new IndexOutOfBoundsException("podano liczbę spoza zakresu");
        Link<E> temp = first;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        moveElement(temp);
        counter--;
    }

    private void moveElement(Link<E> temp) {
        if (temp.prev == null) {
            first = temp.next;
        } else {
            temp.prev.next = temp.next;
        }
        if (temp.next == null) {
            last = temp.prev;
            temp.next = null;
        } else {
            temp.next.prev = temp.prev;
        }
    }


    @Override
    public int length() {
        int counter = 0;
        Link<E> temp = first;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    @Override
    public E first() {
        if (ifEmpty())
            throw new NoSuchElementException("lista jest pusta");
        return first.element;
    }

    @Override
    public E last() {
        if (ifEmpty())
            throw new NoSuchElementException("lista jest pusta");
        return last.element;
    }

    @Override
    public E get(int index) {
        if (outOfBounds(index))
            throw new IndexOutOfBoundsException("podano liczbę spoza zakresu");
        Link<E> temp = first;
        for (int j = 0; j < index; j++) {  //TODO zmieniłem z j=1 na j=0 bo public Iterator<E> iterator()
            temp = temp.next;
        }
        return temp.element;
    }

    @Override
    public boolean containElement(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public int indexOf(E e) {   // TODO czy powinno trows gdy nie contains e?
        Link<E> temp;
        int counter = 1;
        if (e == null) {
            for (temp = first; temp != null; temp = temp.next) {
                if (temp.element == null)
                    return counter;
                counter++;
            }
        } else {
            for (temp = first; temp != null; temp = temp.next) {
                if (temp.element == null)
                    continue;
                if (temp.element.equals(e))
                    return counter;
                counter++;
            }
        }
        return -1;
    }

    @Override
    public boolean ifEmpty() {
        return (length() < 1);
    }

    @Override
    public boolean outOfBounds(int i) {
        return i < 0 || i > length();
    }

    @Override
    public void clear() {
        if (ifEmpty())
            throw new NoSuchElementException("lista nie zawiera elementów");
        for (Link<E> temp = first; temp != null; temp = temp.next) {
            moveElement(temp);
        }
        counter = 0;
    }

    public String toString() {
        if (ifEmpty())
            throw new NoSuchElementException("lista nie zawiera elementów");
        Link<E> temp = first;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(first.element));
        for (int j = 1; j < length(); j++) {
            temp = temp.next;
            stringBuilder.append(", ").append(temp.element);
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Link<E> currentLink = first;

            @Override
            public boolean hasNext() {
                return currentLink.next != null;
            }
                    // Iterator ma metodę remove, którą można dopisać tutaj jak kolejne @Overide
            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Link<E> temp = currentLink;
                currentLink = currentLink.next;
                return temp.element;
            }
        };
    }

    private class Link<E> {     // rekurencyjna struktura danych, ma ref do samej siebie

        private E element;
        private Link<E> next;
        private Link<E> prev;

        Link(Link<E> prev, E element, Link<E> next) {   // TODO dlaczego bez konstruktora nie działało?
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

    }
}


