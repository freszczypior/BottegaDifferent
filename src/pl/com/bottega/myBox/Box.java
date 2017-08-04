package pl.com.bottega.myBox;

public class Box<T> {

    private T element;

    public Box(){}

    public Box(T element) {
        this.element = element;
    }

    public boolean empty(){
            return element == null;
    }

    public void add(T element) {
        if (!empty())
            throw new IllegalStateException("pudełko nie jest puste");
        else
        this.element = element;
    }

    public T pull() {
        if (empty())
            throw new IllegalStateException("pudełko nie jest puste");
        else {
            T temp = element;
            element = null;
            return temp;
        }
    }
}
