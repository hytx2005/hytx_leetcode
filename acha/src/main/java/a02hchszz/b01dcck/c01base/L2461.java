package a02hchszz.b01dcck.c01base;

import java.util.HashMap;
import java.util.Map;

public class L2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> numMap = new HashMap<>();
        long sum = 0;
        long res = 0;

        // 滑动窗口
        for (int i = 0; i < nums.length; i++) {
            // 入
            numMap.merge(nums[i], 1,Integer::sum);
            sum += nums[i];

            if (i < k - 1){
                continue;
            }
            // 更新
            if (numMap.size() == k){
                res = Math.max(res, sum);
            }

            // 出
            int out = nums[i - k + 1];
            Integer outNum = numMap.get(out);
            if (outNum == 1){
                numMap.remove(out);
            }else {
                numMap.put(out,outNum-1);
            }
            sum -= out;
        }
        return res;
    }
}
