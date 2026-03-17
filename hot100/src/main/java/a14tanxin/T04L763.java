package a14tanxin;

import java.util.ArrayList;
import java.util.List;

public class T04L763 {
    public List<Integer> partitionLabels(String s) {
        int[] end = new int[26];
        char[] sc = s.toCharArray();
        for(int i = 0 ; i < sc.length ; i++){
            end[sc[i]-'a'] = i;
        }
        //
        List<Integer> res = new ArrayList<>();
        int e = 0;
        int left = 0;
        for(int right = 0 ; right < sc.length ; right++){
            e = Math.max(e,end[sc[right]-'a']);
            if(right == e){
                res.add(right - left + 1);
                left = right+1;
                e++;
            }
        }
        return res;
    }
}
