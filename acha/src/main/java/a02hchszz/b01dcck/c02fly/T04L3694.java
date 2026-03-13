package a02hchszz.b01dcck.c02fly;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T04L3694 {
    private static final int[][] DIFS = new int[128][2];
    static {
        DIFS['U'][1] = 1;
        DIFS['D'][1] = -1;
        DIFS['L'][0] = -1;
        DIFS['R'][0] = 1;
    }
    public  int distinctPoints(String s, int k) {
        Set<List<Integer>> set = new HashSet<>();
        int[] res = new int[2];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // 入
            char c = charArray[i];
            res[0] += DIFS[c][0];
            res[1] += DIFS[c][1];

            // 更新
            int left = i - k + 1;
            if(left < 0){
                continue;
            }
            set.add(List.of(res[0],res[1]));

            // 出
            char d = charArray[left];
            System.out.println(c+" "+d);
            res[0] -= DIFS[d][0];
            res[1] -= DIFS[d][1];
        }
        return set.size();
    }

    public static void main(String[] args) {
        String s = "LUL";
        T04L3694 l3694 = new T04L3694();
        System.out.println(l3694.distinctPoints(s, 1));
    }
}
