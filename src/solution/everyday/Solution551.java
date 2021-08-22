package solution.everyday;

public class Solution551 {
    public static void main(String[] args) {
        String s = "LPLPLPLPLPL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int a, b, c;
        a = b = c = 0;
        for (char aChar : chars) {
            if (aChar == 'A') {
                c = 0;
                a++;
                if (a >= 2)
                    return false;
            } else if (aChar == 'L') {
                b++;
                c++;
                if (c >= 3)
                    return false;
            } else
                c = 0;
        }
        return true;
    }
}
