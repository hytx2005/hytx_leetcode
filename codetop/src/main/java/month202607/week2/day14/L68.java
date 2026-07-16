package month202607.week2.day14;

import java.util.ArrayList;
import java.util.List;

public class L68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> resTemp = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        List<Integer> resTempSize = new ArrayList<>();
        int tempSize = 0;
        int wordSize = 0;
        for (String word : words) {
            if (tempSize + word.length() < maxWidth) {
                tempSize += word.length() + 1;
                wordSize += word.length();
                temp.add(word);
            } else if (tempSize + word.length() == maxWidth) {
                wordSize += word.length();
                temp.add(word);
                resTemp.add(temp);
                resTempSize.add(wordSize);
                wordSize = 0;
                tempSize = 0;
                temp = new ArrayList<>();
            } else {
                resTemp.add(temp);
                resTempSize.add(wordSize);
                wordSize = word.length() + 1;
                tempSize = word.length();
                temp = new ArrayList<>();
                temp.add(word);
            }
        }
        if (!temp.isEmpty()) {
            resTemp.add(temp);
            resTempSize.add(wordSize);
        }
        // 构造最后的结果
        int size = resTemp.size();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            List<String> strings = resTemp.get(i);
            Integer sSize = resTempSize.get(i);
            StringBuilder sb = new StringBuilder();
            int emptySize = maxWidth - sSize;
            int wordCount = strings.size();

            if (wordCount == 1) {
                // 只有一个单词，直接补空格
                sb.append(strings.get(0));
                sb.append(" ".repeat(emptySize));
            } else {
                // 多个单词，均匀分配空格
                int gaps = wordCount - 1;
                int baseSpaces = emptySize / gaps;
                int extraSpaces = emptySize % gaps;

                sb.append(strings.get(0));
                for (int j = 1; j < wordCount; j++) {
                    // 前 extraSpaces 个空隙多分配一个空格
                    int spaces = baseSpaces + (j <= extraSpaces ? 1 : 0);
                    sb.append(" ".repeat(spaces));
                    sb.append(strings.get(j));
                }
            }
            res.add(sb.toString());
        }
        // 特殊处理最后一行
        List<String> last = resTemp.get(resTemp.size() - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(last.getFirst());
        int len = last.getFirst().length();
        for (int k = 1; k < last.size(); k++) {
            sb.append(" ").append(last.get(k));
            len += 1 + last.get(k).length();
        }
        sb.append(" ".repeat(maxWidth - len));
        res.add(sb.toString());
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int max = 16;
        System.out.println(fullJustify(words, max));
    }
}
