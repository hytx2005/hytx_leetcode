package a02hchszz.b03dxlszz.c01fzzfc;

class T05L0541 {

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * 示例 1：
     * 输入：s = "abcdefg", k = 2
     * 输出："bacdfeg"
     * @param s 字符串
     * @param k 整数
     * @return {@link String }
     */
    public String reverseStr(String s, int k) {
        char[] schar = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i+=2*k){
            reverse(schar,i,Math.min(i+k,s.length()) - 1);
        }
        return new String(schar);
    }

    public void reverse(char[] sChar,int left,int right){
        while(left < right){
            char t = sChar[left];
            sChar[left] = sChar[right];
            sChar[right] = t;
            left++;
            right--;
        }
    }
}
