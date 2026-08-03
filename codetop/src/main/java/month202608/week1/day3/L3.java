package month202608.week1.day3;

public class L3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0,right = 0;
        int[] count = new int[256];
        char[] sc = s.toCharArray();
        while(right < sc.length){
            // 入
            count[sc[right]]++;

            // 出
            while(count[sc[right]] > 1){
                count[sc[left]]--;
                left++;
            }

            // 更新结果
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
