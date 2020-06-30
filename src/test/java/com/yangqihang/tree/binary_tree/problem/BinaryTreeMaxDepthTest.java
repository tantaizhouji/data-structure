package com.yangqihang.tree.binary_tree.problem;

import com.yangqihang.tree.binary_tree.tree_example.NormalTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeMaxDepthTest {

    @Test
    public void maxDepthByTopDown() {
        int maxDepth = BinaryTreeMaxDepth.maxDepthByTopDown(NormalTree.root);
        System.out.println("TopDown: " + maxDepth);
    }

    @Test
    public void maxDepthByBottomUp() {
        int maxDepth = BinaryTreeMaxDepth.maxDepthByBottomUp(NormalTree.root);
        System.out.println("BottomUp: " + maxDepth);
    }
}