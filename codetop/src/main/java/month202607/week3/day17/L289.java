package month202607.week3.day17;

import java.util.Arrays;

public class L289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countAlive(newBoard,i,j);
                if(board[i][j] == 1 && count < 2){
                    board[i][j] =0;
                } else if (board[i][j] == 1 && count <= 3) {
                    board[i][j] = 1;
                }else if(board[i][j] == 1){
                    board[i][j] = 0;
                }else if(board[i][j] == 0 && count == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countAlive(int[][] board,int x,int y){
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        // 遍历8个邻居
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // 跳过自身
                if (i == 0 && j == 0) {
                    continue;
                }

                int nx = x + i;
                int ny = y + j;

                // 检查边界
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (board[nx][ny] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
