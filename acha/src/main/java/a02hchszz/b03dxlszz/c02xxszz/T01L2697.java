package a02hchszz.b03dxlszz.c02xxszz;

/**
 * 2697. 字典序最小会问串 <a href="https://leetcode.cn/problems/lexicographically-smallest-palindrome/">...</a>
 * @author Dai
 * @date 2026/02/03
 */
public class T01L2697 {
    public String makeSmallestPalindrome(String s) {
        char[] sc = s.toCharArray();
        int left = 0,right = sc.length - 1;
        while(left < right){
            if(sc[left] != sc[right]){
                if(sc[left] > sc[right]){
                    sc[left] = sc[right];
                }else {
                    sc[right] = sc[left];
                }
            }
            left++;
            right--;
        }
        return new String(sc);
    }
}
