package a02hchszz.b01dcck.c02fly;

import java.util.Arrays;

/**
 * @author ASUS
 */
public class T03L3439 {
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int length = startTime.length;
        int[] time = new int[length + 1];
        time[0] = startTime[0];
        time[length] = eventTime - endTime[length - 1];
        for (int i = 1; i < length; i++) {
            time[i] = startTime[i] - endTime[i - 1];
        }
        System.out.println(Arrays.toString(time));

        k+=1;
        int res = 0;
        int temp = 0;
        for (int i = 0; i < time.length; i++) {
            // 入
            temp += time[i];

            // 更新
            int left = i - k + 1;
            if (left < 0){
                continue;
            }
            res = Math.max(res, temp);

            // 出
            temp -= time[left];
        }
        return res;
    }
    public static void main(String[] args) {
        int eventTime = 5;
        int k = 1;
        int[] startTime = {1, 3};
        int[] endTime = {2, 5};
        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }
}
