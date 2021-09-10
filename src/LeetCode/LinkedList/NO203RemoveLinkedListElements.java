package LeetCode.LinkedList;
/*
给你一个链表的头节点 head 和一个整数 val ，
请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 */
public class NO203RemoveLinkedListElements {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static  ListNode removeElements(ListNode head, int val) {
       ListNode dyhead=new ListNode(0);
       dyhead.next=head;
       ListNode temp=dyhead;
       while(temp.next!=null){
           if(temp.next.val==val){
               temp.next=temp.next.next;
           }
           else temp=temp.next;
       }
       return dyhead.next;

    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        ListNode l7=l1;

        ListNode head=removeElements(l7,4);
        System.out.println("++++++++++++++++++");
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
