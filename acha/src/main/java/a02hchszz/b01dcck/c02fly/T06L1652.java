package a02hchszz.b01dcck.c02fly;

import java.util.Arrays;

public class T06L1652 {
    /*
     * 可先利用长度为k的定长窗口求出对应的值，再对应的左移或右移k位即可
     */
    public int[] decrypt(int[] code, int k) {
        // 1. 先求值
        int temp = 0;
        int[] teRes = new int[code.length];
        if (k == 0){
            return teRes;
        }
        int num = Math.abs(k);
        int l = code.length + num -1;
        for (int i = 0; i < l; i++) {
            // 入
            int rightVal = code[i%code.length];
            temp += rightVal;

            int left = i - num + 1;
            if (left < 0){
                continue;
            }
            // 更新
            teRes[left] = temp;

            // 出
            temp -= code[left];
        }
        System.out.println(Arrays.toString(teRes));
        // 2. 移动得到正确结果
        int[] res = new int[code.length];
        // 判断需要右移几位
        // k >0 res[i] = res[i+1] + ... + res[i+k]
        // toRes[j] = toRes[j] + toRes[j+1] + ... + toRes[j+k-1]
        if (k > 0){
            for (int i = 0; i < code.length; i++) {
                res[i] = teRes[(i + 1) % code.length];
            }
        }
        // l1 = code.length;
        // k < 0 res[i] = res[(i-|k|) % l1] +... + res[(i-1) % l1]
        // toRes[j] = toRes[j] + toRes[j+1] +... + toRes[j+|k| -1]
        // j = (i - |k|) % l1
        // j = (i+l1 - |k|) % l1
        else {
            for (int i = 0; i < code.length; i++) {
                res[i] = teRes[(i + code.length - num) % code.length];
            }
        }
        // j+k-1 = i-1
        return res;
    }

    public static void main(String[] args) {
        T06L1652 l1652 = new T06L1652();
        int[] code = {5,2,2,3,1};
        int k = 3;
        //System.out.println(Arrays.toString(l1652.decrypt(code, k)));

        int[] code1 = {5,7,1,4};
        int k1 = 3;
        //System.out.println(Arrays.toString(l1652.decrypt(code1, k1)));

        int[] code2 = {2,4,9,3};
        int k2 = -2;
        //System.out.println(Arrays.toString(l1652.decrypt(code2, k2)));

        int[] code3 = {10,5,7,7,3,2,10,3,6,9,1,6};
        int k3 = -4;
        System.out.println(Arrays.toString(l1652.decrypt(code3, k3)));
    }
}
