package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
提醒一下，二叉搜索树满足下列约束条件：
    节点的左子树仅包含键 小于 节点键的节点。
    节点的右子树仅包含键 大于 节点键的节点。
    左右子树也必须是二叉搜索树。
注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
示例 1：
输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO538ConvertBSTtoGreaterTree {
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


    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(4);
        TreeNode t2=new TreeNode(1);

        TreeNode t3=new TreeNode(6);

        TreeNode t4=new TreeNode(0);

        TreeNode t5=new TreeNode(2);
        TreeNode t6=new TreeNode(5);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(3);
        TreeNode t9=new TreeNode(8);
       t1.left=t2;
       t1.right=t3;
       t2.left=t4;
       t2.right=t5;
       t3.left=t6;
       t3.right=t7;
       t5.right=t8;
       t7.right=t9;
      // List<Integer> list=convertBST(t1);
        //System.out.println(list.toString());

        System.out.println(t1.val);
    }
}
