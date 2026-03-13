package shuzuAndzifuchuang;

import java.util.Arrays;

public class T15L135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int res = 0;
        for(int i = 0;i<n;i++){
            if(i>0&&ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
        }
        for(int i = n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                left[i] = Math.max(left[i],left[i+1]+1);
            }
        }
        for(int i = 0 ;i < n;i++){
            res+=left[i];
        }
        return res;
    }
}
