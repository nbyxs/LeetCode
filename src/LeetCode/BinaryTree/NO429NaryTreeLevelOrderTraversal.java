package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：[[1],[3,2,4],[5,6]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO429NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res=new ArrayList<>();
        bfs(res,root);
        return res;
    }

    private void bfs(List<List<Integer>> res, Node root) {
        if(root==null)return;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int len=queue.size();
            while (len>0){
                root=queue.poll();
                list.add(root.val);
                for(Node t:root.children)if(t!=null)queue.offer(t);
                --len;
            }res.add(new ArrayList<>(list));
        }

    }
}
