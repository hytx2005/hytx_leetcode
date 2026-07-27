package month202607.week4.day27;

import month202607.week4.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode cur = deque.pop();
                if(cur.left != null){
                    deque.offer(cur.left);
                }
                if(cur.right != null){
                    deque.offer(cur.right);
                }
                temp.add(cur.val);
            }
            res.add(temp);
        }
        return res;
    }
}
