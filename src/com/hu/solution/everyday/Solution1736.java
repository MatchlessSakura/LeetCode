package com.hu.solution.everyday;


public class Solution1736 {
    public static void main(String[] args) {
        String time = "??:3?";
        System.out.println(maximumTime(time));
    }

    public static String maximumTime(String time) {
        char[] a = time.toCharArray();
        if (a[0] == '?') {
            a[0] = ('4' <= a[1] && a[1] <= '9') ? '1' : '2';
        }
        if (a[1] == '?') {
            a[1] = (a[0] == '2') ? '3' : '9';
        }
        if (a[3] == '?') {
            a[3] = '5';
        }
        if (a[4] == '?') {
            a[4] = '9';
        }
        return new String(a);
    }
}
