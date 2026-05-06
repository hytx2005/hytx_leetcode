package a17jiqiao;

public class T03L75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr0 = 0;
        int ptr2 = n - 1;
        int mid = 0;
        while (mid <= ptr2) {
            if (nums[mid] == 0) {
                swap(nums, mid, ptr0);
                mid++;
                ptr0++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, ptr2);
                ptr2--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
