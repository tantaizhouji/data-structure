package com.yangqihang.tree.binary_tree.problem;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;

/**
 * 通过给定的遍历构造二叉树工具类
 */
public final class BuildTree {

    /**
     * 通给中序遍历,后序遍历构造二叉树
     *
     * @return
     */
    public static BinaryTreeNode buildTreeByInAndPost(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0 || postOrder.length == 0) {
            return null;
        }

        // 获取后序遍历的长度
        int length = postOrder.length;
        // 后序遍历末尾值为根节点的值
        int rootVal = postOrder[length - 1];

        // 构造根节点
        BinaryTreeNode root = new BinaryTreeNode(rootVal);

        // 中序根节点标记位
        int inInx = 0;
        for (int i = 0; i < length; i++) {
            if (inOrder[i] == rootVal) {
                inInx = i; // 得到中序遍历中根节点的索引
                break;
            }
        }

        // 存放中序遍历的左子树
        int[] leftInOrder = new int[inInx];
        // 存放中序遍历的右子树
        int[] rightInOrder = new int[length - 1 - inInx];

        // 存放后序遍历的左子树
        int[] leftPostOrder = new int[inInx];
        // 存放后序遍历的右子树
        int[] rightPostOrder = new int[length - 1 - inInx];

        // 初始化左子树
        for (int i = 0; i < inInx; i++) {
            leftInOrder[i] = inOrder[i];
            leftPostOrder[i] = postOrder[i];
        }

        // 初始化右子树
        for (int i = 0; i < length - 1 - inInx; i++) {
            rightInOrder[i] = inOrder[inInx + i + 1];
            rightPostOrder[i] = postOrder[inInx + i];
        }

        root.setLeft(buildTreeByInAndPost(leftInOrder, leftPostOrder));
        root.setRight(buildTreeByInAndPost(rightInOrder, rightPostOrder));

        return root;
    }

    /**
     * 通过前序遍历,中序遍历构造二叉树
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static BinaryTreeNode buildTreeByInAndPre(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }

        // 获取遍历的长度
        int length = preOrder.length;
        // 前序遍历第一个为根节点的值
        int rootVal = preOrder[0];

        // 创建根节点
        BinaryTreeNode root = new BinaryTreeNode(rootVal);

        // 中序遍历根节点的索引
        int inInx = 0;
        for (int i = 0; i < length; i++) {
            if (inOrder[i] == rootVal) {
                inInx = i; // 从中序遍历中获取根节点的索引
                break;
            }
        }

        // 存放前序遍历的左子树
        int[] leftPreOrder = new int[inInx];
        // 存放前序遍历的右子树
        int[] rightPreOrder = new int[length - 1 - inInx];

        // 存放中序遍历的左子树
        int[] leftInOrder = new int[inInx];
        // 存放中序遍历的右子树
        int[] rightInOrder = new int[length - 1 - inInx];

        // 初始化左子树
        for (int i = 0; i < inInx; i++) {
            leftPreOrder[i] = preOrder[i + 1];
            leftInOrder[i] = inOrder[i];
        }

        // 初始化右子树
        for (int i = 0; i < length - 1 - inInx; i++) {
            rightPreOrder[i] = preOrder[1 + inInx + i];
            rightInOrder[i] = inOrder[1 + inInx + i];
        }

        root.setLeft(buildTreeByInAndPre(leftPreOrder, leftInOrder));
        root.setRight(buildTreeByInAndPre(rightPreOrder, rightInOrder));

        return root;
    }
}
