package a08echashu;

import a08echashu.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class T13L437 {
    public int pathSum1(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int res = rootSum(root,targetSum);
        res += pathSum1(root.left,targetSum);
        res += pathSum1(root.right,targetSum);
        return res;
    }

    public int rootSum(TreeNode root,long targetSum){
        int res = 0;
        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val == targetSum){
            res++;
        }
        res += rootSum(root.left,targetSum-val);
        res += rootSum(root.right,targetSum-val);
        return res;
    }

    public static int test2(TreeNode root,int targetSum){
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        return dfs(map,root,targetSum,0L);
    }

    private static int dfs(Map<Long, Integer> map, TreeNode root, int targetSum, Long curr) {
        if(root == null){
            return 0;
        }
        curr += root.val;
        map.put(curr,map.getOrDefault(curr,0)+1);
        int res = map.getOrDefault(curr-targetSum,0);
        res += dfs(map,root.left,targetSum,curr);
        res += dfs(map,root.right,targetSum,curr);
        map.put(curr,map.getOrDefault(curr,0)-1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(test2(root, 8));
        System.out.println(map);
    }
}
