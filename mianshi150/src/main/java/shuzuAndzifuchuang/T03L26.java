package shuzuAndzifuchuang;

public class T03L26 {
    public int removeDuplicates(int[] nums) {
        int left = 0,right=1;
        while(right < nums.length){
            if(nums[right] == nums[left]){
                right++;
            }else{
                nums[left+1] = nums[right];
                left++;
                right++;
            }
        }
        return left+1;
    }
}
