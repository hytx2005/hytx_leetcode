package a02hchszz.b02bdcck.c02ycyhf;

/**
 * Leetcode 3795 <a href="https://leetcode.cn/problems/minimum-subarray-length-with-distinct-sum-at-least-k/description/">...</a>
 * @author Dai
 * @date 2026/02/06
 */
class T02L3795 {
    public int minLength(int[] nums, int k) {
        int[] count = new int[100001];
        int left = 0,right = 0,l=nums.length;
        int tmp = 0,res = Integer.MAX_VALUE;
        for(;right < l ; right++){
            // 入
            count[nums[right]]++;
            if(count[nums[right]] == 1){
                tmp+=nums[right];
            }

            // 出
            int val = count[nums[left]] > 1 ? 0 : nums[left];
            while(left < right && tmp - val >= k){
                tmp-=val;
                count[nums[left]]--;
                left++;
                val = count[nums[left]] > 1 ? 0 : nums[left];
            }

            if(tmp >= k){
                res = Math.min(res,right-left+1);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        T02L3795 t02L3795 = new T02L3795();
        int[] nums = {6,6,11};
        int k = 12;
        System.out.println(t02L3795.minLength(nums,k));
    }
}
