package a02hchszz.b03dxlszz.c02xxszz;

/**
 * L2105 <a href="https://leetcode.cn/problems/watering-plants-ii/description/">...</a>
 * @author ASUS
 */
class T04L2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0, r = plants.length - 1;
        int ta =capacityA,tb = capacityB;
        int count = 0;
        while(l <= r){
            // 不用判断谁水量更多
            if(l != r){
                // 判断Alice
                if(ta < plants[l]){
                    count++;
                    ta = capacityA;
                }
                ta -= plants[l];
                // 判断Bob
                if(tb < plants[r]){
                    count++;
                    tb = capacityB;
                }
                tb -= plants[r];
            }else{
                // 只有在植物数量为单数时发生，此时必定是最后一个
                if(ta < plants[l] && tb < plants[l]){
                    count++;
                }
            }
            l++;
            r--;
        }
        return count;
    }
}
