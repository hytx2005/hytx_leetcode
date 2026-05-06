package year2026.month03;

public class D25L3546 {
    /**
     * 最朴素做法：分别计算水平分界线和竖直分界线的和，看看能不能等于总和的一半
     * @param grid
     * @return boolean
     */
    public boolean canPartitionGrid1(int[][] grid) {
        long sum = 0;
        for (int[] row : grid) {
            for (int num : row) {
                sum += num;
            }
        }
        if(sum % 2 != 0) {
            return false;
        }

        // 看看水平分界线行不行
        long target = sum / 2;
        long s = 0;
        for (int i = 0; i < grid.length - 1; i++){
            for (int num : grid[i]) {
                s += num;
            }
            if(s == target) {
                return true;
            }else if(s > target) {
                break;
            }
        }
        // 看看竖直分界线行不行
        s = 0;
        for (int j = 0; j < grid[0].length - 1; j++) {
            for (int i = 0; i < grid.length; i++) {
                s += grid[i][j];
            }
            if(s == target) {
                return true;
            }else if(s > target) {
                break;
            }
        }
        return false;
    }

    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        for (int[] row : grid) {
            for (int num : row) {
                sum += num;
            }
        }
        if(sum % 2 != 0) {
            return false;
        }

        // 计算前缀和
        long target = sum / 2;
        // prefixSum[i][j]表示以(i,j)为右下角的矩形的和
        long[][] prefixSum = new long[grid.length+1][grid[0].length+1];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0 ; j < grid[0].length; j++){
                prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + grid[i][j];
            }
        }
        // 判断水平分界线
        for (int i = 1; i < prefixSum.length; i++){
            if(prefixSum[i][prefixSum[0].length - 1] == target) {
                return true;
            }
        }
        // 判断竖直分界线
        for (int j = 1; j < prefixSum[0].length; j++) {
            if(prefixSum[prefixSum.length - 1][j] == target) {
                return true;
            }
        }
        return false;
    }
}
