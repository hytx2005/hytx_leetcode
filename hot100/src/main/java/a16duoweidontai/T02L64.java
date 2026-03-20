package a16duoweidontai;

public class T02L64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int val1 = i-1>=0 ? dp[i-1][j] : -1;
                int val2 = j-1>=0 ? dp[i][j-1] : -1;
                if(val1 == -1 && val2 == -1){
                    dp[i][j] = grid[i][j];
                }else if(val1 == -1){
                    dp[i][j] = val2 + grid[i][j];
                }else if(val2 == -1){
                    dp[i][j] = val1 + grid[i][j];
                }else{
                    dp[i][j] = Math.min(val1,val2) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
