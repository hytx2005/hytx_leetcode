package a15dontai;

public class T04L279 {
    public int numSquares1(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i);j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public int numSquares(int n) {
        if (isPerfectSqrt(n)){
            return 1;
        }
        if (isFourSquares(n)){
            return 4;
        }
        for(int i = 1 ; i <= Math.sqrt(n) ; i++){
            int rest = n - i*i;
            if(isPerfectSqrt(rest)){
                return 2;
            }
        }
        return 3;
    }

    public boolean isPerfectSqrt(int n){
        int sqrt = (int) Math.sqrt(n);
        return sqrt*sqrt == n;
    }

    /**
     * 四平方和 ： 当一个数满足 n = 4^k*(8m+7) 时，n 只能表示为四个平方数的和。
     * @param n
     * @return boolean
     */
    public boolean isFourSquares(int n){
        while(n % 4 == 0){
            n /= 4;
        }
        return n % 8 == 7;
    }
}

