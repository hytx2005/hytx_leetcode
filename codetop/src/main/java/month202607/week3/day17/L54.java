package month202607.week3.day17;

import javax.imageio.stream.ImageOutputStream;
import java.util.ArrayList;
import java.util.List;

public class L54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int x = 0 , y = 0 ;
        int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
        int move = 0;
        boolean[][] visit = new boolean[m][n];
        while (count < m * n){
            res.add(matrix[x][y]);
            visit[x][y] = true;

            int newX = x + moves[move][0];
            int newY = y + moves[move][1];
            if(newX < 0 || newX >= m || newY < 0 || newY >= n){
                move = (move+1)%4;
            }else if(visit[newX][newY]){
                move = (move+1)%4;
            }
            count++;
        }
        return res;
    }
}
