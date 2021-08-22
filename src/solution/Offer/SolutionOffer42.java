package solution.Offer;
//剑指 Offer 42. 连续子数组的最大和
public class SolutionOffer42 {
//    方法一
    public int maxSubArray(int[] nums) {
        int sum = 0;//最大和
        int max = Integer.MIN_VALUE;//最小值
        for (int i = 0; i < nums.length; i++) {
//            这里的思想是：如果 和大于0就继续加，如果和小于零 此时的值无意义 就把和 设置成 当前的值
            if (sum <= 0)
                sum = nums[i];
            else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
//            每次判断完之后 要进行一次最大值的判断判断当前最大值和上一次最大值的大小
        }
        return max;
    }
//    方法二 动态规划 dp
    public int maxSubArray1(int[] nums){
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
