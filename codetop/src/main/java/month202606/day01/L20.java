package month202606.day01;

import java.util.ArrayDeque;
import java.util.Deque;

public class L20 {
    class Solution {
        public boolean isValid(String s) {
            char[] sc = s.toCharArray();
            Deque<Character> deque = new ArrayDeque<>();
            for(char c : sc){
                if(c == '(' || c == '[' || c == '{'){
                    deque.push(c);
                }else {
                    if(deque.isEmpty()){
                        return false;
                    }
                    Character pop = deque.pop();
                    if(!isMatch(pop,c)){
                        return false;
                    }
                }
            }
            return deque.isEmpty();
        }

        public boolean  isMatch(char left,char right){
            if(left == '(' && right == ')'){
                return true;
            }else if(left == '{' && right == '}'){
                return true;
            }else if(left == '[' && right == ']'){
                return true;
            }
            return false;
        }
    }
}
