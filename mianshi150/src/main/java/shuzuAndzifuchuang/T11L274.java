package shuzuAndzifuchuang;

public class T11L274 {
    // 二分
    public int hIndex(int[] citations) {
        int max = citations.length;
        int min = 1;
        int res = 0;
        while(min <= max){
            int mid = (min+max) / 2;
            if(isLegal(citations,mid)){
                min = mid+1;
                res = Math.max(res,mid);
            }else{
                max = mid-1;
            }
        }
        return res;
    }

    public boolean isLegal(int[] nums,int h){
        int count = 0;
        int n = nums.length;
        for(int i = 0;i < n ; i++){
            if(nums[i] >= h){
                count++;
            }
        }
        return count >= h;
    }
}
