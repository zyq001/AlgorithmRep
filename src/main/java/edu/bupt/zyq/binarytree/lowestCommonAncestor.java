package edu.bupt.zyq.binarytree;

/**
 * Created by zangyq on 2015/9/3.
 */
public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //��һ�����ص����⣬���p��q����������ϣ��ǽ���Ͳ����ˣ�
        if(root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q), right = lowestCommonAncestor(root.right, p, q);
        return (left == null)? right : (right == null ? left : root);
    }


}
