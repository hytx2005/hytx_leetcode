package a04zichuang;

import java.util.HashMap;
import java.util.Map;

public class T03L76 {
    public static String minWindow(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();

        // 构造t的map集合
        for (char c : tc) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // 遍历s
        int left = 0,length = Integer.MAX_VALUE;
        int begin = 0;
        for (int i = 0 ; i < sc.length ; i++){
            // 入
            sMap.put(sc[i],sMap.getOrDefault(sc[i],0)+1);


            while (match(sMap,tMap)){
                // 更新长度
                if(i-left+1 < length){
                    length = i-left+1;
                    begin = left;
                }

                // 出
                sMap.put(sc[left],sMap.get(sc[left])-1);
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(begin,begin+length);
    }

    public static boolean match(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Character c : tMap.keySet()) {
            if (!sMap.containsKey(c) || sMap.get(c) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public  String minWindow2(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();
        int count = 0;
        for (char c : tc) {
            if(!map.containsKey(c)){
                count++;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int resLeft = -1,resRight = sc.length;
        int left = 0;
        for(int right = 0 ; right < sc.length ; right++){
            char c = sc[right];
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) == 0){
                count--;
            }

            while (count == 0){
                if(right - left < resRight - resLeft){
                    resLeft = left;
                    resRight = right;
                }
                char leftC = sc[left];

                // 出 如果此时leftC在map中，并且数量为0，说明之前刚好满足条件，现在要出去了，所以count要加1
                if (map.containsKey(leftC)){
                    if(map.get(leftC) == 0){
                        count++;
                    }
                }
                map.put(leftC,map.getOrDefault(leftC,0)+1);
                left ++;
            }
        }
        return resLeft == -1 ? "" : s.substring(resLeft,resRight+1);
    }

    public static void main(String[] args) {
        String s ="cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s,t));
    }
}
