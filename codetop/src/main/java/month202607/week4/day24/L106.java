package month202607.week4.day24;

import month202607.week4.TreeNode;

import java.util.Arrays;

public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0){
            return null;
        }
        // 根节点
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal){
                // 中序数组
                // 0~i-1为左子树
                int[] leftIn = Arrays.copyOfRange(inorder,0,i);
                int[] rightIn = Arrays.copyOfRange(inorder,i+1,inorder.length);

                // 后序数组
                // 0~i-1为左子树 i~len-2为右子树
                int[] leftPost = Arrays.copyOfRange(postorder,0,i);
                int[] rightPost = Arrays.copyOfRange(postorder,i,postorder.length-1);

                root.left = buildTree(leftIn,leftPost);
                root.right = buildTree(rightIn,rightPost);
                break;
            }
        }
        return root;
    }
}
