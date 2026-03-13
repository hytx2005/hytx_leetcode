package t01to10;

/**
 * 最长回文子串 <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">...</a>
 *
 * @author Dai
 * &#064;date  2026/02/10
 */
class T05L5 {
    /**
     * 中心扩展法 考虑两种情况：以i为中心的回文串和以i和i+1为中心的回文串
     *
     * @param s 输入字符串
     * @return {@link String }
     */
    public static String longestPalindrome1(String s) {
        char[] sc = s.toCharArray();
        int len = sc.length;
        int res = 0;
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            // 比较两种情况：以i为中心的回文串和以i和i+1为中心的回文串
            int l1 = i - 1;
            int r1 = i + 1;
            while (l1 >= 0 && r1 < len && sc[l1] == sc[r1]) {
                l1--;
                r1++;
            }
            if (r1 - l1 - 1 > res) {
                res = r1 - l1 - 1;
                left = l1 + 1;
                right = r1 - 1;
            }
            if (i + 1 < len && sc[i] == sc[i + 1]) {
                int l2 = i - 1;
                int r2 = i + 2;
                while (l2 >= 0 && r2 < len && sc[l2] == sc[r2]) {
                    l2--;
                    r2++;
                }
                if (r2 - l2 - 1 > res) {
                    res = r2 - l2 - 1;
                    left = l2 + 1;
                    right = r2 - 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    /**
     * 动态规划 dp[i][j]表示s[i..j]是否是回文串
     *
     * @param s 输入字符串
     * @return {@link String }
     */
    public String longestPalindrome2(String s) {
        char[] sc = s.toCharArray();
        int len = sc.length;
        boolean[][] dp = new boolean[len][len];
        int begin = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // dp[i][j] = dp[i+1][j-1] && sc[i] == sc[j]  j-i>1
        //          = sc[i] == sc[j]  j-i<=1
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {

                // 如果相等
                if (sc[i] == sc[j]) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 更新
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }// 我的代码哪里
            }

        }
        return s.substring(begin, begin + maxLen);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome1("bbb"));
    }
}
