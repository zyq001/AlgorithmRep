package edu.bupt.zyq.binarytree;

import java.util.*;

/**
 * Created by zangyq on 2015/9/3.
 */
public class BinaryTreeTreveral {

    public List<Integer> preorderTraversalAsm(TreeNode root) {
        //Ä£ï¿½ï¿½Ý¹é£¬ï¿½Ù·ï¿½ï¿½Ò£ï¿½ï¿½Ù·ï¿½ï¿½ï¿?
        //ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ï¿½ï¿½Õ¼ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Èµï¿½ï¿½ï¿½ï¿½Ùµï¿½ï¿½ï¿½
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
        //ï¿½ï¿½Í¨ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Õ»ï¿½ï¿½Ê±ï¿½ï¿½ï¿½Õ¼ï¿½ï¿½ï¿½ï¿?
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode t = root;
        stk.push(t);
        res.add(t.val);
        while(!stk.isEmpty()){

            while(t.left != null){//ï¿½Òµï¿½ï¿½ï¿½ï¿½ï¿½ßµÄ¡ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½ÓµÄ½Úµã¡?
                res.add(t.left.val);
                stk.push(t.left);
                t = t.left;
            }
            while(!stk.isEmpty()){//ï¿½ï¿½ï¿½âµ¯ï¿½ï¿½Öªï¿½ï¿½ï¿½Òµï¿½Ò»ï¿½ï¿½ï¿½ï¿½ï¿½Òºï¿½ï¿½Ó¡ï¿½ï¿½ï¿½pushï¿½ï¿½Õ»
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

        //ÀûÓÃlinkedList¿ÉÒÔ²åÈëµÄÌØµã£¬¸ÄÔìpreAsmËã·¨£¬
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

















    static List<TreeNode> res = new ArrayList<TreeNode>();
    public static  void MirroInOrder(TreeNode root){
        if(root == null) return ;
        MirroInOrder(root.right);
        res.add(root);
        MirroInOrder(root.left);
    }

    public static List<TreeNode> MirroInOrderInclu(TreeNode root){
        if(root == null) return null;
        List<TreeNode> res = new LinkedList<TreeNode>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stk.isEmpty() || node != null){
            while(node !=null) {
                stk.push(node);
                node = node.right;
            }
            node = stk.peek();
            stk.pop();
            res.add(node);
            node = node.left;
        }
        return res;
    }

    public  static void main(String[] args){
        TreeNode root = new TreeNode(0), r1 = new TreeNode(1), r2 = new TreeNode(2), r3 = new TreeNode(3), r4 = new TreeNode(4);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r2.right = r4;
        MirroInOrder(root);
        List<TreeNode> rr1 = MirroInOrderInclu(root), rr2 = res;
        for(TreeNode t: rr1) System.out.println(t.val);
        for(TreeNode t: rr2) System.out.println(t.val);
//        System.out.println();
    }

}
