package month202606.week2.day14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L199 {
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
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                int k = 1;
                while (size > 0) {
                    TreeNode curr = deque.poll();
                    if (k == size) {
                        res.add(curr.val);
                    }
                    if (curr.left != null) {
                        deque.offer(curr.left);
                    }
                    if (curr.right != null) {
                        deque.offer(curr.right);
                    }
                    size--;
                }
            }
            return res;
        }
    }
}
