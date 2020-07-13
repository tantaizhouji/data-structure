package com.yangqihang.list.queue;

/**
 * 数组实现队列,环形数组,ringBuffer
 */
public class ArrayQueue<E> {
    private int size = 0;
    private int pushInx = 0;
    private int popInx = 0;
    private int limit;
    private Object[] arr;

    public ArrayQueue(int limit) {
        arr = new Object[limit];
        this.limit = limit;
    }

    public void push(E e) {
        if (size == limit)
            throw new RuntimeException("stack is full");
        size++;
        arr[pushInx] = e;
        pushInx = nextInx(pushInx);
    }

    public E pop() {
        if (size == 0)
            throw new RuntimeException("stack is null");
        size--;
        E e = (E) arr[popInx];
        popInx = nextInx(popInx);
        return e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int nextInx(int index) {
        return index < limit - 1 ? index + 1 : 0;
    }

}
