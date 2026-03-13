package a06juzheng;

public class T01L73 {
    public void setZeroes(int[][] matrix) {
        // 标记第0行和第0列是否有0
        boolean flagOfRow0 = false;
        boolean flagOfCol0 = false;
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录第0列
        for(int i = 0 ; i < m ; i++){
            if(matrix[i][0] == 0){
                flagOfCol0 = true;
                break;
            }
        }
        // 记录第0行
        for(int j = 0 ; j < n ; j++){
            if(matrix[0][j] == 0){
                flagOfRow0 = true;
                break;
            }
        }
        // 记录其他行列
        for(int i = 1 ; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 结果
        for(int i = 1 ; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第0行
        if(flagOfRow0){
            for(int j = 0 ; j < n ; j++){
                matrix[0][j] = 0;
            }
        }
        // 处理第0列
        if(flagOfCol0){
            for(int i = 0 ; i < m ; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
