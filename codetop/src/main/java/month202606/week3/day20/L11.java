package month202606.week3.day20;

public class L11 {
    class Solution {
        public int maxArea(int[] height) {
            int res = 0;
            int left = 0,right = height.length - 1;
            while(left < right){
                res = Math.max(res,Math.min(height[left],height[right]) * (right-left));
                if(height[left] < height[right]){
                    left ++;
                }else{
                    right--;
                }
            }
            return res;
        }
    }
}
