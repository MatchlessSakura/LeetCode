package solution.leetcode101.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Solution37 {

    static boolean[][] row = new boolean[9][9];
    static boolean[][] column = new boolean[9][9];
    static boolean[][][] box = new boolean[3][3][9];
    static boolean v;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = column[j][num] = box[i/3][j/3][num] = true;
                }
                else
                    list.add(new int[]{i,j});
            }
        }
        dfs(board,0);
    }

    private static void dfs(char[][] board, int i) {
        if(i == list.size()){
            v = true;
            return;
        }
        int[] ints = list.get(i);
        int x = ints[0];
        int y = ints[1];
        for (int k = 0; k < 9 && !v; k++) {
            if(!row[x][k] && !column[y][k] && !box[x/3][y/3][k]){
                row[x][k] = column[y][k] = box[x/3][y/3][k] = true;
                board[x][y] = (char) (k + '1');
                dfs(board,i+1);
                row[x][k] = column[y][k] = box[x/3][y/3][k] = false;
            }
        }
    }
}
