package a05shuzhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T02L56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(b1,b2)->b1[0]-b2[0]);
        List<int[]> list = new ArrayList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int tBegin = intervals[i][0];
            int tEnd = intervals[i][1];
            if(tBegin <= end){
                end = Math.max(end,tEnd);
                begin = Math.min(begin,tBegin);
            }else {
                list.add(new int[]{begin,end});
                begin = tBegin;
                end = tEnd;
            }
        }
        list.add(new int[]{begin,end});
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
