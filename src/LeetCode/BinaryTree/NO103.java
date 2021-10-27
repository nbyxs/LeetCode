package LeetCode.BinaryTree;

import java.util.*;

public class NO103 {
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
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)return res;
        search(root);
        return res;
    }

    private void search(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean flag=false;
        while(!queue.isEmpty()){
            root=queue.peek();
            int length=queue.size();
            while (length>0){
                root=queue.poll();
                list.add(root.val);
                    if(root.left!=null)queue.offer(root.left);
                    if(root.right!=null)queue.offer(root.right);
                    --length;
            }
            flag=!flag;
            if(flag) Collections.reverse(list);
            res.add(new ArrayList<>(list));
            list.clear();
        }
    }


}
