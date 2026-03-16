package a12zhan;

import java.util.ArrayDeque;
import java.util.Deque;

public class T04L739 {
    /**
     * 反向 - 栈
     * @param temperatures
     * @return {@link int[] }
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = n-1; i >= 0 ; i--){
            while(!deque.isEmpty() && temperatures[deque.peek()] <= temperatures[i]){
                deque.pop();
            }
            if(deque.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = deque.peek() - i;
            }
            deque.push(i);
        }
        return res;
    }

    /**
     * 正向 - 栈
     * @param temperatures
     * @return {@link int[] }
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n ; i++){
            int temperature = temperatures[i];
            while(!deque.isEmpty() && temperature > temperatures[deque.peek()]){
                int index = deque.pop();
                res[index] = i - index;
            }
            deque.push(i);
        }
        return res;
    }
}
