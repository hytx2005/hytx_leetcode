package a01hash;

import java.util.HashMap;
import java.util.Map;

public class T01L1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> val = new HashMap<>();
        for(int i = 0 ; i<nums.length;i++){
            int num = nums[i];
            int need = target -num;
            if(val.containsKey(need)){
                int j = val.get(need);
                return new int[]{i,j};
            }
            val.put(num,i);
        }
        return null;
    }
}
