package month202605.day0531;

public class L33 {
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            int left = 0,right = len - 1;
            while (left <= right){
                int mid = (left+right) >> 1;
                if(nums[mid] == target){
                    return mid;
                }
                if(nums[mid] >= nums[left]){
                    if(target >= nums[left] && target < nums[mid]){
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }else {
                    if(target > nums[mid] && target <= nums[right]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
