package month202606.week2.day09;

public class L1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] sc1 = text1.toCharArray();
        char[] sc2 = text2.toCharArray();
        int m = sc1.length;
        int n = sc2.length;
        // dp[i][j] 表示text1[0,i]和text2[0,j]的最长公共子序列长度
        int[][] dp = new int[m +1][n+1];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(sc1[i] == sc2[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
