package pl.com.bottega.stack;

public interface MyStack<T> {

    // odkłada na szczyt stosu element t
    void push(T element);

    // zdjemuje ze szczytu stosu element i zwraca go, zwraca null jeśli stos pusty
    T pop();

    // zwraca informację czy są jakieś el. na stosie
    boolean empty();
}
