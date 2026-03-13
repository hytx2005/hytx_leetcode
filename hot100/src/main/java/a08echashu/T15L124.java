package a08echashu;

import a08echashu.base.TreeNode;

import java.util.Map;

public class T15L124 {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        max = root.val;
        max(root);
        return max;
    }

    private int max(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 左节点的贡献，右节点的贡献，如果贡献小于0，则不如不选择
        int left = Math.max(0,max(root.left));
        int right = Math.max(0,max(root.right));
        // 递归，考虑当前节点作为连接节点出现的情况, 1. 只出现当前节点 2. 出现当前节点和左子树 3. 出现当前节点和右子树 4. 出现当前节点和左右子树
        int temp = left + right + root.val;
        max = Math.max(max,temp);
        return root.val + Math.max(left,right);
    }
}
