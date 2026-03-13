package a08echashu;

import a08echashu.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T09L230 {
    /**
     * 中序遍历
     * @param root
     * @param k
     * @return int
     */
    public int getKth(TreeNode root,int k){
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res.get(k-1);
    }
    public void inOrder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }

    public int getKth2(TreeNode root,int k){
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }

     public static void main(String[] args) {
         TreeNode root = new TreeNode(5);
         root.left = new TreeNode(3);
         root.right = new TreeNode(6);
         root.left.left = new TreeNode(2);
         root.left.right = new TreeNode(4);
         root.left.left.left = new TreeNode(1);
         System.out.println(new T09L230().getKth(root,3));
     }
}
