package shuzuAndzifuchuang;

import java.util.HashMap;

public class T05L169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
            if(map.get(num) > nums.length/2){
                res = num;
                return res;
            }
        }
        return res;
    }
}
