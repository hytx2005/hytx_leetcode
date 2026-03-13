package shuzuAndzifuchuang;

public class T07L121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        int m = prices.length;
        for(int i = 1; i < m ;i++){
            if(prices[i] >min){
                res = Math.max(prices[i]-min,res);
            }else{
                min = Math.min(min,prices[i]);
            }
        }
        return res;
    }
}
