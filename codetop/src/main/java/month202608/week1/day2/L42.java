package month202608.week1.day2;

public class L42 {
    public int trap(int[] height) {
        int len = height.length;
        int left = 0 , right = len - 1;
        int leftMax = 0 , rightMax = 0;
        int res = 0 ;
        while(left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax <= rightMax){
                res += leftMax - height[left];
                left++;
            }else{
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
