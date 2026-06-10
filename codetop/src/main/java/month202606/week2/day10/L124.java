package month202606.week2.day10;

public class L124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int res = 0;
        public int maxPathSum(TreeNode root) {
            if(root == null){
                return 0;
            }
            res = root.val;
            dfs(root);
            return res;
        }

        public int dfs(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            res = Math.max(
                    Math.max(res,root.val),
                    Math.max(Math.max(left,right)+root.val, left + right + root.val)
            );
            return Math.max(root.val, Math.max(left, right) + root.val);
        }
    }
}
