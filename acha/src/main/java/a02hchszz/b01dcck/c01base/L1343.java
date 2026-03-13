package a02hchszz.b01dcck.c01base;

public class L1343 {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        threshold *= k;
        // 1.准备数据，前k-1个
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        // 2.开始滑动
        for (int i = k - 1; i < arr.length; i++) {
            // 入
            sum += arr[i];

            // 更新
            if(sum >= threshold){
                count++;
            }

            // 出
            sum -= arr[i - k + 1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,5,5,5,8};
        System.out.println(numOfSubarrays(arr, 3, 4));
    }
}
