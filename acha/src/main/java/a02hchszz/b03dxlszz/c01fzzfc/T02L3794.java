package a02hchszz.b03dxlszz.c01fzzfc;

 class T02L3794 {
     /**
      * 给你一个字符串 s 和一个整数 k。
      * 反转 s 的前 k 个字符，并返回结果字符串。
      * 示例 1:
      * 输入: s = "abcd", k = 2
      * 输出: "bacd"
      * 解释:
      * 前 k = 2 个字符 "ab" 反转为 "ba"。最终得到的结果字符串为 "bacd"。
      * 示例 2:
      * 输入: s = "xyz", k = 3
      * 输出: "zyx"
      * 解释:
      * 前 k = 3 个字符 "xyz" 反转为 "zyx"。最终得到的结果字符串为 "zyx"。
      * @param s 字符串
      * @param k 整数
      * @return {@link String }
      */
     public String reversePrefix(String s, int k) {
        char[] sChar = s.toCharArray();
        int left = 0,right = k-1;
        while(left < right){
            char t = sChar[left];
            sChar[left] = sChar[right];
            sChar[right] = t;
            left++;
            --right;
        }
        return new String(sChar);
    }
}
