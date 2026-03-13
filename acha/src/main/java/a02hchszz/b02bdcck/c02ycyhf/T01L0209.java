package a02hchszz.b02bdcck.c02ycyhf;

/**
 * Leetcode 209. 长度最小的子数组 <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/">...</a>
 * @author Dai
 * &#064;date  2026/02/06
 */
public class T01L0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0;
        int tmp = 0,res = Integer.MAX_VALUE;
        for(;right<nums.length;right++){
            // 入
            tmp+=nums[right];

            // 出
            while(left < nums.length && tmp - nums[left] >= target){
                tmp-=nums[left];
                left++;
            }

            // 更新
            if(tmp >= target){
                res = Math.min(res,right-left+1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
