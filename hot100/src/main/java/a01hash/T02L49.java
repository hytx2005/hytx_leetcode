package a01hash;

import java.util.*;

public class T02L49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int[] ch = new int[26];
        for(String str : strs){
            char[] sc = str.toCharArray();
            for(char c : sc){
                ch[c-'a'] ++;
            }
            // 拼接key
            StringBuilder key = new StringBuilder();
            for(int i = 0 ; i< 26;i++){
                if(ch[i] != 0){
                    key.append((char)('a'+i));
                    key.append(ch[i]);
                }
            }
            // 放入map
            String keys = key.toString();
            if(map.containsKey(keys)){
                List<String> list = map.get(keys);
                list.add(str);
                map.put(keys,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(keys,list);
            }
            // 重置ch
            Arrays.fill(ch,0);
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }
}
