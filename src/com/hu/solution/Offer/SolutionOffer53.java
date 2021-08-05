package com.hu.solution.Offer;

//剑指 Offer 53 - I. 在排序数组中查找数字 I 同167
public class SolutionOffer53 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int firstposition = findFirstPosition(nums, target);
        if (firstposition == -1)
            return 0;
        int lastposition = findLastPosition(nums, target);
        return lastposition - firstposition + 1;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
//        这里用（right-left）/2 是为了避免数组过大的时候直接相加再/2可能造成溢出
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            //这里下面的两个else可以合并 合并后结果为right = mid 减少判断 但是可能再nums[mid] > target 时会多循环一次
            //else
            //   right = mid;
            else if (nums[mid] == target) {
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target)
            return left;
        else
            return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //        （right-left +1）/2 是为了防止死循环,而且只能是找右边界时
            int mid = left + (right - left + 1) / 2;
//            前两个判断也可以合并 情况和上面相同 就是nums[mid] < target 时会多循环一次
//            if（nums[mid] <= target）
//                left = mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}

