package solution.leetcode101.dfsbfs;

public class Solution130 {
    int n, m;

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        if (n == 0)
            return;
        //和上下左右相连的都设置一个新值 然后把剩下的都给覆盖了
        for (int i = 0; i < n; i++) {//左右边界
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        //改变标志
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 'A')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || board[i][j] != 'O')
            return;
        board[i][j] = 'A';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);

    }
}
