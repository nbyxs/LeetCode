package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。
示例 1：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO113PathSumII {
   static List<List<Integer>> res=new ArrayList<>();
   static List<Integer> list=new ArrayList<>();
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

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)return res;
        search(root,targetSum);
        return res;
    }

    private static void search(TreeNode root, int targetSum) {
        if(root==null)return;
        targetSum-=root.val;
        list.add(root.val);

        if(root.left==null&&root.right==null&&targetSum==0){
           res.add(new ArrayList<>(list));
        }
        search(root.left,targetSum);
        search(root.right,targetSum);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(8);
        TreeNode t4=new TreeNode(11);
        TreeNode t5=new TreeNode(13);
        TreeNode t6=new TreeNode(4);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(2);
        TreeNode t9=new TreeNode(5);
        TreeNode t10=new TreeNode(1);

        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t3.left=t5;
        t3.right=t6;
        t4.left=t7;
        t4.right=t8;
        t6.left=t9;
        t6.right=t10;
        List<List<Integer>> res=pathSum(t1,22);
        for(List<Integer>list:res) System.out.println(list.toString());
    }
}
