package a02hchszz.b01dcck.c02fly;

import java.util.Arrays;

public class T05L2134 {
    /*
     * 先求出 1 的个数k，题目可转换为求长度为k的滑动窗口中0的最小个数,也就是滑动窗口中1的最大个数
     * 环形数组实现思路，左边界left最大值为 i - 1，有边界取模即可
     */
    public int minSwaps(int[] nums) {
        int k = 0;
        int res = 0;
        int temp = 0;
        // 1.求滑动窗口长度
        k = Arrays.stream(nums).sum();

        // 2.开始滑动
        int len = nums.length + k - 1;
        for (int i = 0; i < len; i++) {
            // 入
            int right = nums[i % nums.length];
            temp += right;

            // 更新
            int left = i - k + 1;
            if (left < 0){
                continue;
            }
            res = Math.max(res, temp);

            // 出
            temp -= nums[left];
        }
        return k - res;
    }
}
