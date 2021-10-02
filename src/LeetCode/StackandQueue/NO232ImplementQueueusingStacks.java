package LeetCode.StackandQueue;

import java.util.Stack;

/*
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：
    void push(int x) 将元素 x 推到队列的末尾
    int pop() 从队列的开头移除并返回元素
    int peek() 返回队列开头的元素
    boolean empty() 如果队列为空，返回 true ；否则，返回 false
说明：
    你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO232ImplementQueueusingStacks {
   private static Stack<Integer> stack1=null;
   private static Stack<Integer> stack2=null;
    private NO232ImplementQueueusingStacks() {

         stack1=new Stack<>();
         stack2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    private static  void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
        move();
        return stack2.pop();

    }

    /** Get the front element. */
    public int peek() {

        move();
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    private boolean empty() {

        return (stack1.isEmpty() && stack2.isEmpty());
    }
    //若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
    private void move(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        NO232ImplementQueueusingStacks myQueue=new NO232ImplementQueueusingStacks();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()+" "+myQueue.pop()+" "+myQueue.empty()+" "+myQueue.peek()); // return 1
         // return 1, queue is [2]
         // return false


    }
}
