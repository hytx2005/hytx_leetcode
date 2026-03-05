package shuzuAndzifuchuang;

public class T19L58 {
    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        char[] tc = trim.toCharArray();
        int count = 0;
        for (int i = tc.length - 1; i >= 0; i--){
            if (tc[i] == ' '){
                return count;
            }else {
                count++;
            }
        }
        return count;
    }
}
