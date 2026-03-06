package shuanzhizhen;

public class T02L11 {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0,right=height.length-1;
        while(left < right){
            int val = (right-left)*Math.min(height[left],height[right]);
            res = Math.max(res,val);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
