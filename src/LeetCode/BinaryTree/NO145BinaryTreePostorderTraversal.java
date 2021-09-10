package LeetCode.BinaryTree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NO145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(NO94BinaryTreeInorderTraversal.TreeNode root) {

        List<Integer> list=new ArrayList<>();
        postorder(root,list);
        return list;
    }
    public void postorder(NO94BinaryTreeInorderTraversal.TreeNode root, List<Integer> list){
        if(root==null)return ;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }
    public List<Integer> postorderTraversalstack(NO94BinaryTreeInorderTraversal.TreeNode root) {

       List<Integer> list=new ArrayList<>();
        if(root==null)return list;
        Stack<NO94BinaryTreeInorderTraversal.TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            root=stack.pop();
            list.add(root.val);
            if(root.left!=null)stack.add(root.left);
            if(root.right!=null)stack.add(root.right);
        }
        Collections.reverse(list);
        return list;
    }
}
