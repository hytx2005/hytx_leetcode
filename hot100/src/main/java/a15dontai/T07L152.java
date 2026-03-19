package a15dontai;

public class T07L152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        // 一个用来存储最大值，一个用来存储最小值
        long[] maxDp = new long[length];
        long[] minDp = new long[length];
        // 初始化
        for (int i = 0; i < length; i++) {
            maxDp[i] = nums[i];
            minDp[i] = nums[i];
        }
        for (int j = 1; j < length; j++) {
            maxDp[j] = Math.max(nums[j], Math.max(maxDp[j - 1] * nums[j], minDp[j - 1] * nums[j]));
            minDp[j] = Math.min(nums[j], Math.min(maxDp[j - 1] * nums[j], minDp[j - 1] * nums[j]));
        }
        int res = (int) maxDp[0];
        for (int i = 1; i < length; i++) {
            res = Math.max(res, (int) maxDp[i]);
        }
        return res;
    }
}
