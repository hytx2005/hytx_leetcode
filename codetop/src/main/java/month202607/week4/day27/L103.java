package month202607.week4.day27;

import month202607.week4.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return res;
        }
        list.add(root);
        boolean left = true;
        while (!list.isEmpty()) {
            int size = list.size();
            temp.clear();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                if (left) {
                    if (node.left != null) {
                        list.addLast(node.left);
                    }
                    if (node.right != null) {
                        list.addLast(node.right);
                    }
                    temp.addLast(node.val);
                } else {
                    if (node.left != null) {
                        list.addLast(node.left);
                    }
                    if (node.right != null) {
                        list.addLast(node.right);
                    }
                    temp.addFirst(node.val);
                }
            }

            left = !left;
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
