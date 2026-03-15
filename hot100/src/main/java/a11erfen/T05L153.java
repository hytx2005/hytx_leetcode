package a11erfen;

public class T05L153 {
    public static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0,right = n - 1;

        while(left < right){
            int mid = (left + right ) >> 1;
            if(nums[mid] < nums[right]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
