package com.yangqihang.tree.binary_tree.traverse;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树遍历工具类
 */
public final class BinaryTreeTraverse {

    /**
     * 前序遍历,使用递归的方法
     *
     * @param root 根节点
     */
    public static List<Integer> preOrderTraverse(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(root.getVal());                         // 先添加根节点
        result.addAll(preOrderTraverse(root.getLeft()));   // 然后添加左子树
        result.addAll(preOrderTraverse(root.getRight()));  // 最后添加右子树

        return result;
    }

    /**
     * 中序遍历,使用递归方法
     *
     * @param root 根节点
     * @return
     */
    public static List<Integer> inOrderTraverse(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.addAll(inOrderTraverse(root.getLeft()));  // 先添加左子树
        result.add(root.getVal());                       // 然后添加根节点
        result.addAll(inOrderTraverse(root.getRight())); // 最后添加右子树

        return result;
    }

    /**
     * 后序遍历,使用递归方法
     *
     * @param root 根节点
     * @return
     */
    public static List<Integer> postOrderTraverse(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.addAll(postOrderTraverse(root.getLeft()));  // 先添加左子树
        result.addAll(postOrderTraverse(root.getRight())); // 然后添加右子树
        result.add(root.getVal());                         // 最后添加根节点

        return result;
    }

    /**
     * 层序遍历,使用递归方法,这方法效率不是很好
     *
     * @param root 根节点
     * @return
     */
    public static List<List<Integer>> levelOrderTraverse(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 第一个添加的是本节点的值
        result.add(Arrays.asList(root.getVal()));

        List<List<Integer>> listLeft = levelOrderTraverse(root.getLeft());   // 获取左子树的集合
        List<List<Integer>> listRight = levelOrderTraverse(root.getRight()); // 获取右子树的集合
        List<Integer> mergeList = new ArrayList<>();                         // 新建临时同层次的过渡集合
        for (int i = 0; i < (Math.max(listLeft.size(), listRight.size())); i++) {
            if (i < listLeft.size()) {
                mergeList.addAll(listLeft.get(i));   // 如果左子树该层次存在,添加到过渡集合中
            }
            if (i < listRight.size()) {
                mergeList.addAll(listRight.get(i));  // 如果右子树该层次存在,添加到过渡集合中
            }
            result.add(mergeList);                   // 将整合了左右子树同层次的过渡集合添加到结果集合
            mergeList = new ArrayList<>();           // 重置过渡集合
        }

        return result;
    }
}
