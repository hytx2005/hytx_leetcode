package year2025.month10;

/**
 * @author ASUS
 */
public class D251023L3461 {
    /*
    * 给你一个由数字组成的字符串 s 。重复执行以下操作，直到字符串恰好包含 两个 数字：
       从第一个数字开始，对于 s 中的每一对连续数字，计算这两个数字的和 模 10。
       用计算得到的新数字依次替换 s 的每一个字符，并保持原本的顺序。
       如果 s 最后剩下的两个数字 相同 ，返回 true 。否则，返回 false
    * */


    public boolean hasSameDigits(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        while (s.length() > 2){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length()-1; i++) {
                int a1 = s.charAt(i) - '0';
                int a2 = s.charAt(i+1) - '0';
                sb.append((a1 + a2) % 10);
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
