package LeetCode.BinaryTree;
/*
翻转一棵二叉树。
示例：
输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO226InvertBinaryTree {
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
    public TreeNode invertTree(TreeNode root) {

        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if(root==null)return;
        if(root.left!=null)dfs(root.left);
        if(root.right!=null)dfs(root.right);
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
    }
    private void dfs_review(TreeNode root){
        if(root==null)return;
        if(root.left!=null)dfs_review(root.left);
        if(root.right!=null)dfs_review(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}
