package LeetCode.DP;
/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组(连续）的长度。
示例：
输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO718MaximumLengthofRepeatedSubarray {
    public static int findLength(int[] A, int[] B) {

        int n=A.length;
        int m=B.length;
        if(n==0||m==0)return 0;
        int[][] dp=new int[n+1][m+1];
        dp[0][0]=0;
        int ans=0;
        //理解为何倒序遍历 令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值。如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
        //考虑到这里 dp[i][j] 的值从 dp[i + 1][j + 1] 转移得到，
        // 所以我们需要倒过来，首先计算 dp[len(A) - 1][len(B) - 1]，最后计算 dp[0][0]。

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        int[] a={0,1,1,1,1};
        int[] b={1,0,1,0,1};
        System.out.println(findLength(a,b));
    }
}
