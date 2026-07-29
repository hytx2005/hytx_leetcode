package month202607.week4.day28;

import month202607.week4.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || root != null){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if(--k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
