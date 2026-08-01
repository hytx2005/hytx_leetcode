package month202608.week1.day1;

import java.util.*;

public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> maps = new HashMap<>();
        for(String str : strs){
            char[] sc = str.toCharArray();
            Arrays.sort(sc);
            String key = new String(sc);
            if(maps.containsKey(key)){
                maps.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                maps.put(key,list);
            }
        }
        return  maps.values().stream().toList();
    }
}
