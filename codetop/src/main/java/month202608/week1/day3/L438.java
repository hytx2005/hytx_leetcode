package month202608.week1.day3;

import java.util.ArrayList;
import java.util.List;

public class L438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        int left = 0 ,right = 0;
        int pLen = pc.length;
        for(char pcc : pc){
            pCount[pcc-'a']++;
        }
        while(right < sc.length){
            sCount[sc[right]-'a']++;
            right++;
            if(right < pLen){
                continue;
            }
            if(isEqual(sCount,pCount)){
                res.add(left);
            }
            sCount[sc[left] - 'a']--;
            left++;
        }
        return res;
    }

    public boolean isEqual(int[] s ,int[] p){
        for(int i = 0 ; i < 26 ; i++){
            if(s[i] != p[i]){
                return false;
            }
        }
        return true;
    }
}
