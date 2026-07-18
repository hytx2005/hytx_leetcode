package month202607.week3.day17;

import java.util.HashMap;

public class L36 {
    public static boolean isValidSudoku(char[][] board) {
        // 行 i,j表示 数字 i 在第j行是否有
        boolean[][] rows = new boolean[10][10];

        // 列， 下标[i][j]表示 数字 i 在 第 j 列是否存在
        boolean[][] clos = new boolean[10][10];

        //3x3宫格 下标[i][j]表示数字i 在宫格j是否存在
        // 宫格顺序从左到右，从上到下，1-9  计算公式为 (行/3)+(列/3)*3+1
        boolean[][] gongGes = new boolean[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    int num = board[i][j] - '0';
                    int gongGe = (i / 3) + (j / 3)*3 + 1;
                    if (rows[num][i]) {
                        System.out.println(i+""+j);
                        return false;
                    }
                    if (clos[num][j]) {
                        System.out.println(i+""+j);
                        return false;
                    }
                    if (gongGes[num][gongGe]) {
                        System.out.println(i+""+j);
                        return false;
                    }
                    rows[num][i] = true;
                    clos[num][j] = true;
                    gongGes[num][gongGe] = true;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {
                '8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {
                '7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {
                '.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }
}
