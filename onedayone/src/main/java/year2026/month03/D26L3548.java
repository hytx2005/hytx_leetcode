package year2026.month03;

import java.util.HashSet;
import java.util.Set;

public class D26L3548 {
    public static boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        for(int[] nums : grid){
            for(int num : nums){
                sum += num;
            }
        }
        int m = grid.length;
        int n = grid[0].length;
        // 1.从上到下，有缺口则缺口在上
        Set<Long> set = new HashSet<>();
        long temp = 0;
        // 1.1 第一行特判
        for(int num : grid[0]){
            temp += num;
            set.add((long) num);
        }
        long first = temp;
        // 1.1.1 直接满足
        if(temp == sum-temp){
            return true;
        }
        // 1.1.2 可去头去尾
        else if(m > 1 && n > 1 && temp > sum-temp  && (grid[0][0] == 2*temp-sum || grid[0][n-1] == 2*temp-sum)){
            return true;
        }
        // 1.2 第二行开始，可以出现缺口
        for(int i = 1 ; i < m ; i++){
            long thisRowSum = 0;
            for(int j = 0 ; j < n ; j++){
                temp += grid[i][j];
                thisRowSum += grid[i][j];
                set.add((long) grid[i][j]);
            }
            // 1.2.1直接满足，无需缺口
            if(temp == sum - temp){
                return true;
            }
            // 1.2.2 可有缺口(列不能是单列，否则缺口无法去掉)
            else if(n > 1 && temp > (sum-temp) && set.contains(2*temp-sum)){
                return true;
            }
            // 1.2.3 单列从上往下，可去掉首行
            else if(n == 1 && temp - first == sum - temp){
                return true;
            }
            // 1.2.4 单列从上往下，可去掉当前行
            else if(n == 1 && temp - thisRowSum == sum - temp){
                return true;
            }
        }

        // 2.从下到上，有缺口则缺口在下
         set.clear();
         temp = 0;
        // 2.1 最后一行特判
        for(int num : grid[m-1]){
            temp += num;
            set.add((long) num);
        }
        first = temp;
        // 2.1.1 直接满足
        if(temp == sum-temp){
            return true;
        }
        // 2.1.2 可去头去尾
        else if(m > 1 && n > 1 && temp > sum-temp  && (grid[m-1][0] == 2*temp-sum || grid[m-1][n-1] == 2*temp-sum)){
            return true;
        }
        // 2.2 倒数第二行开始，可以出现缺口
        for(int i = m-2 ; i >= 0 ; i--){
            for(int j = 0 ; j < n ; j++){
                temp += grid[i][j];
                set.add((long) grid[i][j]);
            }
            // 2.2.1直接满足，无需缺口
            if(temp == sum - temp){
                return true;
            }
            // 2.2.2 有缺口(列不能是单列，否则缺口无法去掉)
            else if(n > 1 && temp > (sum-temp) && set.contains(2*temp-sum)){
                return true;
            }
            // 2.2.3 单列从下往上，可去掉尾行
            else if(n == 1 && temp - first == sum - temp){
                return true;
            }
        }
        // 3.从左往右，有缺口则缺口在左
        set.clear();
        temp = 0;
        // 3.1 第一列特判
        for(int i = 0 ; i < m ; i++){
            temp += grid[i][0];
            set.add((long) grid[i][0]);
        }
        first = temp;
        // 3.1.1 直接满足
        if(temp == sum-temp){
            return true;
        }
        // 3.1.2 可去头去尾
        else if(m > 1 && n > 1 && temp > sum-temp  && (grid[0][0] == 2*temp-sum || grid[m-1][0] == 2*temp-sum)){
            return true;
        }
        // 3.2 第二列开始，可以出现缺口
        for(int j = 1 ; j < n ; j++){
            long thisColSum = 0;
            for(int i = 0 ; i < m ; i++){
                temp += grid[i][j];
                thisColSum += grid[i][j];
                set.add((long) grid[i][j]);
            }
            // 3.2.1直接满足，无需缺口
            if(temp == sum - temp){
                return true;
            }
            // 3.2.2 可有缺口(行不能是单行，否则缺口无法去掉)
            else if(m > 1 && temp > (sum-temp) && set.contains(2*temp-sum)){
                return true;
            }
            // 3.2.3 单行从左往右，可去掉首列
            else if(m == 1 && temp - first == sum - temp){
                return true;
            }
            // 3.2.4 单行从左往右，可去掉当前列
            else if(m == 1 && temp - thisColSum == sum - temp){
                return true;
            }
        }
        // 4.从右往左，有缺口则缺口在右
        set.clear();
        temp = 0;
        // 4.1 最后一列特判
        for(int i = 0 ; i < m ; i++){
            temp += grid[i][n-1];
            set.add((long) grid[i][n-1]);
        }
        first = temp;
        // 4.1.1 直接满足
        if(temp == sum-temp){
            return true;
        }
        // 4.1.2 可去头去尾
        else if(m > 1 && n > 1 && temp > sum-temp  && (grid[0][n-1] == 2*temp-sum || grid[m-1][n-1] == 2*temp-sum)){
            return true;
        }
        // 4.2 倒数第二列开始，可以出现缺口
        for(int j = n-2 ; j >= 0 ; j--){
            for(int i = 0 ; i < m ; i++){
                temp += grid[i][j];
                set.add((long) grid[i][j]);
            }
            // 4.2.1直接满足，无需缺口
            if(temp == sum - temp){
                return true;
            }
            // 4.2.2 可有缺口(行不能是单行，否则缺口无法去掉)
            else if(m > 1 && temp > (sum-temp) && set.contains(2*temp-sum)){
                return true;
            }
            // 4.2.3 单行从右往左，可去掉尾列
            else if(m == 1 && temp - first == sum - temp){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{10,5,4,5}};
        System.out.println(canPartitionGrid(grid));
    }
}
