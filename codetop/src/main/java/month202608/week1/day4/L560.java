package month202608.week1.day4;

import java.util.HashMap;
import java.util.Map;

public class L560 {
    /**
     * 超时
     * @param nums
     * @param k
     * @return int
     */
    public int subarraySum1(int[] nums, int k) {
        // 结果集
        Map<Integer,Integer> res = new HashMap<>();
        // 当前序号的上一个序号的子数组集
        Map<Integer,Integer> temp = new HashMap<>();
        for(int num : nums){
            Map<Integer,Integer> tempNext = new HashMap<>();
            tempNext.put(num,1);
            res.put(num,res.getOrDefault(num,0)+1);
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                Integer key = entry.getKey();
                Integer val = entry.getValue();
                tempNext.put(key+num,tempNext.getOrDefault(key+num,0)+val);
                res.put(key+num,res.getOrDefault(key+num,0)+val);
            }
            temp = new HashMap<>(tempNext);
        }
        return res.getOrDefault(k,0);
    }

    public int subarraySum(int[] nums, int k) {
        int preFix = 0;
        Map<Integer,Integer> preCount = new HashMap<>();
        preCount.put(0,1);
        int res = 0;
        for(int num : nums){
            // 前缀和之差为k
            // hash  preFix 可推出 preFix - hash = k  球hash数量
            preFix += num;
            res += preCount.getOrDefault(preFix-k,0);
            preCount.put(preFix,preCount.getOrDefault(preFix,0)+1);
        }
        return res;
    }
}
