package a02hchszz.b01dcck.c01base;

/**
 * @author ASUS
 */
public class L1456 {
    public int maxVowels(String s, int k) {
        int max = 0;
        int temp = 0;
        char[] sc = s.toCharArray();
        for (int i = 0; i < k-1; i++) {
            temp += isYuan(sc[i]);
        }
        // 1.开始计算
        for (int i = k-1; i < sc.length; i++) {
            temp += isYuan(sc[i]);
            max = Math.max(max, temp);
            temp -= isYuan(sc[i - k + 1]);
        }
        return max;
    }

    public int isYuan(char a){
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ? 1 : 0;
    }
}
