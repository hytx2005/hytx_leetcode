package a02hchszz.b02bdcck.c01ydyhf.d01base;

import java.util.HashSet;

class T01L0003 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();

        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int right = -1;
        char[] sChar = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            // 入
            while (right+1 < length && !set.contains(sChar[right+1])){
                set.add(sChar[right+1]);
                right++;
            }
            // 更新结果
            res = Math.max(res, right - i + 1);

            // 出
            set.remove(sChar[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        T01L0003 l0003 = new T01L0003();
        System.out.println(l0003.lengthOfLongestSubstring("abcabcbb"));
    }
}
