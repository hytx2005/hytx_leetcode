package a02hchszz.b03dxlszz.c01fzzfc;

 class T03L2000 {
     /**
      * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
      * 例如，如果 word = "abcdefd" 且 ch = 'd' ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
      * @param word 单词
      * @param ch 字符
      * @return {@link String }
      */
     public String reversePrefix(String word, char ch) {
        int right = word.indexOf(ch);
        char[] wChar = word.toCharArray();
        int left = 0;
        while(left < right){
            char t = wChar[left];
            wChar[left] = wChar[right];
            wChar[right] = t;
            left++;
            right--;
        }
        return new String(wChar);
    }
}
