package month202608.week1.day1;

import java.util.HashSet;
import java.util.Set;

public class L128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        // 存在空数组，初值应设为0
        int res = 0;
        for(Integer val : set){
            if(set.contains(val-1)){
                continue;
            }else {
                int count = 0;
                while (set.contains(val)){
                    val++;
                    count++;
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}
