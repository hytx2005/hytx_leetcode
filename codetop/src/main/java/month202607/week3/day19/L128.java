package month202607.week3.day19;

import java.util.HashSet;
import java.util.Set;

public class L128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int temp = 1;
                while (set.contains(i + temp)) {
                    temp++;
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }
}
