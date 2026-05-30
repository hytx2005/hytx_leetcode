package month202605.day0530;

import java.util.ArrayList;
import java.util.List;

public class L102 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            depthTreeNode(root, res, 0);
            return res;
        }

        public static void depthTreeNode(TreeNode root, List<List<Integer>> res, int depth) {
            if (root == null) {
                return;
            }
            if (depth > res.size() - 1) {
                res.add(new ArrayList<>());
            }
            res.get(depth).add(root.val);
            depthTreeNode(root.left, res, depth + 1);
            depthTreeNode(root.right, res, depth + 1);
        }
    }
}
