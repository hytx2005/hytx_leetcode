package year2026.month04;

public class D08L3653 {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            int idx = l;
            while(idx <= r){
                long temp = (long)nums[idx] * v;
                nums[idx] = (int)(temp % mod);
                idx += k;
            }
        }
        int res = 0;
        for(int num : nums){
            res = res ^ num;
        }
        return res;
    }
}
