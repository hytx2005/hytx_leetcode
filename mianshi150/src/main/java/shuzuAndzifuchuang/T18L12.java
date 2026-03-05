package shuzuAndzifuchuang;

public class T18L12 {

    // Use arrays ordered from largest to smallest. Avoid mutation of immutable lists.
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] VALUES =      {1000, 900, 500, 400, 100,  90,   50,  40,   10,   9,    5,    4,    1};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < VALUES.length && num > 0; i++) {
            while (num >= VALUES[i]) {
                sb.append(SYMBOLS[i]);
                num -= VALUES[i];
            }
        }
        return sb.toString();
    }
}
