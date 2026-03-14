package a10huisu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T01L46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for(int num : nums){
            tmp.add(num);
        }
        allSort(res,tmp,0,nums.length);
        return res;
    }
    public static void allSort(List<List<Integer>> res, List<Integer> tmp, int begin, int end){
        // 结束条件
        if(begin == end){
            res.add(new ArrayList<>(tmp));
        }
        // 把begin 和后面的进行调换或者保留
        for(int i = begin; i < end ; i++){
            // 交换
            Collections.swap(tmp,begin,i);
            allSort(res,tmp,begin+1,end);
            // 回溯
            Collections.swap(tmp,begin,i);
        }
    }

    public  static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> list : res){
            System.out.println(list);
        }
    }
}
