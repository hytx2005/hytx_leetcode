package hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ASUS
 */
public class Leetcode49 {
    /*
    * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

        示例 1:

        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

        解释：

        在 strs 中没有字符串可以通过重新排列来形成 "bat"。
        字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
        字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
    * */

    public static List<List<String>> groupAnagrams(String[] strs) {
        // key为排序后的字符串+次数拼接而成
        Map<String,List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }
            System.out.println(Arrays.toString(counts));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    sb.append((char)('a'+i));
                    sb.append(counts[i]);
                }
            }
            System.out.println("key："+sb);
            List<String> orDefault = resMap.getOrDefault(sb.toString(), new ArrayList<>());
            orDefault.add(str);
            resMap.put(sb.toString(),orDefault);
        }
        return new ArrayList<>(resMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //List<List<String>> ans = groupAnagrams(strs);
        //System.out.println(ans);
        strs = new String[]{"ddddddddddg","dgggggggggg"};
        System.out.println(groupAnagrams(strs));
    }
}
