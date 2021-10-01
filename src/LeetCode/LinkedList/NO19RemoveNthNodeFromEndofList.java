package LeetCode.LinkedList;

public class NO19RemoveNthNodeFromEndofList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1=head;
        ListNode l2=new ListNode(0,head);
        ListNode temp=l2;
        while(n!=0){
            l1=l1.next;
            --n;
        }
        while(l1!=null){
            l1=l1.next;
            l2=l2.next;
        }
        l2.next=l2.next.next;
        return temp.next;


    }
    public static ListNode removeNthFromEnd_review(ListNode head, int n){
        if(head==null)return null;

        ListNode t=new ListNode(0,head);
        ListNode temp=t;
        while (n>0){
            head=head.next;
            --n;
        }
        while (head!=null){
            head=head.next;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return t.next;

    }
    public static void main(String[] args) {
        ListNode t1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(4);
        t1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        ListNode head1=removeNthFromEnd_review(t1,1);
        while(head1!=null){
            System.out.println(head1.val);
            head1=head1.next;
        }
    }
}
