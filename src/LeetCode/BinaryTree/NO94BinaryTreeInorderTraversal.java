package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树的根节点 root ，返回它的 中序遍历。
 */
public class NO94BinaryTreeInorderTraversal {

    static  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
        TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return list;

    }
    //递归实现
    public void dfs(TreeNode root,List<Integer> list){
        if(root==null)return ;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
    //迭代实现
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> list=new ArrayList<>();
    Stack<TreeNode> stack=new Stack<>();
    while (!stack.isEmpty()||root!=null){
        if(root!=null){
            stack.add(root);
            root=root.left;
        }else {
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
        }
        return list;

    }
}
