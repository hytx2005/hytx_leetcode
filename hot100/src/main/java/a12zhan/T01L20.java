package a12zhan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class T01L20 {
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0 ; i < sc.length ; i++){
            char c = sc[i];
            if(c == '[' || c == '(' || c == '{'){
                deque.push(c);
            }else{
                if(deque.isEmpty()){
                    return false;
                }
                char t = deque.pop();
                if(!isMatch(t,c)){
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
        if(left == '{' && right == '}'){
            return true;
        }
        return false;
    }
}
