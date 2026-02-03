package a02hchszz.b03dxlszz.c01fzzfc;

public class T08L3775 {
    public String reverseWords(String s) {
        // 1.计数
        char[] sc =  s.toCharArray();
        int left = 0;
        int count = 0;
        while(left<sc.length&&sc[left]!=' '){
            left++;
            if("aeiou".contains(sc[left-1]+"")){
                count++;
            }
        }
        left++;
        int right = left;
        while (right < sc.length){
            int tmp = 0;
            // 2.1 找到单词结尾
            while(right < sc.length && sc[right] != ' '){
                right++;
            }
            // 2.2 计数
            for (int i = left; i < right; i++) {
                if("aeiou".contains(sc[i]+"")){
                    tmp++;
                }
            }
            if(tmp > count){
                reverse(sc,left,right-1);
            }
            left = right + 1;
            right++;
        }
        return new String(sc);
    }

    public void reverse(char[] s,int left,int right){
        while(left < right){
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }
}
