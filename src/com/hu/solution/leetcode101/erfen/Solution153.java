package com.hu.solution.leetcode101.erfen;
//旋转数组最小值 变种：154
public class Solution153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l < r){
            int mid = (l+r)/2;
            if(nums[mid] < nums[r])
//                当前中间值小于最右边的值 说明右边是升序的 左边可能由升序到最初值 [5,6,7,0,1,2,3,4] [5,6,1,2,3]
//                 所以最小值在mid左边 也可能是mid                                  ⬆mid          ⬆mid
                r = mid;
            else
//                当前中间值大于最右边的值 说明左边是升序的 且右边有可能还有升部分 所以不能是mid 至少是mid+1
                l = mid + 1;

        }
        return nums[l];
    }
}
