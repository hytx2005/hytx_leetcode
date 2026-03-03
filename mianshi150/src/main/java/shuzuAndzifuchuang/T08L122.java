package shuzuAndzifuchuang;

public class T08L122 {
    /**
     * 巧妙解法
     * @param prices
     * @return int
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 0 ; i<prices.length-1;i++){
            if(prices[i] < prices[i+1]){
                res+=prices[i+1]-prices[i];
            }
        }
        return res;
    }

    /**
     * 动态规划
     * @param prices
     * @return int
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i<= n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i-1]);
        }
        return dp[n][0];
    }
}
