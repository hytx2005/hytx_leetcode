package t01to10;

/**
 * 字符串转换整数 <a href="https://leetcode.cn/problems/string-to-integer-atoi/description/">...</a>
 */
class T08L8 {
    /**
     * 模拟 时间复杂度 O(n)
     * @param s 字符串
     * @return int
     */
    public int myAtoi(String s) {
        char[] sc = s.toCharArray();
        int i = 0;
        // 记录正负
        int sign = 1;
        //
        while(i < sc.length && sc[i] == ' '){
            i++;
        }
        // 记录正负
        if (sc[i] == '-'){
            sign = -1;
            i++;
        } else if (sc[i] == '+') {
            i++;
        }
        // 跳过前置0
        while(i < sc.length && sc[i] == '0'){
            i++;
        }
        // 出结果
        int res = 0;
        for (; i < sc.length ; i++){
            char c = sc[i];
            if(sc[i] < '0' || sc[i] > '9'){
                return res;
            }else {
                int t = c - '0';
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && t > 7)){
                    return Integer.MAX_VALUE;
                } else if (res < Integer.MIN_VALUE/10 || (res== Integer.MIN_VALUE/10 && t > 8)) {
                    return Integer.MIN_VALUE;
                }else {
                    res = res*10 + sign*t;
                }
            }
        }
        return res;
    }
}
