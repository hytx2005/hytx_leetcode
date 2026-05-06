package a15dontai;

import java.util.ArrayDeque;
import java.util.Deque;

public class T09L32 {
    public static int isOne(String s){
        char[] sc = s.toCharArray();
        int n = sc.length;
        // dp[i][j] 表示是s[i,j]有效括号的长度,不是有效括号则为0
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++){
            if(sc[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
