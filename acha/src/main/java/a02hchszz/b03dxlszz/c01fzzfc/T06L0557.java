package a02hchszz.b03dxlszz.c01fzzfc;

import java.util.Arrays;

public class T06L0557 {

    /**
     * 557. 反转字符串中的单词 III (<a href="https://leetcode.cn/problems/reverse-words-in-a-string-iii/description/">...</a>)
     * @param s
     * @return {@link String }
     */
    public String reverseWords(String s) {
        char[] t = s.toCharArray();
        int left = 0;
        for(int right = left+1;right < s.length(); right++){
            // 遇到空格则反转
            if(t[right] == ' '){
                reverse(t,left,right-1);
                left = right+1;
            }
        }
        // 最后一个单词没有空格，反转最后一个单词
        reverse(t,left,s.length()-1);
        return new String(t);
    }

    public void reverse(char[] s,int left,int right){
        while(left < right){
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(Arrays.toString(s.toCharArray()));
    }
}
