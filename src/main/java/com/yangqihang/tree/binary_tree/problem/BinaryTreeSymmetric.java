package com.yangqihang.tree.binary_tree.problem;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;
import com.yangqihang.tree.binary_tree.traverse.BinaryTreeTraverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树是否镜像对称工具类
 */
public final class BinaryTreeSymmetric {

    /**
     * 判断二叉树是否是镜像对称,递归的方法
     *
     * @param root 根节点
     * @return 是否镜像对称
     */
    public static boolean isSymmetric(BinaryTreeNode root) {
        if (root == null) {
            return true; // 根节点不存在,也算镜像对称
        }

        // 左子树和右子树镜像前序遍历比较
        return preOrderCheck(root.getLeft(), root.getRight());
    }

    /**
     * 左子树和右子树前序比较的递归方法判断左右子树是否相等
     *
     * @param leftTreeRoot  左子树根节点
     * @param rightTreeRoot 右子树根节点
     * @return
     */
    private static boolean preOrderCheck(BinaryTreeNode leftTreeRoot, BinaryTreeNode rightTreeRoot) {
        if (leftTreeRoot == null && rightTreeRoot == null) {
            return true; // 左子树和右子树都不存在,返回true
        }

        if (leftTreeRoot == null || rightTreeRoot == null) {
            return false; // 一边不存在,不镜像对称
        }

        if (leftTreeRoot.getVal() != rightTreeRoot.getVal()) {
            return false; // 左右子树根节点的值不相同,不镜像对称
        }

        if (!preOrderCheck(leftTreeRoot.getLeft(), rightTreeRoot.getRight())) {
            return false; // 左子树的左节点和右子树的右节点比较,不相等则是非镜像对称
        }

        // 左子树的有节点和右子树的左节点比较,不相等则是非镜像对称
        return preOrderCheck(leftTreeRoot.getRight(), rightTreeRoot.getLeft());
    }
}
