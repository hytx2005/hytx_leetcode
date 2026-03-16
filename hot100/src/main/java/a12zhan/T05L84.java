package a12zhan;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class T05L84 {
    /**
     * 两次扫描 - 单调栈
     * @param heights
     * @return int
     */
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        for(int i = n-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int res = 0;
        for(int i = 0 ; i < n ; i++){
            int temp = (right[i]-left[i]-1) * heights[i];
            res = Math.max(res,temp);
        }
        return res;
    }

    /**
     * 一次扫描 - 单调栈
     * @param heights
     * @return int
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            int temp = (right[i]-left[i]-1) * heights[i];
            res = Math.max(res,temp);
        }
        return res;
    }
}
