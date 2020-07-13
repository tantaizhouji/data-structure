package com.yangqihang.list.stack;

import com.yangqihang.list.queue.ArrayQueue;

/**
 * 2个队列实现栈
 */
public class TwoQueueImplementStack<E> {
    private ArrayQueue<E> queue;
    private ArrayQueue<E> help;

    public TwoQueueImplementStack() {
        queue = new ArrayQueue<>(20);
        help = new ArrayQueue<>(20);
    }

    public void push(E e) {
        queue.push(e); // 往queue中添加元素
    }

    public E pop() {
        if (queue.isEmpty())
            throw new RuntimeException("stack is null");
        while (queue.size() > 1) {
            help.push(queue.pop()); // 将queue中的元素除了最后一个转移到help中
        }
        E result = queue.pop();
        ArrayQueue<E> tmp = queue;
        queue = help;
        help = tmp;
        return result;
    }

}
