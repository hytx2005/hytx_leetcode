package a15dontai;

public class T01L70E {
    public int climbStairs(int n) {
        int p1 = 0,p2 = 0,p3 = 1;
        for(int i = 0; i < n ; i++){
            p1 = p2;
            p2 = p3;
            p3 = p1 + p2;
        }
        return p3;
    }
}
