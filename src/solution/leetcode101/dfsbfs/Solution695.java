package solution.leetcode101.dfsbfs;

public class Solution695 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1}};
        int i = maxAreaOfIsland(grid);
        System.out.println(i);

    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)//判断能不能搜索 然后进行最大值的比较
                    max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    public static int dfs(int[][] grid, int x, int y) {

        if (grid[x][y] == 0)// 传进来的位置不能搜索 直接返回
            return 0;
        int[] dire1 = {-1, 1, 0, 0};
        int[] dire2 = {0, 0, -1, 1};//两个加起来对应 左 右 上 下
        grid[x][y] = 0;// ？ 把自己标记为不可搜索 防止递归时的重复调用★★★★★
        int xx, yy, area = 1;
        for (int i = 0; i < 4; i++) {
            xx = x + dire1[i];
            yy = y + dire2[i];//四个方向遍历
            if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length)
                area += dfs(grid, xx, yy);//递归其他点
        }
        return area;
    }
}
