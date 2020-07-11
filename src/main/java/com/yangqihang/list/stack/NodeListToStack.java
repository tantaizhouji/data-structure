package com.yangqihang.list.stack;

/**
 * 单向链表构成的栈
 */
public class NodeListToStack {
    public static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

    public static class NodeStack<T> {
        Node<T> top;

        public void push(T value) {
            if (top == null) {
                top = new Node<>(value);
            } else {
                Node<T> cur = new Node<>(value);
                cur.next = top;
                top = cur;
            }
        }

        public Node<T> pop() {
            if (top == null)
                throw new RuntimeException("stack is null, not pop something");
            Node<T> result = top;
            top = top.next;
            return result;
        }
    }

    public static void main(String[] args) {
        NodeStack<String> stack = new NodeStack<>();
        stack.push("1");
        stack.push("2");
        System.out.println(stack.pop().val);
        System.out.println(stack.pop().val);
    }
}
