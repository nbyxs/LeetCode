package LeetCode.BinaryTree;
/*
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
一般来说，删除节点可分为两个步骤：
    首先找到需要删除的节点；
    如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
示例:
root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7
给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
    5
   / \
  4   6
 /     \
2       7
另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7
 */
public class NO450DeleteNodeinaBST {
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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null)return null;
        if(root.val<key)root.right=deleteNode(root.right,key);
       else if(root.val>key)root.left=deleteNode(root.left,key);
        else {
            if(root.right==null)return root.left;
            if(root.left==null)return root.right;
            TreeNode x=root;
            root=Tmin(x.right);
            root.right=deletemin(x.right);
            root.left=x.left;
        }
        return root;
    }

    private TreeNode deletemin(TreeNode root) {
        if(root.left==null)return root.right;
        root.left=deletemin(root.left);
        return root;
    }

    private TreeNode Tmin(TreeNode root) {
        if(root.left==null)return root;
        return Tmin(root.left);
    }
}
