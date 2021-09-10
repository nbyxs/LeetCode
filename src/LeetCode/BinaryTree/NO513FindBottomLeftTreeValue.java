package LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
假设二叉树中至少有一个节点。
示例 1:
输入: root = [2,1,3]
输出: 1
    2
   / \
  1   3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO513FindBottomLeftTreeValue {
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

    public static int findBottomLeftValue(TreeNode root) {

        int res=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            res=queue.peek().val;
            for(int i=0;i<len;++i){
                root=queue.poll();

                if(root.left!=null)queue.offer(root.left);
                if(root.right!=null)queue.offer(root.right);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(5);
        t1.left=t2;
        t2.right=t4;
        t1.right=t3;
        System.out.println(findBottomLeftValue(t1));
    }
}
