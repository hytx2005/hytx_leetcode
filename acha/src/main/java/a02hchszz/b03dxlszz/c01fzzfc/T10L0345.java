package a02hchszz.b03dxlszz.c01fzzfc;

/**
 * Leetcode345 反转字符串中的元音字母<a href="https://leetcode.cn/problems/reverse-vowels-of-a-string/">...</a>
 * @author Dai
 * @date 2026/02/03
 */
public class T10L0345 {
    public String reverseVowels(String s) {
        char[] sc = s.toCharArray();
        int left = 0, right = sc.length - 1;
        String vowels = "aeiouAEIOU";
        while (left < right){
            while (left < right && !vowels.contains(String.valueOf(sc[left]))){
                left++;
            }
            while (right > left && !vowels.contains(String.valueOf(sc[right]))){
                right--;
            }
            if(left >= right){
                break;
            }
            char temp = sc[left];
            sc[left] = sc[right];
            sc[right] = temp;
            left++;
            right--;
        }
        return new String(sc);
    }
}
