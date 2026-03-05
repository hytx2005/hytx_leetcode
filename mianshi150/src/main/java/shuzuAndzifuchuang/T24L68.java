package shuzuAndzifuchuang;

import java.util.ArrayList;
import java.util.List;

public class T24L68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int temp = 0;
        for(int i = 0 ; i < n ;i++){
            list.add(words[i]);
            temp += words[i].length();
            int len = temp + list.size() - 1;
            System.out.println("拼接"+words[i]+"单词长度"+temp+"总长度"+len);
            if(len >= maxWidth){
                if(len > maxWidth){
                    list.remove(list.size() - 1);
                    temp -= words[i].length();
                }
                // 空格区间数量
                int num = list.size() - 1;
                if(num == 0){
                    sb.append(list.get(0));
                    sb.append(" ".repeat(Math.max(0, maxWidth - temp)));
                    res.add(sb.toString());
                }else {
                    // 空格长度
                    int spaceLen = (maxWidth-temp) / num;
                    // 余数
                    int yu = (maxWidth-temp) % num;
                    for (int j = 0; j < list.size(); j++) {
                        sb.append(list.get(j));
                        if(j != list.size() - 1){
                            sb.append(" ".repeat(Math.max(0, spaceLen)));
                            if(yu > 0){
                                sb.append(" ");
                                yu--;
                            }
                        }
                    }
                    res.add(sb.toString());

                }
                list = new ArrayList<>();
                sb = new StringBuilder();
                if(len > maxWidth){
                    list.add(words[i]);
                    temp = words[i].length();
                }else {
                    temp = 0;
                }
            }
        }
        // 最后处理
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size() - 1){
                sb.append(" ");
            }else {
                sb.append(" ".repeat(Math.max(0, maxWidth - temp - list.size() + 1)));
            }
        }
        if (!list.isEmpty()){
            res.add(sb.toString());
        }


        return res;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words2 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 16;
        List<String> res = fullJustify(words2, 20);
        for(String s : res){
            System.out.println(s);
        }
    }
}
