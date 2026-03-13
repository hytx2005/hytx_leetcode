package a08echashu;

import a08echashu.base.TreeNode;

public class T03L226 {
    /**
     * 递归
     * @param root
     * @return {@link TreeNode }
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
