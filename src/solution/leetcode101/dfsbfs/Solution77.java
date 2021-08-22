package solution.leetcode101.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> list1 = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return list;
    }

    public static void dfs(int u, int n, int k) {

        if (k == 0) {
            list.add(new ArrayList<>(list1));
            return;
        }
        for (int i = u; i <= n - k + 1; i++) {
            //i的范围是关键 当 n-i+1（剩余的可取值的数量）< k（还未填满的数的数量） 就不可能达到了
            //没有顺序 不用格外数组标记访问情况 如果是全排列问题 就需要标记数组来控制访问顺序
            list1.add(i);
            dfs(i + 1, n, k - 1);
            list1.remove(list1.size() - 1);
        }
    }
}
