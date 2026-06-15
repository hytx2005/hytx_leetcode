package month202606.week3.day15;

import java.util.HashMap;
import java.util.Map;

public class L1 {
    class Solution {
        /**
         *  hash表，时间复杂度O(n)，空间复杂度O(n)
         * @param nums 数组
         * @param target 目标值
         * @return {@link int[] }
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0 ; i < nums.length ; i++){
                int t = target-nums[i];
                if(map.containsKey(t)){
                    int index = map.get(t);
                    return new int[]{i,index};
                }else{
                    map.put(nums[i],i);
                }
            }
            return null;
        }
    }
}
