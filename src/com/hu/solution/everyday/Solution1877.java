package com.hu.solution.everyday;

import java.util.Arrays;

public class Solution1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int min = -1;
        for (int i = 0; i < nums.length / 2; i++) {
            min = Math.max(min, nums[i] + nums[nums.length - 1 - i]);
        }
        return min;
    }
}
