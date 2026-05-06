package a16duoweidontai;

public class T03L5 {
    public String longestPalindrome(String s) {
        char[] sc = s.toCharArray();
        int len = s.length();
        // dp[i][j]表示 [i,j]是否为回文
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;
        // 单个字符必为回文
        for(int i = 0 ; i < len ; i++){
            dp[i][i] = true;
        }
        // dp[i][j] = dp[i+1][j-1] && sc[i] == sc[j] i < j
        for(int i = len - 1; i >= 0 ; i--){
            for(int j = i+1 ; j < len ; j++){
                if(sc[i] == sc[j]){
                    if(j-i == 1){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if(dp[i][j] && j-i+1 > maxLen){
                        maxLen = j-i+1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
