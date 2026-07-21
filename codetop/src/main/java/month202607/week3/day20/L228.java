package month202607.week3.day20;

import java.util.ArrayList;
import java.util.List;

public class L228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int left = 0,right = 0;
        int len = nums.length;
        if(len == 0){
            return res;
        }
        while (right < len){
            while (right+1 < len && nums[right+1] - 1 == nums[right]){
                right++;
            }
            if(right == left){
                res.add(String.valueOf(nums[left]));
            }else {
                res.add(nums[left] + "->" + nums[right]);
            }
            right++;
            left = right;
        }
        return res;
    }
}
