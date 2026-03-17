package a14tanxin;

public class T02L55 {
    public boolean canJump(int[] nums) {
        int right = 0;
        int n = nums.length;
        for(int i = 0 ; i <= right && i < n ; i++){
            right = Math.max(right,nums[i]+i);
        }
        return right>=n-1;
    }
}
