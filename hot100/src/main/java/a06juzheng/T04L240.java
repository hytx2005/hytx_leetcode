package a06juzheng;

public class T04L240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[m-1][n-1];
        if(target < min || target > max){
            return false;
        }
        for(int j = 0 ; j <  n; j++){
            for(int i = 0 ; i < m ; i++){
                int t = matrix[i][j];
                if(target < t){
                    break;
                }else if(target == t){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0,y = n-1;
        while (x < m && y >=0){
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}
