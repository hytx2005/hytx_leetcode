package year2025.month10;

import java.util.HashSet;
import java.util.Set;

public class D251031L3289 {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> num = new HashSet<>();
        int [] res = new int[2];
        int k = 0;
        for (int j : nums) {
            if (num.contains(j)) {
                res[k++] = j;
                if (k == 2) {
                    return res;
                }
            } else {
                num.add(j);
            }
        }
        return res;
    }
}
