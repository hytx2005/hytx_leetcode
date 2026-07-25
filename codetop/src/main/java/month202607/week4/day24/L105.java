package month202607.week4.day24;

import month202607.week4.TreeNode;

import java.util.Arrays;

public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        for(int i = 0 ; i < inorder.length ; i++){
            if(inorder[i] == root.val){
                // 0~i-1 左子树
                // i+1~length-1 右子树
                int[] leftInOrder = Arrays.copyOfRange(inorder,0,i);
                int[] rightInOrder = Arrays.copyOfRange(inorder,i+1,inorder.length);

                // 左子树的长度为 (i-1)-0 + 1 = i
                // 故前序数组的左子树部分为 1~(1+i-1) = 1~i
                // 1-i 左子树
                // i+1~length-1 右子树
                int[] leftPreOrder = Arrays.copyOfRange(preorder,1,i+1);
                int[] rightPreOrder = Arrays.copyOfRange(preorder,i+1,preorder.length);
                root.left = buildTree(leftPreOrder, leftInOrder);
                root.right = buildTree(rightPreOrder, rightInOrder);
                break;
            }

        }
        return root;
    }
}
