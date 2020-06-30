package com.yangqihang.tree.binary_tree.tree_example;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;

public class NormalTree {
    public static BinaryTreeNode root;
    private static BinaryTreeNode node2;
    private static BinaryTreeNode node3;
    private static BinaryTreeNode node4;
    private static BinaryTreeNode node5;
    private static BinaryTreeNode node6;
    private static BinaryTreeNode node7;
    private static BinaryTreeNode node8;
    private static BinaryTreeNode node9;

    static {
        root = new BinaryTreeNode(1);
        node2 = new BinaryTreeNode(2);
        node3 = new BinaryTreeNode(3);
        node4 = new BinaryTreeNode(4);
        node5 = new BinaryTreeNode(5);
        node6 = new BinaryTreeNode(6);
        node7 = new BinaryTreeNode(7);
        node8 = new BinaryTreeNode(8);
        node9 = new BinaryTreeNode(9);

        root.setLeft(node2);
        root.setRight(node7);

        node2.setLeft(node3);
        node2.setRight(node4);

        node3.setRight(node5);

        node4.setLeft(node6);

        node7.setRight(node8);

        node8.setLeft(node9);
    }
}
