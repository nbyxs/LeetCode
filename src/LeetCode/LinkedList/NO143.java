package LeetCode.LinkedList;

public class NO143 {
    public void reorderList(ListNode head) {
        ListNode l1=head;
        ListNode mid=midNode(head);
        ListNode l2=mid.next;
        mid.next=null;
        l2=reversNode(l2);
        mergerNode(l1,l2);
    }

    private void mergerNode(ListNode l1, ListNode l2) {
        ListNode l1_;
        ListNode l2_;
        while (l1!=null&&l2!=null){
            l1_=l1.next;
            l2_=l2.next;
            l1.next=l2;
            l1=l1_;
            l2.next=l1;
            l2=l2_;

        }
    }

    private ListNode reversNode(ListNode l2) {
        ListNode t=null;
        ListNode temp=l2;
        while (temp!=null){
            l2=l2.next;
            temp.next=t;
            t=temp;
            temp=l2;
        }
        return t;
    }

    private ListNode midNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
