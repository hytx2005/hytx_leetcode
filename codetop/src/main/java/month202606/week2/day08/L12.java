package month202606.week2.day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L12 {
    class Solution {
        Map<Integer, Integer> map;

        public List<String> letterCombinations(String digits) {
            map = Map.of(
                    1, 0,
                    2, 3,
                    3, 6,
                    4, 9,
                    5, 12,
                    6, 15,
                    7, 19,
                    8, 22,
                    9, 26
            );
            List<String> res = new ArrayList<>();
            StringBuilder temp = new StringBuilder();
            char[] sc = digits.toCharArray();
            allSort(res, temp, sc, 0, sc.length);
            return null;
        }

        public void allSort(List<String> res, StringBuilder temp, char[] sc, int index, int end) {
            if (index == end) {
                res.add(temp.toString());
                return;
            }
            int begin = map.get(sc[index] - '0' - 1);
            int endIndex = map.get(sc[index] - '0');
            for (int i = begin; i < endIndex; i++) {
                temp.append((char) ('a' + i));
                allSort(res, temp, sc, index + 1, end);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
