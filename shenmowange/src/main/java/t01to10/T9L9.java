package t01to10;

/**
 * 回文数  <a href="https://leetcode.cn/problems/palindrome-number/description/">...</a>
 * @author Dai
 * &#064;date  2026/02/11
 */
class T9L9 {

    /**
     * 转为字符串判断是否是回文字符串 时间复杂度 O(n)
     * @param x 整数
     * @return boolean
     */
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        char[] xc = String.valueOf(x).toCharArray();
        int l = 0,r = xc.length-1;
        while(l < r){
            if(xc[l] != xc[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
