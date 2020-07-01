package com.yangqihang.array.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        int[][] arr = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] merge = ArrayUtil.merge(arr);
        for (int i = 0; i < merge.length; i++) {
            System.out.print("[");
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j]);
                if (j != merge[i].length - 1) {
                    System.out.print(",");
                }
            }

            System.out.print("]");
            if (i != merge.length - 1) {
                System.out.print(",");
            }
        }
    }
}