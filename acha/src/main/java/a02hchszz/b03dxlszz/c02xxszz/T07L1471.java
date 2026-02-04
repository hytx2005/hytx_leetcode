package a02hchszz.b03dxlszz.c02xxszz;

import java.util.Arrays;

class T07L1471 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];
        int[] res = new int[k];
        int left = 0,right = n-1;
        int count = 0;
        while (count < k){
            int tl = Math.abs(arr[left] - m);
            int tr = Math.abs(arr[right] - m);
            if(tl > tr){
                res[count] = arr[left];
                left++;
            }else if(tr > tl){
                res[count] = arr[right];
                right--;
            }else{
                if(arr[left] > arr[right]){
                    res[count] = arr[left];
                    left++;
                }else{
                    res[count] = arr[right];
                    right--;
                }
            }
            count++;
        }
        return res;
    }
}
