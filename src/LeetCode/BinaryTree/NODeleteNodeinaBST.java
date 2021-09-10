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

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NODeleteNodeinaBST {
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
        return deleteNode1(root,key);
    }
    public TreeNode deleteNode1(TreeNode root, int key) {

        if(root==null)return  null;
        if(root.val<key)root=deleteNode1(root.right,key);
        else if(root.val>key)root=deleteNode1(root.left,key);
        else {//找到删除节点
            //要删除的结点只有左或右子树
            if(root.right==null)return root.left;
            if(root.left==null)return root.right;

            //要删除的节点有左右子树
            TreeNode t=root;
            root=min(t.right);//root指向它的后继节点（右子树的最小节点）
            root.right=deleteMin(t.right);//将root的右链接指向 删除后所有节点都等于root.val的子二叉树
            root.left=t.left;//root为t.left

        }
        return root;
    }

    private TreeNode deleteMin(TreeNode root) {
        if(root.left==null)return root.right;
        root.left=deleteMin(root.left);
        return root;
    }

    private TreeNode min(TreeNode root) {
        if(root.left==null)return root;
        return  min(root.left);
    }



}
