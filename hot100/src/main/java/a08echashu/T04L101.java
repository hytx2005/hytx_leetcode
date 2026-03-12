package a08echashu;

import a07lianbiao.base.ListNode;
import a08echashu.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T04L101 {

    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }else {
            if (left.val != right.val){
                return false;
            }
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }
    }

}
