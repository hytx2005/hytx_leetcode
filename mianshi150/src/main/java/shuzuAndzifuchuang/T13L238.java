package shuzuAndzifuchuang;

public class T13L238 {
    /**
     * 求自身以外数组的乘积 - 构建左部乘积和右边乘积
     * @param nums
     * @return {@link int[] }
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];

        // 构建左部乘积
        left[0] = 1;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            res[i] = left[i];
        }
        // 构建右部乘积
        right[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
            res[j] *= right[j];
        }
        return res;
    }
}
