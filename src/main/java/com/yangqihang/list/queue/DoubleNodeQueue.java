package com.yangqihang.list.queue;

/**
 * 双向链表实现队列
 */
public class DoubleNodeQueue {
    public static class Node<E> {
        E val;
        Node<E> pre;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }

    public static class DoubleNodeList<E> {
        Node<E> head;
        Node<E> tail;

        public void addFromHead(E e) {
            Node<E> cur = new Node<>(e);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
        }

        public void addFromBottom(E e) {
            Node<E> cur = new Node<>(e);
            if (tail == null) {
                tail = cur;
                head = cur;
            } else {
                cur.pre = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        public E popFormHead() {
            if (head == null)
                throw new RuntimeException("null is stack");
            Node<E> cur = head;
            head = head.next;
            head.pre = null;
            return cur.val;
        }

        public E popFormBottom() {
            if (tail == null)
                throw new RuntimeException("null is stack");
            Node<E> cur = tail;
            tail = tail.pre;
            tail.next = null;
            return cur.val;
        }
    }

    /**
     * 双链表实现队列
     *
     * @param <E>
     */
    public static class MyQueue<E> {
        private DoubleNodeList<E> list;

        public MyQueue() {
            list = new DoubleNodeList<>();
        }

        public void push(E e) {
            list.addFromHead(e);
        }

        public E pop() {
            return list.popFormBottom();
        }
    }
}
