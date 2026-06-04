package month202606.day04;

import java.util.ArrayList;
import java.util.List;

public class L54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            // 移动枚举
            int[][] moves = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            // 记录是否访问标志
            boolean[][] visit = new boolean[m][n];
            // 移动方向
            int move = 0;
            List<Integer> res = new ArrayList<>();
            // 计数
            int count = 0;
            // 当前位置
            int x = 0;
            int y = 0;
            while (count < m * n){
                // 结果
                res.add(matrix[x][y]);
                // 标志访问过
                visit[x][y] = true;

                // 下一个位置
                int newX = x + moves[move][0];
                int newY = y + moves[move][1];

                // 1.下一个位置越界
                if(newX < 0 || newX >= m || newY < 0 || newY >= n){
                    move = (move+1) % 4;
                }
                // 2.下一个位置访问过
                else if(visit[newX][newY]){
                    move = (move+1) % 4;
                }

                // 移动
                x += moves[move][0];
                y +=  moves[move][1];

                count++;
            }
            return res;
        }
    }
}
