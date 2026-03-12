package a08echashu;

import a08echashu.base.TreeNode;

public class T08L98 {
    public static boolean isLegal(TreeNode root){
        return isLegal(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    public static boolean isLegal(TreeNode root,Long max,Long min){
        if(root == null){
            return true;
        }
        if(root.val >= max || root.val <= min){
            return false;
        }
        long val = root.val;
        boolean res =  isLegal(root.left,val,min) && isLegal(root.right,max,val);
        System.out.println("节点"+root.val+"的结果是"+res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(isLegal(root));
    }
}
