package com.yangqihang.array.util;

import java.util.*;

/**
 * 数组工具类
 */
public final class ArrayUtil {

    /**
     * 输出中心索引,索引左边和等于索引右边和,计算了左边的和,右边的和,效率慢
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        // 结果索引,默认为-1没有
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;  // 存放索引左边数值和
            int rightSum = 0; // 存放索引右边数值和

            for (int j = 0; j < i; j++) {
                leftSum += nums[j]; // 累加左边所有数值
            }

            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j]; // 累加右边所有数值
            }

            if (leftSum == rightSum) {
                result = i; // 左边和等于右边和,结果为当前索引下标
                break; // 跳出循环
            }
        }

        return result; // 没有满足返回-1
    }

    /**
     * 输出中心索引,利用左边的2倍+索引值等于全和,效率提高
     *
     * @param nums
     * @return
     */
    public static int pivotIndex2(int[] nums) {
        // 结果索引值,默认-1
        int result = -1;

        // 存放数组所有值的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 累加所有值
        }

        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0; // 存放中心索引左边和
            for (int j = 0; j < i; j++) {
                leftSum += nums[j]; // 累加左边和
            }

            if (leftSum * 2 + nums[i] == sum) {
                result = i; // 左边值乘2加索引值为总的和,结果为中心索引值
                break; // 跳出循环
            }
        }

        return result;
    }

    /**
     * 求中心索引,最快的方法
     *
     * @param nums
     * @return
     */
    public static int pivotIndex3(int[] nums) {
        int result = -1;  // 结果索引位置
        int leftSum = 0;  // 左边和
        int rightSum = 0; // 右边和
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i]; // 由于从第一个开始,右边和为全部的和
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i]; // 右边和减去当前索引的值
            if (leftSum == rightSum) {
                result = i; // 左边和等于右边和,得到结果中心索引
                break; // 跳出循环
            } else {
                leftSum += nums[i]; // 左边不等于右边,移动索引位置,累加左边和
            }
        }

        return result;
    }

    /**
     * 搜索插入位置,使用了二分法查找
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return 数组中找到目标值, 返回其索引;如果目标值不存于数组中,返回它将会被按顺序插入的位置
     */
    public static int searchInsert(int[] nums, int target) {
        // 获取数组的长度
        int length = nums.length;
        if (length == 0 || target <= nums[0]) {
            return 0; // 如果目标值小于等于数组中第一个元素或者数组为空,返回索引0
        }
        if (target > nums[length - 1]) {
            return length; // 如果目标值大于数组最后一个元素,返回末尾添加一位的索引
        }
        if (target == nums[length - 1]) {
            return length - 1; // 如果目标值等于最后一个元素,返回最后一个元素的索引
        }

        int preInx = 0; // 记录前面的索引位置
        int postInx = length - 1; // 记录后面的索引位置
        int midInx = (preInx + postInx) / 2; // 从中间位置开始比较
        while (preInx != midInx && postInx != midInx) {
            if (target == nums[midInx]) {
                return midInx; // 中间值与目标值相等,返回中间值索引
            }
            if (target > nums[midInx]) {
                preInx = midInx;
                midInx = (midInx + postInx) / 2;
            } else {
                postInx = midInx;
                midInx = (preInx + midInx) / 2;
            }
        }

        // 目标值不存在数组中,插入位置是二分索引+1
        return midInx + 1;
    }

    /**
     * 合并区间,将重叠的区间合并,自己写的有点混乱
     * 思路:
     * 1.按照左边界从小到大对区间数组进行排序
     * 2.遍历合并
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        // 用来排序的集合
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1; // 如果o1的左边界大于o2的左边界,左边界小的放到前面
                } else if (o1[0] == o2[0]) {
                    // 左边界相同

                    if ((o1[1] - o1[0]) < (o2[1] - o2[0])) {
                        return 1; //  区间大的放到前面
                    }
                }
                return -1;
            }
        });

        // 区间按照排序规则排序
        set.addAll(Arrays.asList(intervals));

        // 创建数组集合,存放合并之后的数组集
        List<int[]> list = new ArrayList<>();

        set.forEach(i -> {
            // 遍历待合并区间数组

            // 是否需要合并的标志,默认false,不需要合并
            boolean flag = false;

            for (int[] ints : list) {
                // 遍历合并后的区间集合

                if (ints[0] > i[1] || ints[1] < i[0]) {
                    // 合并集合中区间的左边界大于待合并区间的右边界,或合并集合中区间的右边界小于待合并区间的左边界,表明没有交集,不需要合并

                } else {
                    // 满足合并条件,合并
                    ints[0] = Math.min(ints[0], i[0]); // 左边界去最小值
                    ints[1] = Math.max(ints[1], i[1]); // 右边界取最大值

                    flag = true;
                    break;
                }
            }

            if (!flag) {
                // 没有合并,将区间添加到集合中
                list.add(i);
            }
        });

        int[][] result = new int[list.size()][2];
        list.toArray(result); // 集合转到数组中

        return result;
    }

}
