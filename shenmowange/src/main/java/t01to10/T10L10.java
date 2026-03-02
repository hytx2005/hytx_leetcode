package t01to10;

/**
 * 正则表达式匹配 <a href="https://leetcode.cn/problems/regular-expression-matching/description/">...</a>
 * @author Dai
 * &#064;date  2026/02/11
 */
class T10L10 {

    /**
     * 递归
     * @param s 字符串
     * @param p 模式串
     * @return boolean
     */
    public static boolean isMatch1(String s, String p) {
        return match(s, p, 0, 0);
    }
    public static boolean match(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
            // p 完，s 也得完
        }
        if (i == s.length()) {
            return j + 1 < p.length() && p.charAt(j + 1) == '*' && match(s, p, i, j + 2);
            // s 完，p 靠 * 变空
        }
        if (j + 1 < p.length() && p.charAt(j + 1) == '*')
            // 遇到 *
        {
            return match(s, p, i, j + 2) || (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) && match(s, p, i + 1, j);
        }
        return (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) && match(s, p, i + 1, j + 1);
        // 普通字符或 .
    }

    public static boolean isMatch2(String text,String pattern){
        int m = text.length() + 1, n = pattern.length() + 1;
        boolean[][] dp = new boolean[m][n];

        // 初始化 0 行 0 列
        dp[0][0] = true;
        for(int j  = 2 ; j<n ; j+=2){
            dp[0][j] = pattern.charAt(j-1) == '*' && dp[0][j-2];
        }

        // 开始状态转换
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(pattern.charAt(j-1) != '*'){
                    if(pattern.charAt(j-1) == '.' || pattern.charAt(j-1) == text.charAt(i-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }else{
                    // 1. * 代表 0 个
                    if(dp[i][j-2]){
                        dp[i][j] = true;
                    }
                    // 2. * 代表多一个
                    else if(dp[i-1][j] && pattern.charAt(j-2) == text.charAt(i-1)){
                        dp[i][j] = true;
                    }else if(dp[i-1][j] && pattern.charAt(j-2) == '.'){
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(isMatch1("ab", ".*c"));


    }
}
