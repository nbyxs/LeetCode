package LeetCode.MonotoneStack;

import java.util.Stack;

/*
请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
示例 1:
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:
输入: temperatures = [30,60,90]
输出: [1,1,0]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO739DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        if(n==1)return new int[]{0};
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[n];

        stack.push(0);
        for(int i=1;i<n;++i){
            //if(temperatures[i]>temperatures[stack.peek()]){
               while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                   int index=stack.pop();
                   res[index]=i-index;
               }
               stack.push(i);
       // }
           // else if(temperatures[i]<=temperatures[stack.peek()])stack.push(i);

        }
//        while (!stack.isEmpty()){
//            res[stack.pop()]=0;
//        }
        //数组默认值为0；
        return res;

    }

    public static void main(String[] args) {
        int[] a={30,40,50,60};
      int[] res=dailyTemperatures(a);
      for(int i=0;i<res.length;++i) System.out.print(res[i]+" ");
    }
}
