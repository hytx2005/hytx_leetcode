package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ASUS
 */
public class Leetcode1 {
    /*
    * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

      你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

      你可以按任意顺序返回答案。
    * */

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // key: 数值 value: 下标
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i],i);

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
