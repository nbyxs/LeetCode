package LeetCode.BinaryTree;



/*
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
叶子节点 是指没有子节点的节点。
示例 1：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
示例 2：
输入：root = [1,2,3], targetSum = 5
输出：false

 */
public class NO112PathSum {
    static class TreeNode{
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

    public boolean hasPathSum(TreeNode root, int targetSum) {

      if(root==null)return false;
        targetSum-=root.val;
        if((root.left==null)&&(root.right==null)&&(targetSum==0))return true;
        if(root.left!=null){

            if(hasPathSum(root.left,targetSum))return true;
        }
        if(root.right!=null){

            if(hasPathSum(root.right,targetSum))return true;
        }
        return false;
    }
    public  boolean hasPathSum1(TreeNode root,int target){
        if(root==null)return false;
        if(root.left==null&root.right==null)return target==root.val;
        return  hasPathSum1(root.left,target-root.val)||hasPathSum1(root.right,target-root.val);
    }
}
