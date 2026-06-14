package month202606.week2.day14;

public class L165 {
    class Solution {
        public int compareVersion(String version1, String version2) {
            int i = 0, j = 0;
            int len1 = version1.length(), len2 = version2.length();

            while (i < len1 || j < len2) {
                int val1 = 0, val2 = 0;

                // 解析 version1 的下一段
                while (i < len1 && version1.charAt(i) != '.') {
                    val1 = val1 * 10 + (version1.charAt(i) - '0');
                    i++;
                }
                i++; // 跳过点号

                // 解析 version2 的下一段
                while (j < len2 && version2.charAt(j) != '.') {
                    val2 = val2 * 10 + (version2.charAt(j) - '0');
                    j++;
                }
                j++; // 跳过点号

                if (val1 != val2) {
                    return val1 > val2 ? 1 : -1;
                }
            }
            return 0;
        }
    }
}
