package month202607.week3.day21;

import java.util.ArrayDeque;
import java.util.Deque;

public class L150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(String token : tokens){
            switch (token){
                case "+":{
                    int right = deque.pop();
                    int left = deque.pop();
                    deque.push(left+right);
                    break;
                }
                case "-":{
                    int right = deque.pop();
                    int left = deque.pop();
                    deque.push(left-right);
                    break;
                }
                case "*":{
                    int right = deque.pop();
                    int left = deque.pop();
                    deque.push(left*right);
                    break;
                }
                case "/":{
                    int right = deque.pop();
                    int left = deque.pop();
                    deque.push(left/right);
                    break;
                }
                default:{
                    deque.push(Integer.parseInt(token));
                }
            }
        }
        return deque.pop();
    }
}
