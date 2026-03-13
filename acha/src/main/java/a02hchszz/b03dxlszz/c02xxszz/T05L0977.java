package a02hchszz.b03dxlszz.c02xxszz;

/**
 * Leetcode 977 <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/description/">...</a>
 */
class T05L0977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0,r = nums.length - 1;
        int locate = nums.length - 1;
        while(l <= r){
            int a = nums[l] * nums[l];
            int b = nums[r] * nums[r];
            if( a > b){
                res[locate] = a;
                locate--;
                l++;
            }else{
                res[locate] = b;
                locate--;
                r--;
            }
        }
        return res;
    }
}
