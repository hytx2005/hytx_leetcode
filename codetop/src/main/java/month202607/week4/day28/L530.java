package month202607.week4.day28;

import month202607.week4.TreeNode;

public class L530 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return Integer.MAX_VALUE;
        }
        int thisVal = Integer.MAX_VALUE;
        if (root.left != null) {
            TreeNode cur = root.left;
            while(cur.right != null){
                cur = cur.right;
            }
            thisVal = Math.min(thisVal, Math.abs(root.val - cur.val));
        }
        if (root.right != null) {
            TreeNode cur = root.right;
            while(cur.left != null){
                cur = cur.left;
            }
            thisVal = Math.min(thisVal, Math.abs(root.val - cur.val));
        }
        int left = getMinimumDifference(root.left);
        int right = getMinimumDifference(root.right);
        return Math.min(thisVal, Math.min(left, right));
    }
}
