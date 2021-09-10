package LeetCode.BinaryTree;

import java.util.*;

/*
给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层序遍历为：
[
  [15,7], [9,20],[3]
]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO107BinaryTreeLevelOrderTraversalII {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res=new ArrayList<>();
        bfs(res,root);
        Collections.reverse(res);
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
            }res.add(new ArrayList<>(list));
        }
    }
}
