package month202607.week3.day18;

public class L383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];

        char[] rc = ransomNote.toCharArray();
        char[] mc = magazine.toCharArray();


        for(char mcc : mc) {
            cnt[mcc - 'a']++;
        }
        for(char rcc : rc){
            cnt[rcc-'a']--;
            if(cnt[rcc-'a'] < 0){
                return false;
            }
        }


        return true;
    }

}
