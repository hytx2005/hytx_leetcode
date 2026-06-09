package month202606.week1.day05;

public class L72 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            // dp[i][j] 表示word1[0,i]到word2[0,j]的最短编辑距离
            int[][] dp = new int[m + 1][n + 1];
            if (m * n == 0) {
                return n + m;
            }
            // 初始化边界值
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }
            for (int i = 1 ; i <= m ; i++){
                for(int j = 1 ; j <= n ; j++){
                    int add1 = dp[i-1][j] + 1;
                    int add2 = dp[i][j-1] + 1;
                    int edit =  dp[i-1][j-1];
                    if(word1.charAt(i-1) != word2.charAt(j-1)){
                        edit += 1;
                    }
                    dp[i][j] = Math.min(edit,Math.min(add1,add2));
                }
            }
            return dp[m][n];
        }
    }


}
