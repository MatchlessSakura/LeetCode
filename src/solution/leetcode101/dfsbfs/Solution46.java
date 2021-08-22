package solution.leetcode101.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();//存储所有结果
        if (len == 0) return res;
        List<Integer> path = new ArrayList<>(len);//存储每一次遍历结果
        boolean[] used = new boolean[len];//标记数组
        dfs(nums, 0, used, res, path);
        return res;
    }

    public static void dfs(int[] nums, int depth, boolean[] used, List<List<Integer>> res, List<Integer> path) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);//临时数组存数排列中每个数
                dfs(nums, depth + 1, used, res, path);
                used[i] = false;//回溯 方便上一层继续向下遍历
                path.remove(path.size() - 1);//回溯 删除不合适的刚遍历的下一层元素
            }
        }
    }

}

