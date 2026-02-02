package year2025.month10;

/**
 * @author ASUS
 */
public class D251025L1716 {

    public static int totalMoney(int n) {
        int money = 1;
        int res = 0;
        int day = 1;
        int week = 1;
        while (day <= n){
            res += money;
            System.out.println("Day " + day + ": " + money);
            day++;
            money++;
            if (day == 8){
                day = 1;
                n = n - 7;
                week++;
                money = week;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(10));
    }
}
