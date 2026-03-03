package shuzuAndzifuchuang;

public class T09L55 {
    public boolean canJump(int[] nums) {
        int max = 0;//实际可以到达的右边界(数组下标)
        int n = nums.length;
        for(int i = 0; i <= max && i < n;i++){
            max = Math.max(max,i+nums[i]);
            if(max >= n-1){
                return true;
            }
        }
        return max >= n-1;
    }
}
