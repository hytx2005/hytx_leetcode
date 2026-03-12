package a08echashu;

import a08echashu.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T06L102 {
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        while(!temp.isEmpty()){
            int size = temp.size();
            List<Integer> tempRes = new ArrayList<>();
            while(size > 0){

                TreeNode curr = temp.removeFirst();
                tempRes.add(curr.val);
                if(curr.left != null){
                    temp.add(curr.left);
                }
                if(curr.right != null){
                    temp.add(curr.right);
                }
                size --;
            }
            res.add(tempRes);
        }
        return res;
    }

    public static List<List<Integer>> test2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        depthTreeNode(root,res,0);
        return res;
    }

    public static void depthTreeNode(TreeNode root,List<List<Integer>> res,int depth){
        if(root == null){
            return;
        }
        if(depth > res.size()-1){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        depthTreeNode(root.left,res,depth+1);
        depthTreeNode(root.right,res,depth+1);
    }

    public static void main(String[] args) {
        	TreeNode root = new TreeNode(3);
        	root.left = new TreeNode(9);
        	root.right = new TreeNode(20);
        	root.right.left = new TreeNode(15);
        	root.right.right = new TreeNode(7);
        	System.out.println(test2(root));
    }
}
