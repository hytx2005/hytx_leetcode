package month202606.week3.day20;

public class L42 {
    class Solution {
        public int trap(int[] height) {
            int len = height.length;
            int left = 0, right = len - 1;
            ;
            int leftMax = height[0], rightMax = height[len - 1];
            int res = 0;
            while (left <= right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (leftMax <= rightMax) {
                    res += Math.max(leftMax - height[left], 0);
                    left++;
                } else {
                    res += Math.max(rightMax - height[right], 0);
                    right--;
                }
            }
            return res;
        }
    }
}
