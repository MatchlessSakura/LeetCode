package solution.leetcode101.erfen;

public class Solution540 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(singleNonDuplicate(nums));
    }
//仅对偶数索引进行二分搜索
    public static int singleNonDuplicate(int[] nums) {
       int l = 0;
       int r = nums.length-1;
       while (l < r){
           int mid = (l+r)/2;
           if(mid % 2 != 0)
               mid--;
//      在该算法中，我们对所有偶数索引进行搜索，直到遇到第一个其后元素不相同的索引
           if(nums[mid] == nums[mid+1])
                l = mid + 2;
//           如果不是，则我们知道单个元素位于 mid，或者在 mid 之前(插进来的数必为偶数索引)。我们将 r  设置为 mid。
//           一旦 l == r，则当前搜索空间为 1 个元素，那么该元素为单个元素，我们将返回它
           else
               r = mid;

       }
       return nums[l];
    }
}
