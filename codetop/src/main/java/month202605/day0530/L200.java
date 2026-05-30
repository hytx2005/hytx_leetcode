package month202605.day0530;

public class L200 {
    class Solution {
        public int[][] moves = {{-1,0},{0,1},{1,0},{0,-1}};
        public int numIslands(char[][] grid) {
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == '1'){
                        fire(grid,i,j);
                        count++;
                    }
                }
            }
            return count;
        }

        public void fire(char[][] grid,int i ,int j){
            int m = grid.length;
            int n = grid[0].length;
            for (int[] move : moves){
                int newI = i + move[0];

                int newJ = j + move[1];
                boolean fire = newI >= 0 && newI < m && newJ >= 0 && newJ < n;
                if(fire && grid[newI][newJ] == '1'){
                    grid[newI][newJ] = '0';
                    fire(grid,newI,newJ);
                }
            }
        }
    }
}
