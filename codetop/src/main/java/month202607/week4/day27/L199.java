package month202607.week4.day27;

import month202607.week4.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode cur = deque.pop();
                if(i == size - 1){
                    res.add(cur.val);
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
