package a13dui;

import java.util.PriorityQueue;

public class T01L215 {
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int num : nums){
            if (minHeap.size() < k){
                minHeap.offer(num);
            }else {
                if(num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        return minHeap.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int[] minHeap = new int[k];
        int size = 0;
        for(int num : nums){
            if (size < k){
                add(minHeap,num,size);
                size++;
            }else if(num > minHeap[0]){
                removeFirst(minHeap,size);
                size--;
                add(minHeap,num,size);
                size++;
            }
         }
        return minHeap[0];
    }

    public void add(int[] minHeap,int num,int length){
        minHeap[length] = num;
        reBuild(minHeap, length);
    }

    /**
     * 重建二叉树--上浮
     * @param minHeap
     * @param i
     */
    private void reBuild(int[] minHeap, int i) {
       if(i == 0){
           return;
       }
       int parent = (i-1)/2;
         if(minHeap[parent] > minHeap[i]){
                int temp = minHeap[parent];
                minHeap[parent] = minHeap[i];
                minHeap[i] = temp;
                reBuild(minHeap,parent);
         }
    }

    public void reBuildDown(int[] minHeap,int i,int length){
        int leftSon = 2*i+1;
        int right = 2*i+2;
        int minIndex = i;
        if(leftSon < length && minHeap[leftSon] < minHeap[minIndex]){
            minIndex = leftSon;
        }
        if(right < length && minHeap[right] < minHeap[minIndex]){
            minIndex = right;
        }
        if(minIndex != i){
            int temp = minHeap[i];
            minHeap[i] = minHeap[minIndex];
            minHeap[minIndex] = temp;
            reBuildDown(minHeap,minIndex, length);
        }

    }


    public void removeFirst(int[] minHeap,int length){
        minHeap[0] = minHeap[length -1];
        reBuildDown(minHeap,0, length);
    }
}
