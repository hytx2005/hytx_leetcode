package a02shuanzhizhen;

public class T04L42 {
    /**
     * 动态规划，构造左右边界数组，分别记录当前位置左边和右边的最高柱子高度
     * @param height  数组
     * @return int
     */
    public int trap1(int[] height) {
        int h = height.length;
        int[] left = new int[h];
        int[] right = new int[h];
        left[0] = 0;
        right[h-1] = 0;
        // 构造左边界
        for(int i = 1 ; i < h ;i++){
            left[i] = Math.max(left[i-1],height[i-1]);
        }
        // 构造右边界
        for(int j = h-2 ; j >= 0 ; j--){
            right[j] = Math.max(right[j+1],height[j+1]);
        }
        // 构造结果
        int res  = 0;
        for(int k = 1; k < h-1 ; k++){
            res += Math.max( Math.min(left[k],right[k]) - height[k] , 0);
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int leftMax = 0,rightMax = 0;
        int left = 0,right = height.length-1;
        while(left < right){
            // 构造左右 边界
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            // 此时 height[left] 的左右边界的最小值为leftMax
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
