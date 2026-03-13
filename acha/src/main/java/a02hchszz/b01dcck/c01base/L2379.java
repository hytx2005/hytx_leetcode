package a02hchszz.b01dcck.c01base;

public class L2379 {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        int res = k;
        char[] block = blocks.toCharArray();
        for (int i = 0; i < block.length; i++) {
            // 入
            count += block[i] == 'W' ? 1 : 0;

            // 更新
            if( i < k-1){
                continue;
            }
            res = Math.min(res, count);

            // 出
            count -= block[i - k + 1] == 'W'? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "WBBWWBBWBW";
        L2379 l = new L2379();
        System.out.println(l.minimumRecolors(s, 7));
    }
}
