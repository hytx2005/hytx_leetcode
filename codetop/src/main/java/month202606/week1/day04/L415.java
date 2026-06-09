package month202606.week1.day04;

public class L415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            char[] sc1 = num1.toCharArray();
            char[] sc2 = num2.toCharArray();
            int index1 = sc1.length - 1;
            int index2 = sc2.length - 1;
            StringBuilder res = new StringBuilder();

            int other = 0;
            while (index1 >= 0 || index2 >= 0 || other > 0){
                int val1 = index1 >= 0 ? sc1[index1] - '0' : 0;
                int val2 = index2 >= 0 ? sc2[index2] - '0' : 0;
                int val = val1 + val2 + other;
                other = val / 10;
                res.append(val%10);
                index1--;
                index2--;
            }

            return res.reverse().toString();
        }
    }
}
