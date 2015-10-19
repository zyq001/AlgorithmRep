package edu.bupt.zyq.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 15-10-2.
 */
public class R2LPathSum {

    /**
     * Given a binary tree and a sum, determine
     * if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     * */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> tempSum = new LinkedList<Integer>();
        stack.push(root);
        tempSum.push(root.val);
        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            int tempsum = tempSum.pop();
            if(p.left == null && p.right == null && tempsum == sum) return true;
            if(p.left != null){
                stack.push(p.left);
                tempSum.push(tempsum + p.left.val);
            }
            if(p.right != null){
                stack.push(p.right);
                tempSum.push(tempsum + p.right.val);
            }
        }
        return false;
    }

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     * */
    List<List<Integer>> re = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, new ArrayList<Integer>(), sum);
        return re;
    }

    public void pathSum(TreeNode root, List<Integer> tmp, int value){
        if(root == null) return;
        tmp.add(root.val);
        value -= root.val;
        if(root.left == null && root.right == null && value == 0){
            re.add(new LinkedList<Integer>(tmp));//must new, otherwise only one list, and it will be modified later
            tmp.remove(tmp.size() - 1);//return without remove, will affect later backTra
            return;
        }
        pathSum(root.left, tmp, value);
        pathSum(root.right, tmp, value);
        tmp.remove(tmp.size() - 1);
    }
}
