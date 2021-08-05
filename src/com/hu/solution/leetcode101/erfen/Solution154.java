package com.hu.solution.leetcode101.erfen;
//153旋转数组最小值的变种
public class Solution154 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,4,5,5};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l < r){
            int mid = (l+r)/2;
            if(nums[mid] == nums[r])//☆☆☆☆☆
                // 由于存在重复元素，则可能存在极端情况，如：
                // 1,2,2,2,2 mid == end
                // 2,1,2,2,2 mid == end
                // 2,2,1,2,2 mid < end 左
                // 2,2,2,1,2 mid == end
                // 2,2,2,2,1 mid > end 右
                // 1,2,2,2,2 mid == end
                // 可见，mid==end时，无法确定最小元素是在左侧区间还是在右侧区间
                // 但可以直接忽略末尾元素，将右指针左移，因为末尾元素是不是最小值都无所谓，因为mid可以替代nums[mid] == nums[r]☆☆☆☆☆
                // 这时仍然符合二分的逻辑，只不过忽略的“右侧区间”比较小，只有一个元素
                --r;
            else if(nums[mid] < nums[r])
//                当前中间值小于最右边的值 说明右边是升序的也可能是有部分相同的
//                 所以最小值在mid左边 也可能是mid
                r = mid;
            else
//                当前中间值大于最右边的值 说明左边可能是升序的也可能是相同的 且右边有可能还有升部分 所以不能是mid 至少是mid+1
                l = mid + 1;

        }
        return nums[l];
    }
}
