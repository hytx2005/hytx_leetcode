package a12zhan;

import java.util.ArrayDeque;
import java.util.Deque;

public class T02L155 {
    class MinStack1 {
        Deque<Integer> deque;
        Deque<Integer> min;

        public MinStack1() {
            deque = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int val) {
            deque.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                int t = min.peek();
                min.push(Math.min(t, val));
            }
        }

        public void pop() {
            deque.pop();
            min.pop();
        }

        public int top() {
            return deque.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

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
