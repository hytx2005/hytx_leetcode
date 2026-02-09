package t01to10;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 <a href="https://leetcode.cn/problems/two-sum/description/">...</a>
 * @author ASUS
 */
class T01L1 {
    /*
    * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    * */

    /**
     * 做法一 ：双重循环暴力破解 时间复杂度 O(n^2) 空间复杂度 O(1)
     * @param nums 整数数组
     * @param target 目标值
     * @return {@link int[] }
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 做法二 ：哈希表 时间复杂度 O(n) 空间复杂度 O(n)
     * @param nums  整数数组
     * @param target 目标值
     * @return {@link int[] }
     */
    public int[] twoSum2(int[] nums,int target){
        // 哈希表存储已经访问过的元素及其索引
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 计算补数
            if (map.containsKey(complement)) {
                // 如果补数在哈希表中，说明找到了答案
                return new int[]{map.get(complement), i};
                // 返回补数的索引和当前元素的索引
            }
            map.put(nums[i], i);
            // 将当前元素及其索引存入哈希表
        }
        return new int[]{-1, -1};
        // 如果没有找到答案，返回[-1, -1]
    }
}
