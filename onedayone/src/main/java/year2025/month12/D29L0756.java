package year2025.month12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ASUS
 */
public class D29L0756 {
    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        List<Character>[][] dp = new ArrayList[6][6];
        for (String s : allowed) {
            if(dp[s.charAt(0) - 'A'][s.charAt(1) - 'A']==null){
                dp[s.charAt(0) - 'A'][s.charAt(1) - 'A'] = new ArrayList<>();
            };
            dp[s.charAt(0) - 'A'][s.charAt(1) - 'A'].add(s.charAt(2));
        }
        Set<String> list = new HashSet<>();
        dfs(0,bottom,dp,list,new StringBuilder());
        int fre = bottom.length()-1;
        while (fre > 0){
            ;
            Set<String> res = new HashSet<>();
        }
        return list.isEmpty();
    }

    public static void dfs(int begin, String bottom, List[][] dp, Set<String> res, StringBuilder temp){
        if (begin < bottom.length()-1){
            List<Character> c = dp[bottom.charAt(begin)-'A'][bottom.charAt(begin+1)-'A'];
            if (c == null){
                return;
            }
            for (Character character : c) {
                StringBuilder newTemp = new StringBuilder(temp);
                newTemp.append(character);
                dfs(begin+1,bottom,dp,res,newTemp);
            }
        }else {
            res.add(temp.toString());
        }
    }


    public static void main(String[] args) {
        String bottom = "AAAA";
        List<String> allowed = new ArrayList<>();
        allowed.add("AAB");
        allowed.add("AAC");
        allowed.add("BCD");
        allowed.add("BBE");
        allowed.add("DEF");
        System.out.println(pyramidTransition(bottom, allowed));
    }
}
