package month202607.week3.day17;

public class L48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 1.对角线翻转
        for (int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2.水平翻转
        for(int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n/2 ; j++){
                int temp = matrix[i][n-1-j];
                matrix[i][n-1-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
