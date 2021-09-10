package LeetCode.BinaryTree;
/*
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
输入：root = [1,2,3,4,5,6]
输出：6
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO222CountCompleteTreeNodes {
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
    public int countNodes(TreeNode root) {

        if(root==null)return 0;
        TreeNode left=root;
        TreeNode right=root;
        int leftDepth=0;
        int rightDepth=0;
        while(left!=null){
            left=left.left;
            ++leftDepth;
        }
        while(right!=null){
            right=right.right;
            ++rightDepth;
        }
        if(rightDepth==leftDepth)return (2<<leftDepth)-1;
         return 1+countNodes(root.left)+countNodes(root.right);
    }
}
