package solution.everyday;

import java.util.HashMap;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {3, 2, 4};
        int target = sc.nextInt();
        System.out.println(twoSum(nums, target)[0] + " " + twoSum(nums, target)[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i]))
                return new int[] {hashMap.get(target-nums[i]),i};
            hashMap.put(nums[i],i);
        }
        return null;
    }
}

