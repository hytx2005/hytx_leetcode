package a02hchszz.b01dcck.c01base;

import java.util.Arrays;

/**
 * @author ASUS
 */
public class L2090 {
    public static int[] getAverages(int[] nums, int k) {
        // 准备结果，先全部设为-1;
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        //
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 入
            sum += nums[i];

            // 更新
            if( i < 2*k){
                continue;
            }
            res[i-k] = (int) (sum / (2*k+1));

            // 出
            sum -= nums[i - 2*k];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,4,3,9,1,8,5,2,6};
        System.out.println(Arrays.toString(getAverages(nums, 3)));
    }
}
