package shuzuAndzifuchuang;

public class T14L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n = gas.length;
        while(i < n){
            int sumOfGas = 0,sumOfCost = 0;
            // 走过的节点数量
            int count = 0;
            while(count < n){
                // 取余计算下一个节点位置
                int j = (i+count)%n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                // 从 i 走不到
                if(sumOfGas < sumOfCost){
                    break;
                }
                count++;
            }
            if(count == n){
                return i;
            }else{
                i = i+count+1;
            }
        }
        return -1;
    }
}
