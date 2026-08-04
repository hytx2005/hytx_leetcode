package month202608.week1.day4;

import java.util.ArrayDeque;
import java.util.Deque;

public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 存储索引
        // 保证队列内的索引在有效范围内，并且从头到尾 索引对应的值越来越小,但是索引越来越大，同时单调递减
        // 奇妙比喻
        //如果新员工比老员工强（或者一样强），把老员工裁掉。（元素进入窗口）
        //如果老员工 35 岁了，也裁掉。（元素离开窗口）
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        for(int i = 0 ; i < k ; i++){
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] res = new int[n - k + 1];
        res[0] = nums[deque.peekFirst()];
        for(int i = k ; i < n ; i++){
            // 移除比当前索引小且对应的值小于当前值的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            // 移除非法索引
            while (!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
