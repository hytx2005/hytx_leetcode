package a02hchszz.b02bdcck.c01ydyhf.d01base;

 class T03L1493 {
    public int longestSubarray(int[] nums) {
        // 记录出现次数
        int count = 0;
        int l = nums.length;
        int res = 0;
        int right = -1;
        for(int i = 0 ; i < l ; i++){

            // 入 (可以入的两种情况)
            // 1.count == 0 此时不管是0还是1都可以入 -> count == 0
            // 2.count == 1 此时只有1可以入 -> count == 1 && nums[right+1] == 1
            while(right+1 <l && (count ==0  || (count == 1 && nums[right+1] == 1))){
                count+=Math.abs(nums[right+1] - 1);
                right++;
            }


            // 更新
            res = Math.max(res,right-i);
            // 出
            count -= Math.abs(nums[i] - 1);
        }
        return res;
    }

     public static void main(String[] args) {
         T03L1493 t03L1493 = new T03L1493();
         int[] nums = {0,1,1,1,0,1,1,0,1};
         System.out.println(t03L1493.longestSubarray(nums));
     }
}
