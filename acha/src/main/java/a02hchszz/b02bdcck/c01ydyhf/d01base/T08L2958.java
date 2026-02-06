package a02hchszz.b02bdcck.c01ydyhf.d01base;

import java.util.HashMap;

class T08L2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int l = nums.length;
        for(int right = 0; right < l ; right++){
            // 入
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            // 出
            while(map.get(nums[right]) > k){
                Integer val = map.get(nums[left]);
                if (val == 1){
                    map.remove(nums[left]);
                }else{
                    map.put(nums[left],val-1);
                }
                left++;
            }
            // 更新
            res = Math.max(res,right-left+1);
        }
        return res;
    }

    public static void main(String[] args) {
        T08L2958 l2958 = new T08L2958();
        l2958.maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2},2);
    }
}
