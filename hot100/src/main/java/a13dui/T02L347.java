package a13dui;

import java.util.HashMap;
import java.util.Map;

public class T02L347 {
    int[][] maxDui;
    int size;
    Map<Integer,Integer> set;
    public  int[] topKFrequent(int[] nums, int k) {
        // 先存储到哈希表
        set = new HashMap<>();
        for (int num : nums) {
            if (set.containsKey(num)) {
                set.put(num, set.get(num) + 1);
            } else {
                set.put(num, 1);
            }
        }
        // 用哈希表初始化堆
        maxDui = new int[set.size()][2];
        size = 0;
        for (Integer i : set.keySet()) {
            maxDui[size][0] = i;
            maxDui[size][1] = set.get(i);
            size++;
        }

        // 使堆成为大顶堆
        for (int i = size /2 - 1; i >= 0; i--) {
            down(i);
        }

        // 取出前k个
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = removeTop();
        }
        return res;
    }

    public  void swap(int i,int j){
        int temp = maxDui[i][0];
        maxDui[i][0]= maxDui[j][0];
        maxDui[j][0] = temp;
        temp = maxDui[i][1];
        maxDui[i][1]= maxDui[j][1];
        maxDui[j][1] = temp;
    }

    public  int removeTop(){
        int temp = maxDui[0][0];
        size--;
        swap(0,size);
        down(0);
        return temp;
    }

    public  void down(int i){
        int left = 2 * i + 1;
        int right = left + 1;
        int max = i;
        if(left < size && maxDui[left][1] > maxDui[max][1]){
            max = left;
        }
        if(right < size && maxDui[right][1] > maxDui[max][1]){
            max = right;
        }
        if(max != i){
            swap(i,max);
            down(max);
        }
    }
}
