package day2;

import java.util.Arrays;

public class L215 {
    public static int[] minHeap;// 小顶堆
    public static int size;
    public static int findKthLargest(int[] nums, int k) {
        minHeap = new int[k];
        Arrays.fill(minHeap,-10001);
        size = k;
        for(int num : nums){
            add(num);
        }
        return minHeap[0];
    }

    // 下沉，从两个子节点中选择一个较小的交换
    private static void down(int index){
        int leftSon = 2*index + 1;
        int rightSon = leftSon + 1;
        if(leftSon >= size &&  rightSon>=size){
            return;
        }
        if(rightSon >= size){
            rightSon = leftSon;
        }
        int minVal = Math.min(minHeap[leftSon],minHeap[rightSon]);
        if(minVal >= minHeap[index]){
            return;
        }
        if(minVal == minHeap[leftSon]){
            int temp = minHeap[leftSon];
            minHeap[leftSon] = minHeap[index];
            minHeap[index] = temp;
            down(leftSon);
        }else{
            int temp = minHeap[rightSon];
            minHeap[rightSon] = minHeap[index];
            minHeap[index] = temp;
            down(rightSon);
        }
    }

    private static void add(int value){
        if(value > minHeap[0]){
            minHeap[0] = value;
            down(0);
        }
        System.out.println(Arrays.toString(minHeap));
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 6;
        System.out.println(findKthLargest(nums,k));
    }
}
