package a08echashu;

import a08echashu.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T10L199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int k = 1;
            while (size > 0){
                TreeNode curr = deque.poll();
                if(k == size){
                    res.add(curr.val);
                }
                if(curr.left != null){
                    deque.offer(curr.left);
                }
                if(curr.right != null){
                    deque.offer(curr.right);
                }
                size --;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        System.out.println(new T10L199().rightSideView(root));
    }
}
