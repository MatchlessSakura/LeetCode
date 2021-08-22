package solution.everyday;


public class Solution1893 {
    public static void main(String[] args) {
        int[][] ranges = {{25, 42}, {7, 14}, {2, 32}, {25, 28}, {39, 49}, {1, 50}, {29, 45}, {18, 47}};
        int left = 15;
        int right = 38;
        System.out.println(isCovered(ranges, left, right));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int[] a : ranges) {
            int L = Math.max(a[0], left);
            int R = Math.min(a[1], right);
//            通过对 l和 left中的大值和 r和right中的小值 进行标记（两个数之间的区域一定被标记）
            for (int i = L; i <= R; i++) {
                flag[i] = true;
            }
        }
//        检查区间内是否还有区间未被标记（包括）
        for (int i = left; i <= right; i++) {
            if (flag[i] == false) return false;
        }
        return true;
    }
}
