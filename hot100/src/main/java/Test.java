import java.util.HashSet;
import java.util.Set;

public class Test {
    public int numRabbits(int[] answers) {
        Set<Integer> set = new HashSet<>();
        for(int ans : answers){
            set.add(ans);
        }
        int res = 0;
        for(int ans : set){
            res += ans;
        }
        res += set.size();
        return res;
    }
}
