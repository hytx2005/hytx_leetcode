package month202606.week1.day06;

public class L42 {
    class Solution {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int leftMax = height[0];
            int rightMax = height[right];
            int res = 0;
            while (left <= right){
                leftMax = Math.max(leftMax,height[left]);
                rightMax = Math.max(rightMax,height[right]);
                if(leftMax < rightMax){
                    res += leftMax - height[left];
                    left++;
                }else {
                    res += rightMax - height[right];
                    right--;
                }
            }
            return res;
        }
    }
}
