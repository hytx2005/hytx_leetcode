package month202607.week3.day19;

import java.util.*;

public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] sc = str.toCharArray();
            int[] numCount = new int[26];
            StringBuilder key = new StringBuilder();
            for(char scc : sc){
                numCount[scc-'a']++;
            }
            for(int i = 0 ; i < numCount.length ; i++){
                key.append(i).append('#').append(numCount[i]).append('#');
            }
            if(map.containsKey(key.toString())){
                map.get(key.toString()).add(str);
            }else {
                List<String> newString = new ArrayList<>();
                newString.add(str);
                map.put(key.toString(),newString);
            }
        }
        return map.values().stream().toList();
    }
}
