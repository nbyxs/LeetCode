package LeetCode.BinaryTree;

import java.util.Map;

/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/balanced-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO110BalancedBinaryTree {
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

    public boolean isBalanced(TreeNode root) {

        return Depth(root)!=-1;
    }

    private int Depth(TreeNode root) {
        if(root==null)return 0;
        int left=Depth(root.left);
        if(left==-1)return -1;
        int right=Depth(root.right);
        if(right==-1)return -1;
        if(Math.abs(left-right)>1)return -1;
        return Math.max(left,right)+1;
    }
}
