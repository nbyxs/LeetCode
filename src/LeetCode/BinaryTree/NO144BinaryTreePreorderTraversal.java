package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NO144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(NO94BinaryTreeInorderTraversal.TreeNode root) {

        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;
    }
    public void preorder(NO94BinaryTreeInorderTraversal.TreeNode root, List<Integer> list){
        if(root==null)return ;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
    public List<Integer> preorderTraversalstack(NO94BinaryTreeInorderTraversal.TreeNode root) {

        if(root==null)return null;
        List<Integer> list=new ArrayList<>();
        Stack<NO94BinaryTreeInorderTraversal.TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            root=stack.pop();
            list.add(root.val);
            if(root.right!=null)stack.add(root.right);
            if(root.left!=null)stack.add(root.left);
        }
        return list;
    }
}
