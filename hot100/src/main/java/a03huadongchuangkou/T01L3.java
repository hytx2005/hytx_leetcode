package a03huadongchuangkou;

import java.util.HashMap;
import java.util.Map;

public class T01L3 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        while (right < s.length()){
            // 入
            char c = s.charAt(right);

            map.put(c,map.getOrDefault(c,0)+1);

            // 出
            while(map.get(c) > 1){
                char leftC = s.charAt(left);
                left++;
                map.put(leftC,map.get(leftC)-1);
            }

            // 更新结果
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }

    /**
     * 数组代替哈希
     * @param s
     * @return int
     */
    public static int lengthOfLongestSubstring2(String s) {
        int left = 0, right = 0;
        int[] hash = new int[128];
        int res = 0;
        while (right < s.length()){
            // 入
            char c = s.charAt(right);

            hash[c]++;

            // 出
            while(hash[c] > 1){
                char leftC = s.charAt(left);
                left++;
                hash[leftC]--;
            }

            // 更新结果
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
