package edu.bupt.zyq.binarytree;

import java.util.List;

/**
 * Created by root on 15-10-1.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> re = new ArrayList<String>();
        if(root == null) return re;
        return dfs(root, "", re);
    }

    public List<String> dfs(TreeNode root, String path, List<String> re){
        if(root.left == null && root.right == null) re.add(path + root.val);
        if(root.left != null) dfs(root.left, path + root.val + "->", re);
        if(root.right != null) dfs(root.right, path + root.val + "->", re);
        return re;
    }
}
