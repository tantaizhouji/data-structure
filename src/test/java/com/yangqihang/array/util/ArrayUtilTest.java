package com.yangqihang.array.util;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ArrayUtilTest {

    @Test
    public void pivotIndex() {
        int[] nums = {-1, -1, 0, 1, 1, 1};
        int index = ArrayUtil.pivotIndex(nums);
        System.out.println(index);
    }

    @Test
    public void pivotIndex2() {
        int[] nums = {-1, -1, 0, 1, 1, 1};
        int index = ArrayUtil.pivotIndex2(nums);
        System.out.println(index);
    }

    @Test
    public void pivotIndex3() {
        int[] nums = {3, 7, 1, 6, 5, 6};
        int index = ArrayUtil.pivotIndex3(nums);
        System.out.println(index);
    }

    @Test
    public void searchInsert() {
        int[] nums = {1, 3, 5, 7, 9, 11};
        int index = ArrayUtil.searchInsert(nums, 13);
        System.out.println(index);
    }

    @Test
    public void merge() {
        int[][] arr1 = new int[][]{{2, 3}, {0, 1}, {1, 2}, {3, 4}, {4, 5}, {1, 1}, {0, 1}, {4, 6}, {5, 7}, {1, 1}, {3, 5}};
        int[][] arr2 = new int[][]{{0, 0}, {1, 2}, {5, 5}, {2, 4}, {3, 3}, {5, 6}, {5, 6}, {4, 6}, {0, 0}, {1, 1}, {0, 2}, {4, 5}};
        int[][] arr3 = new int[][]{{2, 2}, {1, 3}, {3, 3}, {3, 4}, {2, 3}, {4, 5}, {4, 4}};
        String test1 = Arrays.deepToString(ArrayUtil.merge(arr1));
        String test2 = Arrays.deepToString(ArrayUtil.merge(arr2));
        String test3 = Arrays.deepToString(ArrayUtil.merge(arr3));
        if (!test1.equals(Arrays.deepToString(new int[][]{{0, 7}}))) {
            throw new RuntimeException("测试arr1不通过");
        }
        if (!test2.equals(Arrays.deepToString(new int[][]{{0, 6}}))) {
            throw new RuntimeException("测试arr2不通过");
        }
        if (!test3.equals(Arrays.deepToString(new int[][]{{1, 5}}))) {
            throw new RuntimeException("测试arr3不通过");
        }

    }

    @Test
    public void merge2() {
        int[][] arr1 = new int[][]{{2, 3}, {0, 1}, {1, 2}, {3, 4}, {4, 5}, {1, 1}, {0, 1}, {4, 6}, {5, 7}, {1, 1}, {3, 5}};
        int[][] arr2 = new int[][]{{0, 0}, {1, 2}, {5, 5}, {2, 4}, {3, 3}, {5, 6}, {5, 6}, {4, 6}, {0, 0}, {1, 1}, {0, 2}, {4, 5}};
        int[][] arr3 = new int[][]{{2, 2}, {1, 3}, {3, 3}, {3, 4}, {2, 3}, {4, 5}, {4, 4}};
        String test1 = Arrays.deepToString(ArrayUtil.merge2(arr1));
        String test2 = Arrays.deepToString(ArrayUtil.merge2(arr2));
        String test3 = Arrays.deepToString(ArrayUtil.merge2(arr3));
        if (!test1.equals(Arrays.deepToString(new int[][]{{0, 7}}))) {
            throw new RuntimeException("测试arr1不通过");
        }
        if (!test2.equals(Arrays.deepToString(new int[][]{{0, 6}}))) {
            throw new RuntimeException("测试arr2不通过");
        }
        if (!test3.equals(Arrays.deepToString(new int[][]{{1, 5}}))) {
            throw new RuntimeException("测试arr3不通过");
        }

    }

    @Test
    public void rotate() {
        int[][] matrix1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix2 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        ArrayUtil.rotate(matrix1);
        ArrayUtil.rotate(matrix2);
        int[][] expect1 = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        int[][] expect2 = {{4, 3, 2, 1}, {4, 3, 2, 1}, {4, 3, 2, 1}, {4, 3, 2, 1}};
        if (!(Arrays.deepEquals(matrix1, expect1) && Arrays.deepEquals(matrix2, expect2))) {
            throw new RuntimeException("测试不通过");
        }
    }

    @Test
    public void rotate2() {
        int[][] matrix1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix2 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        ArrayUtil.rotate2(matrix1);
        ArrayUtil.rotate2(matrix2);
        int[][] expect1 = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        int[][] expect2 = {{4, 3, 2, 1}, {4, 3, 2, 1}, {4, 3, 2, 1}, {4, 3, 2, 1}};
        if (!(Arrays.deepEquals(matrix1, expect1) && Arrays.deepEquals(matrix2, expect2))) {
            throw new RuntimeException("测试不通过");
        }
    }

}