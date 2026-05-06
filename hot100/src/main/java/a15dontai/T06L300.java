package a15dontai;

import java.util.Arrays;

public class T06L300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for(int j = 1 ; j < nums.length ; j++){
            for(int i = 0; i < j ; i++){
                if(nums[i] < nums[j]){
                    dp[j] = Math.max(dp[j],dp[i]+1);
                }
            }
            res = Math.max(res,dp[j]);
        }
        return res;
    }
}
