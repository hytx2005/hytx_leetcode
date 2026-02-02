package a01base.b0rumeng;

public class LeetCode2586 {
    public boolean inYuan(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            words[i] = words[i].toLowerCase();
            if (inYuan(words[i].charAt(0)) && inYuan(words[i].charAt(words[i].length() - 1))){
                res++;
            }
        }
        return res;
    }
}
