package year2026.month04;

public class D13L1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int res = n+1;
        // 向右扫描
        for(int i = start ; i < n ; i++){
            if(nums[i] == target){
                res = Math.min(res,Math.abs(i-start));
                break;
            }
        }
        // 向左扫描
        for(int i = start - 1 ; i >= 0 ; i--){
            if(nums[i] == target){
                res = Math.min(res,Math.abs(i-start));
                break;
            }
            if(Math.abs(i-start) > res){
                break;
            }
        }
        return res;
    }
}
