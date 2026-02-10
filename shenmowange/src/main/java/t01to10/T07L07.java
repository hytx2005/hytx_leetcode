package t01to10;

/**
 * 整数反转 <a href="https://leetcode.cn/problems/reverse-integer/description/">...</a>
 * @author Dai
 * @date 2026/02/10
 */
class T07L07 {
    /**
     * 模拟 时间复杂度 O(n)
     * @param x
     * @return int
     */
    public static int reverse(int x) {
        int t = 0;
        int flag = x < 0 ? -1 : 1;
        int y = x;
        while(y != 0){
            int f = y % 10;
            y = y/10;
            if(flag == 1){
                if(t > Integer.MAX_VALUE/10 || (t == Integer.MAX_VALUE/10 && f > 7)){
                    return 0;
                }
            }else{
                if(t < Integer.MIN_VALUE/10 || (t == Integer.MIN_VALUE/10 && f < -8)){
                    return 0;
                }
            }
            t = t*10 + f;
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
