package com.yangqihang.tree.binary_tree.problem;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;

/**
 * 二叉树最大深度工具类
 */
public final class BinaryTreeMaxDepth {

    /**
     * "自顶向下"方案解决二叉树的最大深度,用了一个深度的函数
     *
     * @param root 根节点
     * @return maxDepth 树的最大深度
     */
    public static int maxDepthByTopDown(BinaryTreeNode root) {
        return topDown(root, 1);
    }

    /**
     * "自顶向下"递归求最大深度
     *
     * @param root  根节点
     * @param depth 根节点的深度
     * @return 子树的最大深度
     */
    private static int topDown(BinaryTreeNode root, int depth) {
        if (root == null) {
            return depth - 1; // 如果根节点不存在,深度需要-1
        }

        int leftDepth = topDown(root.getLeft(), depth + 1);   // 获取左子树的深度,左节点的深度是根节点深度+1
        int rightDepth = topDown(root.getRight(), depth + 1); // 获取右子树的深度,右节点的深度是根节点深度+1

        return Math.max(leftDepth, rightDepth);
    }

    /**
     * "自底向上"方案解决二叉树的最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepthByBottomUp(BinaryTreeNode root) {
        if (root == null) {
            return 0; // 根节点为空,该处节点深度为0
        }

        // 返回左右子树最大深度+1
        return Math.max(maxDepthByBottomUp(root.getLeft()), maxDepthByBottomUp(root.getRight())) + 1;
    }
}
