package a02hchszz.b03dxlszz.c02xxszz;

/**
 * L0125 <a href="https://leetcode.cn/problems/valid-palindrome/description/">...</a>
 * @author Dai
 * &#064;date  2026/02/04
 */
class T02L0125 {
    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * 字母和数字都属于字母数字字符。
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     * @return boolean
     */
    public boolean isPalindrome(String s) {
        char[] sc = s.toLowerCase().toCharArray();
        int l = 0,r = sc.length-1;
        while(true){
            while(l < r && isLegal(sc[l])){
                l++;
            }
            while(l < r && isLegal(sc[r])){
                r--;
            }
            if(l >= r){
                break;
            }
            if(sc[l] != sc[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isLegal(char s){
        if(s >= 'a' && s <= 'z'){
            return false;
        }
        return s < '0' || s > '9';
    }
}
