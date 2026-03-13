package year2025.month12;

/**
 * @author ASUS
 */
public class D30L0840 {
    /**
     * 1.穷举法
     * @param grid int[][]
     * @return int
     */
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length-3, n = grid[0].length-3;
        int res = 0;
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(grid[i+1][j+1] != 5){
                    continue;
                }else {
                    res += search(i,j,grid);
                }
            }
        }
        return res;
    }
    // 2 7 6
    // 1 5 9
    // 4 3 8
    public int search(int i, int j, int[][] grid) {
        int[] nums = new int[10];
        // 1.校验元素是否重复
        for(int x = i; x <= i+2; x++) {
            for(int y = j; y <= j+2; y++) {
                if(grid[x][y] > 9 || grid[x][y] < 1 || nums[grid[x][y]] > 0) {
                    return 0;
                }
                nums[grid[x][y]]++;
            }
        }
        // 2.校验行
        for(int x = i; x <= i+2; x++) {
            if(grid[x][j] + grid[x][j+1] + grid[x][j+2] != 15) {
                return 0;
            }
        }
        // 3.校验列
        for (int k = j; k <= j+2; k++) {
            if (grid[i][k] + grid[i+1][k] + grid[i+2][k] != 15) {
                return 0;
            }
        }
        // 4.校验对角线
        if(grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]!= 15 || grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j]!= 15) {
            return 0;
        }
        return 1;
    }
}
