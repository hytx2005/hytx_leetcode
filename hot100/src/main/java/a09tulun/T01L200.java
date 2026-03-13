package a09tulun;

public class T01L200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    fire(grid, i, j);
                }
            }
        }
        return count;
    }
    public void fire(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        fire(grid, i - 1, j);
        fire(grid, i + 1, j);
        fire(grid, i, j - 1);
        fire(grid, i, j + 1);
    }
}
