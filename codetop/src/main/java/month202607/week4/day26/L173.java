package month202607.week4.day26;

import month202607.week4.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L173 {
    class BSTIterator {
        private int idx;
        private final List<Integer> arr;

        public BSTIterator(TreeNode root) {
            idx = 0;
            arr = new ArrayList<Integer>();
            inorderTraversal(root, arr);
        }

        public int next() {
            return arr.get(idx++);
        }

        public boolean hasNext() {
            return idx < arr.size();
        }

        private void inorderTraversal(TreeNode root, List<Integer> arr) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left, arr);
            arr.add(root.val);
            inorderTraversal(root.right, arr);
        }
    }
}
