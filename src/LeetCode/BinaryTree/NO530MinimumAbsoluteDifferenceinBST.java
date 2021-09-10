package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
示例：
输入：
   1
    \
     3
    /
   2
输出：
1
解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO530MinimumAbsoluteDifferenceinBST {
     TreeNode pre;
     int result=Integer.MAX_VALUE;
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
    public int getMinimumDifference(TreeNode root) {

       num(root);
        return result;
    }

    private void num(TreeNode root) {
        if (root==null)return ;
        num(root.left);
        if(pre!=null){
            result=Math.min(result,root.val-pre.val);
        }
        pre=root;
        num(root.right);

    }
}
