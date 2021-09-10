package LeetCode.LinkedList;
/*
给你两个单链表的头节点 headA 和 headB ，
请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class NO0207ListIntersection {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode t1=headA;ListNode t2=headB;
        while(headA!=null&&headB!=null){
            headA=headA.next;headB=headB.next;
        }
        while(headA!=null){
            t1=t1.next;headA=headA.next;
        }
        while(headB!=null){
            t2=t2.next;headB=headB.next;
        }
        while(t1!=null&&t2!=null){
            if(t1==t2)return  t1;//力扣是可以ac idea上要写if(t1.val==t2.val)
            t1=t1.next;t2=t2.next;
        }
        return null;
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
        ListNode t1=new ListNode(2);
        ListNode t2=new ListNode(2);
        ListNode t3=new ListNode(4);
        ListNode t4=new ListNode(1);
        ListNode t5=new ListNode(3);
        ListNode t6=new ListNode(4);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        t5.next=t6;
        ListNode head1=getIntersectionNode(l1,t1);
        while(head1!=null){
            System.out.println(head1.val);
            head1=head1.next;
        }
    }
}
