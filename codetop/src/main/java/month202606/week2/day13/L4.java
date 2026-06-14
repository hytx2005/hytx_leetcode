package month202606.week2.day13;

public class L4 {
    class Solution {
        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
            int m1 = nums1.length;
            int m2 = nums2.length;
            int k = (m1+m2)/2;
            int index1 = 0;
            int index2 = 0;
            while(k > 0){
                int val1 = index1 < m1 ? nums1[index1] : Integer.MAX_VALUE;
                int val2 = index2 < m2 ? nums2[index2] : Integer.MAX_VALUE;
                if(val1 <= val2){
                    index1++;
                }else {
                    index2++;
                }
                k--;
            }
            if((m1+m2) % 2 == 1){
                return Math.min(
                        index1 < m1 ? nums1[index1] : Integer.MAX_VALUE,
                        index2 < m2 ? nums2[index2] : Integer.MAX_VALUE
                );
            }else {
                return (Math.min(
                        index1 < m1 ? nums1[index1] : Integer.MAX_VALUE,
                        index2 < m2 ? nums2[index2] : Integer.MAX_VALUE
                ) + Math.max(
                        index1-1 >= 0 ? nums1[index1-1] : Integer.MIN_VALUE,
                        index2-1 >= 0 ? nums2[index2-1] : Integer.MIN_VALUE
                )) / 2.0;
            }
        }

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            if (len % 2 == 0) {
                return (findKth(nums1, nums2, len / 2) + findKth(nums1, nums2, len / 2 + 1)) / 2.0;
            } else {
                return findKth(nums1, nums2, len / 2 + 1) * 1.0;
            }
        }

        public int findKth(int[] nums1, int[] nums2, int k) {
            if (nums1.length == 0) {
                return nums2[k - 1];
            } else if (nums2.length == 0) {
                return nums1[k - 1];
            }
            int index1 = 0, index2 = 0;
            int m = nums1.length, n = nums2.length;
            while (true) {
                if (index1 == m) {
                    return nums2[index2 + k - 1];
                } else if (index2 == n) {
                    return nums1[index1 + k - 1];
                } else if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }
                int mid = k >> 1;
                int next1 = Math.min(index1 + mid, m) - 1;
                int next2 = Math.min(index2 + mid, n) - 1;
                if (nums1[next1] <= nums2[next2]) {
                    k -= next1 - index1 + 1;
                    index1 = next1 + 1;
                } else {
                    k -= next2 - index2 + 1;
                    index2 = next2 + 1;
                }
            }
        }
    }
}
