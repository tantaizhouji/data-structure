package com.yangqihang.list.queue;

import com.yangqihang.list.stack.ArrayStack;

/**
 * 2个栈实现队列
 */
public class TwoStackImplementQueue<E> {
    private ArrayStack<E> stackPush;
    private ArrayStack<E> stackPop;

    public TwoStackImplementQueue() {
        stackPush = new ArrayStack<>();
        stackPop = new ArrayStack<>();
    }

    public void push(E e) {
        stackPush.push(e);
    }

    public E pop() {
        if (stackPush.isEmpty() && stackPop.isEmpty())
            throw new RuntimeException("queue is null");
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop()); // help为空的时候,将stack中的元素转移到help中
            }
        }
        return stackPop.pop(); // help不为空时,直接从help中弹出
    }

    public static void main(String[] args) {
        TwoStackImplementQueue<String> queue = new TwoStackImplementQueue<>();
        queue.push("a");
        queue.push("b");
        queue.push("c");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push("d");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
