import java.io.*;
import java.util.*;

/**
 * @author ASUS
 */
public class Main implements Serializable{
    // 得到第k小的元素
    public static int getKthNums(int[] nums1,int[] nums2,int k){
        int index1 = 0,index2 = 0;// 分别记录nums1和nums2的左边界
        int l1 = nums1.length,l2 = nums2.length;
        while(true){
            System.out.println("index1=" + index1 + ", index2=" + index2 + ", k=" + k);
            if(index1 == nums1.length){
                return nums2[index2+k-1];
            }
            if(index2 == nums2.length){
                return nums1[index1+k-1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }

            int mid1 = (k / 2) + index1;
            int mid2 = (k / 2) + index2;
            int newIndex1 = Math.min(mid1,l1) - 1;
            int newIndex2 = Math.min(mid2,l2) - 1;
            if(nums1[newIndex1] > nums2[newIndex2]){
                k-=newIndex2-index2+1;
                index2 = newIndex2+1;
            }else{
                k-=newIndex1-index1+1;
                index1 = newIndex1+1;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        int k = 5;
        System.out.println(getKthNums(nums1, nums2, 2));
    }
}
