package year2025.month11;

public class D03L1578 {
    /**
     * 模拟+标记数组
     * @param colors 字符串
     * @param neededTime 数组
     * @return int
     */
    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int res = 0;
        int first = 1;
        int second = 0;
        boolean[] flag = new boolean[n];
        while(first < n){
            char a = colors.charAt(first);
            char b = colors.charAt(second);
            if(a == b){
                if(neededTime[first] > neededTime[second]){
                    res += neededTime[second];
                    flag[second] = true;
                    second = first;
                }else {
                    res += neededTime[first];
                    flag[first] = true;
                }
                first++;
            }else {
                flag[second] = true;
                first++;
                while(flag[second]){
                    second++;
                }
            }
        }
        return res;
    }

    public static int minCost2(String colors, int[] neededTime) {
        int len = colors.length();
        int i = 0,res = 0;
        while (i < len){
            int sum = 0,max = 0;
            char c = colors.charAt(i);
            while (i < len && colors.charAt(i) == c){
                max = Math.max(max,neededTime[i]);
                sum += neededTime[i];
                i++;
            }
            res += sum - max;
        }
        return res;
    }

    public static void main(String[] args) {
        String colors = "cddcdcae";
        int[] neededTime = {4,8,8,4,4,5,4,2};
        String colors2 = "abaac";
        int[] neededTime2 = {1,2,3,4,5};
        String colors3 = "aaaaa";
        int[] neededTime3 = {1,2,3,4,5};
        //System.out.println(minCost(colors, neededTime));
        //System.out.println(minCost(colors2, neededTime2));
        System.out.println(minCost2(colors3, neededTime3));
    }
}
