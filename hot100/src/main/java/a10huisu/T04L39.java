package a10huisu;

import java.util.ArrayList;
import java.util.List;

public class T04L39 {
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        allSortSum(res,temp,0,candidates,target);
        return res;
    }

    private void allSortSum(List<List<Integer>> res, List<Integer> temp, int begin, int[] candidates, int target) {
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        // 下一次 当前或下一个
        if(begin == candidates.length){
            return;
        }
        // 当前
        if(target - candidates[begin] >=0){
            temp.add(candidates[begin]);
            allSortSum(res,temp,begin,candidates,target-candidates[begin]);
            temp.remove(temp.size()-1);
        }

        // 下一个
        allSortSum(res,temp,begin+1,candidates,target);
    }
}
