package a03huadongchuangkou;

import java.util.ArrayList;
import java.util.List;

public class T02L438 {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] pHash = new int[26];
        int[] sHash = new int[26];
        int pl = p.length();
        int sl = s.length();
        char[] sc = s.toCharArray();
        int left = 0,right = 0;
        // 构造p的hash
        for(int i = 0 ; i < pl ;i++){
            pHash[p.charAt(i)-'a'] += 1;
        }

        List<Integer> res = new ArrayList<>();
        // 遍历s
        while(right < sl){
            // 入
            sHash[sc[right] - 'a'] ++;
            right++;

            if(right < pl){
                continue;
            }



            // 更新结果
            if(isAnagram(pHash,sHash)){
                res.add(left);
            }

            // 出
            sHash[sc[left] - 'a'] --;
            left++;
        }
        return res;
    }

    private static boolean isAnagram(int[] pHash, int[] sHash) {
        for(int i = 0 ; i < 26;i++){
            if(pHash[i] != sHash[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);
    }
}
