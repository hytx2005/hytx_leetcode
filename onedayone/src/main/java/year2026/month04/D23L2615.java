package year2026.month04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D23L2615 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] res = new long[n];
        for (List<Integer> idxs : groups.values()) {
            int m = idxs.size();
            long[] preSum = new long[m + 1];
            for (int i = 0; i < m; i++) {
                preSum[i + 1] = preSum[i] + idxs.get(i);
            }
            for (int i = 0; i < m; i++) {
                int idx = idxs.get(i);
                // 左边距离和
                long left = (long) i * idx - preSum[i];
                // 右边距离和
                long right = (preSum[m] - preSum[i + 1]) - (long) (m - i - 1) * idx;
                res[idx] = left + right;
            }
        }
        return res;
    }
}
