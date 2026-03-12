package a08echashu;

import a08echashu.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T11L114 {
    /**
     * 前序遍历
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        first(res,root);
        TreeNode last = root;
        for(int i = 1; i<res.size() ; i++){
            TreeNode temp =  res.get(i);
            last.right = temp;
            last.left = null;
            last = last.right;
        }
    }

    public void first(List<TreeNode> nums,TreeNode root){
        if(root == null){
            return;
        }else{
            nums.add(root);
            first(nums,root.left);
            first(nums,root.right);
        }
    }


    public static void test1(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode curr = root;
        while (curr != null){
            if(curr.left != null){
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null){
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        test1(root);
        System.out.println(root);
    }
}
