package com.hu.solution.leetcode101.erfen;

//为33的变种
public class Solution81 {
    public boolean search(int[] nums, int target) {
        /*做法一 依靠核心类库 时间长一点 且不符合刷题的要求*/
//        Arrays.sort(nums);
//        int l = 0;
//        int r = nums.length-1;
//        while(l <= r){
//            int mid = (l+r)/2;
//            if(nums[mid] == target)
//                return true;
//            else if(nums[mid] > target)
//                r = mid-1;
//            else
//                l = mid+1;
//        }
//        return false;
        /*做法二 最快之一*/
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return true;
            // 因为有重复的值，如果中间数等于左边的 无法判断那个区间是递增的 l++一下
            if(nums[mid] == nums[l])
                l++;
//            对于当前的中点，如果它指向的值小于等于右端，那么说明右区间是排好序的；反之，那么说明左区间是排好序的。
            else if (nums[mid] <= nums[r]) {
//                又分为两种情况 在右区间或者不在右区间
                if (nums[r] >= target && nums[mid] < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            } else {
                if (target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return false;
    }

}
