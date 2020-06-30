package com.yangqihang.array.util;

import org.junit.Test;

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
        int index = ArrayUtil.searchInsert(nums, 11);
        System.out.println(index);
    }
}