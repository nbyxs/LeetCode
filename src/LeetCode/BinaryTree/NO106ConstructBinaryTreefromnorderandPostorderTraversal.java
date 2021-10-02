package LeetCode.BinaryTree;
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
public class NO106ConstructBinaryTreefromnorderandPostorderTraversal {
    static int in = 0;
    static int post = 0;
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
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    //数组区间左闭右开
    public static TreeNode buildTree1(int[] inorder, int inLeft, int inRight,
                                      int[] postorder, int postLeft, int postRight) {
       if(inRight-inLeft<1)return null;
       if(inRight-inLeft==1){
           return  new TreeNode(inorder[inLeft]);
       }
       int val=postorder[postRight-1];
       TreeNode root=new TreeNode(val);
       int index=0;
       for(int i=inLeft;i<inRight;++i){
           if(inorder[i]==val){
               index=i;
               break;
           }
       }
       root.left=buildTree1(inorder,inLeft,index,postorder,postLeft,postLeft+(index-inLeft));
       root.right=buildTree1(inorder,index+1,inRight,postorder,postLeft+(index-inLeft),postRight-1);
       return  root;
    }
    private static TreeNode buildTree(int[] inorder, int[] postorder, int stop) {
        if (post < 0) {
            return null;
        }
        if (inorder[in] == stop) {
            in--;
            return null;
        }
        int value = postorder[post--];
        TreeNode root = new TreeNode(value);
        root.right = buildTree(inorder, postorder, value);
        root.left = buildTree(inorder, postorder, stop);
        return root;
    }

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = inorder.length - 1;
        return buildTree(inorder, postorder, Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        int[] inorder={9,3,15,20,7};
        int[]postorder={9,15,7,20,3};
        TreeNode root=buildTree2(inorder,postorder);

    }
}
