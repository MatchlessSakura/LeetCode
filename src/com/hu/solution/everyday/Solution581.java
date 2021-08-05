package com.hu.solution.everyday;

public class Solution581 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 6};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, right = -1;
        int min = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (max > nums[i]) {// 从左往右 如果中间某个值比他后面的值大 说明此值需要排序
                right = i;//纪录最右需要排序的值
            } else {
                max = nums[i];
            }
            if (min < nums[n - i - 1]) {// 从右往左 如果中间某个值比他前面的值小 说明此值需要排序
                left = n - i - 1;//纪录最左需要排序的值
            } else {
                min = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;//特点判断 数组有序的情况
    }
}
