package month202608.week1.day4;

public class L76 {
    public String minWindow(String s, String t) {
        int[] cntT = new int[128];
        int[] cntS = new int[128];
        for(char tc : t.toCharArray()){
            cntT[tc]++;
        }
        char[] sc = s.toCharArray();
        int m = sc.length;
        int resLeft = -1;
        int resRight = m;
        int left = 0;
        for(int right = 0 ; right < m ; right++){
            // 入
            cntS[sc[right]]++;

            // 出
            while (isCovered(cntS,cntT)){
                // 更新结果
                if(right - left < resRight - resLeft){
                    resLeft = left;
                    resRight = right;
                }
                cntS[sc[left]]--;
                left++;
            }
        }
        return resLeft < 0 ? "" : s.substring(resLeft,resRight+1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
