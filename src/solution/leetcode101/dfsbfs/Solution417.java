package solution.leetcode101.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Solution417 {
    public static class pacificAtlantic {
        private static int[][] dires = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//方向
        private int m, n;
        private int[][] matrix;

        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> res = new ArrayList<>();
            m = matrix.length;
            n = matrix[0].length;
            if (m == 0 || n == 0) {
                return res;
            }
            this.matrix = matrix;//修改
            boolean[][] canReachP = new boolean[m][n];//可以流向太平洋
            boolean[][] canReachA = new boolean[m][n];//可以流向大西洋
            for (int i = 0; i < n; i++) {
                dfs(0, i, canReachP);//上边界流动
                dfs(m - 1, i, canReachA);//下边界流动
            }
            for (int i = 0; i < m; i++) {
                dfs(i, 0, canReachP);//左边界流动
                dfs(i, n - 1, canReachA);//右边界流动
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(canReachA[i][j] && canReachP[i][j]){//两个都可以流到
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        res.add(temp);
                    }
                }
            }
            return res;
        }
        /**
         * 换一种思路，从边界往里面走，只能走到比自己更高或者等高的地方。边界能走到的地方，就是能流入对应海洋的地方。
         */
        private void dfs(int x, int y, boolean[][] canReach) {
            canReach[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + dires[i][0];
                int newY = y + dires[i][1];
                if (isIn(newX, newY) && matrix[x][y] <= matrix[newX][newY] && !canReach[newX][newY]) {
                    dfs(newX, newY, canReach);
                }
            }
        }

        private boolean isIn(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
}
