package a02hchszz.b01dcck.c01base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 */
public class L2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer,Integer> numMap = new HashMap<>();
        long sum = 0;
        long res = 0;

        // 滑动窗口
        for (int i = 0; i < nums.size(); i++) {
            // 入
            numMap.put(nums.get(i), numMap.getOrDefault(nums.get(i),0)+1);
            sum += nums.get(i);

            if (i < k - 1){
                continue;
            }
            // 更新
            if (numMap.size() >= m){
                res = Math.max(res, sum);
            }

            // 出
            int out = nums.get(i - k + 1);
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

    public static void main(String[] args) {
        List<Integer> nums = List.of(2,6,7,3,1,7);
        System.out.println(new L2841().maxSum(nums, 3, 4));
    }
}
