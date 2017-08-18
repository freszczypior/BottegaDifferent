package pl.com.bottega.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList<E> {

    private E[] list;
    private int counter;

    public MyArrayList() {

        list = (E[]) new Object[100];
    }

    public static void main(String[] args) {
    }

    @Override
    public void add(E e) {
        if (counter == list.length) {
            E[] newContents = (E[]) new Object[list.length + 100];
            System.arraycopy(list, 0, newContents, 0, list.length);
            list = newContents;
        }
        list[counter] = e;
        counter++;
    }

    @Override
    public void remove(int i) {
        if (outOfBounds(i))
            throw new IndexOutOfBoundsException("index poza zakresem");
        System.arraycopy(list, i, list, i - 1, counter - 1);
        list[counter - 1] = null;
        counter--;
    }

    @Override
    public void remove(E e) {
        if (e == null) {
            for (int i = 0; i < length(); i++) {
                if (list[i] == null)
                    System.arraycopy(list, i, list, i - 1, counter - 1);
                list[counter - 1] = null;
                counter--;
            }
        } else {
            for (int i = 0; i < length(); i++) {
                if (list[i] == null)
                    continue;
                if (list[i].equals(e))
                    if (length() == 1) {
                        list[counter - 1] = null;
                        break;
                    }
                System.arraycopy(list, i+1, list, i, counter - 1);
                list[counter - 1] = null;
            }
            counter--;
        }
    }

    @Override
    public int length() {
        return counter;
    }

    @Override
    public E first() {
        if (ifEmpty())
            throw new NoSuchElementException("lista jest pusta");
        return list[0];
    }

    @Override
    public E last() {
        if (ifEmpty())
            throw new NoSuchElementException("lista jest pusta");
        return list[counter - 1];
    }

    @Override
    public E get(int i) {
        if (outOfBounds(i))
            throw new ArrayIndexOutOfBoundsException("index poza zakresem");
        return list[i - 1];
    }

    @Override
    public boolean containElement(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < length(); i++) {
                if (list[i] == null)
                    return i + 1;
            }
        } else {
            for (int i = 0; i < length(); i++) {
                if (list[i] == null)
                    continue;
                if (list[i].equals(e))
                    return i + 1;
            }
        }
        return -1;
    }

    @Override
    public boolean ifEmpty() {
        return length() < 1;
    }

    @Override
    public boolean outOfBounds(int i) {
        return i < 0 || i > length();
    }

    @Override
    public void clear() {
        if (ifEmpty())
            throw new NoSuchElementException("lista nie zawiera elementów");
        for (int i = 0; i < length(); i++) {
            list[i] = null;
        }
        counter = 0;
    }

    public String toString() {
        if (ifEmpty())
            throw new NoSuchElementException("lista nie zawiera elementów");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(list[0]));
        for (int j = 1; j < length(); j++) {
            stringBuilder.append(", ").append(list[j]);
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int currentIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < counter;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return list[currentIndex++];
            }
        };
    }
}
