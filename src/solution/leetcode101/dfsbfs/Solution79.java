package solution.leetcode101.dfsbfs;

public class Solution79 {
    public static void main(String[] args) {
        String word = "SEE";
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        boolean[] judge = new boolean[]{false};
        int index = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dfs(i, j, visit, judge, board, word, index);
        return judge[0];
    }

    private static void dfs(int l, int r, boolean[][] visit, boolean[] judge, char[][] board, String
            word, int index) {
        if (l < 0 || l > board.length - 1 || r < 0 || r > board[0].length - 1)
            return;
        if (visit[l][r] || judge[0] || board[l][r] != word.charAt(index))
            return;
        if (index == word.length() - 1) {
            judge[0] = true;
            return;
        }
        visit[l][r] = true;
        dfs(l + 1, r, visit, judge, board, word, index + 1);
        dfs(l - 1, r, visit, judge, board, word, index + 1);
        dfs(l, r - 1, visit, judge, board, word, index + 1);
        dfs(l, r + 1, visit, judge, board, word, index + 1);
        visit[l][r] = false;
    }
}
