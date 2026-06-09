package month202606.week1.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int tBegin = intervals[0][0];
        int tEnd = intervals[0][1];
        int m = intervals.length;
        for (int i = 1; i < m; i++) {
            if(intervals[i][0] <= tEnd){
                tBegin = Math.min(tBegin,intervals[i][0]);
                tEnd = Math.max(tEnd,intervals[i][1]);
            }else {
                res.add(new int[]{tBegin,tEnd});
                tBegin = intervals[i][0];
                tEnd = intervals[i][1];
            }
        }
        res.add(new int[]{tBegin,tEnd});
        return  res.toArray(new int[res.size()][]);
    }
}
