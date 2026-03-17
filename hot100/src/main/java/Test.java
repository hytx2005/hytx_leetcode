import a08echashu.base.TreeNode;

import javax.imageio.stream.ImageInputStream;
import java.util.*;

public class Test {
    public static int test(int[] nums,int k){
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
}
