package a10huisu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class T03L17 {
    Map<Integer, Integer> map;
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return List.of();
        }
        map = Map.of(
                1,0,
                2, 3,
                3, 6,
                4, 9,
                5, 12,
                6, 15,
                7, 19,
                8, 22,
                9, 26
        );
        char[] dc = digits.toCharArray();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        allSort(res,sb,dc,0,dc.length);
        return res;
    }

    private void allSort(List<String> res, StringBuilder sb, char[] dc, int i, int length) {
        if(i == length){
            res.add(sb.toString());
            return;
        }
        int begin = map.get(dc[i]-'0'-1);
        int end = map.get(dc[i]-'0');
        for(int j = begin; j < end; j++){
            sb.append((char)('a'+j));
            allSort(res,sb,dc,i+1,length);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
