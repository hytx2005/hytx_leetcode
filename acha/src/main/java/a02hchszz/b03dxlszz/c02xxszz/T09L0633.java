package a02hchszz.b03dxlszz.c02xxszz;

class T09L0633 {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            // 防止溢出 c 可能是Int的最大值
            if(left * left == c - right * right){
                return true;
            } else if (left * left < c - right * right) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
