package a02hchszz.b03dxlszz.c01fzzfc;

/**
 * Leetcode917 仅仅反转字母<a href="https://leetcode.cn/problems/reverse-only-letters/">...</a>
 * @author Dai
 * @date 2026/02/03
 */
public class T09L0917 {

    public String reverseOnlyLetters(String s) {
        char[] sc = s.toCharArray();
        int left = 0, right = sc.length - 1;
        while (left < right){
            while (left < right && !Character.isLetter(sc[left])){
                left++;
            }
            while (right > left && !Character.isLetter(sc[right])){
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
