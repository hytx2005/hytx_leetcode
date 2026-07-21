package month202607.week3.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> temp = new ArrayList<>();
        int tBegin = intervals[0][0];
        int tEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= tEnd){
                tEnd = Math.max(tEnd,intervals[i][1]);
            }else {
                temp.add(new int[]{tBegin,tEnd});
                tBegin = intervals[i][0];
                tEnd = intervals[i][1];
            }
        }
        temp.add(new int[]{tBegin,tEnd});
        return temp.toArray(new int[temp.size()][2]);
    }
}
