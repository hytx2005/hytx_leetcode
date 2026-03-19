package a15dontai;

public class T08L416 {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2){
            return false;
        }
        int target = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++){
            target += nums[i];
            max = Math.max(max, nums[i]);
        }
        if(target % 2 != 0 || max > target / 2){
            return false;
        }
        target /= 2;
        // dp[i][j]表示前i个数能否组成j
        boolean[][] dp = new boolean[nums.length][target + 1];
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j <= target; j++){
                if(j >= nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
