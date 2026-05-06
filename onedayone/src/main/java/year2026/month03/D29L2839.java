package year2026.month03;

import java.util.Arrays;

public class D29L2839 {
    public boolean canBeEqual(String s1, String s2) {
        int[][] cnt1 = new int[2][26];
        int[][] cnt2 = new int[2][26];
        for (int i = 0; i < s1.length(); i++) {
            cnt1[i % 2][s1.charAt(i) - 'a']++;
            cnt2[i % 2][s2.charAt(i) - 'a']++;
        }
        return Arrays.deepEquals(cnt1, cnt2);
    }
}
