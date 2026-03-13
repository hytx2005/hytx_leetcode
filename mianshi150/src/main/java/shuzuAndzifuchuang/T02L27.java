package shuzuAndzifuchuang;

public class T02L27 {
    public int removeElement(int[] nums, int val) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}
