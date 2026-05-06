package year2026.month04;

import java.util.HashMap;
import java.util.Map;

public class D17L3761 {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> prev = new HashMap<>();
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (prev.containsKey(x)) {
                res = Math.min(res, i - prev.get(x));
            }
            prev.put(reverse(x), i);
        }
        return res != n + 1 ? res : -1;
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int d = x % 10;
            res = res * 10 + d;
            x /= 10;
        }
        return res;
    }
}
