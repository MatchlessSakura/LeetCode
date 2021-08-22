package solution.structure;

public class Solution53 {
    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
//        这里最大值要等于数组的第一个数 要不然在只有一个且为负数时，最大值会是0
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(sum > 0)
                sum  += nums[i];
            else
                sum = nums[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}
