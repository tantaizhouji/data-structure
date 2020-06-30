package com.yangqihang.tree.binary_tree.tree_example;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;

public class NotSymmetricTree {
    public static BinaryTreeNode root;
    private static BinaryTreeNode node2;
    private static BinaryTreeNode node3;
    private static BinaryTreeNode node4;
    private static BinaryTreeNode node5;

    static  {
        root = new BinaryTreeNode(1);
        node2 = new BinaryTreeNode(2);
        node3 = new BinaryTreeNode(2);
        node4 = new BinaryTreeNode(2);
        node5 = new BinaryTreeNode(2);

        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);

        node3.setLeft(node5);
    }
}
