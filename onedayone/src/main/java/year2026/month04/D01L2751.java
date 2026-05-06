package year2026.month04;

import java.util.*;

public class D01L2751 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        char[] dc = directions.toCharArray();
        int n = positions.length;
        Integer[] indexs = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexs[i] = i;
        }
        Arrays.sort(indexs,(i,j)->positions[i] - positions[j]);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : indexs) {
            if(stack.isEmpty() || dc[i] == 'R'){
                stack.push(i);
            }
            else if(dc[i] == 'L' && dc[stack.peek()] == 'L'){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && dc[stack.peek()] == 'R'){
                    int preIndex = stack.peek();
                    if(healths[preIndex] == healths[i]){
                        healths[preIndex] = 0;
                        healths[i] = 0;
                        stack.pop();
                        break;
                    }else if(healths[preIndex] > healths[i]){
                        healths[preIndex]--;
                        healths[i] = 0;
                        break;
                    }else {
                        healths[i]--;
                        healths[preIndex] = 0;
                        stack.pop();
                    }
                }
                if(healths[i] > 0){
                    stack.push(i);
                }

            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int health : healths) {
            if(health > 0){
                ans.add(health);
            }
        }
        return ans;
    }
}
