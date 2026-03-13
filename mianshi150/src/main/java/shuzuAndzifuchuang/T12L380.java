package shuzuAndzifuchuang;

import java.util.*;

public class T12L380 {
    class RandomizedSet {

        List<Integer> nums;
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            nums.add(val);
            map.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int lastNum = nums.get(nums.size() - 1);
            nums.set(index, lastNum);
            map.put(lastNum, index);
            nums.remove(nums.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(nums.size());
            return nums.get(index);
        }
    }
}
