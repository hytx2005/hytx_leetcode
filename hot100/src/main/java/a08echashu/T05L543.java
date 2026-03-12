package a08echashu;

import a08echashu.base.TreeNode;

public class T05L543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
