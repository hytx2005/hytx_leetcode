package month202607.week3.day16;

import java.util.HashMap;

public class L76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> targetCnt = new HashMap<>();
        char[] tc = t.toCharArray();
        for(char tcc : tc){
            targetCnt.put(tcc,targetCnt.getOrDefault(tcc,0)+1);
        }
        String res = s + t;
        char[] sc = s.toCharArray();
        int right = 0;
        HashMap<Character,Integer> cnt= new HashMap<>();
        // 满足需求的字符类别数目，按类别
        int match = 0;
        int left = 0;
        for(;right < sc.length; right++){

            // 入
            char in = sc[right];
            int inCnt = cnt.getOrDefault(in,0);
            int inTarget = targetCnt.getOrDefault(in,0);
            cnt.put(in,cnt.getOrDefault(in,0)+1);
            if(inTarget > 0){
                // 不相等->相等
                if(inCnt + 1 == inTarget){
                    match ++;
                }
            }

            // 更新+出
            while (match == targetCnt.size()){

                // 更新
                String newRes = s.substring(left,right+1);
                if(newRes.length() < res.length()){
                    res = newRes;
                }
                // 出
                char out = sc[left];
                int outCnt = cnt.getOrDefault(out,0);
                int outTarget = targetCnt.getOrDefault(out,0);
                cnt.put(out,cnt.getOrDefault(out,0)-1);
                left++;
                if(outTarget > 0){
                    // 相等 -> 不等
                      if(outCnt == outTarget){
                        match--;
                    }
                }
            }
        }
        return res.length() > s.length() ? "" : res;
    }
}
