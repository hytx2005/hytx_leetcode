package month202607.week3.day16;

import java.util.*;

public class L30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int windowLen = wordLen * words.length;
        Map<String, Integer> targetCnt = new HashMap<>();
        for (String word : words) {
            targetCnt.put(word, targetCnt.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();

        for (int start = 0; start < wordLen; start++) {
            Map<String, Integer> cnt = new HashMap<>();
            int matched = 0;
            // 当前窗口中，计数恰好等于目标值的单词种类数

            for (int right = start + wordLen; right <= s.length(); right += wordLen) {
                // ===== 入窗口（先加入） =====
                String inWord = s.substring(right - wordLen, right);
                int oldCount = cnt.getOrDefault(inWord, 0);
                int targetCount = targetCnt.getOrDefault(inWord, 0);

                // 只有目标中存在的单词才影响 matched
                if (targetCount > 0) {
                    // 如果旧计数等于目标，则它之前是匹配的，加入后将不匹配
                    if (oldCount == targetCount) {
                        matched--;
                    }
                    // 如果新计数等于目标，则它之前不匹配，现在匹配
                    if (oldCount + 1 == targetCount) {
                        matched++;
                    }
                }
                cnt.put(inWord, oldCount + 1);

                int left = right - windowLen;
                if (left < 0) {
                    continue;
                }

                // ===== 检查结果 =====
                if (matched == targetCnt.size()) {
                    res.add(left);
                }

                // ===== 出窗口（先调整） =====
                String outWord = s.substring(left, left + wordLen);
                int oldOut = cnt.get(outWord);
                int targetOut = targetCnt.getOrDefault(outWord, 0);

                if (targetOut > 0) {
                    // 如果旧计数等于目标，移除前匹配，移除后不匹配
                    if (oldOut == targetOut) {
                        matched--;
                    }
                    // 如果新计数等于目标，移除前不匹配，移除后匹配
                    if (oldOut - 1 == targetOut) {
                        matched++;
                    }
                }
                cnt.put(outWord, oldOut - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
}
