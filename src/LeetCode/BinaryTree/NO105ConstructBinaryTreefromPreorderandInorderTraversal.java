package LeetCode.BinaryTree;
/*
给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
示例 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO105ConstructBinaryTreefromPreorderandInorderTraversal {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

       return buildTree1(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode buildTree1(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if(ir-il<1)return null;
        if(ir-il==1){
            return  new TreeNode(inorder[il]);
        }
        int val=preorder[pl];
        TreeNode root=new TreeNode(val);
        int index=0;
        for(int i=il;i<ir;++i){
            if(inorder[i]==val){
                index=i;
                break;
            }
        }
        root.left=buildTree1(preorder,pl+1,pl+1+(index-il),inorder,il,index);
        root.right=buildTree1(preorder,pl+1+(index-il),pr,inorder,index+1,ir);
        return root;
    }
}
