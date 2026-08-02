package month202608.week1.day2;

public class L283 {
    public void moveZeroes(int[] nums) {
        int zeroRight = 0;
        int index = 0;
        while(index < nums.length){
            if(nums[index] != 0){
                int temp = nums[zeroRight];
                nums[zeroRight] = nums[index];
                nums[index] = temp;
                zeroRight++;
            }
            index++;
        }
    }
}
