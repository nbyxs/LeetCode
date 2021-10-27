package LeetCode.LinkedList;

public class NO92 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode dy=new ListNode(-1);
       dy.next=head;
       if(right==left)return head;
       ListNode pre=dy;
       for(int i=0;i<left-1;++i)pre=pre.next;
       ListNode cur=pre.next;
       ListNode next;
       for(int i=0;i<right-left;++i){
           next=cur.next;
           cur.next=next.next;
           next.next=pre.next;
           pre.next=next;
       }
return dy.next;
    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
       // ListNode l6=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
       // l5.next=l6;
        ListNode l7=l1;
        while(l1!=null){
            System.out.print(l1.val+" ");
            l1=l1.next;
        }
       System.out.println('\n'+"+++++++++++++++++++++++++++");
//      l1.next=l2.next;
//      l2.next=l1;
//        while(l2!=null){
//            System.out.println(l2.val);
//            l2=l2.next;
//        }
        ListNode head=reverseBetween(l7,2,4);
        System.out.println("++++++++++++++++++");
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}
