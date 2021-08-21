package solution.leetcode101.dfsbfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permuteUnique = permuteUnique(nums);
        for (List<Integer> list : permuteUnique) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> arrayList = new ArrayList<>();
        int n = nums.length;
        boolean[] visit = new boolean[n];
        dfs(0, n, visit, arrayList, set, nums);
        return new ArrayList<>(set);
    }

    public static void dfs(int depth, int n, boolean[] visit, List<Integer> arrayList, Set<List<Integer>> set, int[] nums) {
        if (depth == n) {
            set.add(new ArrayList<>(arrayList));
            return;
        }
        for (int j = 0; j < n; j++) {
            /*
            * 不用set去重
            * 主函数需要对nums进行排序 保证相邻数字在一起
            *  j>0 是为了让 nums[j-1] 不越界
            * if(visit[j] || (j > 0 && nums[i] == nums[i - 1] && vis[j - 1])
            * continue;
            * */
            if (!visit[j]) {//
                visit[j] = true;
                arrayList.add(nums[j]);
                dfs(depth + 1, n, visit, arrayList, set, nums);
                visit[j] = false;
                arrayList.remove(arrayList.size() - 1);
            }//
        }
    }
}
