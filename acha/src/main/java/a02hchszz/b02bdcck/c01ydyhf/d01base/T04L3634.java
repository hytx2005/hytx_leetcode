package a02hchszz.b02bdcck.c01ydyhf.d01base;

import java.util.Arrays;

 class T04L3634 {
    public int minRemoval(int[] nums, int k) {
        // 排序后使用滑动窗口
        Arrays.sort(nums);

        int l = nums.length;
        int res = 0;
        int right = -1;
        for (int i = 0; i < l; i++) {
            // 入
            while (right+1 < l && nums[right+1] <= (long)nums[i]*k){
                right++;
            }
            // 更新
            res = Math.max(res, right-i+1);

            // i移动自动视为出
        }



        return l-res;
    }

     public static void main(String[] args) {
         T04L3634 l3634 = new T04L3634();
         int[] nums1 = {2,1,5};
         int[] nums2 = {1,6,2,9};
         int[] nums3 = {4,6};
         int[] nums4 = {1};
         System.out.println(l3634.minRemoval(nums1, 2));
         System.out.println(l3634.minRemoval(nums2, 3));
         System.out.println(l3634.minRemoval(nums3, 2));
         System.out.println(l3634.minRemoval(nums4, 1));
     }
}
