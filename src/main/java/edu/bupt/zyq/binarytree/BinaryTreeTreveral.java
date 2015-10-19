package edu.bupt.zyq.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zangyq on 2015/9/3.
 */
public class BinaryTreeTreveral {

    public List<Integer> preorderTraversalAsm(TreeNode root) {
        //模拟递归，再放右，再放左
        //弹得时候收集遍历结果，则，先弹左，再弹右
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode t = root;
        stk.push(t);
        while(!stk.isEmpty()){
            t = stk.pop();
            res.add(t.val);
            if(t.right != null) stk.push(t.right);
            if(t.left != null) stk.push(t.left);
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        //普通方法，入栈的时候收集结果
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode t = root;
        stk.push(t);
        res.add(t.val);
        while(!stk.isEmpty()){

            while(t.left != null){//找到最左边的“没有左孩子的节点”
                res.add(t.left.val);
                stk.push(t.left);
                t = t.left;
            }
            while(!stk.isEmpty()){//往外弹，知道找到一个“右孩子”，push进栈
                t = stk.pop();
                if(t.right != null){
                    stk.push(t.right);
                    res.add(t.right.val);
                    t = t.right;
                    break;
                }
            }

        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> re = new ArrayList<Integer>();
        TreeNode p = root;
        while(!st.isEmpty() || p!=null){
            while(p != null){
                st.push(p);
                p = p.left;
            }

            if(!st.isEmpty()){
                p = st.pop();
                re.add(p.val);
                p = p.right;
            }
        }
        return re;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        //利用linkedList可以插入的特点，改造preAsm算法，
//        Stack
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stk = new Stack<TreeNode>(){};
        TreeNode t = root;
        stk.push(t);
        while(!stk.isEmpty()){
            t = stk.pop();
            res.add(0, t.val);
            if(t.left != null) stk.push(t.left);
            if(t.right != null) stk.push(t.right);
        }
        return res;
    }

}
