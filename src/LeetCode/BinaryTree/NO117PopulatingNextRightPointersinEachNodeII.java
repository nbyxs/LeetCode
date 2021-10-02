package LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO117PopulatingNextRightPointersinEachNodeII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root)  {
        if (root==null)return null;
    Node t=root;
    Queue<Node> queue=new LinkedList<>();
        queue.offer(t);
        while (!queue.isEmpty()){
        int length=queue.size();
        while (length>1){
            t=queue.poll();
            t.next= queue.peek();

            if(t.left!=null)queue.offer(t.left);
            if(t.right!=null)queue.offer(t.right);
            --length;
        }t=queue.poll();
        if(t.left!=null)queue.offer(t.left);
        if(t.right!=null)queue.offer(t.right);
    }return root;
    }
}
