package a02shuanzhizhen;

import java.util.*;

public class T03L15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0 ; i < nums.length;i ++){
            List<Integer> tmp = new ArrayList<>();
            int target = -nums[i];
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left]+nums[right] == target){
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    tmp = new ArrayList<>();
                    left++;
                    right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 不能先跳过重复的数 因为可能存在重复的数和其他数的组合 如 -1，-1，2
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if(left  > i+1 && nums[left] == nums[left-1]){
                    left++;
                    continue;
                }
                 if(right < nums.length-1 && nums[right] == nums[right+1]){
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] == target) {
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    tmp = new ArrayList<>();
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        int[] nums1 = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum2(nums1);
        for(List<Integer> list : res){
            System.out.println(list);
        }
    }
}
