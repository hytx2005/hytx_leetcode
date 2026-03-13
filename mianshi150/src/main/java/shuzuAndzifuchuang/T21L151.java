package shuzuAndzifuchuang;

import java.util.ArrayList;
import java.util.List;

public class T21L151 {
    public String reverseWords1(String s) {
        // 去除前后空格和中间多余空格
        String legalS = legalWord(s);
        // 分割字符串
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < legalS.length(); i++) {
            if (legalS.charAt(i) == ' ') {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(legalS.charAt(i));
            }
        }
        list.add(sb.toString());
        // 构造返回结果
        StringBuilder res = new StringBuilder();
        res.append(list.removeLast());
        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(" ").append(list.get(i));
        }
        return res.toString();
    }

    // 使句子合法化，去除前后空格和中间多余空格
    public String legalWord(String s) {
        String res = s.trim();
        StringBuilder sb = new StringBuilder();
        sb.append(res.charAt(0));
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) == ' ' && res.charAt(i - 1) == ' ') {
                continue;
            } else {
                sb.append(res.charAt(i));
            }
        }
        return sb.toString();
    }
}
