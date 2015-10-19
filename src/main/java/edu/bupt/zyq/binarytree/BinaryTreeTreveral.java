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
        //ģ��ݹ飬�ٷ��ң��ٷ���
        //����ʱ���ռ�������������ȵ����ٵ���
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
        //��ͨ��������ջ��ʱ���ռ����
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode t = root;
        stk.push(t);
        res.add(t.val);
        while(!stk.isEmpty()){

            while(t.left != null){//�ҵ�����ߵġ�û�����ӵĽڵ㡱
                res.add(t.left.val);
                stk.push(t.left);
                t = t.left;
            }
            while(!stk.isEmpty()){//���ⵯ��֪���ҵ�һ�����Һ��ӡ���push��ջ
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
        //����linkedList���Բ�����ص㣬����preAsm�㷨��
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
