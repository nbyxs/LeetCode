package LeetCode.DP;
/*
给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
题目数据保证答案符合 32 位带符号整数范围。
例 1：
输入：s = "rabbbit", t = "rabbit"
输出：3
解释：
如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
rabbbit
rabbbit
rabbbit
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distinct-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO115DistinctSubsequences {
    public static int numDistinct(String s, String t) {

        int n=s.length();
        int m=t.length();
        if(m>n)return 0;
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }
        for(int i=n-1;i>=0;--i){
            for(int j=m-1;j>=0;--j){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j]=dp[i+1][j]+dp[i+1][j+1];
                }else dp[i][j]=dp[i+1][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String a="rabbbit";
        String b="rabbit";
        System.out.println(numDistinct(a,b));
    }
}
