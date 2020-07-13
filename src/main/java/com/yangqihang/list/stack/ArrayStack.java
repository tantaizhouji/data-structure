package com.yangqihang.list.stack;

/**
 * 数组实现栈
 */
public class ArrayStack<E> {
    private Object[] arr;
    private int index = 0;
    private final int size = 10;

    public ArrayStack() {
        arr = new Object[size];
    }

    public void push(E e) {
        if (index >= 10)
            throw new RuntimeException("stack is full");
        arr[index++] = e;
    }

    public E pop() {
        if (index <= 0)
            throw new RuntimeException("stack is null");
        return (E) arr[--index];
    }

    public E peek() {
        if (index <= 0)
            throw new RuntimeException("stack is null");
        return (E) arr[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

}
