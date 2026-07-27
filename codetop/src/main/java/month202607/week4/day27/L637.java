package month202607.week4.day27;

import month202607.week4.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            double sum = 0.0;
            for(int i = 0 ; i < size ; i++){
                TreeNode cur = deque.pop();
                sum += cur.val;
                if(i == size - 1){
                    res.add(sum/size);
                }
                if(cur.left != null){
                    deque.offer(cur.left);
                }
                if(cur.right != null){
                    deque.offer(cur.right);
                }
            }
        }
        return res;
    }
}
