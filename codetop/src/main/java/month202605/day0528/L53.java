package month202605.day0528;

public class L53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1 ; i < len ; i++){
                dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
                res = Math.max(res,dp[i]);
            }
            return res;
        }
    }
}
