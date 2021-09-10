package LeetCode.Array;

/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器。

 输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class  NO11ContainerWithMostWater {
    public static int maxArea(int[] height) {
/*
双指针，每次移动数值较小的指针
 */

        int l=0;
        int r=height.length-1;
        int res=0;
        while(l<=r){
            res=Math.max(res,(r-l)*Math.min(height[l],height[r]));
            if(height[l]>height[r])--r;
            else ++l;
        }
        return  res;

    }
    public static int maxArea1(int[] height){
        int res=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
            if(height[l]<height[r]){
                res=Math.max(res,height[l]*(r-l));
                ++l;
            }
            else {
                res=Math.max(res,height[r]*(r-l));
                --r;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
        System.out.println(maxArea1(a));
    }
}
