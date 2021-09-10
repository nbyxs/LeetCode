package LeetCode.LinkedList;
/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
假设链表为 1→2→3→∅，我们想要把它改成 ∅←1←2←3
 */
public class NO206ReverseLinkedList {

      public static class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode reverseList(ListNode head) {
ListNode pre=null;
ListNode temp=head;
while(temp!=null){
    ListNode t=temp.next;
    temp.next=pre;
    pre=temp;
    temp=t;
}
return pre;
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
//        while(l1!=null){
//            System.out.println(l1.val);
//            l1=l1.next;
//        }
        System.out.println("+++++++++++++++++++++++++++");
      l1.next=l2.next;
      l2.next=l1;
        while(l2!=null){
            System.out.println(l2.val);
            l2=l2.next;
        }
     //   ListNode head=reverseList(l1);
        System.out.println("++++++++++++++++++");
//        while(head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }
    }
}
