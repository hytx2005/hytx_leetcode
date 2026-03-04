package shuzuAndzifuchuang;

import java.util.Map;

public class T16L13 {
    /**
     * 模拟
     * @param s
     * @return int
     */
    public int romanToInt1(String s) {
        char[] sc = s.toCharArray();
        int res = 0;
        int i = 0;
        while (i < sc.length) {
            switch (sc[i]) {
                case 'I':
                    if (i + 1 < sc.length && sc[i + 1] == 'V') {
                        res += 4;
                        i += 2;
                    } else if (i + 1 < sc.length && sc[i + 1] == 'X') {
                        res += 9;
                        i += 2;
                    } else {
                        res += 1;
                        i++;
                    }
                    break;
                case 'V':
                    res += 5;
                    i++;
                    break;
                case 'X':
                    if (i + 1 < sc.length && sc[i + 1] == 'L') {
                        res += 40;
                        i += 2;
                    } else if (i + 1 < sc.length && sc[i + 1] == 'C') {
                        res += 90;
                        i += 2;
                    } else {
                        res += 10;
                        i++;
                    }
                    break;
                case 'L':
                    res += 50;
                    i++;
                    break;
                case 'C':
                    if (i + 1 < sc.length && sc[i + 1] == 'D') {
                        res += 400;
                        i += 2;
                    } else if (i + 1 < sc.length && sc[i + 1] == 'M') {
                        res += 900;
                        i += 2;
                    } else {
                        res += 100;
                        i++;
                    }
                    break;
                case 'D':
                    res += 500;
                    i++;
                    break;
                case 'M':
                    res += 1000;
                    i++;
                default:
                    break;
            }
        }

        return res;
    }
    Map<Character,Integer> map = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
    public int romanToInt2(String s){
        int res = 0;
        char[] sc = s.toCharArray();
        int n = sc.length;
        for(int i = 0;i<n;i++){
            int val = map.get(sc[i]);
            if(i<n-1 && val < map.get(sc[i+1])){
                res-=val;
            }else{
                res+=val;
            }
        }
        return res;
    }
}
