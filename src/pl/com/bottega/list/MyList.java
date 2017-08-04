package pl.com.bottega.list;

public interface MyList<E> {

    void add(E e);                  // dodaje element na koniec listy

    void remove(E e);               // usuwa z listy pierwsze wsytąpienie elementu e

    int length();                   // zwraca długość listy

    void remove(int i);             // usuwa z listy element występujący na pozycji i (i >= 0, i<length())

    E first();                      //zwraca pierwszy element listy

    E last();                       //zwraca ostatni element listy

    E get(int i);                   //zwraca ostatni element listy

    boolean containElement(E e);    //zwraca true jeśli element znajduje się na liście

    int indexOf(E element);         //zwraca indeks zadanego elementu na liście lub -1 jeśli element nie istnieje

    boolean ifEmpty();              //zwraca true jeżeli lista nie zawiera elementów

    boolean outOfBounds(int i);     //zwraca true jak index jest z zakresu listy

    void clear();                   //usuwa wszystkie elemnty z listy
}
