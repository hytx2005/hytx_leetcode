package a02hchszz.b03dxlszz.c02xxszz;

import java.util.Collections;
import java.util.List;

class T10L2824 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0,right = nums.size() - 1;
        int res = 0;
        while(left < right){
            int t = nums.get(left) + nums.get(right);
            if(t < target){
                // left + (left+1 .... right) 都小于target
                res += right-left;
                left++;
            }else{
                right--;
            }
        }

        return res;
    }
}
