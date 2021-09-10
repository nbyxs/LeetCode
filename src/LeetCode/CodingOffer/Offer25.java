package LeetCode.CodingOffer;
//合并两个有序链表
public class Offer25 {
    public static class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

     public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode temp=new ListNode(0);
       ListNode head=temp;
       while(l1!=null&&l2!=null){
           if(l1.val<l2.val){
               temp.next=l1;
               l1=l1.next;
           }
           else {
               temp.next=l2;
               l2=l2.next;
           }
           temp=temp.next;
       }
       temp.next=(l1==null?l2:l1);
       return head.next;

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
l3.next=null;
l4.next=l5;
l5.next=l6;
l6.next=null;
ListNode head=mergeTwoLists(l1,l4);
while(head!=null){
    System.out.println(head.val);
    head=head.next;
}
    }

}
