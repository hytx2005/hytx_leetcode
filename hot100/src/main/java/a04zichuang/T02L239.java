package a04zichuang;

import java.util.*;

public class T02L239 {

    /**
     * 优先级队列
     * @param nums
     * @param k
     * @return {@link int[] }
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
                    }
                }
        );
        int l = nums.length;
        int[] res = new int[l - k + 1];
        for (int i = 0; i < k; i++){
            queue.offer(new int[]{nums[i],i});
        }

        res[0] = queue.peek()[0];
        for(int i = k; i < l; i++){
            queue.offer(new int[]{nums[i],i});
            while(queue.peek()[1] <= i - k){
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // 维护一个双端队列，存储元素的索引，同时保证队列中的元素索引对应的值是单调递减的
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            // 弹出比当前元素小的元素的索引
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        // 构造结果
        int[] res = new int[n - k + 1];
        res[0] = nums[deque.peekFirst()];
        for(int i = k; i < n ; i++){
            // 弹出比当前元素小的元素的索引
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 弹出过期的索引
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
