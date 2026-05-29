package month202605.day0528;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            int len = nums.length;
            for (int first = 0; first < len - 2; first++) {
                if (first != 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                int target = -nums[first];
                int second = first + 1;
                int third = len - 1;
                while (second < third) {
                    if (second != first + 1 && nums[second] == nums[second - 1]) {
                        second++;
                        continue;
                    }
                    if (third != len - 1 && nums[third] == nums[third + 1]) {
                        third--;
                        continue;
                    }
                    int val = nums[second] + nums[third];
                    if (val > target) {
                        third--;
                    } else if (val < target) {
                        second++;
                    } else {
                        temp.add(nums[first]);
                        temp.add(nums[second]);
                        temp.add(nums[third]);
                        res.add(temp);
                        temp = new ArrayList<>();
                        second++;
                        third--;
                    }
                }
            }
            return res;
        }
    }
}
