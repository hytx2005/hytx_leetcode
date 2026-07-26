package month202607.week4.day26;

import month202607.week4.TreeNode;

public class L129 {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode root,int sum){
        // 不是叶子节点
        if(root == null){
            return 0;
        }
        // 叶子节点
        if(root.left == null && root.right == null){
            sum = sum * 10 + root.val;
            return sum;
        }
        //根节点
        sum = sum*10 + root.val;
        return sum(root.left,sum) + sum(root.right,sum);
    }
}
