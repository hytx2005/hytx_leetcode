package month202608.week1.day1;

import java.util.HashMap;

public class L1 {
    public int[] twoSum(int[] nums, int target) {
        // key-val  对应 值-下标
        HashMap<Integer,Integer> vals = new HashMap<>();
        for(int index = 0 ; index < nums.length ; index++){
            if(vals.containsKey(target - nums[index])){
                return new int[]{vals.get(target-nums[index]),index};
            }
            vals.put(nums[index],index);
        }
        return new int[]{-1,-1};
    }
}
