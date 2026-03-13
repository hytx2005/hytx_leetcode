package a09tulun;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class T02L994 {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> deque = new ArrayDeque<>();
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    count++;
                }else if(grid[i][j] == 2){
                    deque.offer(new int[]{i,j});
                }
            }
        }
        int time = 0;
        while(!deque.isEmpty() && count > 0){
            int size = deque.size();
            while(size > 0){
                int[] num = deque.poll();
                int i = num[0];
                int j = num[1];
                for(int k = 0 ; k < 4 ; k ++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x>=0 && x < m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y] = 2;
                        deque.offer(new int[]{x,y});
                        count--;
                    }
                }
                size--;
            }
            time ++;
            for (int[] ints : grid) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println("-----------");
        }
        return count == 0 ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,1},{1,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
