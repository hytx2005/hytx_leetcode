package a02hchszz.b01dcck.c02fly;

import java.util.List;

public class T02L1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] ans = new int[2];
        int max = 0;
        for (int i = 0; i < customers.length; i++) {
            // 入
            ans[grumpy[i]] += customers[i];

            // 更新
            int left = i - minutes + 1;
            if( left < 0){
                continue;
            }
            max = Math.max(max, ans[1]);

            // 出
            ans[1] -= grumpy[left] == 1 ? customers[left] : 0;
        }
        System.out.println(ans[0] + " " + max);
        return ans[0] + max;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1);
                //List.of(1,0,1,2,1,1,7,5);
        int[] array1 = list1.stream().mapToInt(Integer::intValue).toArray();
        List<Integer> list2 = List.of(0);
                //List.of(0,1,0,1,0,1,0,1);
        int[] array2 = list2.stream().mapToInt(Integer::intValue).toArray();
        T02L1052 t2 = new T02L1052();
        System.out.println(t2.maxSatisfied(array1, array2, 1));
    }
}
