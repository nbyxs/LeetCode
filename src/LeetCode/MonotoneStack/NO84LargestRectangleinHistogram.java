package LeetCode.MonotoneStack;
/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
示例 1:
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
 */
//找左右第一个小于的位置
//找到左右两侧最近的高度小于 h 的柱子，
// 这样这两根柱子之间（不包括其本身）的所有柱子高度均不小于 h，并且就是 i 能够扩展到的最远范围。
public class NO84LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        if(n<=1)return heights[0];
        if(n==2)return Math.min(heights[0],heights[1])*2;
        int[] left_min_max=new int[n];
        left_min_max[0]=-1;
        int[] right_min_max=new  int[n];
        right_min_max[n-1]=n;
        for(int i=1;i<n;++i){
           int t=i-1;
           while (t>=0&&heights[t]>heights[i])t=left_min_max[t];
           left_min_max[i]=t;
        }
        for(int i=n-2;i>=0;--i){
           int t=i+1;
           while (t<n&&heights[t]>heights[i])t=right_min_max[t];
           right_min_max[i]=t;
        }
//        for(int i=0;i<n;++i) System.out.print(heights[left_min_max[i]]+" ");
//        System.out.println();
//        for(int i=0;i<n;++i) System.out.print(heights[right_min_max[i]]+" ");
//        System.out.println();
        int area=0;
        for(int i=0;i<n;++i){
            int sum = heights[i] * (right_min_max[i] -left_min_max[i] - 1);
            area= Math.max(sum, area);
        }
        return area;

    }

    public static void main(String[] args) {
        int[] a={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(a));
    }

}
