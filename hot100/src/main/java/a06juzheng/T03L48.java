package a06juzheng;

public class T03L48 {
    public void rotate(int[][] matrix) {
        step1(matrix);
        step2(matrix);
    }

    public void step1(int[][] matrix){
        // 沿对角线翻转
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void step2(int[][] matrix){
        // 沿竖直中线翻转
        int m = matrix.length;
        // j+t = m-1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - 1 - j];
                matrix[i][m - 1 - j] = temp;
            }
        }
    }
}
