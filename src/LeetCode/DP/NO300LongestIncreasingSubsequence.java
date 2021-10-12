package LeetCode.DP;

import java.util.Arrays;

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO300LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {

        int n=nums.length;

        int[] dp=new int[n+1];
        for(int i=0;i<=n;++i)dp[i]=1;
        for(int i=1;i<=n;++i){
            for(int j=1;j<=i-1;++j){
                if(nums[i-1]>nums[j-1]){
                    //System.out.println(nums[i-1]+"  "+nums[j]+"  "+dp[i]+"  "+dp[j]+" ");
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
//            for(int k=1;k<=n;++k) System.out.print(dp[k]+" ");
//            System.out.println();
        }
        for(int i=1;i<=n;++i)dp[0]=Math.max(dp[0],dp[i]);

        return dp[0];
    }
    public static int lengthOfLIS_review(int[] nums){
        int n=nums.length;
        if(n==1)return 1;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                if(nums[i]>nums[j])dp[i]=Math.max(dp[i],dp[j]+1);

            }
        }
        int m=0;
        for(int i=0;i<n;++i)m=Math.max(m,dp[i]);
        return m;
    }
    public static void main(String[] args) {
        int[] a={10,9,2,5,37,101,18};
        System.out.println(lengthOfLIS(a));
        System.out.println(lengthOfLIS_review(a));
    }
}
