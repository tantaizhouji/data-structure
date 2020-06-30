package com.yangqihang.tree.binary_tree.traverse;

import com.yangqihang.tree.binary_tree.tree_example.NormalTree;
import com.yangqihang.tree.binary_tree.tree_example.PathSumTree;
import com.yangqihang.tree.binary_tree.tree_example.SymmetricTree;
import org.junit.Test;

import java.util.List;

public class BinaryTreeTraverseTest {

    @Test
    public void preOrderTraverse() {
        List<Integer> integers = BinaryTreeTraverse.preOrderTraverse(SymmetricTree.root);
        System.out.printf("PreOrderTraverse: ");
        integers.forEach(i -> System.out.printf(i + ", "));
    }

    @Test
    public void inOrderTraverse() {
        List<Integer> integers = BinaryTreeTraverse.inOrderTraverse(NormalTree.root);
        System.out.printf("InOrderTraverse: ");
        integers.forEach(i -> System.out.printf(i + ", "));
    }

    @Test
    public void postOrderTraverse() {
        List<Integer> integers = BinaryTreeTraverse.postOrderTraverse(NormalTree.root);
        System.out.printf("PostOrderTraverse: ");
        integers.forEach(i -> System.out.printf(i + ", "));
    }

    @Test
    public void levelOrderTraverse() {
        List<List<Integer>> lists = BinaryTreeTraverse.levelOrderTraverse(PathSumTree.root);
        System.out.printf("LevelOrderTraverse: ");
        lists.forEach(list -> System.out.printf(list.toString() + ", "));
    }
}