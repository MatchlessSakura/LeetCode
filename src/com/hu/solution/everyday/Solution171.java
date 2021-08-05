package com.hu.solution.everyday;

public class Solution171 {
    public static void main(String[] args) {
        String columnTitle = "ZY";
        System.out.println(titleToNumber(columnTitle));
    }
    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
//            加号后面是一位的情况 前面是多位的情况
            num =  num * 26 + (chars[i] - 'A' + 1);
        }
        return num;
    }
}
