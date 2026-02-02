package a01base.b0rumeng;

public class Leetcode852 {
    public int peakIndexInMountainArray(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                res = i - 1;
                break;
            }
        }
        return res;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int left = 0, right = arr.length - 1;
        int res = 0;
        while (arr[left] < arr[right]) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid + 1]) {
                res = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }
}
