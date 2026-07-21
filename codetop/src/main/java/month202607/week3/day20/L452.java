package month202607.week3.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        List<int[]> temp = new ArrayList<>();
        int tBegin = points[0][0];
        int tEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] <= tEnd){
                tBegin = Math.max(points[i][0],tBegin);
                tEnd = Math.min(points[i][1],tEnd);
            }else {
                temp.add(new int[]{tBegin,tEnd});
                tBegin = points[i][0];
                tEnd = points[i][1];
            }
        }
        temp.add(new int[]{tBegin,tEnd});
        return temp.size();
    }
}
