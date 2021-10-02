package LeetCode.BinaryTree;
/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
    节点的左子树只包含 小于 当前节点的数。
    节点的右子树只包含 大于 当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
示例 1：
输入：root = [2,1,3]
输出：true
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO98ValidateBinarySearchTree {
    Long Max=Long.MIN_VALUE;
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
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        boolean flag=isValidBST(root.left);
        if(Max<root.val)Max= Long.valueOf(root.val);
        else return false;
        boolean flag_r=isValidBST(root.right);
        return flag&&flag_r;

    }
}
