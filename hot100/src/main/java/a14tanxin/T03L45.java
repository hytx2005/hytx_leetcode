package a14tanxin;

public class T03L45 {
    public static int jump(int[] nums) {
        int count = 0;
        int curRight = 0;
        int nextRight = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 遍历的过程中，记录下一座桥的最远点
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) { // 无路可走，必须建桥
                curRight = nextRight; // 建桥后，最远可以到达 next_right
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        System.out.println(jump(nums));
    }
}
