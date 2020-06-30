package com.yangqihang.tree.binary_tree.problem;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;
import com.yangqihang.tree.binary_tree.traverse.BinaryTreeTraverse;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BuildTreeTest {

    @Test
    public void buildTreeByInAndPost() {
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        BinaryTreeNode root = BuildTree.buildTreeByInAndPost(inOrder, postOrder);
        System.out.println(root);
    }

    @Test
    public void buildTreeByInAndPre() {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        BinaryTreeNode root = BuildTree.buildTreeByInAndPre(preOrder, inOrder);
        System.out.println(root);
    }
}