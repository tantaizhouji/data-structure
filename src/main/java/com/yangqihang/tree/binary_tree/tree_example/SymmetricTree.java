package com.yangqihang.tree.binary_tree.tree_example;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;

public class SymmetricTree {
    public static BinaryTreeNode root;
    private static BinaryTreeNode node2;
    private static BinaryTreeNode node3;
    private static BinaryTreeNode node4;
    private static BinaryTreeNode node5;
    private static BinaryTreeNode node6;
    private static BinaryTreeNode node7;
    private static BinaryTreeNode node8;
    private static BinaryTreeNode node9;
    private static BinaryTreeNode node10;
    private static BinaryTreeNode node11;
    private static BinaryTreeNode node12;
    private static BinaryTreeNode node13;
    private static BinaryTreeNode node14;
    private static BinaryTreeNode node15;

    static  {
        root = new BinaryTreeNode(1);
        node2 = new BinaryTreeNode(2);
        node3 = new BinaryTreeNode(2);
        node4 = new BinaryTreeNode(3);
        node5 = new BinaryTreeNode(4);
        node6 = new BinaryTreeNode(4);
        node7 = new BinaryTreeNode(3);
        node8 = new BinaryTreeNode(5);
        node9 = new BinaryTreeNode(6);
        node10 = new BinaryTreeNode(7);
        node11 = new BinaryTreeNode(8);
        node12 = new BinaryTreeNode(8);
        node13 = new BinaryTreeNode(7);
        node14 = new BinaryTreeNode(6);
        node15 = new BinaryTreeNode(5);

        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node4.setLeft(node8);
        node4.setRight(node9);

        node5.setLeft(node10);
        node5.setRight(node11);

        node6.setLeft(node12);
        node6.setRight(node13);

        node7.setLeft(node14);
        node7.setRight(node15);
    }
}
