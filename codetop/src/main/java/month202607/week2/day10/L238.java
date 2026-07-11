package month202607.week2.day10;

public class L238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];

            // 构造左部乘积
            res[0] = 1;
            for(int i = 1; i < n ;i++){
                res[i] = res[i-1]*nums[i-1];
            }
            // 存储右边乘积
            int tmp = nums[n-1];
            for(int i = n - 2; i >= 0 ; i--){

                res[i] = tmp * res[i];
                tmp *= nums[i];
            }

            return res;
        }
    }
}
