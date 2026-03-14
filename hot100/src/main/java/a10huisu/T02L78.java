package a10huisu;

import java.util.ArrayList;
import java.util.List;

public class T02L78 {
    public static List<List<Integer>> num(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        allSort(res,temp,0,nums.length,nums);
        return res;
    }

    private static void allSort(List<List<Integer>> res, List<Integer> temp, int begin, int length, int[] nums) {
        if(begin == length){
            res.add(new ArrayList<>(temp));
            return;
        }
        // 只有两种情况，选或者不选
        // 不选
        allSort(res,temp,begin+1,length,nums);
        // 选
        temp.add(nums[begin]);
        allSort(res,temp,begin+1,length,nums);
        // 回溯
        temp.remove(temp.size()-1);
    }
}
