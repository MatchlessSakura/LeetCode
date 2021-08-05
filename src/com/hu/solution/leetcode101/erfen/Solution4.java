package com.hu.solution.leetcode101.erfen;

public class Solution4 {
    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        if (nums1.length != 0 && nums2.length != 0) {
            int i = 0;
            int j = 0;
            int index = 0;
            while (i != nums1.length || j != nums2.length) {
                if (nums2[j] >= nums1[i]) {
                    arr[index++] = nums1[i++];
                } else {
                    arr[index++] = nums2[j++];
                }
                if (i == nums1.length) {
                    while (j != nums2.length)
                        arr[index++] = nums2[j++];
                } else if (j == nums2.length) {
                    while (i != nums1.length)
                        arr[index++] = nums1[i++];
                }
            }
        } else {
            if (nums1.length == 0) {
                if (nums2.length % 2 == 0)
                    return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
                else
                    return nums2[nums2.length / 2] * 1.0;
            } else{
                if (nums1.length % 2 == 0)
                    return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
                else
                    return nums1[nums1.length / 2] * 1.0;
            }
        }
        if (arr.length % 2 == 0)
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
        else
            return arr[arr.length / 2] * 1.0;
    }
}
