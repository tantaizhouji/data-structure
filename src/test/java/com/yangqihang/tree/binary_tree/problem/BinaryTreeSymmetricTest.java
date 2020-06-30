package com.yangqihang.tree.binary_tree.problem;

import com.yangqihang.tree.binary_tree.node.BinaryTreeNode;
import com.yangqihang.tree.binary_tree.traverse.BinaryTreeTraverse;
import com.yangqihang.tree.binary_tree.tree_example.NotSymmetricTree;
import com.yangqihang.tree.binary_tree.tree_example.SymmetricTree;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeSymmetricTest {

    @Test
    public void isSymmetric() {
        boolean symmetric = BinaryTreeSymmetric.isSymmetric(NotSymmetricTree.root);
        System.out.println("Symmetric: " + symmetric);
    }
}