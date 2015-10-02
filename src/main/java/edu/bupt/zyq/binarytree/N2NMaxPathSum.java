package edu.bupt.zyq.binarytree;

/**
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes
 from some starting node to any node in the tree along the parent-child connections.
 The path does not need to go through the root.
 * Created by root on 15-10-2.
 */
public class N2NMaxPathSum {

    //sum = 0 when val is negtive
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxSum;
    }

    public int findSum(TreeNode root){
        if(root == null) return 0;
        int left = findSum(root.left);
        int right = findSum(root.right);
        maxSum = Math.max(maxSum, left + right + root.val);
        int ret = Math.max(root.val + left, root.val + right);
        return ret > 0? ret: 0;
    }


    /**
     *
     * */

}
