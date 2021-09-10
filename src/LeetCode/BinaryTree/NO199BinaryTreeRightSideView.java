package LeetCode.BinaryTree;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例 1:
     1
   /   \
  2     3
   \     \
   5      4
输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO199BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
          int len=queue.size();
          while (len>0){
              root=queue.poll();
              if(root.left!=null)queue.offer(root.left);
              if(root.right!=null)queue.offer(root.right);
              --len;
          }list.add(root.val);//遍历每层添加最后一个元素

        }return list;
    }
}
