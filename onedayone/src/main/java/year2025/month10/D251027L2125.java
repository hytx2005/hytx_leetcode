package year2025.month10;

/**
 * @author ASUS
 */
public class D251027L2125 {
    public static int numberOfBeams(String[] bank) {
        if (bank.length < 2) {
            return 0;
        }
        int res = 0;
        // 计数 每行设备得数量
        int[] counts = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    counts[i]++;
                }
            }
        }

        // 遍历数组 找到相邻的两个非零元素 相乘 相加
        int l = 0,r = 1;
        while (l < counts.length && counts[l] == 0){
            l++;
            r++;
        }
        while (r < counts.length && counts[r] == 0){
            r++;
        }
        while (l < r && r < bank.length){
            res += counts[l] * counts[r];
            l = r;
            do {
                r++;
            } while (r < bank.length && counts[r] == 0);
        }
        return res;
    }

    public static int numberOfBeams1(String[] bank) {
        if (bank.length < 2) {
            return 0;
        }
        int res = 0;
        int last = 0;
        for (String s : bank) {
            int count = (int) s.chars().filter(ch -> ch == '1').count();
            if(count != 0){
                res += count * last;
                last = count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(test));
    }
}
