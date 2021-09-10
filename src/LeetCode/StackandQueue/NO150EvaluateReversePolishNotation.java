package LeetCode.StackandQueue;

import java.util.Stack;

import static com.alibaba.druid.util.StringUtils.isNumber;


/*
根据 逆波兰表示法，求表达式的值。
有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
说明：
    整数除法只保留整数部分。
    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：
输入：tokens = ["2","1","+","3","*"]
输出：9
解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO150EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {

        Stack<Integer> list_number =new Stack<>();

        for(String s:tokens){
           if(isNumber(s)){
               list_number.add(Integer.parseInt(s));
            }
          else {
               int num2 = list_number.pop();
               int num1 = list_number.pop();
               switch (s) {
                   case "+":
                       list_number.push(num1 + num2);
                       break;
                   case "-":
                       list_number.push(num1 - num2);
                       break;
                   case "*":
                       list_number.push(num1 * num2);
                       break;
                   case "/":
                       list_number.push(num1 / num2);
                       break;
                   default:
               }
           }


        }
        return list_number.pop();
    }

    public static void main(String[] args) {
        String[] list={"2","1","+","3","*"};
        System.out.println( evalRPN(list));
    }
}
