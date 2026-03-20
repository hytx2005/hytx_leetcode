package a17jiqiao;

public class T04L31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 1.找到左边的较小数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 找到右边第一个比较小数大的数
        if(i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        // 此时a[i]右边必为降序，反转变为升序
        reverse(nums, i + 1);
    }


    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums,int start){
        int left = start,right = nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
