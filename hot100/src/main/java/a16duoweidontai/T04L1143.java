package a16duoweidontai;

public class T04L1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(),len2 = text2.length();
        char[] sc1 = text1.toCharArray();
        char[] sc2 = text2.toCharArray();
        // dp[i][j]表示 text1[0,i-1]和text2[0,j-1]的最长公共子序列长度
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1 ; i <= len1 ; i++){
            for(int j = 1 ; j <= len2 ; j++){
                if(sc2[j-1] == sc1[i-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
