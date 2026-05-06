package year2026.month03;

import java.util.Arrays;

public class D24L2906 {
    public static int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];

        // 求前缀
        long pre = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                p[i][j] = (int) pre;
                pre = (pre * grid[i][j]) % MOD;
            }
        }
        for (int[] ints : p) {
            System.out.println(Arrays.toString(ints));
        }
        // 求后缀同时计算结果集
        long suf = 1;
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = m - 1 ; j >= 0 ; j--){
                p[i][j] = (int)(p[i][j] * suf  % MOD);
                suf = (suf * grid[i][j]) % MOD;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        int[][] res = constructProductMatrix(grid);
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }
}
