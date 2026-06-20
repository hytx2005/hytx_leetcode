package month202606.week3.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return null;
            }
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            for (int first = 0; first < len - 2; first++) {
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                int second = first + 1, third = len - 1;
                for (; second < len - 1; second++) {
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 这里是因为数组已经排序了，如果三个数的和大于0，那么说明第三个数太大了，应该往前移动
                    // 且保证second 在 third 的左边
                    while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                        third--;
                    }
                    if (second == third) {
                        break;
                    }
                    if (nums[first] + nums[second] + nums[third] == 0) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    }
                }
            }
            return res;
        }
    }
}
