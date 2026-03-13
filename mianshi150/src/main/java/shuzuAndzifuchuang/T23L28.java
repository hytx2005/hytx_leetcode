package shuzuAndzifuchuang;

public class T23L28 {

    public static int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();
        for (int i = 0; i < h; i++) {
            char h1 = hc[i];
            if (h1 == nc[0]){
                int k = 1;
                int j = i+1;
                while (k < n && j < h){
                    if (hc[j] != nc[k]){
                        break;
                    }
                    k++;
                    j++;
                }
                if(k == n){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String h = "sadbutsad";
        String n = "sad";
        System.out.println(strStr(h, n));
    }
}
