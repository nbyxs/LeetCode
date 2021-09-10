//package LeetCode.BinaryTree;
///*
//根据一棵树的中序遍历与后序遍历构造二叉树。
//注意:
//你可以假设树中没有重复的元素。
//例如，给出
//中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//返回如下的二叉树：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//
//public class NO106ConstructBinaryTreefromnorderandPostorderTraversal {
//    static class TreeNode{
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        public TreeNode() {
//        }
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//
//        public TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public static TreeNode buildTree(int[] inorder, int[] postorder) {
//
//      return   make(inorder,postorder);
//    }
//
//    private static TreeNode make(int[] inorder, int[] postorder) {
//        if(postorder.length==0)return null;
//        int element=postorder[postorder.length-1];
//        TreeNode root=new TreeNode(element);
//        int index=0;
//        for(int i=0;i<inorder.length;++i){
//            if(inorder[i]==element){
//                index=i;
//                break;
//            }
//        }
//        System.out.println(index);
//        int[] inorder1=new int[index];
//        int[] postorder1=new int[index];
//        for(int i=0;i<index;++i){
//            inorder1[i]=inorder[i];
//            postorder1[i]=postorder[i];
//        }
//
//        int[] inorder2=new int[inorder.length-index];
//        int[] postorder2=new int[postorder.length-index];
//        for(int i=0;i<inorder.length-index;++i){
//            inorder2[i]=inorder[i+index+1];
//            postorder2[i]=postorder[index-1+i];
//        }
//        root.left=make(inorder1,postorder1);
//        root.right=make(inorder2,postorder2);
//        return root;
//
//    }
//
//    public static void main(String[] args) {
//        int[] inorder={9,3,15,20,7};
//        int[]postorder={9,15,7,20,3};
//        TreeNode root=buildTree(inorder,postorder);
//
//    }
//}
