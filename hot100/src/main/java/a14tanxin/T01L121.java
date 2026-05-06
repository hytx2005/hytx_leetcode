package a14tanxin;

public class T01L121 {
    public static int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            int val = prices[i] - min;
            res = Math.max(res,val);
            min = Math.min(min,prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
