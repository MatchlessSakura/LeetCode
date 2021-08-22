package solution.leetcode101.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, target, candidates, arrayList, list);
        return list;
    }
    private static void dfs(int x, int target,int[] candidates, List<Integer> arrayList, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(arrayList));
            return;
        }
        for (int i = x; i < candidates.length; i++) {
            //大剪枝
            if(target -candidates[i] < 0)
                break;
            //进一步剪枝 同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过
            if (i > x && candidates[i] == candidates[i-1])
                continue;
            arrayList.add(candidates[i]);
            dfs(i+1, target-candidates[i],  candidates, arrayList, list);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
