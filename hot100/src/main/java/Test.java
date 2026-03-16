import a08echashu.base.TreeNode;

import javax.imageio.stream.ImageInputStream;
import java.util.*;

public class Test {
    // 得到第k小的元素，k>0
    public int getKthMin(int[] nums1,int[] nums2,int k){
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0){
            return nums2[k-1];
        }else if(n == 0){
            return nums1[k-1];
        }
        int index1 = 0,index2 = 0;
        while(true){
            if(index1 == m){
                return nums2[index2+k-1];
            }else if(index2 == n){
                return nums1[index1+k-1];
            }else if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int mid = k >> 1;
            int next1 = Math.min(index1+mid,m) - 1;
            int next2 = Math.min(index2+mid,n) - 1;
            if(nums1[next1] <= nums2[next2]){
                k -= next1 - index1 + 1;
                index1 = next1 + 1;
            }else{
                k -= next2 - index2 + 1;
                index2 = next2 + 1;
            }

        }
    }


}
