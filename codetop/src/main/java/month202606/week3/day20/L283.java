package month202606.week3.day20;

public class L283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0,right = 0;
            int len = nums.length;
            while(right < len){
                if(nums[right] != 0){
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                }
                right++;
            }
        }
    }
}
