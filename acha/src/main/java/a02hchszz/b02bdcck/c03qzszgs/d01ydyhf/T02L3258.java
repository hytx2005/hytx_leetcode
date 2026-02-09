package a02hchszz.b02bdcck.c03qzszgs.d01ydyhf;

/**
 * <a href="https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/description/">...</a>
 */
class T02L3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int[] freq = new int[2];
        char[] sc = s.toCharArray();
        int left = 0,right = 0;
        int res = 0;
        for (;right  < sc.length; ++right) {
            // 入
            freq[sc[right] - '0']++;

            // 出
            while (freq[0] > k && freq[1] > k && left <= right) {
                freq[sc[left] - '0']--;
                left++;
            }

            // 统计
            res += right-left+1;
        }
        return res;
    }

    public static void main(String[] args) {
        T02L3258 l3258 = new T02L3258();
        System.out.println(l3258.countKConstraintSubstrings("10101", 1));
    }
}
