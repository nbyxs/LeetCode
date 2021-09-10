package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
叶子节点 是指没有子节点的节点。
示例 1：
输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO257BinaryTreePaths {
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
    public  static List<String> binaryTreePaths(TreeNode root) {

        List<String>  list=new ArrayList<>();
        if(root==null)return list;
      StringBuffer path=new StringBuffer();
        inorder(list,root,path);
        return list;
    }

    private static void inorder(List<String> list, TreeNode root, StringBuffer path) {
      if(root==null)return;
      if(root.left==null&&root.right==null){
          list.add(path.toString()+root.val);
          System.out.println(list.get(list.size()-1));
          return;
      }
      int len=path.length();
      path.append(root.val).append("->");
      inorder(list,root.left,path);
      inorder(list,root.right,path);
      path.delete(len,path.length());
        }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(5);
        t1.left=t2;
        t2.right=t4;
        t1.right=t3;
        binaryTreePaths(t1);
    }
}
