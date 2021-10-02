package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedDemo {
    static Queue<Integer> queue1=null;
    int l=0;

    public SynchronizedDemo() {

        queue1=new LinkedList<>();
         l=0;
    }

    /** Push element x onto stack.
     * 入栈操作时，首先获得入栈前的元素个数 nnn，然后将元素入队到队列，再将队列中的前 nnn 个元素（即除了新入栈的元素之外的全部元素）依次出队并入队到队列，此时队列的前端的元素即为新入栈的元素，且队列的前端和后端分别对应栈顶和栈底。
     *
     */
    public void push(int x) {

        queue1.offer(x);
        int t=l;
        while (t>0){
            --t;
            queue1.offer(queue1.poll());
        }
        ++l;



    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        return queue1.poll();

    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return queue1.isEmpty();
    }


    public static void main(String[] args) {
        SynchronizedDemo myStack = new SynchronizedDemo();
        myStack.push(1);
        myStack.push(2);
        System.out.println( myStack.top()+" "+myStack.pop()+" "+myStack.empty()); // 返回 2
        // 返回 2
        // 返回 False


    }
}

