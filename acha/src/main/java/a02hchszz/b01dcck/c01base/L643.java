package a02hchszz.b01dcck.c01base;

/**
 * @author ASUS
 */
public class L643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int temp = Integer.MIN_VALUE;
        // 1.准备数据，前k-1个
        for (int i = 0; i < k - 1; i++) {
            sum += nums[i];
        }

        // 2.开始滑动
        for (int i = k - 1; i < nums.length; i++) {
            // 入
            sum += nums[i];
            // 更新
            temp = Math.max(temp, sum);
            // 出
            sum -= nums[i - k + 1];
        }
        return temp * 1.0 / k;
    }

    public static void main(String[] args) {
        L643 obj = new L643();
        System.out.println(obj.findMaxAverage(new int[]{-1},1));
    }
}
