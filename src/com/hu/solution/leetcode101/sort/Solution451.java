package com.hu.solution.leetcode101.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution451 {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        char[] chars = s.toCharArray();
//       统计频率
        for (char aChar : chars) {
            if(map.containsKey(aChar))
                map.put(aChar,map.get(aChar)+1);
            else
                map.put(aChar,1);
            max = Math.max(max,map.get(aChar));//获取最大值 即最大的桶数
        }

//       把频率和字符 存入StringBuilder
        StringBuilder[] str = new StringBuilder[max+1];
        for (int i = 0; i <= max; i++) {
            str[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> x : map.entrySet()) {
            str[x.getValue()].append(x.getKey());
        }
//       按频率降序拼接
        StringBuilder sb = new StringBuilder();
        for (int i = max; i > 0; i--) {//按照最大频率次数 遍历(每个频率只有一次 因为相同的都在一个频率里)
            for (int j = 0; j < str[i].length(); j++) {//str[i]里的所有不同的字符 e/rt
                for (int k = 0; k < i; k++) {//k < i str[i] 是字符的频率 把重复的字符都加上 ee/r/t
                    sb.append(str[i].charAt(j));
                }
            }
        }

        return sb.toString();
    }
}
