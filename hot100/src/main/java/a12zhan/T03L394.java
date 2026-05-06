package a12zhan;

import java.util.ArrayDeque;
import java.util.Deque;

public class T03L394 {
    /**
     * 栈
     * @param s
     * @return {@link String }
     */
    public String decodeString1(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] sc = s.toCharArray();
        for(int i = 0 ; i < sc.length ; i ++){
            char c = sc[i];
            if(c != ']'){
                stack.push(c);
            }else{
                StringBuilder temp = new StringBuilder();
                while(stack.peek() != '['){
                    temp = temp.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num = num.insert(0, stack.pop());
                }
                int n = Integer.parseInt(num.toString());
                StringBuilder res = new StringBuilder();
                for(int j = 0 ; j < n ; j ++){
                    res.append(temp);
                }
                for(int j = 0 ; j < res.length() ; j ++){
                    stack.push(res.charAt(j));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans = ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}
