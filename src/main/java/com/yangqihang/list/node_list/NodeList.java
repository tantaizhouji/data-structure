package com.yangqihang.list.node_list;

/**
 * 单向链表
 */
public class NodeList {
    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 反转一个单向链表
     *
     * @param head
     * @return
     */
    public static Node reverseNodeList(Node head) {
        Node pre = null; // 指向前一个元素
        Node next; // 指向下一个元素
        while (head != null) { // 头节点不为null
            next = head.next; // 记录下头节点的下一个节点
            head.next = pre; // 头节点的下一个节点指向上一个节点
            pre = head; // 上一个指针指向头节点
            head = next; // 头指针指向下一个节点
        }
        return pre;
    }

    /**
     * 删除单向链表中指定的所有值
     *
     * @param head
     * @param value
     * @return
     */
    public static Node removeValue(Node head, int value) {
        while (head != null) { // 删除开头是需要删除的节点
            if (head.val != value) {
                break;
            }
            head = head.next;
        }
        // head来到第一个不需要删除的位置
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.val == value) {
                pre.next = cur.next; // 跳过当前节点
            } else {
                pre = cur; // 上一个指针知道当前位置
            }
            cur = cur.next; // 当前位置指向下一个位置
        }
        return head;
    }
}
