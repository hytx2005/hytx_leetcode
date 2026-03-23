package year2026.month03;

import java.util.Arrays;

public class D23L1594 {
    public static int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] minDp = new long[m][n];
        long[][] maxDp = new long[m][n];
        minDp[0][0] = grid[0][0];
        maxDp[0][0] = grid[0][0];
        // 初始化第一行
        for(int i = 1; i < n ; i++){
            minDp[0][i] = Math.min(grid[0][i]*minDp[0][i-1],grid[0][i]*maxDp[0][i-1]);
            maxDp[0][i] = Math.max(grid[0][i]*minDp[0][i-1],grid[0][i]*maxDp[0][i-1]);
        }
        // 初始化第一列
        for(int i = 1 ; i < m ; i++){
            minDp[i][0] = Math.min(grid[i][0]*minDp[i-1][0],grid[i][0]*maxDp[i-1][0]);
            maxDp[i][0] = Math.max(grid[i][0]*minDp[i-1][0],grid[i][0]*maxDp[i-1][0]);
        }
        // 其他数据
        for(int i = 1; i < m ;i++){
            for(int j = 1; j < n ; j++){
                long min = Math.min(minDp[i-1][j],minDp[i][j-1]);
                long max = Math.max(maxDp[i-1][j],maxDp[i][j-1]);
                int val = grid[i][j];
                minDp[i][j] =Math.min(max*val,min*val);
                maxDp[i][j] = Math.max(max*val,min*val);
            }
        }
        System.out.println(Arrays.deepToString(maxDp));
        int res = (int) (maxDp[m-1][n-1] % ((int)Math.pow(10,9)+7));
        return res >= 0 ? res : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};
        System.out.println(maxProductPath(grid));
    }
}
