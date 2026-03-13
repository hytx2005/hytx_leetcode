package a04zichuang;

import java.util.HashMap;
import java.util.Map;

public class T01L560 {
    /**
     * 双重循环，暴力解法
     * @param nums
     * @param k
     * @return int
     */
    public int subarraySum1(int[] nums, int k) {
        int l = nums.length;
        int res = 0;
        for(int end = 0; end < l ; end++){
            int tmp = 0;
            for(int start = end; start >= 0 ; start--){
                tmp += nums[start];
                if(tmp == k){
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        // 计算前缀和
        int pre = 0;
        for (int num : nums){
            pre += num;
            //
            if(map.containsKey(pre - k)){
                res += map.get(pre - k);
            }
            // 录入哈希
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
