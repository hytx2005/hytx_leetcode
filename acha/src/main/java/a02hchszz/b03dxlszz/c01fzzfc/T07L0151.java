package a02hchszz.b03dxlszz.c01fzzfc;

public class T07L0151 {
    /**
     * Leetcode 151. 反转字符串中的单词 (<a href="https://leetcode.cn/problems/reverse-words-in-a-string/">...</a>)
     * @param s
     * @return {@link String }
     */
    public String reverseWords(String s) {
        // 思路，从后往前遍历，利用stringbuilder拼接

        // 1.去除首尾空格
        s = s.trim();
        StringBuilder res = new StringBuilder();

        // 2.从后往前遍历
        int right = s.length() - 1,left = right;
        while (left >= 0){
            // 2.1 找到单词的开头
            while(left >= 0 && s.charAt(left) != ' '){
                left--;
            }
            // 2.2 拼接单词
            res.append(s, left+1, right+1).append(" ");
            // 2.3 找到下一个单词的结尾
            while(left >= 0 && s.charAt(left) == ' '){
                left--;
            }
            right = left;
        }
        return res.toString().trim();
    }


    /**
     * 空间复杂度O(1)的解法
     * @param s 字符串
     * @return {@link String }
     */
    public String reverseWordsO1(String s) {
        // 1.去除多余空格

        // 1.1 去除首尾空格
        s = s.trim();
        // 1.2 去除中间多余空格 --> 转为字符数组操作
        char[] chars = s.toCharArray();
        //  1.2.1 使用快慢指针去除多余空格
        int l = removeExtraSpaces(chars);
        return new String(chars,0,l);
    }

    public int removeExtraSpaces(char[] chars){
        int l = chars.length;
        int slow = 0,fast = 0;
        int res = 0;
        while (fast < l){
            if (chars[fast] != ' '){
                if (res != 0){
                    chars[slow++] = ' ';
                }
                // 移动
                while(fast < l && chars[fast] != ' '){
                    chars[slow++] = chars[fast++];
                    res++;
                }
            }
            fast++;
        }
        return res;
    }

}
