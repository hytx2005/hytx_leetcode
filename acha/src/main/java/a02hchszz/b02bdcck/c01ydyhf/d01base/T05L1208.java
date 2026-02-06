package a02hchszz.b02bdcck.c01ydyhf.d01base;

public class T05L1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int res = 0;
        int left = 0;
        int tmp = 0;
        int l = sChar.length;
        for (int right = 0; right < l; right++) {
            // 入
            tmp += Math.abs(sChar[right] - tChar[right]);

            // 出
            while (tmp > maxCost) {
                tmp -= Math.abs(sChar[left] - tChar[left]);
                left++;
            }
            // 更新
            res =Math.max(res,right-left+1);
        }
        return res;
    }
}
