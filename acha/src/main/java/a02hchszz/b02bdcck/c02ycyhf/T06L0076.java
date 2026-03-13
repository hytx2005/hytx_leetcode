package a02hchszz.b02bdcck.c02ycyhf;

import java.util.HashMap;

/**
 * Leetcode76 <a href="https://leetcode.cn/problems/minimum-window-substring/description/">...</a>
 */
class T06L0076 {
    int[] sIndex = new int[128];
    int[] tIndex = new int[128];
    public String minWindow(String s, String t) {
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();
        for(char c : tc){
            tIndex[c]++;
        }
        int resLeft = -1,resRight = s.length();
        int left = 0;
        for(int right = 0; right < sc.length; right++){
            sIndex[sc[right]]++;

            // 出
            while (isEqual()){
                if(right - left < resRight - resLeft){
                    resLeft = left;
                    resRight = right;
                }
                sIndex[sc[left]]--;
                left++;
            }
        }
        return resLeft < 0 ? "" : s.substring(resLeft,resRight+1);
    }

    public boolean isEqual(){
        for (char c = 'a'; c <= 'z'; c++) {
            if(sIndex[c] < tIndex[c]){
                return false;
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if(sIndex[c] < tIndex[c]){
                return false;
            }
        }
        return true;
    }
}
