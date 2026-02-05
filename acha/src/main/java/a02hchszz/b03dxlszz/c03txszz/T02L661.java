package a02hchszz.b03dxlszz.c03txszz;

import java.util.Arrays;

/**
 * LeetCode 661. <a href="https://leetcode.cn/problems/valid-triangle-number/description/">...</a>
 * @author ASUS
 */
public class T02L661 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int k;
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = i+1 ; j < n ; j++){
                k = j;
                while(k+1 < n && nums[k+1] < nums[i]+nums[j]){
                    k++;
                }
                res+=k-j;
            }
        }
        return res;
    }
}
