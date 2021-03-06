package LeetCode.BinaryTree;
/*
计算给定二叉树的所有左叶子之和。
示例：
    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-left-leaves
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO404SumofLeftLeaves {
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

    public int sumOfLeftLeaves(TreeNode root) {

        if(root==null)return 0;
        int left=sumOfLeftLeaves(root.left);
        int right=sumOfLeftLeaves(root.right);
        int mid=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null)mid+=root.left.val;
        int sum=left+right+mid;
        return sum;

    }
    public int sumOfLeftLeaves_review(TreeNode root) {

        if(root==null)return 0;
        int left=sumOfLeftLeaves(root.left);
        int right=sumOfLeftLeaves(root.right);
        int mid=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null)mid+=root.left.val;
        int sum=left+right+mid;
        return sum;

    }
}
