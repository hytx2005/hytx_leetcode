package a02hchszz.b03dxlszz.c02xxszz;

/**
 * L1750 <a href="https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/description/">...</a>
 * @author Dai
 * &#064;date  2026/02/04
 */
class T03L1750 {
    /**
     * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
     * <p>
     * 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
     * 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
     * 前缀和后缀在字符串中任意位置都不能有交集。
     * 前缀和后缀包含的所有字符都要相同。
     * 同时删除前缀和后缀。
     * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
     * @return int
     */
    public int minimumLength(String s) {
        char[] sc = s.toCharArray();
        int l = 0,r = sc.length - 1;
        while(l < r && sc[l] == sc[r]){
            while(l < r-1 && sc[l+1] == sc[l]){
                l++;
            }
            while(r-1 > l && sc[r-1] == sc[l]){
                r--;
            }
            l++;
            r--;
        }
        return r-l+1;
    }
}
