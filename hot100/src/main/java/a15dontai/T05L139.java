package a15dontai;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T05L139 {
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= s.length() ; i++){
            sb.append(s.charAt(i-1));
            for (int i1 = 0; i1 < wordDict.size(); i1++) {
                String s1 = wordDict.get(i1);
                if(s1.length() <= sb.length()){
                    dp[i] = dp[i] || (dp[(i-s1.length())] && s1.equals(sb.substring(i-s1.length())));
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for(int i = 1 ; i <= s.length() ; i++){
            for (int j = 0; j < i ; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
