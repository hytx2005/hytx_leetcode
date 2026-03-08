package a05shuzhu;

public class T05L41 {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        // 结果一定在1 - n+1之间
        int[] count = new int[n + 1];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                count[num - 1]++;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            if (count[i] == 0) {
                return i + 1;
            }
        }
        return 0;
    }
}
