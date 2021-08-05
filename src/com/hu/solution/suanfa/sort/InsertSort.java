package com.hu.solution.suanfa.sort;

//稳定
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        insertSort(nums);
        for (int num : nums)
            System.out.print(num + " ");
    }
//每次都是在子序列中排序两两排序 排完序的子序列都是有序的
    private static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j-1]; j--) {
                swap(nums,j,j-1);
            }
        }
    }

    private static void swap(int[] nums, int num, int num1) {
        int temp = nums[num];
        nums[num] = nums[num1];
        nums[num1] = temp;
    }
}
