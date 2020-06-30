package com.yangqihang.tree.binary_tree.tree_example;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;

public class PathSumTree {
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
        root = new BinaryTreeNode(5);
        node2 = new BinaryTreeNode(4);
        node3 = new BinaryTreeNode(8);
        node4 = new BinaryTreeNode(11);
        node5 = new BinaryTreeNode(13);
        node6 = new BinaryTreeNode(4);
        node7 = new BinaryTreeNode(7);
        node8 = new BinaryTreeNode(2);
        node9 = new BinaryTreeNode(1);

        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);

        node3.setLeft(node5);
        node3.setRight(node6);

        node4.setLeft(node7);
        node4.setRight(node8);

        node6.setRight(node9);
    }
}
