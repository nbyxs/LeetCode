package NOWCODER;

import java.util.*;



public class NC70Solution {
    /*
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */

       class ListNode {
        int val;
        ListNode next = null;
      }

    public ListNode sortInList (ListNode head) {
        // write code here
        if(head==null||head.next==null)
        return  head;
        ArrayList<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        list.sort((a,b)->{return  a-b;});
        ListNode t=head;
        int i=0;
        while(t!=null){
            t.val=list.get(i++);
            t=t.next;
        }
        return  head;

    }
}
