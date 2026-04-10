package year2026.month04;

import java.util.Arrays;

public class D09L3655 {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int) Math.sqrt(queries.length);
        int[][] diff = new int[B][];

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];
            long v = q[3];
            if (k < B) {
                // 懒初始化
                if (diff[k] == null) {
                    diff[k] = new int[n + k];
                    Arrays.fill(diff[k], 1);
                }
                diff[k][l] = (int) (diff[k][l] * v % MOD);
                r = r - (r - l) % k + k;
                diff[k][r] = (int) (diff[k][r] * pow(v, MOD - 2) % MOD);
            } else {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) (nums[i] * v % MOD);
                }
            }
        }

        for (int k = 0; k < B; k++) {
            int[] d = diff[k];
            if (d == null) {
                continue;
            }
            for (int start = 0; start < k; start++) {
                long mulD = 1;
                for (int i = start; i < n; i += k) {
                    mulD = mulD * d[i] % MOD;
                    nums[i] = (int) (nums[i] * mulD % MOD);
                }
            }
        }

        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }

    private long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }
}
