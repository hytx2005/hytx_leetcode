package a02hchszz.b03dxlszz.c03txszz;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 2200 <a href="https://leetcode.cn/problems/find-all-k-distant-indices-in-an-array/description/">...</a>
 * @author Dai
 * &#064;date  2026/02/05
 */
class T01L2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        // 单向双指针 left记录合法且未加入的值的左边界，right来记录key的位置
        //  则合法的范围 为 [Math.max(left,right-k),Math.min(right+k,nums.length-1)]
        int left = 0,right = 0;
        List<Integer> res = new ArrayList<>();
        while(right < nums.length){
            if(nums[right] == key){
                // | i - j | <= k 其中j这里是right，故左边界为 j-i=k
                left = Math.max(left,right-k);
                int m = Math.min(right+k,nums.length-1);
                while(left <= m){
                    res.add(left);
                    left++;
                }
            }
            right++;
        }
        return res;
    }
}
