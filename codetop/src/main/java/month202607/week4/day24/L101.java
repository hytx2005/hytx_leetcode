package month202607.week4.day24;

import month202607.week4.TreeNode;

public class L101 {
    public boolean isSymmetric(TreeNode root) {
        return checkIsSymmetric(root.left,root.right);
    }

    public boolean checkIsSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val && checkIsSymmetric(left.left,right.right) && checkIsSymmetric(left.right,right.left);
    }
}
