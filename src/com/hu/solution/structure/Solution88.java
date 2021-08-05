package com.hu.solution.structure;

import java.util.Arrays;

public class Solution88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1,m,nums2,n);
        for (int i : nums1) {
            System.out.print(i+" ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = n + m -1, j = 0; i >= 0 && j < n; i--,j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}
