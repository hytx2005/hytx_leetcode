package shuzuAndzifuchuang;

import java.util.ArrayList;
import java.util.List;

public class T22L6 {
    /**
     * 模拟改进 - 使用集合模拟数组
     * @param s
     * @param numRows
     * @return {@link String }
     */
    public String convert1(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        char[] charArray = s.toCharArray();
        int flag = 1;
        int k = 0;
        for (char c : charArray) {
            list.get(k).append(c);
            k += flag;
            if (k == 0 || k == numRows - 1) {
                flag = -flag;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }


    public static String convert2(String s,int numRows){
        if (numRows == 1){
            return s;
        }
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int t = 2 * numRows - 2;
        // 记录当前已添加的字符数量
        int count = 0;
        for (int i = 0; i < numRows; i++) {

            // 首行和末行
            if(i==0 || i==numRows-1){
                int j = i;
                while (j < n){
                    res.append(s.charAt(j));
                    j += t;
                    count++;
                }
            }
            // 中间行
            else {
                int k = 1;
                res.append(s.charAt(i));
                count++;
                int next = k*t - i;
                do{
                    if(next < n){
                        res.append(s.charAt(next));
                        count++;
                    }
                    if(k*t +i < n){
                        res.append(s.charAt(k*t + i));
                        count++;
                    }
                    k++;
                    next = k*t - i;
                }while (next < n);
            }
            if (count == n){
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert2(s,numRows));
    }
}
