package a02hchszz.b02bdcck.c02ycyhf;

/**
 * 2904 <a href="https://leetcode.cn/problems/shortest-and-lexicographically-smallest-beautiful-string/description/">...</a>
 * @author Dai
 * &#064;date  2026/02/06
 */
class T03L2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int count = 0;
        char[] sc = s.toCharArray();
        int left = 0,right = 0;
        String res = "";
        for(;right<s.length();right++){
            // 入
            count += sc[right] == '1' ? 1 : 0;

            // 出
            while((count == k && sc[left] == '0') || (count > k && sc[left] == '1')){
                count -= sc[left] == '1' ? 1 : 0;
                left++;
            }

            // 更新
            if(count == k){
                res = min(res,s.substring(left,right+1));
            }

        }
        return res;
    }

    public String min(String s1,String s2){
        if(s1 == ""){
            return s2;
        }
        if(s1.length() < s2.length()){
            return s1;
        }else if(s1.length() > s2.length()){
            return s2;
        }else{
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int l = s1.length();
            for(int i = 0 ; i < l ; i++){
                if(c1[i] < c2[i]){
                    return s1;
                }else if(c1[i] > c2[i]){
                    return s2;
                }
            }
            return s1;
        }
    }
}
