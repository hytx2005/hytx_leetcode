package month202607.week3.day21;

import java.util.ArrayDeque;
import java.util.Deque;

public class L20 {
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for(char scc : sc){
            if(scc == '(' || scc == '[' || scc == '{'){
                deque.push(scc);
            }else {
                if(deque.isEmpty()){
                    return false;
                }
                char left = deque.pop();
                if(!isMatch(left, scc)){
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public boolean isMatch(char left,char right){
        if(left == '(' && right == ')'){
            return true;
        }
        if(left == '[' && right == ']'){
            return true;
        }
        return left == '{' && right == '}';
    }
}
