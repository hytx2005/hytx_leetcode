package a02hchszz.b01dcck.c02fly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T01L3679 {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arrivals.length; i++) {
            int x = arrivals[i];

            int c = map.getOrDefault(x,0);
            map.put(x,c+1);
            if (c == m){
                count++;
                arrivals[i] = 0;
                // 恢复到原来的状态
                map.put(x,c);
            }

            if (i >= w - 1){
                // 只有没有杯抛弃的才需要移除，如果已经杯抛弃，不需要再次移除
                if (arrivals[i-w+1] != 0){
                    map.merge(arrivals[i-w+1],-1,Integer::sum);
                }

            }
        }
        return count;
    }


    public static void main(String[] args) {
        //List<Integer> list = List.of(1,2,3,3,3,4);
        List<Integer> list = List.of(1,2,1,3,1);
        List<Integer> list1 = List.of(9,2,5,2,10,9,8,7);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        int[] array1 = list1.stream().mapToInt(Integer::intValue).toArray();
        T01L3679 t01L3679 = new T01L3679();
        System.out.println(t01L3679.minArrivalsToDiscard(array, 4, 2));
    }
}
