import a08echashu.base.TreeNode;

import javax.imageio.stream.ImageInputStream;
import java.util.*;

public class Test {
    public static int isOne(String s){
        char[] sc = s.toCharArray();
        int n = sc.length;
        // dp[i]表示以i结尾的最长有效括号长度
        int[] dp = new int[n];
        int res = 0;
        for (int i = 1; i < n ; i++){
            // 只有当当前字符为')'时才可能构成有效括号
            if(sc[i] == ')'){
                // 如果前一个字符是'('，则dp[i] = dp[i - 2] + 2 加上边界情况即可
                if(sc[i - 1] == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // 如果前一个字符是')'，则需要检查dp[i - 1]之前的字符是否为'('，如果是，则dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
                else if(i - dp[i - 1] > 0 && sc[i - dp[i - 1] - 1] == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(isOne(s));
    }

}
