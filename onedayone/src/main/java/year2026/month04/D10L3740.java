package year2026.month04;

import java.util.Arrays;

public class D10L3740 {
    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(nums[j] == nums[i]){
                    for(int k = j + 1 ; k < n ; k++){
                        if(nums[k] == nums[j]){
                            int temp = (k-i) * 2;
                            res = Math.min(res,temp);
                        }
                    }
                }
            }
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }
    public int minimumDistance2(int[] nums) {

        int n = nums.length;
        int res = n;
        // lst[n] 记录n的上一次出现位置，lst2[n] 记录n的上上次出现位置
        int[] last = new int[n+1];
        int[] last2 = new int[n+1];
        Arrays.fill(last,-n);
        Arrays.fill(last2,-n);
        for (int i = 0; i < n ; i++){
            int x = nums[i];
            res = Math.min(res, i - last2[x]);
            last2[x] = last[x];
            last[x] = i;
        }
        return res != n ? res*2 : -1;
    }
}
