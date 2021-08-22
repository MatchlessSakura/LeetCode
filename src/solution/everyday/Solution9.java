package solution.everyday;

import java.util.Scanner;

public class Solution9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        String a="";
        int l = 0;
        int r = a.length()-1;
        while(l < r){
            if(a.valueOf(l) != a.valueOf(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
