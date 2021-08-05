package com.hu.solution.leetcode101.sort;

public class Solution75 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static void sortColors(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
//        桶排序
        int[] bucket = new int[3];
        for (int num : nums) {
            bucket[num]++;
        }
        for (int i = 0, j = 0; i < 3; i++) {
            while(bucket[i] > 0) {
                nums[j++] = i;
                bucket[i]--;
            }
        }
//        直接赋值
        int p0 = -1, p1 = -1;
        for(int p2 = 0; p2 < nums.length; p2 ++){
            int tmp = nums[p2];
            if(tmp <= 2) nums[p2] = 2;
            if(tmp <= 1) nums[++p1] = 1;
            if(tmp == 0) nums[++p0] = 0;
        }

    }
//    快排
    public static void quickSort(int[] nums, int left, int right) {
        if(left > right)
            return;
        int l = left;
        int r = right;
        int key = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= key)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= key)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = key;
        quickSort(nums, left, l - 1);
        quickSort(nums, r + 1, right);
    }
}
