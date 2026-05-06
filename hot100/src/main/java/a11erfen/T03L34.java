package a11erfen;

public class T03L34 {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums,target);
        int right = searchLeft(nums,target + 1) - 1;
        if(left <= right && right < nums.length && nums[left] == target && nums[right] == target){
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }

    /**
     * 找到第一个大于等于target的元素索引pos
     * 有 nums[pos] >= target
     * @param nums
     * @param target
     * @return int
     */
    public static int searchLeft(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 11;
        System.out.println(searchLeft(nums, target));
    }
}
