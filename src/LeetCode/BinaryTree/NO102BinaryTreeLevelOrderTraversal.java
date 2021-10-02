package LeetCode.BinaryTree;

import java.util.*;

/*
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例：
二叉树：[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO102BinaryTreeLevelOrderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        bfs(res,root);
        return res;
    }

    private void bfs(List<List<Integer>> res, TreeNode root) {
        if(root==null)return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int len=queue.size();
            while (len>0){
                root=queue.poll();
                list.add(root.val);
                if(root.left!=null)queue.offer(root.left);
                if(root.right!=null)queue.offer(root.right);
                --len;
            }
            res.add(new ArrayList<>(list));
        }
    }
    private void bfs_review(List<List<Integer>> res, TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length=queue.size();
            List<Integer> list=new ArrayList<>();
            while (length>0){

                root=queue.poll();
                if(root.left!=null)queue.offer(root.left);
                if(root.right!=null)queue.offer(root.right);
                --length;
                list.add(root.val);
            }
            res.add(new ArrayList<>(list));
        }
    }

}
