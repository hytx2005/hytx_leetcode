package a02hchszz.b01dcck.c01base;

import java.util.List;
import java.util.Map;

public class L1423 {
    public int maxScore(int[] cardPoints, int k) {
        int non = cardPoints.length - k;
        int sum = 0;
        int otherSum = 0;

        // 初始化
        for (int d = 0; d < non; d++) {
            sum += cardPoints[d];
            otherSum += cardPoints[d];
        }
        int res = sum;
        for (int i = non; i < cardPoints.length;i++){
            otherSum += cardPoints[i];
            // 入
            sum += cardPoints[i];

            // 出
            sum -= cardPoints[i - non];
            res = Math.min(res, sum);
        }

        return otherSum - res;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,1);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        L1423 l1423 = new L1423();
        System.out.println(l1423.maxScore(array, 7));
    }
}
