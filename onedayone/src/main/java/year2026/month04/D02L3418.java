package year2026.month04;

import java.util.Arrays;

public class D02L3418 {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        // memo[i][j][k] 表示在 (i, j) 位置，感化次数为 k 次机会的最大金额
        int[][][] memo = new int[m][n][3];
        // 初始化 memo 数组为 Integer.MIN_VALUE，表示未计算过
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return dfs(m - 1, n - 1, 2, coins, memo);
    }
    private int dfs(int i, int j, int k, int[][] coins, int[][][] memo) {
        if(i < 0 || j < 0){
            return Integer.MIN_VALUE;
        }
        int x = coins[i][j];
        if(i == 0 && j == 0){
            return k > 0 ? Math.max(x,0) : x;
        }
        // 已经计算过
        if(memo[i][j][k] != Integer.MIN_VALUE){
            return memo[i][j][k];
        }
        // 不感化
        int res = Math.max(dfs(i-1,j,k,coins,memo),dfs(i,j-1,k,coins,memo));
        // 感化
        if(k > 0 && x < 0){
            res = Math.max(res, Math.max(dfs(i - 1, j, k - 1, coins, memo), dfs(i, j - 1, k - 1, coins, memo)));
        }

        memo[i][j][k] = res;
        return res;
    }
}
