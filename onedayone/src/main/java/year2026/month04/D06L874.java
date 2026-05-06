package year2026.month04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class D06L874 {
    static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    public static int robotSim(int[] commands, int[][] obstacles) {
        int moveIndex = 0;
        HashSet<List<Integer>> set = new HashSet<>();
        for(int[] obstacle : obstacles){
            set.add(List.of(obstacle[0],obstacle[1]));
        }
        int m = commands.length;
        int[] res = new int[2];
        int max = 0;
        for(int i = 0 ; i < m ; i++){
            int val = commands[i];
            if(val > 0){
                while(val > 0){
                    if(set.contains(List.of(res[0]+move[moveIndex][0],res[1]+move[moveIndex][1]))){
                        break;
                    }
                    res[0] += move[moveIndex][0];
                    res[1] += move[moveIndex][1];
                    max = Math.max(max,res[0]*res[0] + res[1] * res[1]);
                    val--;
                }
            }else if(val == -1){
                moveIndex = (moveIndex+1)%4;
            }else{
                moveIndex = (moveIndex+4-1)%4;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        System.out.println(robotSim(commands,obstacles));
    }
}
