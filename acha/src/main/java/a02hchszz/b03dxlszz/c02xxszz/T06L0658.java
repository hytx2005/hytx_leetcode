package a02hchszz.b03dxlszz.c02xxszz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Leetcode0658 <a href="https://leetcode.cn/problems/find-k-closest-elements/description/">...</a>
 */
class T06L0658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = -1, right = arr.length;
        List<Integer> res = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int count = arr.length - k;
        while (count > 0) {
            int tl = Math.abs(arr[left + 1] - x);
            int tr = Math.abs(arr[right - 1] - x);
            if (tl > tr) {
                res.removeFirst();
                left++;
            } else if (tl < tr) {
                res.removeLast();
                right--;
            } else {
                if (arr[left + 1] > arr[right - 1]) {
                    res.removeFirst();
                    left++;
                } else {
                    res.removeLast();
                    right--;
                }

            }
            count--;
        }
        return res;
    }

    public static void main(String[] args) {
        T06L0658 t = new T06L0658();
        int[] arr = {1,1,2,3,4,5};
        System.out.println(t.findClosestElements(arr, 4, -1));
    }
}
