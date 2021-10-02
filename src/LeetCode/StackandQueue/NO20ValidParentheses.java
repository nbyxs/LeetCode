package LeetCode.StackandQueue;

import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
示例 1：
输入：s = "()"
输出：true
示例 2：
输入：s = "()[]{}"
输出：true
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO20ValidParentheses {
    public static boolean isValid(String s) {
        if((s.length()&1)==1)return false;
        Stack<Character> list=new Stack<>();
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
           if(!list.isEmpty()){
               if(ch==')'&&list.peek()=='('){
                   list.pop();
                   continue;
               }
               if(ch=='}'&&list.peek()=='{'){
                   list.pop();
                   continue;
               }
               if(ch==']'&&list.peek()=='['){
                   list.pop();
                   continue;
               }
           }
           list.push(ch);
            //System.out.println(list.peek());
        }
        return list.isEmpty();
    }
    public static boolean isValid_review(String s){
        char[] c=s.toCharArray();
        int n=c.length;
        if((n&1)==1)return false;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;++i){
            if(!stack.isEmpty()){
                char t=stack.peek();
                if((c[i]==')'&&t=='(')||(c[i]=='}'&&t=='{')||(c[i]==']'&&t=='['))stack.pop();
                else  stack.push(c[i]);
            }
            else  stack.push(c[i]);
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String a="({[)";
        System.out.println(3&1);
        System.out.println(isValid_review(a));
    }
}
