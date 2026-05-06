package year2026.month04;

public class D04L2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0;
        int row1 = startPos[0],col1 = startPos[1];
        int row2 = homePos[0],col2 = homePos[1];
        if(row1 < row2){
            while(row1 < row2){
                res += rowCosts[row1+1];
                row1++;
            }
        }else{
            while(row1 > row2){
                res += rowCosts[row1-1];
                row1--;
            }
        }

        if(col1 < col2){
            while(col1 < col2){
                res += colCosts[col1+1];
                col1++;
            }
        }else{
            while(col1 > col2){
                res += colCosts[col1-1];
                col1--;
            }
        }
        return res;
    }
}
