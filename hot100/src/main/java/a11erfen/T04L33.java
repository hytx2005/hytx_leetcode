package a11erfen;

public class T04L33 {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0 , right = n-1;
        while(left <= right){
            int mid = (left+right) >> 1;
            if(nums[mid] == target){
                return mid;
            }
            // 肯定有一边有序
            // 左边有序
            // [left,mid] 有序
            if(nums[mid] >= nums[left]){
                // 在左边
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            // 右边有序
            else{
                // 在右边
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;
        System.out.println(search(nums, target));
    }
}
