package day1;

public class L03 {
    public static int lengthOfLongestSubstring(String s) {
        // left为左边界
        int left = 0,right = 0;
        char[] sc = s.toCharArray();
        int m = sc.length;
        int[] flag = new int[256];
        int res = 1;
        while(right < m){
            // 入
            flag[sc[right]] ++;

            // 出
            while(flag[sc[right]] > 1){
                flag[sc[left]]--;
                left++;
            }

            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
