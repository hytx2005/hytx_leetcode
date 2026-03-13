package year2025.month10;

/**
 *
 */
public class D251026L2043 {
    public static class Bank{
        long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            int l = balance.length;
            if(account1 < 1 || account1 >= l || account2 < 1 || account2 >= l){
                return false;
            }
            if (balance[account1-1] < money){
                return false;
            }
            balance[account1-1] -= money;
            balance[account2-1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            int l = balance.length;
            if(account < 1 || account >= l){
                return false;
            }
            balance[account-1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            int l = balance.length;
            if(account < 1 || account >= l){
                return false;
            }
            if (balance[account-1] < money){
                return false;
            }
            balance[account-1] -= money;
            return true;
        }
    }

}
