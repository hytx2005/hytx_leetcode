package year2025.month10;

/**
 * @author ASUS
 */
public class D251028L354 {
    public int countValidSelections(int[] nums) {
        int l = nums.length,res=0,sum=0;
        for (int num : nums) {
            sum+=num;
        }
        int leftSum = 0,rightSum=sum;
        for (int num : nums) {
            if (num == 0) {
                if (leftSum == rightSum) {
                    res += 2;
                } else if (Math.abs(leftSum - rightSum) == 1) {
                    res++;
                }
            }
            leftSum += num;
            rightSum -= num;
        }
        return res;
    }
}
