package month202606.week3.day15;

import java.util.*;

public class L49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            int[] count = new int[26];
            Map<String,List<String>> map = new HashMap<>();
            for (String str : strs){
                for (char c : str.toCharArray()){
                    count[c-'a']++;
                }
                // 拼接key
                StringBuilder sb = new StringBuilder();
                for (int i = 0 ; i < 26 ; i++){
                    sb.append(count[i]);
                    sb.append('#');
                }
                String key = sb.toString();
                if (!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(str);
                // 恢复count数组
                count = new int[26];
            }
            return map.values().stream().toList();
        }
    }
}
