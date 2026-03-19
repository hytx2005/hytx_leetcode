package a15dontai;

public class T03L198 {
    /**
     * 动态规划-数组
     * @param nums
     * @return int
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 0 ; i < n ; i++){
            dp[i+2] = Math.max(dp[i+1],dp[i]+nums[i]);
        }
        return dp[n+1];
    }

    /**
     * 动态规划-滚动数组
     * @param nums
     * @return int
     */
    public int rob2(int[] nums) {
        int s1 = 0,s2 = 0,s3 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            s1 = s2;
            s2 = s3;
            s3 = Math.max(s1+nums[i],s2);
        }
        return s3;
    }
}
