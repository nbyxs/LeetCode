package LeetCode.LinkedList;

public class NO82 {
    public  static ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;


    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(1);
        ListNode l4=new ListNode(3);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        ListNode l7=l1;

        ListNode head=deleteDuplicates(l1);
        System.out.println("++++++++++++++++++");
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
