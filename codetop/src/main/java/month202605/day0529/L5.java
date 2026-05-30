package month202605.day0529;

public class L5 {
    class Solution {
        public String longestPalindrome(String s) {
            char[] sc = s.toCharArray();
            int len = sc.length;
            // dp[i][j] 表示 i-j 是否为回文
            boolean[][] dp = new boolean[len][len];
            int begin = 0;
            int l = 1;
            for(int i = 0 ; i < len ; i++){
                dp[i][i] = true;
            }
            // dp[i][j] = dp[i+1][j-1] && sc[i] == sc[j] i < j
            for(int i = len - 1 ; i >= 0 ; i--){
                for(int j = i+1 ; j < len ; j++){
                    boolean a = (i + 1) > (j - 1) || dp[i + 1][j - 1];
                    dp[i][j] = a && sc[i] == sc[j];
                    if(dp[i][j] && (j-i+1) > l){
                        begin = i;
                        l = j-i+1;
                    }
                }
            }
            return s.substring(begin,begin+l);
        }
    }
}
