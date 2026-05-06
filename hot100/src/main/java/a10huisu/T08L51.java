package a10huisu;

import java.util.*;

public class T08L51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // queens[i] = j 表示第i行的皇后放在了第j列
        int[] queens = new int[n];
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(res, queens, n, 0,columns,diagonals1,diagonals2);
        return res;
    }

    private void backtrack(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if(row == n){
            List<String> board = generateBoard(queens,n);
            res.add(board);
            return;
        }
        for (int col = 0;col < n;col++){
            if(columns.contains((col))){
                continue;
            }
            // 正对角线
             int diagonal2 = row + col;
            if(diagonals2.contains(diagonal2)){
                continue;
            }
            // 斜对角线
            int diagonal1 = row - col;
            if(diagonals1.contains(diagonal1)){
                continue;
            }
            queens[row] = col;
            columns.add(col);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backtrack(res, queens, n, row + 1,columns,diagonals1,diagonals2);
            queens[row] = -1;
            columns.remove(col);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }


    /**
     * 构造结果集合
     * @param queens
     * @param n
     * @return {@link List }<{@link String }>
     */
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
