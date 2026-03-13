package t01to10;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换 <a href="https://leetcode.cn/problems/zigzag-conversion/description/">...</a>
 */
class T06L6 {
    /**
     * 模拟 时间复杂度 O(n^2)
     * @param s 字符串
     * @param numRows 行数
     * @return {@link String }
     */
    public static String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 模拟
        char[][] tmp =  new char[numRows][s.length()];

        // 模拟放入
        int[] dpx = new int[]{1,-1};
        int[] dpy = new int[]{0,1};
        int flag = 0;// flag=0代表向下，=1表示斜向上
        char[] sc = s.toCharArray();
        int x = 0,y=0;
        for(char c : sc){
            tmp[x][y] = c;
            if(x == 0){
                flag = 0;
            }else if(x == numRows-1){
                flag = 1;
            }
            x += dpx[flag];
            y += dpy[flag];
        }

        // 拼接结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if(tmp[i][j] != 0){
                    sb.append(tmp[i][j]);
                }
            }
        }
        return sb.toString();
    }


    /**
     * 模拟-优化（使用List替代数组） 时间复杂度 O(n)
     * @param s 字符串
     * @param numRows 行数
     * @return {@link String }
     */
    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 模拟
        List<StringBuilder> tmp = new ArrayList<>();
        for(int i = 0; i< numRows ;i++){
            tmp.add(new StringBuilder());
        }

        // 模拟放入
        int flag = -1;// flag=1代表向下，-1表示斜向上
        char[] sc = s.toCharArray();
        int x = 0;
        for(char c : sc){
            if(x == 0){
                flag = 1;
            }else if(x == numRows-1){
                flag = -1;
            }
            tmp.get(x).append(c);
            x += flag;
        }



        // 拼接结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(tmp.get(i));
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        System.out.println(convert1("AB", 1));
    }
}
