package a02hchszz.b02bdcck.c03qzszgs.d01ydyhf;

/**
 * <a href="https://leetcode.cn/problems/subarray-product-less-than-k/description/">...</a>
 */
class T01L0713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0,right = 0;
        int count = 0;
        long res = 1;
        for (; right < nums.length; right++) {
            // 入
            res *= nums[right];

            // 出
            while(res >= k && left <= right){
                res /= nums[left];
                left++;
            }
            // 计数
            count += right - left + 1;
        }
        return count;
    }
}
