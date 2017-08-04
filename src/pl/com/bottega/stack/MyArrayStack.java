package pl.com.bottega.stack;

public class MyArrayStack<T> implements MyStack<T> {

    private T[] stack;
    private int counter;

    public MyArrayStack() {
        stack = (T[]) new Object[10];
    }

    @Override
    public void push(T items) {
        if (counter == stack.length) {
            T[] newStack = (T[]) new Object[stack.length + 10];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[counter] = items;
        counter++;
    }

    @Override
    public T pop() {
        if (empty())
            return null;
        T temp = stack[counter - 1];
        stack[counter - 1] = null;
        counter--;
        return temp;
    }

    @Override
    public boolean empty() {
        return counter < 1;
    }
}
