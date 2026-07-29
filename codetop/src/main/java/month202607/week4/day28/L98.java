package month202607.week4.day28;

import month202607.week4.TreeNode;

public class L98 {
    public boolean isValidBST(TreeNode root) {
        return isLegal(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    public boolean isLegal(TreeNode root,Long max,Long min){
        if(root == null){
            return true;
        }
        if(root.val >= max || root.val <= min){
            return false;
        }
        long val = root.val;
        return isLegal(root.left,val,min) && isLegal(root.right,max,val);
    }
}
