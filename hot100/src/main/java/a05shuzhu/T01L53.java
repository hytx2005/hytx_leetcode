package a05shuzhu;

public class T01L53 {
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l+1];
        dp[0] = 0;
        int res = nums[0];
        for(int i = 0 ; i < l ; i ++){
            dp[i+1] = Math.max(dp[i],0) + nums[i];
            res = Math.max(res,dp[i+1]);
        }
        return res;
    }
}
