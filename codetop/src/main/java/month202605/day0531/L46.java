package month202605.day0531;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            allSort(res,nums,0,nums.length-1);
            return res;
        }

        public void allSort(List<List<Integer>> res, int[] nums, int begin, int end) {
            if(begin == end){
                res.add(Arrays.stream(nums).boxed().toList());
            }
            for (int i = begin; i <= end; i++) {
                swap(nums,i,begin);
                allSort(res,nums,begin+1,end);
                swap(nums,i,begin);
            }
        }
        public void swap(int[] nums,int i ,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


    }
}
