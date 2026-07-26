package month202607.week4.day26;

import month202607.week4.TreeNode;

public class L222 {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left+right+1;
    }
}
