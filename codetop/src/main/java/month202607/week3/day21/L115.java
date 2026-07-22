package month202607.week3.day21;

import java.util.ArrayDeque;
import java.util.Deque;

public class L115 {
    class MinStack {
        Deque<int[]> deque;

        public MinStack() {
            deque = new ArrayDeque<>();
            deque.push(new int[]{0,Integer.MAX_VALUE});
        }

        public void push(int val) {
            deque.push(new int[]{val,Math.min(getMin(),val)});
        }

        public void pop() {
            deque.pop();
        }

        public int top() {
            return deque.peek()[0];
        }

        public int getMin() {
            return deque.peek()[1];
        }
    }

}
