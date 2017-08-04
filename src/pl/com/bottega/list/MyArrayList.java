package pl.com.bottega.list;

//Listą nazywamy generyczną strukturę danych utrzymującą porządek, która udostępnia następujące operacje:
//
//        void add(E e) - dodaje element na koniec listy
//        void remove(E e) - usuwa z listy pierwsze wsytąpienie elementu e
//        int length() - zwraca długość listy
//        void remove(int i) - usuwa z listy element występujący na pozycji i (i >= 0, i<length())
//        E first() - zwraca pierwszy element listy
//        E last() - zwraca ostatni element listy
//        E get(int i) - zwraca ostatni element listy
//
//        Stwórz interfejs MyList zawierający w.w. operacje oraz dwie jego implementcje MyArrayList i MyLinkedList.


import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList<E> {

    private E[] list;
    private int counter;

    public MyArrayList() {

        list = (E[]) new Object[100];
    }

    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.remove("one");
        System.out.println(list.ifEmpty());
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

}
