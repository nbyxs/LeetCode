package LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class NO116PopulatingNextRightPointersinEachNode {
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
    //方法1
    public Node connect(Node root) {
        Node root1 = root;
          if(root==null)return null;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            while (len>1){
                root=queue.poll();
                root.next=queue.peek();
                if(root.left!=null)queue.offer(root.left);
                if(root.right!=null)queue.offer(root.right);
                --len;
            }//将每层最后一个结点的左右子树加入队列
            root=queue.poll();
            root.next=null;
            if(root.left!=null)queue.offer(root.left);
            if(root.right!=null)queue.offer(root.right);
        }return root1;
    }
    //方法2
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点，题目要求是完美二叉树
            leftmost = leftmost.left;
        }

        return root;
    }


}
