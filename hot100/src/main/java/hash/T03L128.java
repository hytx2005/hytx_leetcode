package hash;

import java.util.HashSet;
import java.util.Set;

public class T03L128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        // 1.全部放入set集合
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        // 2.遍历set集合，不是连续序列中的最小数不进行计算
        for(int num : set){
            if(!set.contains(num-1)){
                int t = num;
                int count = 0;
                while(set.contains(t)){
                    count++;
                    t++;
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}
