package a02hchszz.b03dxlszz.c03txszz;

import java.util.Arrays;

/**
 * LeetCode 3649 <a href="https://leetcode.cn/problems/number-of-perfect-pairs/description/">...</a>
 */
public class T03L3649 {
    public long perfectPairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // nums[i] = Math.abs(nums[i]);
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }
        Arrays.sort(nums);
        long res = 0;
        for(int left = 0,right = 0;right < nums.length ; right++){
            int b = nums[right];
            while(nums[left]*2 < b){
                left++;
            }
            res+=right-left;
        }
        return res;
    }
}
