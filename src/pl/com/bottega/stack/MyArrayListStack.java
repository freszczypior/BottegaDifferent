package pl.com.bottega.stack;

import pl.com.bottega.list.MyArrayList;

public class MyArrayListStack<T> implements MyStack<T>{

    MyArrayList<T> stack = new MyArrayList<>();

    @Override
    public void push(T items) {
        stack.add(items);
    }

    @Override
    public T pop() {
        if (empty())
            return null;
        T temp = stack.last();
        stack.remove(temp);
        return temp;
    }

    @Override
    public boolean empty() {
        return stack.ifEmpty();
    }
}
