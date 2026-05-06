package a09tulun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T03L207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录入度的数组
        int[] inCount = new int[numCourses];
        // list.get(i) 里记录的是以 i 为起点的边的终点
        List<List<Integer>> adjBian = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adjBian.add(new ArrayList<>());
        }

        // 遍历数组记录入度 和边
        for(int i = 0 ; i < prerequisites.length ; i++){
            inCount[prerequisites[i][0]] ++;
            adjBian.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(inCount[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses --;
            List<Integer> ress = adjBian.get(pre);
            for(int t : ress){
                inCount[t]--;
                if(inCount[t] == 0){
                    queue.add(t);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0,1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
