package month202606.day03;

import java.util.Arrays;

public class L300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int m = nums.length;
            int[] dp = new int[m];
            Arrays.fill(dp,1);
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = i+1; j < m; j++) {
                    if(nums[j] > nums[i]){
                        dp[j] = Math.max(dp[j],dp[i]+1);
                    }
                }
                res = Math.max(res,dp[i]);
            }
            return res;
        }
    }
}
