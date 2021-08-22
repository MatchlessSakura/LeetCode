package solution.leetcode101.erfen;

import java.util.Scanner;

public class Solution69 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if(x == 1)
            return 1;
        int l = 0;
        int r = x;
        while (l +1 < r) {
//           l+1<r是防止 两个相邻数之间没有整数 比如l=1 r=2 卡死
            int mid = (l + r) / 2;
            if (x/mid >= mid) {
                l = mid;
            } else
                r = mid;
        }
        return l;
    }
}
