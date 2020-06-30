package com.yangqihang.tree.binary_tree.problem;

import com.yangqihang.tree.binary_tree.tree_example.PathSumTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreePathSumTest {

    @Test
    public void hasPathSum() {
        boolean hasPathSum = BinaryTreePathSum.hasPathSum(PathSumTree.root, 22);
        System.out.println(hasPathSum);
    }
}