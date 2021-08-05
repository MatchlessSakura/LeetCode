package com.hu.solution.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*
 * 思想：
 *   把targrt转化为存储值和下标的map，再把arr里和target[i]对应的值存入最长子序列（b），这样就求出了最长公共子序列。
 *   然后targrt的长度减去最长公共子序列的长度就是答案
 * */
public class Solution1713 {
    public static void main(String[] args) {
        int[] target = {6,4,8,1,3,2};
        int[] arr = {4,7,6,2,3,8,6,1};
        System.out.println(minOperations(target, arr));
    }
    public static int minOperations(int[] target, int[] arr) {

        int n = target.length;
        Map<Integer, Integer> a = new HashMap<>();
//        把target 的值 和 下标 存进图
        for (int i = 0; i < target.length; i++) {
            a.put(target[i], i);
        }
//        最长公共子序列
        ArrayList<Integer> b = new ArrayList<>();
        for (int j : arr) {
//           因为如果arr里有target里没有的 target在这一段就一定不是他的子序列
            if (a.containsKey(j)) {//如果键有 就获取值(下标)
                int x = a.get(j);//如果键有 就获取值(下标)
//                通过二分查找找到arr里对应target的值的下标
                int y = binarysearch(b, x);
//                把下标纪录进子序列中
                if (y != b.size())
                    b.set(y, x);//把map下标根据找到的位置存入
                else
                    b.add(x);
            }
        }
        return n - b.size();
    }

    private static int binarysearch(ArrayList<Integer> b, int x) {
        int length = b.size();
//        最开始的length为0就是add 如果最长公共子序列的最后的值小于目标值（因为最长公共子序列是递增的）就是add
        if (length == 0 || b.get(length - 1) < x)
            return length;
        int l = 0;
        int r = length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (b.get(mid) < x)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
