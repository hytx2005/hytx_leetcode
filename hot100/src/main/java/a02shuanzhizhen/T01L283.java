package a02shuanzhizhen;

public class T01L283 {
    public void moveZeroes(int[] nums) {
        int left = 0; // 合法的右边界，不包
        int right = 0; // 不合法的左边界，包
        while(right < nums.length){
            if(nums[right] != 0){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }
}
