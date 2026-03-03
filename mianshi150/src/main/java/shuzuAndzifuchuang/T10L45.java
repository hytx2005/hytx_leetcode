package shuzuAndzifuchuang;

public class T10L45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 本轮右端点
        int curR = 0;
        // 下一轮右端点
        int nextR = 0;
        for(int i = 0 ; i<nums.length-1;i++){
            nextR = Math.max(nextR,i+nums[i]);
            if(i == curR){
                curR = nextR;
                res++;
            }
        }
        return res;
    }
}
