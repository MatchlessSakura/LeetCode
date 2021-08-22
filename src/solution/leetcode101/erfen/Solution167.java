package solution.leetcode101.erfen;
//同剑指offer53
public class Solution167 {
    public  static int[] left(int[] numbers, int target){
        int l = 0;
        int r = numbers.length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(numbers[l] + numbers[r] == target)
                return new int[]{l+1,r+1};
            else if(numbers[l] + numbers[r] > target)
                r--;
            else
                l++;
        }
        return null;
    }
}
