package com.hu.solution.structure;

import java.util.ArrayList;
import java.util.List;

public class Solution217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))
                return true;
            list.add(nums[i]);
        }
        return false;
    }
}
