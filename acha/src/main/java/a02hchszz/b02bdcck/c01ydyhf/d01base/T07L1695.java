package a02hchszz.b02bdcck.c01ydyhf.d01base;

 class T07L1695 {
     public int maximumUniqueSubarray(int[] nums) {
         int res = 0;
         int left = 0;
         int l = nums.length;
         int[] count = new int[100000];
         int tmp = 0;
         for(int right = 0; right < l ;right++){
             // 入
             count[nums[right]]++;
             tmp+=nums[right];

             // 出
             while(count[nums[right]] > 1){
                 count[nums[left]] --;
                 tmp-=nums[left];
                 left++;
             }

             // 更新
             res = Math.max(res,tmp);
         }
         return res;
     }

     public static void main(String[] args) {
         T07L1695 l1695 = new T07L1695();
         System.out.println(l1695.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
     }
}
