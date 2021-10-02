package LeetCode.BinaryTree;
/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。
输入：root = [3,9,20,null,null,15,7]
输出：2
 */
public class NO111MinimumDepthofBinaryTree {
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
    public int minDepth(TreeNode root) {

       if(root==null)return 0;
       if(root.left == null&&root.right==null)return 1;
       int depth=Integer.MAX_VALUE;
      if(root.left!=null)  depth=Math.min(minDepth(root.left),depth);
        if(root.right!=null){
           depth=Math.min(minDepth(root.right),depth);
       }
       return depth+1;
    }


}
