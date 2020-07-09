package com.yangqihang.list.node_list;

/**
 * 双向链表
 */
public class DoubleNodeList {
    private static class DoubleNode {
        int val;
        DoubleNode pre;
        DoubleNode next;

        public DoubleNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转双向链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
