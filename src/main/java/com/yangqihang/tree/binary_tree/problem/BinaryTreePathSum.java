package com.yangqihang.tree.binary_tree.problem;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;

/**
 * 二叉树路径总和工具类
 */
public final class BinaryTreePathSum {
    /**
     * 给定路径和sum,判断该树是否具有该路径和
     *
     * @param root 根节点
     * @param sum  给定路径和
     * @return 是否存在
     */
    public static boolean hasPathSum(BinaryTreeNode root, int sum) {
        if (root == null) {
            return false; // 根节点为不存在时,肯定不存在路径和
        }

        // 路径和减去当前节点的值
        sum = sum - root.getVal();
        if (root.getLeft() == null && root.getRight() == null) {
            return sum == 0; // 当前节点是叶子节点,且剩余路径为0,返回存在
        }

        if (hasPathSum(root.getLeft(), sum)) {
            return true; // 左子树找到了路径和,直接返回存在
        }

        // 返回右子树的路径和结果
        return hasPathSum(root.getRight(), sum);
    }

}
