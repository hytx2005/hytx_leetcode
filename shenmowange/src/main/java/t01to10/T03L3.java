package t01to10;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">无重复字符的最长字串 </a>
 * @author Dai
 * &#064;date  2026/02/09
 */
class T03L3 {

    /**
     * 滑动窗口+哈希表记录 时间复杂度：O(n)，其中 n 是字符串 s 的长度。空间复杂度：O(min(m,n))，其中 m 是字符集的大小，在本题中为 128。
     * @param s
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {
        //转为字符数组操作更快速
        char[] sc = s.toCharArray();
        // 越长越合法，故初始值为0
        int res = 0;
        int left = 0,right = 0;
        // 使用哈希表存储字符和字符的次数
        HashMap<Character,Integer> map = new HashMap<>();

        // 开始滑动
        while(right < sc.length){
            // 入
            char c = sc[right];
            map.put(c,map.getOrDefault(c,0)+1);

            // 出
            while(left < right && map.get(c) > 1){
                map.put(sc[left],map.getOrDefault(sc[left],0)-1);
                left++;
            }

            // 更新
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
