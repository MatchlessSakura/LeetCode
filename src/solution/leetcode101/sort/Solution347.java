package solution.leetcode101.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
//        统计数字频率 
        for (int num : nums) {
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] lists = new List[nums.length+1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int x = map.get(key);
            if(lists[x] == null)
                lists[x] = new ArrayList<>();
            lists[x].add(key);
        }
        // 倒序遍历数组获取出现顺序从大到小的排列
        List<Integer> arrayList = new ArrayList<>();
        for (int i = lists.length-1; i >= 0 && arrayList.size() < k; i--) {
            if(lists[i] == null)//没出现过
                continue;
            arrayList.addAll(lists[i]);// 如果当前下标里有数 就把所有的数存进去(因为可能有 不同的数出现相同的频率 所以addAll)
        }
        int[] ans = new int[k];
        for (int i = 0; i < arrayList.size(); i++) {
            ans[i] = arrayList.get(i);
        }
        return ans;
    }
}
