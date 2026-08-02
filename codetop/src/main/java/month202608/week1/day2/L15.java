package month202608.week1.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for(int first = 0 ; first < len - 2 ; first ++){
            if(first != 0 && nums[first] == nums[first-1]){
                continue;
            }
            int third = len - 1;
            for(int second = first + 1 ; second < third; second ++){
                if(second != first + 1 && nums[second] == nums[second-1]){
                    continue;
                }
                while(third > second+1 && nums[first] + nums[second] + nums[third] > 0){
                    third--;
                }
                if(nums[first] + nums[second] + nums[third] < 0){
                    continue;
                }else if(nums[first] + nums[second] + nums[third] == 0){
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[first]);
                    t.add(nums[second]);
                    t.add(nums[third]);
                    res.add(t);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums1 = {-2,0,1,3};
        System.out.println(threeSum(nums1));
    }
}
