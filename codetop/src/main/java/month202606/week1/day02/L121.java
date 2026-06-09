package month202606.week1.day02;

public class L121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int res = 0;
            int min = prices[0];
            for (int price : prices){
                min = Math.min(min,price);
                res = Math.max(res,price-min);
            }
            return res;
        }
    }
}
