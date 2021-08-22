package solution.leetcode101.dfsbfs;

public class Solution547 {
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int circleNum = findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    public static int findCircleNum(int[][] isConnected) {
        int count = 0;
        int length = isConnected.length;
        boolean[] visit = new boolean[length];//用来标记走没走过
        for (int i = 0; i < length; i++) {
            if (!visit[i]) {
                dfs(isConnected, visit, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] isConnected, boolean[] visit, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                visit[i] = true;
                dfs(isConnected, visit, j);//这里是关键 把j传进i  就是 去找他连接的节点去了 这样找到最后就是一个集合
            }
        }
    }
}
