package a02hchszz.b03dxlszz.c02xxszz;

/**
 * 167. 两数之和 II - 输入有序数组 <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/">...</a>
 */
class T08L0167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length - 1;
        while(left < right){
            int t = numbers[left] + numbers[right];
            if(t == target){
                return new int[]{left+1,right+1};
            }else if(t > target){
                right--;
            }else{
                left++;
            }
        }
        return null;
    }
}
