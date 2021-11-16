package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class NO129 {
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }



    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode r1=new TreeNode(2);
        TreeNode r2=new TreeNode(3);
        root.left=r1;
        root.right=r2;
        System.out.println();
        System.out.println(sumNumbers(root));
    }
}
