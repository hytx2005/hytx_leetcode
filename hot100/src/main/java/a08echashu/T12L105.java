package a08echashu;

import a08echashu.base.TreeNode;

import java.util.Arrays;

public class T12L105 {
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if(preOrder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[0]);
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == root.val) {
                // 0~i-1 左子树
                // i+1~length-1 右子树
                int[] leftInOrder = Arrays.copyOfRange(inOrder,0,i);
                int[] rightInOrder = Arrays.copyOfRange(inOrder,i+1,inOrder.length);

                // 左子树的长度为 (i-1)-0 + 1 = i
                // 故前序数组的左子树部分为 1~(1+i-1) = 1~i
                // 1-i 左子树
                // i+1~length-1 右子树
                int[] leftPreOrder = Arrays.copyOfRange(preOrder,1,i+1);
                int[] rightPreOrder = Arrays.copyOfRange(preOrder,i+1,preOrder.length);
                root.left = buildTree(leftPreOrder, leftInOrder);
                root.right = buildTree(rightPreOrder, rightInOrder);
                break;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int[] preOrder = {3,9,8,5,20,15,7};
        int[] inOrder = {8,9,5,3,15,20,7};
        System.out.println(buildTree(preOrder, inOrder));
    }

}
