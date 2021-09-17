package LeetCode.MonotoneStack;

import java.util.Stack;

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO42TrappingRainWater {
    public  static int trap_dp(int[] height) {

        int n=height.length;
        if(n<=2)return 0;
        int[] left_max=new  int[n];
        int[] right_max=new int[n];
        left_max[0]=height[0];
        for(int i=1;i<n;++i){
            left_max[i]=Math.max(left_max[i-1],height[i]);
        }
        right_max[n-1]=height[n-1];
        for(int i=n-2;i>=0;--i)right_max[i]=Math.max(right_max[i+1],height[i]);
        int area=0;
        for(int i=0;i<n;++i){
            int a=Math.min(left_max[i],right_max[i])-height[i];
            if(a>0)area+=a;

        }
        return area;
    }
    //添加的柱子高度大于栈头元素了，此时就出现凹槽了，栈头元素就是凹槽底部的柱子，
    // 栈头第二个元素就是凹槽左边的柱子，而添加的元素就是凹槽右边的柱子。
    public  static int trap_ms(int[] height){
        int n=height.length;
        if(n<=2)return 0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int area=0;
        for(int i=1;i<n;++i){

            if(height[i]<height[stack.peek()])stack.push(i);
            else if(height[i]==height[stack.peek()]){
                stack.pop();stack.push(i);
            }
            else {
                while (!stack.empty() && height[i] > height[stack.peek()]) { // 注意这里是while，持续跟新栈顶元素
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.empty()) {
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        int w = i - stack.peek() - 1; // 注意减一，只求中间宽度
                        area += h * w;
                    }
            }
                stack.push(i);
        }

    }
        return area;
    }
    public  static int trap_double_point(int[] height){
        int l=0;
        int r=height.length-1;
        if(r<=1)return 0;
        int area=0;
        int leftMax=height[0];
        int rightMax=height[r];
        while (l<r){
            leftMax=Math.max(leftMax,height[l]);
            rightMax=Math.max(rightMax,height[r]);
            if(height[l]<height[r]){
                area+=leftMax-height[l];
                ++l;
            }
            else {
                area+=rightMax-height[r];
                --r;
            }
        }
        return area;
    }
    public static void main(String[] args) {
        int[] a={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap_dp(a));
        System.out.println(trap_ms(a));
        System.out.println(trap_double_point(a));
    }
}
