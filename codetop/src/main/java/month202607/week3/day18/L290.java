package month202607.week3.day18;

import java.util.HashMap;
import java.util.Map;

public class L290 {
    public boolean wordPattern(String pattern, String s) {
        char[] pc = pattern.toCharArray();
        String[] ss = s.split(" ");
        if(pc.length != ss.length){
            return false;
        }
        Map<Character,String> p2s = new HashMap<>();
        Map<String,Character> s2p = new HashMap<>();

        for(int i = 0 ; i < pc.length ; i++){
            if((p2s.containsKey(pc[i]) && !p2s.get(pc[i]).equals(ss[i]))
            || (s2p.containsKey(ss[i]) && s2p.get(ss[i]) != pc[i])){
                return false;
            }
            p2s.put(pc[i],ss[i]);
            s2p.put(ss[i],pc[i]);
        }
        return true;
    }
}
