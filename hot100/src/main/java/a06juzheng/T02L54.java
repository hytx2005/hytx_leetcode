package a06juzheng;

import java.util.ArrayList;
import java.util.List;

public class T02L54 {
    public List<Integer> t54(int[][] matrix){
        int m = matrix.length;;
        int n = matrix[0].length;
        int[] xd = {0,1,0,-1};
        int[] yd = {1,0,-1,0};
        int flag = 0;
        boolean[][] visited = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int num = m*n;
        int dx = 0;
        int dy = 0;
        while (count < num) {
            res.add(matrix[dx][dy]);
            visited[dx][dy] = true;
            count++;
            int nextDx = dx + xd[flag];
            int nextDy = dy + yd[flag];
            boolean out = nextDx < 0 || nextDx >= m || nextDy < 0 || nextDy >= n;
            if (out || visited[nextDx][nextDy]) {
                flag = (flag + 1) % 4;
            }
            dx += xd[flag];
            dy += yd[flag];
        }
        return res;
    }

    public List<Integer> t54T2(int[][] matrix){
        int illegal = 101;
        int m = matrix.length;;
        int n = matrix[0].length;
        int[] xd = {0,1,0,-1};
        int[] yd = {1,0,-1,0};
        int flag = 0;
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int num = m*n;
        int dx = 0;
        int dy = 0;
        while (count < num) {
            res.add(matrix[dx][dy]);
            matrix[dx][dy] = illegal;
            count++;
            int nextDx = dx + xd[flag];
            int nextDy = dy + yd[flag];
            boolean out = nextDx < 0 || nextDx >= m || nextDy < 0 || nextDy >= n;
            if (out || matrix[nextDx][nextDy] == illegal) {
                flag = (flag + 1) % 4;
            }
            dx += xd[flag];
            dy += yd[flag];
        }
        return res;
    }
}
