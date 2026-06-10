package month202606.week2.day10;

import java.util.ArrayList;
import java.util.List;

public class L93 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            allSort(s.toCharArray(), 0, res, new ArrayList<>());
            return res;
        }

        public void allSort(char[] sc, int index, List<String> res, List<String> temp) {
            if (index == sc.length) {
                if(temp.size() == 4){
                    res.add(String.join(".", temp));
                }
            } else {
                for (int i = index; i < sc.length && i < index + 3; i++) {
                    String sub = new String(sc, index, i - index + 1);
                    if (isValid(sub)) {
                        temp.add(sub);
                        allSort(sc, i + 1, res, temp);
                        temp.removeLast();
                    }
                }
            }
        }

        public boolean isValid(String s) {
            if (s.length() > 3 || s.isEmpty()) {
                return false;
            }
            if (s.charAt(0) == '0' && s.length() > 1) {
                return false;
            }
            int num = Integer.parseInt(s);
            return num >= 0 && num <= 255;
        }
    }
}
