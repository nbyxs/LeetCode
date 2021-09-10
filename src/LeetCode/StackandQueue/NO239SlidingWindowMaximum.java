package LeetCode.StackandQueue;
/*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。
示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-maximum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO239SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n=nums.length;
        int[] res=new int[n-k+1];
        int[] q=new int[n];
        int hh=0;
        int index=0;
        int tt=-1;
        for(int i=0;i<n;++i){

            if(hh<=tt&&q[hh]<i-k+1)++hh;
            while (hh<=tt&&nums[q[tt]]<=nums[i])--tt;
            q[++tt]=i;
            if(i>=k-1)res[index++]=nums[q[hh]];
        }return res;
    }

    public static void main(String[] args) {
        int[] a={1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] res=maxSlidingWindow(a,k);
        for(int n:res) System.out.print(n);
    }
}
