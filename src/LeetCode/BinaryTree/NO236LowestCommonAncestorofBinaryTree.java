package LeetCode.BinaryTree;
/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
示例 1：
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO236LowestCommonAncestorofBinaryTree {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
               if(root==p||root==q||root==null)return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) {
            return root;//分别在root左右子树上找到了p，q
        }
        if (left==null&&right!=null)return right;//在右子树上找到了p q
        else if(left != null)return left;
        else return null;


    }
    public TreeNode lowestCommonAncestor_review(TreeNode root, TreeNode p, TreeNode q){
        if(root==null||root==p||root==q)return root;
        TreeNode left=lowestCommonAncestor_review(root.left,p,q);
        TreeNode right=lowestCommonAncestor_review(root.right,p,q);
        if(left!=null&&right!=null)return root;
        if(left != null)return left;
        else if(right != null)return right;
        else return null;
    }
}
