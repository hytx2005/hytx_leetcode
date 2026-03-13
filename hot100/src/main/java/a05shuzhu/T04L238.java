package a05shuzhu;

import java.util.Arrays;

public class T04L238 {
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // 构造左部乘积
        left[0] = 1;
        for(int i = 1; i < n ;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        // 构造右边乘积
        right[n-1] = 1;
        for(int i = n - 2; i >= 0 ; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        // 构造结果
        int[] res= new int[n];
        for(int i = 0 ; i < n ; i ++){
            res[i] = left[i] * right[i] ;
        }
        return res;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // 构造左部乘积
        res[0] = 1;
        for(int i = 1; i < n ;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        System.out.println("左边乘积："+Arrays.toString(res));
        // 存储右边乘积
        int tmp = nums[n-1];
        for(int i = n - 2; i >= 0 ; i--){

            res[i] = tmp * res[i];
            tmp *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
