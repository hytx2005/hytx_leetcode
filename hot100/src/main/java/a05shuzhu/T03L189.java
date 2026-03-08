package a05shuzhu;

import java.util.Arrays;

public class T03L189 {
    public void rotate(int[] nums, int k) {
        reverse(nums,0,nums.length-1);
        k %= nums.length;
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
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

    public static void rotate2(int[] nums,int k){
        int n = nums.length;
        k %= n;
        int count = 0;
        int begin = 0;
        while (count < n){
            // 从begin开始，依次交换位置，直到回到begin位置
            int current = begin;
            int prev = nums[current];
            do{
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while (current != begin);
            begin++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        rotate2(new int[]{1,2,3,4,5,6,7},3);
    }
}
