package shuzuAndzifuchuang;

public class T01L88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int f1 = m-1,f2=n-1;
        int count = m+n-1;
        while(f1 >=0 || f2 >= 0){
            int val1 = f1 >= 0 ? nums1[f1] : Integer.MIN_VALUE;
            int val2 = f2 >= 0 ? nums2[f2] : Integer.MIN_VALUE;
            if(val1 >= val2){
                nums1[count] = nums1[f1];
                f1--;
            }else{
                nums1[count] = nums2[f2];
                f2--;
            }
            count--;
        }
    }
}
