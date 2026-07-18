package month202607.week3.day17;

public class L73 {
    public void setZeroes(int[][] matrix) {
        boolean zeroOfRow0 = false;
        boolean zeroOfCol0 = false;

        int m = matrix.length;
        int n = matrix[0].length;

        // 第0行
        for (int j = 0; j < n; j++) {
            if(matrix[0][j] == 0){
                zeroOfRow0 = true;
                break;
            }
        }

        // 第0列
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                zeroOfCol0 = true;
                break;
            }
        }

        // 其他
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 处理结果

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(zeroOfRow0){
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if(zeroOfCol0){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
