package shuzuAndzifuchuang;

public class T04L80 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int left = 0,right = left+1;
        int count = 1;
        while(right < nums.length){
            if(nums[right] == nums[left] && count >= 2){
                right++;
            }else{
                if(nums[left] == nums[right]){
                    nums[left+1] = nums[right];
                    count ++;
                }else{
                    nums[left+1] = nums[right];
                    count = 1;
                }
                left++;
                right++;
            }
        }
        return left+1;
    }

    public int removeDuplicates2(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        // right为待检查元素
        // left 为已检查元素右边界（不包）
        int left = 2,right = 2;
        while(right < nums.length){
            if(nums[left-2] != nums[right]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int l = removeDuplicates(nums);
        for (int i = 0; i < l; i++) {
            System.out.print(nums[i]+",");;
        }
    }
}
