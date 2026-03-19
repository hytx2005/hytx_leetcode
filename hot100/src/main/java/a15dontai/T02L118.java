package a15dontai;

import java.util.ArrayList;
import java.util.List;

public class T02L118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int i = 0;
        while(i < numRows){
            if(res.isEmpty()){
                temp.add(1);
                res.add(new ArrayList<>(temp));
            }else{
                List<Integer> prev = res.get(i-1);
                temp.add(1);
                for(int j = 1; j < i ; j++){
                    int val1 = prev.get(j-1);
                    int val2 = prev.get(j);
                    temp.add(val1+val2);
                }
                temp.add(1);
                res.add(new ArrayList<>(temp));
            }
            temp.clear();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
