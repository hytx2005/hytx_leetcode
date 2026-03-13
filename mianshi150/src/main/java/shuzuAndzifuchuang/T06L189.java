package shuzuAndzifuchuang;

import java.util.Arrays;

public class T06L189 {

    /**
     * 用新数组实现数组向右轮转 k 位
     * @param nums 数组
     * @param k 轮转位数
     */
    public void rotate1(int[] nums, int k) {
        if(k == 0){
            return;
        }
        int[] old = Arrays.copyOf(nums,nums.length);
        for(int i = 0 ; i < old.length; i++){
            nums[(i+k)%nums.length] = old[i];
        }
    }

    /**
     * 两次反转实现数组向右轮转 k 位
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums,int begin,int end){
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
