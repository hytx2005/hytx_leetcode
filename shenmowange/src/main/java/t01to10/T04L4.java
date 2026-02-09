package t01to10;


/**
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/description/">寻找两个正序数组的中位数</a>
 * @author Dai
 * &#064;date  2026/02/09
 */
class T04L4 {

    /**
     * 有序数组合并 O(m+n)
     * @param nums1 数组1
     * @param nums2 数组2
     * @return double
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        int i1 = 0 ,i2 = 0, k = 0;
        int l1 = nums1.length,l2 = nums2.length;
        while ( k < nums.length){
            int val1 = i1 < l1 ? nums1[i1] : Integer.MAX_VALUE;
            int val2 = i2 < l2 ? nums2[i2] : Integer.MAX_VALUE;
            if (val1 < val2){
                nums[k] = val1;
                i1++;
            } else {
                nums[k] = val2;
                i2++;
            }
            k++;
        }

        // 计算中位数
        double res = 0;
        if (nums.length % 2 == 0){
            res = (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            res = nums[nums.length / 2];
        }

        return res;
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 0){
            return (findKth(nums1, nums2, length / 2) + findKth(nums1, nums2, length / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, nums2, length / 2 + 1);
        }
    }

    // 找到第k小的元素
    public int findKth(int[] nums1, int[] nums2, int k){
        int length = nums1.length + nums2.length;
        int index1 = 0, index2 = 0;
        while (true){
            // 边界情况
            if(index1 == nums1.length){
                return nums2[index2 + k - 1];
            }
            if(index2 == nums2.length){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int mid = k / 2;
            int newIndex1 = Math.min(index1 + mid, nums1.length) -1;
            int newIndex2 = Math.min(index2 + mid, nums2.length) -1;
            int pivot1 = nums1[newIndex1],pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -= newIndex1-index1+1;
                index1 = newIndex1 + 1;
            }else {
                k -= newIndex2-index2+1;
                index2 = newIndex2 + 1;
            }
        }

    }

    public static void main(String[] args) {
        T04L4 t = new T04L4();
        int[] nums1 = {1, 3}, nums2 = {2};
        System.out.println(t.findMedianSortedArrays1(nums1, nums2));
    }
}
