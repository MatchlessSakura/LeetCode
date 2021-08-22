package solution.everyday;

class Solution7 {
    public int reverse(int x) {
        long n = 0;
        while(x /10 > 0){
            n = n*10+x%10;
            x /=10;
        }
        return (int)n==n? (int)n:0;
    }
}
